package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lhf;
import mhb;

public class ArticleInfoModule$11
  implements Runnable
{
  public ArticleInfoModule$11(lhf paramlhf, int paramInt, List paramList) {}
  
  public void run()
  {
    this.this$0.aON = this.aOP;
    this.this$0.hv = this.val$list;
    Object localObject;
    if (this.val$list != null)
    {
      localObject = this.val$list.iterator();
      while (((Iterator)localObject).hasNext())
      {
        mhb localmhb = (mhb)((Iterator)localObject).next();
        if (localmhb.mResult != 0) {
          QLog.e("ArticleInfoModule", 2, "dislike fail ,articleID : " + localmhb.mArticleId + ", failCode : " + localmhb.mResult + ",fialMessage : " + localmhb.mMessage);
        }
      }
    }
    if (this.this$0.aON == 0)
    {
      localObject = new StringBuilder().append("dislike upload successful ! count : ");
      if (this.val$list == null) {
        break label175;
      }
    }
    label175:
    for (int i = this.val$list.size();; i = 0)
    {
      QLog.d("ArticleInfoModule", 2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.11
 * JD-Core Version:    0.7.0.1
 */