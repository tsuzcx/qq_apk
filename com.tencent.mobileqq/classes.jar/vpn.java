import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public class vpn
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
  
  public static vku a(vou paramvou, int paramInt1, int paramInt2)
  {
    if (!a(paramvou)) {
      return null;
    }
    ved.b("DoodleUtil", "item:" + paramvou.toString());
    int i = 0;
    int j = 0;
    if (paramvou.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramvou.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      j = paramvou.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f3 = paramvou.jdField_a_of_type_Vov.c;
    float f1 = paramvou.jdField_a_of_type_Vov.d;
    float f2 = paramvou.jdField_a_of_type_Vov.e;
    float f4 = paramvou.jdField_a_of_type_Vov.f;
    f2 = paramInt1 / f2;
    f4 = paramInt2 / f4;
    f3 = f3 * f2 / i;
    int k = (int)(paramvou.jdField_a_of_type_Vov.b / f1 * j);
    j = j + a(paramvou.b, k, i) * 2 + 32;
    vov localvov = paramvou.jdField_a_of_type_Vov;
    int m = localvov.jdField_a_of_type_Int;
    if ((a(m, 64)) || (a(m, 48)))
    {
      ved.b("DoodleUtil", "align--> CENTER");
      f1 = paramInt1 / 2;
      f2 = paramInt2 / 2;
    }
    for (;;)
    {
      paramvou = new vku(f1, f2, f3, 0.0F, 0.0F, 0.0F, i, j, paramvou.b, Color.parseColor(paramvou.jdField_a_of_type_Vov.jdField_a_of_type_JavaLangString), k);
      ved.b("DoodleUtil", "LayerParams:" + paramvou.toString());
      return paramvou;
      if ((a(m, 18)) || (a(m, 16)))
      {
        ved.b("DoodleUtil", "align--> CENTER_HORIZONTAL | TOP");
        paramInt2 = localvov.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 / 2;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if (a(m, 24))
      {
        ved.b("DoodleUtil", "align--> CENTER_HORIZONTAL | BOTTOM");
        m = localvov.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 / 2;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else if ((a(m, 33)) || (a(m, 32)))
      {
        ved.b("DoodleUtil", "align--> CENTER_VERTICAL | LEFT");
        f1 = localvov.jdField_a_of_type_ArrayOfInt[0];
        f1 = i / 2 * f3 + f1 * f2;
        f2 = paramInt2 / 2;
      }
      else if (a(m, 36))
      {
        ved.b("DoodleUtil", "align--> CENTER_VERTICAL | RIGHT");
        m = localvov.jdField_a_of_type_ArrayOfInt[2];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 / 2;
      }
      else if ((a(m, 3)) || (a(m, 1)) || (a(m, 2)) || (m == 0))
      {
        ved.b("DoodleUtil", "align--> LEFT | TOP");
        paramInt1 = localvov.jdField_a_of_type_ArrayOfInt[0];
        paramInt2 = localvov.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f4 = paramInt2;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((a(m, 6)) || (a(m, 4)))
      {
        ved.b("DoodleUtil", "align--> RIGHT | TOP");
        paramInt2 = localvov.jdField_a_of_type_ArrayOfInt[2];
        m = localvov.jdField_a_of_type_ArrayOfInt[1];
        f1 = paramInt1 - (paramInt2 * f2 + i / 2 * f3);
        f4 = m;
        f2 = j / 2 * f3 + f4 * f2;
      }
      else if ((a(m, 9)) || (a(m, 8)))
      {
        ved.b("DoodleUtil", "align--> LEFT | BOTTOM");
        paramInt1 = localvov.jdField_a_of_type_ArrayOfInt[0];
        m = localvov.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 * f2 + i / 2 * f3;
        f2 = paramInt2 - (m * f2 + j / 2 * f3);
      }
      else
      {
        if (!a(m, 12)) {
          break;
        }
        ved.b("DoodleUtil", "align--> RIGHT | BOTTOM");
        m = localvov.jdField_a_of_type_ArrayOfInt[2];
        int n = localvov.jdField_a_of_type_ArrayOfInt[3];
        f1 = paramInt1 - (m * f2 + i / 2 * f3);
        f2 = paramInt2 - (n * f2 + j / 2 * f3);
      }
    }
    ved.e("DoodleUtil", "align attribute is error,align:" + m);
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
  
  public static boolean a(vou paramvou)
  {
    if (paramvou == null)
    {
      ved.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(paramvou.e))
    {
      ved.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!paramvou.a())
    {
      ved.e("DoodleUtil", "parseJson error:" + paramvou.e);
      return false;
    }
    if (paramvou.jdField_a_of_type_Vov.b < 0)
    {
      ved.e("DoodleUtil", "item textSize < 0. textSize:" + paramvou.jdField_a_of_type_Vov.b);
      return false;
    }
    if ((paramvou.jdField_a_of_type_Vov.c <= 0) || (paramvou.jdField_a_of_type_Vov.d <= 0))
    {
      ved.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + paramvou.jdField_a_of_type_Vov.c + ",pictureHeight:" + paramvou.jdField_a_of_type_Vov.d);
      return false;
    }
    if ((paramvou.jdField_a_of_type_Vov.e <= 0) || (paramvou.jdField_a_of_type_Vov.f <= 0))
    {
      ved.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + paramvou.jdField_a_of_type_Vov.e + ",standardHeight:" + paramvou.jdField_a_of_type_Vov.f);
      return false;
    }
    try
    {
      Color.parseColor(paramvou.jdField_a_of_type_Vov.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      ved.e("DoodleUtil", "item color is illegal:" + paramvou.jdField_a_of_type_Vov.jdField_a_of_type_JavaLangString);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpn
 * JD-Core Version:    0.7.0.1
 */