package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.ImplDataReportHandle_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.QLog;
import dgy;
import dgz;
import dha;
import java.util.ArrayList;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public RelativeLayout a;
  public TextView a;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dha(this);
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  private IReport_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51;
  public QfileEditBottomBar a;
  public SendBottomBar a;
  final String jdField_a_of_type_JavaLangString = "BaseFileAssistantActivity<FileAssistant>";
  public boolean a;
  private int b;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  private boolean h;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void n()
  {
    k();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131298030));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131297974));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (g())
    {
      i();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    while (!i()) {
      return;
    }
    i();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298040));
    }
    if ((g()) || (i())) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      b(j());
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public IReport_Ver51 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51;
  }
  
  public void a(int paramInt)
  {
    super.setContentViewNoTitle(2130903432);
    ((RelativeLayout)findViewById(2131298038)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.j = ((TextView)findViewById(2131298004));
    h();
    l();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramIClickListener_Ver51);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramIClickListener_Ver51);
  }
  
  public void a(ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d();
      return;
    }
    e();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setEditBtnVisible(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c() {}
  
  public void c(ArrayList paramArrayList) {}
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d()
  {
    h();
  }
  
  public void d(ArrayList paramArrayList) {}
  
  protected void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if (paramInt2 == 4)
    {
      if ((this.h) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        a(paramIntent.getExtras());
      }
      setResult(4, paramIntent);
      finish();
    }
    do
    {
      return;
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
        return;
      }
    } while (paramInt2 != 5);
    setResult(5, null);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    paramBundle = getIntent();
    e(paramBundle.getBooleanExtra("selectMode", g()));
    if (!g()) {}
    for (boolean bool = true;; bool = false)
    {
      d(paramBundle.getBooleanExtra("enableDelete", bool));
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("srcDiscGroup");
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("peerType", 0);
      this.h = paramBundle.getBooleanExtra("rootEntrace", true);
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("busiType", 0);
      this.jdField_d_of_type_Int = paramBundle.getIntExtra("enterfrom", 0);
      this.g = paramBundle.getBooleanExtra("apautocreate", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
      FMDataCache.a(20);
      if (QLog.isColorLevel()) {
        QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<<" + " doOnCreate ");
      }
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<<" + " doOnDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    this.jdField_c_of_type_Boolean = true;
    m();
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    super.doOnResume();
  }
  
  public void e()
  {
    this.j.setVisibility(0);
  }
  
  public void e(ArrayList paramArrayList) {}
  
  protected void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void f()
  {
    this.j.setVisibility(8);
  }
  
  public void f(ArrayList paramArrayList) {}
  
  public void f(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void finish()
  {
    super.finish();
    if ((this.h) && (j())) {
      FMDataCache.b();
    }
  }
  
  public void g()
  {
    this.jdField_c_of_type_Boolean = false;
    new Handler().postDelayed(new dgy(this), 1500L);
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298039));
      i();
    }
    n();
    if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
      f();
    }
    o();
    p();
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public void j()
  {
    setTitle(this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Int == 1) && (!j())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public boolean j()
  {
    return (g()) || (i());
  }
  
  public void k()
  {
    if (j())
    {
      this.j.setVisibility(0);
      this.j.setText(getString(2131361966));
    }
    for (;;)
    {
      this.j.setOnClickListener(new dgz(this));
      return;
      this.j.setVisibility(0);
      this.j.setText(2131361939);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51 = new ImplDataReportHandle_Ver51();
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    long l = FMDataCache.a();
    if ((!this.jdField_b_of_type_Boolean) && (j()))
    {
      if (FMDataCache.a() == 0L) {
        j();
      }
    }
    else {
      return;
    }
    setTitle("已选" + l + "个");
  }
  
  public void onClick(View paramView) {}
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2130903432);
    ((RelativeLayout)findViewById(2131298038)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    h();
    l();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", g());
    paramIntent.putExtra("enableDelete", f());
    paramIntent.putExtra("targetUin", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("srcDiscGroup", this.jdField_d_of_type_JavaLangString);
    paramIntent.putExtra("peerType", this.jdField_b_of_type_Int);
    paramIntent.putExtra("busiType", this.jdField_c_of_type_Int);
    paramIntent.putExtra("enterfrom", this.jdField_d_of_type_Int);
    paramIntent.putExtra("apautocreate", this.g);
    paramIntent.putExtra("rootEntrace", false);
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */