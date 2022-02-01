package com.tencent.mobileqq.filemanager.discoperation;

import agib;
import agkf;
import agkh;
import agov;
import agoy;
import agoz;
import ahav;
import anaz;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DiscFileOperator$2
  implements Runnable
{
  public DiscFileOperator$2(agov paramagov) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "run sendFile:" + anaz.gQ());
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.this$0.c.status = 0;
      this.this$0.app.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 1, null, 2, null);
      this.this$0.a.Zs = 9004L;
      this.this$0.a.strErrMsg = "NoNetWork";
      this.this$0.a.diD();
      this.this$0.app.a().u(this.this$0.c);
    }
    do
    {
      return;
      if (this.this$0.ceF)
      {
        QLog.w("DiscFileOperator<FileAssistant>", 1, "nID[" + this.this$0.c.nSessionId + "] user canceled!");
        return;
      }
      String str1 = null;
      if ((this.this$0.c.strFileMd5 == null) || (this.this$0.c.strFileMd5.length() != 32))
      {
        str1 = agoy.t(ahav.t(this.this$0.c.getFilePath()));
        this.this$0.c.strFileMd5 = str1;
      }
      String str2 = null;
      if ((this.this$0.c.strFileMd5 == null) || (this.this$0.c.strFileMd5.length() != 40))
      {
        str2 = agoy.t(ahav.x(this.this$0.c.getFilePath()));
        this.this$0.c.strFileSHA = str2;
      }
      this.this$0.c.status = 0;
      this.this$0.app.a().u(this.this$0.c);
      this.this$0.c.status = 2;
      this.this$0.a.strMd5 = str1;
      this.this$0.a.bII = str2;
      this.this$0.a.Zt = System.currentTimeMillis();
      this.this$0.app.a().a(this.this$0.c.strFileMd5, this.this$0.c.strFileSHA, this.this$0.c.fileName, this.this$0.c.fileSize, this.this$0.c.peerUin, this.this$0.app.getCurrentAccountUin(), this.this$0);
    } while (!QLog.isColorLevel());
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nID[" + this.this$0.c.nSessionId + "]Send CS Request!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator.2
 * JD-Core Version:    0.7.0.1
 */