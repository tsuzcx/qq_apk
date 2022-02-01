import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity.a;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import mqq.app.AppActivity;

class rwa
  extends ScannerActivity.a
{
  rwa(rvz paramrvz) {}
  
  public void doCancel()
  {
    this.a.px.setVisibility(8);
    if (this.a.b.aKm)
    {
      this.a.val$callBack.bwZ();
      return;
    }
    if (this.a.b.aKi)
    {
      this.a.a.finish();
      return;
    }
    this.a.val$callBack.bxa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwa
 * JD-Core Version:    0.7.0.1
 */