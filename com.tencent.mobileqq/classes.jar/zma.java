import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class zma
  implements zmu
{
  public zma(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    QQCustomDialog localQQCustomDialog = bhdj.a(this.a, 230);
    if (paramInt == 2) {
      localQQCustomDialog.setMessage(2131718188);
    }
    for (;;)
    {
      zmb localzmb = new zmb(this);
      localQQCustomDialog.setPositiveButton(2131694399, localzmb);
      localQQCustomDialog.setOnCancelListener(localzmb);
      localQQCustomDialog.show();
      return;
      localQQCustomDialog.setMessage(2131718198);
    }
  }
  
  public void a(ScannerResult paramScannerResult, int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a, paramScannerResult, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zma
 * JD-Core Version:    0.7.0.1
 */