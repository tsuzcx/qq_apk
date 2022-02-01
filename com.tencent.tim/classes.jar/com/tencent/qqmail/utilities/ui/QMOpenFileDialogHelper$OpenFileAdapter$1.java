package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.QMqqBrowserInfo;

class QMOpenFileDialogHelper$OpenFileAdapter$1
  implements View.OnClickListener
{
  QMOpenFileDialogHelper$OpenFileAdapter$1(QMOpenFileDialogHelper.OpenFileAdapter paramOpenFileAdapter, QMqqBrowserInfo paramQMqqBrowserInfo) {}
  
  public void onClick(View paramView)
  {
    QMOpenFileDialogHelper.OpenFileAdapter.access$1400(this.this$1, this.val$info, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMOpenFileDialogHelper.OpenFileAdapter.1
 * JD-Core Version:    0.7.0.1
 */