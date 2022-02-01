package com.tencent.av.video.effect.core.qqavimage.SpecialFilter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

public class QQAVImageTwoSrcFilter
  extends QQAVImageThreeInputFilter
{
  private int mHeightLocation;
  private int mWidthLocation;
  
  public QQAVImageTwoSrcFilter()
  {
    super(String.valueOf(37));
  }
  
  public void onInit()
  {
    super.onInit();
    this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mWidthLocation, paramInt1);
    setFloat(this.mHeightLocation, paramInt2);
  }
  
  public void setBitmap(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {}
    do
    {
      do
      {
        return;
      } while (paramBitmap == null);
      if (paramInt == 0)
      {
        this.filterSourceTexture2 = OpenGlUtils.loadTexture(paramBitmap, this.filterSourceTexture2, false);
        return;
      }
    } while (paramInt != 1);
    this.filterSourceTexture3 = OpenGlUtils.loadTexture(paramBitmap, this.filterSourceTexture3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoSrcFilter
 * JD-Core Version:    0.7.0.1
 */