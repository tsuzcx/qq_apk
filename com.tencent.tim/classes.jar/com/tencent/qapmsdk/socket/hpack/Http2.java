package com.tencent.qapmsdk.socket.hpack;

import java.io.IOException;
import okio.ByteString;

public final class Http2
{
  static final String[] BINARY;
  static final ByteString CONNECTION_PREFACE;
  static final String[] FLAGS;
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  private static final String[] FRAME_NAMES;
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  
  static
  {
    int k = 0;
    CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    FLAGS = new String[64];
    BINARY = new String[256];
    FRAME_NAMES = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    int i = 0;
    while (i < BINARY.length)
    {
      BINARY[i] = Util.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    FLAGS[0] = "";
    FLAGS[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    FLAGS[8] = "PADDED";
    int j = arrayOfInt1.length;
    i = 0;
    while (i < j)
    {
      m = arrayOfInt1[i];
      FLAGS[(m | 0x8)] = (FLAGS[m] + "|PADDED");
      i += 1;
    }
    FLAGS[4] = "END_HEADERS";
    FLAGS[32] = "PRIORITY";
    FLAGS[36] = "END_HEADERS|PRIORITY";
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
        FLAGS[(i2 | n)] = (FLAGS[i2] + '|' + FLAGS[n]);
        FLAGS[(i2 | n | 0x8)] = (FLAGS[i2] + '|' + FLAGS[n] + "|PADDED");
        j += 1;
      }
      i += 1;
    }
    while (j < FLAGS.length)
    {
      if (FLAGS[j] == null) {
        FLAGS[j] = BINARY[j];
      }
      j += 1;
    }
  }
  
  static String formatFlags(byte paramByte1, byte paramByte2)
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
          if (paramByte2 >= FLAGS.length) {
            break;
          }
        }
        for (str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
        {
          return str.replace("HEADERS", "PUSH_PROMISE");
          if (paramByte2 == 1) {
            return "ACK";
          }
          return BINARY[paramByte2];
          return BINARY[paramByte2];
        }
        localObject = str;
      } while (paramByte1 != 0);
      localObject = str;
    } while ((paramByte2 & 0x20) == 0);
    return str.replace("PRIORITY", "COMPRESSED");
  }
  
  static String frameLog(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str3;
    if (paramByte1 < FRAME_NAMES.length)
    {
      str1 = FRAME_NAMES[paramByte1];
      str3 = formatFlags(paramByte1, paramByte2);
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (String str2 = "<<";; str2 = ">>")
    {
      return Util.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
      str1 = Util.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
    }
  }
  
  static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(Util.format(paramString, paramVarArgs));
  }
  
  static IOException ioException(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(Util.format(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.hpack.Http2
 * JD-Core Version:    0.7.0.1
 */