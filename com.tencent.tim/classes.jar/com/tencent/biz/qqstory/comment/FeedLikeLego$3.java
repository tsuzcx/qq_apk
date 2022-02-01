package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import pqu;
import psm;
import qvf;

public class FeedLikeLego$3
  implements Runnable
{
  public FeedLikeLego$3(pqu parampqu, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Qvf.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0)
    {
      CommentLikeFeedItem localCommentLikeFeedItem = this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mLikeCount -= 1;
    }
    int i = 0;
    while (i < this.this$0.mx.size())
    {
      if (((LikeEntry)this.this$0.mx.get(i)).unionId.equals(this.auu))
      {
        this.this$0.jdField_a_of_type_Psm.b((LikeEntry)this.this$0.mx.get(i));
        this.this$0.mx.remove(i);
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new FeedLikeLego.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.3
 * JD-Core Version:    0.7.0.1
 */