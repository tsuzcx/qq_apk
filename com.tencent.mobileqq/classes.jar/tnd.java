import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;

public class tnd
  implements Runnable
{
  public tnd(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    WebViewTitleStyleHelper.a().a(BaseApplicationImpl.sApplication.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnd
 * JD-Core Version:    0.7.0.1
 */