import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.mobileqq.webview.webso.WebSoService.a;

public class ardi
  implements WebSoService.a
{
  public ardi(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, long paramLong) {}
  
  public void onResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.a.resultCode = 10005;
    }
    this.a.czO = paramString;
    this.a.forceRefresh = true;
    this.a.aCu = false;
    this.a.a.eeE = ((int)(System.currentTimeMillis() - this.val$startTime));
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardi
 * JD-Core Version:    0.7.0.1
 */