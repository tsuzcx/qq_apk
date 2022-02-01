package com.tencent.moai.database.sqlite;

public final class CloseGuard
{
  private static volatile boolean ENABLED = true;
  private static final CloseGuard NOOP = new CloseGuard();
  private static volatile Reporter REPORTER = new DefaultReporter(null);
  private Throwable allocationSite;
  
  public static CloseGuard get()
  {
    if (!ENABLED) {
      return NOOP;
    }
    return new CloseGuard();
  }
  
  public static Reporter getReporter()
  {
    return REPORTER;
  }
  
  public static void setEnabled(boolean paramBoolean)
  {
    ENABLED = paramBoolean;
  }
  
  public static void setReporter(Reporter paramReporter)
  {
    if (paramReporter == null) {
      throw new NullPointerException("reporter == null");
    }
    REPORTER = paramReporter;
  }
  
  public void close()
  {
    this.allocationSite = null;
  }
  
  public void open(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("closer == null");
    }
    if ((this == NOOP) || (!ENABLED)) {
      return;
    }
    this.allocationSite = new Throwable("Explicit termination method '" + paramString + "' not called");
  }
  
  public void warnIfOpen()
  {
    if ((this.allocationSite == null) || (!ENABLED)) {
      return;
    }
    REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
  }
  
  static final class DefaultReporter
    implements CloseGuard.Reporter
  {
    public void report(String paramString, Throwable paramThrowable)
    {
      SQLiteDebug.Log.w(paramString, paramThrowable);
    }
  }
  
  public static abstract interface Reporter
  {
    public abstract void report(String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.CloseGuard
 * JD-Core Version:    0.7.0.1
 */