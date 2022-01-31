package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import duw;
import java.util.List;

public class PhotoFileView
  extends PhotoFileViewBase
{
  private final PhotoFileViewBase.IControllProxyInterface jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPhotoFileViewBase$IControllProxyInterface;
  private final String jdField_a_of_type_JavaLangString = "PhotoFileView";
  
  public PhotoFileView(Activity paramActivity, QQAppInterface paramQQAppInterface, List paramList, int paramInt)
  {
    super(paramActivity, paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPhotoFileViewBase$IControllProxyInterface = new duw(this, paramQQAppInterface);
    a().a();
  }
  
  protected PhotoFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPhotoFileViewBase$IControllProxyInterface;
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileView
 * JD-Core Version:    0.7.0.1
 */