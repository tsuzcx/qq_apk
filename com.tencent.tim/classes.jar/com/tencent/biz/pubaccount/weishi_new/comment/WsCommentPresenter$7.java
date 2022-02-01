package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.TextView;
import ohl;
import sds;

public class WsCommentPresenter$7
  implements Runnable
{
  public WsCommentPresenter$7(ohl paramohl) {}
  
  public void run()
  {
    if (ohl.b(this.this$0) != null)
    {
      if (ohl.b(this.this$0) > 0L)
      {
        ohl.b(this.this$0).setText(sds.aO(ohl.b(this.this$0)));
        ohl.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    ohl.b(this.this$0).setText("");
    ohl.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.7
 * JD-Core Version:    0.7.0.1
 */