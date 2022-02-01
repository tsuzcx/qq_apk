package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.ReadMailDetailView;

class ReadMailFragment$104
  implements View.OnClickListener
{
  ReadMailFragment$104(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    ReadMailDetailView localReadMailDetailView;
    MailUI localMailUI;
    if (ReadMailFragment.access$11900(this.this$0) != null)
    {
      localReadMailDetailView = ReadMailFragment.access$11900(this.this$0);
      localMailUI = ReadMailFragment.access$000(this.this$0);
      if (ReadMailFragment.access$11900(this.this$0).isShowDetail()) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      localReadMailDetailView.render(localMailUI, bool);
      ReadMailFragment.access$2300(this.this$0).reflow();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.104
 * JD-Core Version:    0.7.0.1
 */