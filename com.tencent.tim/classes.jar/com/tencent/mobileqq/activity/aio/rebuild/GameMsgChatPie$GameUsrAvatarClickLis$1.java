package com.tencent.mobileqq.activity.aio.rebuild;

import ahta;
import awot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.qphone.base.util.QLog;
import xzk;
import xzk.a;

public class GameMsgChatPie$GameUsrAvatarClickLis$1
  implements Runnable
{
  public GameMsgChatPie$GameUsrAvatarClickLis$1(xzk.a parama) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((ahta)xzk.a.a(this.this$0).getManager(358)).a(xzk.a.a(this.this$0));
        if (localObject == null)
        {
          QLog.w(xzk.TAG, 1, "GameUsrAvatarClickLis, usrInfo is null");
          return;
        }
        xzk.a.a(this.this$0);
        awot localawot = awot.a();
        String str2 = ((GameUserInfo)localObject).mAppId;
        if (xzk.a.a(this.this$0))
        {
          localObject = "0";
          localawot.c(str2, "1", "145", "920", "92005", "206352", "", "", "20", (String)localObject);
          if (!xzk.a.b(this.this$0)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(xzk.TAG, 2, "GameUsrAvatarClickLis already update.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(xzk.TAG, 1, localThrowable, new Object[0]);
        return;
      }
      String str1 = "1";
    }
    xzk.a.a(this.this$0, xzk.a.a(this.this$0));
    xzk.a.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1
 * JD-Core Version:    0.7.0.1
 */