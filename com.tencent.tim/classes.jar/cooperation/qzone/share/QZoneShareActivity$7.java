package cooperation.qzone.share;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QZoneShareData;
import mqq.os.MqqHandler;

class QZoneShareActivity$7
  implements Runnable
{
  QZoneShareActivity$7(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if ((this.this$0.app != null) && (QZoneShareActivity.a(this.this$0).appid > 0L) && (!TextUtils.isEmpty(QZoneShareActivity.a(this.this$0).pkgname)) && (!this.this$0.a(this.this$0.app, QZoneShareActivity.a(this.this$0).appid, QZoneShareActivity.a(this.this$0).pkgname))) {
      return;
    }
    int i = this.this$0.fQ();
    int j = this.this$0.fP();
    ThreadManager.getUIHandler().post(new QZoneShareActivity.7.1(this, i, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.7
 * JD-Core Version:    0.7.0.1
 */