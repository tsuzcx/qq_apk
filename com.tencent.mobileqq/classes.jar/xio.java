import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public class xio
{
  private static int a(@NonNull String paramString, int paramInt1, int paramInt2)
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
  
  public static xdv a(xhv paramxhv, int paramInt1, int paramInt2)
  {
    if (!a(paramxhv)) {
      return null;
    }
    wxe.b("DoodleUtil", "item:" + paramxhv.toString());
    int i = 0;
    int j = 0;
    if (paramxhv.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramxhv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      j = paramxhv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f3 = paramxhv.jdField_a_of_type_Xhw.c;
    float f1 = paramxhv.jdField_a_of_type_Xhw.d;
    float f2 = paramxhv.jdField_a_of_type_Xhw.e;
    float f4 = paramxhv.jdField_a_of_type_Xhw.f;
    f2 = paramInt1 / f2;
    f4 = paramInt2 / f4;
    f3 = f3 * f2 / i;
    int k = (int)(paramxhv.jdField_a_of_type_Xhw.b / f1 * j);
    j = j + a(paramxhv.b, k, i) * 2 + 32;
    xhw localxhw = paramxhv.jdField_a_of_type_Xhw;
    int m = localxhw.jdField_a_of_type_Int;
    if ((a(m, 64)) || (a(m, 48)))
    {
      wxe.b("DoodleUtil", "align--> CENTER");
      f1 = paramInt1 / 2;
      f2 = paramInt2 / 2;
    }
    for (;;)
    {
      paramxhv = new xdv(f1, f2, f3, 0.0F, 0.0F, 0.0F, i, j, paramxhv.b, Color.parseColor(paramxhv.jdField_a_of_type_Xhw.jdField_a_of_type_JavaLangString), k);
      wxe.b("DoodleUtil", "LayerParams:" + paramxhv.toString());
      return paramxhv;
      if ((a(m, 18)) || (a(m, 16)))
      {
        wxe.b("DoodleUtil", "align--> CENTER_HORIZONTAL | TOP");
        paramInt2 = localxhw.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 / 2;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if (a(m, 24))
      {
        wxe.b("DoodleUtil", "align--> CENTER_HORIZONTAL | BOTTOM");
        m = localxhw.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 / 2;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else if ((a(m, 33)) || (a(m, 32)))
      {
        wxe.b("DoodleUtil", "align--> CENTER_VERTICAL | LEFT");
        f1 = localxhw.jdField_a_of_type_ArrayOfInt[0];
        f1 = i / 2 * f3 + f1 * f2;
        f2 = paramInt2 / 2;
      }
      else if (a(m, 36))
      {
        wxe.b("DoodleUtil", "align--> CENTER_VERTICAL | RIGHT");
        m = localxhw.jdField_a_of_type_ArrayOfInt[2];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 / 2;
      }
      else if ((a(m, 3)) || (a(m, 1)) || (a(m, 2)) || (m == 0))
      {
        wxe.b("DoodleUtil", "align--> LEFT | TOP");
        paramInt1 = localxhw.jdField_a_of_type_ArrayOfInt[0];
        paramInt2 = localxhw.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((a(m, 6)) || (a(m, 4)))
      {
        wxe.b("DoodleUtil", "align--> RIGHT | TOP");
        paramInt2 = localxhw.jdField_a_of_type_ArrayOfInt[2];
        m = localxhw.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 - (paramInt2 * f2 + i / 2 * f3);
        f4 = m;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((a(m, 9)) || (a(m, 8)))
      {
        wxe.b("DoodleUtil", "align--> LEFT | BOTTOM");
        paramInt1 = localxhw.jdField_a_of_type_ArrayOfInt[0];
        m = localxhw.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else
      {
        if (!a(m, 12)) {
          break;
        }
        wxe.b("DoodleUtil", "align--> RIGHT | BOTTOM");
        m = localxhw.jdField_a_of_type_ArrayOfInt[2];
        int n = localxhw.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 - (n * f2 + j / 2 * f3);
      }
    }
    wxe.e("DoodleUtil", "align attribute is error,align:" + m);
    return null;
  }
  
  public static void a(Bitmap paramBitmap, int paramInt)
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
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & paramInt2) == paramInt2) && (((paramInt2 ^ 0xFFFFFFFF) & paramInt1) == 0);
  }
  
  public static boolean a(xhv paramxhv)
  {
    if (paramxhv == null)
    {
      wxe.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(paramxhv.e))
    {
      wxe.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!paramxhv.a())
    {
      wxe.e("DoodleUtil", "parseJson error:" + paramxhv.e);
      return false;
    }
    if (paramxhv.jdField_a_of_type_Xhw.b < 0)
    {
      wxe.e("DoodleUtil", "item textSize < 0. textSize:" + paramxhv.jdField_a_of_type_Xhw.b);
      return false;
    }
    if ((paramxhv.jdField_a_of_type_Xhw.c <= 0) || (paramxhv.jdField_a_of_type_Xhw.d <= 0))
    {
      wxe.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + paramxhv.jdField_a_of_type_Xhw.c + ",pictureHeight:" + paramxhv.jdField_a_of_type_Xhw.d);
      return false;
    }
    if ((paramxhv.jdField_a_of_type_Xhw.e <= 0) || (paramxhv.jdField_a_of_type_Xhw.f <= 0))
    {
      wxe.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + paramxhv.jdField_a_of_type_Xhw.e + ",standardHeight:" + paramxhv.jdField_a_of_type_Xhw.f);
      return false;
    }
    try
    {
      Color.parseColor(paramxhv.jdField_a_of_type_Xhw.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      wxe.e("DoodleUtil", "item color is illegal:" + paramxhv.jdField_a_of_type_Xhw.jdField_a_of_type_JavaLangString);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xio
 * JD-Core Version:    0.7.0.1
 */