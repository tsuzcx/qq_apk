package oicq.wlogin_sdk.code2d;

import android.content.Context;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import oicq.wlogin_sdk.request.WloginAllSigInfo;
import oicq.wlogin_sdk.request.j;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class a
  extends b
{
  protected static byte[] a = null;
  
  public a()
  {
    this._cmd = 20;
  }
  
  public int a(byte[] paramArrayOfByte, long paramLong, Context paramContext)
  {
    paramArrayOfByte = get_response(paramArrayOfByte, 0);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 11)) {
      return -1009;
    }
    _status.a = util.buf_to_int64(paramArrayOfByte, 2);
    _status.b = (util.buf_to_int8(paramArrayOfByte, 10) & 0xFF);
    if (_status.b != 0)
    {
      i = util.buf_to_int16(paramArrayOfByte, 11);
      _status.f = new byte[i];
      System.arraycopy(paramArrayOfByte, 13, _status.f, 0, i);
      return _status.b;
    }
    _status.c = (util.buf_to_int32(paramArrayOfByte, 11) & 0xFFFFFFFF);
    int i = util.buf_to_int16(paramArrayOfByte, 15);
    _status.d = new byte[i];
    System.arraycopy(paramArrayOfByte, 17, _status.d, 0, i);
    i += 17;
    if (i + 2 + 2 + 1 >= paramArrayOfByte.length) {
      return _status.b;
    }
    int j = util.buf_to_int16(paramArrayOfByte, i);
    if (j == 0) {
      return _status.b;
    }
    Object localObject4 = cryptor.decrypt(paramArrayOfByte, i + 2, j, a);
    if ((localObject4 == null) || (localObject4.length == 0)) {
      return -1014;
    }
    int k = util.buf_to_int16((byte[])localObject4, 0);
    Object localObject1 = null;
    Object localObject2 = null;
    paramArrayOfByte = null;
    j = 2;
    i = 0;
    Object localObject3;
    if (i < k)
    {
      int m = util.buf_to_int16((byte[])localObject4, j);
      int n = j + 2;
      j = util.buf_to_int16((byte[])localObject4, n);
      n += 2;
      switch (m)
      {
      default: 
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        i += 1;
        j = n + j;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = new byte[j];
        System.arraycopy(localObject4, n, localObject3, 0, j);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        paramArrayOfByte = new byte[j];
        System.arraycopy(localObject4, n, paramArrayOfByte, 0, j);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = new byte[j];
        System.arraycopy(localObject4, n, localObject3, 0, j);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    if (c.s)
    {
      if ((paramArrayOfByte == null) || (localObject1 == null) || (localObject2 == null)) {
        return -1009;
      }
      paramContext = oicq.wlogin_sdk.request.c.a(paramContext, "tk_file");
      if (paramContext == null) {
        return -1004;
      }
      localObject3 = (WloginAllSigInfo)paramContext.get(Long.valueOf(_status.a));
      if (localObject3 == null) {
        return -1004;
      }
      localObject4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
      i = 0;
      while (i < 5)
      {
        localObject4[i] = new byte[0];
        i += 1;
      }
      localObject4[0] = j.b(localObject1, localObject2);
      localObject4[1] = paramArrayOfByte;
      ((WloginAllSigInfo)localObject3).put_siginfo(paramLong, (byte[][])localObject4, t.f());
      paramContext.put(Long.valueOf(_status.a), ((WloginAllSigInfo)localObject3).get_clone());
      t.ae.a(paramContext, "tk_file");
    }
    return _status.b;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, List<byte[]> paramList, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, long paramLong4, long paramLong5)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramArrayOfByte3 = new int[4];
    byte[] tmp25_23 = paramArrayOfByte3;
    tmp25_23[0] = 22;
    byte[] tmp30_25 = tmp25_23;
    tmp30_25[1] = 24;
    byte[] tmp35_30 = tmp30_25;
    tmp35_30[2] = 25;
    byte[] tmp40_35 = tmp35_30;
    tmp40_35[3] = 29;
    tmp40_35;
    paramList = null;
    byte[] arrayOfByte;
    if ((c.s) && (paramArrayOfByte4.length > 16))
    {
      paramList = new byte[paramArrayOfByte4.length - 16];
      arrayOfByte = new byte[16];
      System.arraycopy(paramArrayOfByte4, 0, paramList, 0, paramList.length);
      System.arraycopy(paramArrayOfByte4, paramList.length, arrayOfByte, 0, arrayOfByte.length);
      a = arrayOfByte;
    }
    for (paramArrayOfByte4 = paramArrayOfByte3;; paramArrayOfByte4 = new int[0])
    {
      paramInt = 0;
      if (paramInt < paramArrayOfByte4.length)
      {
        arrayOfByte = null;
        oicq.wlogin_sdk.b.a locala = new oicq.wlogin_sdk.b.a();
        locala.a(paramArrayOfByte4[paramInt]);
        paramArrayOfByte3 = arrayOfByte;
        switch (paramArrayOfByte4[paramInt])
        {
        default: 
          paramArrayOfByte3 = arrayOfByte;
        }
        for (;;)
        {
          if (paramArrayOfByte3 != null)
          {
            locala.b(paramArrayOfByte3, paramArrayOfByte3.length);
            locala.d();
            ((List)tmp35_30).add(locala.a());
          }
          paramInt += 1;
          break;
          paramArrayOfByte3 = getAppInfo(paramLong2, paramLong3);
          continue;
          paramArrayOfByte3 = paramList;
          continue;
          paramArrayOfByte3 = paramArrayOfByte5;
          continue;
          paramArrayOfByte3 = new byte[10];
          util.int8_to_buf(paramArrayOfByte3, 0, 0);
          util.int64_to_buf32(paramArrayOfByte3, 1, paramLong4);
          util.int64_to_buf32(paramArrayOfByte3, 5, paramLong5);
          util.int8_to_buf(paramArrayOfByte3, 9, 0);
        }
      }
      int j = ((List)tmp35_30).size();
      paramInt = paramArrayOfByte1.length + 16 + 2 + paramArrayOfByte2.length + 1 + 2;
      int i = 0;
      if (i < j)
      {
        if (((List)tmp35_30).get(i) == null) {
          break label582;
        }
        paramInt = ((byte[])((List)tmp35_30).get(i)).length + paramInt;
      }
      label579:
      label582:
      for (;;)
      {
        i += 1;
        break;
        paramArrayOfByte3 = new byte[paramInt];
        util.int64_to_buf32(paramArrayOfByte3, 2, paramLong2);
        util.int64_to_buf(paramArrayOfByte3, 6, paramLong1);
        util.int16_to_buf(paramArrayOfByte3, 14, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 16, paramArrayOfByte1.length);
        paramInt = paramArrayOfByte1.length + 16;
        util.int16_to_buf(paramArrayOfByte3, paramInt, paramArrayOfByte2.length);
        paramInt += 2;
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt, paramArrayOfByte2.length);
        paramInt += paramArrayOfByte2.length;
        util.int8_to_buf(paramArrayOfByte3, paramInt, 8);
        paramInt += 1;
        util.int16_to_buf(paramArrayOfByte3, paramInt, j);
        paramInt += 2;
        i = 0;
        if (i < j)
        {
          paramArrayOfByte1 = (byte[])((List)tmp35_30).get(i);
          if (paramArrayOfByte1 == null) {
            break label579;
          }
          System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt, paramArrayOfByte1.length);
          paramInt = paramArrayOfByte1.length + paramInt;
        }
        for (;;)
        {
          i += 1;
          break;
          return get_request(paramLong1, true, paramArrayOfByte3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.a
 * JD-Core Version:    0.7.0.1
 */