package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import ycd;
import yda;

public class PublicAccountChatPie$34$1
  implements Runnable
{
  public PublicAccountChatPie$34$1(yda paramyda, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    AccountDetail localAccountDetail = new AccountDetail(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    EntityManager localEntityManager = this.jdField_a_of_type_Yda.this$0.app.getEntityManagerFactory(this.jdField_a_of_type_Yda.this$0.app.getAccount()).createEntityManager();
    if (localEntityManager != null) {
      localEntityManager.persistOrReplace(localAccountDetail);
    }
    this.jdField_a_of_type_Yda.this$0.b = PublicAccountInfo.createPublicAccount(localAccountDetail, 0L);
    this.jdField_a_of_type_Yda.this$0.a(this.jdField_a_of_type_Yda.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.34.1
 * JD-Core Version:    0.7.0.1
 */