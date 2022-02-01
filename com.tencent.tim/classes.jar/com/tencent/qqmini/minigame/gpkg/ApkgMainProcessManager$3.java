package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class ApkgMainProcessManager$3
  extends MiniCmdCallback.Stub
{
  ApkgMainProcessManager$3(MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    QMLog.d("ApkgMainProcessManager", "queueSubProcessLoadTask() called with: miniAppConfig = [" + this.val$miniAppConfig + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.3
 * JD-Core Version:    0.7.0.1
 */