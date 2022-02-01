package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BrightnessDialog$1
  implements View.OnClickListener
{
  BrightnessDialog$1(BrightnessDialog paramBrightnessDialog) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.BrightnessDialog.1
 * JD-Core Version:    0.7.0.1
 */