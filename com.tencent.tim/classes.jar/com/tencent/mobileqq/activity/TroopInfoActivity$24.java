package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import aqgv;
import aqgx;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$24
  implements Runnable
{
  TroopInfoActivity$24(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject1 = aqgv.A(this.this$0.app, this.this$0.a.troopowneruin);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.this$0.a.troopowneruin)))
    {
      this.this$0.a.troopOwnerNick = ((String)localObject1);
      this.this$0.handler.sendEmptyMessage(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "mTroopInfoData.troopOwnerNick = " + this.this$0.a.troopOwnerNick);
      }
      return;
      Object localObject2 = null;
      Object localObject3 = aqgx.a().a(this.this$0.app, this.this$0.a.troopUin, this.this$0.a.troopowneruin);
      if (localObject3 == null)
      {
        localObject3 = aqgx.a().a(this.this$0.app, this.this$0.a.troopUin, this.this$0.a.troopowneruin);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick)) {
            break label237;
          }
          localObject1 = ((TroopMemberInfo)localObject3).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label295;
        }
        this.this$0.a.troopOwnerNick = ((String)localObject1);
        this.this$0.handler.sendEmptyMessage(2);
        break;
        label237:
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject3).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject3).nick;
          }
          else
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject3).name;
            }
          }
        }
      }
      label295:
      if ((!this.this$0.baZ) && (this.this$0.b != null))
      {
        this.this$0.baZ = true;
        this.this$0.b.DG(this.this$0.a.troopowneruin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.24
 * JD-Core Version:    0.7.0.1
 */