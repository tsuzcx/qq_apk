package com.tencent.mobileqq.profile;

import alcp;
import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQToast;

class ProfileCardShareHelper$3$1
  implements Runnable
{
  ProfileCardShareHelper$3$1(ProfileCardShareHelper.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.a.this$0.dismissProgressDialog();
    if (this.fP != null)
    {
      alcp.a(this.a.this$0, alcp.a(this.a.this$0), alcp.c(this.a.this$0), this.fP);
      return;
    }
    QQToast.a(alcp.a(this.a.this$0), 1, 2131720153, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */