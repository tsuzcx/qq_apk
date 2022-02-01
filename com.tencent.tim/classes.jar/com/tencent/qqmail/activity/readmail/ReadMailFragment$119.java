package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.webkit.WebView.HitTestResult;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewLongClickSaverListener;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadMailFragment$119
  extends QMScaleWebViewController.QMScaleWebViewLongClickSaverListener
{
  ReadMailFragment$119(ReadMailFragment paramReadMailFragment, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  public boolean onLongClick(View paramView)
  {
    int i;
    try
    {
      Object localObject = ((TitleBarWebView2)paramView).getHitTestResult();
      if ((localObject != null) && (((WebView.HitTestResult)localObject).getExtra() != null) && (this.this$0.getActivity() != null))
      {
        i = ((WebView.HitTestResult)localObject).getType();
        if (i != 7) {
          break label140;
        }
        localObject = ((WebView.HitTestResult)localObject).getExtra();
        if ((((String)localObject).startsWith("http://")) || (((String)localObject).startsWith("https://")) || (((String)localObject).startsWith("www.")))
        {
          DataCollector.logEvent("Event_Use_Content_Recognize");
          this.this$0.showUrlDialog((String)localObject);
          OneStepUtils.dragLinkByOneStep(paramView, (String)localObject);
        }
        else if (((String)localObject).startsWith("date:"))
        {
          OneStepUtils.dragTextByOneStep(paramView, android.net.Uri.decode(localObject).replace("date:", "").split(",")[0]);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      return super.onLongClick(paramView);
      label140:
      if ((i == 2) || (i == 4)) {
        OneStepUtils.dragTextByOneStep(paramView, localException.getExtra());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.119
 * JD-Core Version:    0.7.0.1
 */