package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import apsw;
import java.util.ArrayList;

public class TroopGagMgr$1
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = this.this$0.d(this.val$uin, false);
    this.val$handler.post(new TroopGagMgr.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr.1
 * JD-Core Version:    0.7.0.1
 */