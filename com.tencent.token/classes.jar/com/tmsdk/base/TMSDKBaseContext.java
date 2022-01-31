package com.tmsdk.base;

import android.content.Context;
import btmsdkobf.bc;
import btmsdkobf.be;
import btmsdkobf.bh;
import btmsdkobf.bn;
import btmsdkobf.bx;
import btmsdkobf.ec;
import btmsdkobf.ee;
import btmsdkobf.eg;
import com.qq.taf.jce.JceStruct;
import tmsdk.common.tcc.b;

public class TMSDKBaseContext
{
  public static final int CALLBACK_RUN_ON_THREAD = 0;
  public static final int CALLBACK_RUN_ON_UI = 8;
  public static final int ELANG_CHS = 1;
  public static final int ELANG_ENG = 2;
  public static final int ELANG_NONE = 0;
  private static boolean r = false;
  
  public static void SaveStringData(int paramInt, String paramString)
  {
    eg.e("TMSDKBaseContext", "SaveStringData, modelId:[" + paramInt + "]msg:[" + paramString + "]");
    be.SaveStringData(paramInt, paramString);
  }
  
  public static void SaveStringDataOnce(int paramInt, String paramString)
  {
    eg.e("TMSDKBaseContext", "SaveStringDataOnce, modelId:[" + paramInt + "]msg:[" + paramString + "]");
    be.SaveStringDataOnce(paramInt, paramString);
  }
  
  public static void addReportListener(TMSDKBaseContext.IReportListener paramIReportListener)
  {
    bn.addReportListener(paramIReportListener);
  }
  
  public static void addTask(Runnable paramRunnable, String paramString)
  {
    ee.cT().addTask(paramRunnable, paramString);
  }
  
  public static void addUrgentTask(Runnable paramRunnable, String paramString)
  {
    ee.cT().addUrgentTask(paramRunnable, paramString);
  }
  
  public static void aroundWifiReport() {}
  
  public static boolean checkLicence()
  {
    return bc.checkLicence();
  }
  
  public static void checkPullReport(int paramInt) {}
  
  public static void collectSaveNumber(String paramString, int paramInt) {}
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b.decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b.encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static Context getApplicationContext()
  {
    return bc.n();
  }
  
  public static String getChannel()
  {
    return bc.getChannel();
  }
  
  public static int getCurrentLang()
  {
    return ec.cS().getInt("c_l", 1);
  }
  
  public static String getGuid()
  {
    return bx.ar().getGuid();
  }
  
  /* Error */
  public static boolean init(Context paramContext, AbsTMSBaseConfig paramAbsTMSBaseConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tmsdk/base/TMSDKBaseContext:r	Z
    //   6: ifeq +17 -> 23
    //   9: ldc 28
    //   11: ldc 140
    //   13: invokestatic 54	btmsdkobf/eg:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: iconst_1
    //   17: istore_2
    //   18: ldc 2
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: aload_0
    //   24: aload_1
    //   25: invokestatic 142	btmsdkobf/bc:init	(Landroid/content/Context;Lcom/tmsdk/base/AbsTMSBaseConfig;)Z
    //   28: putstatic 20	com/tmsdk/base/TMSDKBaseContext:r	Z
    //   31: ldc 28
    //   33: new 30	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   40: ldc 144
    //   42: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc 149
    //   51: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: ldc 151
    //   60: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: getstatic 20	com/tmsdk/base/TMSDKBaseContext:r	Z
    //   66: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: ldc 44
    //   71: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 54	btmsdkobf/eg:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: getstatic 20	com/tmsdk/base/TMSDKBaseContext:r	Z
    //   83: istore_2
    //   84: goto -66 -> 18
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramContext	Context
    //   0	93	1	paramAbsTMSBaseConfig	AbsTMSBaseConfig
    //   17	67	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	87	finally
    //   23	84	87	finally
  }
  
  public static boolean isENG()
  {
    return getCurrentLang() == 2;
  }
  
  public static boolean isExpired()
  {
    return bh.B().isExpired();
  }
  
  public static boolean isInitialized()
  {
    return r;
  }
  
  public static void removeReportListener(TMSDKBaseContext.IReportListener paramIReportListener)
  {
    bn.removeReportListener(paramIReportListener);
  }
  
  public static void saveActionData(int paramInt)
  {
    eg.e("TMSDKBaseContext", "saveActionData, modelId:[" + paramInt + "]");
    be.saveActionData(paramInt);
  }
  
  public static void saveActionData(int paramInt1, int paramInt2)
  {
    eg.e("TMSDKBaseContext", "saveActionData, modelId:[" + paramInt1 + "]errorCode:[" + paramInt2 + "]");
    be.saveActionData(paramInt1, paramInt2);
  }
  
  public static void saveActionDataOnce(int paramInt)
  {
    eg.e("TMSDKBaseContext", "saveActionDataOnce, modelId:[" + paramInt + "]");
    be.saveActionDataOnce(paramInt);
  }
  
  public static void sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBackOut paramISharkCallBackOut)
  {
    sendShark(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramISharkCallBackOut, 0L);
  }
  
  public static void sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBackOut paramISharkCallBackOut, long paramLong)
  {
    eg.e("TMSDKBaseContext", "guid:[" + bx.ar().getGuid() + "]sendShark, cmdId:[" + paramInt1 + "]timeout:[" + paramLong + "]");
    if (paramJceStruct1 == null)
    {
      eg.g("TMSDKBaseContext", "req == null");
      return;
    }
    bx.ar().a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new TMSDKBaseContext.1(paramISharkCallBackOut), paramLong);
  }
  
  public static void setAutoConnectionSwitch(Context paramContext, boolean paramBoolean)
  {
    eg.e("TMSDKBaseContext", "setAutoConnectionSwitch, aContext:[" + paramContext + "]aAutoConnection:[" + paramBoolean + "]");
    bc.setAutoConnectionSwitch(paramContext, paramBoolean);
  }
  
  public static void setCurrentLang(int paramInt)
  {
    ec.cS().putInt("c_l", paramInt);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    eg.setLogEnable(paramBoolean);
  }
  
  public static void wifiConnectRetReport() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.TMSDKBaseContext
 * JD-Core Version:    0.7.0.1
 */