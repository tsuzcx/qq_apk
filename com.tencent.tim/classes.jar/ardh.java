import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.mobileqq.webview.webso.WebSoService.a;

public class ardh
  implements WebSoService.a
{
  public ardh(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState) {}
  
  public void onResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.a.resultCode = 10004;
    }
    this.a.czO = paramString;
    this.a.aPr = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardh
 * JD-Core Version:    0.7.0.1
 */