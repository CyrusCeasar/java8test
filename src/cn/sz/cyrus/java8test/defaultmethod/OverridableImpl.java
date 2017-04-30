package cn.sz.cyrus.java8test.defaultmethod;

public class OverridableImpl implements Defaulable{

	@Override
	public String notRequired() {
		return "Overridden implmentation";
	}
}
