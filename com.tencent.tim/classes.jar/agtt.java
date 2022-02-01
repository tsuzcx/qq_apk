import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.qphone.base.util.QLog;

class agtt
  implements FilePreviewActivity.a
{
  agtt(agts paramagts, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
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
    paramString2 = "";
    short s;
    if (paramBundle != null) {
      if (this.cYJ == 3000)
      {
        paramBoolean = agmx.aK(this.a.mAppInterface);
        paramString1 = paramBundle.getString("httpsdomain");
        if ((TextUtils.isEmpty(paramString1)) || (!paramBoolean)) {
          break label316;
        }
        paramBoolean = true;
        s = paramBundle.getShort("httpsport");
        label210:
        paramString2 = paramBundle.getString("ipv6domain", "");
      }
    }
    for (;;)
    {
      this.a.a(this.a.str_download_dns, this.a.aEI, this.a.aEJ, ahav.d(this.a.c.b()), "/", this.a.aEK, this.a.c.b(), paramBoolean, paramString1, s, paramString2, new agtu(this, paramBoolean, paramString1, s));
      return;
      paramBoolean = agmx.aG(this.a.mAppInterface);
      break;
      label316:
      paramString1 = null;
      s = 0;
      paramBoolean = false;
      break label210;
      paramString1 = null;
      s = 0;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtt
 * JD-Core Version:    0.7.0.1
 */