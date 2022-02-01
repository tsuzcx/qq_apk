package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.ReadMailDetailView;

class QMReadEmlActivity$10
  implements View.OnClickListener
{
  QMReadEmlActivity$10(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onClick(View paramView)
  {
    ReadMailDetailView localReadMailDetailView = QMReadEmlActivity.access$3100(this.this$0);
    MailUI localMailUI = QMReadEmlActivity.access$3000(this.this$0);
    if (!QMReadEmlActivity.access$3100(this.this$0).isShowDetail()) {}
    for (boolean bool = true;; bool = false)
    {
      localReadMailDetailView.render(localMailUI, bool);
      QMReadEmlActivity.access$2800(this.this$0).reflow();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.10
 * JD-Core Version:    0.7.0.1
 */