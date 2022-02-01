package com.tencent.mobileqq.mutualmark.oldlogic;

import acff;
import ajol;
import ajoo;
import anot;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import xys;

public final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  public OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, xys paramxys) {}
  
  public void run()
  {
    acff localacff = (acff)this.val$app.getManager(51);
    ExtensionInfo localExtensionInfo = localacff.a(this.a.aTl, false);
    if (localExtensionInfo == null) {}
    do
    {
      return;
      bool1 = localacff.aL(false);
    } while (bool1);
    int i = ajol.a(5, this.a.aTl, localExtensionInfo, bool1);
    int j = ajol.a(4, this.a.aTl, localExtensionInfo, bool1);
    long l1 = localExtensionInfo.lastChatTime;
    long l2 = localExtensionInfo.lastpraiseTime;
    int k = ajol.Gx();
    boolean bool2 = ajol.q(k, l1 * 1000L);
    boolean bool3 = ajol.q(k, l2 * 1000L);
    k = ajol.a(1, this.a.aTl, localExtensionInfo, localacff.aL(false));
    l1 = localExtensionInfo.loverLastChatTime;
    boolean bool1 = ajol.b(ajol.Gx(), l1 * 1000L, localExtensionInfo.loverTransFlag);
    xys localxys = this.c;
    int n;
    if ((k != 0) && (bool1))
    {
      bool1 = true;
      localxys.bkN = bool1;
      if (this.c.bkN) {
        ajoo.b(this.val$app, this.a, this.c);
      }
      k = localExtensionInfo.isGrayTipRemind;
      int m = localExtensionInfo.isGrayTipMultiRemind;
      n = localacff.cvv;
      if (QLog.isColorLevel()) {
        QLog.d("reactivetip", 2, "checkReactiveGraytip isRemind=" + k + "isMultiRemind" + m + "praiseNeedRemind=" + bool3 + "chatNeedRemind=" + bool2 + "maxRemindTime=" + n);
      }
      if ((!bool3) || (!bool2) || (i == 0) || (j == 0)) {
        break label397;
      }
      if (!ajoo.b(this.val$app, "hot_friend_graytip_priaseandchat_remind_times", Boolean.valueOf(true), m, 4096, true, localExtensionInfo, n)) {
        break label552;
      }
      i = 23;
    }
    for (;;)
    {
      localacff.a(localExtensionInfo);
      anot.a(this.val$app, "dc00898", "", "", "0X8007779", "0X8007779", i, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
      label397:
      if (bool3)
      {
        if (j == 2)
        {
          if (ajoo.b(this.val$app, "hot_friend_graytip_priasedown_remind_times", Boolean.valueOf(false), k, 1, bool3, localExtensionInfo, n)) {
            i = 20;
          }
        }
        else if ((j == 1) && (ajoo.b(this.val$app, "hot_friend_graytip_priasedis_remind_times", Boolean.valueOf(false), k, 16, bool3, localExtensionInfo, n))) {
          i = 19;
        }
      }
      else if (bool2) {
        if (i == 2)
        {
          if (ajoo.b(this.val$app, "hot_friend_graytip_chatdown_remind_times", Boolean.valueOf(false), k, 256, bool2, localExtensionInfo, n)) {
            i = 18;
          }
        }
        else if ((i == 1) && (ajoo.b(this.val$app, "hot_friend_graytip_chatdis_remind_times", Boolean.valueOf(false), k, 4096, bool2, localExtensionInfo, n)))
        {
          i = 17;
          continue;
        }
      }
      label552:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */