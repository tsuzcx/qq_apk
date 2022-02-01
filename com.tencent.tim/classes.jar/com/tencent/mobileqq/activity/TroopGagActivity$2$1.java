package com.tencent.mobileqq.activity;

import android.os.Handler;
import apsw;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import vyy;

public class TroopGagActivity$2$1
  implements Runnable
{
  public TroopGagActivity$2$1(vyy paramvyy, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((apsw)this.a.this$0.app.getManager(48)).d(this.a.this$0.troopCode, false);
    this.val$handler.post(new TroopGagActivity.2.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1
 * JD-Core Version:    0.7.0.1
 */