package com.tencent.mobileqq.filemanager.activity.fileviewer.troopfile;

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
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import fyd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TroopFileViewerActivity
  extends BaseFileViewerActivity
{
  static final String jdField_a_of_type_JavaLangString = "<FileAssistant>TroopFileViewerActivity";
  int jdField_a_of_type_Int = 0;
  TroopFileController jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerTroopfileTroopFileController = null;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fyd(this);
  public FileManagerEntity a;
  public ForwardFileInfo a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public TroopFileViewerActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = new ForwardFileInfo();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected IFileViewerController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerTroopfileTroopFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerTroopfileTroopFileController = new TroopFileController(this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerTroopfileTroopFileController;
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
      QLog.e("<FileAssistant>TroopFileViewerActivity", 1, "<FileAssistant>TroopFileViewerActivitynot found, bug. sessionid:" + String.valueOf(l));
      finish();
      return false;
    }
    g();
    this.b.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.b.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    super.doOnDestroy();
  }
  
  public void g()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 0) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a())
    {
    default: 
      h();
    }
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = (FileViewerImageInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId == ((FileViewerImageInfo)localObject).jdField_a_of_type_Long) {
        this.jdField_a_of_type_Int = i;
      }
      i += 1;
      continue;
      localObject = FMDataCache.a();
      int j = getIntent().getIntExtra("clicked_file_hashcode", 0);
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        h();
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
        if (localFileInfo.hashCode() == j) {
          a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        } else if (FileManagerUtil.a(localFileInfo.d()) == 0) {
          a(FileManagerUtil.a(localFileInfo));
        }
      }
      FMDataCache.a();
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.troopfile.TroopFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */