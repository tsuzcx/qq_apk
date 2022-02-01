package com.tencent.mobileqq.adapter;

import abge;
import abge.d;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopListAdapter2$5
  implements Runnable
{
  public TroopListAdapter2$5(abge paramabge, TroopManager paramTroopManager, String paramString, abge.d paramd, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.c.jr(this.Uf);
    if (QLog.isColorLevel()) {
      QLog.d("TroopListAdapter2", 2, "itemTag.troopInfo.troopcode == null, queryDB");
    }
    ThreadManager.getUIHandler().post(new TroopListAdapter2.5.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.5
 * JD-Core Version:    0.7.0.1
 */