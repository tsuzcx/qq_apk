import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.mobileqq.webview.webso.WebSoService.a;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class arde
  implements WebSoService.a
{
  public arde(WebSoService paramWebSoService, long paramLong, WebSoService.WebSoState paramWebSoState, Handler paramHandler, String paramString) {}
  
  public void onResult(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSoService", 2, "verifyHtmlData cost=" + (System.currentTimeMillis() - this.val$time));
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.a != null) && (this.a.cm.get() != 2))
    {
      this.a.a.cYZ = true;
      this.a.czO = paramString;
      this.a.cZe = true;
      this.a.aCu = true;
      this.a.aPr = false;
      ardk.Wo("load from cache");
      WebSoService.a(this.this$0, this.val$handler, this.a);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 1, new String[] { this.val$url });
      return;
    }
    VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 0, new String[] { this.val$url });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arde
 * JD-Core Version:    0.7.0.1
 */