import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class ztw
  implements abdt
{
  public ztw(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bgpa localbgpa = bglp.a(this.a, 230);
    if (paramInt == 2) {
      localbgpa.setMessage(2131717439);
    }
    for (;;)
    {
      ztx localztx = new ztx(this);
      localbgpa.setPositiveButton(2131694081, localztx);
      localbgpa.setOnCancelListener(localztx);
      localbgpa.show();
      return;
      localbgpa.setMessage(2131717448);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztw
 * JD-Core Version:    0.7.0.1
 */