package com.tencent.mobileqq.filemanager.core;

import agib;
import agkl;
import agzw;
import ahav;
import anaz;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class FileManagerRSWorker$8
  implements Runnable
{
  public FileManagerRSWorker$8(agkl paramagkl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + anaz.gQ());
    }
    agzw localagzw = new agzw();
    localagzw.bJz = this.this$0.strUin;
    localagzw.fileSize = this.this$0.nFileSize;
    this.this$0.dO = ahav.t(this.this$0.strFilePath);
    this.this$0.dP = ahav.x(this.this$0.strFilePath);
    this.this$0.dQ = ahav.B(this.this$0.strFilePath);
    if ((this.this$0.dO == null) || (this.this$0.dP == null) || (this.this$0.dQ == null))
    {
      this.this$0.j(null, 0);
      return;
    }
    this.this$0.c.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.dQ);
    this.this$0.c.str10Md5 = HexUtil.bytes2HexStr(this.this$0.dO);
    localagzw.md5 = this.this$0.dO;
    localagzw.sha1 = this.this$0.dP;
    localagzw.el = this.this$0.dQ;
    try
    {
      localagzw.ej = ahav.getFileName(this.this$0.strFilePath).getBytes("utf-8");
      localagzw.ei = this.this$0.strFilePath.getBytes("utf-8");
      this.this$0.app.a().b(localagzw, agkl.a(this.this$0), this.this$0.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8
 * JD-Core Version:    0.7.0.1
 */