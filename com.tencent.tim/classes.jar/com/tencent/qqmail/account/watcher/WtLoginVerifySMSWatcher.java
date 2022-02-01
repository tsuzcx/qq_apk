package com.tencent.qqmail.account.watcher;

import moai.core.watcher.Watchers.Watcher;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract interface WtLoginVerifySMSWatcher
  extends Watchers.Watcher
{
  public abstract void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg);
  
  public abstract void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.watcher.WtLoginVerifySMSWatcher
 * JD-Core Version:    0.7.0.1
 */