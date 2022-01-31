package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class LocalFileViewerAdapter
  extends FileViewerAdapterBase
{
  private static final String jdField_a_of_type_JavaLangString = "LocalFileViewerAdapter";
  private FileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
  
  public LocalFileViewerAdapter(FileInfo paramFileInfo)
  {
    this.a = paramFileInfo;
  }
  
  public int a()
  {
    if (this.a.b() == 5) {
      return 5;
    }
    return FileManagerUtil.a(this.a.e());
  }
  
  public long a()
  {
    return this.a.a();
  }
  
  public FileManagerEntity a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getEntity should not be called on LocalFileViewAdapter");
    }
    return null;
  }
  
  public WeiYunFileInfo a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getWeiyunInfo should not be called on LocalFileViewAdapter");
    }
    return null;
  }
  
  public String a()
  {
    return this.a.e();
  }
  
  public void a(String paramString) {}
  
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
    return this.a.d();
  }
  
  public int c()
  {
    return 3;
  }
  
  public long c()
  {
    return MessageCache.a() * 1000L;
  }
  
  public String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.b() == 5)
    {
      localObject1 = localObject2;
      if (FileUtil.b(this.a.d())) {
        localObject1 = this.a.d();
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
      QLog.w("LocalFileViewerAdapter", 4, "getFileStatus: has not status");
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
      QLog.w("LocalFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public String e()
  {
    return null;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public String f()
  {
    return this.a.d();
  }
  
  public String g()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.LocalFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */