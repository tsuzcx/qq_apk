package oicq.wlogin_sdk.code2d;

import android.content.Context;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import oicq.wlogin_sdk.request.WloginAllSigInfo;
import oicq.wlogin_sdk.request.g;
import oicq.wlogin_sdk.request.o;
import oicq.wlogin_sdk.request.y;
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
      paramContext = g.a(paramContext, "tk_file");
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
      localObject4[0] = o.b(localObject1, localObject2);
      localObject4[1] = paramArrayOfByte;
      ((WloginAllSigInfo)localObject3).put_siginfo(paramLong, (byte[][])localObject4, y.f());
      paramContext.put(Long.valueOf(_status.a), ((WloginAllSigInfo)localObject3).get_clone());
      y.ac.a(paramContext, "tk_file");
    }
    return _status.b;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, List<byte[]> paramList, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, long paramLong4, long paramLong5)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte4.length - 16];
    paramArrayOfByte3 = new byte[16];
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, 0, arrayOfByte.length);
    System.arraycopy(paramArrayOfByte4, arrayOfByte.length, paramArrayOfByte3, 0, paramArrayOfByte3.length);
    a = paramArrayOfByte3;
    paramList = new int[4];
    List<byte[]> tmp72_70 = paramList;
    tmp72_70[0] = 22;
    List<byte[]> tmp77_72 = tmp72_70;
    tmp77_72[1] = 24;
    List<byte[]> tmp82_77 = tmp77_72;
    tmp82_77[2] = 25;
    List<byte[]> tmp87_82 = tmp82_77;
    tmp87_82[3] = 29;
    tmp87_82;
    if (c.s) {}
    for (;;)
    {
      paramInt = 0;
      if (paramInt < paramList.length)
      {
        paramArrayOfByte4 = null;
        oicq.wlogin_sdk.b.a locala = new oicq.wlogin_sdk.b.a();
        locala.a(paramList[paramInt]);
        paramArrayOfByte3 = paramArrayOfByte4;
        switch (paramList[paramInt])
        {
        default: 
          paramArrayOfByte3 = paramArrayOfByte4;
        }
        for (;;)
        {
          if (paramArrayOfByte3 != null)
          {
            locala.b(paramArrayOfByte3, paramArrayOfByte3.length);
            locala.d();
            ((List)tmp82_77).add(locala.a());
          }
          paramInt += 1;
          break;
          paramArrayOfByte3 = getAppInfo(paramLong2, paramLong3);
          continue;
          paramArrayOfByte3 = tmp87_82;
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
      int j = ((List)tmp82_77).size();
      paramInt = paramArrayOfByte1.length + 16 + 2 + paramArrayOfByte2.length + 1 + 2;
      int i = 0;
      if (i < j)
      {
        if (((List)tmp82_77).get(i) == null) {
          break label566;
        }
        paramInt = ((byte[])((List)tmp82_77).get(i)).length + paramInt;
      }
      label563:
      label566:
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
          paramArrayOfByte1 = (byte[])((List)tmp82_77).get(i);
          if (paramArrayOfByte1 == null) {
            break label563;
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
      paramList = new int[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.a
 * JD-Core Version:    0.7.0.1
 */