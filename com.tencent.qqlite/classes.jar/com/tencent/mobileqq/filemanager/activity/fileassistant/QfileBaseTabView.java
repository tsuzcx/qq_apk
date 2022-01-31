package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import djg;
import java.util.ArrayList;

public class QfileBaseTabView
  extends RelativeLayout
  implements IBaseTabViewEvent
{
  protected Handler a;
  protected QQAppInterface a;
  public FMActivity a;
  View d;
  boolean e;
  public boolean f = true;
  
  public QfileBaseTabView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity = ((FMActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.app;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected BaseFileAssistantActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity;
  }
  
  protected String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(paramInt);
  }
  
  protected void a(int paramInt)
  {
    this.d = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.d);
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  public void a(FileManagerEntity paramFileManagerEntity) {}
  
  protected void a(Runnable paramRunnable)
  {
    a().runOnUiThread(paramRunnable);
  }
  
  public void a(ArrayList paramArrayList) {}
  
  public boolean a(FileInfo paramFileInfo)
  {
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(ArrayList paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidOsHandler == null;
  }
  
  public void d(ArrayList paramArrayList) {}
  
  protected boolean d()
  {
    return this.f;
  }
  
  public void e(ArrayList paramArrayList) {}
  
  protected boolean e()
  {
    return a().g();
  }
  
  public void f(ArrayList paramArrayList) {}
  
  protected boolean f()
  {
    return a().i();
  }
  
  public void g(ArrayList paramArrayList) {}
  
  protected boolean g()
  {
    return (f()) || (e());
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
  
  protected void q()
  {
    this.f = false;
    new Handler().postDelayed(new djg(this), 1500L);
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  protected void s()
  {
    a().m();
  }
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void setSelect(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
 * JD-Core Version:    0.7.0.1
 */