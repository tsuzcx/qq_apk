package com.tencent.qqmail.utilities.audio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMAudioPlayBar$5
  implements View.OnClickListener
{
  QMAudioPlayBar$5(QMAudioPlayBar paramQMAudioPlayBar) {}
  
  public void onClick(View paramView)
  {
    this.this$0.close();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioPlayBar.5
 * JD-Core Version:    0.7.0.1
 */