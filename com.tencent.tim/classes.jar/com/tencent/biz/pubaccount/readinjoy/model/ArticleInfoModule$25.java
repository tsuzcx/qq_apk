package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import lhf;

public class ArticleInfoModule$25
  implements Runnable
{
  public ArticleInfoModule$25(lhf paramlhf, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    if (!this.this$0.mEntityManager.remove(this.e)) {
      QLog.d("ArticleInfoModule", 2, "delete article fail ! title : " + this.e.mTitle + " , articleID : " + this.e.mArticleID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.25
 * JD-Core Version:    0.7.0.1
 */