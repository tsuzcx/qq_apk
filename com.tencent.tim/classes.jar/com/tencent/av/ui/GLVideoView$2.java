package com.tencent.av.ui;

import com.tencent.av.opengl.ui.GLRootView;
import izm;

public class GLVideoView$2
  implements Runnable
{
  public GLVideoView$2(izm paramizm) {}
  
  public void run()
  {
    GLRootView localGLRootView = this.this$0.a();
    if (localGLRootView != null)
    {
      izm.e(this.this$0);
      localGLRootView.postDelayed(this.this$0.bT, 80L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.2
 * JD-Core Version:    0.7.0.1
 */