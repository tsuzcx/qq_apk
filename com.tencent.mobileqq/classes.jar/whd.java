import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class whd
  implements xns
{
  public whd(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bbgu localbbgu = bbdj.a(this.a, 230);
    if (paramInt == 2) {
      localbbgu.setMessage(2131718907);
    }
    for (;;)
    {
      whe localwhe = new whe(this);
      localbbgu.setPositiveButton(2131694794, localwhe);
      localbbgu.setOnCancelListener(localwhe);
      localbbgu.show();
      return;
      localbbgu.setMessage(2131718916);
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
 * Qualified Name:     whd
 * JD-Core Version:    0.7.0.1
 */