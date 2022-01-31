package com.tencent.unipay.plugsdk;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.unipay.plug.IUnipayService;
import com.tencent.unipay.plug.IUnipayService.Stub;

public class UnipayPlugAPI
{
  public static final String ACCOUNT_TYPE_COMMON = "common";
  public static final String ACCOUNT_TYPE_SECURITY = "secrety";
  public static final String PAY_CHANNEL_BANK = "bank";
  public static final String PAY_CHANNEL_WECHAT = "wechat";
  public static IUnipayServiceCallBack unipayPlugCallBack = null;
  private Context ApplicationContext = null;
  private String LOG_TAG = "TencentUnipaySDK";
  private BroadcastReceiver broadcast = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) && (paramAnonymousIntent.getDataString().endsWith("com.tencent.unipay"))) {
        UnipayPlugAPI.this.bindUnipayService();
      }
    }
  };
  private Context context = null;
  private String envParams = "release";
  private boolean isNumVisible = true;
  private boolean logEnable = true;
  private String offerId = "";
  private String propUnit = "";
  private boolean serviceBinded = false;
  private IUnipayService unipayService;
  private ServiceConnection unipayServiceConection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      UnipayPlugAPI.this.unipayService = IUnipayService.Stub.asInterface(paramAnonymousIBinder);
      try
      {
        UnipayPlugAPI.this.unipayService.Initialize();
        UnipayPlugAPI.this.registerCallBack(UnipayPlugAPI.unipayPlugCallBack);
        UnipayPlugAPI.this.serviceBinded = true;
        Log.i(UnipayPlugAPI.this.LOG_TAG, "onServiceConnected ");
        return;
      }
      catch (RemoteException paramAnonymousComponentName) {}
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
  };
  
  public UnipayPlugAPI(Context paramContext)
  {
    this.context = paramContext;
    this.ApplicationContext = paramContext.getApplicationContext();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    localIntentFilter.setPriority(2147483647);
    paramContext.registerReceiver(this.broadcast, localIntentFilter);
  }
  
  private boolean checkUnipayAPP()
  {
    return new UnipayPlugTools(this.context).checkUnipayAPP();
  }
  
  private boolean checkUnipayParams()
  {
    if (this.unipayService == null)
    {
      Log.i(this.LOG_TAG, "service绑定失败,请在回调重新绑定");
      UnipayPlugTools.invokeCallBack(-2, -1, -1, -1, "service绑定失败,请重新绑定", null);
      return false;
    }
    if (unipayPlugCallBack == null)
    {
      Toast.makeText(this.context, "请先注册回调", 0).show();
      return false;
    }
    if (TextUtils.isEmpty(this.envParams))
    {
      UnipayPlugTools.invokeCallBack(-1, -1, -1, -1, "支付环境不能为空", null);
      return false;
    }
    if (TextUtils.isEmpty(this.offerId))
    {
      UnipayPlugTools.invokeCallBack(-1, -1, -1, -1, "offerId不能为空", null);
      return false;
    }
    return true;
  }
  
  private void registerCallBack(IUnipayServiceCallBack paramIUnipayServiceCallBack)
  {
    try
    {
      this.unipayService.registerCallback(paramIUnipayServiceCallBack);
      return;
    }
    catch (RemoteException paramIUnipayServiceCallBack)
    {
      paramIUnipayServiceCallBack.printStackTrace();
    }
  }
  
  public void MPSaveGameCoins(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, byte[] paramArrayOfByte, String paramString10, String paramString11, String paramString12, String paramString13)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.MPSaveGameCoin(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramArrayOfByte, paramString10, paramString11, paramString12, paramString13);
    }
  }
  
  public void MPSaveGoods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9, String paramString10, String paramString11, String paramString12)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.MPSaveGoods(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramArrayOfByte, paramString9, paramString10, paramString11, paramString12);
    }
  }
  
  public void OpenServiceWithNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9, boolean paramBoolean, String paramString10)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.OpenServiceWithNum(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramArrayOfByte, paramString9, paramBoolean, paramString10);
    }
  }
  
  public void OpenServiceWithoutNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.OpenServiceWithoutNum(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramArrayOfByte, paramString9);
    }
  }
  
  public void SaveGameCoinsWithNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, byte[] paramArrayOfByte)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.SaveGameCoinWithNum(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramBoolean, paramArrayOfByte);
    }
  }
  
  public void SaveGameCoinsWithoutNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.SaveGameCoinWithoutNum(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramArrayOfByte);
    }
  }
  
  public void SaveGoods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9)
    throws RemoteException
  {
    if ((checkUnipayAPP()) && (checkUnipayParams()))
    {
      this.unipayService.setOfferId(this.offerId);
      this.unipayService.setEnv(this.envParams);
      this.unipayService.setLogEnable(this.logEnable);
      this.unipayService.setNumberVisible(this.isNumVisible);
      this.unipayService.setPropUnit(this.propUnit);
      this.unipayService.SaveGoods(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramArrayOfByte);
    }
  }
  
  public void bindUnipayService()
  {
    Log.i(this.LOG_TAG, "bindUnipayService");
    try
    {
      Intent localIntent = new Intent("com.tencen.unipay.plug.UnipayPulgService");
      this.ApplicationContext.bindService(localIntent, this.unipayServiceConection, 1);
      return;
    }
    catch (Exception localException)
    {
      Log.i(this.LOG_TAG, "bindUnipayService error");
      this.serviceBinded = false;
    }
  }
  
  public String getUnipayPlugVersion()
  {
    try
    {
      String str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public void setCallBack(IUnipayServiceCallBack paramIUnipayServiceCallBack)
  {
    unipayPlugCallBack = paramIUnipayServiceCallBack;
  }
  
  public void setEnv(String paramString)
  {
    this.envParams = paramString;
  }
  
  public void setLogEnable(boolean paramBoolean)
  {
    this.logEnable = paramBoolean;
  }
  
  public void setNumVisible(boolean paramBoolean)
  {
    this.isNumVisible = paramBoolean;
  }
  
  public void setOfferId(String paramString)
  {
    this.offerId = paramString;
  }
  
  public void setPropUnit(String paramString)
  {
    this.propUnit = paramString;
  }
  
  public void unbindUnipayService()
  {
    Log.i(this.LOG_TAG, "unbindUnipayService");
    try
    {
      if (this.serviceBinded)
      {
        this.context.unregisterReceiver(this.broadcast);
        this.ApplicationContext.unbindService(this.unipayServiceConection);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.unipay.plugsdk.UnipayPlugAPI
 * JD-Core Version:    0.7.0.1
 */