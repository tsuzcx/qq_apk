package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import mqq.os.MqqHandler;
import vbn;

public class FriendProfileMoreInfoActivity$16$1
  implements Runnable
{
  public FriendProfileMoreInfoActivity$16$1(vbn paramvbn, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((TroopManager)this.a.this$0.app.getManager(52)).b(this.a.this$0.mTroopUin, this.aMs, this.val$nickName, this.bFR, this.aMt, this.aMu);
    ThreadManager.getUIHandler().post(new FriendProfileMoreInfoActivity.16.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.16.1
 * JD-Core Version:    0.7.0.1
 */