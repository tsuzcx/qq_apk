package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface ClassToInstanceMap<B>
  extends Map<Class<? extends B>, B>
{
  @CanIgnoreReturnValue
  public abstract <T extends B> T getInstance(Class<T> paramClass);
  
  @CanIgnoreReturnValue
  public abstract <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ClassToInstanceMap
 * JD-Core Version:    0.7.0.1
 */