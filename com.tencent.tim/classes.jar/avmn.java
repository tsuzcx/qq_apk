import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class avmn
  implements ReaderJsCallback
{
  avmn(avml paramavml) {}
  
  public void onCallback(String paramString1, String paramString2) {}
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    paramReaderBaseWebViewPlugin.init(avml.a(this.a), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmn
 * JD-Core Version:    0.7.0.1
 */