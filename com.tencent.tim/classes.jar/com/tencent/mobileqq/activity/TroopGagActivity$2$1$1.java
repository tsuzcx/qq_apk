package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.TroopManager.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vyy;

class TroopGagActivity$2$1$1
  implements Runnable
{
  TroopGagActivity$2$1$1(TroopGagActivity.2.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.pH != null) && (!this.pH.isEmpty()))
    {
      this.a.a.this$0.rl.clear();
      Iterator localIterator = this.pH.iterator();
      while (localIterator.hasNext())
      {
        TroopManager.d locald = (TroopManager.d)localIterator.next();
        TroopGagActivity.a locala = new TroopGagActivity.a();
        locala.uin = locald.sUin;
        locala.Hc = locald.QU;
        this.a.a.this$0.rl.add(locala);
      }
    }
    this.a.a.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */