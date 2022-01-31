import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;

public class tij
  implements Runnable
{
  public tij(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    WebViewTitleStyleHelper.a().a(BaseApplicationImpl.sApplication.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tij
 * JD-Core Version:    0.7.0.1
 */