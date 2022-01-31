package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int a = 11;
  public int b = 0;
  public int c = 5;
  public int d = 0;
  
  public static int a(byte[] paramArrayOfByte, h paramh)
  {
    int k = 0;
    int i;
    if (1 > paramArrayOfByte.length) {
      i = -1009;
    }
    int j;
    byte[] arrayOfByte;
    do
    {
      return i;
      if (3 > paramArrayOfByte.length) {
        return -1009;
      }
      if (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) {
        return -1009;
      }
      if (7 > paramArrayOfByte.length) {
        return -1009;
      }
      if (8 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int8(paramArrayOfByte, 7);
      if (i + 8 > paramArrayOfByte.length) {
        return -1009;
      }
      i += 8;
      if (i + 1 > paramArrayOfByte.length) {
        return -1009;
      }
      paramh.d = (util.buf_to_int8(paramArrayOfByte, i) & 0xFF);
      j = i + 1;
      if (j + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
      if (j + i > paramArrayOfByte.length) {
        return -1009;
      }
      arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
      j += i;
      if (j + 1 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int8(paramArrayOfByte, j);
      j += 1;
      if (j + i > paramArrayOfByte.length) {
        return -1009;
      }
      paramh.e = new byte[i];
      System.arraycopy(paramArrayOfByte, j, paramh.e, 0, i);
      j += i;
      if (j + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
      if (j + i > paramArrayOfByte.length) {
        return -1009;
      }
      paramh.f = new byte[i];
      System.arraycopy(paramArrayOfByte, j, paramh.f, 0, i);
      i = k;
    } while (arrayOfByte.length <= 0);
    if (paramh.d == 0)
    {
      if (4 > arrayOfByte.length) {
        return -1009;
      }
      paramh.l = util.buf_to_int32(arrayOfByte, 0);
      if (5 > arrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int8(arrayOfByte, 4);
      if (i + 5 > arrayOfByte.length) {
        return -1009;
      }
      paramh.m = new byte[i];
      System.arraycopy(arrayOfByte, 5, paramh.m, 0, i);
      return 0;
    }
    if (paramh.d == 2)
    {
      if (1 > arrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int8(arrayOfByte, 0);
      if (i + 1 > arrayOfByte.length) {
        return -1009;
      }
      paramh.n = new byte[i];
      System.arraycopy(arrayOfByte, 1, paramh.n, 0, i);
      paramh.o = new byte[6];
      j = 0;
      for (;;)
      {
        i = k;
        if (j >= paramh.o.length) {
          break;
        }
        paramh.o[j] = ((byte)((byte)(util.get_rand_32() % 10) + 48));
        j += 1;
      }
    }
    if ((paramh.d == 3) || (paramh.d == 6) || (paramh.d == 44))
    {
      if (2 > arrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int16(arrayOfByte, 0);
      if (i + 2 > arrayOfByte.length) {
        return -1009;
      }
      paramh.p = new byte[i];
      System.arraycopy(arrayOfByte, 2, paramh.p, 0, i);
      return 0;
    }
    if (paramh.d == 4)
    {
      if (2 > arrayOfByte.length) {
        return -1009;
      }
      paramh.q = util.buf_to_int16(arrayOfByte, 0);
      if (4 > arrayOfByte.length) {
        return -1009;
      }
      paramh.r = util.buf_to_int16(arrayOfByte, 2);
      return 0;
    }
    if (paramh.d == 5)
    {
      if (2 > arrayOfByte.length) {
        return -1009;
      }
      paramh.q = util.buf_to_int16(arrayOfByte, 0);
      if (4 > arrayOfByte.length) {
        return -1009;
      }
      paramh.r = util.buf_to_int16(arrayOfByte, 2);
      return 0;
    }
    util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
    return 0;
  }
  
  public static int b(byte[] paramArrayOfByte, h paramh)
  {
    if (1 > paramArrayOfByte.length) {}
    int i;
    int j;
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
              do
              {
                do
                {
                  return -1009;
                } while ((3 > paramArrayOfByte.length) || (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) || (7 > paramArrayOfByte.length) || (8 > paramArrayOfByte.length));
                i = util.buf_to_int8(paramArrayOfByte, 7);
              } while (i + 8 > paramArrayOfByte.length);
              i += 8;
            } while (i + 1 > paramArrayOfByte.length);
            paramh.d = util.buf_to_int8(paramArrayOfByte, i);
            j = i + 1;
          } while (j + 1 > paramArrayOfByte.length);
          i = util.buf_to_int8(paramArrayOfByte, j);
          j += 1;
        } while (j + i > paramArrayOfByte.length);
        paramh.e = new byte[i];
        System.arraycopy(paramArrayOfByte, j, paramh.e, 0, i);
        j += i;
      } while (j + 2 > paramArrayOfByte.length);
      i = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
    } while (j + i > paramArrayOfByte.length);
    paramh.f = new byte[i];
    System.arraycopy(paramArrayOfByte, j, paramh.f, 0, i);
    return 0;
  }
  
  public static int c(byte[] paramArrayOfByte, h paramh)
  {
    if (1 > paramArrayOfByte.length) {
      return -1009;
    }
    if (3 > paramArrayOfByte.length) {
      return -1009;
    }
    if (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) {
      return -1009;
    }
    if (7 > paramArrayOfByte.length) {
      return -1009;
    }
    if (8 > paramArrayOfByte.length) {
      return -1009;
    }
    int i = util.buf_to_int8(paramArrayOfByte, 7);
    if (i + 8 > paramArrayOfByte.length) {
      return -1009;
    }
    i += 8;
    if (i + 1 > paramArrayOfByte.length) {
      return -1009;
    }
    paramh.d = util.buf_to_int8(paramArrayOfByte, i);
    int j = i + 1;
    if (j + 1 > paramArrayOfByte.length) {
      return -1009;
    }
    i = util.buf_to_int8(paramArrayOfByte, j);
    j += 1;
    if (j + i > paramArrayOfByte.length) {
      return -1009;
    }
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, i);
    int k = j + i;
    if (paramh.d == 0)
    {
      if ((paramh.j == null) || (paramh.j.length <= 0)) {}
      for (byte[] arrayOfByte1 = h.a.getBytes();; arrayOfByte1 = MD5.toMD5Byte(paramh.j))
      {
        arrayOfByte1 = cryptor.decrypt(arrayOfByte2, 0, arrayOfByte2.length, arrayOfByte1);
        if (arrayOfByte1 != null) {
          break;
        }
        return -1009;
      }
      if (1 > arrayOfByte1.length) {
        return -1009;
      }
      i = util.buf_to_int8(arrayOfByte1, 0);
      if (i + 1 > arrayOfByte1.length) {
        return -1009;
      }
      i += 1;
      if (i + 8 > arrayOfByte1.length) {
        return -1009;
      }
      paramh.s = util.buf_to_int64(arrayOfByte1, i);
      j = i + 8;
      if (j + 2 > arrayOfByte1.length) {
        return -1009;
      }
      i = util.buf_to_int16(arrayOfByte1, j);
      j += 2;
      if (j + i > arrayOfByte1.length) {
        return -1009;
      }
      paramh.t = new byte[i];
      System.arraycopy(arrayOfByte1, j, paramh.t, 0, i);
      i = j + i;
      if (i + 1 > arrayOfByte1.length) {
        return -1009;
      }
      int m = util.buf_to_int8(arrayOfByte1, i);
      j = i + 1;
      i = 0;
      if (i < m)
      {
        if (j + 2 > arrayOfByte1.length) {
          return -1009;
        }
        int n = util.buf_to_int8(arrayOfByte1, j);
        int i1 = j + 1;
        j = util.buf_to_int8(arrayOfByte1, i1);
        i1 += 1;
        if (i1 + j > arrayOfByte1.length) {
          return -1009;
        }
        switch (n)
        {
        }
        for (;;)
        {
          j = i1 + j;
          i += 1;
          break;
          paramh.u = new byte[j];
          System.arraycopy(arrayOfByte1, i1, paramh.u, 0, j);
          continue;
          arrayOfByte2 = new byte[j];
          System.arraycopy(arrayOfByte1, i1, arrayOfByte2, 0, j);
          h.w = util.buf_to_int64(arrayOfByte2, 0);
        }
      }
    }
    if (k + 1 > paramArrayOfByte.length) {
      return -1009;
    }
    i = util.buf_to_int8(paramArrayOfByte, k);
    j = k + 1;
    if (j + i > paramArrayOfByte.length) {
      return -1009;
    }
    paramh.e = new byte[i];
    System.arraycopy(paramArrayOfByte, j, paramh.e, 0, i);
    j = i + j;
    if (j + 2 > paramArrayOfByte.length) {
      return -1009;
    }
    i = util.buf_to_int16(paramArrayOfByte, j);
    j += 2;
    if (j + i > paramArrayOfByte.length) {
      return -1009;
    }
    paramh.f = new byte[i];
    System.arraycopy(paramArrayOfByte, j, paramh.f, 0, i);
    return 0;
  }
  
  public static int d(byte[] paramArrayOfByte, h paramh)
  {
    if (1 > paramArrayOfByte.length) {}
    int i;
    int j;
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
              do
              {
                return -1009;
              } while ((3 > paramArrayOfByte.length) || (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) || (7 > paramArrayOfByte.length) || (8 > paramArrayOfByte.length));
              i = util.buf_to_int8(paramArrayOfByte, 7);
            } while (i + 8 > paramArrayOfByte.length);
            i += 8;
          } while (i + 1 > paramArrayOfByte.length);
          paramh.d = util.buf_to_int8(paramArrayOfByte, i);
          j = i + 1;
        } while (j + 2 > paramArrayOfByte.length);
        i = util.buf_to_int16(paramArrayOfByte, j);
        j += 2;
      } while (j + i > paramArrayOfByte.length);
      paramh.f = new byte[i];
      System.arraycopy(paramArrayOfByte, j, paramh.f, 0, i);
      j += i;
      if (j + 2 > paramArrayOfByte.length) {
        break;
      }
      i = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
    } while (j + i > paramArrayOfByte.length);
    if (i > 0)
    {
      byte[] arrayOfByte = new byte[i + 2];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 1, i);
      arrayOfByte[0] = 40;
      arrayOfByte[(i + 1)] = 41;
      paramh.f = new String(paramh.f).replace("。", new String(arrayOfByte) + "。").getBytes();
    }
    return 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.a + 2 + paramArrayOfByte.length];
    util.int8_to_buf(arrayOfByte, 0, 2);
    util.int16_to_buf(arrayOfByte, 1, this.a + paramArrayOfByte.length + 2);
    util.int16_to_buf(arrayOfByte, 3, 1);
    util.int16_to_buf(arrayOfByte, 5, this.b);
    util.int8_to_buf(arrayOfByte, 7, 4);
    util.int32_to_buf(arrayOfByte, 8, 0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 12, paramArrayOfByte.length);
    int i = paramArrayOfByte.length + 12;
    util.int8_to_buf(arrayOfByte, i, 3);
    return arrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 1];
    util.int8_to_buf(arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte2);
    return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */