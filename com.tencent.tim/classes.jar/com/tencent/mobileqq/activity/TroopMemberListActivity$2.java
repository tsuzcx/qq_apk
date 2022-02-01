package com.tencent.mobileqq.activity;

import acff;
import android.os.Handler;
import aqgx;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.List;

class TroopMemberListActivity$2
  implements Runnable
{
  TroopMemberListActivity$2(TroopMemberListActivity paramTroopMemberListActivity, acff paramacff) {}
  
  public void run()
  {
    Object localObject1 = aqgx.a().a(this.this$0.app, this.this$0.mTroopUin, this.this$0.aRb);
    aqgx.a().a(this.this$0.app, this.this$0.mTroopUin, this.this$0.aRb);
    if ((localObject1 != null) && (this.g != null))
    {
      this.this$0.a(this.this$0.aRb);
      synchronized (this.this$0)
      {
        localObject1 = this.this$0.a((TroopMemberInfo)localObject1, this.g);
        this.this$0.pr.add(localObject1);
        this.this$0.mHandler.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.2
 * JD-Core Version:    0.7.0.1
 */