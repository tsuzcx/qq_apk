package com.tencent.qqmini.sdk.launcher;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppRuntimeLoaderManager$5
  extends MiniCmdCallback.Stub
{
  AppRuntimeLoaderManager$5(AppRuntimeLoaderManager paramAppRuntimeLoaderManager) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "notify runtime info result " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager.5
 * JD-Core Version:    0.7.0.1
 */