package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lhf;

public class ArticleInfoModule$55
  implements Runnable
{
  public ArticleInfoModule$55(lhf paramlhf, int paramInt) {}
  
  public void run()
  {
    List localList = this.this$0.mEntityManager.query(ArticleExposureInfo.class, true, "channelID = ?", new String[] { String.valueOf(this.aHH) }, null, null, "exposureTime desc", String.valueOf(100));
    if (localList != null)
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((Iterator)localObject).next();
        if ((localArticleExposureInfo != null) && (!TextUtils.isEmpty(localArticleExposureInfo.rowkey))) {
          localConcurrentHashMap.put(localArticleExposureInfo.rowkey, localArticleExposureInfo);
        }
      }
      localObject = (ConcurrentHashMap)lhf.c(this.this$0).get(Integer.valueOf(this.aHH));
      if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0)) {
        localConcurrentHashMap.putAll((Map)localObject);
      }
      lhf.c(this.this$0).put(Integer.valueOf(this.aHH), localConcurrentHashMap);
    }
    QLog.d("ArticleInfoModule", 1, "loadFeedsExposureInfo from db , channelID : " + this.aHH + ", result : " + localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.55
 * JD-Core Version:    0.7.0.1
 */