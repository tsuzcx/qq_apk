package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import anlk;
import com.tencent.mobileqq.app.QQAppInterface;

class GeneralSettingActivity$12
  implements Runnable
{
  GeneralSettingActivity$12(GeneralSettingActivity paramGeneralSettingActivity, boolean paramBoolean1, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!((anlk)this.this$0.app.getBusinessHandler(154)).b(this.aXi, this.bHC, true))
    {
      this.this$0.cf(2131719970, 0);
      GeneralSettingActivity localGeneralSettingActivity = this.this$0;
      CompoundButton localCompoundButton = this.val$buttonView;
      if (!this.val$isChecked) {}
      for (boolean bool = true;; bool = false)
      {
        localGeneralSettingActivity.a(localCompoundButton, bool);
        return;
      }
    }
    GeneralSettingActivity.a(this.this$0, true, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.12
 * JD-Core Version:    0.7.0.1
 */