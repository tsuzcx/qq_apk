import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class aile
  extends aquy
{
  public aile(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(aquz paramaquz)
  {
    Activity localActivity = this.this$0.mRuntime.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramaquz.errCode == 0)
    {
      paramaquz = aoiz.getFilePath(this.val$imageUrl);
      if (new File(paramaquz).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.val$imageUrl);
        }
        this.this$0.a(this.val$json, paramaquz, 0);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile failed: " + this.val$imageUrl);
    }
    this.this$0.a(this.val$json, null, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aile
 * JD-Core Version:    0.7.0.1
 */