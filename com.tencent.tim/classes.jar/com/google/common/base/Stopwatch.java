package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;

@GwtCompatible
public final class Stopwatch
{
  private long elapsedNanos;
  private boolean isRunning;
  private long startTick;
  private final Ticker ticker;
  
  Stopwatch()
  {
    this.ticker = Ticker.systemTicker();
  }
  
  Stopwatch(Ticker paramTicker)
  {
    this.ticker = ((Ticker)Preconditions.checkNotNull(paramTicker, "ticker"));
  }
  
  private static String abbreviate(TimeUnit paramTimeUnit)
  {
    switch (1.$SwitchMap$java$util$concurrent$TimeUnit[paramTimeUnit.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      return "ns";
    case 2: 
      return "μs";
    case 3: 
      return "ms";
    case 4: 
      return "s";
    case 5: 
      return "min";
    case 6: 
      return "h";
    }
    return "d";
  }
  
  private static TimeUnit chooseUnit(long paramLong)
  {
    if (TimeUnit.DAYS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.DAYS;
    }
    if (TimeUnit.HOURS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.HOURS;
    }
    if (TimeUnit.MINUTES.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MINUTES;
    }
    if (TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.SECONDS;
    }
    if (TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MILLISECONDS;
    }
    if (TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MICROSECONDS;
    }
    return TimeUnit.NANOSECONDS;
  }
  
  public static Stopwatch createStarted()
  {
    return new Stopwatch().start();
  }
  
  public static Stopwatch createStarted(Ticker paramTicker)
  {
    return new Stopwatch(paramTicker).start();
  }
  
  public static Stopwatch createUnstarted()
  {
    return new Stopwatch();
  }
  
  public static Stopwatch createUnstarted(Ticker paramTicker)
  {
    return new Stopwatch(paramTicker);
  }
  
  private long elapsedNanos()
  {
    if (this.isRunning) {
      return this.ticker.read() - this.startTick + this.elapsedNanos;
    }
    return this.elapsedNanos;
  }
  
  public long elapsed(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
  }
  
  public boolean isRunning()
  {
    return this.isRunning;
  }
  
  @CanIgnoreReturnValue
  public Stopwatch reset()
  {
    this.elapsedNanos = 0L;
    this.isRunning = false;
    return this;
  }
  
  @CanIgnoreReturnValue
  public Stopwatch start()
  {
    if (!this.isRunning) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "This stopwatch is already running.");
      this.isRunning = true;
      this.startTick = this.ticker.read();
      return this;
    }
  }
  
  @CanIgnoreReturnValue
  public Stopwatch stop()
  {
    long l1 = this.ticker.read();
    Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
    this.isRunning = false;
    long l2 = this.elapsedNanos;
    this.elapsedNanos = (l1 - this.startTick + l2);
    return this;
  }
  
  public String toString()
  {
    long l = elapsedNanos();
    TimeUnit localTimeUnit = chooseUnit(l);
    double d = l / TimeUnit.NANOSECONDS.convert(1L, localTimeUnit);
    return Platform.formatCompact4Digits(d) + " " + abbreviate(localTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Stopwatch
 * JD-Core Version:    0.7.0.1
 */