package oicq.wlogin_sdk.request;

import java.net.HttpURLConnection;
import oicq.wlogin_sdk.tools.util;

public class j
  implements Runnable
{
  private HttpURLConnection a;
  private boolean b = false;
  
  public j(HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramHttpURLConnection;
  }
  
  public static boolean a(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    try
    {
      paramHttpURLConnection = new j(paramHttpURLConnection);
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
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.j
 * JD-Core Version:    0.7.0.1
 */