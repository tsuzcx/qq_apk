import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class admg
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public admg(QRScanEntryView paramQRScanEntryView, String paramString, Activity paramActivity) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = new Intent();
      paramBundle.putExtra("detectType", 2);
      paramBundle.putExtra("scannerResult", this.val$result.trim());
      this.val$activity.setResult(13, paramBundle);
      this.val$activity.finish();
      this.val$activity.overridePendingTransition(0, 0);
      QRScanEntryView.a(this.this$0, null);
      QRScanEntryView.a(this.this$0, 0L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, "onLaunchResult 1 false " + this.val$result);
    }
    QRScanEntryView.a(this.this$0, this.val$result);
    QRScanEntryView.a(this.this$0, System.currentTimeMillis());
    ((adkv)this.this$0.a).Gp(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admg
 * JD-Core Version:    0.7.0.1
 */