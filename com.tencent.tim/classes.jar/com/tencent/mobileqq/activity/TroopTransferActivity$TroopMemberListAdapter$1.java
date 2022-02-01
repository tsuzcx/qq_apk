package com.tencent.mobileqq.activity;

import acff;
import acms;
import android.text.TextUtils;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopTransferActivity$TroopMemberListAdapter$1
  implements Runnable
{
  TroopTransferActivity$TroopMemberListAdapter$1(TroopTransferActivity.e parame, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.b.mList.size();
    TroopManager localTroopManager = (TroopManager)this.b.this$0.app.getManager(52);
    acff localacff = (acff)this.b.this$0.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      TroopTransferActivity.d locald = (TroopTransferActivity.d)this.b.mList.get(i);
      if (TextUtils.isEmpty(locald.memberUin)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localacff == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            locald.nickname = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            locald.remark = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(locald.memberUin))) {
            break label479;
          }
          localObject = aqgx.a().a(this.b.this$0.app, String.valueOf(this.b.this$0.mTroopUin), locald.memberUin);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            locald.aRl = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            locald.remark = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(locald.remark)) {
            break label488;
          }
          locald.displayName = locald.remark;
          label282:
          if (TextUtils.isEmpty(locald.displayName)) {
            break label571;
          }
          locald.pinyinFirst = ChnToSpell.aJ(locald.displayName, 2);
          locald.pinyinAll = ChnToSpell.aJ(locald.displayName, 1);
          label321:
          if (TextUtils.isEmpty(locald.nickname)) {
            break label588;
          }
          locald.aRh = ChnToSpell.aJ(locald.nickname, 2);
          locald.aRi = ChnToSpell.aJ(locald.nickname, 1);
          label360:
          if (TextUtils.isEmpty(locald.remark)) {
            break label605;
          }
          locald.aRj = ChnToSpell.aJ(locald.remark, 2);
        }
        for (locald.aRk = ChnToSpell.aJ(locald.remark, 1);; locald.aRk = "")
        {
          if (TextUtils.isEmpty(locald.aRl)) {
            break label622;
          }
          locald.aRm = ChnToSpell.aJ(locald.aRl, 2);
          locald.aRn = ChnToSpell.aJ(locald.aRl, 1);
          break;
          localObject = localacff.e(locald.memberUin);
          break label108;
          label455:
          localObject = localTroopManager.getTroopMemberName(this.b.this$0.mTroopUin, locald.memberUin);
          break label161;
          label479:
          locald.aRl = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(locald.aRl))
          {
            locald.displayName = locald.aRl;
            break label282;
          }
          if (!TextUtils.isEmpty(locald.nickname))
          {
            locald.displayName = locald.nickname;
            break label282;
          }
          if (TextUtils.isEmpty(locald.memberUin)) {
            break label282;
          }
          locald.displayName = locald.memberUin;
          localArrayList.add(locald.memberUin);
          break label282;
          label571:
          locald.pinyinFirst = "";
          locald.pinyinAll = "";
          break label321;
          label588:
          locald.aRh = "";
          locald.aRi = "";
          break label360;
          label605:
          locald.aRj = "";
        }
        label622:
        locald.aRm = "";
        locald.aRn = "";
      }
    }
    Object localObject = (acms)this.b.this$0.app.getBusinessHandler(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((acms)localObject).b(this.b.this$0.mTroopUin, this.b.this$0.aKI, localArrayList);
    }
    try
    {
      if ((this.b.this$0 != null) && (!this.b.this$0.isFinishing())) {
        this.b.this$0.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.transfer", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */