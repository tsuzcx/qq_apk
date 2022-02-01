package com.tencent.mobileqq.gamecenter.message;

import acxw;
import aeka;
import aekb;
import ahta;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(ahta paramahta) {}
  
  public void run()
  {
    QLog.i(ahta.access$000(), 1, "init task starts.");
    Object localObject1 = aekb.a();
    if (localObject1 != null)
    {
      if (ahta.a(this.this$0) == null) {
        ahta.a(this.this$0, new aeka());
      }
      ahta.a(this.this$0).a((aeka)localObject1);
      QLog.i(ahta.access$000(), 1, "graySwitch:" + ahta.a(this.this$0).cNE);
    }
    ahta.a(this.this$0);
    ahta.b(this.this$0);
    ahta.c(this.this$0);
    ahta.a(this.this$0).addObserver(ahta.a(this.this$0));
    this.this$0.fi();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + ahta.a(this.this$0).getCurrentAccountUin();
    ahta.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    ahta.a(this.this$0).b().addObserver(this.this$0);
    ahta.bf(true);
    if (ahta.a(this.this$0) > 0)
    {
      localObject1 = ahta.a(this.this$0).a().a();
      localObject2 = ((acxw)localObject1).a("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.anX())) {
        ((acxw)localObject1).e((RecentUser)localObject2);
      }
    }
    this.this$0.dpZ();
    QLog.i(ahta.access$000(), 1, "init task ends. unreadCnt = " + ahta.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */