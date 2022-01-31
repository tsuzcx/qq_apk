package oicq.wlogin_sdk.request;

import android.os.Build.VERSION;
import java.net.Socket;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.report.report_t1;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class z
  extends j
{
  public int D = 0;
  public int E = 5;
  
  public z(t paramt)
  {
    this.s = 2066;
    this.t = 1;
    this.u = "wtlogin.trans_emp";
    this.w = paramt;
    if (this.w.m != 0) {
      this.w.m = 1;
    }
  }
  
  public int a(long paramLong1, TransReqContext paramTransReqContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    try
    {
      int m = t.u;
      int k = 0;
      int j = 0;
      Object localObject = paramTransReqContext._body;
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = t.aa;
      if (localObject == null) {
        localObject = new byte[0];
      }
      for (;;)
      {
        byte[] arrayOfByte = new byte[localObject.length + 4];
        util.int64_to_buf32(arrayOfByte, 0, l1 + l2);
        System.arraycopy(localObject, 0, arrayOfByte, 4, localObject.length);
        localObject = arrayOfByte;
        if (paramArrayOfByte1 != null) {
          localObject = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte2);
        }
        int i = j;
        if (localObject != null)
        {
          i = j;
          if (localObject.length > 0)
          {
            localObject = a((byte[])localObject, paramArrayOfByte1, paramLong2, paramLong3, 0);
            a(this.h, this.s, this.i, paramLong1, this.l, this.m, m, this.o, (byte[])localObject);
            j = a(String.valueOf(paramLong1), false, paramWUserSigInfo);
            if (j == 0) {}
          }
        }
        do
        {
          do
          {
            util.LOGI("request_transport rsp: ret=" + j);
            return j;
            i = a(paramTransReqContext);
            if ((i == 0) && (paramArrayOfByte1 != null))
            {
              localObject = paramTransReqContext.get_body();
              paramTransReqContext.set_body(cryptor.decrypt((byte[])localObject, 0, localObject.length, paramArrayOfByte2));
            }
            j = i;
          } while (i != 180);
          j = i;
        } while (k >= 1);
        k += 1;
        j = i;
        break;
      }
    }
    finally {}
  }
  
  public int a(long paramLong1, TransReqContext paramTransReqContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    for (;;)
    {
      long l;
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      try
      {
        i = t.u;
        l = paramTransReqContext._body.length;
        j = this.z;
        this.z = (j + 1);
        arrayOfByte1 = a(l, j, String.valueOf(paramLong1).getBytes(), paramLong2, paramLong2, paramArrayOfByte3, new String("wtlogin_conn_trans").getBytes(), new byte[8], 0, 0L, t.y);
        arrayOfByte2 = paramTransReqContext._body;
        l = System.currentTimeMillis() / 1000L + t.aa;
        if (arrayOfByte2 == null)
        {
          paramArrayOfByte3 = new byte[0];
          if ((paramArrayOfByte3 == null) || (paramArrayOfByte3.length <= 0)) {
            break label365;
          }
          paramArrayOfByte3 = a(paramArrayOfByte3, paramArrayOfByte1, paramLong2, paramLong3, 1);
          a(this.h, this.s, this.i, paramLong1, this.l, this.m, i, this.o, paramArrayOfByte3);
          i = a(String.valueOf(paramLong1), true, paramWUserSigInfo);
          if (i == 0) {
            break label312;
          }
          return i;
        }
        if (paramArrayOfByte1 == null)
        {
          paramArrayOfByte3 = new byte[arrayOfByte1.length + 4 + arrayOfByte2.length];
          util.int64_to_buf32(paramArrayOfByte3, 0, l);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, 4, arrayOfByte1.length);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, arrayOfByte1.length + 4, arrayOfByte2.length);
          continue;
        }
        paramArrayOfByte3 = new byte[arrayOfByte1.length + 4 + arrayOfByte2.length];
      }
      finally {}
      util.int64_to_buf32(paramArrayOfByte3, 0, l);
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, 4, arrayOfByte1.length);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, arrayOfByte1.length + 4, arrayOfByte2.length);
      paramArrayOfByte3 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
      continue;
      label312:
      int j = a(paramTransReqContext);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1 = paramTransReqContext.get_body();
          paramTransReqContext.set_body(cryptor.decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2));
          i = j;
          continue;
          label365:
          i = 0;
        }
      }
    }
  }
  
  public int a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    for (;;)
    {
      try
      {
        i = t.u;
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = t.aa;
        t.ag.commit(Build.VERSION.RELEASE, new String(t.E), "", util.buf_to_string(util.get_ksid(t.r)), new String(t.C), new String(t.O), new String(t.G), new String(t.F), util.get_release_time(), "5.4.0.7");
        try
        {
          paramArrayOfByte1 = t.ag.toJasonObj().toString().getBytes();
          if (paramArrayOfByte1 != null)
          {
            int j = paramArrayOfByte1.length;
            if (j != 0) {}
          }
          else
          {
            i = 0;
            return i;
          }
        }
        catch (Throwable paramArrayOfByte1)
        {
          paramArrayOfByte1 = new byte[0];
          continue;
          paramArrayOfByte1 = util.compress(paramArrayOfByte1);
          if (paramArrayOfByte1 == null) {
            break label344;
          }
        }
        if (paramArrayOfByte1.length == 0) {
          break label344;
        }
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 8];
        util.int64_to_buf32(arrayOfByte, 0, l1 + l2);
        util.int8_to_buf(arrayOfByte, 4, 0);
        util.int8_to_buf(arrayOfByte, 5, 1);
        util.int16_to_buf(arrayOfByte, 6, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 8, paramArrayOfByte1.length);
        paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte3);
        if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
          break label350;
        }
        report_t.delete_file(t.r);
        paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramLong2, 85L, 0);
        a(this.h, this.s, this.i, paramLong1, this.l, this.m, i, this.o, paramArrayOfByte1);
        i = a(String.valueOf(paramLong1), true, paramWUserSigInfo);
        if (i != 0)
        {
          if (i == 0) {
            break label335;
          }
          report_t.write_tofile(t.ag, t.r);
          continue;
        }
        i = b();
      }
      finally {}
      continue;
      label335:
      t.ag.clear_t2();
      continue;
      label344:
      int i = 0;
      continue;
      label350:
      i = 0;
    }
  }
  
  public int a(TransReqContext paramTransReqContext)
  {
    int i = this.b;
    int j;
    if (i <= this.e + 2)
    {
      j = -1009;
      return j;
    }
    this.f = (i - this.e - 2);
    if (this.w.m == 0)
    {
      j = a(this.g, this.e + 1, this.f, this.w.o);
      i = j;
      if (j < 0)
      {
        util.LOGI("use ecdh decrypt_body failed");
        j = a(this.g, this.e + 1, this.f, this.w.c);
        i = j;
        if (j < 0)
        {
          util.LOGI("use kc decrypt_body failed");
          i = j;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i < 0) {
        break;
      }
      return a(this.g, this.e + 1, this.f, paramTransReqContext);
      j = a(this.g, this.e + 1, this.f, this.w.c);
      i = j;
      if (j < 0)
      {
        util.LOGI("use kc decrypt_body failed");
        i = j;
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransReqContext paramTransReqContext)
  {
    if (paramInt2 < this.E) {
      return -1009;
    }
    int i = c(paramArrayOfByte, paramInt1);
    a((ErrMsg)null);
    util.LOGD(getClass().getName(), "type=" + i);
    switch (i)
    {
    default: 
      return i;
    case 0: 
      int j = this.E;
      byte[] arrayOfByte = new byte[paramInt2 - this.E];
      System.arraycopy(paramArrayOfByte, j + paramInt1, arrayOfByte, 0, arrayOfByte.length);
      paramTransReqContext.set_body(arrayOfByte);
      return i;
    }
    paramInt1 = this.E + 2 + paramInt1;
    paramTransReqContext = new bi();
    paramInt2 = paramTransReqContext.b(paramArrayOfByte, paramInt1, this.b - paramInt1 - 1);
    paramInt1 = paramInt2;
    if (paramInt2 > 0)
    {
      this.w.m = 2;
      this.w.p = paramTransReqContext.b();
      util.LOGI("request_transport get rollback sig");
      paramInt1 = i;
    }
    return paramInt1;
  }
  
  public void a(Socket paramSocket)
  {
    this.w.ad = paramSocket;
  }
  
  byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, long paramLong5, byte[] paramArrayOfByte5)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 16 + 4 + 16 + 4 + arrayOfByte.length + 4 + paramArrayOfByte3.length + 4 + paramArrayOfByte4.length + 1 + 4 + 4 + paramArrayOfByte5.length + 4];
    util.int64_to_buf32(paramArrayOfByte2, 0, paramArrayOfByte2.length + paramLong1);
    util.int64_to_buf32(paramArrayOfByte2, 4, paramArrayOfByte2.length - 4 - 4);
    util.int64_to_buf32(paramArrayOfByte2, 8, paramLong2);
    util.int32_to_buf(paramArrayOfByte2, 12, paramArrayOfByte1.length + 4);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 16, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 16;
    util.int64_to_buf32(paramArrayOfByte2, i, paramLong3);
    i += 4;
    util.int64_to_buf32(paramArrayOfByte2, i, paramLong4);
    i += 16;
    util.int32_to_buf(paramArrayOfByte2, i, arrayOfByte.length + 4);
    i += 4;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, i, arrayOfByte.length);
    i += arrayOfByte.length;
    util.int32_to_buf(paramArrayOfByte2, i, paramArrayOfByte3.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, i, paramArrayOfByte3.length);
    i += paramArrayOfByte3.length;
    util.int32_to_buf(paramArrayOfByte2, i, paramArrayOfByte4.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, i, paramArrayOfByte4.length);
    i += paramArrayOfByte4.length;
    util.int8_to_buf(paramArrayOfByte2, i, paramInt);
    paramInt = i + 1;
    util.int64_to_buf32(paramArrayOfByte2, paramInt, paramLong5);
    paramInt += 4;
    util.int32_to_buf(paramArrayOfByte2, paramInt, paramArrayOfByte5.length + 4);
    paramInt += 4;
    System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte2, paramInt, paramArrayOfByte5.length);
    paramInt += paramArrayOfByte5.length;
    util.int64_to_buf32(paramArrayOfByte2, paramInt, 4L + paramLong1);
    return paramArrayOfByte2;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramArrayOfByte2 == null)
    {
      paramArrayOfByte2 = new byte[0];
      if (paramInt == 0) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte2 = new byte[0];
      byte[] arrayOfByte1 = arrayOfByte2;
      if (this.w.p != null)
      {
        arrayOfByte1 = arrayOfByte2;
        if (this.w.p.length > 0)
        {
          arrayOfByte2 = new bi().a(this.w.p);
          arrayOfByte1 = new byte[arrayOfByte2.length + 2];
          util.int16_to_buf(arrayOfByte1, 0, 1);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 2, arrayOfByte2.length);
        }
      }
      this.D = (paramArrayOfByte2.length + 13 + 1 + arrayOfByte1.length);
      arrayOfByte2 = new byte[paramArrayOfByte1.length + this.D];
      util.int8_to_buf(arrayOfByte2, 0, paramInt);
      util.int16_to_buf(arrayOfByte2, 1, paramArrayOfByte1.length);
      util.int64_to_buf32(arrayOfByte2, 3, paramLong1);
      util.int64_to_buf32(arrayOfByte2, 7, paramLong2);
      util.int16_to_buf(arrayOfByte2, 11, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, 13, paramArrayOfByte2.length);
      paramInt = paramArrayOfByte2.length + 13;
      util.int8_to_buf(arrayOfByte2, paramInt, arrayOfByte1.length);
      paramInt += 1;
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramInt, arrayOfByte1.length);
      paramInt += arrayOfByte1.length;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, paramInt, paramArrayOfByte1.length);
      paramInt = paramArrayOfByte1.length;
      return a(arrayOfByte2);
      paramInt = 3;
      continue;
      if (paramInt == 0) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
    }
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    return 8080;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < this.E) {
      return -1009;
    }
    paramInt1 = c(paramArrayOfByte, paramInt1);
    a((ErrMsg)null);
    util.LOGD(getClass().getName(), "type=" + paramInt1);
    return paramInt1;
  }
  
  public Socket d()
  {
    if (this.w.ad != null) {
      util.LOGD("_transport_sk", "_transport_sk" + this.w.ad.toString());
    }
    for (;;)
    {
      return this.w.ad;
      util.LOGD("_transport_sk", "_transport_sk null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.z
 * JD-Core Version:    0.7.0.1
 */