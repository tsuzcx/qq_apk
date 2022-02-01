package cooperation.qqreader.host.webview;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public abstract class ReaderBaseWebViewPlugin
  extends WebViewPlugin
{
  private Context ac;
  private JsBridgeListener d;
  
  public ReaderBaseWebViewPlugin()
  {
    this.mPluginNameSpace = getNamespace();
  }
  
  public Context getContext()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.getActivity();
    }
    if (this.ac != null) {
      return this.ac;
    }
    return null;
  }
  
  protected String getNamespace()
  {
    return getClass().getSimpleName();
  }
  
  @Nullable
  public ReaderWebView getWebView()
  {
    if (this.mRuntime != null) {
      return (ReaderWebView)this.mRuntime.getWebView();
    }
    return null;
  }
  
  @Deprecated
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(getNamespace()))) {
      return false;
    }
    this.d = paramJsBridgeListener;
    return handleJsRequest(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected abstract boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  public void init(Context paramContext, JsBridgeListener paramJsBridgeListener)
  {
    this.ac = paramContext;
    this.d = paramJsBridgeListener;
    this.mRuntime = null;
    onCreate();
  }
  
  public void init(WebViewPlugin.a parama, JsBridgeListener paramJsBridgeListener)
  {
    this.mRuntime = parama;
    this.d = paramJsBridgeListener;
    this.ac = null;
    onCreate();
  }
  
  protected void onJsComplete(Object paramObject)
  {
    if (this.d != null) {
      this.d.onComplete(paramObject);
    }
  }
  
  protected void onJsError(String paramString)
  {
    if (this.d != null) {
      this.d.onError(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */