package com.tencent.qqmail.utilities.draw;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import java.io.FileOutputStream;

public class DrawIcon
{
  private static int drawBorderColor = -3881788;
  private static int drawTextColor;
  private static final int[] symbols = { 65505, 12310, 12311, 12302, 12303, 12308, 12309, 8203, 183, 65128, 65289, 12305, 12298, 65292, 12289, 65374, 65281, 65312, 65283, 65509, 8230, 215, 8212, 65371, 12304, 65373, 8221, 8216, 8220, 8217, 12299, 12290, 65507, 65344, 65284, 65285, 65342, 65286, 65290, 65288, 65343, 65293, 65291, 65309, 65339, 65341, 65372, 65340, 65306, 65307, 65282, 65287, 65308, 65310, 65294, 65311, 65295, 12288 };
  
  static
  {
    drawTextColor = -9013642;
  }
  
  public static Bitmap drawCircleIcon(float paramFloat1, float paramFloat2, String paramString1, String paramString2)
  {
    int k = (int)(paramFloat1 * paramFloat2);
    int i = (int)(paramFloat1 / 22.0F);
    int j = k / 2;
    float f = 10.0F;
    Object localObject = new Rect();
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    if (paramFloat1 == QMAvatar.getIconSize(0))
    {
      i = 1;
      f = 14.0F * paramFloat2;
      localBitmap = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint(1);
      localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localCanvas.drawColor(Color.alpha(0));
      localPaint.setColor(drawBorderColor);
      localCanvas.drawCircle(j, j, j, localPaint);
      localPaint.setColor(-1);
      localCanvas.drawCircle(j, j, j - i, localPaint);
      localPaint.setColor(drawTextColor);
      localPaint.setTextSize(f);
      localPaint.setTextAlign(Paint.Align.CENTER);
      if (paramString2.length() <= 1) {
        break label355;
      }
      localPaint.getTextBounds("AA", 0, paramString2.length(), (Rect)localObject);
      i = ((Rect)localObject).bottom - ((Rect)localObject).top;
      localPaint.getTextBounds(paramString2, 0, paramString2.length(), (Rect)localObject);
      k = Math.abs(((Rect)localObject).bottom - ((Rect)localObject).top - i) / 2;
      localCanvas.drawText(paramString2, j, i / 2 + j - k, localPaint);
    }
    for (;;)
    {
      localCanvas.save();
      Threads.runInBackground(new DrawIcon.1(paramString1, localBitmap));
      return localBitmap;
      if (paramFloat1 == QMAvatar.getIconSize(1))
      {
        i = 2;
        f = 18.0F * paramFloat2;
        break;
      }
      if (paramFloat1 == QMAvatar.getIconSize(2))
      {
        i = 2;
        f = 24.0F * paramFloat2;
        break;
      }
      if (paramFloat1 != QMAvatar.getIconSize(5)) {
        break;
      }
      i = 2;
      f = 48.0F * paramFloat2;
      break;
      label355:
      if (paramString2.charAt(0) > '')
      {
        localObject = localPaint.getFontMetrics();
        paramFloat2 = ((Paint.FontMetrics)localObject).bottom;
        f = ((Paint.FontMetrics)localObject).top;
        paramFloat1 = k;
        paramFloat2 = (k - (paramFloat2 - f)) / 2.0F;
        f = ((Paint.FontMetrics)localObject).bottom;
        localCanvas.drawText(paramString2, j, paramFloat1 - paramFloat2 - f, localPaint);
      }
      else
      {
        localPaint.getTextBounds("A", 0, paramString2.length(), (Rect)localObject);
        i = ((Rect)localObject).bottom - ((Rect)localObject).top;
        localPaint.getTextBounds(paramString2, 0, paramString2.length(), (Rect)localObject);
        k = Math.abs(((Rect)localObject).bottom - ((Rect)localObject).top - i) / 2;
        localCanvas.drawText(paramString2, j, i / 2 + j - k, localPaint);
      }
    }
  }
  
  public static Bitmap drawRoundRectIcon(float paramFloat1, float paramFloat2, String paramString1, String paramString2)
  {
    int j = (int)(paramFloat1 * paramFloat2);
    int i = j / 2;
    paramFloat1 = 3.0F * paramFloat2;
    float f = 3.0F * paramFloat2 - 1.0F;
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Paint localPaint = new Paint(1);
    Object localObject = new Rect();
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
    localCanvas.drawColor(Color.alpha(0));
    localPaint.setColor(drawBorderColor);
    localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, j), paramFloat1, paramFloat1, localPaint);
    localPaint.setColor(-1);
    localCanvas.drawRoundRect(new RectF(1, 1, j - 1, j - 1), f, f, localPaint);
    localPaint.setColor(drawTextColor);
    localPaint.setTextSize(14.0F * paramFloat2);
    localPaint.setTextAlign(Paint.Align.CENTER);
    int k;
    if (paramString2.length() > 1)
    {
      localPaint.getTextBounds("AA", 0, paramString2.length(), (Rect)localObject);
      j = ((Rect)localObject).bottom - ((Rect)localObject).top;
      localPaint.getTextBounds(paramString2, 0, paramString2.length(), (Rect)localObject);
      k = Math.abs(((Rect)localObject).bottom - ((Rect)localObject).top - j) / 2;
      localCanvas.drawText(paramString2, i, j / 2 + i - k, localPaint);
    }
    for (;;)
    {
      localCanvas.save();
      try
      {
        paramString1 = new FileOutputStream(paramString1);
        localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString1);
        paramString1.close();
        return localBitmap;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      if (paramString2.charAt(0) > '')
      {
        localObject = localPaint.getFontMetrics();
        paramFloat2 = ((Paint.FontMetrics)localObject).bottom;
        f = ((Paint.FontMetrics)localObject).top;
        paramFloat1 = j;
        paramFloat2 = (j - (paramFloat2 - f)) / 2.0F;
        f = ((Paint.FontMetrics)localObject).bottom;
        localCanvas.drawText(paramString2, i, paramFloat1 - paramFloat2 - f, localPaint);
      }
      else
      {
        localPaint.getTextBounds("A", 0, paramString2.length(), (Rect)localObject);
        j = ((Rect)localObject).bottom - ((Rect)localObject).top;
        localPaint.getTextBounds(paramString2, 0, paramString2.length(), (Rect)localObject);
        k = Math.abs(((Rect)localObject).bottom - ((Rect)localObject).top - j) / 2;
        localCanvas.drawText(paramString2, i, j / 2 + i - k, localPaint);
      }
    }
    return localBitmap;
  }
  
  public static String getDrawString(String paramString)
  {
    Object localObject1 = "";
    int m = 0;
    int j = 0;
    int i = 0;
    int i1;
    int n;
    char c;
    for (;;)
    {
      if ((m >= paramString.length()) || (j > 0)) {
        return localObject1;
      }
      i1 = paramString.charAt(m);
      if (i1 <= 127) {
        break;
      }
      k = 0;
      for (;;)
      {
        n = i;
        if (k < symbols.length)
        {
          if (i1 == symbols[k]) {
            n = 1;
          }
        }
        else
        {
          if (n != 0) {
            break;
          }
          c = (char)i1;
          return c + "";
        }
        k += 1;
      }
      i = 0;
      m += 1;
    }
    Object localObject2;
    if ((i1 < 65) || (i1 > 90))
    {
      k = j;
      localObject2 = localObject1;
      if (i1 >= 97)
      {
        k = j;
        localObject2 = localObject1;
        if (i1 > 122) {}
      }
    }
    else
    {
      n = m;
      k = j;
      localObject2 = localObject1;
      if (n < paramString.length())
      {
        i1 = paramString.charAt(n);
        if ((i1 < 65) || (i1 > 90))
        {
          k = j;
          localObject2 = localObject1;
          if (i1 >= 97)
          {
            k = j;
            localObject2 = localObject1;
            if (i1 > 122) {}
          }
        }
        else
        {
          if (j != 0) {
            break label303;
          }
          if ((i1 < 97) || (i1 > 122)) {
            break label464;
          }
        }
      }
    }
    label303:
    label439:
    label464:
    for (int k = i1 - 32;; k = i1)
    {
      c = (char)k;
      localObject2 = c + "";
      k = j + 1;
      do
      {
        for (;;)
        {
          n += 1;
          j = k;
          localObject1 = localObject2;
          break;
          if (j != 1) {
            break label439;
          }
          if ((((String)localObject1).charAt(0) == i1) || (((String)localObject1).charAt(0) == i1 - 32))
          {
            localObject2 = (String)localObject1 + ((String)localObject1).charAt(0) + "";
            k = j + 1;
          }
          else
          {
            k = i1;
            if (i1 >= 65)
            {
              k = i1;
              if (i1 <= 90) {
                k = i1 + 32;
              }
            }
            c = (char)k;
            localObject2 = (String)localObject1 + c + "";
            k = j + 1;
          }
        }
        k = j;
        localObject2 = localObject1;
      } while (j != 2);
      break;
      localObject1 = localObject2;
      j = k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.draw.DrawIcon
 * JD-Core Version:    0.7.0.1
 */