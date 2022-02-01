package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ksw;
import kut;
import kut.a;
import kut.b;

public class ReadInJoyCommentPBModule$4
  implements Runnable
{
  public ReadInJoyCommentPBModule$4(kut paramkut, int paramInt, kut.a parama, kut.b paramb, CommentData paramCommentData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleFamilyCommentList | retCode ").append(this.val$resultCode).append(" | hasFamilyNextPage ").append(this.d.hasNextPage).append(" | familyPageCookie ").append(this.d.acv).append("| familyCommentCnt ").append(this.jdField_a_of_type_Kut$b.sN).append(" | familyCommentListSize ");
    if (this.d.gH != null) {}
    for (int i = this.d.gH.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 1, i);
      if (kut.a(this.this$0) != null) {
        kut.a(this.this$0).c(this.val$resultCode, this.d, this.jdField_a_of_type_Kut$b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4
 * JD-Core Version:    0.7.0.1
 */