package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.view.Photo;
import com.tencent.view.RendererUtils;

public class PicBaseFilter
{
  private BaseFilter mBaseFilter;
  
  public PicBaseFilter(BaseFilter paramBaseFilter)
  {
    this.mBaseFilter = paramBaseFilter;
  }
  
  public QImage ApplyFilter(QImage paramQImage)
  {
    return null;
  }
  
  public void RendProcessImage(QImage paramQImage, Frame paramFrame)
  {
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = new int[2];
    int[] tmp12_10 = arrayOfInt1;
    tmp12_10[0] = 1;
    int[] tmp16_12 = tmp12_10;
    tmp16_12[1] = 1;
    tmp16_12;
    GLSLRender.nativePreprocessJepg(paramQImage, arrayOfInt1);
    int[] arrayOfInt2 = new int[1];
    GlUtil.glGenTextures(arrayOfInt2.length, arrayOfInt2, 0);
    float[] arrayOfFloat = new float[9];
    float[] tmp49_47 = arrayOfFloat;
    tmp49_47[0] = 1.0F;
    float[] tmp53_49 = tmp49_47;
    tmp53_49[1] = 0.0F;
    float[] tmp57_53 = tmp53_49;
    tmp57_53[2] = 0.0F;
    float[] tmp61_57 = tmp57_53;
    tmp61_57[3] = 0.0F;
    float[] tmp65_61 = tmp61_57;
    tmp65_61[4] = 1.0F;
    float[] tmp69_65 = tmp65_61;
    tmp69_65[5] = 0.0F;
    float[] tmp73_69 = tmp69_65;
    tmp73_69[6] = 0.0F;
    float[] tmp78_73 = tmp73_69;
    tmp78_73[7] = 0.0F;
    float[] tmp83_78 = tmp78_73;
    tmp83_78[8] = 1.0F;
    tmp83_78;
    int[] arrayOfInt3 = new int[2];
    int[] tmp96_94 = arrayOfInt3;
    tmp96_94[0] = 0;
    int[] tmp100_96 = tmp96_94;
    tmp100_96[1] = 0;
    tmp100_96;
    int i = 0;
    while (i < arrayOfInt1[0])
    {
      int j = 0;
      if (j < arrayOfInt1[1])
      {
        GLSLRender.nativePickJepgToTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], arrayOfInt2[0], arrayOfInt3);
        arrayOfFloat[0] = (arrayOfInt3[0] / paramQImage.getWidth());
        arrayOfFloat[4] = (arrayOfInt3[1] / paramQImage.getHeight());
        arrayOfFloat[2] = (i / arrayOfInt1[0]);
        arrayOfFloat[5] = (j / arrayOfInt1[1]);
        this.mBaseFilter.setGlobalTextureMatrix(arrayOfFloat);
        if (BitmapUtils.currentShareIndex >= 0)
        {
          this.mBaseFilter.RenderProcess(arrayOfInt2[0], arrayOfInt3[0], arrayOfInt3[1], -2, 0.0D, paramFrame);
          GLSLRender.nativePushJepgFromTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], BitmapUtils.currentShareIndex);
        }
        for (;;)
        {
          j += 1;
          break;
          this.mBaseFilter.RenderProcess(arrayOfInt2[0], arrayOfInt3[0], arrayOfInt3[1], -1, 0.0D, paramFrame);
          GLSLRender.nativePushJepgFromTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], BitmapUtils.currentShareIndex);
        }
      }
      i += 1;
    }
    this.mBaseFilter.setGlobalTextureMatrix(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    GLES20.glDeleteTextures(arrayOfInt2.length, arrayOfInt2, 0);
    LogUtils.d("BaseFilter", "RendProcessImage:" + (System.currentTimeMillis() - l));
  }
  
  public void clear()
  {
    this.mBaseFilter = null;
  }
  
  public void renderProcessBitmap(Bitmap paramBitmap, Frame paramFrame)
  {
    Photo localPhoto = Photo.createWithoutRecycle(paramBitmap);
    if (BitmapUtils.currentShareIndex < 0)
    {
      this.mBaseFilter.RenderProcess(localPhoto.texture(), localPhoto.width(), localPhoto.height(), localPhoto.texture(), 0.0D, paramFrame);
      RendererUtils.saveTextureToBitmap(localPhoto.texture(), localPhoto.width(), localPhoto.height(), paramBitmap);
    }
    for (;;)
    {
      localPhoto.clear();
      return;
      this.mBaseFilter.RenderProcess(localPhoto.texture(), localPhoto.width(), localPhoto.height(), -2, 0.0D, paramFrame);
      GLSLRender.nativePushBitmapFromTexture(paramBitmap, BitmapUtils.currentShareIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.filter.PicBaseFilter
 * JD-Core Version:    0.7.0.1
 */