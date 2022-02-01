package com.tencent.mobileqq.managers;

import aizp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class TroopAssistantManager$1
  implements Runnable
{
  public TroopAssistantManager$1(aizp paramaizp, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    localObject3 = null;
    localObject4 = this.this$0.object;
    localObject1 = localObject3;
    try
    {
      if (this.this$0.H != null)
      {
        localObject1 = localObject3;
        if (this.this$0.H.size() > 0) {
          localObject1 = this.this$0.H.toArray();
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("troopassist_guide", 2, localIllegalArgumentException.getMessage());
          localObject1 = localObject3;
        }
      }
    }
    finally {}
    if (localObject1 != null) {
      aqmk.a(this.val$app.getApp().getSharedPreferences(this.val$app.getAccount(), 0).edit(), "troop_assis_new_unread_list", (Object[])localObject1).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.1
 * JD-Core Version:    0.7.0.1
 */