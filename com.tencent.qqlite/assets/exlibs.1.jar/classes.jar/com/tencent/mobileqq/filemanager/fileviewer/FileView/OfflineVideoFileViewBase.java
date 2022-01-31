package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

public abstract class OfflineVideoFileViewBase
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OfflineVideoFileViewBase";
  private View jdField_a_of_type_AndroidViewView;
  
  public OfflineVideoFileViewBase(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineVideoFileViewBase", 4, "initVarView: but adapter is null");
      }
      return;
    }
    e();
    a().c();
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297990)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297650);
    if (2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c()) {}
    for (String str = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) + BaseApplicationImpl.getContext().getString(2131361977);; str = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) + BaseApplicationImpl.getContext().getString(2131361977) + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b(), false) + BaseApplicationImpl.getContext().getString(2131361974))
    {
      localTextView.setText(str);
      if ((6 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c()) && (7 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c())) {
        break;
      }
      localTextView.setVisibility(4);
      return;
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903444, paramViewGroup, false);
    g();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract OfflineVideoFileViewBase.IControllProxyInterface a();
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131361983);
  }
  
  public void a()
  {
    a().b();
  }
  
  public void b()
  {
    g();
  }
  
  public void e()
  {
    AsyncImageView localAsyncImageView = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297648);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f() != null)
    {
      localAsyncImageView.setAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f());
      return;
    }
    localAsyncImageView.setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileViewBase
 * JD-Core Version:    0.7.0.1
 */