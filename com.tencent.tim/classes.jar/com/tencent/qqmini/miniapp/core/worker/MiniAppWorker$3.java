package com.tencent.qqmini.miniapp.core.worker;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class MiniAppWorker$3
  implements JsContext.ExceptionHandler
{
  MiniAppWorker$3(MiniAppWorker paramMiniAppWorker) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    QMLog.e("minisdk-worker", "X5Exception:" + paramJsError.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.3
 * JD-Core Version:    0.7.0.1
 */