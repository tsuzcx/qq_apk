package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import lhf;

public class ArticleInfoModule$12
  implements Runnable
{
  public ArticleInfoModule$12(lhf paramlhf, int paramInt) {}
  
  public void run()
  {
    this.this$0.mEntityManager.execSQL("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.aHH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.12
 * JD-Core Version:    0.7.0.1
 */