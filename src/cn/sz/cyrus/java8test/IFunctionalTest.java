package cn.sz.cyrus.java8test;

@FunctionalInterface
public interface IFunctionalTest {
	void method(String msg);
	default void defaultMethod(){
		System.out.println("defaultMethod ivoked");
	}

}
