package com.tencent.mobileqq.widget;

import alcn;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

class ProfileCardMoreInfoView$2
  implements Runnable
{
  ProfileCardMoreInfoView$2(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.this$0.a.e.uin))
      {
        Object localObject = this.this$0.a.e.uin;
        if (this.this$0.a.e.uin.startsWith("+")) {
          localObject = this.this$0.a.e.uin.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 2, Long.valueOf((String)localObject).longValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.2
 * JD-Core Version:    0.7.0.1
 */