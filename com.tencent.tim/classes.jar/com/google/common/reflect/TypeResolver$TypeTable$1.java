package com.google.common.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

class TypeResolver$TypeTable$1
  extends TypeResolver.TypeTable
{
  TypeResolver$TypeTable$1(TypeResolver.TypeTable paramTypeTable1, TypeVariable paramTypeVariable, TypeResolver.TypeTable paramTypeTable2) {}
  
  public Type resolveInternal(TypeVariable<?> paramTypeVariable, TypeResolver.TypeTable paramTypeTable)
  {
    if (paramTypeVariable.getGenericDeclaration().equals(this.val$var.getGenericDeclaration())) {
      return paramTypeVariable;
    }
    return this.val$unguarded.resolveInternal(paramTypeVariable, paramTypeTable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeResolver.TypeTable.1
 * JD-Core Version:    0.7.0.1
 */