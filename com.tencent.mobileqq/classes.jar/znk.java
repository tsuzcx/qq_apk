import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class znk
  implements Runnable
{
  public znk(ThemeHandler paramThemeHandler) {}
  
  public void run()
  {
    QQToast.a(this.a.a.getApplication(), "主题资源异常，为你恢复默认主题", 4000).a();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znk
 * JD-Core Version:    0.7.0.1
 */