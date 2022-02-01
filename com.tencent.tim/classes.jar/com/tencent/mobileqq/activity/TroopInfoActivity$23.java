package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Handler;
import apyg;
import apyh;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$23
  implements Runnable
{
  TroopInfoActivity$23(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.this$0.a.dwGroupClassExt);
      apyg localapyg = apyh.a((Context)localObject).a();
      if ((localapyg != null) && (localapyg.id.equals(str)))
      {
        this.this$0.a.troopClass = localapyg.BD();
        this.this$0.a.mTroopClassExtText = localapyg.name;
      }
      for (;;)
      {
        this.this$0.handler.sendEmptyMessage(5);
        this.this$0.handler.sendEmptyMessage(6);
        return;
        localObject = apyh.a((Context)localObject).a((Context)localObject, str);
        if (localObject != null)
        {
          this.this$0.a.troopClass = ((apyg)localObject).BD();
          this.this$0.a.mTroopClassExtText = ((apyg)localObject).name;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.23
 * JD-Core Version:    0.7.0.1
 */