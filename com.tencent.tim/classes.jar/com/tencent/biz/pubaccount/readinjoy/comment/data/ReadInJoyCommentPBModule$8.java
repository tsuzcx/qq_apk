package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ksw;
import kut;
import kut.a;
import kut.b;

public class ReadInJoyCommentPBModule$8
  implements Runnable
{
  public ReadInJoyCommentPBModule$8(kut paramkut, int paramInt, kut.a parama, kut.b paramb, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleHotCommentList | retCode ").append(this.val$resultCode).append(" | hasHotNextPage ").append(this.b.hasNextPage).append(" | hotPageCookie ").append(this.b.acv).append("| HotCommentCnt ");
    if (this.b.gH != null) {}
    for (int i = this.b.gH.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (kut.a(this.this$0) != null) {
        kut.a(this.this$0).b(this.val$resultCode, this.b, this.jdField_a_of_type_Kut$b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.8
 * JD-Core Version:    0.7.0.1
 */