import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class ails
  extends WebViewPlugin
{
  public static final String TAG = ails.class.getSimpleName();
  protected skj mClient = skj.a();
  
  public ails()
  {
    this.mPluginNameSpace = "ftssearch";
    this.mClient.bzj();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    while ("ftssearch".equals(paramString2)) {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ails
 * JD-Core Version:    0.7.0.1
 */