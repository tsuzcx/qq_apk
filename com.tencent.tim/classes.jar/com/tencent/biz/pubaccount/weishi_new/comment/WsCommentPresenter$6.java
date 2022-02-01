package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ListView;
import ohl;
import ooz;

public class WsCommentPresenter$6
  implements Runnable
{
  public WsCommentPresenter$6(ohl paramohl) {}
  
  public void run()
  {
    ohl.d(this.this$0);
    ooz.e(ohl.a(this.this$0), "onResponse, lastPosition:" + ohl.c(this.this$0) + ",currentPosition:" + ohl.b(this.this$0));
    if (this.this$0.l != null) {
      this.this$0.l.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.6
 * JD-Core Version:    0.7.0.1
 */