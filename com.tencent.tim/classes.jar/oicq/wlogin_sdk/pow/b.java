package oicq.wlogin_sdk.pow;

import android.util.Log;
import oicq.wlogin_sdk.tools.util;

public class b
  implements Runnable
{
  int a;
  byte[] b;
  
  public b(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }
  
  public static void a()
  {
    try
    {
      new Thread(new b(1, null), "Wtlogin_asynCalcPow").start();
      util.LOGI("asyncGetPerformance started", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      util.LOGI("asyncGetPerformance error " + Log.getStackTraceString(localThrowable), "");
    }
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      new Thread(new b(0, paramArrayOfByte), "Wtlogin_asynCalcPow").start();
      util.LOGI("aysncCalcPow started", "");
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      util.LOGI("aysncCalcPow error " + Log.getStackTraceString(paramArrayOfByte), "");
    }
  }
  
  public static void b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ClientPow().a(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        oicq.wlogin_sdk.request.u.an = paramArrayOfByte;
        return;
      }
      util.LOGI("outBuf is null", "");
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      util.LOGI("syncCalcPow error " + Log.getStackTraceString(paramArrayOfByte), "");
    }
  }
  
  public void run()
  {
    byte[] arrayOfByte;
    if (this.a == 0)
    {
      if ((this.b != null) && (this.b.length > 0))
      {
        arrayOfByte = new ClientPow().a(this.b);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0))
        {
          oicq.wlogin_sdk.request.u.an = arrayOfByte;
          return;
        }
        util.LOGI("outBuf is null", "");
        return;
      }
      util.LOGI("inBuf is null ", "");
      return;
    }
    if (this.a == 1)
    {
      try
      {
        arrayOfByte = new ClientPow().nativeGetTestData();
        if ((arrayOfByte != null) && (arrayOfByte.length != 0))
        {
          oicq.wlogin_sdk.request.u.ao = arrayOfByte;
          util.LOGI("get performance" + arrayOfByte.length, "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        util.LOGI("getPerformance " + Log.getStackTraceString(localThrowable), "");
        return;
      }
      util.LOGI("outBuf is null", "");
      return;
    }
    util.LOGI("error type:" + this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.pow.b
 * JD-Core Version:    0.7.0.1
 */