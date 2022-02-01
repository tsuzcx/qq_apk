package com.tencent.biz.pubaccount.readinjoy.comment.data;

import ksw;
import kut;

public class ReadInJoyCommentPBModule$10
  implements Runnable
{
  public ReadInJoyCommentPBModule$10(kut paramkut, int paramInt) {}
  
  public void run()
  {
    if (kut.a(this.this$0) != null)
    {
      if (this.val$resultCode == 10003) {
        kut.a(this.this$0).onCommentStateError(1002);
      }
    }
    else {
      return;
    }
    kut.a(this.this$0).onCommentStateError(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.10
 * JD-Core Version:    0.7.0.1
 */