package com.tencent.biz.pubaccount.readinjoy.comment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import ksi;
import ykm;

public class ReadInJoyCommentComponentFragment$8$1
  implements Runnable
{
  public ReadInJoyCommentComponentFragment$8$1(ksi paramksi) {}
  
  public void run()
  {
    ykm localykm = ReadInJoyCommentComponentFragment.a(this.a.this$0);
    if ((localykm != null) && (ReadInJoyCommentComponentFragment.a(this.a.this$0)))
    {
      localykm.ciX();
      ReadInJoyCommentComponentFragment.a(this.a.this$0, false);
      this.a.this$0.iB.setSelected(false);
    }
    this.a.this$0.ix.setImageDrawable(ReadInJoyDeliverUGCActivity.a(this.a.this$0.a));
    this.a.this$0.eP.setVisibility(0);
    ReadInJoyCommentComponentFragment.a(this.a.this$0);
    if (this.a.this$0.isSelected)
    {
      this.a.this$0.iC.setImageResource(2130843667);
      ReadInJoyCommentComponentFragment.b(this.a.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.8.1
 * JD-Core Version:    0.7.0.1
 */