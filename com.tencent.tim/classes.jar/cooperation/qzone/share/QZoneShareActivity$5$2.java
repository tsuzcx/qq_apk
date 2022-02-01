package cooperation.qzone.share;

import awaf;
import com.tencent.mobileqq.widget.QQToast;

public class QZoneShareActivity$5$2
  implements Runnable
{
  public QZoneShareActivity$5$2(awaf paramawaf, String paramString, long paramLong) {}
  
  public void run()
  {
    this.a.this$0.hideProgressDialog();
    QQToast.a(this.a.this$0, 1, this.val$errMsg + "(" + this.val$retCode + ")", 1).show();
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.5.2
 * JD-Core Version:    0.7.0.1
 */