package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class WeiyunFileViewerAdapter
  extends FileViewerAdapterBase
{
  private static final String jdField_a_of_type_JavaLangString = "WeiyunFileViewerAdapter";
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private WeiYunFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo;
  
  public WeiyunFileViewerAdapter(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo = paramWeiYunFileInfo;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
  }
  
  public int a()
  {
    return FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public WeiYunFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.g = paramString;
  }
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return -1L;
  }
  
  public String b()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
    }
    FileManagerEntity localFileManagerEntity1;
    do
    {
      return str;
      FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      }
    } while (localFileManagerEntity1 == null);
    a(localFileManagerEntity1);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
  }
  
  public int c()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType;
    }
    for (;;)
    {
      int j = i;
      if (2 == i)
      {
        j = i;
        if (FileUtil.b(b())) {
          j = 3;
        }
      }
      return j;
      FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      }
      if (localFileManagerEntity1 != null)
      {
        a(localFileManagerEntity1);
        i = localFileManagerEntity1.cloudType;
      }
      else
      {
        i = 2;
      }
    }
  }
  
  public long c()
  {
    return MessageCache.a() * 1000L;
  }
  
  public String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
      {
        localObject1 = localObject2;
        if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
        }
      }
    }
    return localObject1;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public int e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public String f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)) {
        return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath;
    }
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    }
    if (localFileManagerEntity1 != null)
    {
      a(localFileManagerEntity1);
      if (FileUtil.b(localFileManagerEntity1.strFilePath)) {
        return localFileManagerEntity1.strFilePath;
      }
      return localFileManagerEntity1.strThumbPath;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.g;
  }
  
  public String g()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.WeiyunFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */