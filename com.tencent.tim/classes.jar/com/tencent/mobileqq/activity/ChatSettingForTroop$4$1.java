package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import uqj;

public class ChatSettingForTroop$4$1
  implements Runnable
{
  public ChatSettingForTroop$4$1(uqj paramuqj, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((TroopManager)this.a.this$0.app.getManager(52)).b(this.a.this$0.a.troopUin, this.aMs, this.val$nickName, this.bFR, this.aMt, this.aMu);
    this.a.this$0.a.troopColorNick = this.val$nickName;
    this.a.this$0.a.troopCard = this.val$nickName;
    this.a.this$0.mUIHandler.sendEmptyMessage(6);
    if (this.a.this$0.qC != null) {
      this.a.this$0.fH(this.a.this$0.qC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.4.1
 * JD-Core Version:    0.7.0.1
 */