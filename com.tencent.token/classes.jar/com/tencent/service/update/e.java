package com.tencent.service.update;

import android.util.Log;
import com.tencent.token.global.RqdApplication;

public class e
{
  private static e b;
  private final String A = "conch_update_cloud_cmd_id";
  private final String B = "conch_update_cloud_conchseqno";
  private final String C = "conch_update_cloud_task_for_active";
  private final String D = "meri_silent_update_switch_user";
  private final String E = "meri_silent_update_switch_cloud";
  private final String F = "meri_silent_update";
  private final String G = "meri_silent_update_url";
  private final String H = "meri_silent_update_msg_title";
  private final String I = "meri_silent_update_msg";
  private final String J = "meri_silent_update_msg_type";
  private final String K = "meri_silent_update_msg_ask_type";
  private final String L = "meri_silent_update_show_insatll_dlg";
  private final String M = "meri_silent_update_next_notify_time";
  private final String N = "meri_silent_update_show_insatll_notice";
  private final String O = "is_need_report_go_browser";
  private final String P = "auto_install_under_root";
  private final String Q = "has_click_update_tip_in_main_page";
  private final String R = "silent_download_time_control";
  private final String S = "qqpim_download_position_show";
  final String a = "huagp";
  private c c = new a(RqdApplication.n(), "updateConfig");
  private final String d = "meri_lastest_version_p";
  private final String e = "meri_lastest_version_c";
  private final String f = "meri_lastest_version_h";
  private final String g = "meri_lastest_build";
  private final String h = "meri_lastest_version_code";
  private final String i = "meri_lastest_featrue";
  private final String j = "meri_lastest_size";
  private final String k = "meri_lastest_url";
  private final String l = "meri_patch_url";
  private final String m = "meri_need_show_update_dialog";
  private final String n = "meri_update_start_time";
  private final String o = "meri_update_end_time";
  private final String p = "meri_update_url_type";
  private final String q = "meri_update_market";
  private final String r = "meri_update_msg_type";
  private final String s = "meri_update_msg_title";
  private final String t = "meri_update_process";
  private final String u = "meri_update_need_show";
  private final String v = "meri_update_remind_time";
  private final String w = "meri_update_cycle_time";
  private final String x = "meri_update_show_dialog_count";
  private final String y = "conch_update_cloud_task_id";
  private final String z = "conch_update_cloud_task_seqno";
  
  public static e a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new e();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(int paramInt)
  {
    this.c.b("meri_update_url_type", paramInt);
  }
  
  public void a(long paramLong)
  {
    this.c.b("meri_update_start_time", paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.c.a();
    this.c.b("conch_update_cloud_task_id", paramLong1);
    this.c.b("conch_update_cloud_task_seqno", paramLong2);
    this.c.b("conch_update_cloud_cmd_id", paramInt1);
    this.c.b("conch_update_cloud_conchseqno", paramInt2);
    this.c.b();
  }
  
  public void a(SoftUpdateInfo paramSoftUpdateInfo, long paramLong, int paramInt, String paramString)
  {
    this.c.a();
    h(paramInt);
    e(paramString);
    b(paramLong);
    b(paramSoftUpdateInfo.newVersion.pversion);
    c(paramSoftUpdateInfo.newVersion.cversion);
    d(paramSoftUpdateInfo.newVersion.hotfix);
    e(paramSoftUpdateInfo.newBuildno);
    f(paramSoftUpdateInfo.newVersionCode);
    b(paramSoftUpdateInfo.newFeature);
    c(paramSoftUpdateInfo.url);
    a(paramSoftUpdateInfo.urlType);
    a(paramSoftUpdateInfo.market);
    d(paramSoftUpdateInfo.noticeInterval * 24 * 60 * 60 * 1000);
    g(paramSoftUpdateInfo.newPkgSize << 10);
    if (paramSoftUpdateInfo.silentDownloadInfo != null)
    {
      c(paramSoftUpdateInfo.isSilentDownload);
      f(paramSoftUpdateInfo.silentDownloadInfo.url);
      g(paramSoftUpdateInfo.silentDownloadInfo.title);
      h(paramSoftUpdateInfo.silentDownloadInfo.msg);
      i(paramSoftUpdateInfo.silentDownloadInfo.type);
      j(paramSoftUpdateInfo.silentDownloadInfo.askType);
    }
    this.c.b();
  }
  
  public void a(String paramString)
  {
    this.c.b("meri_update_market", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.b("huagp", paramBoolean);
  }
  
  public void b(int paramInt)
  {
    this.c.b("meri_lastest_version_p", paramInt);
  }
  
  public void b(long paramLong)
  {
    this.c.b("meri_update_end_time", paramLong);
  }
  
  public void b(String paramString)
  {
    this.c.b("meri_lastest_featrue", paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.b("meri_need_show_update_dialog", paramBoolean);
  }
  
  public boolean b()
  {
    return this.c.a("huagp", false);
  }
  
  public void c(int paramInt)
  {
    this.c.b("meri_lastest_version_c", paramInt);
  }
  
  public void c(long paramLong)
  {
    this.c.b("conch_update_cloud_task_for_active", paramLong);
  }
  
  public void c(String paramString)
  {
    this.c.b("meri_lastest_url", paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.c.b("meri_silent_update", paramBoolean);
  }
  
  public boolean c()
  {
    return this.c.c("huagp");
  }
  
  public long d()
  {
    return this.c.a("meri_update_end_time", 0L);
  }
  
  public void d(int paramInt)
  {
    this.c.b("meri_lastest_version_h", paramInt);
  }
  
  public void d(long paramLong)
  {
    this.c.b("meri_update_cycle_time", paramLong);
  }
  
  public void d(String paramString)
  {
    this.c.b("meri_patch_url", paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.c.b("meri_silent_update_show_insatll_dlg", paramBoolean);
  }
  
  public int e()
  {
    return this.c.a("meri_update_url_type", 0);
  }
  
  public void e(int paramInt)
  {
    this.c.b("meri_lastest_build", paramInt);
  }
  
  public void e(long paramLong)
  {
    Log.i("updatemanager", "setMeriUpdateRemindTime");
    try
    {
      throw new Exception();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.c.b("meri_update_remind_time", paramLong);
    }
  }
  
  public void e(String paramString)
  {
    this.c.b("meri_update_msg_title", paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    this.c.b("meri_silent_update_show_insatll_notice", paramBoolean);
  }
  
  public int f()
  {
    return this.c.a("meri_lastest_version_p", 0);
  }
  
  public void f(int paramInt)
  {
    this.c.b("meri_lastest_version_code", paramInt);
  }
  
  public void f(String paramString)
  {
    this.c.b("meri_silent_update_url", paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    this.c.b("meri_update_need_show", paramBoolean);
  }
  
  public int g()
  {
    return this.c.a("meri_lastest_version_c", 0);
  }
  
  public void g(int paramInt)
  {
    this.c.b("meri_lastest_size", paramInt);
  }
  
  public void g(String paramString)
  {
    this.c.b("meri_silent_update_msg_title", paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    this.c.b("has_click_update_tip_in_main_page", paramBoolean);
  }
  
  public int h()
  {
    return this.c.a("meri_lastest_version_h", 0);
  }
  
  public void h(int paramInt)
  {
    this.c.b("meri_update_msg_type", paramInt);
  }
  
  public void h(String paramString)
  {
    this.c.b("meri_silent_update_msg", paramString);
  }
  
  public int i()
  {
    return this.c.a("meri_lastest_build", 0);
  }
  
  public void i(int paramInt)
  {
    this.c.b("meri_silent_update_msg_type", paramInt);
  }
  
  public String j()
  {
    return this.c.a("meri_lastest_featrue", "");
  }
  
  public void j(int paramInt)
  {
    this.c.b("meri_silent_update_msg_ask_type", paramInt);
  }
  
  public int k()
  {
    return this.c.a("meri_lastest_size", -1);
  }
  
  public void k(int paramInt)
  {
    this.c.b("meri_update_process", paramInt);
  }
  
  public String l()
  {
    return this.c.a("meri_lastest_url", "");
  }
  
  public void l(int paramInt)
  {
    this.c.b("meri_update_show_dialog_count", paramInt);
  }
  
  public long m()
  {
    return this.c.a("conch_update_cloud_task_id", 0L);
  }
  
  public void n()
  {
    this.c.a();
    h(0);
    e("");
    a(0L);
    b(0L);
    b(0);
    c(0);
    d(0);
    e(0);
    f(0);
    b("");
    c("");
    a(0);
    a("");
    d("");
    g(0);
    d(0L);
    e(0L);
    l(0);
    c(false);
    f("");
    g("");
    h("");
    i(0);
    j(0);
    g(false);
    this.c.b();
  }
  
  public boolean o()
  {
    return this.c.a("meri_silent_update_switch_user", true);
  }
  
  public boolean p()
  {
    return this.c.a("meri_silent_update_switch_cloud", true);
  }
  
  public int q()
  {
    return this.c.b("meri_update_msg_type");
  }
  
  public String r()
  {
    return this.c.a("meri_update_msg_title", "");
  }
  
  public boolean s()
  {
    return this.c.a("meri_silent_update", false);
  }
  
  public String t()
  {
    return this.c.a("meri_silent_update_url");
  }
  
  public boolean u()
  {
    return this.c.a("meri_silent_update_show_insatll_dlg", false);
  }
  
  public boolean v()
  {
    return this.c.a("meri_silent_update_show_insatll_notice", false);
  }
  
  public long w()
  {
    return this.c.a("meri_update_cycle_time", 604800000L);
  }
  
  public long x()
  {
    return this.c.a("meri_update_remind_time", 0L);
  }
  
  public String y()
  {
    return this.c.a("silent_download_time_control", "0;19,23,100");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.e
 * JD-Core Version:    0.7.0.1
 */