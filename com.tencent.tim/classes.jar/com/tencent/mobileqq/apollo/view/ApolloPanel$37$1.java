package com.tencent.mobileqq.apollo.view;

import abhh.d;
import acat;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;

public class ApolloPanel$37$1
  implements Runnable
{
  public ApolloPanel$37$1(acat paramacat) {}
  
  public void run()
  {
    ApolloPanel.a(this.a.this$0).setVisibility(0);
    this.a.this$0.jy.setVisibility(0);
    ApolloPanel.a(this.a.this$0).setVisibility(8);
    if ((abhh.d.bCU) && (ApolloPanel.d(this.a.this$0)))
    {
      ApolloPanel.a(this.a.this$0).setVisibility(0);
      ApolloPanel.b(this.a.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (ApolloPanel.a(this.a.this$0).getVisibility() == 0) {
        ApolloPanel.a(this.a.this$0).setOnClickListener(this.a.this$0);
      }
      return;
      ApolloPanel.a(this.a.this$0).setVisibility(8);
      ApolloPanel.b(this.a.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.37.1
 * JD-Core Version:    0.7.0.1
 */