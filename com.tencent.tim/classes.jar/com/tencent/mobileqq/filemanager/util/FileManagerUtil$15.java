package com.tencent.mobileqq.filemanager.util;

import agkf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public final class FileManagerUtil$15
  implements Runnable
{
  public FileManagerUtil$15(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    this.val$app.a().a(this.b.peerUin, this.val$app.getCurrentAccountUin(), this.b.peerType, -3014, BaseApplicationImpl.getContext().getString(2131693858));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.15
 * JD-Core Version:    0.7.0.1
 */