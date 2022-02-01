import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class yxc
  implements aaeh
{
  public yxc(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    QQCustomDialog localQQCustomDialog = bfur.a(this.a, 230);
    if (paramInt == 2) {
      localQQCustomDialog.setMessage(2131717806);
    }
    for (;;)
    {
      yxd localyxd = new yxd(this);
      localQQCustomDialog.setPositiveButton(2131694201, localyxd);
      localQQCustomDialog.setOnCancelListener(localyxd);
      localQQCustomDialog.show();
      return;
      localQQCustomDialog.setMessage(2131717815);
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
 * Qualified Name:     yxc
 * JD-Core Version:    0.7.0.1
 */