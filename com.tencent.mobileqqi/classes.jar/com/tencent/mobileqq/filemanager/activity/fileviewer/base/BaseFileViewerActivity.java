package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFileViewerActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int = 0;
  private FileViewerController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController;
  private FileViewerImageAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerImageAdapter;
  private IFileViewerController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseIFileViewerController;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  private void a(int paramInt)
  {
    super.f(2130903509);
    ((RelativeLayout)findViewById(2131232761)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    b(getIntent());
  }
  
  public abstract int a();
  
  public abstract IFileViewerController a();
  
  public abstract String a(Object paramObject);
  
  public abstract List a();
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Int != paramInt) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_Int = paramInt;
    paramAdapterView = ((FileViewerImageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController.a(paramAdapterView);
    f();
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      f();
      return;
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      int i = this.jdField_a_of_type_Int;
      return i + 1 + "/" + this.jdField_a_of_type_JavaUtilList.size();
    }
    return getString(2131558721);
  }
  
  public abstract boolean c();
  
  public void d()
  {
    d();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 != 103) && (paramInt2 != 4)) || (paramIntent == null) || (paramIntent.getExtras() == null)) {
      return;
    }
    setResult(4, paramIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(2130903514);
    x();
    if (!c())
    {
      QLog.e("IphoneTitleBarActivity", 1, "create subclass false!");
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarActivity", 2, FileManagerUtil.a());
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseIFileViewerController = a();
    this.jdField_a_of_type_JavaUtilList = a();
    this.jdField_a_of_type_Int = a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerImageAdapter = new FileViewerImageAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerImageAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController = new FileViewerController(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseIFileViewerController);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131231777));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerImageAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131427411));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    f();
    return true;
  }
  
  public void e()
  {
    e();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerImageAdapter != null)
    {
      if (this.jdField_b_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        int j = this.jdField_a_of_type_ComTencentWidgetGallery.p();
        int i = j;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        }
        Object localObject = ((FileViewerImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController.a(localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerImageAdapter.notifyDataSetChanged();
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle(c());
    }
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      finish();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController == null) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController.a(paramMenuItem);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseFileViewerController.a(paramMenu);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */