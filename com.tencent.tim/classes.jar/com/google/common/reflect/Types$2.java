package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

final class Types$2
  extends TypeVisitor
{
  Types$2(AtomicReference paramAtomicReference) {}
  
  void visitClass(Class<?> paramClass)
  {
    this.val$result.set(paramClass.getComponentType());
  }
  
  void visitGenericArrayType(GenericArrayType paramGenericArrayType)
  {
    this.val$result.set(paramGenericArrayType.getGenericComponentType());
  }
  
  void visitTypeVariable(TypeVariable<?> paramTypeVariable)
  {
    this.val$result.set(Types.access$100(paramTypeVariable.getBounds()));
  }
  
  void visitWildcardType(WildcardType paramWildcardType)
  {
    this.val$result.set(Types.access$100(paramWildcardType.getUpperBounds()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Types.2
 * JD-Core Version:    0.7.0.1
 */