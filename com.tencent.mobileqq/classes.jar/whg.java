import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class whg
  implements xnv
{
  public whg(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bbgg localbbgg = bbcv.a(this.a, 230);
    if (paramInt == 2) {
      localbbgg.setMessage(2131718896);
    }
    for (;;)
    {
      whh localwhh = new whh(this);
      localbbgg.setPositiveButton(2131694793, localwhh);
      localbbgg.setOnCancelListener(localwhh);
      localbbgg.show();
      return;
      localbbgg.setMessage(2131718905);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    String str = "QR_CODE";
    if (ScannerActivity.a(this.a) != null) {
      str = ScannerActivity.a(this.a).a();
    }
    ScannerActivity.a(this.a, paramInt1, str, paramString, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     whg
 * JD-Core Version:    0.7.0.1
 */