package com.tencent.mobileqq.msf.core.wtlogin;

import android.os.RemoteException;
import com.tencent.qphone.base.remote.IWtloginServiceCallbacker.Stub;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class MsfWtloginServiceListener
  extends IWtloginServiceCallbacker.Stub
{
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnException(String paramString, int paramInt)
    throws RemoteException
  {}
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt2, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnRefreshPictureData(String paramString, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
    throws RemoteException
  {}
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
    throws RemoteException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.wtlogin.MsfWtloginServiceListener
 * JD-Core Version:    0.7.0.1
 */