package com.tencent.mobileqq.nearby.gameroom;

import android.os.Bundle;
import aprb;
import apuh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

class GameRoomInviteActivity$20
  implements Runnable
{
  GameRoomInviteActivity$20(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void run()
  {
    Object localObject2 = (TicketManager)this.this$0.app.getManager(2);
    Object localObject1 = this.this$0.app.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.this$0.app.getCurrentAccountUin());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("bkn", "" + apuh.eU(str));
    ((Bundle)localObject2).putString("ver", "3.4.4");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("uin", this.this$0.app.getCurrentAccountUin());
    ((Bundle)localObject2).putString("count", "8");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.this$0.app.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new aprb("https://nearby.qq.com/cgi-bin/werewolf/get_friend_board_list", "GET", this.this$0.b, 0, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomInviteActivity", 2, "get feed from server start: " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.20
 * JD-Core Version:    0.7.0.1
 */