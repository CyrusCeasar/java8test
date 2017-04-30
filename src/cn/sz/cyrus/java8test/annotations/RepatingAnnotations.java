package cn.sz.cyrus.java8test.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;


public class RepatingAnnotations {
	@Target (ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters{
		Filter[] value();
	}
	
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter{
		String value();
	}
	
	@Filter("filter1")
	@Filter("filter2")
	public interface Filterable{
	}
	
	public static void main(String[] args) {
		Arrays.asList(Filterable.class.getAnnotationsByType(Filter.class)).forEach(filter->System.out.println(filter.value()));
	}

}
