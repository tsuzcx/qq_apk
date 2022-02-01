import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.util.QZLog;

public class awhb
  extends awfr
{
  public static String METHOD_NAME = "setPGCNavViewSetting";
  public static String PKG_NAME = "Qzone";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(PKG_NAME)) || (!METHOD_NAME.equals(paramString3))) {
      return false;
    }
    QZLog.i("QzoneHomePageJsPlugin", 4, "navigation url:" + paramString1 + " pkgName:" + paramString2 + " method:" + paramString3 + " jsonString:" + paramVarArgs[0]);
    paramJsBridgeListener = new Intent("JsCallReflushNavigationBar");
    paramJsBridgeListener.putExtra("navigationBar", paramVarArgs[0]);
    if ((this.f != null) && (this.f.mRuntime != null) && (this.f.mRuntime.getActivity() != null)) {
      this.f.mRuntime.getActivity().sendBroadcast(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhb
 * JD-Core Version:    0.7.0.1
 */