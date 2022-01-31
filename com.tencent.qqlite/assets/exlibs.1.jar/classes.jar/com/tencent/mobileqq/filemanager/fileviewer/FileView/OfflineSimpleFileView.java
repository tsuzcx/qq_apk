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

public class OfflineSimpleFileView
  extends FileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OfflineSimpleFileView";
  private View jdField_a_of_type_AndroidViewView;
  
  public OfflineSimpleFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineSimpleFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    Object localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297644);
    TextView localTextView;
    if (5 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())
    {
      ((AsyncImageView)localObject).setDefaultImage(2130838509);
      ((AsyncImageView)localObject).setApkIconAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297985)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297646);
      if (2 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c()) {
        break label224;
      }
    }
    label224:
    for (localObject = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) + BaseApplicationImpl.getContext().getString(2131361977);; localObject = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) + BaseApplicationImpl.getContext().getString(2131361977) + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b(), false) + BaseApplicationImpl.getContext().getString(2131361974))
    {
      localTextView.setText((CharSequence)localObject);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298059)).setVisibility(8);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f() != null)
      {
        ((AsyncImageView)localObject).setAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.f());
        break;
      }
      ((AsyncImageView)localObject).setImageResource(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
      break;
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903432, paramViewGroup, false);
    e();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131361983);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineSimpleFileView
 * JD-Core Version:    0.7.0.1
 */