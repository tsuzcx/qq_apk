package com.tencent.mobileqq.activity;

import ahbj;
import ajrk;
import android.os.Message;
import android.text.TextUtils;
import aqep;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.os.MqqHandler;
import vbg;

public class FriendProfileImageAvatar$3
  implements Runnable
{
  public FriendProfileImageAvatar$3(vbg paramvbg, String paramString) {}
  
  public void run()
  {
    if (ahbj.isFileExists(aqep.pf(String.valueOf(this.val$uin)))) {
      if (ajrk.isDevelopLevel()) {
        ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
      }
    }
    do
    {
      return;
      if (!this.this$0.aWN) {
        break;
      }
    } while (!ajrk.isDevelopLevel());
    ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
    return;
    this.this$0.aWN = true;
    Setting localSetting = (Setting)this.this$0.app.a().createEntityManager().find(Setting.class, this.val$uin);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = localSetting;
      if (this.this$0.g != null) {
        this.this$0.g.sendMessage(localMessage);
      }
    }
    for (;;)
    {
      this.this$0.aWN = false;
      if (!ajrk.isDevelopLevel()) {
        break;
      }
      ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
      return;
      this.this$0.aWM = true;
      this.this$0.app.EH(this.val$uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.3
 * JD-Core Version:    0.7.0.1
 */