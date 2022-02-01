package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import aqft;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

class TroopTransferActivity$14
  implements Runnable
{
  TroopTransferActivity$14(TroopTransferActivity paramTroopTransferActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = false;
    Object localObject;
    TroopTransferActivity.d locald;
    if (i < this.val$list.size())
    {
      localObject = (TroopMemberCardInfo)this.val$list.get(i);
      locald = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (locald != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!aqft.equalsWithNullCheck(((TroopMemberCardInfo)localObject).name, locald.aRl))
      {
        locald.aRl = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(locald.aRl))
        {
          locald.aRm = ChnToSpell.aJ(locald.aRl, 2);
          locald.aRn = ChnToSpell.aJ(locald.aRl, 1);
        }
      }
      else
      {
        label118:
        if (!aqft.equalsWithNullCheck(((TroopMemberCardInfo)localObject).nick, locald.nickname))
        {
          locald.nickname = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(locald.nickname)) {
            break label277;
          }
          locald.aRh = ChnToSpell.aJ(locald.nickname, 2);
          locald.aRi = ChnToSpell.aJ(locald.nickname, 1);
        }
        label181:
        if (TextUtils.isEmpty(locald.remark)) {
          break label294;
        }
        localObject = locald.remark;
      }
      for (;;)
      {
        if (!aqft.equalsWithNullCheck(localObject, locald.displayName))
        {
          locald.displayName = ((String)localObject);
          if (!TextUtils.isEmpty(locald.displayName))
          {
            locald.pinyinFirst = ChnToSpell.aJ(locald.displayName, 2);
            locald.pinyinAll = ChnToSpell.aJ(locald.displayName, 1);
            bool = true;
            break;
            locald.aRm = "";
            locald.aRn = "";
            break label118;
            label277:
            locald.aRh = "";
            locald.aRi = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(locald.aRl))
            {
              localObject = locald.aRl;
              continue;
            }
            if (!TextUtils.isEmpty(locald.nickname))
            {
              localObject = locald.nickname;
              continue;
            }
            if (!TextUtils.isEmpty(locald.memberUin))
            {
              localObject = locald.memberUin;
              continue;
            }
            localObject = "";
            continue;
          }
          locald.pinyinFirst = "";
          locald.pinyinAll = "";
          bool = true;
          break;
          this.this$0.yi(bool);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.14
 * JD-Core Version:    0.7.0.1
 */