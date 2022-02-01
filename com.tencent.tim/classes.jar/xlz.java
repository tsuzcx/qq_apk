import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;

class xlz
  implements View.OnClickListener
{
  xlz(xlx paramxlx) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.mContext instanceof Activity)) && (this.a.sessionInfo != null) && (this.a.app != null))
    {
      Object localObject = new QZoneClickReport.a();
      ((QZoneClickReport.a)localObject).actionType = "330";
      ((QZoneClickReport.a)localObject).cMI = "3";
      ((QZoneClickReport.a)localObject).reserves = "2";
      QZoneClickReport.startReportImediately(this.a.app.getAccount(), (QZoneClickReport.a)localObject);
      localObject = avpw.d.a();
      avpw.a((Activity)this.a.mContext, (avpw.d)localObject, this.a.sessionInfo.aTl, 0, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlz
 * JD-Core Version:    0.7.0.1
 */