package oicq.wlogin_sdk.request;

import java.net.HttpURLConnection;

public class m
  implements Runnable
{
  private HttpURLConnection a;
  private boolean b = false;
  
  public m(HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramHttpURLConnection;
  }
  
  public static boolean a(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    try
    {
      paramHttpURLConnection = new m(paramHttpURLConnection);
      Thread localThread = new Thread(paramHttpURLConnection);
      localThread.start();
      localThread.join(paramLong);
      boolean bool = paramHttpURLConnection.a();
      return bool;
    }
    catch (Throwable paramHttpURLConnection) {}
    return false;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void run()
  {
    try
    {
      this.a.connect();
      this.b = true;
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */