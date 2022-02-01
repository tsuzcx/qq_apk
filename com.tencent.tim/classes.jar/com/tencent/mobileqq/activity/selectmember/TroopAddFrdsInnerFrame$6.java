package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;

final class TroopAddFrdsInnerFrame$6
  implements Runnable
{
  TroopAddFrdsInnerFrame$6(boolean paramBoolean, QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    String str2;
    QQAppInterface localQQAppInterface;
    String str3;
    String str1;
    if (this.aRm)
    {
      str2 = "multiMode_add";
      localQQAppInterface = this.val$app;
      str3 = this.b.troopuin;
      if (!this.aRm) {
        break label63;
      }
      str1 = "1";
    }
    for (;;)
    {
      anot.a(localQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str2, 0, 0, str3, str1, "", "");
      return;
      str2 = "singleMode_add";
      break;
      label63:
      if (TextUtils.isEmpty(this.b.recommendRemark)) {
        str1 = "0";
      } else {
        str1 = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.6
 * JD-Core Version:    0.7.0.1
 */