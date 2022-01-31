package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;

public abstract class FilePreViewControllerBase
{
  public FilePreviewActivity.ControlerCallback a;
  
  public abstract int a();
  
  public void a(FilePreviewActivity.ControlerCallback paramControlerCallback)
  {
    this.a = paramControlerCallback;
  }
  
  public abstract boolean a();
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase
 * JD-Core Version:    0.7.0.1
 */