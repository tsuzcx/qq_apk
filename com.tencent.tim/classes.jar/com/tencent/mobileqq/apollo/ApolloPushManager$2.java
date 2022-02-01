package com.tencent.mobileqq.apollo;

import abht;
import abht.a;
import com.tencent.mobileqq.data.ApolloActionPush;
import mqq.util.WeakReference;

public class ApolloPushManager$2
  implements Runnable
{
  public ApolloPushManager$2(abht paramabht, int paramInt, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (abht.a(this.this$0) != null)
    {
      abht.a locala = (abht.a)abht.a(this.this$0).get();
      if (locala != null) {
        locala.a(this.cgr, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.2
 * JD-Core Version:    0.7.0.1
 */