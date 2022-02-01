package com.tencent.token;

import android.graphics.Path;
import java.util.ArrayList;

public final class cz
{
  private static int a(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((((i - 65) * (i - 90) <= 0) || ((i - 97) * (i - 122) <= 0)) && (i != 101) && (i != 69)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static Path a(String paramString)
  {
    Path localPath = new Path();
    b[] arrayOfb = b(paramString);
    if (arrayOfb != null) {
      try
      {
        b.a(arrayOfb, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw new RuntimeException("Error in parsing ".concat(String.valueOf(paramString)), localRuntimeException);
      }
    }
    return null;
  }
  
  private static void a(ArrayList<b> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new b(paramChar, paramArrayOfFloat));
  }
  
  public static boolean a(b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    if (paramArrayOfb1 != null)
    {
      if (paramArrayOfb2 == null) {
        return false;
      }
      if (paramArrayOfb1.length != paramArrayOfb2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfb1.length) {
        if (paramArrayOfb1[i].a == paramArrayOfb2[i].a)
        {
          if (paramArrayOfb1[i].b.length != paramArrayOfb2[i].b.length) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  static float[] a(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = paramArrayOfFloat.length;
      if (i >= 0)
      {
        paramInt -= 0;
        i = Math.min(paramInt, i - 0);
        float[] arrayOfFloat = new float[paramInt];
        System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, i);
        return arrayOfFloat;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static b[] a(b[] paramArrayOfb)
  {
    if (paramArrayOfb == null) {
      return null;
    }
    b[] arrayOfb = new b[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      arrayOfb[i] = new b(paramArrayOfb[i]);
      i += 1;
    }
    return arrayOfb;
  }
  
  public static b[] b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = a(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = c(str);
        a(localArrayList, str.charAt(0), arrayOfFloat);
      }
      i = j;
      j += 1;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      a(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (b[])localArrayList.toArray(new b[localArrayList.size()]);
  }
  
  private static float[] c(String paramString)
  {
    if ((paramString.charAt(0) != 'z') && (paramString.charAt(0) != 'Z')) {}
    for (;;)
    {
      int j;
      int m;
      int n;
      int i;
      int i1;
      int k;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        localObject = new a();
        int i2 = paramString.length();
        j = 1;
        m = 0;
        int i3;
        if (j < i2)
        {
          ((a)localObject).b = false;
          n = j;
          i = 0;
          i1 = 0;
          k = 0;
          if (n < paramString.length())
          {
            i3 = paramString.charAt(n);
            if (i3 == 32) {
              break label317;
            }
            if ((i3 == 69) || (i3 == 101)) {
              break label312;
            }
          }
        }
        switch (i3)
        {
        case 45: 
          ((a)localObject).b = true;
          i = 0;
          k = 1;
          break label321;
          if ((n == j) || (i != 0)) {
            break label307;
          }
          ((a)localObject).b = true;
          i = 0;
          k = 1;
          break label321;
          ((a)localObject).a = n;
          k = ((a)localObject).a;
          i = m;
          if (j < k)
          {
            arrayOfFloat[m] = Float.parseFloat(paramString.substring(j, k));
            i = m + 1;
          }
          if (!((a)localObject).b) {
            break label334;
          }
          j = k;
          m = i;
          continue;
          arrayOfFloat = a(arrayOfFloat, m);
          return arrayOfFloat;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject = new StringBuilder("error in parsing \"");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\"");
        throw new RuntimeException(((StringBuilder)localObject).toString(), localNumberFormatException);
      }
      return new float[0];
      if (i1 == 0)
      {
        i = 0;
        i1 = 1;
        break label321;
        label307:
        i = 0;
        break label321;
        label312:
        i = 1;
        break label321;
        label317:
        i = 0;
        k = 1;
        label321:
        if (k == 0)
        {
          n += 1;
          continue;
          label334:
          j = k + 1;
          m = i;
        }
      }
    }
  }
  
  static final class a
  {
    int a;
    boolean b;
  }
  
  public static final class b
  {
    public char a;
    public float[] b;
    
    b(char paramChar, float[] paramArrayOfFloat)
    {
      this.a = paramChar;
      this.b = paramArrayOfFloat;
    }
    
    b(b paramb)
    {
      this.a = paramb.a;
      paramb = paramb.b;
      this.b = cz.a(paramb, paramb.length);
    }
    
    private static void a(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      int i = (int)Math.ceil(Math.abs(paramDouble9 * 4.0D / 3.141592653589793D));
      double d4 = Math.cos(paramDouble7);
      double d5 = Math.sin(paramDouble7);
      double d1 = Math.cos(paramDouble8);
      double d3 = Math.sin(paramDouble8);
      paramDouble7 = -paramDouble3;
      double d9 = paramDouble7 * d4;
      double d10 = paramDouble4 * d5;
      paramDouble7 *= d5;
      double d11 = paramDouble4 * d4;
      paramDouble4 = i;
      Double.isNaN(paramDouble4);
      double d6 = paramDouble9 / paramDouble4;
      double d2 = d3 * paramDouble7 + d1 * d11;
      paramDouble9 = d9 * d3 - d10 * d1;
      int j = 0;
      d3 = paramDouble8;
      d1 = paramDouble6;
      paramDouble8 = paramDouble5;
      paramDouble4 = paramDouble7;
      paramDouble7 = d6;
      paramDouble6 = d5;
      paramDouble5 = d4;
      for (;;)
      {
        d5 = paramDouble3;
        if (j >= i) {
          break;
        }
        d6 = d3 + paramDouble7;
        double d7 = Math.sin(d6);
        double d12 = Math.cos(d6);
        d4 = paramDouble1 + d5 * paramDouble5 * d12 - d10 * d7;
        double d8 = paramDouble2 + d5 * paramDouble6 * d12 + d11 * d7;
        d5 = d9 * d7 - d10 * d12;
        d7 = d7 * paramDouble4 + d12 * d11;
        d3 = d6 - d3;
        d12 = Math.tan(d3 / 2.0D);
        d3 = Math.sin(d3) * (Math.sqrt(d12 * 3.0D * d12 + 4.0D) - 1.0D) / 3.0D;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)(paramDouble8 + paramDouble9 * d3), (float)(d1 + d2 * d3), (float)(d4 - d3 * d5), (float)(d8 - d3 * d7), (float)d4, (float)d8);
        j += 1;
        d1 = d8;
        d3 = d6;
        d2 = d7;
        paramDouble9 = d5;
        paramDouble8 = d4;
      }
    }
    
    private static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
    {
      float f1 = paramFloat5;
      paramFloat5 = paramFloat6;
      paramFloat6 = f1;
      double d5;
      double d6;
      double d7;
      double d8;
      double d9;
      double d10;
      double d2;
      double d11;
      double d3;
      double d12;
      double d13;
      double d15;
      double d17;
      for (;;)
      {
        float f2 = paramFloat3;
        f1 = paramFloat1;
        d5 = Math.toRadians(paramFloat7);
        d6 = Math.cos(d5);
        d7 = Math.sin(d5);
        d8 = f1;
        Double.isNaN(d8);
        d9 = paramFloat2;
        Double.isNaN(d9);
        d10 = paramFloat6;
        Double.isNaN(d10);
        d1 = (d8 * d6 + d9 * d7) / d10;
        d2 = -f1;
        Double.isNaN(d2);
        Double.isNaN(d9);
        d11 = paramFloat5;
        Double.isNaN(d11);
        d4 = (d2 * d7 + d9 * d6) / d11;
        d3 = f2;
        Double.isNaN(d3);
        d2 = paramFloat4;
        Double.isNaN(d2);
        Double.isNaN(d10);
        d12 = (d3 * d6 + d2 * d7) / d10;
        d3 = -f2;
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d11);
        d13 = (d3 * d7 + d2 * d6) / d11;
        d15 = d1 - d12;
        d14 = d4 - d13;
        d3 = (d1 + d12) / 2.0D;
        d2 = (d4 + d13) / 2.0D;
        d16 = d15 * d15 + d14 * d14;
        if (d16 == 0.0D) {
          return;
        }
        d17 = 1.0D / d16 - 0.25D;
        if (d17 >= 0.0D) {
          break;
        }
        f1 = (float)(Math.sqrt(d16) / 1.99999D);
        paramFloat6 *= f1;
        paramFloat5 *= f1;
      }
      double d16 = Math.sqrt(d17);
      d15 *= d16;
      double d14 = d16 * d14;
      if (paramBoolean1 == paramBoolean2)
      {
        d3 -= d14;
        d2 += d15;
      }
      else
      {
        d3 += d14;
        d2 -= d15;
      }
      d14 = Math.atan2(d4 - d2, d1 - d3);
      double d4 = Math.atan2(d13 - d2, d12 - d3) - d14;
      if (d4 >= 0.0D) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      double d1 = d4;
      if (paramBoolean2 != paramBoolean1) {
        if (d4 > 0.0D) {
          d1 = d4 - 6.283185307179586D;
        } else {
          d1 = d4 + 6.283185307179586D;
        }
      }
      Double.isNaN(d10);
      d3 *= d10;
      Double.isNaN(d11);
      d2 *= d11;
      a(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, d10, d11, d8, d9, d5, d14, d1);
    }
    
    private static void a(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
    {
      Path localPath = paramPath;
      float f1 = paramArrayOfFloat1[0];
      float f2 = paramArrayOfFloat1[1];
      float f3 = paramArrayOfFloat1[2];
      float f4 = paramArrayOfFloat1[3];
      float f6 = paramArrayOfFloat1[4];
      float f5 = paramArrayOfFloat1[5];
      char c1;
      switch (paramChar2)
      {
      default: 
        c1 = '\002';
        break;
      case 'Z': 
      case 'z': 
        paramPath.close();
        localPath.moveTo(f6, f5);
        f1 = f6;
        f3 = f1;
        f2 = f5;
        f4 = f2;
        c1 = '\002';
        break;
      case 'Q': 
      case 'S': 
      case 'q': 
      case 's': 
        c1 = '\004';
        break;
      case 'L': 
      case 'M': 
      case 'T': 
      case 'l': 
      case 'm': 
      case 't': 
        c1 = '\002';
        break;
      case 'H': 
      case 'V': 
      case 'h': 
      case 'v': 
        c1 = '\001';
        break;
      case 'C': 
      case 'c': 
        c1 = '\006';
        break;
      case 'A': 
      case 'a': 
        c1 = '\007';
      }
      float f7 = f2;
      f2 = f6;
      char c2 = '\000';
      int i = paramChar1;
      f6 = f5;
      f5 = f2;
      paramChar1 = c2;
      f2 = f1;
      f1 = f7;
      while (paramChar1 < paramArrayOfFloat2.length)
      {
        f7 = 0.0F;
        float f8;
        int j;
        float f9;
        int k;
        boolean bool1;
        boolean bool2;
        switch (paramChar2)
        {
        default: 
          break;
        case 'v': 
          i = paramChar1 + '\000';
          localPath.rLineTo(0.0F, paramArrayOfFloat2[i]);
          f1 += paramArrayOfFloat2[i];
          break;
        case 't': 
          if ((i != 113) && (i != 116) && (i != 81) && (i != 84))
          {
            f4 = 0.0F;
            f3 = f7;
          }
          else
          {
            f3 = f2 - f3;
            f4 = f1 - f4;
          }
          i = paramChar1 + '\000';
          f7 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\001';
          localPath.rQuadTo(f3, f4, f7, paramArrayOfFloat2[c2]);
          f7 = f2 + paramArrayOfFloat2[i];
          f8 = f1 + paramArrayOfFloat2[c2];
          f4 += f1;
          f3 += f2;
          f1 = f8;
          f2 = f7;
          break;
        case 's': 
          if ((i != 99) && (i != 115) && (i != 67) && (i != 83))
          {
            f3 = 0.0F;
            f4 = 0.0F;
          }
          else
          {
            f4 = f1 - f4;
            f3 = f2 - f3;
          }
          i = paramChar1 + '\000';
          f7 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\001';
          f8 = paramArrayOfFloat2[c2];
          j = paramChar1 + '\002';
          f9 = paramArrayOfFloat2[j];
          k = paramChar1 + '\003';
          paramPath.rCubicTo(f3, f4, f7, f8, f9, paramArrayOfFloat2[k]);
          f3 = paramArrayOfFloat2[i];
          f4 = paramArrayOfFloat2[c2];
          f7 = f2 + paramArrayOfFloat2[j];
          f8 = f1 + paramArrayOfFloat2[k];
          f3 += f2;
          f4 += f1;
          f1 = f8;
          f2 = f7;
          break;
        case 'q': 
          i = paramChar1 + '\000';
          f3 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\001';
          f4 = paramArrayOfFloat2[c2];
          j = paramChar1 + '\002';
          f7 = paramArrayOfFloat2[j];
          k = paramChar1 + '\003';
          localPath.rQuadTo(f3, f4, f7, paramArrayOfFloat2[k]);
          f3 = paramArrayOfFloat2[i];
          f4 = paramArrayOfFloat2[c2];
          f7 = f2 + paramArrayOfFloat2[j];
          f8 = f1 + paramArrayOfFloat2[k];
          f3 += f2;
          f4 += f1;
          f1 = f8;
          f2 = f7;
          break;
        case 'm': 
          i = paramChar1 + '\000';
          f2 += paramArrayOfFloat2[i];
          c2 = paramChar1 + '\001';
          f1 += paramArrayOfFloat2[c2];
          if (paramChar1 > 0)
          {
            localPath.rLineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
          }
          else
          {
            localPath.rMoveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
            f6 = f1;
            f5 = f2;
          }
          break;
        case 'l': 
          i = paramChar1 + '\000';
          f7 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\001';
          localPath.rLineTo(f7, paramArrayOfFloat2[c2]);
          f2 += paramArrayOfFloat2[i];
          f1 += paramArrayOfFloat2[c2];
          break;
        case 'h': 
          i = paramChar1 + '\000';
          localPath.rLineTo(paramArrayOfFloat2[i], 0.0F);
          f2 += paramArrayOfFloat2[i];
          break;
        case 'c': 
          f3 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f4 = paramArrayOfFloat2[(paramChar1 + '\001')];
          i = paramChar1 + '\002';
          f7 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\003';
          f8 = paramArrayOfFloat2[c2];
          j = paramChar1 + '\004';
          f9 = paramArrayOfFloat2[j];
          k = paramChar1 + '\005';
          paramPath.rCubicTo(f3, f4, f7, f8, f9, paramArrayOfFloat2[k]);
          f3 = paramArrayOfFloat2[i];
          f4 = paramArrayOfFloat2[c2];
          f7 = f2 + paramArrayOfFloat2[j];
          f8 = f1 + paramArrayOfFloat2[k];
          f3 += f2;
          f4 += f1;
          f1 = f8;
          f2 = f7;
          break;
        case 'a': 
          i = paramChar1 + '\005';
          f3 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\006';
          f4 = paramArrayOfFloat2[c2];
          f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
          f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
          if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (paramArrayOfFloat2[(paramChar1 + '\004')] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          a(paramPath, f2, f1, f3 + f2, f4 + f1, f7, f8, f9, bool1, bool2);
          f2 += paramArrayOfFloat2[i];
          f1 += paramArrayOfFloat2[c2];
          f4 = f1;
          f3 = f2;
          localPath = paramPath;
          break;
        case 'V': 
          i = paramChar1 + '\000';
          f1 = paramArrayOfFloat2[i];
          localPath = paramPath;
          localPath.lineTo(f2, f1);
          f1 = paramArrayOfFloat2[i];
          break;
        case 'T': 
          f7 = f1;
          f8 = f2;
          c2 = paramChar1;
          if ((i != 113) && (i != 116) && (i != 81))
          {
            f2 = f8;
            f1 = f7;
            if (i != 84) {}
          }
          else
          {
            f1 = f7 * 2.0F - f4;
            f2 = f8 * 2.0F - f3;
          }
          i = c2 + '\000';
          f3 = paramArrayOfFloat2[i];
          c2 += '\001';
          localPath.quadTo(f2, f1, f3, paramArrayOfFloat2[c2]);
          f8 = paramArrayOfFloat2[i];
          f7 = paramArrayOfFloat2[c2];
          f3 = f2;
          f4 = f1;
          f1 = f7;
          f2 = f8;
          break;
        case 'S': 
          c2 = paramChar1;
          if ((i != 99) && (i != 115) && (i != 67) && (i != 83))
          {
            f3 = f1;
            f1 = f2;
            f2 = f3;
          }
          else
          {
            f1 = f1 * 2.0F - f4;
            f3 = f2 * 2.0F - f3;
            f2 = f1;
            f1 = f3;
          }
          i = c2 + '\000';
          f3 = paramArrayOfFloat2[i];
          j = c2 + '\001';
          f4 = paramArrayOfFloat2[j];
          k = c2 + '\002';
          f7 = paramArrayOfFloat2[k];
          c2 += '\003';
          paramPath.cubicTo(f1, f2, f3, f4, f7, paramArrayOfFloat2[c2]);
          f3 = paramArrayOfFloat2[i];
          f4 = paramArrayOfFloat2[j];
          f2 = paramArrayOfFloat2[k];
          f1 = paramArrayOfFloat2[c2];
          break;
        case 'Q': 
          i = paramChar1;
          c2 = i + 0;
          f1 = paramArrayOfFloat2[c2];
          j = i + 1;
          f2 = paramArrayOfFloat2[j];
          k = i + 2;
          f3 = paramArrayOfFloat2[k];
          i += 3;
          localPath.quadTo(f1, f2, f3, paramArrayOfFloat2[i]);
          f3 = paramArrayOfFloat2[c2];
          f4 = paramArrayOfFloat2[j];
          f2 = paramArrayOfFloat2[k];
          f1 = paramArrayOfFloat2[i];
          break;
        case 'M': 
          i = paramChar1;
          c2 = i + 0;
          f2 = paramArrayOfFloat2[c2];
          j = i + 1;
          f1 = paramArrayOfFloat2[j];
          if (i > 0)
          {
            localPath.lineTo(paramArrayOfFloat2[c2], paramArrayOfFloat2[j]);
          }
          else
          {
            localPath.moveTo(paramArrayOfFloat2[c2], paramArrayOfFloat2[j]);
            f6 = f1;
            f5 = f2;
          }
          break;
        case 'L': 
          i = paramChar1;
          c2 = i + 0;
          f1 = paramArrayOfFloat2[c2];
          i += 1;
          localPath.lineTo(f1, paramArrayOfFloat2[i]);
          f2 = paramArrayOfFloat2[c2];
          f1 = paramArrayOfFloat2[i];
          break;
        case 'H': 
          i = paramChar1 + '\000';
          localPath.lineTo(paramArrayOfFloat2[i], f1);
          f2 = paramArrayOfFloat2[i];
          break;
        case 'C': 
          i = paramChar1;
          f1 = paramArrayOfFloat2[(i + 0)];
          f2 = paramArrayOfFloat2[(i + 1)];
          c2 = i + 2;
          f3 = paramArrayOfFloat2[c2];
          j = i + 3;
          f4 = paramArrayOfFloat2[j];
          k = i + 4;
          f7 = paramArrayOfFloat2[k];
          i += 5;
          paramPath.cubicTo(f1, f2, f3, f4, f7, paramArrayOfFloat2[i]);
          f2 = paramArrayOfFloat2[k];
          f1 = paramArrayOfFloat2[i];
          f3 = paramArrayOfFloat2[c2];
          f4 = paramArrayOfFloat2[j];
          break;
        case 'A': 
          i = paramChar1;
          c2 = i + 5;
          f3 = paramArrayOfFloat2[c2];
          j = i + 6;
          f4 = paramArrayOfFloat2[j];
          f7 = paramArrayOfFloat2[(i + 0)];
          f8 = paramArrayOfFloat2[(i + 1)];
          f9 = paramArrayOfFloat2[(i + 2)];
          if (paramArrayOfFloat2[(i + 3)] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (paramArrayOfFloat2[(i + 4)] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          a(paramPath, f2, f1, f3, f4, f7, f8, f9, bool1, bool2);
          f2 = paramArrayOfFloat2[c2];
          f1 = paramArrayOfFloat2[j];
          f4 = f1;
          f3 = f2;
        }
        paramChar1 += c1;
        i = paramChar2;
      }
      paramArrayOfFloat1[0] = f2;
      paramArrayOfFloat1[1] = f1;
      paramArrayOfFloat1[2] = f3;
      paramArrayOfFloat1[3] = f4;
      paramArrayOfFloat1[4] = f5;
      paramArrayOfFloat1[5] = f6;
    }
    
    public static void a(b[] paramArrayOfb, Path paramPath)
    {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      int i = 0;
      while (i < paramArrayOfb.length)
      {
        a(paramPath, arrayOfFloat, c, paramArrayOfb[i].a, paramArrayOfb[i].b);
        c = paramArrayOfb[i].a;
        i += 1;
      }
    }
    
    public final void a(b paramb1, b paramb2, float paramFloat)
    {
      int i = 0;
      for (;;)
      {
        float[] arrayOfFloat = paramb1.b;
        if (i >= arrayOfFloat.length) {
          break;
        }
        this.b[i] = (arrayOfFloat[i] * (1.0F - paramFloat) + paramb2.b[i] * paramFloat);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cz
 * JD-Core Version:    0.7.0.1
 */