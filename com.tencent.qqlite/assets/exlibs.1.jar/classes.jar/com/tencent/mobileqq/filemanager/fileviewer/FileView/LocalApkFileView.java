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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;

public class LocalApkFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString = "LocalApkFileViewer";
  
  public LocalApkFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalApkFileViewer", 4, "initVarView: but adapter is null");
      }
      return;
    }
    Object localObject = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297644);
    ((AsyncImageView)localObject).setDefaultImage(2130838509);
    ((AsyncImageView)localObject).setApkIconAsyncImage(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297985)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297646)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298059)).setText(BaseApplicationImpl.getContext().getString(2131362008));
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298058);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() == 16)
    {
      ((TextView)localObject).setText(BaseApplicationImpl.getContext().getString(2131362028));
      return;
    }
    ((TextView)localObject).setVisibility(8);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903432, paramViewGroup, false);
    e();
    return this.jdField_a_of_type_AndroidViewView;
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalApkFileView
 * JD-Core Version:    0.7.0.1
 */