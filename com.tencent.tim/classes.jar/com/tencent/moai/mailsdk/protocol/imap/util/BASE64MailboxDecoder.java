package com.tencent.moai.mailsdk.protocol.imap.util;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class BASE64MailboxDecoder
{
  static final char[] pem_array;
  private static final byte[] pem_convert_array;
  
  static
  {
    int k = 0;
    pem_array = new char[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 44 };
    pem_convert_array = new byte[256];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 255) {
        break;
      }
      pem_convert_array[i] = -1;
      i += 1;
    }
    while (j < pem_array.length)
    {
      pem_convert_array[pem_array[j]] = ((byte)j);
      j += 1;
    }
  }
  
  private static int base64decode(char[] paramArrayOfChar, int paramInt, CharacterIterator paramCharacterIterator)
  {
    int n = 1;
    int i = -1;
    for (;;)
    {
      int j = (byte)paramCharacterIterator.next();
      int k;
      if (j == -1) {
        k = paramInt;
      }
      label23:
      int i1;
      int m;
      int i3;
      label151:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return k;
                if (j != 45) {
                  break;
                }
                k = paramInt;
              } while (n == 0);
              paramArrayOfChar[paramInt] = '&';
              return paramInt + 1;
              i1 = 0;
              m = (byte)paramCharacterIterator.next();
              k = paramInt;
            } while (m == -1);
            k = paramInt;
          } while (m == 45);
          j = pem_convert_array[(j & 0xFF)];
          i3 = pem_convert_array[(m & 0xFF)];
          j = (byte)(j << 2 & 0xFC | i3 >>> 4 & 0x3);
          if (i == -1) {
            break label367;
          }
          paramArrayOfChar[paramInt] = ((char)(i << 8 | j & 0xFF));
          m = -1;
          j = paramInt + 1;
          i2 = (byte)paramCharacterIterator.next();
          i = m;
          n = i1;
          paramInt = j;
          if (i2 == 61) {
            break;
          }
          k = j;
        } while (i2 == -1);
        k = j;
      } while (i2 == 45);
      int i2 = pem_convert_array[(i2 & 0xFF)];
      paramInt = (byte)(i3 << 4 & 0xF0 | i2 >>> 2 & 0xF);
      if (m != -1)
      {
        paramArrayOfChar[j] = ((char)(m << 8 | paramInt & 0xFF));
        m = -1;
        j += 1;
      }
      for (;;)
      {
        i3 = (byte)paramCharacterIterator.next();
        i = m;
        n = i1;
        paramInt = j;
        if (i3 == 61) {
          break;
        }
        k = j;
        if (i3 == -1) {
          break label23;
        }
        k = j;
        if (i3 == 45) {
          break label23;
        }
        paramInt = (byte)(pem_convert_array[(i3 & 0xFF)] & 0x3F | i2 << 6 & 0xC0);
        if (m == -1) {
          break label391;
        }
        paramArrayOfChar[j] = ((char)(m << 8 | paramInt & 0xFF));
        i = -1;
        paramInt = j + 1;
        n = i1;
        break;
        label367:
        m = j & 0xFF;
        j = paramInt;
        break label151;
        m = paramInt & 0xFF;
      }
      label391:
      i = paramInt & 0xFF;
      n = i1;
      paramInt = j;
    }
  }
  
  public static String decode(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    char[] arrayOfChar;
    int j;
    int k;
    do
    {
      return paramString;
      arrayOfChar = new char[paramString.length()];
      StringCharacterIterator localStringCharacterIterator = new StringCharacterIterator(paramString);
      int i = localStringCharacterIterator.first();
      j = 0;
      k = 0;
      if (i != 65535)
      {
        if (i == 38) {
          k = 1;
        }
        int m;
        for (j = base64decode(arrayOfChar, j, localStringCharacterIterator);; j = m)
        {
          i = localStringCharacterIterator.next();
          break;
          m = j + 1;
          arrayOfChar[j] = i;
        }
      }
    } while (k == 0);
    return new String(arrayOfChar, 0, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.util.BASE64MailboxDecoder
 * JD-Core Version:    0.7.0.1
 */