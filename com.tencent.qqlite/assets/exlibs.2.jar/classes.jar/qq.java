import android.graphics.Rect;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.widgets.ScannerView;

public class qq
  implements Runnable
{
  public qq(ScannerActivity paramScannerActivity) {}
  
  public void run()
  {
    Rect localRect = this.a.a();
    this.a.a.setViewFinder(localRect.left, localRect.top, localRect.right, localRect.bottom);
    if (!this.a.f) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     qq
 * JD-Core Version:    0.7.0.1
 */