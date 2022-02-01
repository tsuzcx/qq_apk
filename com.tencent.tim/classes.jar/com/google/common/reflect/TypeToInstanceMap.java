package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
public abstract interface TypeToInstanceMap<B>
  extends Map<TypeToken<? extends B>, B>
{
  @Nullable
  public abstract <T extends B> T getInstance(TypeToken<T> paramTypeToken);
  
  @Nullable
  public abstract <T extends B> T getInstance(Class<T> paramClass);
  
  @Nullable
  @CanIgnoreReturnValue
  public abstract <T extends B> T putInstance(TypeToken<T> paramTypeToken, @Nullable T paramT);
  
  @Nullable
  @CanIgnoreReturnValue
  public abstract <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.TypeToInstanceMap
 * JD-Core Version:    0.7.0.1
 */