package com.tencent.qqmail.utilities.audio;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMAudioRecorder$4
  implements View.OnClickListener
{
  QMAudioRecorder$4(QMAudioRecorder paramQMAudioRecorder, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    this.this$0.confirmDialog(this.val$context);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.4
 * JD-Core Version:    0.7.0.1
 */