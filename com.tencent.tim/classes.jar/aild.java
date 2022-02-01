import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin.28.1;
import com.tencent.mobileqq.jsp.UiApiPlugin.28.2;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aild
  extends aquy
{
  public aild(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onDone(aquz paramaquz)
  {
    Activity localActivity = this.this$0.mRuntime.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramaquz.errCode == 0)
    {
      paramaquz = new File(aoiz.getFilePath(this.val$url));
      if (paramaquz.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile success: " + this.val$url);
        }
        localActivity.runOnUiThread(new UiApiPlugin.28.1(this, paramaquz));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile failed: " + this.val$url);
    }
    localActivity.runOnUiThread(new UiApiPlugin.28.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aild
 * JD-Core Version:    0.7.0.1
 */