import android.text.TextUtils;
import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class avnb
  implements ReaderJsCallback
{
  avnb(avna paramavna) {}
  
  public void onCallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      avna.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    if (paramReaderBaseWebViewPlugin != null) {
      paramReaderBaseWebViewPlugin.init(this.a.mRuntime, avna.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnb
 * JD-Core Version:    0.7.0.1
 */