package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadMailFragment$49
  implements View.OnClickListener
{
  ReadMailFragment$49(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    if ((ReadMailFragment.access$2300(this.this$0) != null) && (ReadMailFragment.access$2300(this.this$0).getWebView() != null)) {
      ReadMailFragment.access$2300(this.this$0).getWebView().smoothToTop();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.49
 * JD-Core Version:    0.7.0.1
 */