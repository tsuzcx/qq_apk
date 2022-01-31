package com.tencent.mobileqq.filemanager.activity.fileviewer.qfile;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerImageInfo;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.IFileViewerController;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import fto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class QfileFileViewerActivity
  extends BaseFileViewerActivity
{
  static final String jdField_a_of_type_JavaLangString = "<FileAssistant>QfileFileViewerActivity";
  int jdField_a_of_type_Int = 0;
  QfileFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileController = null;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fto(this);
  public FileManagerEntity a;
  public ForwardFileInfo a;
  public List a;
  
  public QfileFileViewerActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = new ForwardFileInfo();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected IFileViewerController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileController = new QfileFileController(this.b, this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerQfileQfileFileController;
  }
  
  protected String a(Object paramObject)
  {
    paramObject = (FileManagerEntity)paramObject;
    if (FileUtil.b(paramObject.strFilePath)) {
      return paramObject.strFilePath;
    }
    return paramObject.strThumbPath;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileViewerImageInfo localFileViewerImageInfo = (FileViewerImageInfo)localIterator.next();
      if (localFileViewerImageInfo.jdField_a_of_type_Long == paramLong) {
        localFileViewerImageInfo.jdField_a_of_type_Boolean = paramBoolean;
      }
    }
  }
  
  void a(FileManagerEntity paramFileManagerEntity)
  {
    FileViewerImageInfo localFileViewerImageInfo = new FileViewerImageInfo();
    localFileViewerImageInfo.jdField_a_of_type_Long = paramFileManagerEntity.nSessionId;
    localFileViewerImageInfo.jdField_a_of_type_JavaLangObject = paramFileManagerEntity;
    this.jdField_a_of_type_JavaUtilList.add(localFileViewerImageInfo);
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)getIntent().getParcelableExtra("fileinfo"));
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.b.a().a(l);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivitynot found, bug. sessionid:" + String.valueOf(l));
      finish();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 0) {
        break label166;
      }
    }
    label166:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 5)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 1) {
          j = 0;
        }
      }
      if (j != 0) {
        g();
      }
      for (;;)
      {
        this.b.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return true;
        j = 1;
        break;
        h();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("<FileAssistant>QfileFileViewerActivity", 2, ">>>>QfileFileViewerActivity<<<< doOnDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.b.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    super.doOnDestroy();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 0) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a())
    {
    case 10005: 
    default: 
      h();
    }
    for (;;)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject1 = (FileViewerImageInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId == ((FileViewerImageInfo)localObject1).jdField_a_of_type_Long) {
          this.jdField_a_of_type_Int = i;
        }
        i += 1;
      }
      Object localObject1 = FMDataCache.a();
      i = getIntent().getIntExtra("clicked_file_hashcode", 0);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        h();
        return;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileInfo)((Iterator)localObject1).next();
        if (((FileInfo)localObject2).hashCode() == i) {
          a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        } else if (FileManagerUtil.a(((FileInfo)localObject2).d()) == 0) {
          a(FileManagerUtil.a((FileInfo)localObject2));
        }
      }
      FMDataCache.a();
      continue;
      localObject1 = getIntent().getParcelableArrayListExtra("local_offline_list");
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "offline fileList is null??????????????????");
        h();
        return;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (OfflineFileInfo)((Iterator)localObject1).next();
        if ((((OfflineFileInfo)localObject2).a != null) && (((OfflineFileInfo)localObject2).a.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid))) {
          a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        } else if (FileManagerUtil.a(((OfflineFileInfo)localObject2).b) == 0) {
          a(FileManagerUtil.a((OfflineFileInfo)localObject2, 0));
        }
      }
      localObject1 = getIntent().getParcelableArrayListExtra("local_weiyun_list");
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "weiyun fileList is null??????????????????");
        h();
        return;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if ((((WeiYunFileInfo)localObject2).a != null) && (((WeiYunFileInfo)localObject2).a.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId))) {
          a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        } else if (FileManagerUtil.a(((WeiYunFileInfo)localObject2).b) == 0) {
          a(FileManagerUtil.a((WeiYunFileInfo)localObject2));
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() == 10001)
      {
        localObject1 = this.b.a().a().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
          if ((FileManagerUtil.a(((FileManagerEntity)localObject2).fileName) == 0) && (((FileManagerEntity)localObject2).cloudType != 0) && ((((FileManagerEntity)localObject2).cloudType != 5) || (((FileManagerEntity)localObject2).status == 1))) {
            a((FileManagerEntity)localObject2);
          }
        }
        localObject1 = getIntent().getStringArrayListExtra("Aio_Uinseq_ImageList");
        if (localObject1 == null)
        {
          h();
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          long l = Long.parseLong((String)((Iterator)localObject1).next());
          localObject2 = this.b.a().a(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, -1L);
          if ((FileManagerUtil.a(((FileManagerEntity)localObject2).fileName) == 0) && (((FileManagerEntity)localObject2).cloudType != 0) && ((((FileManagerEntity)localObject2).cloudType != 5) || (((FileManagerEntity)localObject2).status == 1))) {
            a((FileManagerEntity)localObject2);
          }
        }
      }
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 0) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */