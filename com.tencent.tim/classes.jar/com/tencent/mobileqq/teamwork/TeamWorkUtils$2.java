package com.tencent.mobileqq.teamwork;

import ahwa;
import ahwb;
import anaz;
import android.os.Bundle;
import android.os.Process;
import anot;
import aobw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public final class TeamWorkUtils$2
  implements Runnable
{
  public TeamWorkUtils$2(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, String paramString4, String paramString5, int paramInt, String paramString6) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    Object localObject2;
    if (this.aOy.equals(this.cjY))
    {
      localObject1 = this.cjZ;
      localObject2 = new ahwa((String)localObject1, this.val$app.getCurrentUin(), this.val$tips, 0, -5020, 3276804, anaz.gQ());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 42);
      localBundle.putString("key_a_action_DATA", this.val$url);
      QQAppInterface localQQAppInterface = this.val$app;
      if (!this.aOy.equals(this.cjY)) {
        break label220;
      }
      localObject1 = this.cjZ;
      label104:
      localBundle.putString("key_action_DATA", aobw.c(localQQAppInterface, (String)localObject1, 0));
      ((ahwa)localObject2).addHightlightItem(this.val$index, this.val$index + this.cjX.length(), localBundle);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.val$app, (ahwa)localObject2);
      ahwb.a(this.val$app, (MessageForUniteGrayTip)localObject1);
      localObject2 = this.val$app;
      if (!this.aOy.equals(this.cjY)) {
        break label228;
      }
    }
    label220:
    label228:
    for (Object localObject1 = this.cjZ;; localObject1 = this.cjY)
    {
      anot.a((QQAppInterface)localObject2, "dc00898", "", (String)localObject1, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
      return;
      localObject1 = this.cjY;
      break;
      localObject1 = this.cjY;
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.2
 * JD-Core Version:    0.7.0.1
 */