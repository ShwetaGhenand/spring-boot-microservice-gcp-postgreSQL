package com.example.identityservice.dao;

public interface DtoToEntityConveter<T,E> {

	void dtoToEntityConvert(final T dto, E entity);
}
