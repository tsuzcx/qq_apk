package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import ube;

public class DoraemonAPIReporterMain$3
  implements Runnable
{
  public DoraemonAPIReporterMain$3(ube paramube, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.val$app.a().createEntityManager();
    APIQuotaEntity localAPIQuotaEntity = new APIQuotaEntity();
    localAPIQuotaEntity.type = this.val$appType;
    localAPIQuotaEntity.appid = this.val$appid;
    localAPIQuotaEntity.apiName = this.val$apiName;
    localAPIQuotaEntity.remainTimes = this.Fb;
    localAPIQuotaEntity.expireTimeMillis = this.Fc;
    localEntityManager.persistOrReplace(localAPIQuotaEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.3
 * JD-Core Version:    0.7.0.1
 */