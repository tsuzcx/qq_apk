package oicq.wlogin_sdk.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.g;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int a = 11;
  public int b = 0;
  public int c = 5;
  public int d = 0;
  protected int e = 3;
  
  public static int a(int paramInt, byte[] paramArrayOfByte, i parami)
  {
    Object localObject = b(paramArrayOfByte);
    int j = localObject[0];
    int i = localObject[1];
    if (j == -1009) {
      return j;
    }
    int k = i + 2;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.d = (util.buf_to_int16(paramArrayOfByte, i) & 0xFFFF);
    i = k + 2;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    int m = util.buf_to_int16(paramArrayOfByte, k);
    k = i + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    localObject = new byte[m];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, m);
    i = k + 1;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    m = util.buf_to_int8(paramArrayOfByte, k);
    k = i + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.e = new byte[m];
    System.arraycopy(paramArrayOfByte, i, parami.e, 0, m);
    i = k + 2;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    m = util.buf_to_int16(paramArrayOfByte, k);
    k = i + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.f = new byte[m];
    System.arraycopy(paramArrayOfByte, i, parami.f, 0, m);
    i = j;
    if (paramInt == 3)
    {
      paramInt = k + 2;
      i = j;
      if (paramInt <= paramArrayOfByte.length)
      {
        i = util.buf_to_int16(paramArrayOfByte, k);
        StringBuilder localStringBuilder = new StringBuilder("reg cmd 0x3 has ");
        localStringBuilder.append(i);
        localStringBuilder.append(" tlv");
        util.LOGI(localStringBuilder.toString());
        i = g.a(i, paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt, parami.C);
        if (i != 0)
        {
          util.LOGI("parser tlv failed ".concat(String.valueOf(i)), "");
          return -1009;
        }
        paramArrayOfByte = new StringBuilder("reg cmd 0x3 tlv map size ");
        paramArrayOfByte.append(parami.C.size());
        util.LOGI(paramArrayOfByte.toString());
      }
    }
    if (localObject.length <= 0) {
      return i;
    }
    paramInt = parami.d;
    if (paramInt != 0)
    {
      if (paramInt != 31)
      {
        if ((paramInt != 44) && (paramInt != 51)) {
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
              return i;
            case 59: 
              if (2 > localObject.length) {
                return -1009;
              }
              paramInt = util.buf_to_int16((byte[])localObject, 0);
              if (paramInt + 2 > localObject.length) {
                return -1009;
              }
              parami.s = new byte[paramInt];
              System.arraycopy(localObject, 2, parami.s, 0, paramInt);
              return i;
            }
          case 5: 
            if (2 > localObject.length) {
              return -1009;
            }
            parami.t = util.buf_to_int16((byte[])localObject, 0);
            if (4 > localObject.length) {
              return -1009;
            }
            parami.u = util.buf_to_int16((byte[])localObject, 2);
            return i;
          case 4: 
            if (2 > localObject.length) {
              return -1009;
            }
            parami.t = util.buf_to_int16((byte[])localObject, 0);
            if (4 > localObject.length) {
              return -1009;
            }
            parami.u = util.buf_to_int16((byte[])localObject, 2);
            return i;
          case 2: 
            if (1 > localObject.length) {
              return -1009;
            }
            paramInt = util.buf_to_int8((byte[])localObject, 0);
            j = paramInt + 1;
            if (j > localObject.length) {
              return -1009;
            }
            parami.o = new byte[paramInt];
            System.arraycopy(localObject, 1, parami.o, 0, paramInt);
            paramInt = j + 1;
            k = util.buf_to_int8((byte[])localObject, j);
            j = paramInt + k;
            if (j > localObject.length) {
              return -1009;
            }
            parami.p = new byte[k];
            System.arraycopy(localObject, paramInt, parami.p, 0, k);
            paramInt = util.buf_to_int16((byte[])localObject, j);
            j += 2;
            if (j + paramInt > localObject.length) {
              return -1009;
            }
            parami.q = new byte[paramInt];
            System.arraycopy(localObject, j, parami.q, 0, paramInt);
            return i;
          }
        }
        if (2 > localObject.length) {
          return -1009;
        }
        paramInt = util.buf_to_int16((byte[])localObject, 0);
        if (paramInt + 2 > localObject.length) {
          return -1009;
        }
        parami.r = new byte[paramInt];
        System.arraycopy(localObject, 2, parami.r, 0, paramInt);
        return i;
      }
      parami.t = 0;
      parami.u = 0;
      return i;
    }
    if (4 > localObject.length) {
      return -1009;
    }
    parami.m = util.buf_to_int32((byte[])localObject, 0);
    if (5 > localObject.length) {
      return -1009;
    }
    paramInt = util.buf_to_int8((byte[])localObject, 4);
    if (paramInt + 5 > localObject.length) {
      return -1009;
    }
    parami.n = new byte[paramInt];
    System.arraycopy(localObject, 5, parami.n, 0, paramInt);
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte, i parami)
  {
    return a(0, paramArrayOfByte, parami);
  }
  
  public static int b(byte[] paramArrayOfByte, i parami)
  {
    int[] arrayOfInt = b(paramArrayOfByte);
    int j = arrayOfInt[0];
    int i = arrayOfInt[1];
    if (j == -1009) {
      return j;
    }
    j = i + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    parami.d = util.buf_to_int16(paramArrayOfByte, i);
    i = j + 1;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    int k = util.buf_to_int8(paramArrayOfByte, j);
    j = i + k;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    parami.e = new byte[k];
    System.arraycopy(paramArrayOfByte, i, parami.e, 0, k);
    i = j + 2;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    k = util.buf_to_int16(paramArrayOfByte, j);
    j = i + k;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    parami.f = new byte[k];
    System.arraycopy(paramArrayOfByte, i, parami.f, 0, k);
    i = j + 2;
    if (i > paramArrayOfByte.length) {
      return 0;
    }
    i = g.a(util.buf_to_int16(paramArrayOfByte, j), paramArrayOfByte, i, paramArrayOfByte.length - i, parami.C);
    if (i != 0)
    {
      util.LOGI("parser tlv failed ".concat(String.valueOf(i)), "");
      return -1009;
    }
    return i;
  }
  
  private static int[] b(byte[] paramArrayOfByte)
  {
    if (1 > paramArrayOfByte.length) {
      return new int[] { -1009, 0 };
    }
    if (3 > paramArrayOfByte.length) {
      return new int[] { -1009, 1 };
    }
    if (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) {
      return new int[] { -1009, 3 };
    }
    if (7 > paramArrayOfByte.length) {
      return new int[] { -1009, 3 };
    }
    if (8 > paramArrayOfByte.length) {
      return new int[] { -1009, 7 };
    }
    int i = util.buf_to_int8(paramArrayOfByte, 7) + 8;
    if (i > paramArrayOfByte.length) {
      return new int[] { -1009, 8 };
    }
    return new int[] { 0, i };
  }
  
  public static int c(byte[] paramArrayOfByte, i parami)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    int k = j + 2;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.d = util.buf_to_int16(paramArrayOfByte, j);
    j = k + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    int m = util.buf_to_int16(paramArrayOfByte, k);
    k = j + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    byte[] arrayOfByte = new byte[m];
    System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, m);
    if (parami.d == 0)
    {
      if ((parami.j != null) && (parami.j.length > 0)) {
        localObject = MD5.toMD5Byte(parami.j);
      } else {
        localObject = i.a.getBytes();
      }
      localObject = cryptor.decrypt(arrayOfByte, 0, m, (byte[])localObject);
      if (localObject == null) {
        return -1009;
      }
      if (1 > localObject.length) {
        return -1009;
      }
      i = util.buf_to_int8((byte[])localObject, 0) + 1;
      if (i > localObject.length) {
        return -1009;
      }
      j = i + 8;
      if (j > localObject.length) {
        return -1009;
      }
      parami.v = util.buf_to_int64((byte[])localObject, i);
      i = j + 2;
      if (i > localObject.length) {
        return -1009;
      }
      m = util.buf_to_int16((byte[])localObject, j);
      j = i + m;
      if (j > localObject.length) {
        return -1009;
      }
      parami.w = new byte[m];
      System.arraycopy(localObject, i, parami.w, 0, m);
      i = j + 2;
      if (i > localObject.length) {
        return -1009;
      }
      j = g.a(util.buf_to_int16((byte[])localObject, j), (byte[])localObject, i, localObject.length - i, parami.C);
      if (j != 0)
      {
        util.LOGI("parse tlv failed ".concat(String.valueOf(j)), "");
        return -1009;
      }
      localObject = (tlv_t)parami.C.get(Integer.valueOf(7));
      if (localObject != null) {
        parami.x = ((tlv_t)localObject).get_data();
      }
      localObject = (tlv_t)parami.C.get(Integer.valueOf(12));
      i = j;
      if (localObject != null)
      {
        i.z = util.buf_to_int64(((tlv_t)localObject).get_data(), 0);
        i = j;
      }
    }
    j = k + 1;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    m = util.buf_to_int8(paramArrayOfByte, k);
    k = j + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.e = new byte[m];
    System.arraycopy(paramArrayOfByte, j, parami.e, 0, m);
    j = k + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    k = util.buf_to_int16(paramArrayOfByte, k);
    if (j + k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.f = new byte[k];
    System.arraycopy(paramArrayOfByte, j, parami.f, 0, k);
    return i;
  }
  
  public static int d(byte[] paramArrayOfByte, i parami)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    int k = j + 2;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.d = util.buf_to_int16(paramArrayOfByte, j);
    j = k + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    int m = util.buf_to_int16(paramArrayOfByte, k);
    k = j + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    parami.f = new byte[m];
    System.arraycopy(paramArrayOfByte, j, parami.f, 0, m);
    j = k + 2;
    if (j <= paramArrayOfByte.length)
    {
      k = util.buf_to_int16(paramArrayOfByte, k);
      if (j + k > paramArrayOfByte.length) {
        return -1009;
      }
      if (k > 0)
      {
        localObject = new byte[k + 2];
        System.arraycopy(paramArrayOfByte, j, localObject, 1, k);
        localObject[0] = 40;
        localObject[(k + 1)] = 41;
        paramArrayOfByte = new String(parami.f);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(new String((byte[])localObject));
        localStringBuilder.append("。");
        parami.f = paramArrayOfByte.replace("。", localStringBuilder.toString()).getBytes();
      }
    }
    return i;
  }
  
  public static int e(byte[] paramArrayOfByte, i parami)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, j, paramArrayOfByte.length - j);
    localObject = new DataInputStream(paramArrayOfByte);
    try
    {
      ((DataInputStream)localObject).readByte();
      parami.d = ((DataInputStream)localObject).readShort();
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        ((DataInputStream)localObject).read(arrayOfByte);
        arrayOfByte = cryptor.decrypt(arrayOfByte, 0, i, parami.l);
        if (arrayOfByte == null)
        {
          util.LOGI("no tlv in rsp", "");
          return -1;
        }
        i = g.a(util.buf_to_int16(arrayOfByte, 0), arrayOfByte, 2, arrayOfByte.length - 2, parami.C);
        if (i != 0)
        {
          util.LOGI("parser tlv failed ".concat(String.valueOf(i)), "");
          return -1009;
        }
      }
      parami.e = new byte[((DataInputStream)localObject).readByte()];
      ((DataInputStream)localObject).read(parami.e);
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        parami.f = new byte[i];
        if (((DataInputStream)localObject).read(parami.f) != i)
        {
          paramArrayOfByte = new StringBuilder("msg len ");
          paramArrayOfByte.append(i);
          paramArrayOfByte.append(" error");
          throw new Exception(paramArrayOfByte.toString());
        }
      }
      ((DataInputStream)localObject).close();
      paramArrayOfByte.close();
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      parami = new StringBuilder("parse0x10Rsp failed ");
      parami.append(paramArrayOfByte.getMessage());
      util.LOGI(parami.toString(), "");
    }
    return -1009;
  }
  
  public static int f(byte[] paramArrayOfByte, i parami)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, j, paramArrayOfByte.length - j);
    localObject = new DataInputStream(paramArrayOfByte);
    try
    {
      ((DataInputStream)localObject).readByte();
      parami.d = ((DataInputStream)localObject).readShort();
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        ((DataInputStream)localObject).read(arrayOfByte);
        arrayOfByte = cryptor.decrypt(arrayOfByte, 0, i, parami.l);
        if (arrayOfByte == null)
        {
          util.LOGI("no tlv in rsp", "");
          return -1;
        }
        i = g.a(util.buf_to_int16(arrayOfByte, 0), arrayOfByte, 2, arrayOfByte.length - 2, parami.C);
        if (i != 0)
        {
          util.LOGI("parser tlv failed ".concat(String.valueOf(i)), "");
          return -1009;
        }
      }
      parami.e = new byte[((DataInputStream)localObject).readByte()];
      ((DataInputStream)localObject).read(parami.e);
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        parami.f = new byte[i];
        if (((DataInputStream)localObject).read(parami.f) != i)
        {
          paramArrayOfByte = new StringBuilder("msg len ");
          paramArrayOfByte.append(i);
          paramArrayOfByte.append(" error");
          throw new Exception(paramArrayOfByte.toString());
        }
      }
      ((DataInputStream)localObject).close();
      paramArrayOfByte.close();
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      parami = new StringBuilder("parse0x11Rsp failed ");
      parami.append(paramArrayOfByte.getMessage());
      util.LOGI(parami.toString(), "");
    }
    return -1009;
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
    util.int16_to_buf(arrayOfByte, 3, this.e);
    util.int16_to_buf(arrayOfByte, 5, this.b);
    util.int8_to_buf(arrayOfByte, 7, 4);
    util.int32_to_buf(arrayOfByte, 8, 0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 12, paramArrayOfByte.length);
    util.int8_to_buf(arrayOfByte, paramArrayOfByte.length + 12, 3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */