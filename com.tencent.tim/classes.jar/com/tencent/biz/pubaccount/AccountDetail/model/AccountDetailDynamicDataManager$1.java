package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.qphone.base.util.QLog;
import jub;

public class AccountDetailDynamicDataManager$1
  implements Runnable
{
  public AccountDetailDynamicDataManager$1(jub paramjub, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.a(this.qL, this.val$data);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.1
 * JD-Core Version:    0.7.0.1
 */