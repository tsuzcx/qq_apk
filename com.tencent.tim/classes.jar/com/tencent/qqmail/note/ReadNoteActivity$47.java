package com.tencent.qqmail.note;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView.HitTestResult;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewLongClickSaverListener;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadNoteActivity$47
  extends QMScaleWebViewController.QMScaleWebViewLongClickSaverListener
{
  ReadNoteActivity$47(ReadNoteActivity paramReadNoteActivity, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  public boolean onLongClick(View paramView)
  {
    try
    {
      Object localObject = ((TitleBarWebView2)paramView).getHitTestResult();
      if ((localObject != null) && (((WebView.HitTestResult)localObject).getExtra() != null) && (this.this$0.getActivity() != null) && (((WebView.HitTestResult)localObject).getType() == 7))
      {
        localObject = ((WebView.HitTestResult)localObject).getExtra();
        if ((((String)localObject).startsWith("http://")) || (((String)localObject).startsWith("https://")) || (((String)localObject).startsWith("www.")))
        {
          DataCollector.logEvent("Event_Use_Content_Recognize");
          localObject = Uri.decode((String)localObject).toString();
          this.this$0.showUrlDialog((String)localObject);
          OneStepUtils.dragLinkByOneStep(paramView, (String)localObject);
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.47
 * JD-Core Version:    0.7.0.1
 */