package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import fth;
import ftq;
import java.util.List;

public final class QfileWeiyunFileController
  extends fth
{
  static final String b = "<FileAssistant>QfileWeiyunFileController";
  
  public QfileWeiyunFileController(QfileFileViewerActivity paramQfileFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQfileFileViewerActivity, paramFileManagerEntity);
  }
  
  public ViewerData a()
  {
    ViewerData localViewerData = super.a();
    localViewerData.c = true;
    localViewerData.h = true;
    localViewerData.l = a(2131558750);
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    default: 
      localViewerData.jdField_g_of_type_JavaLangString = a(2131558725);
      QLog.i("<FileAssistant>QfileWeiyunFileController", 1, "should not come here ,entity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    case 0: 
    case 3: 
    case 16: 
    case -1: 
    case 1: 
      for (;;)
      {
        if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == 0) {
          localViewerData.jdField_a_of_type_Boolean = true;
        }
        if (!FMDataCache.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId)) {
          break;
        }
        localViewerData.jdField_g_of_type_Boolean = true;
        return localViewerData;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 5))
        {
          localViewerData.jdField_g_of_type_JavaLangString = a(2131558731);
        }
        else
        {
          localViewerData.jdField_g_of_type_JavaLangString = a(2131558730);
          continue;
          localViewerData.jdField_f_of_type_JavaLangString = a(2131560909);
          continue;
          localViewerData.jdField_g_of_type_JavaLangString = a(2131558725);
        }
      }
    }
    long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 5)) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558732) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.getString(2131558733) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      localViewerData.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
      localViewerData.jdField_a_of_type_JavaLangString = str;
      localViewerData.jdField_f_of_type_Boolean = true;
      break;
    }
    localViewerData.jdField_g_of_type_Boolean = false;
    return localViewerData;
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    Object localObject = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId.length() > 0)) {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>QfileWeiyunFileController", 2, "begin pull xlarge weiyun pic thumb, FileManagerEntity:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "beginTime:" + MessageCache.a());
      }
      if (paramObject == null) {
        a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, true);
      }
      if (paramObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramObject;
      }
      return;
      paramObject = localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid != null)
      {
        paramObject = localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() > 0) {
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, 5, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
      }
    }
  }
  
  protected void a(List paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      paramList.add(Integer.valueOf(2131558801));
    } while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() != 10003) || (FMDataCache.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId)));
    paramList.add(Integer.valueOf(2131558799));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
  }
  
  public void c(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 3) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        return;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      return;
    }
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity))
    {
      if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)))
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, 2131558759, 2131558757, new ftq(this));
        return;
      }
      e();
      return;
    }
    FMToastUtil.a(2131562488);
  }
  
  public void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() == 10003) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, null, -1, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileWeiyunFileController
 * JD-Core Version:    0.7.0.1
 */