package com.quiz.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.data.domain.Page;

import com.google.common.reflect.TypeToken;
import com.quiz.model.Pergunta;

public class UtilsGetType<T> {
	
	private Class<T> persistentClass;

	private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
	};

	private final Type type = typeToken.getType(); // or getRawType() to return Class<? super T>

	public Type getType() {
		return type;
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	

	public static void main(String[] args) {
		UtilsGetType<Pergunta> example = new UtilsGetType<Pergunta>() {
		};
		System.out.println(example.getGenericClass());
//		System.out.println(((ParameterizedType)example.getClass().getGenericSuperclass()).getActualTypeArguments()[0]); // => class java.lang.String
		
	}
}
