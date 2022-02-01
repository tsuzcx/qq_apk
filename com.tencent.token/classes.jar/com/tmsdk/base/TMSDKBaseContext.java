package com.tmsdk.base;

import android.content.Context;
import btmsdkobf.bc;
import btmsdkobf.be;
import btmsdkobf.bh;
import btmsdkobf.bn;
import btmsdkobf.bx;
import btmsdkobf.cj;
import btmsdkobf.ec;
import btmsdkobf.ee;
import btmsdkobf.eg;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.auo;

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
    StringBuilder localStringBuilder = new StringBuilder("SaveStringData, modelId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]msg:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
    be.SaveStringData(paramInt, paramString);
  }
  
  public static void SaveStringDataOnce(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("SaveStringDataOnce, modelId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]msg:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
    be.SaveStringDataOnce(paramInt, paramString);
  }
  
  public static void addReportListener(IReportListener paramIReportListener)
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
    return auo.b(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return auo.a(paramArrayOfByte1, paramArrayOfByte2);
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
  
  public static boolean init(Context paramContext, AbsTMSBaseConfig paramAbsTMSBaseConfig)
  {
    try
    {
      if (r)
      {
        eg.e("TMSDKBaseContext", "has initialized, return true");
        return true;
      }
      r = bc.init(paramContext, paramAbsTMSBaseConfig);
      StringBuilder localStringBuilder = new StringBuilder("init, aContext:[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("]aTMSConfig:[");
      localStringBuilder.append(paramAbsTMSBaseConfig);
      localStringBuilder.append("]ret:[");
      localStringBuilder.append(r);
      localStringBuilder.append("]");
      eg.e("TMSDKBaseContext", localStringBuilder.toString());
      boolean bool = r;
      return bool;
    }
    finally {}
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
  
  public static void removeReportListener(IReportListener paramIReportListener)
  {
    bn.removeReportListener(paramIReportListener);
  }
  
  public static void saveActionData(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("saveActionData, modelId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
    be.saveActionData(paramInt);
  }
  
  public static void saveActionData(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("saveActionData, modelId:[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("]errorCode:[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
    be.saveActionData(paramInt1, paramInt2);
  }
  
  public static void saveActionDataOnce(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("saveActionDataOnce, modelId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
    be.saveActionDataOnce(paramInt);
  }
  
  public static void sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBackOut paramISharkCallBackOut)
  {
    sendShark(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramISharkCallBackOut, 0L);
  }
  
  public static void sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBackOut paramISharkCallBackOut, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("guid:[");
    localStringBuilder.append(bx.ar().getGuid());
    localStringBuilder.append("]sendShark, cmdId:[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("]timeout:[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
    if (paramJceStruct1 == null)
    {
      eg.g("TMSDKBaseContext", "req == null");
      return;
    }
    bx.ar().a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new cj()
    {
      public final void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        Object localObject = new StringBuilder("onFinish, cmdId:[");
        ((StringBuilder)localObject).append(paramAnonymousInt2);
        ((StringBuilder)localObject).append("]retCode:[");
        ((StringBuilder)localObject).append(paramAnonymousInt3);
        ((StringBuilder)localObject).append("]dataRetCode:[");
        ((StringBuilder)localObject).append(paramAnonymousInt4);
        ((StringBuilder)localObject).append("]");
        eg.g("TMSDKBaseContext", ((StringBuilder)localObject).toString());
        int i = paramAnonymousInt3;
        if (paramAnonymousInt3 == 0)
        {
          i = paramAnonymousInt3;
          if (paramAnonymousInt4 == 0) {
            i = 0;
          }
        }
        if (i % 20 == -4) {
          paramAnonymousInt3 = -102;
        } else if (i != 0) {
          paramAnonymousInt3 = -999;
        } else if (paramAnonymousInt4 != 0) {
          paramAnonymousInt3 = -101;
        } else {
          paramAnonymousInt3 = i;
        }
        localObject = this.s;
        if (localObject != null) {
          ((ISharkCallBackOut)localObject).onFinish(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousJceStruct);
        }
      }
    }, paramLong);
  }
  
  public static void setAutoConnectionSwitch(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("setAutoConnectionSwitch, aContext:[");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("]aAutoConnection:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    eg.e("TMSDKBaseContext", localStringBuilder.toString());
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
  
  public static abstract interface IReportListener
  {
    public abstract void onReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.TMSDKBaseContext
 * JD-Core Version:    0.7.0.1
 */