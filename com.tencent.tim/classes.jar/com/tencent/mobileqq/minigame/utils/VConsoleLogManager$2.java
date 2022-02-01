package com.tencent.mobileqq.minigame.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VConsoleLogManager$2
  implements View.OnClickListener
{
  VConsoleLogManager$2(VConsoleLogManager paramVConsoleLogManager) {}
  
  public void onClick(View paramView)
  {
    VConsoleLogManager.access$100(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.VConsoleLogManager.2
 * JD-Core Version:    0.7.0.1
 */