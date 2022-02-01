import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.mobileqq.webview.webso.WebSoService.a;
import java.util.concurrent.atomic.AtomicInteger;

public class ardf
  implements WebSoService.a
{
  public ardf(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, long paramLong) {}
  
  public void onResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.a.resultCode = 10003;
    }
    this.a.czO = paramString;
    if ((!TextUtils.isEmpty(this.a.czY)) && (this.a.cn.get() == 1)) {
      this.a.cZg = true;
    }
    for (;;)
    {
      this.a.aCu = false;
      this.a.a.eeE = ((int)(System.currentTimeMillis() - this.val$startTime));
      this.this$0.a(this.a);
      return;
      this.a.forceRefresh = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardf
 * JD-Core Version:    0.7.0.1
 */