package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;

public class BitmapBlur
{
  private static final String a = BitmapBlur.class.getSimpleName();
  
  private static int a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int j = paramInt >> 24 & 0xFF;
    int i = j;
    if (!paramBoolean) {
      i = (int)(j * paramFloat);
    }
    return i << 24 | (int)((paramInt >> 16 & 0xFF) * paramFloat) << 16 | (int)((paramInt >> 8 & 0xFF) * paramFloat) << 8 | (int)((paramInt & 0xFF) * paramFloat);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled()) {
        break label38;
      }
      throw new IllegalArgumentException("Bitmap is invliad!");
    }
    catch (Exception paramBitmap)
    {
      localBitmap = null;
    }
    QLog.d("GuassianBlur", 4, paramBitmap.getMessage());
    return localBitmap;
    label38:
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 <= 0) || (paramInt4 <= 0) || (paramInt1 + paramInt3 > paramBitmap.getWidth()) || (paramInt2 + paramInt4 > paramBitmap.getHeight())) {
      throw new IllegalArgumentException("One or more bitmap parameters are invliad!");
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    for (;;)
    {
      try
      {
        new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
        float[] arrayOfFloat = new float[19];
        float[] tmp127_125 = arrayOfFloat;
        tmp127_125[0] = 3.814697E-006F;
        float[] tmp132_127 = tmp127_125;
        tmp132_127[1] = 6.866455E-005F;
        float[] tmp137_132 = tmp132_127;
        tmp137_132[2] = 0.0005836487F;
        float[] tmp142_137 = tmp137_132;
        tmp142_137[3] = 0.00311279F;
        float[] tmp147_142 = tmp142_137;
        tmp147_142[4] = 0.01167297F;
        float[] tmp152_147 = tmp147_142;
        tmp152_147[5] = 0.03268433F;
        float[] tmp157_152 = tmp152_147;
        tmp157_152[6] = 0.070816F;
        float[] tmp163_157 = tmp157_152;
        tmp163_157[7] = 0.1213989F;
        float[] tmp169_163 = tmp163_157;
        tmp169_163[8] = 0.1669235F;
        float[] tmp175_169 = tmp169_163;
        tmp175_169[9] = 0.1854706F;
        float[] tmp181_175 = tmp175_169;
        tmp181_175[10] = 0.1669235F;
        float[] tmp187_181 = tmp181_175;
        tmp187_181[11] = 0.1213989F;
        float[] tmp193_187 = tmp187_181;
        tmp193_187[12] = 0.070816F;
        float[] tmp199_193 = tmp193_187;
        tmp199_193[13] = 0.03268433F;
        float[] tmp205_199 = tmp199_193;
        tmp205_199[14] = 0.01167297F;
        float[] tmp211_205 = tmp205_199;
        tmp211_205[15] = 0.00311279F;
        float[] tmp217_211 = tmp211_205;
        tmp217_211[16] = 0.0005836487F;
        float[] tmp223_217 = tmp217_211;
        tmp223_217[17] = 6.866455E-005F;
        float[] tmp229_223 = tmp223_217;
        tmp229_223[18] = 3.814697E-006F;
        tmp229_223;
        int i1 = arrayOfFloat.length / 2;
        int[] arrayOfInt = new int[paramInt3 * paramInt4 * 4];
        int j = paramInt2;
        continue;
        int i;
        int n = a(paramBitmap.getPixel(n, j), arrayOfFloat[(i - k + i1)], false);
        i += 1;
        int m = n + m;
        continue;
        localBitmap.setPixels(arrayOfInt, 0, paramInt3, 0, 0, paramInt3, paramInt4);
        paramInt2 = 0;
        continue;
        int k = a(localBitmap.getPixel(i, k), arrayOfFloat[(paramInt1 - paramInt2 + i1)], false);
        paramInt1 += 1;
        j = k + j;
        if (paramBoolean)
        {
          arrayOfInt[m] = a(j, 0.8F, true);
          continue;
          localBitmap.setPixels(arrayOfInt, 0, paramInt3, 0, 0, paramInt3, paramInt4);
          return localBitmap;
          k = paramInt1;
          continue;
          n = i;
          continue;
          if (j < paramInt2 + paramInt4)
          {
            k = paramInt1;
            if (k < paramInt1 + paramInt3)
            {
              i = k - i1;
              m = 0;
              if (i <= k + i1)
              {
                if ((i >= paramInt1) && (i < paramInt1 + paramInt3)) {
                  continue;
                }
                n = k * 2 - i;
                continue;
              }
              arrayOfInt[((j - paramInt2) * paramInt3 + (k - paramInt1))] = m;
              k += 1;
              continue;
            }
            j += 1;
            continue;
          }
          continue;
          if (paramInt2 >= paramInt4) {
            continue;
          }
          i = 0;
          if (i < paramInt3)
          {
            m = paramInt2 * paramInt3 + i;
            paramInt1 = paramInt2 - i1;
            j = 0;
            if (paramInt1 > paramInt2 + i1) {
              continue;
            }
            if ((paramInt1 >= 0) && (paramInt1 < paramInt4)) {
              continue;
            }
            k = paramInt2 * 2 - paramInt1;
            continue;
            i += 1;
            continue;
          }
        }
        else
        {
          arrayOfInt[m] = j;
          continue;
        }
      }
      catch (Exception paramBitmap) {}
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.BitmapBlur
 * JD-Core Version:    0.7.0.1
 */