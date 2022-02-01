package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import aqdj;
import java.util.HashMap;

class AccountManageActivity$14$1
  implements Runnable
{
  AccountManageActivity$14$1(AccountManageActivity.14 param14, boolean paramBoolean, String paramString, Bitmap paramBitmap, Drawable paramDrawable) {}
  
  public void run()
  {
    if ((this.a.g != this.a.this$0.app) || (this.a.g == null)) {
      return;
    }
    if (this.aQX)
    {
      this.a.BB.setText(this.aKB);
      AccountManageActivity.b(this.a.this$0).put(this.a.aKo, this.aKB);
    }
    if ((this.a.pi.getDrawable() != null) && ((this.a.pi.getDrawable() instanceof aqdj))) {
      ((aqdj)this.a.pi.getDrawable()).cancel();
    }
    if (this.dj != null)
    {
      this.a.pi.setImageBitmap(this.dj);
      return;
    }
    this.a.pi.setImageDrawable(this.dw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14.1
 * JD-Core Version:    0.7.0.1
 */