package com.tencent.mobileqq.activity;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopDisbandActivity$1
  implements Runnable
{
  TroopDisbandActivity$1(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  public void run()
  {
    try
    {
      acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
      if (localacms != null)
      {
        long l = Long.parseLong(this.this$0.mTroopUin);
        localacms.a(l, 0L, 5, 6, 1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(l));
        localacms.dL(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.disband", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.1
 * JD-Core Version:    0.7.0.1
 */