package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener;

class MiniAppCmdServlet$1
  implements BaseLibManager.UpdateListener
{
  MiniAppCmdServlet$1(MiniAppCmdServlet paramMiniAppCmdServlet, MiniCmdCallback paramMiniCmdCallback, String paramString) {}
  
  public void onUpdateResult(int paramInt)
  {
    if (this.val$callback == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      try
      {
        this.val$callback.onCmdResult(true, new Bundle());
        return;
      }
      catch (Exception localException)
      {
        QMLog.e("MiniAppCmdServlet", "cmd response exception. cmd=" + this.val$cmd, localException);
        return;
      }
    }
    this.val$callback.onCmdResult(false, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.MiniAppCmdServlet.1
 * JD-Core Version:    0.7.0.1
 */