package com.tencent.qqmail.utilities.audio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMAudioRecorder$6
  implements View.OnClickListener
{
  QMAudioRecorder$6(QMAudioRecorder paramQMAudioRecorder) {}
  
  public void onClick(View paramView)
  {
    this.this$0.stopAndCallback();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.6
 * JD-Core Version:    0.7.0.1
 */