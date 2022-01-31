package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class an
  extends a
{
  public int h = 0;
  
  public an()
  {
    this.g = 324;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    int m;
    int k;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
    {
      m = 0 + paramArrayOfByte1.length;
      k = 1;
    }
    for (;;)
    {
      int i = k;
      int j = m;
      if (paramArrayOfByte2 != null)
      {
        i = k;
        j = m;
        if (paramArrayOfByte2.length > 0)
        {
          j = m + paramArrayOfByte2.length;
          i = k + 1;
        }
      }
      k = i;
      m = j;
      if (paramArrayOfByte3 != null)
      {
        k = i;
        m = j;
        if (paramArrayOfByte3.length > 0)
        {
          m = j + paramArrayOfByte3.length;
          k = i + 1;
        }
      }
      j = k;
      i = m;
      if (paramArrayOfByte4 != null)
      {
        j = k;
        i = m;
        if (paramArrayOfByte4.length > 0)
        {
          i = m + paramArrayOfByte4.length;
          j = k + 1;
        }
      }
      byte[] arrayOfByte = new byte[i + 2];
      util.int16_to_buf(arrayOfByte, 0, j);
      j = 2;
      i = j;
      if (paramArrayOfByte1 != null)
      {
        i = j;
        if (paramArrayOfByte1.length > 0)
        {
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, paramArrayOfByte1.length);
          i = paramArrayOfByte1.length + 2;
        }
      }
      j = i;
      if (paramArrayOfByte2 != null)
      {
        j = i;
        if (paramArrayOfByte2.length > 0)
        {
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
          j = i + paramArrayOfByte2.length;
        }
      }
      i = j;
      if (paramArrayOfByte3 != null)
      {
        i = j;
        if (paramArrayOfByte3.length > 0)
        {
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, j, paramArrayOfByte3.length);
          i = j + paramArrayOfByte3.length;
        }
      }
      if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
      {
        System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, i, paramArrayOfByte4.length);
        i = paramArrayOfByte4.length;
      }
      paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte5);
      this.h = paramArrayOfByte1.length;
      a(this.g);
      b(paramArrayOfByte1, paramArrayOfByte1.length);
      d();
      return a();
      k = 0;
      m = 0;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8)
  {
    int m;
    int k;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
    {
      m = 0 + paramArrayOfByte1.length;
      k = 1;
    }
    for (;;)
    {
      int i = k;
      int j = m;
      if (paramArrayOfByte2 != null)
      {
        i = k;
        j = m;
        if (paramArrayOfByte2.length > 0)
        {
          j = m + paramArrayOfByte2.length;
          i = k + 1;
        }
      }
      k = i;
      m = j;
      if (paramArrayOfByte3 != null)
      {
        k = i;
        m = j;
        if (paramArrayOfByte3.length > 0)
        {
          m = j + paramArrayOfByte3.length;
          k = i + 1;
        }
      }
      i = k;
      j = m;
      if (paramArrayOfByte4 != null)
      {
        i = k;
        j = m;
        if (paramArrayOfByte4.length > 0)
        {
          j = m + paramArrayOfByte4.length;
          i = k + 1;
        }
      }
      k = i;
      m = j;
      if (paramArrayOfByte5 != null)
      {
        k = i;
        m = j;
        if (paramArrayOfByte5.length > 0)
        {
          m = j + paramArrayOfByte5.length;
          k = i + 1;
        }
      }
      i = k;
      j = m;
      if (paramArrayOfByte6 != null)
      {
        i = k;
        j = m;
        if (paramArrayOfByte6.length > 0)
        {
          j = m + paramArrayOfByte6.length;
          i = k + 1;
        }
      }
      m = i;
      k = j;
      if (paramArrayOfByte7 != null)
      {
        m = i;
        k = j;
        if (paramArrayOfByte7.length > 0)
        {
          k = j + paramArrayOfByte7.length;
          m = i + 1;
        }
      }
      byte[] arrayOfByte = new byte[k + 2];
      util.int16_to_buf(arrayOfByte, 0, m);
      j = 2;
      i = j;
      if (paramArrayOfByte1 != null)
      {
        i = j;
        if (paramArrayOfByte1.length > 0)
        {
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, paramArrayOfByte1.length);
          i = paramArrayOfByte1.length + 2;
        }
      }
      j = i;
      if (paramArrayOfByte2 != null)
      {
        j = i;
        if (paramArrayOfByte2.length > 0)
        {
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
          j = i + paramArrayOfByte2.length;
        }
      }
      i = j;
      if (paramArrayOfByte3 != null)
      {
        i = j;
        if (paramArrayOfByte3.length > 0)
        {
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, j, paramArrayOfByte3.length);
          i = j + paramArrayOfByte3.length;
        }
      }
      j = i;
      if (paramArrayOfByte4 != null)
      {
        j = i;
        if (paramArrayOfByte4.length > 0)
        {
          System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, i, paramArrayOfByte4.length);
          j = i + paramArrayOfByte4.length;
        }
      }
      i = j;
      if (paramArrayOfByte5 != null)
      {
        i = j;
        if (paramArrayOfByte5.length > 0)
        {
          System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, j, paramArrayOfByte5.length);
          i = j + paramArrayOfByte5.length;
        }
      }
      j = i;
      if (paramArrayOfByte6 != null)
      {
        j = i;
        if (paramArrayOfByte6.length > 0)
        {
          System.arraycopy(paramArrayOfByte6, 0, arrayOfByte, i, paramArrayOfByte6.length);
          j = i + paramArrayOfByte6.length;
        }
      }
      if ((paramArrayOfByte7 != null) && (paramArrayOfByte7.length > 0))
      {
        System.arraycopy(paramArrayOfByte7, 0, arrayOfByte, j, paramArrayOfByte7.length);
        i = paramArrayOfByte7.length;
      }
      paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte8);
      this.h = paramArrayOfByte1.length;
      a(this.g);
      b(paramArrayOfByte1, paramArrayOfByte1.length);
      d();
      return a();
      k = 0;
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.an
 * JD-Core Version:    0.7.0.1
 */