package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.request.oicq_request;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

public class e
  extends c
{
  public e()
  {
    this._cmd = 18;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte4 = get_response(paramArrayOfByte, 0);
    if (arrayOfByte4 != null)
    {
      if (arrayOfByte4.length < 8) {
        return -1009;
      }
      paramArrayOfByte = a(arrayOfByte4, 0);
      _status.a = paramArrayOfByte.b;
      _status.h = paramArrayOfByte.c;
      _status.b = paramArrayOfByte.d;
      int i = paramArrayOfByte.a + 0;
      if (_status.b != 0) {
        return _status.b;
      }
      _status.a = util.buf_to_int64(arrayOfByte4, i);
      i += 8;
      _status.c = util.buf_to_int32(arrayOfByte4, i);
      i += 4;
      _status.e = new ArrayList();
      int k = util.buf_to_int16(arrayOfByte4, i);
      byte[] arrayOfByte2 = null;
      i += 2;
      byte[] arrayOfByte1 = null;
      paramArrayOfByte = arrayOfByte1;
      byte[] arrayOfByte3 = paramArrayOfByte;
      int j = 0;
      while (j < k)
      {
        int m = util.buf_to_int16(arrayOfByte4, i);
        int n = i + 2;
        i = util.buf_to_int16(arrayOfByte4, n);
        n += 2;
        if (m != 30)
        {
          Object localObject;
          if (m != 101)
          {
            switch (m)
            {
            default: 
              localObject = new byte[i + 4];
              System.arraycopy(arrayOfByte4, n - 4, localObject, 0, localObject.length);
              _status.e.add(localObject);
              i = n + i;
              break;
            case 25: 
              paramArrayOfByte = new byte[i];
              System.arraycopy(arrayOfByte4, n, paramArrayOfByte, 0, i);
              i = n + i;
              break;
            case 24: 
              arrayOfByte2 = new byte[i];
              System.arraycopy(arrayOfByte4, n, arrayOfByte2, 0, i);
              i = n + i;
              break;
            }
          }
          else
          {
            arrayOfByte3 = new byte[i];
            System.arraycopy(arrayOfByte4, n, arrayOfByte3, 0, i);
            i = n + i;
            localObject = new StringBuilder("get tgtQR len ");
            ((StringBuilder)localObject).append(arrayOfByte3.length);
            localObject = ((StringBuilder)localObject).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(_status.a);
            util.LOGI((String)localObject, localStringBuilder.toString());
          }
        }
        else
        {
          arrayOfByte1 = new byte[i];
          System.arraycopy(arrayOfByte4, n, arrayOfByte1, 0, i);
          i = n + i;
        }
        j += 1;
      }
      if ((arrayOfByte2 != null) && (arrayOfByte1 != null))
      {
        if (paramArrayOfByte == null) {
          return -1009;
        }
        d.q = oicq_request.b(arrayOfByte2, arrayOfByte1);
        d.r = paramArrayOfByte;
        d.s = arrayOfByte3;
        return _status.b;
      }
      return -1009;
    }
    return -1009;
  }
  
  protected a a(byte[] paramArrayOfByte, int paramInt)
  {
    a locala = new a();
    int i = util.buf_to_int16(paramArrayOfByte, paramInt);
    int j = paramInt + 2;
    if (i != 0) {
      paramInt = util.buf_to_int8(paramArrayOfByte, j);
    } else {
      paramInt = 0;
    }
    if (2 == paramInt) {
      locala.b = util.buf_to_int64(paramArrayOfByte, j + 1);
    }
    paramInt = j + i;
    locala.c = util.buf_to_int32(paramArrayOfByte, paramInt);
    locala.d = util.buf_to_int8(paramArrayOfByte, paramInt + 4);
    locala.a = (i + 2 + 4 + 1);
    return locala;
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 13 + (paramArrayOfByte2.length + 11 + 2)];
    util.int16_to_buf(arrayOfByte, 0, 5);
    util.int8_to_buf(arrayOfByte, 2, 1);
    util.int32_to_buf(arrayOfByte, 3, u.aA);
    util.int64_to_buf32(arrayOfByte, 7, paramLong2);
    int i = fill_staff(arrayOfByte, paramArrayOfByte1, 11);
    util.int64_to_buf(arrayOfByte, i, paramLong1);
    i += 8;
    util.int8_to_buf(arrayOfByte, i, 8);
    fill_staff(arrayOfByte, paramArrayOfByte2, i + 1);
    return get_request(paramLong1, true, arrayOfByte);
  }
  
  class a
  {
    int a;
    long b;
    long c;
    int d;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.e
 * JD-Core Version:    0.7.0.1
 */