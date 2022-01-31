import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class xvv
  implements zcl
{
  public xvv(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    bdfq localbdfq = bdcd.a(this.a, 230);
    if (paramInt == 2) {
      localbdfq.setMessage(2131719383);
    }
    for (;;)
    {
      xvw localxvw = new xvw(this);
      localbdfq.setPositiveButton(2131694951, localxvw);
      localbdfq.setOnCancelListener(localxvw);
      localbdfq.show();
      return;
      localbdfq.setMessage(2131719392);
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
 * Qualified Name:     xvv
 * JD-Core Version:    0.7.0.1
 */