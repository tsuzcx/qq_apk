package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.EntityFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.LocalFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.WeiyunFileViewerAdapter;

public abstract class FileViewerAdapterBase
  implements IFileViewerAdapter
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  static IFileViewerAdapter a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new EntityFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
  }
  
  static IFileViewerAdapter a(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    return new WeiyunFileViewerAdapter(paramQQAppInterface, paramWeiYunFileInfo);
  }
  
  static IFileViewerAdapter a(FileInfo paramFileInfo)
  {
    return new LocalFileViewerAdapter(paramFileInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return this.c;
  }
  
  public boolean i()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase
 * JD-Core Version:    0.7.0.1
 */