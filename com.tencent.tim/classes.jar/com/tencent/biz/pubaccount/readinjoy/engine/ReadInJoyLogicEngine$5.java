package com.tencent.biz.pubaccount.readinjoy.engine;

import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.Locale;
import kxa;
import kxm;
import lbz;
import lhf;

public class ReadInJoyLogicEngine$5
  implements Runnable
{
  public ReadInJoyLogicEngine$5(lbz paramlbz, int paramInt) {}
  
  public void run()
  {
    Pair localPair = awit.a(lbz.a(this.this$0));
    if (this.aHH == 40677) {
      localPair = awit.b(lbz.a(this.this$0));
    }
    for (;;)
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L - ((Long)localPair.first).longValue();
      long l3 = lbz.access$100() / 1000L;
      Object localObject2 = (Long)lbz.access$200().get(Integer.valueOf(this.aHH));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Long.valueOf(0L);
      }
      if (((BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity)) || ((awit.Vs()) && (kxm.AK())) || (l1 - ((Long)localObject1).longValue() < ((Long)localPair.first).longValue()) || (l1 - l3 < kxa.aMo / 1000) || (l1 - l3 < ((Long)localPair.first).longValue())) {
        return;
      }
      if (lbz.a(this.this$0) != null) {
        lbz.a(this.this$0).m(this.aHH, l2, ((Integer)localPair.second).intValue());
      }
      localObject1 = this.this$0.getEntityManagerFactory().createEntityManager();
      localObject2 = String.format(Locale.CHINA, "delete from %s where mRecommendSeq not in ( select mRecommendSeq from %s where mChannelID = %d order by mRecommendSeq desc limit %d ) and mRecommendTime < %d  and mChannelID = %d ", new Object[] { ArticleInfo.TABLE_NAME, ArticleInfo.TABLE_NAME, Integer.valueOf(this.aHH), localPair.second, Long.valueOf(l2), Integer.valueOf(this.aHH) });
      if (!((EntityManager)localObject1).execSQL((String)localObject2)) {
        QLog.d("ArticleInfoModule", 2, "delete main outdated article fail !");
      }
      for (;;)
      {
        lbz.access$200().put(Integer.valueOf(this.aHH), Long.valueOf(l1));
        return;
        QLog.d("ArticleInfoModule", 2, "delete outdated article successful ! Sql is : " + (String)localObject2 + ", nowTime : " + l1 + ", interval : " + localPair.first + ", feedsCnt : " + localPair.second);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.5
 * JD-Core Version:    0.7.0.1
 */