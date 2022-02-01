package com.tencent.androidqqmail.tim;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MainActivity$1
  implements View.OnClickListener
{
  MainActivity$1(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity.1
 * JD-Core Version:    0.7.0.1
 */