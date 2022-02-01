package com.tencent.mobileqq.filemanager.util;

import agkf;
import agkh;
import agoy;
import ahav;
import ahav.f;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class FileManagerUtil$20$1$1
  implements Runnable
{
  FileManagerUtil$20$1$1(FileManagerUtil.20.1 param1, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    String str = this.o.getFilePath();
    this.a.this$0.b.strFileSha3 = agoy.t(ahav.A(str));
    QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, set file download sucessed!");
    this.a.this$0.b.status = 1;
    this.a.this$0.b.cloudType = 3;
    this.a.this$0.b.setFilePath(this.o.getFilePath());
    this.a.this$0.val$app.a().u(this.a.this$0.b);
    this.a.this$0.val$app.a().a(this.a.this$0.b.uniseq, this.a.this$0.b.nSessionId, this.a.this$0.b.peerUin, this.a.this$0.b.peerType, 11, new Object[] { this.a.this$0.b.getFilePath(), Long.valueOf(this.a.this$0.b.fileSize), Boolean.valueOf(true), "" }, 0, null);
    if (this.a.this$0.a != null) {
      this.a.this$0.a.JC(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.20.1.1
 * JD-Core Version:    0.7.0.1
 */