package com.tencent.mobileqq.activity;

import android.widget.TextView;

class TroopAssistantActivity$15$1
  implements Runnable
{
  TroopAssistantActivity$15$1(TroopAssistantActivity.15 param15, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.aIU <= 0)
    {
      this.a.FW.setVisibility(4);
      return;
    }
    this.a.FW.setText(this.val$finalText);
    this.a.FW.setContentDescription(this.val$finalText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.15.1
 * JD-Core Version:    0.7.0.1
 */