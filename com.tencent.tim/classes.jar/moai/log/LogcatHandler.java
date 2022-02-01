package moai.log;

import android.util.Log;

public class LogcatHandler
  extends Handler
{
  public LogcatHandler()
  {
    super(2, null);
  }
  
  public int publish(int paramInt, String paramString1, String paramString2)
  {
    return Log.println(paramInt, paramString1, paramString2);
  }
  
  public int publish(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramThrowable = Log.getStackTraceString(paramThrowable);
    int i = Log.println(paramInt, paramString1, paramString2);
    return Log.println(paramInt, paramString1, paramThrowable) + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.LogcatHandler
 * JD-Core Version:    0.7.0.1
 */