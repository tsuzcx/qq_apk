package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class InnerAppReportDc4239$1
  implements Runnable
{
  InnerAppReportDc4239$1(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.report(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), this.val$path, "inner_app", "from_api", this.val$reservesAction, this.val$reserves2, this.val$reserves3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.InnerAppReportDc4239.1
 * JD-Core Version:    0.7.0.1
 */