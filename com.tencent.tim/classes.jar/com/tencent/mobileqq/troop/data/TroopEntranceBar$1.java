package com.tencent.mobileqq.troop.data;

import anot;
import apbk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import ocp;

public class TroopEntranceBar$1
  implements Runnable
{
  public TroopEntranceBar$1(apbk paramapbk) {}
  
  public void run()
  {
    String str1 = "";
    if (this.this$0.sessionInfo != null)
    {
      String str2 = this.this$0.sessionInfo.aTl;
      AccountDetail localAccountDetail = ocp.a(this.this$0.app, str2);
      if (localAccountDetail != null) {
        str1 = localAccountDetail.uin;
      }
      anot.a(this.this$0.app, "dc00899", "Grp_tribe", "", "interest_data", "exp_tribechat_aio", 0, 0, str2, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.1
 * JD-Core Version:    0.7.0.1
 */