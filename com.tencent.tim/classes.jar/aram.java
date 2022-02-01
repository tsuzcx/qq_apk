import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class aram
  implements ThreadExcutor.IThreadListener
{
  public aram(WebViewPlugin paramWebViewPlugin) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.d.onPostPluginAsyncTask();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aram
 * JD-Core Version:    0.7.0.1
 */