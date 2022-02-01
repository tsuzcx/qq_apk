package com.tencent.qqmail.account.fragment;

import android.graphics.Bitmap;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.AvatarSelector.OnAvatarChange;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.view.QMAvatarView;

class LoginInfoFragment$6
  implements AvatarSelector.OnAvatarChange
{
  LoginInfoFragment$6(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onAvatarChange(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      LoginInfoFragment.access$802(this.this$0, paramBitmap);
      LoginInfoFragment.access$300(this.this$0).setAvatar(paramBitmap, null);
      String str2 = LoginInfoFragment.access$200(this.this$0).getEmail();
      String str1 = str2;
      if (LoginInfoFragment.access$200(this.this$0).isQQMail())
      {
        str1 = str2;
        if (!LoginInfoFragment.access$200(this.this$0).isBizMail())
        {
          str1 = str2;
          if (str2 != null)
          {
            str1 = str2;
            if (!str2.endsWith("qq.com")) {
              str1 = str2 + "@qq.com";
            }
          }
        }
      }
      ImageUtil.cutPhotoAndSave(paramBitmap, str1);
    }
  }
  
  public void onDefaultAvatar(Bitmap paramBitmap)
  {
    LoginInfoFragment.access$802(this.this$0, null);
    LoginInfoFragment.access$300(this.this$0).setAvatar(paramBitmap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.6
 * JD-Core Version:    0.7.0.1
 */