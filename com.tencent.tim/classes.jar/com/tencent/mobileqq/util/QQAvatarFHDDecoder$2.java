package com.tencent.mobileqq.util;

import android.text.TextUtils;
import aqes;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class QQAvatarFHDDecoder$2
  implements Runnable
{
  public void run()
  {
    if (aqes.a(this.this$0)) {
      return;
    }
    Setting localSetting = aqes.a(this.this$0).b(this.val$uin);
    if ((this.val$forceUpdate) || (localSetting == null) || (TextUtils.isEmpty(localSetting.url)) || (System.currentTimeMillis() - localSetting.updateTimestamp > 86400000L))
    {
      aqes.a(this.this$0).DH(this.val$uin);
      return;
    }
    this.this$0.e(localSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.2
 * JD-Core Version:    0.7.0.1
 */