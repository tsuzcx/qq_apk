package com.tencent.qqmail.model.verify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.model.QMCalendarManager;

class QMVerifyImageDialog$2
  implements View.OnClickListener
{
  QMVerifyImageDialog$2(QMVerifyImageDialog paramQMVerifyImageDialog) {}
  
  public void onClick(View paramView)
  {
    QMVerifyImageDialog.access$100(this.this$0).setVisibility(0);
    QMCalendarManager.getInstance().getVerifyImage(QMVerifyImageDialog.access$200(this.this$0), QMVerifyImageDialog.access$300(this.this$0), QMVerifyImageDialog.access$400(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.verify.QMVerifyImageDialog.2
 * JD-Core Version:    0.7.0.1
 */