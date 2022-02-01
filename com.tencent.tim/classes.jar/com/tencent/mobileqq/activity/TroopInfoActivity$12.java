package com.tencent.mobileqq.activity;

import acms;
import android.os.Handler;
import android.text.TextUtils;
import apyg;
import apyh;
import aqgv;
import aqgx;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$12
  implements Runnable
{
  TroopInfoActivity$12(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troopinfo", 2, "init mTroopInfoData == null");
      }
      return;
    }
    if (!TextUtils.isEmpty(this.this$0.a.troopowneruin))
    {
      localObject1 = aqgv.A(this.this$0.app, this.this$0.a.troopowneruin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.this$0.a.troopowneruin)))
      {
        this.this$0.a.troopOwnerNick = ((String)localObject1);
        this.this$0.handler.sendEmptyMessage(2);
      }
    }
    else
    {
      label109:
      if (this.this$0.d != null)
      {
        if ((this.this$0.a.isMember) || (this.this$0.a.pa == 2) || (this.this$0.a.pa == 101) || (this.this$0.a.pa == 102) || (this.this$0.a.pa == 103) || (this.this$0.a.pa == 104) || (this.this$0.a.pa == 105) || (this.this$0.a.pa == 106) || (this.this$0.a.pa == 112) || (this.this$0.a.pa == 113)) {
          break label712;
        }
        this.this$0.d.dK(this.this$0.a.troopUin, this.this$0.a.getStatOption());
      }
    }
    label607:
    while (!this.this$0.a.isMember)
    {
      this.this$0.app.EG(this.this$0.a.troopUin);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      localObject1 = apyh.a(BaseApplication.getContext()).a(this.this$0, Long.toString(this.this$0.a.dwGroupClassExt));
      if (localObject1 != null) {
        this.this$0.a.troopClass = ((apyg)localObject1).BD();
      }
      this.this$0.handler.sendEmptyMessage(5);
      if (this.this$0.d == null) {
        break;
      }
      this.this$0.d.EX(this.this$0.a.troopUin);
      this.this$0.d.ES(this.this$0.a.troopUin);
      if (this.this$0.a.pa != 115) {
        break;
      }
      this.this$0.d.EZ(this.this$0.a.troopUin);
      return;
      str = null;
      Object localObject2 = aqgx.a().a(this.this$0.app, this.this$0.a.troopUin, this.this$0.a.troopowneruin);
      if (localObject2 == null)
      {
        localObject2 = aqgx.a().a(this.this$0.app, this.this$0.a.troopUin, this.this$0.a.troopowneruin);
        localObject1 = str;
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
            break label607;
          }
          localObject1 = ((TroopMemberInfo)localObject2).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label671;
        }
        this.this$0.a.troopOwnerNick = ((String)localObject1);
        this.this$0.handler.sendEmptyMessage(2);
        break;
        localObject1 = str;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject2).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject2).nick;
          }
          else
          {
            localObject1 = str;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject2).name;
            }
          }
        }
      }
      if (this.this$0.b == null) {
        break label109;
      }
      this.this$0.baZ = true;
      this.this$0.b.DG(this.this$0.a.troopowneruin);
      break label109;
    }
    label671:
    label712:
    Object localObject1 = this.this$0.d;
    String str = this.this$0.a.troopUin;
    if (this.this$0.a.pa == 28) {}
    for (boolean bool = true;; bool = false)
    {
      ((acms)localObject1).bJ(str, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.12
 * JD-Core Version:    0.7.0.1
 */