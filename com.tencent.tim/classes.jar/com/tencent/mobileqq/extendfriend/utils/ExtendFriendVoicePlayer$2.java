package com.tencent.mobileqq.extendfriend.utils;

import afyg;
import afyg.a;
import aojs;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ExtendFriendVoicePlayer$2
  implements Runnable
{
  public ExtendFriendVoicePlayer$2(afyg paramafyg, String paramString) {}
  
  public void run()
  {
    if ((afyg.a(this.this$0) != null) && (afyg.a(this.this$0).isFinishing()))
    {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file not exist download on executeOnFileThread but activity isFinishing");
      return;
    }
    QLog.i("ExtendFriendVoicePlayer", 2, "playLocal file not exist executeOnFileThread");
    String str = aojs.a(afyg.a(this.this$0).app.getCurrentAccountUin(), MD5.toMD5(this.val$url), 23, null);
    File localFile = new File(str);
    int i = HttpDownloadUtil.a(afyg.a(this.this$0).app, this.val$url, localFile);
    if (i == 0)
    {
      afyg.a(this.this$0).u(localFile);
      this.this$0.mg(str);
      return;
    }
    afyg.a(this.this$0).Nm(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.2
 * JD-Core Version:    0.7.0.1
 */