package cn.sz.cyrus.java8test.defaultmethod;

public  interface Defaulable {
	default String notRequired(){
		return "Default implementation";
	}

}
