package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

class QQAVImageFilter$1
  implements Runnable
{
  QQAVImageFilter$1(QQAVImageFilter paramQQAVImageFilter, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    GLES20.glUniform1i(this.val$location, this.val$intValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter.1
 * JD-Core Version:    0.7.0.1
 */