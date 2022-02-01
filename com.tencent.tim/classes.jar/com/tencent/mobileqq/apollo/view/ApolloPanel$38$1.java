package com.tencent.mobileqq.apollo.view;

import abhh;
import abhh.d;
import acau;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;

public class ApolloPanel$38$1
  implements Runnable
{
  public ApolloPanel$38$1(acau paramacau) {}
  
  public void run()
  {
    this.a.this$0.jy.setVisibility(8);
    ApolloPanel.a(this.a.this$0).setVisibility(8);
    if (abhh.d.bCU)
    {
      ApolloPanel.a(this.a.this$0).setVisibility(0);
      ApolloPanel.b(this.a.this$0).setVisibility(0);
      abhh.t(101, String.valueOf(abhh.d.coN), abhh.d.sTraceInfo);
    }
    while (ApolloPanel.a(this.a.this$0).getVisibility() == 0)
    {
      ApolloPanel.a(this.a.this$0).setVisibility(0);
      if (this.a.this$0.a == null) {
        this.a.this$0.a = new ApolloPanel.a(this.a.this$0);
      }
      ApolloPanel.a(this.a.this$0).setOnClickListener(this.a.this$0.a);
      this.a.this$0.a.cGQ();
      return;
      ApolloPanel.a(this.a.this$0).setVisibility(8);
      ApolloPanel.b(this.a.this$0).setVisibility(8);
    }
    ApolloPanel.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.38.1
 * JD-Core Version:    0.7.0.1
 */