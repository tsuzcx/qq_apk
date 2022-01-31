package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import duu;

public class OfflineVideoFileView
  extends OfflineVideoFileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "OfflineVideoFileView";
  private final OfflineVideoFileViewBase.IControllProxyInterface jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileViewBase$IControllProxyInterface;
  
  public OfflineVideoFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileViewBase$IControllProxyInterface = new duu(this, paramQQAppInterface);
    a().a();
  }
  
  protected OfflineVideoFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileViewBase$IControllProxyInterface;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView
 * JD-Core Version:    0.7.0.1
 */