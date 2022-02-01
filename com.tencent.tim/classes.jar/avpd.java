import cooperation.qzone.util.QZLog;

public final class avpd
{
  private static volatile boolean ENABLED = true;
  private static volatile avpd.b a = new avpd.a(null);
  private static final avpd b = new avpd();
  private Throwable allocationSite;
  
  public static avpd a()
  {
    if (!ENABLED) {
      return b;
    }
    return new avpd();
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
    if ((this == b) || (!ENABLED)) {
      return;
    }
    this.allocationSite = new Throwable("Explicit termination method '" + paramString + "' not called");
  }
  
  public void warnIfOpen()
  {
    if ((this.allocationSite == null) || (!ENABLED)) {
      return;
    }
    a.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
  }
  
  static final class a
    implements avpd.b
  {
    public void report(String paramString, Throwable paramThrowable)
    {
      QZLog.e("QZLog", paramString, paramThrowable);
    }
  }
  
  public static abstract interface b
  {
    public abstract void report(String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpd
 * JD-Core Version:    0.7.0.1
 */