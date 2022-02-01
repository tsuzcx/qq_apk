package com.tencent.biz.subscribe.comment;

import android.widget.TextView;
import scw;
import scw.c;
import sds;

public class CommentPresenter$2
  implements Runnable
{
  public CommentPresenter$2(scw paramscw) {}
  
  public void run()
  {
    if (scw.a(this.this$0) != null) {
      scw.a(this.this$0).yk(scw.a(this.this$0));
    }
    if (scw.a(this.this$0) != null)
    {
      if (scw.a(this.this$0) > 0)
      {
        scw.a(this.this$0).setText(sds.aO(scw.a(this.this$0)));
        scw.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    scw.a(this.this$0).setText("");
    scw.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */