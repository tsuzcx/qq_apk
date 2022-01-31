package com.tencent.av.report;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class AVReport
{
  static AVReport a;
  public static final String a = "AVReport";
  static final String b = "actAVQualityReportSender";
  static final String c = "actAVQualityReportReceiver";
  static final String d = "param_detail";
  static final String e = "param_peeruin";
  static final String f = "param_sessionid";
  static final String g = "param_bussinesstype";
  public long A;
  public long B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O;
  public long P;
  public long Q;
  public long R;
  public long S;
  public long a;
  public AVReport.ReceiverNodeStage a;
  public AVReport.SenderNodeStage a;
  public boolean a;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public String h;
  public boolean h;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public long k;
  public boolean k;
  public long l;
  public boolean l;
  public long m;
  public boolean m;
  public long n;
  public boolean n;
  public long o;
  public boolean o;
  public long p;
  public boolean p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  static
  {
    jdField_a_of_type_ComTencentAvReportAVReport = null;
  }
  
  private AVReport()
  {
    this.jdField_h_of_type_JavaLangString = "";
  }
  
  public static AVReport a()
  {
    if (jdField_a_of_type_ComTencentAvReportAVReport == null) {
      jdField_a_of_type_ComTencentAvReportAVReport = new AVReport();
    }
    return jdField_a_of_type_ComTencentAvReportAVReport;
  }
  
  private String a()
  {
    if (this.jdField_o_of_type_Boolean) {}
    for (String str = "" + "|0";; str = "" + "|1") {
      return str + "|";
    }
  }
  
  private String a(int paramInt, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    long l1;
    if (paramLong1 > paramLong2) {
      l1 = paramLong1 - paramLong2;
    }
    while (paramBoolean1) {
      if (paramBoolean2)
      {
        if ((paramLong2 > 0L) && (paramLong1 > paramLong2))
        {
          return "" + "|STEP" + paramInt + "_1_0_" + l1;
          l1 = paramLong2 - paramLong1;
        }
        else
        {
          return "" + "|STEP" + paramInt + "_2_-1_0";
        }
      }
      else {
        return "" + "|STEP" + paramInt + "_1_0_" + l1;
      }
    }
    return "" + "|STEP" + paramInt + "_2_-1_0";
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong2 > 0L) && (paramLong1 > paramLong2);
  }
  
  public void a()
  {
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_p_of_type_Long = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = 0L;
    this.E = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.F = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.G = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.H = 0L;
    this.jdField_f_of_type_Boolean = false;
    this.I = 0L;
    this.jdField_g_of_type_Boolean = false;
    this.J = 0L;
    this.jdField_h_of_type_Boolean = false;
    this.K = 0L;
    this.jdField_i_of_type_Boolean = false;
    this.L = 0L;
    this.jdField_j_of_type_Boolean = false;
    this.M = 0L;
    this.jdField_k_of_type_Boolean = false;
    this.N = 0L;
    this.jdField_l_of_type_Boolean = false;
    this.O = 0L;
    this.jdField_m_of_type_Boolean = false;
    this.P = 0L;
    this.jdField_n_of_type_Boolean = false;
    this.Q = 0L;
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
    if (paramIntent != null)
    {
      this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isSender", false);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_i_of_type_Long = 0L;
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("senderStartTime", 0L);
      }
    }
    else
    {
      return;
    }
    this.w = SystemClock.elapsedRealtime();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long == -1L))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_peeruin", String.valueOf(this.S));
    localHashMap.put("param_sessionid", String.valueOf(this.R));
    localHashMap.put("param_bussinesstype", a());
    String str;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_h_of_type_Long > 0L) && (this.jdField_i_of_type_Long > this.jdField_h_of_type_Long))
      {
        str = "" + a(1, true, this.jdField_i_of_type_Long, this.jdField_h_of_type_Long, true);
        bool = true;
        if (!bool) {
          break label884;
        }
        str = str + a(2, true, this.jdField_j_of_type_Long, this.jdField_h_of_type_Long, false);
        label176:
        if (!bool) {
          break label908;
        }
        str = str + a(3, true, this.jdField_e_of_type_Long, this.jdField_b_of_type_Long, true);
        bool = a(this.jdField_e_of_type_Long, this.jdField_b_of_type_Long);
        label226:
        if (!bool) {
          break label932;
        }
        str = str + a(4, true, this.jdField_m_of_type_Long, this.jdField_l_of_type_Long, true);
        bool = a(this.jdField_m_of_type_Long, this.jdField_l_of_type_Long);
        label276:
        if (!this.jdField_g_of_type_Boolean) {
          break label980;
        }
        if ((this.jdField_f_of_type_Long <= 0L) || (this.J <= this.jdField_f_of_type_Long)) {
          break label956;
        }
        str = str + "|STEP5_2_1_" + (this.J - this.jdField_f_of_type_Long);
        label337:
        bool = false;
        label339:
        if (!bool) {
          break label1147;
        }
        str = str + a(6, true, this.jdField_k_of_type_Long, this.jdField_n_of_type_Long, true);
        bool = a(this.jdField_k_of_type_Long, this.jdField_n_of_type_Long);
        label390:
        if (!this.jdField_m_of_type_Boolean) {
          break label1195;
        }
        if ((this.jdField_n_of_type_Long <= 0L) || (this.P <= this.jdField_n_of_type_Long)) {
          break label1171;
        }
        str = str + "|STEP7_1_1_" + (this.P - this.jdField_n_of_type_Long);
        label451:
        bool = false;
        label453:
        if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long)) {
          break label1342;
        }
        str = str + a(8, true, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, true);
        bool = true;
        label510:
        if (!bool) {
          break label1366;
        }
        str = str + a(9, true, this.jdField_c_of_type_Long, this.jdField_b_of_type_Long, true);
        bool = a(this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
        label561:
        if (this.jdField_b_of_type_Long > this.jdField_c_of_type_Long) {
          this.jdField_p_of_type_Boolean = false;
        }
        if ((this.jdField_c_of_type_Long <= 0L) || (this.jdField_d_of_type_Long <= 0L)) {
          this.jdField_p_of_type_Boolean = false;
        }
        if (!bool) {
          break label1390;
        }
        str = str + a(10, true, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long, true);
        bool = a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
        label652:
        if (!bool) {
          break label1414;
        }
        str = str + a(11, true, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, true);
        bool = a(this.jdField_e_of_type_Long, this.jdField_d_of_type_Long);
        label703:
        if (!bool) {
          break label1438;
        }
        str = str + a(12, true, this.jdField_f_of_type_Long, this.jdField_e_of_type_Long, true);
        bool = a(this.jdField_f_of_type_Long, this.jdField_e_of_type_Long);
        label754:
        if (!bool) {
          break label1462;
        }
        str = str + a(13, true, this.jdField_g_of_type_Long, this.jdField_f_of_type_Long, true);
        a(this.jdField_g_of_type_Long, this.jdField_f_of_type_Long);
      }
      for (;;)
      {
        localHashMap.put("param_detail", str + "|");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_h_of_type_JavaLangString, "actAVQualityReportSender", this.jdField_p_of_type_Boolean, 0L, 0L, localHashMap, "", true);
        return;
        str = "" + "|STEP1_2_-1_0";
        bool = false;
        break;
        label884:
        str = str + "|STEP2_0_0_0";
        break label176;
        label908:
        str = str + "|STEP3_0_0_0";
        break label226;
        label932:
        str = str + "|STEP4_0_0_0";
        break label276;
        label956:
        str = str + "|STEP5_2_1_0";
        break label337;
        label980:
        if (this.jdField_h_of_type_Boolean)
        {
          if ((this.jdField_f_of_type_Long > 0L) && (this.K > this.jdField_f_of_type_Long)) {}
          for (str = str + "|STEP5_2_3_" + (this.K - this.jdField_f_of_type_Long);; str = str + "|STEP5_2_3_0")
          {
            bool = false;
            break;
          }
        }
        if (bool)
        {
          str = str + a(5, true, this.jdField_n_of_type_Long, this.jdField_f_of_type_Long, true);
          bool = a(this.jdField_n_of_type_Long, this.jdField_f_of_type_Long);
          break label339;
        }
        str = str + "|STEP5_0_0_0";
        break label339;
        label1147:
        str = str + "|STEP6_0_0_0";
        break label390;
        label1171:
        str = str + "|STEP7_2_-1_0";
        break label451;
        label1195:
        if (this.jdField_n_of_type_Boolean)
        {
          if ((this.jdField_n_of_type_Long > 0L) && (this.Q > this.jdField_n_of_type_Long)) {}
          for (str = str + "|STEP7_1_2_" + (this.Q - this.jdField_n_of_type_Long);; str = str + "|STEP7_2_-1_0")
          {
            bool = false;
            break;
          }
        }
        if (this.jdField_k_of_type_Long > 0L)
        {
          str = str + "|STEP7_2_-1_0";
          break label453;
        }
        str = str + "|STEP7_0_0_0";
        break label453;
        label1342:
        str = str + "|STEP8_2_-1_0";
        break label510;
        label1366:
        str = str + "|STEP9_0_0_0";
        break label561;
        label1390:
        str = str + "|STEP10_0_0_0";
        break label652;
        label1414:
        str = str + "|STEP11_0_0_0";
        break label703;
        label1438:
        str = str + "|STEP12_0_0_0";
        break label754;
        label1462:
        str = str + "|STEP13_0_0_0";
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      str = "" + "|STEP1_2_1_0";
      if ((this.A <= 0L) || (this.B <= this.A)) {
        break label2012;
      }
      str = str + a(2, true, this.B, this.A, true);
      bool = true;
      label1571:
      if ((this.u <= 0L) || (this.v <= this.u)) {
        break label2062;
      }
      if ((this.q <= 0L) || (this.v <= this.q)) {
        break label2038;
      }
      str = str + a(3, true, this.v, this.q, true);
      label1646:
      if (!this.jdField_j_of_type_Boolean) {
        break label2143;
      }
      str = str + "|STEP4_2_1_0";
      bool = false;
      label1676:
      if (!bool) {
        break label2352;
      }
      str = str + a(5, true, this.z, this.C, true);
      bool = a(this.z, this.C);
      label1726:
      if (!this.jdField_m_of_type_Boolean) {
        break label2400;
      }
      if ((this.C <= 0L) || (this.P <= this.C)) {
        break label2376;
      }
      str = str + "|STEP6_1_1_" + (this.P - this.C);
      label1787:
      if ((this.q <= 0L) || (this.r <= this.q)) {
        break label2545;
      }
      str = str + a(7, true, this.r, this.q, true);
      bool = true;
      label1844:
      if (!bool) {
        break label2606;
      }
      if ((this.u <= 0L) || (this.v <= this.u)) {
        break label2569;
      }
      str = str + a(8, true, this.v, this.r, true);
    }
    for (;;)
    {
      localHashMap.put("param_detail", str + "|");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_h_of_type_JavaLangString, "actAVQualityReportReceiver", this.jdField_p_of_type_Boolean, 0L, 0L, localHashMap, "", true);
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        str = "" + "|STEP1_2_2_0";
        break;
      }
      str = "" + "|STEP1_1_0_0";
      break;
      label2012:
      str = str + "|STEP2_2_-1_0";
      bool = false;
      break label1571;
      label2038:
      str = str + "|STEP3_2_-1_0";
      break label1646;
      label2062:
      if ((this.q > 0L) && (this.t > this.q))
      {
        str = str + a(3, true, this.t, this.q, true);
        break label1646;
      }
      str = str + "|STEP3_2_-1_0";
      break label1646;
      label2143:
      if (this.jdField_k_of_type_Boolean)
      {
        str = str + "|STEP4_2_2_0";
        bool = false;
        break label1676;
      }
      if (this.jdField_i_of_type_Boolean)
      {
        str = str + "|STEP4_2_4_0";
        bool = false;
        break label1676;
      }
      if (this.jdField_e_of_type_Boolean)
      {
        str = str + "|STEP4_2_5_0";
        bool = false;
        break label1676;
      }
      if (this.jdField_f_of_type_Boolean)
      {
        str = str + "|STEP4_2_6_0";
        bool = false;
        break label1676;
      }
      if (bool)
      {
        str = str + a(4, true, this.C, this.F, true);
        bool = a(this.C, this.F);
        break label1676;
      }
      str = str + "|STEP4_0_0_0";
      break label1676;
      label2352:
      str = str + "|STEP5_0_0_0";
      break label1726;
      label2376:
      str = str + "|STEP6_2_-1_0";
      break label1787;
      label2400:
      if (this.jdField_n_of_type_Boolean)
      {
        if ((this.C > 0L) && (this.Q > this.C))
        {
          str = str + "|STEP6_1_2_" + (this.Q - this.C);
          break label1787;
        }
        str = str + "|STEP6_2_-1_0";
        break label1787;
      }
      if (this.z > 0L)
      {
        str = str + "|STEP6_2_-1_0";
        break label1787;
      }
      str = str + "|STEP6_0_0_0";
      break label1787;
      label2545:
      str = str + "|STEP7_2_-1_0";
      break label1844;
      label2569:
      str = str + a(8, true, this.t, this.r, true);
      continue;
      label2606:
      str = str + "|STEP8_0_0_0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.report.AVReport
 * JD-Core Version:    0.7.0.1
 */