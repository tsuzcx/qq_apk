package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import java.util.Iterator;
import java.util.List;
import lhi;

public class ArticleReadInfoModule$2
  implements Runnable
{
  public ArticleReadInfoModule$2(lhi paramlhi, List paramList) {}
  
  public void run()
  {
    if ((this.val$list != null) && (this.val$list.size() > 0))
    {
      Iterator localIterator = this.val$list.iterator();
      while (localIterator.hasNext())
      {
        ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)localIterator.next();
        this.this$0.a(localArticleReadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.2
 * JD-Core Version:    0.7.0.1
 */