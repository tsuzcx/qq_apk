package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class EntityFileViewerAdapter
  extends FileViewerAdapterBase
{
  private static final String jdField_a_of_type_JavaLangString = "EntityFileViewerAdapter";
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean jdField_a_of_type_Boolean;
  
  public EntityFileViewerAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    if (((3 == c()) && (d() != null)) || (1 == c())) {
      this.jdField_a_of_type_Boolean = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public WeiYunFileInfo a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EntityFileViewerAdapter", 4, "getWeiyunInfo should not be called on EntityFileViewAdapter");
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
  }
  
  public int c()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType;
    int i = j;
    if (2 == j)
    {
      i = j;
      if (FileUtil.b(b())) {
        i = 3;
      }
    }
    return i;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
  }
  
  public String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
    {
      localObject1 = localObject2;
      if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      }
    }
    return localObject1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend;
  }
  
  public int d()
  {
    if (4 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public boolean e()
  {
    if (3 == c()) {
      return false;
    }
    String str = FMConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "FunctionSwitch");
    int i;
    for (;;)
    {
      try
      {
        i = Integer.parseInt(str);
        if (i == 1)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        QLog.w("EntityFileViewerAdapter", 1, "canAutoPreview: parse config autoPreviewenable[" + str + "] not correct");
        return false;
      }
      i = 0;
    }
    if (NetworkUtil.g(BaseApplicationImpl.getContext())) {}
    for (str = FMConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "WiFiMaxSize");; str = FMConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3GMaxSize")) {
      try
      {
        i = Integer.parseInt(str);
        if (a() <= i * 1024 * 1024) {
          break;
        }
        return false;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        QLog.w("EntityFileViewerAdapter", 1, "canAutoPreview: parse config autoPreview max size[" + str + "] not correct");
        return false;
      }
    }
    return d();
  }
  
  public String f()
  {
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath;
  }
  
  public String g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.EntityFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */