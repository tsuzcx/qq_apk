package cooperation.qzone.webviewplugin;

import acfp;
import android.app.Activity;
import android.content.Context;
import aqha;
import aqju;
import awga;
import awgc;
import awgd;
import awge;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(awgc paramawgc) {}
  
  public void run()
  {
    awga.a(this.a.this$0, this.a.val$args[0]);
    Activity localActivity = this.a.this$0.f.mRuntime.getActivity();
    if (awga.a(this.a.this$0) == null) {
      awga.a(this.a.this$0, aqha.a(localActivity, 230).setTitle(acfp.m(2131713331)).setMessage(acfp.m(2131713334)).setPositiveButton(acfp.m(2131713332), new awge(this)).setNegativeButton(localActivity.getString(2131718138), new awgd(this)));
    }
    if (!awga.a(this.a.this$0).isShowing()) {
      awga.a(this.a.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */