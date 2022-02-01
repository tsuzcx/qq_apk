package moai.view.moaiphoto.log;

public abstract interface Logger
{
  public abstract int d(String paramString1, String paramString2);
  
  public abstract int d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int e(String paramString1, String paramString2);
  
  public abstract int e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int i(String paramString1, String paramString2);
  
  public abstract int i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int v(String paramString1, String paramString2);
  
  public abstract int v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int w(String paramString1, String paramString2);
  
  public abstract int w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.log.Logger
 * JD-Core Version:    0.7.0.1
 */