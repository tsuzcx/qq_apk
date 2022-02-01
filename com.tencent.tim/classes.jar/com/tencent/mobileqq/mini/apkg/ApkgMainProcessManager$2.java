package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

final class ApkgMainProcessManager$2
  extends CmdCallback.Stub
{
  ApkgMainProcessManager$2(CmdCallback paramCmdCallback, boolean paramBoolean) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    if (this.val$cmdCallback != null) {
      this.val$cmdCallback.onCmdResult(paramBoolean, paramBundle);
    }
    if ((this.val$isApkg) || (paramBoolean)) {
      QLog.d("ApkgMainProcessManager", 2, "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.2
 * JD-Core Version:    0.7.0.1
 */