package com.tencent.qqmail.account.fragment;

import android.graphics.Bitmap;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMAvatarView;
import java.util.List;

class LoginInfoFragment$2$1
  implements Runnable
{
  LoginInfoFragment$2$1(LoginInfoFragment.2 param2, List paramList) {}
  
  public void run()
  {
    if (LoginInfoFragment.access$200(this.this$1.this$0) == null) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
      } while ((this.val$emails == null) || (!this.val$emails.contains(LoginInfoFragment.access$200(this.this$1.this$0).getEmail())));
      QMLog.log(4, "LoginInfoFragment", "addAccount. syncPhotoWatcher:" + LoginInfoFragment.access$200(this.this$1.this$0).getEmail() + "," + LoginInfoFragment.access$200(this.this$1.this$0).getName());
      localBitmap = QMSettingManager.sharedInstance().getAccountIconLocal(LoginInfoFragment.access$200(this.this$1.this$0).getEmail(), 2);
    } while (localBitmap == null);
    LoginInfoFragment.access$300(this.this$1.this$0).setAvatar(localBitmap, LoginInfoFragment.access$200(this.this$1.this$0).getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.2.1
 * JD-Core Version:    0.7.0.1
 */