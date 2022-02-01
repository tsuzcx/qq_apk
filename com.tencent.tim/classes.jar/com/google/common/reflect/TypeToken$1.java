package com.google.common.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

class TypeToken$1
  extends Invokable.MethodInvokable<T>
{
  TypeToken$1(TypeToken paramTypeToken, Method paramMethod)
  {
    super(paramMethod);
  }
  
  Type[] getGenericExceptionTypes()
  {
    return TypeToken.access$000(this.this$0, super.getGenericExceptionTypes());
  }
  
  Type[] getGenericParameterTypes()
  {
    return TypeToken.access$000(this.this$0, super.getGenericParameterTypes());
  }
  
  Type getGenericReturnType()
  {
    return this.this$0.resolveType(super.getGenericReturnType()).getType();
  }
  
  public TypeToken<T> getOwnerType()
  {
    return this.this$0;
  }
  
  public String toString()
  {
    return getOwnerType() + "." + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken.1
 * JD-Core Version:    0.7.0.1
 */