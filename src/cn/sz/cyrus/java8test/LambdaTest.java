package cn.sz.cyrus.java8test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

	static class FunctionTest{
		public FunctionTest(IFunctionalTest iFunctionalTest) {
			this.iFunctionalTest = iFunctionalTest;
		}
		
		IFunctionalTest iFunctionalTest;
	}
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
		peoples.sort(Comparator.comparing(People::getName).reversed());
		peoples.forEach(people->System.out.print(people.getName()));
		Consumer<String> consumer = content->System.out.println(content);
	}
	
}
