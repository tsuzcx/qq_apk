package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import fth;
import ftk;
import java.util.List;

public class QfileBaseLocalFileController
  extends fth
{
  static final String b = "<FileAssistant>QfileLocalFileController";
  
  public QfileBaseLocalFileController(BaseFileViewerActivity paramBaseFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramBaseFileViewerActivity, paramFileManagerEntity);
  }
  
  protected void a()
  {
    if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, 2131558759, 2131558756, new ftk(this));
      return;
    }
    e();
  }
  
  protected void a(List paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      paramList.add(Integer.valueOf(2131558800));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) {
        paramList.add(Integer.valueOf(2131558802));
      }
      if (a()) {
        paramList.add(Integer.valueOf(2131558803));
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 0);
    paramList.add(Integer.valueOf(2131558804));
    paramList.add(Integer.valueOf(2131558805));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.relatedEntity.nSessionId);
  }
  
  public void f(View paramView)
  {
    FileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
  }
  
  public void g(View paramView)
  {
    QfileFileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileBaseLocalFileController
 * JD-Core Version:    0.7.0.1
 */