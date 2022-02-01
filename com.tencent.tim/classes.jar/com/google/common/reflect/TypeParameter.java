package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

@Beta
public abstract class TypeParameter<T>
  extends TypeCapture<T>
{
  final TypeVariable<?> typeVariable;
  
  protected TypeParameter()
  {
    Type localType = capture();
    Preconditions.checkArgument(localType instanceof TypeVariable, "%s should be a type variable.", localType);
    this.typeVariable = ((TypeVariable)localType);
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof TypeParameter))
    {
      paramObject = (TypeParameter)paramObject;
      return this.typeVariable.equals(paramObject.typeVariable);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.typeVariable.hashCode();
  }
  
  public String toString()
  {
    return this.typeVariable.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeParameter
 * JD-Core Version:    0.7.0.1
 */