package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dsq;
import dsr;

public abstract class BaseQfileActionBar
  extends BaseActionBar
{
  protected Button a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public ProgressBar a;
  public TextView a;
  protected FMObserver a;
  public FileManagerEntity a;
  public IFileBrowser a;
  private final String jdField_a_of_type_JavaLangString = "BaseActionBar<FileAssistant>";
  RelativeLayout b = null;
  
  public BaseQfileActionBar(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  public abstract void a();
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IFileBrowser))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = ((IFileBrowser)paramObject);
      b();
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    throw new NullPointerException("init类型错误,请检查堆栈");
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseActionBar<FileAssistant>", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dsr(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public abstract void c();
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseActionBar<FileAssistant>", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is delete");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  }
  
  public void f()
  {
    e();
  }
  
  public void g()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    c();
  }
  
  public void h()
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (this.jdField_a_of_type_AndroidWidgetButton == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.b.findViewById(2131297968));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new dsq(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.b.findViewById(2131297967));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131297966));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 6) && ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 8) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 1) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 5))) {
        break label245;
      }
    }
    label245:
    for (String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131361992) + "(" + FileUtil.a(0L) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131361993) + "(" + FileUtil.a(0L) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar
 * JD-Core Version:    0.7.0.1
 */