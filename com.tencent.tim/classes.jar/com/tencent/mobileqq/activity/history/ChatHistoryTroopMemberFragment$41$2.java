package com.tencent.mobileqq.activity.history;

import acff;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;
import zim;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(zim paramzim, String paramString) {}
  
  public void run()
  {
    Object localObject = (acff)this.a.this$0.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = aqgx.a().a(this.a.this$0.app, this.a.this$0.mTroopUin, this.aMs);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.a.this$0.a(localTroopMemberInfo, (acff)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (ChatHistoryTroopMemberFragment.a)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */