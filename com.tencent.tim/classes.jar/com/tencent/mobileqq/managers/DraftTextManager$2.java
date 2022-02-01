package com.tencent.mobileqq.managers;

import aiyx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

public class DraftTextManager$2
  implements Runnable
{
  public DraftTextManager$2(aiyx paramaiyx, DraftTextInfo paramDraftTextInfo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = this.c;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.this$0.a(this.val$app, this.val$uin, this.val$type);
    }
    localObject3 = this.val$app.a().createEntityManager();
    try
    {
      ((EntityManager)localObject3).remove((Entity)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityManager)localObject3).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.2
 * JD-Core Version:    0.7.0.1
 */