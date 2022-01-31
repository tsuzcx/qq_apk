package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import fxx;

public final class QfileC2COfflineFileController
  extends fxx
{
  static final String c = "<FileAssistant>QfileC2COfflineFileController";
  
  public QfileC2COfflineFileController(QfileFileViewerActivity paramQfileFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQfileFileViewerActivity, paramFileManagerEntity);
  }
  
  protected String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, 5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileC2COfflineFileController
 * JD-Core Version:    0.7.0.1
 */