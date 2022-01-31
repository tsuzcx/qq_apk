package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import brc;
import brd;
import bre;
import brf;
import brg;
import brh;
import bri;
import brj;
import brk;
import brl;
import brm;
import brn;
import bro;
import brp;
import brq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;
import java.util.Calendar;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeActivity
  extends BaseActivity
{
  public static final int a = 4096;
  public static final String a = "activity_type";
  public static final int b = 8192;
  public static final int c = 16384;
  private static final int jdField_e_of_type_Int = 0;
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 3;
  private static final int k = 3;
  long a;
  String b = null;
  private String c = null;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = null;
  private String jdField_e_of_type_JavaLangString;
  private int i = 0;
  private int j = 0;
  
  public UpgradeActivity()
  {
    this.e = "确认升级";
  }
  
  private void a(boolean paramBoolean)
  {
    if (UpgradeController.a().a() == 4)
    {
      UpgradeController.a().a(this);
      return;
    }
    UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, true, true);
  }
  
  private boolean c()
  {
    boolean bool = false;
    long l = getSharedPreferences("QQLite", 0).getLong("upgrade_tip_time", 0L);
    l = this.a - l;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.a * 1000L);
    int m = localCalendar.get(11);
    if (((l > 14400L) && (((12 <= m) && (14 >= m)) || ((20 <= m) && (23 >= m)))) || (l > 86400L)) {
      bool = true;
    }
    return bool;
  }
  
  private void e()
  {
    this.c = "下载暂停";
    this.jdField_d_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void f()
  {
    this.c = "下载QQ失败";
    this.jdField_d_of_type_JavaLangString = "未能更新QQ新版本，点击“重试”继续下载。";
    showDialog(16384);
  }
  
  private void g()
  {
    this.c = getIntent().getStringExtra("StrTitle");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("StrUpgradeDesc");
    this.b = getIntent().getStringExtra("StrUrl");
    this.i = getIntent().getIntExtra("iUpgradeType", 0);
    this.j = getIntent().getIntExtra("iTipsType", 0);
    this.e = getIntent().getStringExtra("strConfirmBtnText");
    int m = getIntent().getIntExtra("mode", 0);
    if (this.i == 2)
    {
      showDialog(2);
      return;
    }
    if (this.i == 1)
    {
      this.a = MessageCache.a();
      Object localObject = BaseApplicationImpl.a().getSharedPreferences("QQLite", 0);
      int n = ((SharedPreferences)localObject).getInt("upgrade_tip_count", 0);
      if (m == 0)
      {
        if ((n < 3) && (c()))
        {
          showDialog(1);
          ((SharedPreferences)localObject).edit().putLong("upgrade_tip_time", this.a).commit();
          return;
        }
        localObject = this.app.a(Conversation.class);
        if (localObject != null) {
          ((Handler)localObject).sendEmptyMessage(11340003);
        }
        finish();
        return;
      }
      showDialog(1);
      return;
    }
    finish();
  }
  
  private void h() {}
  
  private void i() {}
  
  private void j() {}
  
  public void c()
  {
    finish();
    this.app.b(false);
  }
  
  public void d()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("QQLite", 0);
    int m = localSharedPreferences.getInt("upgrade_tip_count", 0);
    if (m < 3) {
      localSharedPreferences.edit().putInt("upgrade_tip_count", m + 1).commit();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = UpgradeController.a().a();
    if ((paramBundle == null) || (paramBundle.a == null) || (paramBundle.a.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131427345);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("activity_type", 4096);
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      finish();
      return true;
    case 4096: 
      g();
      return true;
    case 8192: 
      e();
      return true;
    }
    f();
    return true;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    finish();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null) {
        break label455;
      }
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setOnDismissListener(new bri(this));
      return localObject;
      localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
      ((QQCustomDialog)localObject).setPositiveButton(2131363158, new brk(this)).setNegativeButton(2131363161, new brj(this)).setOnKeyListener(new brc(this));
      continue;
      if (this.j == 0)
      {
        localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
        if (UpgradeController.a().a() == 4) {}
        for (paramInt = 2131363159;; paramInt = 2131363158)
        {
          ((QQCustomDialog)localObject).setPositiveButton(paramInt, new brn(this)).setNegativeButton(2131363160, new brm(this)).setOnKeyListener(new brl(this));
          break;
        }
      }
      if (this.j != 2) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
      localObject = DialogUtil.a(this, this.c, this.jdField_d_of_type_JavaLangString, this.e, new bro(this), "关闭", new brp(this));
      ((QQCustomSingleButtonDialog)localObject).setOnKeyListener(new brq(this));
      if (localObject != null)
      {
        ((QQCustomSingleButtonDialog)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomSingleButtonDialog)localObject).setOnDismissListener(new brd(this));
        return localObject;
      }
      localObject = null;
      continue;
      localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
      ((QQCustomDialog)localObject).setPositiveButton("继续下载", new brf(this)).setNegativeButton("取消", new bre(this));
      continue;
      localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
      ((QQCustomDialog)localObject).setPositiveButton("重试", new brh(this)).setNegativeButton("取消", new brg(this));
    }
    label455:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */