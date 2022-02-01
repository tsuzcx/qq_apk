package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ksw;
import kut;
import kut.a;
import kut.b;

public class ReadInJoyCommentPBModule$11
  implements Runnable
{
  public ReadInJoyCommentPBModule$11(kut paramkut, int paramInt, kut.a parama, String paramString, kut.b paramb) {}
  
  public void run()
  {
    if ("handleSubCommentList | retCode " + this.val$resultCode + " | hasNextPage " + this.jdField_a_of_type_Kut$a.hasNextPage + " | pageCookie " + this.jdField_a_of_type_Kut$a.acv + "| subCommentListSize " + this.jdField_a_of_type_Kut$a.gI != null) {}
    for (int i = this.jdField_a_of_type_Kut$a.gI.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentPBModule", 2, new Object[] { Integer.valueOf(i) });
      if (kut.a(this.this$0) != null) {
        kut.a(this.this$0).a(this.val$resultCode, this.acu, this.jdField_a_of_type_Kut$a, this.jdField_a_of_type_Kut$b);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.11
 * JD-Core Version:    0.7.0.1
 */