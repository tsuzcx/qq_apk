import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public class vpq
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
  
  public static vkx a(vox paramvox, int paramInt1, int paramInt2)
  {
    if (!a(paramvox)) {
      return null;
    }
    veg.b("DoodleUtil", "item:" + paramvox.toString());
    int i = 0;
    int j = 0;
    if (paramvox.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramvox.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      j = paramvox.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f3 = paramvox.jdField_a_of_type_Voy.c;
    float f1 = paramvox.jdField_a_of_type_Voy.d;
    float f2 = paramvox.jdField_a_of_type_Voy.e;
    float f4 = paramvox.jdField_a_of_type_Voy.f;
    f2 = paramInt1 / f2;
    f4 = paramInt2 / f4;
    f3 = f3 * f2 / i;
    int k = (int)(paramvox.jdField_a_of_type_Voy.b / f1 * j);
    j = j + a(paramvox.b, k, i) * 2 + 32;
    voy localvoy = paramvox.jdField_a_of_type_Voy;
    int m = localvoy.jdField_a_of_type_Int;
    if ((a(m, 64)) || (a(m, 48)))
    {
      veg.b("DoodleUtil", "align--> CENTER");
      f1 = paramInt1 / 2;
      f2 = paramInt2 / 2;
    }
    for (;;)
    {
      paramvox = new vkx(f1, f2, f3, 0.0F, 0.0F, 0.0F, i, j, paramvox.b, Color.parseColor(paramvox.jdField_a_of_type_Voy.jdField_a_of_type_JavaLangString), k);
      veg.b("DoodleUtil", "LayerParams:" + paramvox.toString());
      return paramvox;
      if ((a(m, 18)) || (a(m, 16)))
      {
        veg.b("DoodleUtil", "align--> CENTER_HORIZONTAL | TOP");
        paramInt2 = localvoy.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 / 2;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if (a(m, 24))
      {
        veg.b("DoodleUtil", "align--> CENTER_HORIZONTAL | BOTTOM");
        m = localvoy.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 / 2;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else if ((a(m, 33)) || (a(m, 32)))
      {
        veg.b("DoodleUtil", "align--> CENTER_VERTICAL | LEFT");
        f1 = localvoy.jdField_a_of_type_ArrayOfInt[0];
        f1 = i / 2 * f3 + f1 * f2;
        f2 = paramInt2 / 2;
      }
      else if (a(m, 36))
      {
        veg.b("DoodleUtil", "align--> CENTER_VERTICAL | RIGHT");
        m = localvoy.jdField_a_of_type_ArrayOfInt[2];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 / 2;
      }
      else if ((a(m, 3)) || (a(m, 1)) || (a(m, 2)) || (m == 0))
      {
        veg.b("DoodleUtil", "align--> LEFT | TOP");
        paramInt1 = localvoy.jdField_a_of_type_ArrayOfInt[0];
        paramInt2 = localvoy.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((a(m, 6)) || (a(m, 4)))
      {
        veg.b("DoodleUtil", "align--> RIGHT | TOP");
        paramInt2 = localvoy.jdField_a_of_type_ArrayOfInt[2];
        m = localvoy.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 - (paramInt2 * f2 + i / 2 * f3);
        f4 = m;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((a(m, 9)) || (a(m, 8)))
      {
        veg.b("DoodleUtil", "align--> LEFT | BOTTOM");
        paramInt1 = localvoy.jdField_a_of_type_ArrayOfInt[0];
        m = localvoy.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else
      {
        if (!a(m, 12)) {
          break;
        }
        veg.b("DoodleUtil", "align--> RIGHT | BOTTOM");
        m = localvoy.jdField_a_of_type_ArrayOfInt[2];
        int n = localvoy.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 - (n * f2 + j / 2 * f3);
      }
    }
    veg.e("DoodleUtil", "align attribute is error,align:" + m);
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
  
  public static boolean a(vox paramvox)
  {
    if (paramvox == null)
    {
      veg.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(paramvox.e))
    {
      veg.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!paramvox.a())
    {
      veg.e("DoodleUtil", "parseJson error:" + paramvox.e);
      return false;
    }
    if (paramvox.jdField_a_of_type_Voy.b < 0)
    {
      veg.e("DoodleUtil", "item textSize < 0. textSize:" + paramvox.jdField_a_of_type_Voy.b);
      return false;
    }
    if ((paramvox.jdField_a_of_type_Voy.c <= 0) || (paramvox.jdField_a_of_type_Voy.d <= 0))
    {
      veg.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + paramvox.jdField_a_of_type_Voy.c + ",pictureHeight:" + paramvox.jdField_a_of_type_Voy.d);
      return false;
    }
    if ((paramvox.jdField_a_of_type_Voy.e <= 0) || (paramvox.jdField_a_of_type_Voy.f <= 0))
    {
      veg.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + paramvox.jdField_a_of_type_Voy.e + ",standardHeight:" + paramvox.jdField_a_of_type_Voy.f);
      return false;
    }
    try
    {
      Color.parseColor(paramvox.jdField_a_of_type_Voy.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      veg.e("DoodleUtil", "item color is illegal:" + paramvox.jdField_a_of_type_Voy.jdField_a_of_type_JavaLangString);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpq
 * JD-Core Version:    0.7.0.1
 */