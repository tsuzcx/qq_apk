package com.tencent.mobileqq.activity.aio.rebuild;

import acdu;
import aizr;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import aprp;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import java.util.Set;

class TroopChatPie$38
  implements Runnable
{
  TroopChatPie$38(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (aizr.a().h(this.this$0.sessionInfo.aTl, this.this$0.app))
    {
      this.this$0.c = ChatActivityUtils.a(this.this$0.mActivity, this.this$0.mActivity.getString(2131690158));
      this.this$0.c.show();
      aizr.a().m(this.this$0.sessionInfo.aTl, this.this$0.app);
    }
    Object localObject = (acdu)this.this$0.app.getManager(53);
    if ((localObject != null) && (((acdu)localObject).bL.contains(this.this$0.sessionInfo.aTl)))
    {
      this.this$0.app.b().gW(this.this$0.sessionInfo.aTl);
      ((acdu)localObject).bL.remove(this.this$0.sessionInfo.aTl);
    }
    localObject = (aprp)this.this$0.app.getManager(109);
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(52);
    if (localObject != null)
    {
      if (this.this$0.bYI != ((aprp)localObject).jM(0))
      {
        this.this$0.bYI = ((aprp)localObject).jM(0);
        this.this$0.bX.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.sessionInfo.aTl);
      ((aprp)localObject).Qx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.38
 * JD-Core Version:    0.7.0.1
 */