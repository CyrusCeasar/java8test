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
		 * ��һ��task���ϱ�ת����Ϊ����Ӧ��stream��ʾ�� Ȼ��filter�������˵�״̬ΪCLOSED��task��
		 * ��һ����mapToInt����ͨ��Task::
		 * getPoints���ַ�ʽ����ÿ��taskʵ����getPoints������Task��streamת��ΪInteger��stream��
		 * �����sum���������еķ������������õ����յĽ����
		 */
		System.out.println("Total points: " + totalPointsOfOpenTasks);

		// Calculate total points of all tasks
		final double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()) // or
				.reduce(0, Integer::sum);
		/*
		 * ��������ǲ������еģ� ���ʹ��reduce�����������յĽ����
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