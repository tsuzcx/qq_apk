package com.tencent.mobileqq.managers;

import aiyx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;

public class DraftTextManager$1
  implements Runnable
{
  public DraftTextManager$1(aiyx paramaiyx, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.val$app.a().createEntityManager();
    localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      localEntityManager.persistOrReplace(this.b);
      localEntityTransaction.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */