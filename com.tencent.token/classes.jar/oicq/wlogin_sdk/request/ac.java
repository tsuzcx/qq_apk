package oicq.wlogin_sdk.request;

import android.os.Build.VERSION;
import java.net.Socket;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class ac
  extends oicq_request
{
  public int K = 0;
  public int L = 5;
  
  public ac(u paramu)
  {
    this.t = 2066;
    this.u = 1;
    this.v = "wtlogin.trans_emp";
    this.x = paramu;
    if (this.x.m != 0) {
      this.x.m = 1;
    }
  }
  
  public int a(long paramLong1, TransReqContext paramTransReqContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    int j;
    byte[] arrayOfByte2;
    byte[] arrayOfByte1;
    label100:
    boolean bool;
    label178:
    try
    {
      i = u.x;
      i = 0;
      j = 0;
      arrayOfByte2 = paramTransReqContext._body;
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = u.af;
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[0];
      }
      arrayOfByte2 = new byte[arrayOfByte1.length + 4];
      util.int64_to_buf32(arrayOfByte2, 0, l1 + l2);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
      if (paramArrayOfByte1 == null) {
        break label297;
      }
      arrayOfByte1 = cryptor.encrypt(arrayOfByte2, 0, arrayOfByte2.length, paramArrayOfByte2);
      if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
        break label340;
      }
      if ((oicq_request.EncryptionMethod.EM_ST != paramTransReqContext.requestEm) || ((paramTransReqContext.wtSessionTicketKey != null) && (paramTransReqContext.wtSessionTicketKey.length != 0) && (paramTransReqContext.wtSessionTicket != null) && (paramTransReqContext.wtSessionTicket.length != 0))) {
        break label304;
      }
      paramTransReqContext.requestEm = oicq_request.EncryptionMethod.EM_ECDH;
      u.at.attr_api(2413503);
      util.LOGI("using wt st encrypt body but no st key", String.valueOf(paramLong1));
    }
    finally {}
    a(paramLong1, a(arrayOfByte1, bool, paramArrayOfByte1, paramLong2, paramLong3, paramTransReqContext), paramTransReqContext.requestEm);
    int k = a(String.valueOf(paramLong1), false, paramWUserSigInfo);
    int i = k;
    if (k == 0)
    {
      k = a(paramTransReqContext);
      if ((k != 0) || (paramArrayOfByte1 == null)) {
        break label321;
      }
      arrayOfByte1 = paramTransReqContext.get_body();
      paramTransReqContext.set_body(cryptor.decrypt(arrayOfByte1, 0, arrayOfByte1.length, paramArrayOfByte2));
    }
    for (;;)
    {
      label265:
      util.LOGI("request_transport rsp: ret=".concat(String.valueOf(i)));
      return i;
      label297:
      label304:
      label321:
      label340:
      do
      {
        j += 1;
        break;
        arrayOfByte1 = arrayOfByte2;
        break label100;
        if (paramArrayOfByte1 != null)
        {
          bool = true;
          break label178;
        }
        bool = false;
        break label178;
        i = k;
        if (k != 180) {
          break label265;
        }
        i = k;
      } while (j <= 0);
    }
  }
  
  public int a(long paramLong1, TransReqContext paramTransReqContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    try
    {
      int i = u.x;
      long l1 = paramTransReqContext._body.length;
      int j = this.G;
      this.G = (j + 1);
      long l2 = j;
      byte[] arrayOfByte1 = String.valueOf(paramLong1).getBytes();
      byte[] arrayOfByte2 = new String("wtlogin_conn_trans").getBytes();
      byte[] arrayOfByte3 = new byte[8];
      byte[] arrayOfByte4 = u.B;
      try
      {
        arrayOfByte1 = a(l1, l2, arrayOfByte1, paramLong2, paramLong2, paramArrayOfByte3, arrayOfByte2, arrayOfByte3, 0, 0L, arrayOfByte4);
        arrayOfByte2 = paramTransReqContext._body;
        l1 = System.currentTimeMillis() / 1000L + u.af;
        if (arrayOfByte2 == null)
        {
          paramArrayOfByte3 = new byte[0];
        }
        else if (paramArrayOfByte1 == null)
        {
          paramArrayOfByte3 = new byte[arrayOfByte1.length + 4 + arrayOfByte2.length];
          util.int64_to_buf32(paramArrayOfByte3, 0, l1);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, 4, arrayOfByte1.length);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, arrayOfByte1.length + 4, arrayOfByte2.length);
        }
        else
        {
          paramArrayOfByte3 = new byte[arrayOfByte1.length + 4 + arrayOfByte2.length];
          util.int64_to_buf32(paramArrayOfByte3, 0, l1);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, 4, arrayOfByte1.length);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, arrayOfByte1.length + 4, arrayOfByte2.length);
          paramArrayOfByte3 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
        }
        if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
        {
          paramArrayOfByte3 = a(paramArrayOfByte3, paramArrayOfByte1, paramLong2, paramLong3, 1);
          try
          {
            a(this.i, this.t, this.j, paramLong1, this.m, this.n, i, this.p, paramArrayOfByte3);
            j = a(String.valueOf(paramLong1), true, paramWUserSigInfo);
            i = j;
            if (j != 0) {
              break label386;
            }
            j = a(paramTransReqContext);
            i = j;
            if (j != 0) {
              break label386;
            }
            i = j;
            if (paramArrayOfByte1 == null) {
              break label386;
            }
            paramArrayOfByte1 = paramTransReqContext.get_body();
            paramTransReqContext.set_body(cryptor.decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2));
            i = j;
          }
          finally {}
        }
        else
        {
          i = 0;
        }
        label386:
        return i;
      }
      finally {}
    }
    finally {}
    throw paramTransReqContext;
  }
  
  public int a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    int i;
    long l1;
    long l2;
    label112:
    try
    {
      i = u.x;
      l1 = System.currentTimeMillis() / 1000L;
      l2 = u.af;
      u.at.commit(Build.VERSION.RELEASE, new String(u.H), "", util.buf_to_string(util.get_ksid(u.u)), new String(u.F), new String(u.R), new String(u.J), new String(u.I), util.get_release_time(), "6.0.0.2484");
    }
    finally {}
    try
    {
      paramArrayOfByte1 = u.at.toJasonObj().toString().getBytes();
    }
    catch (Throwable paramArrayOfByte1)
    {
      break label112;
    }
    paramArrayOfByte1 = new byte[0];
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
    {
      paramArrayOfByte1 = util.compress(paramArrayOfByte1);
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
      {
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 8];
        util.int64_to_buf32(arrayOfByte, 0, l1 + l2);
        util.int8_to_buf(arrayOfByte, 4, 0);
        util.int8_to_buf(arrayOfByte, 5, 1);
        util.int16_to_buf(arrayOfByte, 6, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 8, paramArrayOfByte1.length);
        paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte3);
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
        {
          report_t.delete_file(u.u);
          paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramLong2, 85L, 0);
          a(this.i, this.t, this.j, paramLong1, this.m, this.n, i, this.p, paramArrayOfByte1);
          int j = a(String.valueOf(paramLong1), true, paramWUserSigInfo);
          i = j;
          if (j == 0) {
            i = b();
          }
          if (i != 0) {
            report_t.write_tofile(u.at, u.u);
          } else {
            u.at.clear_t2();
          }
          return i;
        }
        return 0;
      }
      return 0;
    }
    return 0;
  }
  
  public int a(TransReqContext paramTransReqContext)
  {
    int i = this.c;
    if (i <= this.f + 2) {
      return -1009;
    }
    this.g = (i - this.f - 2);
    int j;
    if (paramTransReqContext.requestEm == oicq_request.EncryptionMethod.EM_ECDH)
    {
      if (this.x.m == 0)
      {
        j = a(this.h, this.f + 1, this.g, this.x.p);
        i = j;
        if (j < 0)
        {
          util.LOGI("use ecdh decrypt_body failed");
          j = a(this.h, this.f + 1, this.g, this.x.c);
          i = j;
          if (j < 0)
          {
            util.LOGI("use kc decrypt_body failed");
            i = j;
          }
        }
      }
      else
      {
        j = a(this.h, this.f + 1, this.g, this.x.c);
        i = j;
        if (j < 0)
        {
          util.LOGI("use kc decrypt_body failed");
          i = j;
        }
      }
    }
    else if (paramTransReqContext.requestEm == oicq_request.EncryptionMethod.EM_ST)
    {
      j = a(this.h, this.f + 1, this.g, paramTransReqContext.wtSessionTicketKey);
      i = j;
      if (j < 0)
      {
        u.at.attr_api(2494911);
        util.LOGI("use session key decrypt_body failed", "");
        i = -1025;
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("unknown encryption method ");
      localStringBuilder.append(paramTransReqContext.requestEm);
      util.LOGI(localStringBuilder.toString(), "");
      i = -1024;
    }
    if (i < 0) {
      return i;
    }
    return a(this.h, this.f + 1, this.g, paramTransReqContext);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransReqContext paramTransReqContext)
  {
    if (paramInt2 < this.L) {
      return -1009;
    }
    int i = c(paramArrayOfByte, paramInt1);
    a(null);
    util.LOGD(getClass().getName(), "type=".concat(String.valueOf(i)));
    if (i != 0)
    {
      if (i == 180)
      {
        paramInt1 += this.L + 2;
        paramTransReqContext = new tlv_t172();
        paramInt2 = paramTransReqContext.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          return paramInt1;
        }
        this.x.m = 2;
        this.x.s = paramTransReqContext.get_data();
        util.LOGI("request_transport get rollback sig");
      }
    }
    else
    {
      int j = this.L;
      byte[] arrayOfByte = new byte[paramInt2 - j];
      System.arraycopy(paramArrayOfByte, paramInt1 + j, arrayOfByte, 0, arrayOfByte.length);
      paramTransReqContext.set_body(arrayOfByte);
    }
    paramInt1 = i;
    return paramInt1;
  }
  
  public void a(Socket paramSocket)
  {
    this.x.aq = paramSocket;
  }
  
  byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, long paramLong5, byte[] paramArrayOfByte5)
  {
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 16 + 4 + 16 + 4 + paramArrayOfByte2.length + 4 + paramArrayOfByte3.length + 4 + paramArrayOfByte4.length + 1 + 4 + 4 + paramArrayOfByte5.length + 4];
    util.int64_to_buf32(arrayOfByte, 0, arrayOfByte.length + paramLong1);
    util.int64_to_buf32(arrayOfByte, 4, arrayOfByte.length - 4 - 4);
    util.int64_to_buf32(arrayOfByte, 8, paramLong2);
    util.int32_to_buf(arrayOfByte, 12, paramArrayOfByte1.length + 4);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 16, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 16;
    util.int64_to_buf32(arrayOfByte, i, paramLong3);
    i += 4;
    util.int64_to_buf32(arrayOfByte, i, paramLong4);
    i += 16;
    util.int32_to_buf(arrayOfByte, i, paramArrayOfByte2.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
    i += paramArrayOfByte2.length;
    util.int32_to_buf(arrayOfByte, i, paramArrayOfByte3.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i, paramArrayOfByte3.length);
    i += paramArrayOfByte3.length;
    util.int32_to_buf(arrayOfByte, i, paramArrayOfByte4.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, i, paramArrayOfByte4.length);
    i += paramArrayOfByte4.length;
    util.int8_to_buf(arrayOfByte, i, paramInt);
    paramInt = i + 1;
    util.int64_to_buf32(arrayOfByte, paramInt, paramLong5);
    paramInt += 4;
    util.int32_to_buf(arrayOfByte, paramInt, paramArrayOfByte5.length + 4);
    paramInt += 4;
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt, paramArrayOfByte5.length);
    util.int64_to_buf32(arrayOfByte, paramInt + paramArrayOfByte5.length, 4L + paramLong1);
    return arrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    byte[] arrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte1 = new byte[0];
    }
    if (true == paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    byte[] arrayOfByte2 = new byte[0];
    paramArrayOfByte2 = arrayOfByte2;
    if (this.x.s != null)
    {
      paramArrayOfByte2 = arrayOfByte2;
      if (this.x.s.length > 0)
      {
        arrayOfByte2 = new tlv_t172().get_tlv_172(this.x.s);
        paramArrayOfByte2 = new byte[arrayOfByte2.length + 2];
        util.int16_to_buf(paramArrayOfByte2, 0, 1);
        System.arraycopy(arrayOfByte2, 0, paramArrayOfByte2, 2, arrayOfByte2.length);
      }
    }
    this.K = (arrayOfByte1.length + 13 + 1 + paramArrayOfByte2.length);
    arrayOfByte2 = new byte[paramArrayOfByte1.length + this.K];
    util.int8_to_buf(arrayOfByte2, 0, i);
    util.int16_to_buf(arrayOfByte2, 1, paramArrayOfByte1.length);
    util.int64_to_buf32(arrayOfByte2, 3, paramLong1);
    util.int64_to_buf32(arrayOfByte2, 7, paramLong2);
    util.int16_to_buf(arrayOfByte2, 11, arrayOfByte1.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 13, arrayOfByte1.length);
    int i = arrayOfByte1.length + 13;
    util.int8_to_buf(arrayOfByte2, i, paramArrayOfByte2.length);
    i += 1;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, i, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i + paramArrayOfByte2.length, paramArrayOfByte1.length);
    return a(arrayOfByte2, paramTransReqContext.requestEm, paramTransReqContext.wtSessionTicket, paramTransReqContext.wtSessionTicketKey);
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramArrayOfByte2 == null)
    {
      paramArrayOfByte2 = new byte[0];
      if (paramInt == 0) {
        paramInt = 0;
      } else {
        paramInt = 3;
      }
    }
    else if (paramInt == 0)
    {
      paramInt = 1;
    }
    else
    {
      paramInt = 2;
    }
    byte[] arrayOfByte2 = new byte[0];
    byte[] arrayOfByte1 = arrayOfByte2;
    if (this.x.s != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (this.x.s.length > 0)
      {
        arrayOfByte2 = new tlv_t172().get_tlv_172(this.x.s);
        arrayOfByte1 = new byte[arrayOfByte2.length + 2];
        util.int16_to_buf(arrayOfByte1, 0, 1);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 2, arrayOfByte2.length);
      }
    }
    this.K = (paramArrayOfByte2.length + 13 + 1 + arrayOfByte1.length);
    arrayOfByte2 = new byte[paramArrayOfByte1.length + this.K];
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
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, paramInt + arrayOfByte1.length, paramArrayOfByte1.length);
    return a(arrayOfByte2);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < this.L) {
      return -1009;
    }
    paramInt1 = c(paramArrayOfByte, paramInt1);
    a(null);
    util.LOGD(getClass().getName(), "type=".concat(String.valueOf(paramInt1)));
    return paramInt1;
  }
  
  public Socket d()
  {
    if (this.x.aq != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("_transport_sk");
      localStringBuilder.append(this.x.aq.toString());
      util.LOGD("_transport_sk", localStringBuilder.toString());
    }
    else
    {
      util.LOGD("_transport_sk", "_transport_sk null");
    }
    return this.x.aq;
  }
  
  public int e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 8080;
    }
    return 8080;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.ac
 * JD-Core Version:    0.7.0.1
 */