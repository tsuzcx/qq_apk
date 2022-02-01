package com.tencent.mobileqq.troop.utils;

import acms;
import android.content.Context;
import anot;
import apuh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class TroopUtils$5
  implements Runnable
{
  public TroopUtils$5(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.val$app.getManager(52)).b(this.Uf, this.aMs);
    int j = 0;
    for (;;)
    {
      try
      {
        String[] arrayOfString = this.crB.split("_");
        i = j;
        if (arrayOfString != null)
        {
          i = j;
          if (arrayOfString.length > 2)
          {
            j = Integer.parseInt(arrayOfString[0]);
            i = Integer.parseInt(arrayOfString[1]);
          }
        }
        long l;
        j = i;
      }
      catch (Exception localException1)
      {
        try
        {
          l = Long.parseLong(arrayOfString[2]);
          anot.a(this.val$app, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(i), "", "", "");
          ((acms)this.val$app.getBusinessHandler(20)).af(this.Uf, 2, j);
          j = i;
          if (localTroopMemberInfo == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick open card " + this.aMs + " " + this.crB);
          }
          if (this.val$context != null) {
            apuh.a(this.val$app, this.val$context, this.aMs, j, this.Uf);
          }
          return;
        }
        catch (Exception localException2)
        {
          int i;
          break label214;
        }
        localException1 = localException1;
        i = 0;
      }
      label214:
      if (QLog.isColorLevel())
      {
        QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick " + localException1);
        j = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick no member " + this.aMs);
    }
    ThreadManager.getUIHandler().post(new TroopUtils.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.5
 * JD-Core Version:    0.7.0.1
 */