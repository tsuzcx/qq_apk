package com.tencent.qqmail.utilities.audio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMAudioRecorder$5
  implements View.OnClickListener
{
  QMAudioRecorder$5(QMAudioRecorder paramQMAudioRecorder) {}
  
  public void onClick(View paramView)
  {
    paramView.setEnabled(false);
    this.this$0.performClickRecording(1);
    paramView.postDelayed(new QMAudioRecorder.5.1(this, paramView), 1000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.5
 * JD-Core Version:    0.7.0.1
 */