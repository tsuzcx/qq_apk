package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import aqdj;
import ugv;

public class AssociatedAccountManageActivity$8$1
  implements Runnable
{
  public AssociatedAccountManageActivity$8$1(ugv paramugv, String paramString, View paramView) {}
  
  public void run()
  {
    try
    {
      aqdj localaqdj = aqdj.a(this.a.this$0.app, this.val$uin, (byte)1);
      ImageView localImageView = (ImageView)this.val$view.findViewById(2131368698);
      if (localImageView != null) {
        localImageView.setImageDrawable(localaqdj);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8.1
 * JD-Core Version:    0.7.0.1
 */