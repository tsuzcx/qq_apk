package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import fto;

public class QfileFileViewerFacade
{
  static final String a = "<FileAssistant>QfileFileViewerFacade";
  
  public static void a() {}
  
  public static void a(QQAppInterface paramQQAppInterface, BaseFileViewerActivity paramBaseFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    String str1 = paramFileManagerEntity.strFilePath;
    QLog.i("<FileAssistant>QfileFileViewerFacade", 1, "open[" + str1 + "]");
    if (str1.lastIndexOf(".rename") > 0)
    {
      String str3 = str1.replace(".rename", "");
      String str2 = str3.substring(0, str3.lastIndexOf("."));
      str3 = str3.substring(str3.lastIndexOf(".")).replaceAll("[0-9]*", "").replace("(", "").replace(")", "");
      str2 = str2 + str3;
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>QfileFileViewerFacade", 1, "file maybe renmaed,realName[" + str2 + "]");
      }
      FMDialogUtil.a(paramBaseFileViewerActivity, paramBaseFileViewerActivity.getString(2131558722), 2131558724, new fto(str2, str1, paramFileManagerEntity, paramQQAppInterface, paramBaseFileViewerActivity));
      return;
    }
    FileManagerUtil.b(paramBaseFileViewerActivity, paramFileManagerEntity.strFilePath);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseFileViewerActivity paramBaseFileViewerActivity, FileManagerEntity paramFileManagerEntity, ViewerData paramViewerData)
  {
    if ((paramFileManagerEntity.nOpType == 6) || (paramFileManagerEntity.nOpType == 4) || (paramFileManagerEntity.nOpType == 20))
    {
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] nOpType is weiyunFile ,hide button");
      return;
    }
    if (paramFileManagerEntity.status == 16)
    {
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] nOpType is INVALID_FILE  ,hide button");
      return;
    }
    if (paramFileManagerEntity.nRelatedSessionId == 0L)
    {
      paramViewerData.k = paramBaseFileViewerActivity.getString(2131558703);
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]not related ,and set SaveToWeiYun");
      return;
    }
    paramQQAppInterface = paramQQAppInterface.a().a(paramFileManagerEntity.nRelatedSessionId);
    if (paramQQAppInterface == null)
    {
      paramViewerData.k = paramBaseFileViewerActivity.getString(2131558703);
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]related[" + String.valueOf(paramFileManagerEntity.nRelatedSessionId) + "],but not entity,and set SaveToWeiYun");
      return;
    }
    if ((paramQQAppInterface.nOpType != 6) && (paramQQAppInterface.nOpType != 4) && (paramQQAppInterface.nOpType != 20))
    {
      paramViewerData.k = paramBaseFileViewerActivity.getString(2131558743);
      paramViewerData.e = false;
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] related[" + String.valueOf(paramFileManagerEntity.nRelatedSessionId) + "] is upload success,set Success!");
      return;
    }
    switch (paramQQAppInterface.status)
    {
    default: 
      paramViewerData.k = paramBaseFileViewerActivity.getString(2131558703);
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] related[" + String.valueOf(paramFileManagerEntity.nRelatedSessionId) + "] is not status,set SaveToWeiYun!");
      return;
    case 0: 
    case 3: 
      paramViewerData.k = paramBaseFileViewerActivity.getString(2131558703);
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] related[" + String.valueOf(paramFileManagerEntity.nRelatedSessionId) + "] is pause,set fv_resume_upload!");
      return;
    case 2: 
      paramViewerData.k = (paramBaseFileViewerActivity.getString(2131558744) + "(" + Integer.valueOf((int)(paramQQAppInterface.fProgress * 100.0F)) + "%)");
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] related[" + String.valueOf(paramFileManagerEntity.nRelatedSessionId) + "] is processing,set fv_uploading!");
      return;
    case 1: 
      paramViewerData.k = paramBaseFileViewerActivity.getString(2131558743);
      paramViewerData.e = false;
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] related[" + String.valueOf(paramFileManagerEntity.nRelatedSessionId) + "] is success,set fv_save_wy_suc!");
      return;
    }
    paramViewerData.k = null;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType != 6)
    {
      if (paramFileManagerEntity.relatedEntity == null) {
        if (paramFileManagerEntity.nRelatedSessionId <= 0L) {
          break label69;
        }
      }
      label69:
      for (paramQQAppInterface = paramQQAppInterface.a().a(paramFileManagerEntity.nRelatedSessionId);; paramQQAppInterface = null)
      {
        paramFileManagerEntity.relatedEntity = paramQQAppInterface;
        if ((paramFileManagerEntity.relatedEntity != null) && ((paramFileManagerEntity.relatedEntity == null) || (paramFileManagerEntity.relatedEntity.status == 1))) {
          break;
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerFacade
 * JD-Core Version:    0.7.0.1
 */