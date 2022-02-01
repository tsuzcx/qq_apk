package com.tencent.token;

import java.io.IOException;

public final class alx
{
  static final amy a = amy.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] b;
  static final String[] c;
  private static final String[] d;
  
  static
  {
    int k = 0;
    d = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    b = new String[64];
    c = new String[256];
    int i = 0;
    for (;;)
    {
      localObject = c;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = akt.a("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    String[] arrayOfString = b;
    arrayOfString[0] = "";
    arrayOfString[1] = "END_STREAM";
    Object localObject = new int[1];
    localObject[0] = 1;
    arrayOfString[8] = "PADDED";
    i = 0;
    int j;
    StringBuilder localStringBuilder;
    while (i <= 0)
    {
      j = localObject[i];
      arrayOfString = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b[j]);
      localStringBuilder.append("|PADDED");
      arrayOfString[(j | 0x8)] = localStringBuilder.toString();
      i += 1;
    }
    arrayOfString = b;
    arrayOfString[4] = "END_HEADERS";
    arrayOfString[32] = "PRIORITY";
    arrayOfString[36] = "END_HEADERS|PRIORITY";
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= 3) {
        break;
      }
      int m = new int[] { 4, 32, 36 }[i];
      j = 0;
      while (j <= 0)
      {
        int n = localObject[j];
        arrayOfString = b;
        int i1 = n | m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b[n]);
        localStringBuilder.append('|');
        localStringBuilder.append(b[m]);
        arrayOfString[i1] = localStringBuilder.toString();
        arrayOfString = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b[n]);
        localStringBuilder.append('|');
        localStringBuilder.append(b[m]);
        localStringBuilder.append("|PADDED");
        arrayOfString[(i1 | 0x8)] = localStringBuilder.toString();
        j += 1;
      }
      i += 1;
    }
    for (;;)
    {
      localObject = b;
      if (j >= localObject.length) {
        break;
      }
      if (localObject[j] == null) {
        localObject[j] = c[j];
      }
      j += 1;
    }
  }
  
  static IllegalArgumentException a(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(akt.a(paramString, paramVarArgs));
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    Object localObject = d;
    String str1;
    if (paramByte1 < localObject.length) {
      str1 = localObject[paramByte1];
    } else {
      str1 = akt.a("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
    }
    if (paramByte2 == 0)
    {
      localObject = "";
    }
    else
    {
      switch (paramByte1)
      {
      case 5: 
      default: 
        localObject = b;
        if (paramByte2 < localObject.length) {
          localObject = localObject[paramByte2];
        }
        break;
      case 4: 
      case 6: 
        if (paramByte2 == 1) {
          localObject = "ACK";
        } else {
          localObject = c[paramByte2];
        }
        break;
      case 2: 
      case 3: 
      case 7: 
      case 8: 
        localObject = c[paramByte2];
        break;
      }
      localObject = c[paramByte2];
      if ((paramByte1 == 5) && ((paramByte2 & 0x4) != 0)) {
        localObject = ((String)localObject).replace("HEADERS", "PUSH_PROMISE");
      } else if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
        localObject = ((String)localObject).replace("PRIORITY", "COMPRESSED");
      }
    }
    String str2;
    if (paramBoolean) {
      str2 = "<<";
    } else {
      str2 = ">>";
    }
    return akt.a("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, localObject });
  }
  
  static IOException b(String paramString, Object... paramVarArgs)
  {
    throw new IOException(akt.a(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alx
 * JD-Core Version:    0.7.0.1
 */