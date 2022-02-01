package com.tencent.mobileqq.apollo.process.data;

import abos;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameLauncher$3
  implements Runnable
{
  public CmGameLauncher$3(abos paramabos) {}
  
  public void run()
  {
    if (abos.a(this.this$0) != null)
    {
      abos.a(this.this$0).setPreserveEGLContextOnPause(true);
      abos.a(this.this$0).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3
 * JD-Core Version:    0.7.0.1
 */