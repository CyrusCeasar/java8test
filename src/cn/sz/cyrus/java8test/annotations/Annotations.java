package cn.sz.cyrus.java8test.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

public class Annotations {
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE_USE,ElementType.TYPE_PARAMETER})
	public @interface NonEmpty{
		
	}
	
	public static class Holder<@NonEmpty T> extends @NonEmpty Object{
		final Holder<String> holder = new @NonEmpty Holder<>();
		@NonEmpty Collection<@NonEmpty String> strings = new ArrayList<>();
	/*	ElementType.TYPE_USE和ElementType.TYPE_PARAMETER是两个新添加的用于描述适当的注解上下文的元素类型。
		在Java语言中，注解处理API也有小的改动来识别新增的类型注解*/
	}

}
