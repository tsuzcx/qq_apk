package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.ViewerData;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import fth;

public final class QfileOnlineFileController
  extends fth
{
  static final String b = "<FileAssistant>QfileOnlineFileController";
  
  public QfileOnlineFileController(QfileFileViewerActivity paramQfileFileViewerActivity, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQfileFileViewerActivity, paramFileManagerEntity);
  }
  
  public ViewerData a()
  {
    boolean bool = false;
    int j = 2131558725;
    ViewerData localViewerData = super.a();
    localViewerData.c = false;
    localViewerData.jdField_a_of_type_Boolean = false;
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType)
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("<FileAssistant>QfileOnlineFileController", 2, "<FileAssistant>QfileOnlineFileControllerdefault: should not come here!!!! entity info:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      }
      i = 0;
      label143:
      localViewerData.jdField_f_of_type_Boolean = bool;
      if (bool)
      {
        localViewerData.jdField_a_of_type_JavaLangString = a(2131558748);
        localViewerData.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
      }
      break;
    }
    do
    {
      return localViewerData;
      i = 0;
      break label143;
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
      {
      case 10: 
      default: 
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("<FileAssistant>QfileOnlineFileController", 2, "<FileAssistant>QfileOnlineFileControllerOPERATION_TYPE_OLFILE_BE_PC_HANDLED:  should not come here!!!! entity info:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        i = 0;
        break;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
        {
        default: 
          i = 0;
          break;
        case 5: 
          i = 2131558774;
          break;
        case 6: 
          i = 2131558775;
          break;
        case 7: 
          i = 2131558774;
          break;
        case 8: 
        case 9: 
          i = 2131558776;
        }
        break;
      case 11: 
      case 12: 
      case 13: 
      case 14: 
        i = 0;
        break label143;
        switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
        {
        case 13: 
        default: 
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("<FileAssistant>QfileOnlineFileController", 2, "<FileAssistant>QfileOnlineFileControllerOPERATION_TYPE_OLFILE_GOTO_UPLOAD: should not come here!!!! entity info:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          i = 0;
          break;
        case 14: 
        case 15: 
          bool = true;
          i = 0;
          break;
        case 10: 
        case 11: 
          j = 2131558730;
          i = 0;
          break;
        case 12: 
          i = 2131558777;
          break label143;
          switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
          {
          case 13: 
          default: 
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("<FileAssistant>QfileOnlineFileController", 2, "<FileAssistant>QfileOnlineFileControllerOPERATION_TYPE_OLFILE_STOP_UPLOAD: should not come here!!!! entity info:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
            i = 0;
            break;
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 14: 
          case 15: 
            j = 2131558730;
            i = 0;
            break label143;
            switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
            {
            default: 
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("<FileAssistant>QfileOnlineFileController", 2, "<FileAssistant>QfileOnlineFileControllerOPERATION_TYPE_OLFILE_BE_PC_HANDLED_IS_SENDER_2OFF: should not come here!!!! entity info:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
              i = 0;
              break;
            case 9: 
              i = 0;
              break label143;
              switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
              {
              case 9: 
              case 10: 
              case 11: 
              case 12: 
              case 13: 
              default: 
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("<FileAssistant>QfileOnlineFileController", 2, "<FileAssistant>QfileOnlineFileControllerOPERATION_TYPE_OLFILE_BE_PC_HANDLED_ON_RECV2OFF_FAILED: should not come here!!!! entity info:" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
                i = 0;
                break;
              case 5: 
              case 6: 
              case 7: 
              case 8: 
              case 14: 
                j = 2131558730;
                i = 0;
                break label143;
                i = 0;
                break label143;
                if (i != 0)
                {
                  localViewerData.jdField_f_of_type_JavaLangString = a(i);
                  return localViewerData;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    } while (j == 0);
    localViewerData.g = a(j);
    return localViewerData;
  }
  
  public void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileOnlineFileController
 * JD-Core Version:    0.7.0.1
 */