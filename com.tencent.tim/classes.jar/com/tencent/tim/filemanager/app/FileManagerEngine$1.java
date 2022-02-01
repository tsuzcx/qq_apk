package com.tencent.tim.filemanager.app;

import anaz;
import atso;
import attf;
import attk;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileManagerEngine$1
  implements Runnable
{
  public FileManagerEngine$1(atso paramatso, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, long paramLong) {}
  
  public void run()
  {
    audx.J(this.d);
    if (this.cdp) {
      this.this$0.app.a().a(this.bGW, this.bGX, true, this.bGY, 0L, true, this.bPa, this.bGZ, this.d.msgSeq, this.d.msgSeq, null, this.val$type, this.Yp, this.d.msgUid, -1L, anaz.gQ());
    }
    this.this$0.app.a().w(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.app.FileManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */