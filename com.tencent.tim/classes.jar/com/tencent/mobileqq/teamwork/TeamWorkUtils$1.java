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

public final class TeamWorkUtils$1
  implements Runnable
{
  public TeamWorkUtils$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, int paramInt, String paramString4) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    ahwa localahwa = new ahwa(this.Uf, this.Uf, this.val$tips, 1, -5020, 3276804, anaz.gQ());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 42);
    ((Bundle)localObject).putString("key_action_DATA", aobw.c(this.val$app, this.Uf, 1));
    ((Bundle)localObject).putString("key_a_action_DATA", this.val$url);
    localahwa.addHightlightItem(this.val$index, this.val$index + this.cjX.length(), (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.val$app, localahwa);
    ahwb.a(this.val$app, (MessageForUniteGrayTip)localObject);
    anot.a(this.val$app, "dc00898", "", this.Uf, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.1
 * JD-Core Version:    0.7.0.1
 */