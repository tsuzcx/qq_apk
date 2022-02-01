package com.tencent.biz.pubaccount.AccountDetail.model;

import acje;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import jtr;
import jub;
import juc;

public class AccountDetailDynamicDataManager$2
  implements Runnable
{
  public AccountDetailDynamicDataManager$2(jub paramjub, long paramLong, QQAppInterface paramQQAppInterface, acje paramacje) {}
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)jub.a(this.this$0).find(DynamicInfoEntity.class, this.qL);
    if ((localObject != null) && (this.qL == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = juc.a(this.val$app, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = jub.a(this.val$app).a(this.qL);
      if ((i == 0) && (localObject != null) && (!((jtr)localObject).aZ().isEmpty())) {
        this.a.I(true, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2
 * JD-Core Version:    0.7.0.1
 */