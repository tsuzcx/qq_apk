package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import anjo;
import anjx;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

public class RedBagVideoManager$5
  implements Runnable
{
  public RedBagVideoManager$5(anjo paramanjo) {}
  
  public void run()
  {
    String str1 = null;
    if (anjo.a(this.this$0) == null) {}
    while (anjo.a(this.this$0).redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
      return;
    }
    String str2 = anjo.a(this.this$0).senderUin;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VALUE_USER_UIN_TO_GET_NICK_NAME", str2);
    localObject = anjx.a().b("CMD_GET_NICK_NAME_BY_UIN", (Bundle)localObject);
    if ((localObject == null) && (QLog.isColorLevel())) {
      QLog.d("RedBagVideoManager", 2, "getNickName VideoPlayIPCClient.callServer value=null");
    }
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("VALUE_USER_NICK_NAME");; localObject = "")
    {
      Bundle localBundle = anjx.a().b("CMD_GET_CURRENT_NICK_NAME", null);
      if (localBundle != null) {
        str1 = localBundle.getString("VALUE_GET_CURRENT_NICK_NAME");
      }
      this.this$0.a(anjo.a(this.this$0), str2, (String)localObject, str1, anjo.a(this.this$0).shortVideoId, anjo.a(this.this$0).istroop, anjo.a(this.this$0).friendUin);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.5
 * JD-Core Version:    0.7.0.1
 */