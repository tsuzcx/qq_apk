package cooperation.qzone.share;

import aqha;
import aqju;
import awad;
import awae;
import com.tencent.mobileqq.widget.QQToast;

public class QZoneShareActivity$4$2
  implements Runnable
{
  public QZoneShareActivity$4$2(awad paramawad, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      this.a.this$0.hideProgressDialog();
      aqha.a(this.a.this$0, 233, this.a.this$0.getString(2131720156), this.val$finalErrMsg, new awae(this), null).show();
      return;
    }
    this.a.this$0.hideProgressDialog();
    QZoneShareActivity.e(this.a.this$0);
    QQToast.a(this.a.this$0, 1, 2131695940, 1).show();
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */