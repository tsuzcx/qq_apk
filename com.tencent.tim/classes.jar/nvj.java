import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.29.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.29.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.io.File;

public class nvj
  extends aquy
{
  public nvj(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onDone(aquz paramaquz)
  {
    Activity localActivity = this.this$0.getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramaquz.errCode == 0)
    {
      paramaquz = new File(aoiz.getFilePath(this.val$url));
      if (paramaquz.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(BridgeModule.TAG, 2, "shareImageToAIO->downloadFile success: " + this.val$url);
        }
        localActivity.runOnUiThread(new BridgeModule.29.1(this, paramaquz));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(BridgeModule.TAG, 2, "shareImageToAIO->downloadFile failed: " + this.val$url);
    }
    localActivity.runOnUiThread(new BridgeModule.29.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvj
 * JD-Core Version:    0.7.0.1
 */