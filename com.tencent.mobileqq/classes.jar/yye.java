import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtCgiReportRunnable;
import com.tencent.mobileqq.app.ThreadManager;

public class yye
{
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GdtCgiReportRunnable(paramString), 2, null, false);
    yxs.b("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yye
 * JD-Core Version:    0.7.0.1
 */