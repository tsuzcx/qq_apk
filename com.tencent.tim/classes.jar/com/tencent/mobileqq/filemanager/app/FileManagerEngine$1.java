package com.tencent.mobileqq.filemanager.app;

import aghw;
import agkf;
import agkj;
import ahav;
import anaz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileManagerEngine$1
  implements Runnable
{
  public FileManagerEngine$1(aghw paramaghw, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, long paramLong) {}
  
  public void run()
  {
    ahav.J(this.d);
    if (this.cdp) {
      this.this$0.app.a().a(this.bGW, this.bGX, true, this.bGY, 0L, true, this.bPa, this.bGZ, this.d.msgSeq, this.d.msgSeq, null, this.val$type, this.Yp, this.d.msgUid, -1L, anaz.gQ());
    }
    if (this.cdp) {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.d.nSessionId + "] SendLocalfile[" + this.d.fileName + "], peerType[" + this.d.peerType + "]");
    }
    for (;;)
    {
      this.this$0.app.a().w(this.d);
      return;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.d.nSessionId + "] SendLocalfileToWeiyun[" + this.d.fileName + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */