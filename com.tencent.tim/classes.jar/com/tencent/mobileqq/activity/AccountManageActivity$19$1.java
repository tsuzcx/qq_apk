package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;

class AccountManageActivity$19$1
  implements Runnable
{
  AccountManageActivity$19$1(AccountManageActivity.19 param19) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      this.a.this$0.fJ.removeViewAt(this.a.bDs);
      label22:
      if (!this.a.this$0.fk) {
        this.a.this$0.vG(false);
      }
      AccountManageActivity.a(this.a.this$0, null);
      int j = this.a.this$0.fJ.getChildCount();
      while (i < j)
      {
        View localView = this.a.this$0.fJ.getChildAt(i);
        if (localView.getTag() != null) {
          localView.setTag(Integer.valueOf(i));
        }
        i += 1;
      }
      this.a.this$0.pd.dismiss();
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.19.1
 * JD-Core Version:    0.7.0.1
 */