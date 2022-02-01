package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ksw;
import kut;
import kut.a;
import kut.b;

public class ReadInJoyCommentPBModule$6
  implements Runnable
{
  public ReadInJoyCommentPBModule$6(kut paramkut, int paramInt, kut.a parama, kut.b paramb, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleNewCommentList | retCode ").append(this.val$resultCode).append(" | hasNewNextPage ").append(this.c.hasNextPage).append(" | newPageCookie ").append(this.c.acv).append("| newCommentCnt ").append(this.jdField_a_of_type_Kut$b.sN).append(" | newCommentListSize ");
    if (this.c.gH != null) {}
    for (int i = this.c.gH.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (kut.a(this.this$0) != null) {
        kut.a(this.this$0).a(this.val$resultCode, this.c, this.jdField_a_of_type_Kut$b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.6
 * JD-Core Version:    0.7.0.1
 */