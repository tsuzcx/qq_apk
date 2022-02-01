package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class TroopInfoActivity$2
  implements Runnable
{
  TroopInfoActivity$2(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = TroopInfoActivity.a(this.this$0, this.this$0.a);
    if (localArrayList != null) {
      ThreadManager.getUIHandler().post(new TroopInfoActivity.2.1(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */