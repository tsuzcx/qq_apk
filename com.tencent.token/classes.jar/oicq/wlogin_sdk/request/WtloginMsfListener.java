package oicq.wlogin_sdk.request;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import oicq.wlogin_sdk.tools.util;

public class WtloginMsfListener
  implements Runnable
{
  public static String CLIENT_CLASSNAME = "com.tencent.mobileqq.msf.core.auth.WtProvider";
  static Object TicketMgr;
  private static final Object __SyncCB;
  private static final Object __SyncSeq = new Object();
  private static Map<Long, WtloginMsfListener> __cbs = new HashMap();
  private static long __seq;
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
  
  static
  {
    __SyncCB = new Object();
    __seq = 0L;
  }
  
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
    if (paramInt <= 0) {
      paramInt = 5000;
    }
    this.timeout = paramInt;
    this.flag = paramBoolean;
    this.userSigInfo = paramWUserSigInfo;
  }
  
  private static long allocateSeq()
  {
    synchronized (__SyncSeq)
    {
      long l = __seq + 1L;
      __seq = l;
      return l % 2147483647L;
    }
  }
  
  public static void onAsyncReceive(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("rpc receive ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" seq: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" data:");
    if (paramArrayOfByte == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramArrayOfByte.length);
    }
    localStringBuilder.append(localObject);
    util.LOGI(localStringBuilder.toString(), paramString1);
    Object localObject = pickSeq(paramLong);
    if (localObject != null) {
      ((WtloginMsfListener)localObject).onReceiveData(paramString1, paramString2, paramArrayOfByte);
    }
  }
  
  public static void onAsyncReceiveFail(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder("rpc receive ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" seq: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" fail:");
    ((StringBuilder)localObject).append(paramInt);
    util.LOGI(((StringBuilder)localObject).toString(), paramString1);
    localObject = pickSeq(paramLong);
    if (localObject != null) {
      ((WtloginMsfListener)localObject).onReceiveFail(paramString1, paramString2, paramInt);
    }
  }
  
  private static WtloginMsfListener pickSeq(long paramLong)
  {
    synchronized (__SyncCB)
    {
      WtloginMsfListener localWtloginMsfListener = (WtloginMsfListener)__cbs.get(Long.valueOf(paramLong));
      __cbs.remove(Long.valueOf(paramLong));
      return localWtloginMsfListener;
    }
  }
  
  private Object sendDataByReflectMqq(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    Class localClass1 = Class.forName("mqq.manager.TicketManager");
    if (TicketMgr == null)
    {
      Object localObject2 = Class.forName("com.tencent.common.app.BaseApplicationImpl");
      Object localObject3 = Class.forName("mqq.app.BaseActivity");
      Class localClass2 = Class.forName("mqq.app.AppRuntime");
      Object localObject1 = ((Class)localObject2).getMethod("getApplication", new Class[0]);
      Method localMethod = ((Class)localObject2).getMethod("waitAppRuntime", new Class[] { localObject3 });
      localObject2 = localClass2.getMethod("getManager", new Class[] { Integer.TYPE });
      localObject3 = localClass2.getField("TICKET_MANAGER");
      localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
      if (localObject1 != null)
      {
        localObject1 = localMethod.invoke(localObject1, new Object[] { null });
        if (localObject1 != null) {
          TicketMgr = ((Method)localObject2).invoke(localObject1, new Object[] { ((Field)localObject3).get(localClass2) });
        }
      }
    }
    return localClass1.getMethod("sendRPCData", new Class[] { Long.TYPE, String.class, String.class, [B.class, Integer.TYPE }).invoke(TicketMgr, new Object[] { Long.valueOf(paramLong), this.uin, this.serviceCmd, paramArrayOfByte.clone(), Integer.valueOf(paramInt) });
  }
  
  private int sendRPCData(byte[] arg1, int paramInt)
  {
    long l = allocateSeq();
    util.LOGI("sendRPCData seq: ".concat(String.valueOf(l)), "");
    try
    {
      if (WtloginHelper.getWtDataSender() == null) {
        paramInt = Integer.parseInt(sendDataByReflectMqq(???, paramInt, l).toString());
      } else {
        paramInt = WtloginHelper.getWtDataSender().a(l, this.uin, this.serviceCmd, (byte[])???.clone(), paramInt);
      }
      int i = paramInt;
      if (paramInt == 0) {
        synchronized (__SyncCB)
        {
          __cbs.put(Long.valueOf(l), this);
          this.semp.acquire();
          return 99;
        }
      }
      return i;
    }
    catch (Exception ???)
    {
      util.printException(???, this.uin);
      i = -1000;
    }
  }
  
  public void Cancel()
  {
    try
    {
      Class localClass = Class.forName(CLIENT_CLASSNAME);
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
    try
    {
      this.semp.acquire();
      if (!this.ret_success) {
        return null;
      }
      String str;
      if ((this.ret_uin != null) && (this.ret_uin.equals(this.uin)))
      {
        if ((this.ret_serviceCmd != null) && (this.ret_serviceCmd.equals(this.serviceCmd)))
        {
          this.semp.release();
          return this.ret_data;
        }
        this.ret = -1009;
        localStringBuilder = new StringBuilder("ret_serviceCmd: ");
        if (this.ret_serviceCmd == null) {
          str = "null";
        } else {
          str = this.ret_serviceCmd;
        }
        localStringBuilder.append(str);
        localStringBuilder.append(", serviceCmd:");
        if (this.serviceCmd == null) {
          str = "null";
        } else {
          str = this.serviceCmd;
        }
        localStringBuilder.append(str);
        util.LOGI(localStringBuilder.toString(), "");
        return null;
      }
      this.ret = -1009;
      StringBuilder localStringBuilder = new StringBuilder("ret_uin: ");
      if (this.ret_uin == null) {
        str = "null";
      } else {
        str = this.ret_uin;
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", uin: ");
      if (this.uin == null) {
        str = "null";
      } else {
        str = this.uin;
      }
      localStringBuilder.append(str);
      util.LOGI(localStringBuilder.toString(), "");
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      util.printException(localInterruptedException, this.uin);
    }
    return null;
  }
  
  public int SendData(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject;
    if (!u.ax)
    {
      localObject = u.m();
      util.LOGI("mqq process: ".concat(String.valueOf(localObject)), "");
      if (!((String)localObject).endsWith(":MSF")) {
        return sendRPCData(paramArrayOfByte, paramInt);
      }
    }
    try
    {
      util.LOGI("msf sendData", "");
      localObject = Class.forName(CLIENT_CLASSNAME);
      int i = Integer.valueOf(((Class)localObject).getMethod("sendData", new Class[] { WUserSigInfo.class, String.class, String.class, [B.class, Integer.TYPE, Boolean.TYPE, WtloginMsfListener.class }).invoke(localObject, new Object[] { this.userSigInfo, this.uin, this.serviceCmd, paramArrayOfByte.clone(), Integer.valueOf(paramInt), Boolean.valueOf(this.flag), this }).toString()).intValue();
      paramInt = i;
      if (i > 0)
      {
        this.semp.acquire();
        return i;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      util.printException(paramArrayOfByte, this.uin);
      paramInt = -1000;
    }
    return paramInt;
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
        StringBuilder localStringBuilder = new StringBuilder("msf request send data failed, ret=");
        localStringBuilder.append(this.ret);
        util.LOGI(localStringBuilder.toString(), "");
        return;
      }
      if (RecvData() == null) {
        this.ret_data = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginMsfListener
 * JD-Core Version:    0.7.0.1
 */