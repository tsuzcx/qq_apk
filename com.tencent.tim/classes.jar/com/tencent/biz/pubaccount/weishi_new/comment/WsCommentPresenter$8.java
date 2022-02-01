package com.tencent.biz.pubaccount.weishi_new.comment;

import ogt;
import ohl;
import ooz;

public class WsCommentPresenter$8
  implements Runnable
{
  public WsCommentPresenter$8(ohl paramohl) {}
  
  public void run()
  {
    if (ohl.a(this.this$0) != null)
    {
      ohl.a(this.this$0).notifyDataSetChanged();
      return;
    }
    ooz.e(ohl.a(this.this$0), "updateAdapterOnUI, mCommentAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */