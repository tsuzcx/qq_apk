package com.tencent.biz.qqcircle.comment;

import android.widget.TextView;
import ovd;
import oyu;

public class QCircleCommentPanelView$5
  implements Runnable
{
  public QCircleCommentPanelView$5(oyu paramoyu, int paramInt) {}
  
  public void run()
  {
    if (oyu.a(this.this$0) != null)
    {
      if (this.BG > 0)
      {
        oyu.a(this.this$0).setText(ovd.aD(this.BG));
        oyu.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    oyu.a(this.this$0).setText("");
    oyu.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.5
 * JD-Core Version:    0.7.0.1
 */