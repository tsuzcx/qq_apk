import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class vuj
  implements xev
{
  public vuj(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bafb localbafb = babr.a(this.a, 230);
    if (paramInt == 2) {
      localbafb.setMessage(2131653069);
    }
    for (;;)
    {
      vuk localvuk = new vuk(this);
      localbafb.setPositiveButton(2131629116, localvuk);
      localbafb.setOnCancelListener(localvuk);
      localbafb.show();
      return;
      localbafb.setMessage(2131653077);
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
 * Qualified Name:     vuj
 * JD-Core Version:    0.7.0.1
 */