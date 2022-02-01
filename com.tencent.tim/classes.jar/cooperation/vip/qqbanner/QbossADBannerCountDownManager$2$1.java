package cooperation.vip.qqbanner;

import android.text.TextUtils;
import android.widget.TextView;
import awmm;
import awmn;
import cooperation.qzone.util.QZLog;

class QbossADBannerCountDownManager$2$1
  implements Runnable
{
  QbossADBannerCountDownManager$2$1(QbossADBannerCountDownManager.2 param2) {}
  
  public void run()
  {
    if ((awmn.c(this.a.this$0) == null) || (TextUtils.isEmpty(awmn.c(this.a.this$0).getText()))) {}
    Object localObject;
    do
    {
      return;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerManager", 2, "count down text = " + awmn.c(this.a.this$0).getText());
      }
      localObject = awmn.c(this.a.this$0).getText().toString().split(":");
      if ((localObject != null) && (localObject.length == 2)) {
        break;
      }
      awmn.b(this.a.this$0);
    } while (!QZLog.isColorLevel());
    QZLog.i("QbossADBannerManager", 2, "stopTimer split error text = " + awmn.c(this.a.this$0).getText());
    return;
    for (;;)
    {
      int i;
      int j;
      try
      {
        int k = Integer.valueOf(localObject[0]).intValue();
        int m = Integer.valueOf(localObject[1]).intValue() - 1;
        i = m;
        j = k;
        if (m >= 0) {
          break label305;
        }
        i = 59;
        j = k - 1;
      }
      catch (Exception localException)
      {
        awmn localawmn;
        localException.printStackTrace();
        return;
      }
      localawmn = this.a.this$0;
      if (awmn.a(this.a.this$0) != null)
      {
        localObject = awmn.a(this.a.this$0).cRz;
        awmn.a(localawmn, (String)localObject);
        awmn.b(this.a.this$0);
        return;
      }
      String str = "";
      continue;
      label305:
      do
      {
        awmn.a(this.a.this$0, awmn.a(this.a.this$0, j, i));
        return;
        if (j < 0) {
          break;
        }
      } while (i >= 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.2.1
 * JD-Core Version:    0.7.0.1
 */