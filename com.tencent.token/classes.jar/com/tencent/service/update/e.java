package com.tencent.service.update;

import android.util.Log;
import com.tencent.token.global.RqdApplication;

public class e
{
  private static e a = null;
  private final String A = "conch_update_cloud_conchseqno";
  private final String B = "conch_update_cloud_task_for_active";
  private final String C = "meri_silent_update_switch_user";
  private final String D = "meri_silent_update_switch_cloud";
  private final String E = "meri_silent_update";
  private final String F = "meri_silent_update_url";
  private final String G = "meri_silent_update_msg_title";
  private final String H = "meri_silent_update_msg";
  private final String I = "meri_silent_update_msg_type";
  private final String J = "meri_silent_update_msg_ask_type";
  private final String K = "meri_silent_update_show_insatll_dlg";
  private final String L = "meri_silent_update_next_notify_time";
  private final String M = "meri_silent_update_show_insatll_notice";
  private final String N = "is_need_report_go_browser";
  private final String O = "auto_install_under_root";
  private final String P = "has_click_update_tip_in_main_page";
  private final String Q = "silent_download_time_control";
  private final String R = "qqpim_download_position_show";
  private c b = new a(RqdApplication.l(), "updateConfig");
  private final String c = "meri_lastest_version_p";
  private final String d = "meri_lastest_version_c";
  private final String e = "meri_lastest_version_h";
  private final String f = "meri_lastest_build";
  private final String g = "meri_lastest_version_code";
  private final String h = "meri_lastest_featrue";
  private final String i = "meri_lastest_size";
  private final String j = "meri_lastest_url";
  private final String k = "meri_patch_url";
  private final String l = "meri_need_show_update_dialog";
  private final String m = "meri_update_start_time";
  private final String n = "meri_update_end_time";
  private final String o = "meri_update_url_type";
  private final String p = "meri_update_market";
  private final String q = "meri_update_msg_type";
  private final String r = "meri_update_msg_title";
  private final String s = "meri_update_process";
  private final String t = "meri_update_need_show";
  private final String u = "meri_update_remind_time";
  private final String v = "meri_update_cycle_time";
  private final String w = "meri_update_show_dialog_count";
  private final String x = "conch_update_cloud_task_id";
  private final String y = "conch_update_cloud_task_seqno";
  private final String z = "conch_update_cloud_cmd_id";
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.b.b("meri_update_url_type", paramInt);
  }
  
  public void a(long paramLong)
  {
    this.b.b("qqpim_download_position_show", paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.b.a();
    this.b.b("conch_update_cloud_task_id", paramLong1);
    this.b.b("conch_update_cloud_task_seqno", paramLong2);
    this.b.b("conch_update_cloud_cmd_id", paramInt1);
    this.b.b("conch_update_cloud_conchseqno", paramInt2);
    this.b.b();
  }
  
  public void a(SoftUpdateInfo paramSoftUpdateInfo, long paramLong, int paramInt, String paramString)
  {
    this.b.a();
    h(paramInt);
    e(paramString);
    c(paramLong);
    b(paramSoftUpdateInfo.newVersion.pversion);
    c(paramSoftUpdateInfo.newVersion.cversion);
    d(paramSoftUpdateInfo.newVersion.hotfix);
    e(paramSoftUpdateInfo.newBuildno);
    f(paramSoftUpdateInfo.newVersionCode);
    b(paramSoftUpdateInfo.newFeature);
    c(paramSoftUpdateInfo.url);
    a(paramSoftUpdateInfo.urlType);
    a(paramSoftUpdateInfo.market);
    e(paramSoftUpdateInfo.noticeInterval * 24 * 60 * 60 * 1000);
    g(paramSoftUpdateInfo.newPkgSize << 10);
    if (paramSoftUpdateInfo.silentDownloadInfo != null)
    {
      b(paramSoftUpdateInfo.isSilentDownload);
      f(paramSoftUpdateInfo.silentDownloadInfo.url);
      g(paramSoftUpdateInfo.silentDownloadInfo.title);
      h(paramSoftUpdateInfo.silentDownloadInfo.msg);
      i(paramSoftUpdateInfo.silentDownloadInfo.type);
      j(paramSoftUpdateInfo.silentDownloadInfo.askType);
    }
    this.b.b();
  }
  
  public void a(String paramString)
  {
    this.b.b("meri_update_market", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.b("meri_need_show_update_dialog", paramBoolean);
  }
  
  public long b()
  {
    return this.b.a("qqpim_download_position_show", 0L);
  }
  
  public void b(int paramInt)
  {
    this.b.b("meri_lastest_version_p", paramInt);
  }
  
  public void b(long paramLong)
  {
    this.b.b("meri_update_start_time", paramLong);
  }
  
  public void b(String paramString)
  {
    this.b.b("meri_lastest_featrue", paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.b("meri_silent_update", paramBoolean);
  }
  
  public long c()
  {
    return this.b.a("meri_update_end_time", 0L);
  }
  
  public void c(int paramInt)
  {
    this.b.b("meri_lastest_version_c", paramInt);
  }
  
  public void c(long paramLong)
  {
    this.b.b("meri_update_end_time", paramLong);
  }
  
  public void c(String paramString)
  {
    this.b.b("meri_lastest_url", paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.b("meri_silent_update_show_insatll_dlg", paramBoolean);
  }
  
  public int d()
  {
    return this.b.a("meri_update_url_type", 0);
  }
  
  public void d(int paramInt)
  {
    this.b.b("meri_lastest_version_h", paramInt);
  }
  
  public void d(long paramLong)
  {
    this.b.b("conch_update_cloud_task_for_active", paramLong);
  }
  
  public void d(String paramString)
  {
    this.b.b("meri_patch_url", paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.b.b("meri_silent_update_show_insatll_notice", paramBoolean);
  }
  
  public int e()
  {
    return this.b.a("meri_lastest_version_p", 0);
  }
  
  public void e(int paramInt)
  {
    this.b.b("meri_lastest_build", paramInt);
  }
  
  public void e(long paramLong)
  {
    this.b.b("meri_update_cycle_time", paramLong);
  }
  
  public void e(String paramString)
  {
    this.b.b("meri_update_msg_title", paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    this.b.b("meri_update_need_show", paramBoolean);
  }
  
  public int f()
  {
    return this.b.a("meri_lastest_version_c", 0);
  }
  
  public void f(int paramInt)
  {
    this.b.b("meri_lastest_version_code", paramInt);
  }
  
  public void f(long paramLong)
  {
    Log.i("updatemanager", "setMeriUpdateRemindTime");
    try
    {
      throw new Exception();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.b.b("meri_update_remind_time", paramLong);
    }
  }
  
  public void f(String paramString)
  {
    this.b.b("meri_silent_update_url", paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    this.b.b("has_click_update_tip_in_main_page", paramBoolean);
  }
  
  public int g()
  {
    return this.b.a("meri_lastest_version_h", 0);
  }
  
  public void g(int paramInt)
  {
    this.b.b("meri_lastest_size", paramInt);
  }
  
  public void g(String paramString)
  {
    this.b.b("meri_silent_update_msg_title", paramString);
  }
  
  public int h()
  {
    return this.b.a("meri_lastest_build", 0);
  }
  
  public void h(int paramInt)
  {
    this.b.b("meri_update_msg_type", paramInt);
  }
  
  public void h(String paramString)
  {
    this.b.b("meri_silent_update_msg", paramString);
  }
  
  public String i()
  {
    return this.b.a("meri_lastest_featrue", "");
  }
  
  public void i(int paramInt)
  {
    this.b.b("meri_silent_update_msg_type", paramInt);
  }
  
  public int j()
  {
    return this.b.a("meri_lastest_size", -1);
  }
  
  public void j(int paramInt)
  {
    this.b.b("meri_silent_update_msg_ask_type", paramInt);
  }
  
  public String k()
  {
    return this.b.a("meri_lastest_url", "");
  }
  
  public void k(int paramInt)
  {
    this.b.b("meri_update_process", paramInt);
  }
  
  public long l()
  {
    return this.b.a("conch_update_cloud_task_id", 0L);
  }
  
  public void l(int paramInt)
  {
    this.b.b("meri_update_show_dialog_count", paramInt);
  }
  
  public void m()
  {
    this.b.a();
    h(0);
    e("");
    b(0L);
    c(0L);
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
    e(0L);
    f(0L);
    l(0);
    b(false);
    f("");
    g("");
    h("");
    i(0);
    j(0);
    f(false);
    this.b.b();
  }
  
  public boolean n()
  {
    return this.b.a("meri_silent_update_switch_user", true);
  }
  
  public boolean o()
  {
    return this.b.a("meri_silent_update_switch_cloud", true);
  }
  
  public int p()
  {
    return this.b.b("meri_update_msg_type");
  }
  
  public String q()
  {
    return this.b.a("meri_update_msg_title", "");
  }
  
  public boolean r()
  {
    return this.b.a("meri_silent_update", false);
  }
  
  public String s()
  {
    return this.b.a("meri_silent_update_url");
  }
  
  public boolean t()
  {
    return this.b.a("meri_silent_update_show_insatll_dlg", false);
  }
  
  public boolean u()
  {
    return this.b.a("meri_silent_update_show_insatll_notice", false);
  }
  
  public long v()
  {
    return this.b.a("meri_update_cycle_time", 604800000L);
  }
  
  public long w()
  {
    return this.b.a("meri_update_remind_time", 0L);
  }
  
  public String x()
  {
    return this.b.a("silent_download_time_control", "0;19,23,100");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.e
 * JD-Core Version:    0.7.0.1
 */