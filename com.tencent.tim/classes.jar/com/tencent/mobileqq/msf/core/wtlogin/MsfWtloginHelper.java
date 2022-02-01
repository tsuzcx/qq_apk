package com.tencent.mobileqq.msf.core.wtlogin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.IWtloginService;
import com.tencent.qphone.base.remote.IWtloginServiceCallbacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class MsfWtloginHelper
{
  private static final String WTSERVICENAME = "com.tencent.mobileqq.msf.core.wtlogin.WtLoginService";
  private static AtomicInteger helperSeq = new AtomicInteger(new Random().nextInt(100000));
  private static final String tag = "MsfWtloginHelper";
  protected volatile IWtloginService _baseService;
  protected ServiceConnection conn = new b(this);
  String helperTag;
  private WtloginHelper localWtloginHelper;
  String processName = "";
  IWtloginServiceCallbacker subRemoteWtloginListener;
  WtServiceBindListener wtServiceBindListener;
  
  public MsfWtloginHelper(Context paramContext, IWtloginServiceCallbacker paramIWtloginServiceCallbacker, WtServiceBindListener paramWtServiceBindListener)
  {
    this.subRemoteWtloginListener = paramIWtloginServiceCallbacker;
    this.processName = MsfSdkUtils.getProcessName(paramContext);
    this.helperTag = (this.processName + "_" + helperSeq.incrementAndGet());
    this.localWtloginHelper = new WtloginHelper(paramContext, MsfWtloginPrivacyListenerImpl.getSingleton());
    this.wtServiceBindListener = paramWtServiceBindListener;
    new a(this).start();
  }
  
  private void onWtloginServiceConnected()
  {
    if (this.wtServiceBindListener != null) {
      this.wtServiceBindListener.onBindFinished();
    }
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.CheckPictureAndGetSt(this.helperTag, paramString, paramArrayOfByte, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.CheckSMSAndGetSt(this.helperTag, paramString, paramArrayOfByte, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public Boolean ClearUserFastLoginData(String paramString, long paramLong)
  {
    return this.localWtloginHelper.ClearUserLoginData(paramString, paramLong);
  }
  
  public int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, List paramList, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.CloseCode(this.helperTag, paramString, paramLong, paramArrayOfByte, paramInt, paramList, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public int GetA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo)
    throws Exception
  {
    return this._baseService.GetA1WithA1(this.helperTag, paramString, paramLong1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, this.subRemoteWtloginListener);
  }
  
  public List GetAllLoginInfo()
  {
    return this.localWtloginHelper.GetAllLoginInfo();
  }
  
  public Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    return this.localWtloginHelper.GetBasicUserInfo(paramString, paramWloginSimpleInfo);
  }
  
  public DevlockInfo GetDevLockInfo(String paramString)
  {
    return this.localWtloginHelper.GetDevLockInfo(paramString);
  }
  
  public DevlockInfo GetDevLockInfo(String paramString, long paramLong)
  {
    return this.localWtloginHelper.GetDevLockInfo(paramString, paramLong);
  }
  
  public WUserSigInfo GetLocalSig(String paramString, long paramLong)
  {
    return this.localWtloginHelper.GetLocalSig(paramString, paramLong);
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.GetStWithPasswd(this.helperTag, paramString1, paramLong, paramString2, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.GetStWithoutPasswd(this.helperTag, paramString, paramLong1, paramLong2, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public boolean IsNeedLoginWithPasswd(String paramString, int paramInt)
  {
    return this.localWtloginHelper.IsNeedLoginWithPasswd(paramString, paramInt).booleanValue();
  }
  
  public boolean IsUserHaveA1(String paramString, long paramLong)
  {
    return this.localWtloginHelper.IsUserHaveA1(paramString, paramLong).booleanValue();
  }
  
  public boolean IsWtLoginUrl(String paramString)
  {
    return this.localWtloginHelper.IsWtLoginUrl(paramString);
  }
  
  public int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.RefreshPictureData(this.helperTag, paramString, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public int RefreshSMSData(String paramString, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.RefreshSMSData(this.helperTag, paramString, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public void SetTestHost(int paramInt, String paramString)
    throws Exception
  {
    this._baseService.setTestHost(this.helperTag, paramInt, paramString, this.subRemoteWtloginListener);
  }
  
  public int VerifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo)
    throws Exception
  {
    return this._baseService.VerifyCode(this.helperTag, paramString, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, paramInt, paramWUserSigInfo, this.subRemoteWtloginListener);
  }
  
  public boolean bindWtLoginService(String paramString)
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), paramString);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.processName);
      bool = BaseApplication.getContext().bindService(localIntent, this.conn, 1);
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      try
      {
        QLog.d("MsfWtloginHelper", 2, " bind " + paramString + " service finished " + bool);
        return bool;
      }
      catch (Exception paramString)
      {
        boolean bool;
        break label96;
      }
      paramString = paramString;
      bool = false;
    }
    label96:
    return bool;
  }
  
  public String getHelperTag()
  {
    return this.helperTag;
  }
  
  public byte[] getPkgSigFromApkName(Context paramContext, String paramString)
  {
    return util.getPkgSigFromApkName(paramContext, paramString);
  }
  
  public void refreLocalHelper(Context paramContext)
  {
    this.localWtloginHelper = new WtloginHelper(paramContext, MsfWtloginPrivacyListenerImpl.getSingleton());
  }
  
  public void setHelperTag(String paramString)
  {
    this.helperTag = paramString;
  }
  
  public void unBindWtLoginService()
  {
    try
    {
      this._baseService.removeRemoteHelper(this.helperTag);
      BaseApplication.getContext().unbindService(this.conn);
      this._baseService = null;
      QLog.d("MsfWtloginHelper", 2, " unbindService service finished");
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MsfWtloginHelper", 2, " unbindService service error " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.wtlogin.MsfWtloginHelper
 * JD-Core Version:    0.7.0.1
 */