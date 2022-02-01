package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lcc;
import lhf;

public class ArticleInfoModule$53
  implements Runnable
{
  public ArticleInfoModule$53(lhf paramlhf, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "onTopicInfoListFetched: keywordList: " + this.hO + " topicInfoList: " + this.hP);
    }
    lcc.a().l(this.hO, this.hP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.53
 * JD-Core Version:    0.7.0.1
 */