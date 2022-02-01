import android.text.TextUtils;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aijr
  extends WebViewPlugin
{
  public static final String TAG = aijr.class.getSimpleName();
  
  public aijr()
  {
    this.mPluginNameSpace = "MixSearchWeb";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return false;
    }
    if (!"MixSearchWeb".equals(paramString2)) {
      return false;
    }
    if (("setSearchBarWord".equals(paramString3)) && ((this.mRuntime.b() instanceof MixSearchWebFragment))) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        ((MixSearchWebFragment)this.mRuntime.b()).hm(paramJsBridgeListener.optString("searchWord"), paramJsBridgeListener.optString("placeholder"));
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.e(TAG, 1, "handleJsRequest: e = " + paramJsBridgeListener);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijr
 * JD-Core Version:    0.7.0.1
 */