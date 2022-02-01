package cooperation.qzone;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import aqho;
import avrb;

public class QzoneGiftFullScreenViewController$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$2(avrb paramavrb) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.gu.getLayoutParams();
    localLayoutParams.rightMargin = ((int)aqho.convertDpToPixel(avrb.a(this.this$0), 10.0F));
    this.this$0.gu.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.2
 * JD-Core Version:    0.7.0.1
 */