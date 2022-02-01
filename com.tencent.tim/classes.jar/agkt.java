import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class agkt
  implements ahae.a
{
  agkt(agkl paramagkl) {}
  
  public void NW(int paramInt)
  {
    this.this$0.setStatus(2005);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 12, null, paramInt, null);
    ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 9040L, "", this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.a(this.this$0), "sdcard full", null);
    ahav.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, agkl.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, 9040L, "", this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, agkl.a(this.this$0), "", agkl.b(this.this$0), "sdcard full", null);
  }
  
  public void at(long paramLong1, long paramLong2) {}
  
  public void dhx()
  {
    this.this$0.vc();
  }
  
  public void fG(String paramString1, String paramString2)
  {
    if (this.this$0.bHJ.equalsIgnoreCase(paramString1)) {
      this.this$0.bHJ = paramString2;
    }
    while (!this.this$0.strFilePath.equalsIgnoreCase(paramString1)) {
      return;
    }
    this.this$0.strFilePath = paramString2;
    this.this$0.c.setFilePath(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkt
 * JD-Core Version:    0.7.0.1
 */