import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

class atzu
  implements FilePreviewActivity.a
{
  atzu(atzs paramatzs) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (!paramBoolean)
    {
      QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + paramLong + "], retMeg[" + paramString3 + "]");
      if (this.a.a != null) {
        this.a.a.jM(paramLong);
      }
      if (this.a.e != null) {
        this.a.e.it();
      }
      this.a.mAppInterface.a().u(this.a.c.b());
      return;
    }
    this.a.str_download_dns = paramString1;
    this.a.aEI = paramString2;
    this.a.aEJ = paramString4;
    this.a.aEK = paramString5;
    this.a.a(this.a.str_download_dns, this.a.aEI, this.a.aEJ, audx.d(this.a.c.b()), "/", this.a.aEK, this.a.c.b(), new atzv(this));
  }
  
  public void g(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzu
 * JD-Core Version:    0.7.0.1
 */