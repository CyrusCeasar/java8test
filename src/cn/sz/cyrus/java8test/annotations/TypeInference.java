package cn.sz.cyrus.java8test.annotations;

import cn.sz.cyrus.java8test.Value;

public class TypeInference {
	public static void main(String[] args) {
		final Value<String> value = new Value<>();
		value.getOrDefault("22",Value.defaultValue());
/*		Value.defaultValue()的参数类型可以被推测出，所以就不必明确给出。
		在Java 7中，相同的例子将不会通过编译，正确的书写方式是 Value.< String >defaultValue()。*/
	}
}
