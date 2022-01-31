package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileController;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.IFileViewerController;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.HashMap;
import java.util.Map;

public final class QfileFileController
  extends BaseFileController
{
  static final String jdField_a_of_type_JavaLangString = "<FileAssistant>QfileFileController";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  QfileC2COfflineFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileC2COfflineFileController = null;
  QfileDiscOfflineFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileDiscOfflineFileController = null;
  QfileFileViewerActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity = null;
  QfileLocalFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileLocalFileController = null;
  QfileOnlineFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileOnlineFileController = null;
  QfileQlinkFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileQlinkFileController = null;
  QfileWeiyunFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileWeiyunFileController = null;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  @SuppressLint({"UseSparseArrays"})
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public QfileFileController(QQAppInterface paramQQAppInterface, QfileFileViewerActivity paramQfileFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity = paramQfileFileViewerActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public IFileViewerController a()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType)
    {
    case 4: 
    default: 
      return null;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileLocalFileController == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileLocalFileController = new QfileLocalFileController(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileLocalFileController;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileDiscOfflineFileController == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileDiscOfflineFileController = new QfileDiscOfflineFileController(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
        return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileDiscOfflineFileController;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileC2COfflineFileController == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileC2COfflineFileController = new QfileC2COfflineFileController(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileC2COfflineFileController;
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileQlinkFileController == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileQlinkFileController = new QfileQlinkFileController(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileQlinkFileController;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileWeiyunFileController == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileWeiyunFileController = new QfileWeiyunFileController(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileWeiyunFileController;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileOnlineFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileOnlineFileController = new QfileOnlineFileController(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileOnlineFileController;
  }
  
  public ViewerData a()
  {
    return a().a();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.onBackPressed();
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((FileManagerEntity)paramObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileViewerActivity.a.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    a().a(paramObject);
  }
  
  public boolean a(Menu paramMenu)
  {
    return a().a(paramMenu);
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    return a().a(paramMenuItem);
  }
  
  public void b(View paramView)
  {
    a().b(paramView);
  }
  
  public void c(View paramView)
  {
    a().c(paramView);
  }
  
  public void d(View paramView)
  {
    a().d(paramView);
  }
  
  public void e(View paramView)
  {
    a().e(paramView);
  }
  
  public void f(View paramView)
  {
    a().f(paramView);
  }
  
  public void g(View paramView)
  {
    a().g(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileController
 * JD-Core Version:    0.7.0.1
 */