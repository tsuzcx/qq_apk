import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

class sua
  implements arbl.a
{
  sua(stw paramstw, long paramLong, String paramString) {}
  
  public void onCheckOfflineFinish(int paramInt)
  {
    this.this$0.bzc = ((int)(System.currentTimeMillis() - this.val$startTime));
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "onCheckOfflineFinish, cost: " + this.this$0.bzc + ", url: " + jqo.filterKeyForLog(this.aGH, new String[0]));
    }
    this.this$0.bE(this.aGH, paramInt);
    CustomWebView localCustomWebView = this.this$0.mRuntime.getWebView();
    if (localCustomWebView != null)
    {
      localCustomWebView.loadUrlOriginal(this.aGH);
      return;
    }
    QLog.e("OfflinePluginQQ", 1, "error!!!! webview is null, now can not loadUrl " + this.aGH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sua
 * JD-Core Version:    0.7.0.1
 */