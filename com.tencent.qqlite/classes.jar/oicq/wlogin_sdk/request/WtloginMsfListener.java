package oicq.wlogin_sdk.request;

import java.lang.reflect.Method;
import java.util.concurrent.Semaphore;
import oicq.wlogin_sdk.tools.util;

public class WtloginMsfListener
  implements Runnable
{
  private final String CLIENT_CLASSNAME = "com.tencent.mobileqq.msf.core.auth.WtProvider";
  private byte[] data;
  private boolean flag;
  private int ret;
  private byte[] ret_data = null;
  private String ret_serviceCmd;
  private boolean ret_success = false;
  private String ret_uin;
  private final Semaphore semp = new Semaphore(1);
  private String serviceCmd;
  private int timeout;
  private String uin;
  private WUserSigInfo userSigInfo;
  
  public WtloginMsfListener(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "0";
    }
    this.uin = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.serviceCmd = paramString1;
    paramString1 = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString1 = new byte[0];
    }
    this.data = paramString1;
    if (paramInt > 0) {}
    for (;;)
    {
      this.timeout = paramInt;
      this.flag = paramBoolean;
      this.userSigInfo = paramWUserSigInfo;
      return;
      paramInt = 10000;
    }
  }
  
  public void Cancel()
  {
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.msf.core.auth.WtProvider");
      localClass.getMethod("cancel", new Class[] { WUserSigInfo.class }).invoke(localClass, new Object[] { this.userSigInfo });
      return;
    }
    catch (Exception localException)
    {
      util.printException(localException, this.uin);
    }
  }
  
  public byte[] RecvData()
  {
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        this.semp.acquire();
        if (!this.ret_success) {
          return null;
        }
        if ((this.ret_uin != null) && (this.ret_uin.equals(this.uin))) {
          break;
        }
        this.ret = -1009;
        localStringBuilder = new StringBuilder().append("ret_uin: ");
        if (this.ret_uin == null)
        {
          String str = "null";
          localStringBuilder = localStringBuilder.append(str).append(", uin: ");
          if (this.uin != null) {
            break label122;
          }
          str = "null";
          util.LOGI(str, "");
          return null;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        util.printException(localInterruptedException, this.uin);
        return null;
      }
      localObject = this.ret_uin;
      continue;
      label122:
      localObject = this.uin;
    }
    if ((this.ret_serviceCmd == null) || (!this.ret_serviceCmd.equals(this.serviceCmd)))
    {
      this.ret = -1009;
      localStringBuilder = new StringBuilder().append("ret_serviceCmd: ");
      if (this.ret_serviceCmd == null)
      {
        localObject = "null";
        localStringBuilder = localStringBuilder.append((String)localObject).append(", serviceCmd:");
        if (this.serviceCmd != null) {
          break label225;
        }
      }
      label225:
      for (localObject = "null";; localObject = this.serviceCmd)
      {
        util.LOGI((String)localObject, "");
        return null;
        localObject = this.ret_serviceCmd;
        break;
      }
    }
    this.semp.release();
    Object localObject = this.ret_data;
    return localObject;
  }
  
  public int SendData(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.msf.core.auth.WtProvider");
      paramInt = Integer.valueOf(localClass.getMethod("sendData", new Class[] { WUserSigInfo.class, String.class, String.class, [B.class, Integer.TYPE, Boolean.TYPE, WtloginMsfListener.class }).invoke(localClass, new Object[] { this.userSigInfo, new String(this.uin), new String(this.serviceCmd), paramArrayOfByte.clone(), new Integer(paramInt), Boolean.valueOf(this.flag), this }).toString()).intValue();
      if (paramInt > 0) {
        this.semp.acquire();
      }
      return paramInt;
    }
    catch (Exception paramArrayOfByte)
    {
      util.printException(paramArrayOfByte, this.uin);
    }
    return -1000;
  }
  
  public int getRet()
  {
    return this.ret;
  }
  
  public byte[] getRetData()
  {
    return this.ret_data;
  }
  
  public void onReceiveData(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.ret_success = true;
    this.ret_uin = paramString1;
    this.ret_serviceCmd = paramString2;
    this.ret = 0;
    this.ret_data = paramArrayOfByte;
    this.semp.release();
  }
  
  public void onReceiveFail(String paramString1, String paramString2, int paramInt)
  {
    this.ret_success = false;
    this.ret_uin = paramString1;
    this.ret_serviceCmd = paramString2;
    this.ret = paramInt;
    this.semp.release();
  }
  
  public void run()
  {
    try
    {
      this.ret = SendData(this.data, this.timeout);
      if (this.ret <= 0)
      {
        util.LOGI("msf request send data failed, ret=" + this.ret, "");
        return;
      }
      if (RecvData() == null)
      {
        this.ret_data = null;
        return;
      }
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginMsfListener
 * JD-Core Version:    0.7.0.1
 */