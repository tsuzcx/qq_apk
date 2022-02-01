package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import aqft;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, TroopTransferActivity.d paramd) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!aqft.equalsWithNullCheck(this.c.remark, this.a.remark))
    {
      this.a.remark = this.c.remark;
      if (!TextUtils.isEmpty(this.a.aRl))
      {
        this.a.aRj = ChnToSpell.aJ(this.a.aRl, 2);
        this.a.aRk = ChnToSpell.aJ(this.a.aRl, 1);
      }
    }
    else
    {
      if (!aqft.equalsWithNullCheck(this.c.name, this.a.nickname))
      {
        this.a.nickname = this.c.name;
        if (TextUtils.isEmpty(this.a.nickname)) {
          break label290;
        }
        this.a.aRh = ChnToSpell.aJ(this.a.nickname, 2);
        this.a.aRi = ChnToSpell.aJ(this.a.nickname, 1);
      }
      if (TextUtils.isEmpty(this.a.remark)) {
        break label311;
      }
      str = this.a.remark;
      if (aqft.equalsWithNullCheck(str, this.a.displayName)) {
        break label412;
      }
      this.a.displayName = str;
      if (TextUtils.isEmpty(this.a.displayName)) {
        break label389;
      }
      this.a.pinyinFirst = ChnToSpell.aJ(this.a.displayName, 2);
      this.a.pinyinAll = ChnToSpell.aJ(this.a.displayName, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.yi(bool);
      return;
      this.a.aRj = "";
      this.a.aRk = "";
      break;
      label290:
      this.a.aRh = "";
      this.a.aRi = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.a.aRl))
      {
        str = this.a.aRl;
        break label187;
      }
      if (!TextUtils.isEmpty(this.a.nickname))
      {
        str = this.a.nickname;
        break label187;
      }
      if (!TextUtils.isEmpty(this.a.memberUin))
      {
        str = this.a.memberUin;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.a.pinyinFirst = "";
      this.a.pinyinAll = "";
      bool = true;
      continue;
      label412:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.15
 * JD-Core Version:    0.7.0.1
 */