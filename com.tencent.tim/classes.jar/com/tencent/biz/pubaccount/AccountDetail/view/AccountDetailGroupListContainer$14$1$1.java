package com.tencent.biz.pubaccount.AccountDetail.view;

import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import jtz;
import juk;
import juq;
import jur;

public class AccountDetailGroupListContainer$14$1$1
  implements Runnable
{
  public AccountDetailGroupListContainer$14$1$1(jur paramjur, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "saveAccountDetailInSubThread");
    }
    jtz.a(this.a.a.b.app, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.14.1.1
 * JD-Core Version:    0.7.0.1
 */