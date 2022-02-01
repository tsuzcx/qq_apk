package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import kdm;

public class EcShopAssistantManager$3
  implements Runnable
{
  public EcShopAssistantManager$3(kdm paramkdm, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.mApp.a().createEntityManager();
    if (kdm.a(this.this$0, localEntityManager, this.val$uin)) {
      kdm.a(this.this$0, this.val$uin);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */