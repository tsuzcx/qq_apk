package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;
import apdd;
import apsw;
import apwh;
import aqfr;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.os.MqqHandler;

class TroopChatPie$37
  implements Runnable
{
  TroopChatPie$37(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.chy();
    Object localObject1 = ((apsw)this.this$0.app.getManager(48)).a(this.this$0.sessionInfo.aTl, true);
    Object localObject2 = this.this$0.bX.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.bX.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.app.getManager(52)).c(this.this$0.sessionInfo.aTl);
    int i = this.this$0.app.cs(this.this$0.sessionInfo.aTl);
    localObject2 = this.this$0.app.b().a();
    int j = aqiw.getSystemNetwork(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((apdd)localObject2).dTt > 0))) && (((apdd)localObject2).cPW) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((apdd)localObject2).dTs) && ((j == 4) || (j == 1))) {
      ((apdd)localObject2).bM(this.this$0.sessionInfo.aTl, Math.min(this.this$0.bfi, ((apdd)localObject2).dTr));
    }
    localObject2 = TroopChatPie.k(this.this$0).obtainMessage(85);
    if (apwh.a(TroopChatPie.a(this.this$0)).j(this.this$0.app, this.this$0.sessionInfo)) {}
    for (i = 1;; i = 0)
    {
      ((Message)localObject2).arg1 = i;
      ((Message)localObject2).sendToTarget();
      if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
        aqfr.b("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.sessionInfo.aTl });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.37
 * JD-Core Version:    0.7.0.1
 */