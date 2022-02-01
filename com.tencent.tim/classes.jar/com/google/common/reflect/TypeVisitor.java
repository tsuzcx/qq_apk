package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class TypeVisitor
{
  private final Set<Type> visited = Sets.newHashSet();
  
  public final void visit(Type... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Type localType = paramVarArgs[i];
      if ((localType == null) || (!this.visited.add(localType))) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          if ((localType instanceof TypeVariable))
          {
            visitTypeVariable((TypeVariable)localType);
            continue;
          }
        }
        finally
        {
          this.visited.remove(localType);
        }
        if ((localType instanceof WildcardType))
        {
          visitWildcardType((WildcardType)localType);
        }
        else if ((localType instanceof ParameterizedType))
        {
          visitParameterizedType((ParameterizedType)localType);
        }
        else if ((localType instanceof Class))
        {
          visitClass((Class)localType);
        }
        else
        {
          if (!(localType instanceof GenericArrayType)) {
            break label156;
          }
          visitGenericArrayType((GenericArrayType)localType);
        }
      }
      label156:
      throw new AssertionError("Unknown type: " + localType);
    }
  }
  
  void visitClass(Class<?> paramClass) {}
  
  void visitGenericArrayType(GenericArrayType paramGenericArrayType) {}
  
  void visitParameterizedType(ParameterizedType paramParameterizedType) {}
  
  void visitTypeVariable(TypeVariable<?> paramTypeVariable) {}
  
  void visitWildcardType(WildcardType paramWildcardType) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeVisitor
 * JD-Core Version:    0.7.0.1
 */