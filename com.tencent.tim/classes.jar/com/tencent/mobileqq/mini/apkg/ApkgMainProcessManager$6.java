package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

final class ApkgMainProcessManager$6
  extends CmdCallback.Stub
{
  ApkgMainProcessManager$6(MiniAppConfig paramMiniAppConfig) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    QLog.d("ApkgMainProcessManager", 2, "removeSubProcessLoadTask() called with: miniAppConfig = [" + this.val$miniAppConfig + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.6
 * JD-Core Version:    0.7.0.1
 */