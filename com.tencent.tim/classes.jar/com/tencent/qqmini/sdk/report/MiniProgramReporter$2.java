package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONObject;

class MiniProgramReporter$2
  implements AsyncResult
{
  MiniProgramReporter$2(MiniProgramReporter paramMiniProgramReporter, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QMLog.d("MiniProgramReporter", "performDataReportViaSSO  onDcReport() called with: isSuc = [true], ret = [" + paramJSONObject + "]");
      return;
    }
    QMLog.e("MiniProgramReporter", "performDataReportViaSSO onDcReport: sso command failed, try again");
    this.this$0.addDataAll(this.val$currentlyOperatedSingleDcDataList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.2
 * JD-Core Version:    0.7.0.1
 */