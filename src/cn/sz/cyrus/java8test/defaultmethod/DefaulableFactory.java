package cn.sz.cyrus.java8test.defaultmethod;

import java.util.function.Supplier;

public interface DefaulableFactory {
	static Defaulable create(Supplier<Defaulable> supplier){
		return supplier.get();
	}

}
