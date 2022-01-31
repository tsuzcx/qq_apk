import android.view.View;
import com.tencent.biz.qrcode.CameraManager;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class bta
  implements Runnable
{
  public bta(ScannerActivity paramScannerActivity) {}
  
  public void run()
  {
    int i = this.a.b.getWidth();
    int j = this.a.b.getHeight();
    this.a.a.a(i, j);
    this.a.d = true;
    if ((!this.a.g) && (this.a.h)) {
      this.a.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bta
 * JD-Core Version:    0.7.0.1
 */