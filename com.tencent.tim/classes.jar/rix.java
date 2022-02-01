import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public class rix
{
  public static rft.d a(rim.a parama, int paramInt1, int paramInt2)
  {
    if (!a(parama)) {
      return null;
    }
    ram.d("DoodleUtil", "item:" + parama.toString());
    int i = 0;
    int j = 0;
    if (parama.dj != null)
    {
      i = parama.dj.getBounds().width();
      j = parama.dj.getBounds().height();
    }
    float f3 = parama.a.brS;
    float f1 = parama.a.brT;
    float f2 = parama.a.brU;
    float f4 = parama.a.brV;
    f2 = paramInt1 / f2;
    f4 = paramInt2 / f4;
    f3 = f3 * f2 / i;
    int k = (int)(parama.a.textSize / f1 * j);
    j = j + d(parama.name, k, i) * 2 + 32;
    rim.a.a locala = parama.a;
    int m = locala.bkg;
    if ((am(m, 64)) || (am(m, 48)))
    {
      ram.d("DoodleUtil", "align--> CENTER");
      f1 = paramInt1 / 2;
      f2 = paramInt2 / 2;
    }
    for (;;)
    {
      parama = new rft.d(f1, f2, f3, 0.0F, 0.0F, 0.0F, i, j, parama.name, Color.parseColor(parama.a.textColor), k);
      ram.d("DoodleUtil", "LayerParams:" + parama.toString());
      return parama;
      if ((am(m, 18)) || (am(m, 16)))
      {
        ram.d("DoodleUtil", "align--> CENTER_HORIZONTAL | TOP");
        paramInt2 = locala.eh[1];
        f1 = paramInt1 / 2;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if (am(m, 24))
      {
        ram.d("DoodleUtil", "align--> CENTER_HORIZONTAL | BOTTOM");
        m = locala.eh[3];
        f1 = paramInt1 / 2;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else if ((am(m, 33)) || (am(m, 32)))
      {
        ram.d("DoodleUtil", "align--> CENTER_VERTICAL | LEFT");
        f1 = locala.eh[0];
        f1 = i / 2 * f3 + f1 * f2;
        f2 = paramInt2 / 2;
      }
      else if (am(m, 36))
      {
        ram.d("DoodleUtil", "align--> CENTER_VERTICAL | RIGHT");
        m = locala.eh[2];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 / 2;
      }
      else if ((am(m, 3)) || (am(m, 1)) || (am(m, 2)) || (m == 0))
      {
        ram.d("DoodleUtil", "align--> LEFT | TOP");
        paramInt1 = locala.eh[0];
        paramInt2 = locala.eh[1];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((am(m, 6)) || (am(m, 4)))
      {
        ram.d("DoodleUtil", "align--> RIGHT | TOP");
        paramInt2 = locala.eh[2];
        m = locala.eh[1];
        f1 = paramInt1 - (paramInt2 * f2 + i / 2 * f3);
        f4 = m;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((am(m, 9)) || (am(m, 8)))
      {
        ram.d("DoodleUtil", "align--> LEFT | BOTTOM");
        paramInt1 = locala.eh[0];
        m = locala.eh[3];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else
      {
        if (!am(m, 12)) {
          break;
        }
        ram.d("DoodleUtil", "align--> RIGHT | BOTTOM");
        m = locala.eh[2];
        int n = locala.eh[3];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 - (n * f2 + j / 2 * f3);
      }
    }
    ram.e("DoodleUtil", "align attribute is error,align:" + m);
    return null;
  }
  
  public static boolean a(rim.a parama)
  {
    if (parama == null)
    {
      ram.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(parama.aAE))
    {
      ram.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!parama.LB())
    {
      ram.e("DoodleUtil", "parseJson error:" + parama.aAE);
      return false;
    }
    if (parama.a.textSize < 0)
    {
      ram.e("DoodleUtil", "item textSize < 0. textSize:" + parama.a.textSize);
      return false;
    }
    if ((parama.a.brS <= 0) || (parama.a.brT <= 0))
    {
      ram.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + parama.a.brS + ",pictureHeight:" + parama.a.brT);
      return false;
    }
    if ((parama.a.brU <= 0) || (parama.a.brV <= 0))
    {
      ram.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + parama.a.brU + ",standardHeight:" + parama.a.brV);
      return false;
    }
    try
    {
      Color.parseColor(parama.a.textColor);
      return true;
    }
    catch (Exception localException)
    {
      ram.e("DoodleUtil", "item color is illegal:" + parama.a.textColor);
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean am(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & paramInt2) == paramInt2) && (((paramInt2 ^ 0xFFFFFFFF) & paramInt1) == 0);
  }
  
  public static void b(Bitmap paramBitmap, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt * paramInt];
    int i3 = paramBitmap.getHeight() / paramInt;
    int i4 = paramBitmap.getWidth() / paramInt;
    int i5 = paramBitmap.getHeight() % paramInt;
    int i6 = paramBitmap.getWidth() % paramInt;
    int i = 0;
    int j;
    int i7;
    int i8;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    while (i < i3)
    {
      j = 0;
      while (j < i4)
      {
        i7 = i * paramInt;
        i8 = j * paramInt;
        paramBitmap.getPixels(arrayOfInt, 0, paramInt, i8, i7, paramInt, paramInt);
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        while (k < paramInt)
        {
          i2 = 0;
          while (i2 < paramInt)
          {
            int i9 = arrayOfInt[(k * paramInt + i2)];
            i1 += (i9 >> 16 & 0xFF);
            n += (i9 >> 8 & 0xFF);
            m += (i9 & 0xFF);
            i2 += 1;
          }
          k += 1;
        }
        i1 = i1 / paramInt / paramInt;
        n = n / paramInt / paramInt;
        i2 = m / paramInt / paramInt;
        k = 0;
        while (k < paramInt)
        {
          m = 0;
          while (m < paramInt)
          {
            arrayOfInt[(k * paramInt + m)] = (0xFF000000 | i1 << 16 | n << 8 | i2);
            m += 1;
          }
          k += 1;
        }
        paramBitmap.setPixels(arrayOfInt, 0, paramInt, i8, i7, paramInt, paramInt);
        j += 1;
      }
      i += 1;
    }
    if (i6 > 0)
    {
      i = 0;
      while (i < i3)
      {
        i2 = i * paramInt;
        i7 = i4 * paramInt;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (j < paramInt)
        {
          i1 = 0;
          while (i1 < i6)
          {
            i8 = paramBitmap.getPixel(i7 + i1, i2 + j);
            n += (i8 >> 16 & 0xFF);
            m += (i8 >> 8 & 0xFF);
            k += (i8 & 0xFF);
            i1 += 1;
          }
          j += 1;
        }
        n = n / paramInt / i6;
        m = m / paramInt / i6;
        i1 = k / paramInt / i6;
        j = 0;
        while (j < paramInt)
        {
          k = 0;
          while (k < i6)
          {
            paramBitmap.setPixel(i7 + k, i2 + j, 0xFF000000 | n << 16 | m << 8 | i1);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
    if (i5 > 0)
    {
      i = 0;
      while (i < i4)
      {
        i2 = i3 * paramInt;
        i6 = i * paramInt;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (j < i5)
        {
          i1 = 0;
          while (i1 < paramInt)
          {
            i7 = paramBitmap.getPixel(i6 + i1, i2 + j);
            n += (i7 >> 16 & 0xFF);
            m += (i7 >> 8 & 0xFF);
            k += (i7 & 0xFF);
            i1 += 1;
          }
          j += 1;
        }
        n = n / paramInt / i5;
        m = m / paramInt / i5;
        i1 = k / paramInt / i5;
        j = 0;
        while (j < i5)
        {
          k = 0;
          while (k < paramInt)
          {
            paramBitmap.setPixel(i6 + k, i2 + j, 0xFF000000 | n << 16 | m << 8 | i1);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private static int d(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("textSize : " + paramInt1 + ", width : " + paramInt2);
    }
    Object localObject = new TextPaint();
    ((TextPaint)localObject).setTextSize(paramInt1);
    paramString = new StaticLayout(paramString, (TextPaint)localObject, paramInt2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    localObject = new Rect();
    paramString.getLineBounds(0, (Rect)localObject);
    return ((Rect)localObject).height();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rix
 * JD-Core Version:    0.7.0.1
 */