import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class aquh
  extends EmojiUiPlugin
{
  public void OnActivityCreate()
  {
    this.mActivityType = 2;
    super.OnActivityCreate();
  }
  
  public void OnActivityPause()
  {
    super.OnActivityPause();
    this.mRuntime.getWebView().loadUrl("javascript:var webviewEvent = document.createEvent('Events');webviewEvent.initEvent('webviewobserve');webviewEvent.name = 'stopAudio';document.dispatchEvent(webviewEvent);");
  }
  
  public long getPluginBusiness()
  {
    return 8L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquh
 * JD-Core Version:    0.7.0.1
 */