package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import fpk;
import fpl;
import fpm;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fpm(this);
  private SendBottomBar jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar;
  final String jdField_a_of_type_JavaLangString = "BaseFileAssistantActivity<FileAssistant>";
  public boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e;
  private boolean f;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void g()
  {
    if (g())
    {
      this.m.setVisibility(0);
      this.m.setText(getString(2131558705));
      this.m.setOnClickListener(new fpl(this));
      return;
    }
    this.m.setVisibility(4);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131232755));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    SendBottomBar localSendBottomBar = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar;
    if (g()) {}
    for (int i = 0;; i = 8)
    {
      localSendBottomBar.setVisibility(i);
      return;
    }
  }
  
  private void i()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131232760);
    if (g())
    {
      localRelativeLayout.setVisibility(0);
      return;
    }
    localRelativeLayout.setVisibility(8);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    new Handler().postDelayed(new fpk(this), 1500L);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if (paramInt2 == 4)
    {
      if ((this.f) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    paramBundle = getIntent();
    b(paramBundle.getBooleanExtra("selectMode", g()));
    if (!g()) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramBundle.getBooleanExtra("enableDelete", bool));
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("srcDiscGroup");
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("peerType", 0);
      this.f = paramBundle.getBooleanExtra("rootEntrace", true);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("busiType", 0);
      this.jdField_d_of_type_Int = paramBundle.getIntExtra("enterfrom", 0);
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("sendprepare", -100);
      this.e = paramBundle.getBooleanExtra("apautocreate", false);
      if (QLog.isColorLevel()) {
        QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<<" + " doOnCreate ");
      }
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<<" + " doOnDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    this.jdField_b_of_type_Boolean = true;
    super.doOnResume();
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected void e()
  {
    g();
    h();
    i();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
  }
  
  public boolean f()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void finish()
  {
    super.finish();
    if (this.f)
    {
      if (b() == 1) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      }
      FMDataCache.b();
    }
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean i()
  {
    return this.e;
  }
  
  public void onClick(View paramView) {}
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2130903508);
    ((RelativeLayout)findViewById(2131232759)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    e();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", g());
    paramIntent.putExtra("enableDelete", f());
    paramIntent.putExtra("targetUin", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("srcDiscGroup", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("peerType", this.jdField_a_of_type_Int);
    paramIntent.putExtra("busiType", this.jdField_b_of_type_Int);
    paramIntent.putExtra("enterfrom", this.jdField_d_of_type_Int);
    paramIntent.putExtra("sendprepare", this.jdField_c_of_type_Int);
    paramIntent.putExtra("apautocreate", this.e);
    paramIntent.putExtra("rootEntrace", false);
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */