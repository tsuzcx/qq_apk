package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppRealTimeLogReporter$1
  implements AsyncResult
{
  MiniAppRealTimeLogReporter$1(MiniAppRealTimeLogReporter paramMiniAppRealTimeLogReporter) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppRealTimeLogReporter", "realTimeLogReport  ReportLog isSuc: " + paramBoolean + "  ret:" + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter.1
 * JD-Core Version:    0.7.0.1
 */