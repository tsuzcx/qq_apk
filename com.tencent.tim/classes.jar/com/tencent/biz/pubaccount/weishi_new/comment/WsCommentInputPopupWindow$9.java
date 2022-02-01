package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.ImageButton;
import ohe;

public class WsCommentInputPopupWindow$9
  implements Runnable
{
  public WsCommentInputPopupWindow$9(ohe paramohe, int paramInt) {}
  
  public void run()
  {
    ohe.b(this.this$0, true);
    ohe.a(this.this$0).setVisibility(0);
    ohe.b(this.this$0).setVisibility(8);
    if (this.beZ == 2) {
      ohe.c(this.this$0).performClick();
    }
    while (this.beZ != 3) {
      return;
    }
    ohe.d(this.this$0).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.9
 * JD-Core Version:    0.7.0.1
 */