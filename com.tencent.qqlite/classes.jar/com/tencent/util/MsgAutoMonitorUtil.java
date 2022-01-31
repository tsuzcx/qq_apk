package com.tencent.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class MsgAutoMonitorUtil
{
  private static MsgAutoMonitorUtil jdField_a_of_type_ComTencentUtilMsgAutoMonitorUtil = null;
  public static final String a = "AutoMonitor";
  public static final String b = "MSG_InitCostTime";
  public static final String c = "MSG_InitMsgNum";
  public static final String d = "MSG_TableNum";
  public static final String e = "MSG_ProxyInitTime";
  public static final String f = "MSG_DbTableNum";
  public static final String g = "MSG_DbIoTime";
  public static final String h = "MSG_DbIoNum";
  public static final String i = "MSG_DbIoTransaction";
  public static final String j = "MSG_ObserverTime";
  public static final String k = "MSG_ObserverNotifyNum";
  public static final String l = "MSG_DecodeC2CMsgNum";
  public static final String m = "MSG_DecodeC2CMsgTime";
  public static final String n = "MSG_DecodeGrpDisMsgNum";
  public static final String o = "MSG_DecodeGrpDisMsgTime";
  public static final String p = "MSG_AddMsgNum";
  public static final String q = "MSG_AddMsgTime";
  public static final String r = "MSG_MsgFilterNum";
  public static final String s = "MSG_MsgFilterTime";
  public static final String t = "MSG_PROXY_SEQ_DIS_T";
  public static final String u = "MSG_PROXY_SEQ_GRP_T";
  public static final String v = "MSG_NOTIFY_FIN_C2C";
  public static final String w = "MSG_NOTIFY_FIN_GRP";
  public static final String x = "MSG_NOTIFY_FIN_DIS";
  public static final String y = "MSG_PROXY_THREAD_NUM_BEGIN";
  public static final String z = "MSG_PROXY_THREAD_NUM_END";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  private long n = 0L;
  private long o = 0L;
  private long p = 0L;
  private long q = 0L;
  private long r = 0L;
  private long s = 0L;
  private long t = 0L;
  private long u = 0L;
  private long v = 0L;
  
  public static MsgAutoMonitorUtil a()
  {
    if (jdField_a_of_type_ComTencentUtilMsgAutoMonitorUtil == null) {
      jdField_a_of_type_ComTencentUtilMsgAutoMonitorUtil = new MsgAutoMonitorUtil();
    }
    return jdField_a_of_type_ComTencentUtilMsgAutoMonitorUtil;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilMsgAutoMonitorUtil = null;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long += paramLong;
    this.b += 1L;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.i += paramLong1;
    this.j += paramLong2;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AutoMonitor", 2, paramString1 + ", cost=" + paramString2);
      return;
    }
    Log.i("AutoMonitor", paramString1 + ", cost=" + paramString2);
  }
  
  public void b()
  {
    a("MSG_DbIoTime", this.jdField_a_of_type_Long + "");
    this.jdField_a_of_type_Long = 0L;
    a("MSG_DbIoNum", this.b + "");
    this.b = 0L;
    a("MSG_DbIoTransaction", this.c + "");
    this.c = 0L;
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.c += paramLong;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void c(long paramLong)
  {
    this.d += paramLong;
  }
  
  public void d()
  {
    a("MSG_ObserverTime", this.d + "");
    a("MSG_ObserverNotifyNum", this.jdField_a_of_type_Int + "");
    this.d = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void d(long paramLong)
  {
    this.m += paramLong;
  }
  
  public void e()
  {
    this.p = System.currentTimeMillis();
  }
  
  public void e(long paramLong)
  {
    this.n += paramLong;
  }
  
  public void f()
  {
    this.o = (System.currentTimeMillis() - this.p);
  }
  
  public void f(long paramLong)
  {
    this.e += paramLong;
    this.f += 1L;
  }
  
  public void g()
  {
    this.r = System.currentTimeMillis();
  }
  
  public void g(long paramLong)
  {
    this.g += paramLong;
    this.h += 1L;
  }
  
  public void h()
  {
    this.q = (System.currentTimeMillis() - this.r);
  }
  
  public void h(long paramLong)
  {
    this.k += paramLong;
    this.l += 1L;
  }
  
  public void i()
  {
    this.t = System.currentTimeMillis();
  }
  
  public void j()
  {
    this.s = (System.currentTimeMillis() - this.t);
  }
  
  public void k()
  {
    a("MSG_DecodeC2CMsgNum", String.valueOf(this.f));
    a("MSG_DecodeC2CMsgTime", String.valueOf(this.e));
    a("MSG_DecodeGrpDisMsgNum", String.valueOf(this.h));
    a("MSG_DecodeGrpDisMsgTime", String.valueOf(this.g));
    a("MSG_AddMsgNum", String.valueOf(this.j));
    a("MSG_AddMsgTime", String.valueOf(this.i));
    a("MSG_MsgFilterNum", String.valueOf(this.l));
    a("MSG_MsgFilterTime", String.valueOf(this.k));
    a("MSG_PROXY_SEQ_DIS_T", String.valueOf(this.m));
    a("MSG_PROXY_SEQ_GRP_T", String.valueOf(this.n));
    b();
    d();
    a("MSG_NOTIFY_FIN_C2C", String.valueOf(this.o));
    a("MSG_NOTIFY_FIN_GRP", String.valueOf(this.q));
    a("MSG_NOTIFY_FIN_DIS", String.valueOf(this.s));
    a("MSG_PROXY_THREAD_NUM_BEGIN", String.valueOf(this.u));
    a("MSG_PROXY_THREAD_NUM_END", String.valueOf(this.v));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.MsgAutoMonitorUtil
 * JD-Core Version:    0.7.0.1
 */