package com.tencent.mobileqq.relationx.batchAdd;

import anot;
import apwn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

public final class BatchAddFriendData$1
  implements Runnable
{
  public BatchAddFriendData$1(int paramInt, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    String str1 = apwn.b(false, this.val$type);
    Object localObject2 = (TroopManager)this.val$appInterface.getManager(52);
    Object localObject1 = ((TroopManager)localObject2).b(this.Uf);
    String str2;
    if (localObject1 != null)
    {
      if (this.val$type != 1) {
        break label109;
      }
      ((TroopInfo)localObject1).wClickBAFTipCount += 1;
      ((TroopManager)localObject2).i((TroopInfo)localObject1);
      localObject2 = this.val$appInterface;
      str2 = this.Uf;
      if (((TroopInfo)localObject1).wInsertBAFTipCount != 1) {
        break label103;
      }
    }
    label103:
    for (localObject1 = "0";; localObject1 = "1")
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, str2, (String)localObject1, "", "");
      return;
    }
    label109:
    anot.a(this.val$appInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, this.Uf, "0", Integer.toString(((TroopInfo)localObject1).wMemberNum), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData.1
 * JD-Core Version:    0.7.0.1
 */