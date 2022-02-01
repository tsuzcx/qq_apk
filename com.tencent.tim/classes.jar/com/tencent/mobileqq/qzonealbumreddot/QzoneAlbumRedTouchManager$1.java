package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import allp;
import allr;
import altq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import mqq.app.NewIntent;

public class QzoneAlbumRedTouchManager$1
  implements Runnable
{
  public QzoneAlbumRedTouchManager$1(allp paramallp) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    Object localObject = (altq)this.this$0.app.getManager(36);
    String str = String.valueOf(100180);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localObject).getAppInfoByPath(str);
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      ((altq)localObject).OT(str);
      LocalMultiProcConfig.putBool("key_photo_guide_is_red", false);
      QZoneClickReport.startReportImediately(this.this$0.app.getCurrentAccountUin(), "443", "2");
      return;
    }
    localObject = new NewIntent(this.this$0.app.getApplication(), allr.class);
    ((NewIntent)localObject).putExtra("req", new operation_red_touch_req(2L));
    this.this$0.app.startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */