package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class AssistantSettingActivity$18
  implements Runnable
{
  AssistantSettingActivity$18(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void run()
  {
    if (("haibao".equals(this.this$0.getIntent().getStringExtra("jumpTo"))) && (AssistantSettingActivity.a(this.this$0) != null) && (AssistantSettingActivity.a(this.this$0).getVisibility() == 0)) {
      this.this$0.c.scrollTo(0, AssistantSettingActivity.a(this.this$0).getTop());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */