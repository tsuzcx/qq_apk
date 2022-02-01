package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import ycd;

public class PublicAccountChatPie$31
  implements Runnable
{
  public PublicAccountChatPie$31(ycd paramycd, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    try
    {
      EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
      PublicAccountMenuEntity localPublicAccountMenuEntity = (PublicAccountMenuEntity)localEntityManager.find(PublicAccountMenuEntity.class, this.this$0.sessionInfo.aTl);
      if (localPublicAccountMenuEntity != null) {
        localEntityManager.remove(localPublicAccountMenuEntity);
      }
      if (localEntityManager != null) {
        localEntityManager.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.this$0.TAG, 4, localException.getMessage());
        }
      }
    }
    this.val$sp.edit().putBoolean(this.val$key, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31
 * JD-Core Version:    0.7.0.1
 */