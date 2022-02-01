package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

final class TypeResolver$1
  extends TypeVisitor
{
  TypeResolver$1(Map paramMap, Type paramType) {}
  
  void visitClass(Class<?> paramClass)
  {
    if ((this.val$to instanceof WildcardType)) {
      return;
    }
    throw new IllegalArgumentException("No type mapping from " + paramClass + " to " + this.val$to);
  }
  
  void visitGenericArrayType(GenericArrayType paramGenericArrayType)
  {
    if ((this.val$to instanceof WildcardType)) {
      return;
    }
    Type localType = Types.getComponentType(this.val$to);
    if (localType != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "%s is not an array type.", this.val$to);
      TypeResolver.access$000(this.val$mappings, paramGenericArrayType.getGenericComponentType(), localType);
      return;
    }
  }
  
  void visitParameterizedType(ParameterizedType paramParameterizedType)
  {
    int i = 0;
    if ((this.val$to instanceof WildcardType)) {
      return;
    }
    ParameterizedType localParameterizedType = (ParameterizedType)TypeResolver.access$100(ParameterizedType.class, this.val$to);
    if ((paramParameterizedType.getOwnerType() != null) && (localParameterizedType.getOwnerType() != null)) {
      TypeResolver.access$000(this.val$mappings, paramParameterizedType.getOwnerType(), localParameterizedType.getOwnerType());
    }
    Preconditions.checkArgument(paramParameterizedType.getRawType().equals(localParameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", paramParameterizedType, this.val$to);
    Type[] arrayOfType1 = paramParameterizedType.getActualTypeArguments();
    Type[] arrayOfType2 = localParameterizedType.getActualTypeArguments();
    if (arrayOfType1.length == arrayOfType2.length) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "%s not compatible with %s", paramParameterizedType, localParameterizedType);
      while (i < arrayOfType1.length)
      {
        TypeResolver.access$000(this.val$mappings, arrayOfType1[i], arrayOfType2[i]);
        i += 1;
      }
      break;
    }
  }
  
  void visitTypeVariable(TypeVariable<?> paramTypeVariable)
  {
    this.val$mappings.put(new TypeResolver.TypeVariableKey(paramTypeVariable), this.val$to);
  }
  
  void visitWildcardType(WildcardType paramWildcardType)
  {
    int k = 0;
    if (!(this.val$to instanceof WildcardType)) {}
    for (;;)
    {
      return;
      Object localObject = (WildcardType)this.val$to;
      Type[] arrayOfType1 = paramWildcardType.getUpperBounds();
      Type[] arrayOfType2 = ((WildcardType)localObject).getUpperBounds();
      Type[] arrayOfType3 = paramWildcardType.getLowerBounds();
      localObject = ((WildcardType)localObject).getLowerBounds();
      if ((arrayOfType1.length == arrayOfType2.length) && (arrayOfType3.length == localObject.length)) {}
      int j;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Incompatible type: %s vs. %s", paramWildcardType, this.val$to);
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= arrayOfType1.length) {
            break;
          }
          TypeResolver.access$000(this.val$mappings, arrayOfType1[i], arrayOfType2[i]);
          i += 1;
        }
      }
      while (j < arrayOfType3.length)
      {
        TypeResolver.access$000(this.val$mappings, arrayOfType3[j], localObject[j]);
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeResolver.1
 * JD-Core Version:    0.7.0.1
 */