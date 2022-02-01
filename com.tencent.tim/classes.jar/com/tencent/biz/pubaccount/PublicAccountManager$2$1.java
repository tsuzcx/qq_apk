package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import kaw;
import kbe;
import mqq.observer.BusinessObserver;

public class PublicAccountManager$2$1
  implements Runnable
{
  public PublicAccountManager$2$1(kbe paramkbe, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_Kbe.this$0.a(this.jdField_a_of_type_Kbe.val$app, this.jdField_a_of_type_Kbe.val$uin, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse);
    if (this.jdField_a_of_type_Kbe.val$observer != null) {
      this.jdField_a_of_type_Kbe.val$observer.onReceive(this.val$type, this.val$isSuccess, this.val$bundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountManager.2.1
 * JD-Core Version:    0.7.0.1
 */