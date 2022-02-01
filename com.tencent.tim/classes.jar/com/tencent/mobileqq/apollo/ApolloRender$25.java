package com.tencent.mobileqq.apollo;

import com.tencent.ttpic.util.youtu.VideoFaceDetector;

final class ApolloRender$25
  implements Runnable
{
  ApolloRender$25(ApolloRender paramApolloRender, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.b.mDetector.doFaceDetect(this.val$data, this.val$width, this.val$height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.25
 * JD-Core Version:    0.7.0.1
 */