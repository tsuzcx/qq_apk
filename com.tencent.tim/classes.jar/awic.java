import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class awic
  implements awhy.a
{
  awic(awib paramawib, IWebviewListener paramIWebviewListener) {}
  
  public void onPageFinished()
  {
    if (awib.a(this.b) == null) {}
    do
    {
      return;
      if (awib.a(this.b).getVisibility() != 0) {
        awib.a(this.b).setVisibility(0);
      }
    } while (this.a == null);
    this.a.onPageFinished();
  }
  
  public void onReceiveError(int paramInt, String paramString1, String paramString2)
  {
    if (this.a != null) {
      this.a.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awic
 * JD-Core Version:    0.7.0.1
 */