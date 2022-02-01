package com.tencent.mobileqq.apollo;

import abja;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$6
  implements Runnable
{
  ApolloRender$6(ApolloRender paramApolloRender, abja paramabja, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.a != null)
    {
      QLog.d("sava_ApolloRender", 2, "cb.onSurfaceReady");
      this.a.onSurfaceReady(this.val$width, this.val$height);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.6
 * JD-Core Version:    0.7.0.1
 */