package okhttp3.internal.http2;

import com.tencent.token.fb;
import java.io.IOException;
import okio.ByteString;

public final class c
{
  static final ByteString a;
  static final String[] b;
  static final String[] c;
  private static final String[] d;
  
  static
  {
    int k = 0;
    a = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    d = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    b = new String[64];
    c = new String[256];
    int i = 0;
    while (i < c.length)
    {
      c[i] = fb.a("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    b[0] = "";
    b[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    b[8] = "PADDED";
    int j = arrayOfInt1.length;
    i = 0;
    while (i < j)
    {
      m = arrayOfInt1[i];
      b[(m | 0x8)] = (b[m] + "|PADDED");
      i += 1;
    }
    b[4] = "END_HEADERS";
    b[32] = "PRIORITY";
    b[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = new int[3];
    int[] tmp250_248 = arrayOfInt2;
    tmp250_248[0] = 4;
    int[] tmp254_250 = tmp250_248;
    tmp254_250[1] = 32;
    int[] tmp259_254 = tmp254_250;
    tmp259_254[2] = 36;
    tmp259_254;
    int m = arrayOfInt2.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      int n = arrayOfInt2[i];
      int i1 = arrayOfInt1.length;
      j = 0;
      while (j < i1)
      {
        int i2 = arrayOfInt1[j];
        b[(i2 | n)] = (b[i2] + '|' + b[n]);
        b[(i2 | n | 0x8)] = (b[i2] + '|' + b[n] + "|PADDED");
        j += 1;
      }
      i += 1;
    }
    while (j < b.length)
    {
      if (b[j] == null) {
        b[j] = c[j];
      }
      j += 1;
    }
  }
  
  static IllegalArgumentException a(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(fb.a(paramString, paramVarArgs));
  }
  
  static String a(byte paramByte1, byte paramByte2)
  {
    Object localObject;
    if (paramByte2 == 0) {
      localObject = "";
    }
    String str;
    do
    {
      do
      {
        return localObject;
        switch (paramByte1)
        {
        case 5: 
        default: 
          if (paramByte2 >= b.length) {
            break;
          }
        }
        for (str = b[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = c[paramByte2])
        {
          return str.replace("HEADERS", "PUSH_PROMISE");
          if (paramByte2 == 1) {
            return "ACK";
          }
          return c[paramByte2];
          return c[paramByte2];
        }
        localObject = str;
      } while (paramByte1 != 0);
      localObject = str;
    } while ((paramByte2 & 0x20) == 0);
    return str.replace("PRIORITY", "COMPRESSED");
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str3;
    if (paramByte1 < d.length)
    {
      str1 = d[paramByte1];
      str3 = a(paramByte1, paramByte2);
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (String str2 = "<<";; str2 = ">>")
    {
      return fb.a("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
      str1 = fb.a("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
    }
  }
  
  static IOException b(String paramString, Object... paramVarArgs)
  {
    throw new IOException(fb.a(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.c
 * JD-Core Version:    0.7.0.1
 */