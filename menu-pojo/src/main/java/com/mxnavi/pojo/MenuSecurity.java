package com.mxnavi.pojo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ȩ����֤ע�⣬���Լ�����򷽷���
 * �����ϵ�����
 * Ĭ��ֵ�Ǹ÷��������˶����Է���
 */

//��ͷ�������Ч
@Target({ElementType.METHOD,ElementType.TYPE})

//����ʱ��Ч
@Retention(RetentionPolicy.RUNTIME)

//��javadoc�ĵ���ʹ�ã��������Ҫ��
@Documented

public @interface MenuSecurity {
	
	int [] value() default {};
	
}


