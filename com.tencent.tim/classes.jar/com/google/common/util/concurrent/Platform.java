package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class Platform
{
  static boolean isInstanceOfThrowableClass(@Nullable Throwable paramThrowable, Class<? extends Throwable> paramClass)
  {
    return paramClass.isInstance(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Platform
 * JD-Core Version:    0.7.0.1
 */