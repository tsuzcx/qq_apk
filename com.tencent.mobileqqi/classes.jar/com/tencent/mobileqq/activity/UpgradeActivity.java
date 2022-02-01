package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;
import com.tencent.qphone.base.util.BaseApplication;
import dts;
import dtt;
import dtu;
import dtv;
import dtw;
import dtx;
import dty;
import dtz;
import dua;
import dub;
import duc;
import dud;
import due;
import duf;
import dug;
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
  String b;
  private String c = null;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = null;
  private String jdField_e_of_type_JavaLangString;
  private int i = 0;
  private int j = 0;
  
  public UpgradeActivity()
  {
    this.e = null;
    this.jdField_b_of_type_JavaLangString = null;
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
    long l = getSharedPreferences("mobileQQi", 0).getLong("upgrade_tip_time", 0L);
    l = this.a - l;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.a * 1000L);
    int m = localCalendar.get(11);
    if (((l > 14400L) && (((12 <= m) && (14 >= m)) || ((20 <= m) && (23 >= m)))) || (l > 86400L)) {
      bool = true;
    }
    return bool;
  }
  
  private void f()
  {
    this.c = getString(2131559143);
    this.jdField_d_of_type_JavaLangString = getString(2131559144);
    showDialog(8192);
  }
  
  private void g()
  {
    this.c = getString(2131559145);
    this.jdField_d_of_type_JavaLangString = getString(2131559146);
    showDialog(16384);
  }
  
  private void h()
  {
    this.c = getIntent().getStringExtra("StrTitle");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("StrUpgradeDesc");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("StrUrl");
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
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("mobileQQi", 0);
      int n = ((SharedPreferences)localObject).getInt("upgrade_tip_count", 0);
      if (m == 0)
      {
        if ((n < 3) && (c()))
        {
          showDialog(1);
          ((SharedPreferences)localObject).edit().putLong("upgrade_tip_time", this.a).commit();
          return;
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
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
  
  private void i() {}
  
  private void j() {}
  
  private void k() {}
  
  public void d()
  {
    finish();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k();
  }
  
  public void e()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("mobileQQi", 0);
    int m = localSharedPreferences.getInt("upgrade_tip_count", 0);
    if (m < 3) {
      localSharedPreferences.edit().putInt("upgrade_tip_count", m + 1).commit();
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = UpgradeController.a().a();
    if ((paramBundle == null) || (paramBundle.a == null) || (paramBundle.a.iUpgradeType <= 0))
    {
      finish();
      return;
    }
    getWindow().setBackgroundDrawableResource(2131361815);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("activity_type", 4096);
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      finish();
      return;
    case 4096: 
      h();
      return;
    case 8192: 
      f();
      return;
    }
    g();
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
        break label504;
      }
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setOnDismissListener(new dty(this));
      return localObject;
      localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
      ((QQCustomDialog)localObject).setPositiveButton(2131563134, new dua(this)).setNegativeButton(2131562704, new dtz(this)).setOnKeyListener(new dts(this));
      continue;
      if (this.j == 0)
      {
        localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
        if (UpgradeController.a().a() == 4) {}
        for (paramInt = 2131562241;; paramInt = 2131563134)
        {
          ((QQCustomDialog)localObject).setPositiveButton(paramInt, new dud(this)).setNegativeButton(2131561659, new duc(this)).setOnKeyListener(new dub(this));
          break;
        }
      }
      if (this.j != 2) {
        break;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
      this.e = getResources().getString(2131559142);
      localObject = DialogUtil.a(this, this.c, this.jdField_d_of_type_JavaLangString, this.e, new due(this), getResources().getString(2131559147), new duf(this));
      ((QQCustomSingleButtonDialog)localObject).setOnKeyListener(new dug(this));
      if (localObject != null)
      {
        ((QQCustomSingleButtonDialog)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomSingleButtonDialog)localObject).setOnDismissListener(new dtt(this));
        return localObject;
      }
      localObject = null;
      continue;
      localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
      ((QQCustomDialog)localObject).setPositiveButton(getResources().getString(2131559148), new dtv(this)).setNegativeButton(getResources().getString(2131559149), new dtu(this));
      continue;
      localObject = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.jdField_d_of_type_JavaLangString);
      ((QQCustomDialog)localObject).setPositiveButton(getResources().getString(2131559150), new dtx(this)).setNegativeButton(getResources().getString(2131559151), new dtw(this));
    }
    label504:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */