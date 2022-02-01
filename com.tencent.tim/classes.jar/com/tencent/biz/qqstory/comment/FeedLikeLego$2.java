package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import pqu;
import psm;
import ptf;
import qvf;

public class FeedLikeLego$2
  implements Runnable
{
  public FeedLikeLego$2(pqu parampqu, ptf paramptf, String paramString, LikeEntry paramLikeEntry) {}
  
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Ptf.b(this.auu);
    LikeEntry localLikeEntry;
    if (localQQUserUIItem != null)
    {
      localLikeEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry;
      if (!localQQUserUIItem.isVip) {
        break label104;
      }
    }
    label104:
    for (long l = 2L;; l = 0L)
    {
      localLikeEntry.role = l;
      this.this$0.mx.add(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
      this.this$0.jdField_a_of_type_Psm.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
      this.this$0.jdField_a_of_type_Qvf.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      ThreadManager.getUIHandler().post(new FeedLikeLego.2.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.2
 * JD-Core Version:    0.7.0.1
 */