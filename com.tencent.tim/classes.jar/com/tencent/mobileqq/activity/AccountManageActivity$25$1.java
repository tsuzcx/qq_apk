package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import aqdj;
import ucp;

public class AccountManageActivity$25$1
  implements Runnable
{
  public AccountManageActivity$25$1(ucp paramucp, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      aqdj localaqdj = aqdj.a(this.a.this$0.app, this.val$uin, (byte)1);
      ((ImageView)this.a.this$0.fJ.getChildAt(this.val$pos).findViewById(2131368698)).setImageDrawable(localaqdj);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.25.1
 * JD-Core Version:    0.7.0.1
 */