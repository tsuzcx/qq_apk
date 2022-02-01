package com.tencent.mobileqq.troop.activity;

import aqgv;
import java.util.List;
import java.util.Map;

class TroopAdminList$3
  implements Runnable
{
  TroopAdminList$3(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    int j = this.this$0.Hi.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.this$0.Hi.get(i)).get("uin");
      ((Map)this.this$0.Hi.get(i)).put("nick", aqgv.A(this.this$0.app, str));
      i += 1;
    }
    this.this$0.runOnUiThread(new TroopAdminList.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.3
 * JD-Core Version:    0.7.0.1
 */