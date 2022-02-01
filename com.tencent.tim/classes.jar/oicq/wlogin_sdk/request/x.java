package oicq.wlogin_sdk.request;

import android.os.Build.VERSION;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class x
  extends k
{
  public final int b = 1737040709;
  public final int c = 33;
  public final String d = "x'Z8mSi,V(Wu~.v:";
  
  public x(u paramu)
  {
    this.a = paramu;
  }
  
  public int a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      i = b(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2);
    }
    while (paramInt != 1) {
      return i;
    }
    return c(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2);
  }
  
  public byte[] a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
    {
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
      paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 10 + paramArrayOfByte1.length];
      util.int32_to_buf(paramArrayOfByte3, 0, (int)paramLong1);
      util.int32_to_buf(paramArrayOfByte3, 4, (int)paramLong2);
      util.int16_to_buf(paramArrayOfByte3, 8, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 10, paramArrayOfByte2.length);
      i = paramArrayOfByte2.length + 10;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, i, paramArrayOfByte1.length);
      i = paramArrayOfByte1.length;
      return paramArrayOfByte3;
    }
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, "x'Z8mSi,V(Wu~.v:".getBytes());
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 10];
    util.int32_to_buf(paramArrayOfByte2, 0, (int)paramLong1);
    util.int32_to_buf(paramArrayOfByte2, 4, (int)paramLong2);
    util.int16_to_buf(paramArrayOfByte2, 8, 0);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 10, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length;
    return paramArrayOfByte2;
  }
  
  public byte[] a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 33];
    util.int32_to_buf(arrayOfByte, 0, 1737040709);
    util.int32_to_buf(arrayOfByte, 4, 0);
    util.int32_to_buf(arrayOfByte, 8, arrayOfByte.length);
    util.int64_to_buf32(arrayOfByte, 12, paramLong1);
    util.int64_to_buf32(arrayOfByte, 16, paramLong2);
    util.int64_to_buf32(arrayOfByte, 20, paramLong3 / 1000L);
    util.int8_to_buf(arrayOfByte, 24, paramInt);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 33, paramArrayOfByte.length);
    paramInt = paramArrayOfByte.length;
    return arrayOfByte;
  }
  
  public int b(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2)
  {
    long l = System.currentTimeMillis();
    u.at.commit(Build.VERSION.RELEASE, new String(u.H), "", util.buf_to_string(util.get_ksid(u.u)), new String(u.F), new String(u.R), new String(u.J), new String(u.I), util.get_release_time(), "6.0.0.2484");
    try
    {
      paramArrayOfByte1 = u.at.toJasonObj().toString().getBytes();
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
        return 0;
      }
    }
    catch (Throwable paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1 = new byte[0];
      }
      paramArrayOfByte1 = util.compress(paramArrayOfByte1);
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
        return 0;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 4];
      util.int8_to_buf(arrayOfByte, 0, 0);
      util.int8_to_buf(arrayOfByte, 1, 1);
      util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
      paramArrayOfByte1 = a(arrayOfByte, paramLong1, paramLong2, l, 0);
      report_t.delete_file(u.u);
      int i = b(a(a(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2)));
      util.LOGI("request_report_error(0) rsp: ret=" + i);
      if (i != 0)
      {
        report_t.write_tofile(u.at, u.u);
        return i;
      }
      u.at.clear_t2();
      return i;
    }
  }
  
  public int c(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2)
  {
    long l1;
    String str;
    long l2;
    if ((this.a.d != null) && (!u.e.booleanValue()))
    {
      u.e = Boolean.valueOf(true);
      long l3 = System.currentTimeMillis();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      Calendar localCalendar = Calendar.getInstance();
      int j = this.a.d.get_bitmap();
      int k = this.a.d.get_network();
      util.LOGI("bitmap:" + j + " network:" + k + " local network:" + util.get_network_type(u.u));
      int i = 0;
      if (i < 32)
      {
        if ((1 << i & j) == 0) {}
        while ((k != 0) && ((k != 1) || (util.get_network_type(u.u) != 2)))
        {
          i += 1;
          break;
        }
        l1 = l3 - 86400000 * i;
        localCalendar.setTimeInMillis(l1);
        str = localSimpleDateFormat.format(localCalendar.getTime());
        l2 = util.getLogModifyTime(u.u, str);
        if (l2 != 0L) {
          break label339;
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte1 = util.readLog(u.u, str);
      if (paramArrayOfByte1 == null) {}
      for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = a(paramArrayOfByte1, paramLong1, paramLong2, l1, 1))
      {
        if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0)) {
          break label320;
        }
        int m = b(a(a(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2)));
        util.LOGI("request_report_error(1) rsp: ret=" + m + "(" + str + ")");
        break;
      }
      label320:
      break;
      this.a.d = null;
      u.e = Boolean.valueOf(false);
      return 0;
      label339:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.x
 * JD-Core Version:    0.7.0.1
 */