package com.tencent.moai.mailsdk.util.stream;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BASE64DecoderStream
  extends FilterInputStream
{
  private static final char[] pem_array;
  private static final byte[] pem_convert_array;
  private byte[] buffer = new byte[3];
  private int bufsize = 0;
  private boolean ignoreErrors = true;
  private int index = 0;
  private byte[] input_buffer = new byte[8190];
  private int input_len = 0;
  private int input_pos = 0;
  
  static
  {
    int k = 0;
    pem_array = new char[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
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
  
  public BASE64DecoderStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public BASE64DecoderStream(InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramInputStream);
    this.ignoreErrors = paramBoolean;
  }
  
  private int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int m = 1;
    int j = paramInt1;
    int i = paramInt2;
    paramInt2 = j;
    int k;
    label24:
    int n;
    if (i >= 3)
    {
      j = 0;
      k = 0;
      if (k < 4)
      {
        n = getByte();
        if ((n == -1) || (n == -2)) {
          if (n == -1)
          {
            if (k == 0) {
              return paramInt2 - paramInt1;
            }
            if (!this.ignoreErrors) {
              throw new IOException("Error in encoded stream: needed 4 valid base64 characters but only got " + k + " before EOF" + recentChars());
            }
            i = 1;
            n = k - 1;
            if (n != 0) {
              break label459;
            }
          }
        }
      }
    }
    for (;;)
    {
      k += 1;
      n = j << 6;
      j = k;
      k = n;
      for (;;)
      {
        if (j >= 4) {
          break label334;
        }
        if (i == 0)
        {
          n = getByte();
          if (n == -1)
          {
            if (this.ignoreErrors) {
              break label318;
            }
            throw new IOException("Error in encoded stream: hit EOF while looking for padding characters (=)" + recentChars());
            if ((k < 2) && (!this.ignoreErrors)) {
              throw new IOException("Error in encoded stream: needed at least 2 valid base64 characters, but only got " + k + " before padding character (=)" + recentChars());
            }
            if (k == 0) {
              return paramInt2 - paramInt1;
            }
            i = 0;
            break;
          }
          if ((n != -2) && (!this.ignoreErrors)) {
            throw new IOException("Error in encoded stream: found valid base64 character after a padding character (=)" + recentChars());
          }
        }
        label318:
        k <<= 6;
        j += 1;
      }
      label334:
      i = k >> 8;
      if (m == 2) {
        paramArrayOfByte[(paramInt2 + 1)] = ((byte)(i & 0xFF));
      }
      paramArrayOfByte[paramInt2] = ((byte)(i >> 8 & 0xFF));
      return m + paramInt2 - paramInt1;
      j = j << 6 | n;
      k += 1;
      break label24;
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(j & 0xFF));
      j >>= 8;
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(j & 0xFF));
      paramArrayOfByte[paramInt2] = ((byte)(j >> 8 & 0xFF));
      i -= 3;
      paramInt2 += 3;
      break;
      return paramInt2 - paramInt1;
      label459:
      m = n;
    }
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length / 4 * 3;
    if (j == 0) {
      return paramArrayOfByte;
    }
    int i = j;
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 61)
    {
      j -= 1;
      i = j;
      if (paramArrayOfByte[(paramArrayOfByte.length - 2)] == 61) {
        i = j - 1;
      }
    }
    byte[] arrayOfByte1 = new byte[i];
    int k = paramArrayOfByte.length;
    int m = 0;
    i = 0;
    if (k > 0)
    {
      j = 3;
      byte[] arrayOfByte2 = pem_convert_array;
      int n = i + 1;
      int i1 = arrayOfByte2[(paramArrayOfByte[i] & 0xFF)];
      arrayOfByte2 = pem_convert_array;
      i = n + 1;
      n = (i1 << 6 | arrayOfByte2[(paramArrayOfByte[n] & 0xFF)]) << 6;
      if (paramArrayOfByte[i] != 61)
      {
        arrayOfByte2 = pem_convert_array;
        i1 = i + 1;
        n |= arrayOfByte2[(paramArrayOfByte[i] & 0xFF)];
        i = i1;
        label156:
        n <<= 6;
        if (paramArrayOfByte[i] == 61) {
          break label269;
        }
        n |= pem_convert_array[(paramArrayOfByte[i] & 0xFF)];
        i += 1;
      }
      for (;;)
      {
        if (j > 2) {
          arrayOfByte1[(m + 2)] = ((byte)(n & 0xFF));
        }
        n >>= 8;
        if (j > 1) {
          arrayOfByte1[(m + 1)] = ((byte)(n & 0xFF));
        }
        arrayOfByte1[m] = ((byte)(n >> 8 & 0xFF));
        m += j;
        k -= 4;
        break;
        j = 2;
        break label156;
        label269:
        j -= 1;
      }
    }
    return arrayOfByte1;
  }
  
  private int getByte()
    throws IOException
  {
    for (;;)
    {
      if (this.input_pos >= this.input_len) {}
      try
      {
        this.input_len = this.in.read(this.input_buffer);
        if (this.input_len <= 0) {
          return -1;
        }
        this.input_pos = 0;
        byte[] arrayOfByte = this.input_buffer;
        int i = this.input_pos;
        this.input_pos = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (i == 61) {
          return -2;
        }
        i = pem_convert_array[i];
        if (i != -1) {
          return i;
        }
      }
      catch (EOFException localEOFException) {}
    }
    return -1;
  }
  
  private String recentChars()
  {
    String str = "";
    int i;
    label56:
    char c;
    if (this.input_pos > 10)
    {
      i = 10;
      if (i <= 0) {
        return str;
      }
      str = "" + ", the " + i + " most recent characters were: \"";
      i = this.input_pos - i;
      if (i >= this.input_pos) {
        break label254;
      }
      c = (char)(this.input_buffer[i] & 0xFF);
      switch (c)
      {
      case '\013': 
      case '\f': 
      default: 
        if ((c >= ' ') && (c < '')) {
          str = str + c;
        }
        break;
      }
    }
    for (;;)
    {
      i += 1;
      break label56;
      i = this.input_pos;
      break;
      str = str + "\\r";
      continue;
      str = str + "\\n";
      continue;
      str = str + "\\t";
      continue;
      str = str + "\\" + c;
    }
    label254:
    str = str + "\"";
    return str;
  }
  
  public int available()
    throws IOException
  {
    return this.in.available() * 3 / 4 + (this.bufsize - this.index);
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if (this.index >= this.bufsize)
    {
      this.bufsize = decode(this.buffer, 0, this.buffer.length);
      if (this.bufsize <= 0) {
        return -1;
      }
      this.index = 0;
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int k = paramInt1;
    int i = paramInt2;
    while ((this.index < this.bufsize) && (i > 0))
    {
      byte[] arrayOfByte = this.buffer;
      paramInt2 = this.index;
      this.index = (paramInt2 + 1);
      paramArrayOfByte[k] = arrayOfByte[paramInt2];
      i -= 1;
      k += 1;
    }
    if (this.index >= this.bufsize)
    {
      this.index = 0;
      this.bufsize = 0;
    }
    int m = i / 3 * 3;
    paramInt2 = k;
    int j = i;
    if (m > 0)
    {
      int n = decode(paramArrayOfByte, k, m);
      k += n;
      j = i - n;
      paramInt2 = k;
      if (n != m)
      {
        if (k == paramInt1) {
          return -1;
        }
        return k - paramInt1;
      }
    }
    do
    {
      paramArrayOfByte[paramInt2] = ((byte)i);
      j -= 1;
      paramInt2 += 1;
      if (j <= 0) {
        break;
      }
      i = read();
    } while (i != -1);
    if (paramInt2 == paramInt1) {
      return -1;
    }
    return paramInt2 - paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.BASE64DecoderStream
 * JD-Core Version:    0.7.0.1
 */