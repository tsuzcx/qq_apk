import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

public class awfl
  extends awfr
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {}
    while (!"jumpQQCleanPage".equalsIgnoreCase(paramString3)) {
      return false;
    }
    if (this.f.mRuntime.getActivity() != null)
    {
      QQSettingCleanActivity.dg(this.f.mRuntime.getActivity());
      return true;
    }
    QLog.e("jumpCleanPage", 2, "call activity with null runtime");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfl
 * JD-Core Version:    0.7.0.1
 */