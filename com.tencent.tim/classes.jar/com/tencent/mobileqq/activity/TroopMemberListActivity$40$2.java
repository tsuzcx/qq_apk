package com.tencent.mobileqq.activity;

import acff;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;
import wcd;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(wcd paramwcd, String paramString) {}
  
  public void run()
  {
    Object localObject = (acff)this.a.this$0.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = aqgx.a().a(this.a.this$0.app, this.a.this$0.mTroopUin, this.aMs);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.a.this$0.a(localTroopMemberInfo, (acff)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (TroopMemberListActivity.a)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */