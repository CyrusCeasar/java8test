package cn.sz.cyrus.java8test.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

	
	 void test1(){
		Arrays.asList("c","a","b","d").forEach(e->System.out.print(e));
		System.out.println();
		Arrays.asList("c","a","b","d").forEach((String e)->System.out.print(e)); 
		System.out.println();
		Arrays.asList("c","a","b","d").forEach( e->{
			System.out.print(e);
			System.out.print(e);
		}); 
	}
	 void test2(){
		 Runnable runnable = ()->{System.out.println("haha");};
			new Thread(()->System.out.println("hjaha")).start();
	 }
	
	public static void main(String[] args){
		List<People> peoples = new LinkedList<>();
		String[] names = {"wangermazi","lisi","zhangsan"};
		Arrays.asList(names).forEach(name->peoples.add(new People(name)));
	//	peoples.sort(Comparator.comparing(People::getName));
		
		System.out.println("print all people");
		peoples.sort(Comparator.comparing(People::getName).reversed());
		peoples.forEach(people->System.out.println(people.getName()));
		Consumer<String> consumer = content->System.out.println(content);
		
		
		System.out.println("get lisi's age");
		peoples.stream().filter(p->p.getName().equals("lisi")).map(People::getAge).forEach(age->System.out.println( "lisi age:"+age));;
		
		System.out.println("remove lisi and print all people");
		peoples.removeIf(p->p.getName().equals("lisi"));
		peoples.forEach(people->System.out.println(people.getName()));
	}
	
}
