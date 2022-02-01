import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.LinearLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class ahva
  extends ahvi
{
  public ahva(QQGameFeedWebFragment paramQQGameFeedWebFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.this$0.parsePageEndTime = SystemClock.elapsedRealtime();
    super.onPageFinished(paramWebView, paramString);
    QQGameFeedWebFragment.a(this.this$0).setVisibility(0);
    QQGameFeedWebFragment.a(this.this$0).setVisibility(8);
    if ((this.this$0.isAdded()) && (QQGameFeedWebFragment.a(this.this$0) != null)) {
      QQGameFeedWebFragment.a(this.this$0).KC(true);
    }
    QLog.d("GameWebPage", 4, "-->web onPageFinished");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.this$0.loadUrlEndTime = SystemClock.elapsedRealtime();
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahva
 * JD-Core Version:    0.7.0.1
 */