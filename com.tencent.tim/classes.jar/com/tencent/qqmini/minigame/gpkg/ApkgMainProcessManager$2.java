package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class ApkgMainProcessManager$2
  extends MiniCmdCallback.Stub
{
  ApkgMainProcessManager$2(MiniCmdCallback paramMiniCmdCallback) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    if (this.val$cmdCallback != null) {
      this.val$cmdCallback.onCmdResult(paramBoolean, paramBundle);
    }
    QMLog.d("ApkgMainProcessManager", "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.2
 * JD-Core Version:    0.7.0.1
 */