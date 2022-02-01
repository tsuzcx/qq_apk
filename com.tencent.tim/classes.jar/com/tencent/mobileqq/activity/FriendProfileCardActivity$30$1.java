package com.tencent.mobileqq.activity;

import alcn;
import android.text.TextUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import uzn;

public class FriendProfileCardActivity$30$1
  implements Runnable
{
  public FriendProfileCardActivity$30$1(uzn paramuzn) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a.this$0.a.e.uin))
      {
        Object localObject = this.a.this$0.a.e.uin;
        if (this.a.this$0.a.e.uin.startsWith("+")) {
          localObject = this.a.this$0.a.e.uin.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 3, Long.valueOf((String)localObject).longValue());
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("QzoneReport", "makeOrRefreshQZone", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.30.1
 * JD-Core Version:    0.7.0.1
 */