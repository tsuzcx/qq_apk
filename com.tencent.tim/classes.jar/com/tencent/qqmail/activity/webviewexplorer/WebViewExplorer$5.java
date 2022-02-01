package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.popularize.JSApiUitil;
import java.util.ArrayList;

class WebViewExplorer$5
  implements View.OnClickListener
{
  WebViewExplorer$5(WebViewExplorer paramWebViewExplorer) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.popularizeMoreOperations != null) && (this.this$0.popularizeMoreOperations.size() > 0)) {
      this.this$0.mMoreActionWindow = JSApiUitil.showMoreDialogPopup(this.this$0, paramView, this.this$0.popularizeMoreOperations, this.this$0.url);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.showMoreDialogPopup(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.5
 * JD-Core Version:    0.7.0.1
 */