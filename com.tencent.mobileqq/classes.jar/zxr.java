import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class zxr
  implements abhw
{
  public zxr(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bhpc localbhpc = bhlq.a(this.a, 230);
    if (paramInt == 2) {
      localbhpc.setMessage(2131717570);
    }
    for (;;)
    {
      zxs localzxs = new zxs(this);
      localbhpc.setPositiveButton(2131694098, localzxs);
      localbhpc.setOnCancelListener(localzxs);
      localbhpc.show();
      return;
      localbhpc.setMessage(2131717579);
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
 * Qualified Name:     zxr
 * JD-Core Version:    0.7.0.1
 */