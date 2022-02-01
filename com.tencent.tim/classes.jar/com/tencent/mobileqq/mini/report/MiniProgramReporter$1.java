package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class MiniProgramReporter$1
  implements MiniAppCmdInterface
{
  MiniProgramReporter$1(MiniProgramReporter paramMiniProgramReporter, List paramList) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      return;
    }
    QLog.e("MiniProgramReporter", 1, "performReportViaSSO onDcReport: sso command failed, try again");
    this.this$0.addAll(this.val$currentlyOperatedSingleDcDataList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.1
 * JD-Core Version:    0.7.0.1
 */