package com.tencent.token;

import com.tencent.token.global.RqdApplication;

public class sj
{
  private static sj d;
  private final String A = "conch_update_cloud_task_seqno";
  private final String B = "conch_update_cloud_cmd_id";
  private final String C = "conch_update_cloud_conchseqno";
  private final String D = "conch_update_cloud_task_for_active";
  private final String E = "meri_silent_update_switch_user";
  private final String F = "meri_silent_update_switch_cloud";
  private final String G = "meri_silent_update";
  private final String H = "meri_silent_update_url";
  private final String I = "meri_silent_update_msg_title";
  private final String J = "meri_silent_update_msg";
  private final String K = "meri_silent_update_msg_type";
  private final String L = "meri_silent_update_msg_ask_type";
  private final String M = "meri_silent_update_show_insatll_dlg";
  private final String N = "meri_silent_update_next_notify_time";
  private final String O = "meri_silent_update_show_insatll_notice";
  private final String P = "is_need_report_go_browser";
  private final String Q = "auto_install_under_root";
  private final String R = "has_click_update_tip_in_main_page";
  private final String S = "silent_download_time_control";
  private final String T = "qqpim_download_position_show";
  private final String U = "kiawl";
  public sh a = new sf(RqdApplication.n(), "updateConfig");
  final String b = "huagp_new";
  public final String c = "u_a_p_i";
  private final String e = "meri_lastest_version_p";
  private final String f = "meri_lastest_version_c";
  private final String g = "meri_lastest_version_h";
  private final String h = "meri_lastest_build";
  private final String i = "meri_lastest_version_code";
  private final String j = "meri_lastest_featrue";
  private final String k = "meri_lastest_size";
  private final String l = "meri_lastest_url";
  private final String m = "meri_patch_url";
  private final String n = "meri_need_show_update_dialog";
  private final String o = "meri_update_start_time";
  private final String p = "meri_update_end_time";
  private final String q = "meri_update_url_type";
  private final String r = "meri_update_market";
  private final String s = "meri_update_msg_type";
  private final String t = "meri_update_msg_title";
  private final String u = "meri_update_process";
  private final String v = "meri_update_need_show";
  private final String w = "meri_update_remind_time";
  private final String x = "meri_update_cycle_time";
  private final String y = "meri_update_show_dialog_count";
  private final String z = "conch_update_cloud_task_id";
  
  public static sj a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new sj();
        }
      }
      finally {}
    }
    return d;
  }
  
  public final void a(int paramInt)
  {
    this.a.b("meri_update_url_type", paramInt);
  }
  
  public final void a(long paramLong)
  {
    this.a.b("meri_update_end_time", paramLong);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.a.a();
    this.a.b("conch_update_cloud_task_id", paramLong1);
    this.a.b("conch_update_cloud_task_seqno", paramLong2);
    this.a.b("conch_update_cloud_cmd_id", paramInt1);
    this.a.b("conch_update_cloud_conchseqno", paramInt2);
    this.a.b();
  }
  
  public final void a(String paramString)
  {
    this.a.b("meri_update_market", paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.b("huagp_new", paramBoolean);
  }
  
  public final void b(int paramInt)
  {
    this.a.b("meri_lastest_version_p", paramInt);
  }
  
  public final void b(long paramLong)
  {
    this.a.b("meri_update_cycle_time", paramLong);
  }
  
  public final void b(String paramString)
  {
    this.a.b("meri_lastest_featrue", paramString);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a.b("meri_silent_update", paramBoolean);
  }
  
  public final boolean b()
  {
    return this.a.a("huagp_new", false);
  }
  
  public final long c()
  {
    return this.a.a("meri_update_end_time", 0L);
  }
  
  public final void c(int paramInt)
  {
    this.a.b("meri_lastest_version_c", paramInt);
  }
  
  public final void c(long paramLong)
  {
    try
    {
      throw new Exception();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.b("meri_update_remind_time", paramLong);
    }
  }
  
  public final void c(String paramString)
  {
    this.a.b("meri_lastest_url", paramString);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.a.b("meri_update_need_show", paramBoolean);
  }
  
  public final int d()
  {
    return this.a.a("meri_lastest_version_p", 0);
  }
  
  public final void d(int paramInt)
  {
    this.a.b("meri_lastest_version_h", paramInt);
  }
  
  public final void d(String paramString)
  {
    this.a.b("meri_update_msg_title", paramString);
  }
  
  public final int e()
  {
    return this.a.a("meri_lastest_version_c", 0);
  }
  
  public final void e(int paramInt)
  {
    this.a.b("meri_lastest_build", paramInt);
  }
  
  public final void e(String paramString)
  {
    this.a.b("meri_silent_update_url", paramString);
  }
  
  public final int f()
  {
    return this.a.a("meri_lastest_version_h", 0);
  }
  
  public final void f(int paramInt)
  {
    this.a.b("meri_lastest_version_code", paramInt);
  }
  
  public final void f(String paramString)
  {
    this.a.b("meri_silent_update_msg_title", paramString);
  }
  
  public final int g()
  {
    return this.a.a("meri_lastest_build", 0);
  }
  
  public final void g(int paramInt)
  {
    this.a.b("meri_lastest_size", paramInt);
  }
  
  public final void g(String paramString)
  {
    this.a.b("meri_silent_update_msg", paramString);
  }
  
  public final int h()
  {
    return this.a.a("meri_lastest_size", -1);
  }
  
  public final void h(int paramInt)
  {
    this.a.b("meri_update_msg_type", paramInt);
  }
  
  public final long i()
  {
    return this.a.a("conch_update_cloud_task_id", 0L);
  }
  
  public final void i(int paramInt)
  {
    this.a.b("meri_silent_update_msg_type", paramInt);
  }
  
  public final String j()
  {
    return this.a.a("meri_update_msg_title", "");
  }
  
  public final void j(int paramInt)
  {
    this.a.b("meri_silent_update_msg_ask_type", paramInt);
  }
  
  public final void k()
  {
    this.a.b("meri_silent_update_show_insatll_dlg", false);
  }
  
  public final void k(int paramInt)
  {
    this.a.b("meri_update_process", paramInt);
  }
  
  public final boolean l()
  {
    return this.a.a("meri_silent_update_show_insatll_dlg", false);
  }
  
  public final void m()
  {
    this.a.b("meri_silent_update_show_insatll_notice", false);
  }
  
  public final long n()
  {
    return this.a.a("meri_update_cycle_time", 604800000L);
  }
  
  public final long o()
  {
    return this.a.a("meri_update_remind_time", 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sj
 * JD-Core Version:    0.7.0.1
 */