package cooperation.qzone.share;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QZoneShareActivity$14
  implements Runnable
{
  QZoneShareActivity$14(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    int i = this.this$0.fQ();
    int j = this.this$0.fP();
    ThreadManager.getUIHandler().post(new QZoneShareActivity.14.1(this, i - j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14
 * JD-Core Version:    0.7.0.1
 */