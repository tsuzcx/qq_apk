package cooperation.qzone;

import android.view.View;
import avrb;
import avrb.a;
import avrb.b;
import avrd;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(avrd paramavrd) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.this$0.b).setBackgroundColor(0);
    avrb.a(this.a.this$0);
    this.a.a.GB();
    if (avrb.a(this.a.this$0).size() > 0)
    {
      avrb.b localb = (avrb.b)avrb.a(this.a.this$0).get(0);
      this.a.this$0.a(localb.cNg, localb.cNh, localb.dou, localb.b);
      avrb.a(this.a.this$0).remove(localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */