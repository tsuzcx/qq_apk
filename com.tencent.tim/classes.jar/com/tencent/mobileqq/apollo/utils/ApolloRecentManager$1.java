package com.tencent.mobileqq.apollo.utils;

import abxk;
import abyu;

public class ApolloRecentManager$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.mApp == null) {
      return;
    }
    if (this.a == null)
    {
      abxk.a(this.this$0.mApp, this.b);
      return;
    }
    abxk.a(this.this$0.mApp, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloRecentManager.1
 * JD-Core Version:    0.7.0.1
 */