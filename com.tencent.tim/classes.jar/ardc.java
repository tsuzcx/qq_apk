import android.support.v4.util.LruCache;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class ardc
  extends LruCache<String, WebSoService.WebSoState>
{
  public ardc(WebSoService paramWebSoService, int paramInt)
  {
    super(paramInt);
  }
  
  protected WebSoService.WebSoState a(String paramString)
  {
    return new WebSoService.WebSoState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardc
 * JD-Core Version:    0.7.0.1
 */