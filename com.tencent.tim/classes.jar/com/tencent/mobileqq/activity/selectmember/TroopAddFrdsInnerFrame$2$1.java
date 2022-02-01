package com.tencent.mobileqq.activity.selectmember;

import aayl;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopAddFrdsInnerFrame$2$1
  implements Runnable
{
  public TroopAddFrdsInnerFrame$2$1(aayl paramaayl, List paramList) {}
  
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onUpdateTroopGetMemberList:");
        if (this.vD != null) {
          break label159;
        }
      }
      label159:
      for (int i = 0;; i = this.vD.size())
      {
        QLog.d("TroopAddFrdsInnerFrame", 2, i);
        this.a.this$0.a.getSharedPreferences("last_update_time" + this.a.this$0.e.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.a.this$0.mTroopUin, System.currentTimeMillis()).commit();
        TroopAddFrdsInnerFrame.a(this.a.this$0, this.a.this$0.mTroopUin, this.vD);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAddFrdsInnerFrame", 2, "onUpdateTroopGetMemberList:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.2.1
 * JD-Core Version:    0.7.0.1
 */