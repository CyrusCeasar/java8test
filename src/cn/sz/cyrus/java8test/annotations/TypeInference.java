package cn.sz.cyrus.java8test.annotations;

import cn.sz.cyrus.java8test.Value;

public class TypeInference {
	public static void main(String[] args) {
		final Value<String> value = new Value<>();
		value.getOrDefault("22",Value.defaultValue());
/*		Value.defaultValue()�Ĳ������Ϳ��Ա��Ʋ�������ԾͲ�����ȷ������
		��Java 7�У���ͬ�����ӽ�����ͨ�����룬��ȷ����д��ʽ�� Value.< String >defaultValue()��*/
	}
}
