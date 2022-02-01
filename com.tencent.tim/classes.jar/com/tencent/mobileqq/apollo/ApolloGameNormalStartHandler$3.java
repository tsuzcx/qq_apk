package com.tencent.mobileqq.apollo;

import abhf;
import abhg;
import abzn;

public class ApolloGameNormalStartHandler$3
  implements Runnable
{
  public void run()
  {
    if (abhf.a(this.this$0) == null) {
      abhf.a(this.this$0, new abzn(this.val$activity));
    }
    abhf.a(this.this$0).setClickListener(new abhg(this));
    abhf.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.3
 * JD-Core Version:    0.7.0.1
 */