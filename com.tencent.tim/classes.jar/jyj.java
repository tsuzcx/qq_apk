import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.CustomWebView.a;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.a;

public class jyj
  implements SwiftBrowserCookieMonster.a
{
  public jyj(CustomWebView paramCustomWebView, CustomWebView.a parama) {}
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.a.mode)
    {
    default: 
      return;
    case 1: 
      this.this$0.loadUrl(paramString);
      return;
    case 2: 
      this.this$0.loadUrlOriginal(paramString);
      return;
    case 3: 
      this.this$0.loadData(paramString, this.a.mimeType, this.a.encoding);
      return;
    }
    this.this$0.loadDataWithBaseURL(paramString, this.a.data, this.a.mimeType, this.a.encoding, this.a.UW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyj
 * JD-Core Version:    0.7.0.1
 */