package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kxm;
import lhf;
import mhr;
import mhr.a;
import mhr.c;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.TopicInfo;

public class ArticleInfoModule$48
  implements Runnable
{
  public ArticleInfoModule$48(lhf paramlhf, int paramInt, Set paramSet, List paramList) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)lhf.a(this.this$0).get(Integer.valueOf(this.aMH));
    Iterator localIterator1 = this.V.iterator();
    while (localIterator1.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)localConcurrentHashMap.get(Long.valueOf(((Long)localIterator1.next()).longValue()));
      if ((localArticleInfo != null) && (kxm.x(localArticleInfo)) && (localArticleInfo.mNewPolymericInfo.iP != null))
      {
        Iterator localIterator2 = localArticleInfo.mNewPolymericInfo.iP.iterator();
        while (localIterator2.hasNext())
        {
          mhr.a locala = (mhr.a)localIterator2.next();
          if (locala.a != null)
          {
            Iterator localIterator3 = this.hH.iterator();
            while (localIterator3.hasNext())
            {
              oidb_cmd0xa6e.TopicInfo localTopicInfo = (oidb_cmd0xa6e.TopicInfo)localIterator3.next();
              if (locala.a.aSe == localTopicInfo.uint64_topic_id.get()) {
                locala.a.joinCount = localTopicInfo.uint32_pv.get();
              }
            }
          }
        }
        localArticleInfo.invalidateProteusTemplateBean();
        this.this$0.a(localArticleInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.48
 * JD-Core Version:    0.7.0.1
 */