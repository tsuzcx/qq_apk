import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class admf
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public admf(QRScanEntryView paramQRScanEntryView, String paramString1, String paramString2) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = new Intent();
      paramBundle.putExtra("detectType", 2);
      paramBundle.putExtra("scannerResult", this.aWc.trim());
      paramBundle.putExtra("filePath", this.val$filePath);
      ((Activity)this.this$0.mContext).setResult(13, paramBundle);
      ((Activity)this.this$0.mContext).finish();
      ((Activity)this.this$0.mContext).overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, "onLaunchResult 2 false");
    }
    ((adkv)this.this$0.a).Gp(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admf
 * JD-Core Version:    0.7.0.1
 */