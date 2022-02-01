package dov.com.qq.im.ae.play;

import axbu;
import axgi;
import axif;
import mqq.util.WeakReference;

public class PlayDownloadManagerWrap$2
  implements Runnable
{
  public PlayDownloadManagerWrap$2(axif paramaxif, axbu paramaxbu) {}
  
  public void run()
  {
    if (this.n.eEy == 0) {
      if ((axif.a(this.this$0) != null) && (axif.a(this.this$0).get() != null))
      {
        axgn.k = this.n;
        ((axgi)axif.a(this.this$0).get()).p(393218, new Object[] { this.n });
      }
    }
    while (((this.n.eEy != 4) && (this.n.eEy != 5) && (this.n.eEy != 6) && (this.n.eEy != 7)) || (axif.a(this.this$0) == null) || (axif.a(this.this$0).get() == null)) {
      return;
    }
    ((axgi)axif.a(this.this$0).get()).p(655361, new Object[] { this.n });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */