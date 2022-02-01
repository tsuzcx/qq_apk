package cooperation.vip.qqbanner;

import aajc;
import aajc.a;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import aqnm;
import awij;
import awmo;
import awmq;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(awmq paramawmq, aajc paramaajc) {}
  
  public void run()
  {
    if (this.b == null) {}
    while (!(this.b instanceof awmo)) {
      return;
    }
    awmq.a(this.this$0, (awmo)this.b);
    awmq.a(this.this$0).setText(awmq.a(this.this$0, awmq.a(this.this$0).cRv));
    awmq.b(this.this$0).setText(awmq.b(this.this$0, awmq.a(this.this$0).cRw));
    awmq.a(this.this$0).setTextColor(awmq.a(this.this$0, awmq.a(this.this$0).auH));
    awmq.b(this.this$0).setTextColor(awmq.b(this.this$0, awmq.a(this.this$0).auH));
    aajc.a locala = (aajc.a)this.b.bR.get(2);
    awmq.a(this.this$0, new awij());
    awmq.a(this.this$0).hb(locala.filePath, awmq.a(this.this$0, awmq.a(this.this$0)));
    awmq.a(this.this$0).setScale(aqnm.getScreenWidth() / 720.0F);
    awmq.a(this.this$0).eDG();
    awmq.a(this.this$0).Xb(true);
    awmq.a(this.this$0).Xc(true);
    awmq.a(this.this$0).start();
    awmq.a(this.this$0).setImageDrawable(awmq.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */