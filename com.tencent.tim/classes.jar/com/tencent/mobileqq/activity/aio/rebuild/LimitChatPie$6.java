package com.tencent.mobileqq.activity.aio.rebuild;

import afsi;
import afxx;
import aine;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ybb;

public class LimitChatPie$6
  implements Runnable
{
  public LimitChatPie$6(ybb paramybb, String paramString) {}
  
  public void run()
  {
    afsi localafsi = (afsi)this.this$0.app.getManager(264);
    if (localafsi == null)
    {
      QLog.e(this.this$0.TAG, 2, "getSubThreadHandler  extendFriendManager Is null");
      return;
    }
    ybb.a(this.this$0, localafsi.a(this.Lw, true));
    if (ybb.a(this.this$0) == null)
    {
      aine.a(this.this$0.app, this.Lw, 1, "", false);
      ybb.a(this.this$0, localafsi.a(this.Lw, true));
    }
    if ((ybb.a(this.this$0) != null) && (ybb.a(this.this$0).isSignalBomb()) && (ybb.a(this.this$0).showDistanceHLight))
    {
      ybb.a(this.this$0).showDistanceHLight = false;
      localafsi.a(ybb.a(this.this$0));
    }
    Object localObject = this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, null, 500);
    if (localObject != null) {
      ybb.a(this.this$0, ((List)localObject).size());
    }
    if (ybb.e(this.this$0) <= 0) {
      afxx.i(this.this$0.app, this.this$0.app.getCurrentAccountUin(), this.Lw, this.this$0.sessionInfo.cZ);
    }
    if ((localObject != null) && (((List)localObject).size() > 0) && (!ybb.a(this.this$0).enableQQCall))
    {
      QLog.d(this.this$0.TAG, 2, "enableQQCall check");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((MessageRecord)((Iterator)localObject).next()).senderuin.equals(ybb.a(this.this$0).uin))
        {
          ybb.a(this.this$0).enableQQCall = true;
          localafsi.a(ybb.a(this.this$0));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "mAllMsgCount " + ybb.e(this.this$0));
    }
    this.this$0.refresh(65536);
    ThreadManager.getUIHandler().post(new LimitChatPie.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6
 * JD-Core Version:    0.7.0.1
 */