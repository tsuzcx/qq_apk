import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class yae
  implements zha
{
  public yae(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bdjz localbdjz = bdgm.a(this.a, 230);
    if (paramInt == 2) {
      localbdjz.setMessage(2131719395);
    }
    for (;;)
    {
      yaf localyaf = new yaf(this);
      localbdjz.setPositiveButton(2131694953, localyaf);
      localbdjz.setOnCancelListener(localyaf);
      localbdjz.show();
      return;
      localbdjz.setMessage(2131719404);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yae
 * JD-Core Version:    0.7.0.1
 */