package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import ube;

public class DoraemonAPIReporterMain$1
  implements Runnable
{
  public DoraemonAPIReporterMain$1(ube paramube, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    List localList = this.val$app.a().createEntityManager().query(APIQuotaEntity.class, false, "type=? and appid=?", new String[] { String.valueOf(this.val$appType), this.val$appid }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0)) {
      ube.a(this.this$0, this.val$cacheKey, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.1
 * JD-Core Version:    0.7.0.1
 */