package com.Vas.ColorFont;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import aqgz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import j;

public class FreeTypeLib
{
  private int[] V;
  
  private int[] d()
  {
    if (this.V == null)
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      this.V = new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels };
    }
    return this.V;
  }
  
  public void Z()
  {
    int i = 1;
    int[] arrayOfInt = d();
    int j = (int)aqgz.getCpuMaxFreq();
    int k = Runtime.getRuntime().availableProcessors();
    int m = (int)(aqgz.getSystemTotalMemory() / 1024L);
    j.i("FreeTypeLib", "......cpuFrequency:" + j + "   maxMemory:" + m);
    int n = arrayOfInt[0];
    int i1 = arrayOfInt[1];
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      initRender(n, i1, i, Build.VERSION.SDK_INT, Build.VERSION.RELEASE, Build.BRAND, Build.MODEL, k, j, m);
      return;
      i = 0;
    }
  }
  
  public native int[] calculateExpressionSize(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7, int[] paramArrayOfInt8, int paramInt2, int paramInt3, int paramInt4, long paramLong);
  
  public native int clearCache();
  
  public native int drawAnimationText(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt6, int paramInt8);
  
  public native int drawSpecialEffectsText(int paramInt1, int[] paramArrayOfInt1, long paramLong, int paramInt2, Bitmap paramBitmap, int[] paramArrayOfInt2);
  
  public native int drawStrikingText(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt7, int paramInt8);
  
  public native int drawText(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt6, int paramInt6);
  
  public native int[] getBitmapWH(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, long paramLong, int[] paramArrayOfInt4);
  
  public native int getExtraBitmap(int paramInt1, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2);
  
  public native int getFontColor(int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public native int getFontVersion(String paramString);
  
  public native int getHiBoomViewSize(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int getTextWidths(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2);
  
  public native int initColorFont(int paramInt, String paramString, int[] paramArrayOfInt);
  
  public native void initRender(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5, int paramInt6, int paramInt7);
  
  public native int releaseColorFont(int paramInt);
  
  public native int renderExpressionBitmap(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, Bitmap paramBitmap, int[] paramArrayOfInt7, int paramInt6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.Vas.ColorFont.FreeTypeLib
 * JD-Core Version:    0.7.0.1
 */