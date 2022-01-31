package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class QfileLocalFileController
  extends QfileBaseLocalFileController
{
  static final String c = "<FileAssistant>QfileLocalFileController";
  
  public QfileLocalFileController(BaseFileViewerActivity paramBaseFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramBaseFileViewerActivity, paramFileManagerEntity);
  }
  
  public ViewerData a()
  {
    int j = 0;
    ViewerData localViewerData = super.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    if (i == 16)
    {
      localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558770);
      localViewerData.c = false;
      return localViewerData;
    }
    QfileFileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, localViewerData);
    switch (i)
    {
    default: 
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("<FileAssistant>QfileLocalFileController", 2, "should not come here ,entity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        i = j;
      }
      if (i == 0)
      {
        if (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != true) {
          break label537;
        }
        localViewerData.i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131562565);
        label173:
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 5) {
          break label572;
        }
        localViewerData.j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558728);
        localViewerData.l = a(2131558751);
      }
      break;
    }
    for (;;)
    {
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == 0) {
        localViewerData.jdField_a_of_type_Boolean = true;
      }
      return localViewerData;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localViewerData.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558731);
        i = j;
        break;
      }
      localViewerData.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558731);
      i = j;
      break;
      localViewerData.h = false;
      localViewerData.c = true;
      i = j;
      break;
      long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558732) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";
      }
      for (;;)
      {
        localViewerData.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
        localViewerData.jdField_a_of_type_JavaLangString = ((String)localObject);
        localViewerData.jdField_f_of_type_Boolean = true;
        i = 1;
        break;
        String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558732) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("<FileAssistant>QfileLocalFileController", 2, "local file has not downloading ,entity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          localObject = str;
        }
      }
      localViewerData.h = false;
      localViewerData.c = true;
      i = j;
      break;
      label537:
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != true) {
        break label173;
      }
      localViewerData.i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131563152);
      break label173;
      label572:
      localViewerData.j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558727);
    }
  }
  
  public void c(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileLocalFileController
 * JD-Core Version:    0.7.0.1
 */