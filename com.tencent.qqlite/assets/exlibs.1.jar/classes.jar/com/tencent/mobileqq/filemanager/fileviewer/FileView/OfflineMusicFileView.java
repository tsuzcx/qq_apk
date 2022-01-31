package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class OfflineMusicFileView
  extends FileViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString = "OfflineMusicFileViewer";
  
  public OfflineMusicFileView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("OfflineMusicFileViewer", 4, "initVarView: but adapter is null");
      }
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297985)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130903438, paramViewGroup, false);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297646);
    if (2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c()) {}
    for (paramViewGroup = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) + BaseApplicationImpl.getContext().getString(2131361977);; paramViewGroup = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) + BaseApplicationImpl.getContext().getString(2131361977) + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b(), false) + BaseApplicationImpl.getContext().getString(2131361974))
    {
      localTextView.setText(paramViewGroup);
      ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131298065)).setEnabled(false);
      e();
      return this.jdField_a_of_type_AndroidViewView;
    }
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineMusicFileView
 * JD-Core Version:    0.7.0.1
 */