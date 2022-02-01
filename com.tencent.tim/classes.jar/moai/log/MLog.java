package moai.log;

public abstract interface MLog
{
  public abstract void addHandler(Handler paramHandler);
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract Handler[] getAllHandler();
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void println(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean removeHandler(Handler paramHandler);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.MLog
 * JD-Core Version:    0.7.0.1
 */