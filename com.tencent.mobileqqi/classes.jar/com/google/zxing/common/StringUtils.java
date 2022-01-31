package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;

public final class StringUtils
{
  public static final String a = "SJIS";
  private static final boolean a;
  public static final String b = "GB2312";
  private static final String c = System.getProperty("file.encoding");
  private static final String d = "EUC_JP";
  private static final String e = "UTF8";
  private static final String f = "ISO8859_1";
  private static final String g = "GBK";
  
  static
  {
    if (("SJIS".equalsIgnoreCase(c)) || ("EUC_JP".equalsIgnoreCase(c))) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, Map paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (String)paramMap.get(DecodeHintType.CHARACTER_SET);
      if (paramMap != null) {
        return paramMap;
      }
    }
    int i18 = paramArrayOfByte.length;
    int i8 = 1;
    int j = 1;
    int n = 1;
    int i7 = 0;
    int i15 = 0;
    int i14 = 0;
    int i13 = 0;
    int m = 0;
    int k = 0;
    int i2 = 0;
    int i = 0;
    int i9 = 0;
    int i4 = 0;
    int i5 = 0;
    int i10;
    int i11;
    int i12;
    int i3;
    int i1;
    label112:
    int i16;
    int i6;
    if ((paramArrayOfByte.length > 3) && (paramArrayOfByte[0] == -17) && (paramArrayOfByte[1] == -69) && (paramArrayOfByte[2] == -65))
    {
      i10 = 1;
      i11 = 0;
      i12 = 0;
      i3 = 0;
      i1 = 1;
      if ((i11 >= i18) || ((i8 == 0) && (j == 0) && (n == 0) && (i1 == 0))) {
        break label731;
      }
      i16 = paramArrayOfByte[i11] & 0xFF;
      if (i1 == 0) {
        break label977;
      }
      if (i5 != 1) {
        break label359;
      }
      if ((i16 < 64) || (i16 > 254) || (i16 == 127)) {
        break label341;
      }
      i5 = i4 + 1;
      i4 = 0;
      i6 = i1;
    }
    for (;;)
    {
      label194:
      if (n != 0) {
        if (i7 > 0) {
          if ((i16 & 0x80) == 0) {
            i1 = 0;
          }
        }
      }
      for (;;)
      {
        label216:
        if (i8 != 0) {
          if ((i16 > 127) && (i16 < 160))
          {
            i8 = i9;
            i9 = 0;
          }
        }
        for (;;)
        {
          label243:
          if (j != 0) {
            if (m > 0) {
              if ((i16 < 64) || (i16 == 127) || (i16 > 252))
              {
                j = i3;
                n = 0;
              }
            }
          }
          for (;;)
          {
            int i17 = i11 + 1;
            i11 = i9;
            i9 = i1;
            i16 = i5;
            i1 = i6;
            i3 = j;
            j = n;
            n = i9;
            i9 = i8;
            i8 = i11;
            i5 = i4;
            i4 = i16;
            i11 = i17;
            break label112;
            i10 = 0;
            break;
            label341:
            i1 = i4;
            i6 = 0;
            i4 = i5;
            i5 = i1;
            break label194;
            label359:
            if ((i16 < 129) || (i16 > 254)) {
              break label977;
            }
            i5 = i4;
            i4 = 1;
            i6 = i1;
            break label194;
            i7 -= 1;
            i1 = n;
            break label216;
            if ((i16 & 0x80) == 0) {
              break label970;
            }
            if ((i16 & 0x40) == 0)
            {
              i1 = 0;
              break label216;
            }
            i7 += 1;
            if ((i16 & 0x20) == 0)
            {
              i15 += 1;
              i1 = n;
              break label216;
            }
            i7 += 1;
            if ((i16 & 0x10) == 0)
            {
              i14 += 1;
              i1 = n;
              break label216;
            }
            i7 += 1;
            if ((i16 & 0x8) == 0)
            {
              i13 += 1;
              i1 = n;
              break label216;
            }
            i1 = 0;
            break label216;
            if ((i16 <= 159) || ((i16 >= 192) && (i16 != 215) && (i16 != 247))) {
              break label955;
            }
            n = i9 + 1;
            i9 = i8;
            i8 = n;
            break label243;
            n = j;
            j = i3;
            m -= 1;
            continue;
            if ((i16 == 128) || (i16 == 160) || (i16 > 239))
            {
              j = i3;
              n = 0;
            }
            else
            {
              if ((i16 > 160) && (i16 < 224))
              {
                n = k + 1;
                k = i2 + 1;
                if (k > i)
                {
                  i16 = 0;
                  i2 = k;
                  i3 = j;
                  i = k;
                  j = i16;
                  k = n;
                  n = i3;
                }
              }
              else
              {
                if (i16 > 127)
                {
                  n = m + 1;
                  i2 = 0;
                  m = i3 + 1;
                  if (m > i12)
                  {
                    i12 = m;
                    i3 = j;
                    j = m;
                    m = n;
                    n = i3;
                  }
                }
                else
                {
                  i2 = 0;
                  n = j;
                  j = 0;
                  continue;
                  label731:
                  if ((n != 0) && (i7 > 0)) {
                    n = 0;
                  }
                  for (;;)
                  {
                    i2 = j;
                    if (j != 0)
                    {
                      i2 = j;
                      if (m > 0) {
                        i2 = 0;
                      }
                    }
                    if ((i1 != 0) && (i5 != 0)) {}
                    for (j = 0;; j = i1)
                    {
                      if ((n != 0) && ((i10 != 0) || (i15 + i14 + i13 > 0))) {
                        return "UTF8";
                      }
                      if ((i2 != 0) && ((a) || (i >= 3) || (i12 >= 3))) {
                        return "SJIS";
                      }
                      if ((j != 0) && (i4 > 0)) {
                        return "GBK";
                      }
                      if ((i8 != 0) && (i2 != 0))
                      {
                        if (((i == 2) && (k == 2)) || (i9 * 10 >= i18)) {
                          return "SJIS";
                        }
                        return "ISO8859_1";
                      }
                      if (i8 != 0) {
                        return "ISO8859_1";
                      }
                      if (i2 != 0) {
                        return "SJIS";
                      }
                      if (n != 0) {
                        return "UTF8";
                      }
                      return c;
                    }
                  }
                }
                i3 = j;
                j = m;
                m = n;
                n = i3;
                continue;
              }
              i3 = j;
              j = 0;
              i2 = k;
              k = n;
              n = i3;
              continue;
              n = j;
              j = i3;
            }
          }
          label955:
          n = i8;
          i8 = i9;
          i9 = n;
        }
        label970:
        i1 = n;
      }
      label977:
      i6 = i4;
      i4 = i5;
      i5 = i6;
      i6 = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.StringUtils
 * JD-Core Version:    0.7.0.1
 */