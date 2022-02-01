package moai.log;

public class SimpleMLog
  implements MLog
{
  public void addHandler(Handler paramHandler) {}
  
  public void d(String paramString1, String paramString2)
  {
    process(3, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    process(3, paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    process(3, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void e(String paramString1, String paramString2)
  {
    process(6, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    process(6, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    process(6, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public Handler[] getAllHandler()
  {
    return null;
  }
  
  public void i(String paramString1, String paramString2)
  {
    process(4, paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    process(4, paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    process(4, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void println(int paramInt, String paramString1, String paramString2)
  {
    process(paramInt, paramString1, paramString2);
  }
  
  protected void process(int paramInt, String paramString1, String paramString2) {}
  
  protected void process(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public boolean removeHandler(Handler paramHandler)
  {
    return false;
  }
  
  public void v(String paramString1, String paramString2)
  {
    process(2, paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    process(2, paramString1, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    process(2, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void w(String paramString1, String paramString2)
  {
    process(5, paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    process(5, paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    process(5, paramString1, String.format(paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.SimpleMLog
 * JD-Core Version:    0.7.0.1
 */