package com.google.common.reflect;

import com.google.common.collect.ImmutableSet.Builder;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

class TypeToken$4
  extends TypeVisitor
{
  TypeToken$4(TypeToken paramTypeToken, ImmutableSet.Builder paramBuilder) {}
  
  void visitClass(Class<?> paramClass)
  {
    this.val$builder.add(paramClass);
  }
  
  void visitGenericArrayType(GenericArrayType paramGenericArrayType)
  {
    this.val$builder.add(Types.getArrayClass(TypeToken.of(paramGenericArrayType.getGenericComponentType()).getRawType()));
  }
  
  void visitParameterizedType(ParameterizedType paramParameterizedType)
  {
    this.val$builder.add((Class)paramParameterizedType.getRawType());
  }
  
  void visitTypeVariable(TypeVariable<?> paramTypeVariable)
  {
    visit(paramTypeVariable.getBounds());
  }
  
  void visitWildcardType(WildcardType paramWildcardType)
  {
    visit(paramWildcardType.getUpperBounds());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToken.4
 * JD-Core Version:    0.7.0.1
 */