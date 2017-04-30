package cn.sz.cyrus.java8test.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
	private enum Status {
		OPEN, CLOSED
	};

	private static final class Task {
		private final Status status;
		private final Integer points;

		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}

	public static void main(String[] args) {
		List<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8));
		final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();
		/*
		 * 第一，task集合被转换化为其相应的stream表示。 然后，filter操作过滤掉状态为CLOSED的task。
		 * 下一步，mapToInt操作通过Task::
		 * getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream。
		 * 最后，用sum函数把所有的分数加起来，得到最终的结果。
		 */
		System.out.println("Total points: " + totalPointsOfOpenTasks);

		// Calculate total points of all tasks
		final double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()) // or
				.reduce(0, Integer::sum);
		/*
		 * 这个例子是并行运行的， 其次使用reduce方法来算最终的结果。
		 */

		System.out.println("Total points (all tasks): " + totalPoints);

		// Group tasks by their status
		final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);

		// Calculate the weight of each tasks (as percent of total points)
		final Collection<String> result = tasks.stream() // Stream< String >
				.mapToInt(Task::getPoints) // IntStream
				.asLongStream() // LongStream
				.mapToDouble(points -> points / totalPoints) // DoubleStream
				.boxed() // Stream< Double >
				.mapToLong(weigth -> (long) (weigth * 100)) // LongStream
				.mapToObj(percentage -> percentage + "%") // Stream< String>
				.collect(Collectors.toList()); // List< String >

		System.out.println(result);
	}
}