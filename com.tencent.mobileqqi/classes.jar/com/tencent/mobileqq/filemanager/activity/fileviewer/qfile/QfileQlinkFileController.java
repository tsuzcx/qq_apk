package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;

public final class QfileQlinkFileController
  extends QfileBaseLocalFileController
{
  static final String c = "<FileAssistant>QfileQlinkFileController";
  boolean a;
  
  public QfileQlinkFileController(QfileFileViewerActivity paramQfileFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQfileFileViewerActivity, paramFileManagerEntity);
    this.jdField_a_of_type_Boolean = false;
    if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)) {
      FMToastUtil.c(2131558752);
    }
  }
  
  public ViewerData a()
  {
    ViewerData localViewerData = super.a();
    QfileFileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, localViewerData);
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    label169:
    int i;
    switch (j)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>QfileQlinkFileController", 2, "should not come here ,entity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      }
      i = 0;
      label171:
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (j != 1))
      {
        localViewerData.c = false;
        localViewerData.k = null;
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)) {
        localViewerData.jdField_a_of_type_Boolean = true;
      }
      return localViewerData;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560914);
        i = 0;
        break label171;
      }
      localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560913);
      i = 0;
      break label171;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localViewerData.e = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560915);
        localViewerData.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560921);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 0) {}
      }
      for (localViewerData.e = null;; localViewerData.e = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560916))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.errCode != -305) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.errCode != -306) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.errCode != -307)) {
          break label421;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break;
        }
        localViewerData.e = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560917);
        i = 0;
        break label171;
        localViewerData.g = null;
      }
      label421:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.errCode != -205) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)) {
        break label169;
      }
      localViewerData.e = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560918);
      i = 0;
      break label171;
      localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560909);
      i = 0;
      break label171;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560910);
        i = 0;
        break label171;
      }
      if (!QLog.isColorLevel()) {
        break label169;
      }
      QLog.e("<FileAssistant>QfileQlinkFileController", 2, "receiver should not have this status,entity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      i = 0;
      break label171;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560911);
        i = 0;
        break label171;
      }
      localViewerData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560912);
      i = 0;
      break label171;
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        FMToastUtil.c(2131558752);
      }
      localViewerData.h = false;
      localViewerData.c = true;
      i = 0;
      break label171;
      long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
      for (String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560924) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560925) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
      {
        localViewerData.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
        localViewerData.jdField_a_of_type_JavaLangString = str;
        localViewerData.jdField_f_of_type_Boolean = true;
        i = 1;
        break;
      }
      localViewerData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560908);
      localViewerData.jdField_a_of_type_Float = 0.0F;
      localViewerData.jdField_f_of_type_Boolean = true;
      i = 1;
      break label171;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localViewerData.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560923);
        break;
      }
      localViewerData.g = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131560922);
      break;
      if (i == 0)
      {
        if (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == true) {
          localViewerData.i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131562565);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 5) {
            break label1020;
          }
          localViewerData.j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558728);
          localViewerData.l = a(2131558751);
          break;
          if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == true) {
            localViewerData.i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131563152);
          }
        }
        label1020:
        localViewerData.j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558727);
      }
    }
  }
  
  public void c(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>QfileQlinkFileController", 2, "onFileTransButtonClicked resend, retuen new entity:" + FileManagerUtil.a(paramView));
      }
      a(paramView);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("<FileAssistant>QfileQlinkFileController", 2, "onFileTransButtonClicked qlink hava no rerecv");
  }
  
  public void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileQlinkFileController
 * JD-Core Version:    0.7.0.1
 */