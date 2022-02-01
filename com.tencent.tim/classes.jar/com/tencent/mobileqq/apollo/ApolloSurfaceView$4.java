package com.tencent.mobileqq.apollo;

class ApolloSurfaceView$4
  extends IApolloRunnableTask
{
  ApolloSurfaceView$4(ApolloSurfaceView paramApolloSurfaceView, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public String aV()
  {
    return "sendUpTouchToNative_nativeTouchInput";
  }
  
  public void run()
  {
    ApolloSurfaceView.nativeTouchInput(this.this$0.getRender().getSavaWrapper().Nn, this.aW, this.aX, this.jO, this.jP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */