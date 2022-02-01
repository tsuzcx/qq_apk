package com.tencent.tim.filemanager.core;

import atsq;
import attm;
import audi;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.UnsupportedEncodingException;

public class FileManagerRSWorker$9
  implements Runnable
{
  public void run()
  {
    audi localaudi = new audi();
    localaudi.bJz = this.this$0.strUin;
    localaudi.fileSize = this.this$0.nFileSize;
    this.this$0.dO = audx.t(this.this$0.strFilePath);
    this.this$0.dP = audx.x(this.this$0.strFilePath);
    this.this$0.dQ = audx.B(this.this$0.strFilePath);
    if ((this.this$0.dQ == null) || (this.this$0.dQ == null) || (this.this$0.dQ == null))
    {
      this.this$0.j(null, 0);
      return;
    }
    localaudi.md5 = this.this$0.dO;
    localaudi.sha1 = this.this$0.dP;
    localaudi.el = this.this$0.dQ;
    try
    {
      localaudi.ej = audx.getFileName(this.this$0.strFilePath).getBytes("utf-8");
      localaudi.ei = this.this$0.strFilePath.getBytes("utf-8");
      this.this$0.app.a().b(localaudi, attm.a(this.this$0), this.this$0.c);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerRSWorker.9
 * JD-Core Version:    0.7.0.1
 */