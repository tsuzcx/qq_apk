package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckReturnValue;

@GwtIncompatible
@CanIgnoreReturnValue
public final class ThreadFactoryBuilder
{
  private ThreadFactory backingThreadFactory = null;
  private Boolean daemon = null;
  private String nameFormat = null;
  private Integer priority = null;
  private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
  
  private static ThreadFactory build(ThreadFactoryBuilder paramThreadFactoryBuilder)
  {
    String str = paramThreadFactoryBuilder.nameFormat;
    Boolean localBoolean = paramThreadFactoryBuilder.daemon;
    Integer localInteger = paramThreadFactoryBuilder.priority;
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = paramThreadFactoryBuilder.uncaughtExceptionHandler;
    if (paramThreadFactoryBuilder.backingThreadFactory != null)
    {
      paramThreadFactoryBuilder = paramThreadFactoryBuilder.backingThreadFactory;
      if (str == null) {
        break label70;
      }
    }
    label70:
    for (AtomicLong localAtomicLong = new AtomicLong(0L);; localAtomicLong = null)
    {
      return new ThreadFactoryBuilder.1(paramThreadFactoryBuilder, str, localAtomicLong, localBoolean, localInteger, localUncaughtExceptionHandler);
      paramThreadFactoryBuilder = Executors.defaultThreadFactory();
      break;
    }
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  @CheckReturnValue
  public ThreadFactory build()
  {
    return build(this);
  }
  
  public ThreadFactoryBuilder setDaemon(boolean paramBoolean)
  {
    this.daemon = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public ThreadFactoryBuilder setNameFormat(String paramString)
  {
    format(paramString, new Object[] { Integer.valueOf(0) });
    this.nameFormat = paramString;
    return this;
  }
  
  public ThreadFactoryBuilder setPriority(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 1)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Thread priority (%s) must be >= %s", paramInt, 1);
      if (paramInt > 10) {
        break label49;
      }
    }
    label49:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Thread priority (%s) must be <= %s", paramInt, 10);
      this.priority = Integer.valueOf(paramInt);
      return this;
      bool1 = false;
      break;
    }
  }
  
  public ThreadFactoryBuilder setThreadFactory(ThreadFactory paramThreadFactory)
  {
    this.backingThreadFactory = ((ThreadFactory)Preconditions.checkNotNull(paramThreadFactory));
    return this;
  }
  
  public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.uncaughtExceptionHandler = ((Thread.UncaughtExceptionHandler)Preconditions.checkNotNull(paramUncaughtExceptionHandler));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ThreadFactoryBuilder
 * JD-Core Version:    0.7.0.1
 */