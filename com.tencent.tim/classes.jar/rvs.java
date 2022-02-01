import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.widgets.ScannerView.b;

public class rvs
  implements ScannerView.b
{
  public rvs(ScannerActivity paramScannerActivity) {}
  
  public void yc(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.aKh = false;
    ScannerActivity.a(this.a).setVisibility(8);
    aqju localaqju = aqha.a(this.a, 230);
    if (paramInt == 2) {
      localaqju.setMessage(2131719027);
    }
    for (;;)
    {
      rvt localrvt = new rvt(this);
      localaqju.setPositiveButton(2131721079, localrvt);
      localaqju.setOnCancelListener(localrvt);
      localaqju.show();
      return;
      localaqju.setMessage(2131719036);
    }
  }
  
  public void z(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.aKh = false;
    String str = "QR_CODE";
    if (ScannerActivity.a(this.a) != null) {
      str = ScannerActivity.a(this.a).ni();
    }
    ScannerActivity.a(this.a, paramInt1, str, paramString, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvs
 * JD-Core Version:    0.7.0.1
 */