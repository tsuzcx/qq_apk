package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AssociatedAccountManageActivity$7$1
  implements Runnable
{
  AssociatedAccountManageActivity$7$1(AssociatedAccountManageActivity.7 param7) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "deleteAccount begin to remove account view");
    }
    try
    {
      View localView = AssociatedAccountManageActivity.a(this.a.this$0, this.a.val$uin, 1);
      if (localView != null) {
        this.a.this$0.fP.removeView(localView);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.d("AssociatedAccountManage", 2, "deleteAccount runOnUiThread removeView error");
          continue;
          this.a.this$0.ru.setVisibility(4);
        }
      }
    }
    this.a.this$0.bGk();
    if ((this.a.this$0.qi == null) || (this.a.this$0.qi.size() == 0))
    {
      this.a.this$0.ru.setVisibility(8);
      AssociatedAccountManageActivity.a(this.a.this$0);
      if (((this.a.this$0.qj == null) || (this.a.this$0.qj.size() == 0)) && ((this.a.this$0.qi == null) || (this.a.this$0.qi.size() == 0))) {
        this.a.this$0.onBackEvent();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7.1
 * JD-Core Version:    0.7.0.1
 */