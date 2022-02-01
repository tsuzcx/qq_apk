package com.tencent.mobileqq.extendfriend;

import afsi;
import afsi.a;
import afsi.b;
import afss;
import afwv;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtendFriendManager$5
  implements Runnable
{
  public ExtendFriendManager$5(afsi paramafsi) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!afsi.a(this.this$0)) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!afwv.akw())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (afsi.a(this.this$0) == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else
    {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = afsi.a(this.this$0);
    if ((!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (afsi.a(this.this$0) > 2))
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + l1 + " lastDownloadTime " + afsi.a(this.this$0) + " downloadTimes" + afsi.a(this.this$0));
      return;
    }
    Object localObject = afwv.uL();
    if (afsi.a(this.this$0).kw != null)
    {
      localObject = (afsi.b)afsi.a(this.this$0).kw.get(localObject);
      afsi.a(this.this$0).a((afsi.b)localObject);
      afsi.a(this.this$0, l1);
      afsi.b(this.this$0);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */