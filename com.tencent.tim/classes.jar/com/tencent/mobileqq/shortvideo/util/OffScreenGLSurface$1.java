package com.tencent.mobileqq.shortvideo.util;

import ankm;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class OffScreenGLSurface$1
  implements Runnable
{
  public OffScreenGLSurface$1(ankm paramankm) {}
  
  public void run()
  {
    ankm.a(this.this$0).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1
 * JD-Core Version:    0.7.0.1
 */