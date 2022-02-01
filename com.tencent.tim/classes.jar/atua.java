import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class atua
  implements aqoi, attz
{
  private atty a;
  private aqog b;
  private final int cWz;
  private final QQAppInterface mApp;
  private final int mFileType;
  private boolean mIsStop;
  private final long mSessionId;
  
  private atua(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionId = paramLong;
    this.cWz = paramInt1;
    this.mFileType = paramInt2;
  }
  
  public static atua a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new atua(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void Hp(String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    this.a.IK(paramString);
  }
  
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    if (this.mIsStop) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.mSessionId) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (paramaqog1 == this.b) {
        break;
      }
      if ((paramaqog1 != null) && (this.b != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],Req Serial[" + String.valueOf(paramaqog1.Mk()) + "], curRequest Serial[" + String.valueOf(this.b.Mk()) + "]");
        return;
      }
      if (paramaqog1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],Req Serial[" + String.valueOf(paramaqog1.Mk()) + "]");
        return;
      }
    } while (this.b == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],curRequest Serial[" + String.valueOf(this.b.Mk()) + "]");
    return;
    if (paramaqog2.getResponseCode() == 200) {
      if (paramaqog2.pK("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(paramaqog2.pK("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.a.M(paramaqog2.errCode, paramaqog2.getErrorString(), paramaqog2.cuw);
        return;
      }
      paramaqog1 = paramaqog2.pK("Range");
      if (paramaqog1 == null)
      {
        this.a.cs(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(paramaqog1);
      this.a.at(l, paramaqog2.cuw);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.mSessionId) + "],decode but response Code [" + paramaqog2.getResponseCode() + "] is not 200");
      return;
    }
  }
  
  public void a(atty paramatty)
  {
    this.a = paramatty;
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.b = new aqog(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.b.setInstanceFollowRedirects(false);
    this.b.setRequestProperty("cache-control", "no-cache");
    paramString = "gprs";
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.b.setRequestProperty("Net-type", paramString);
    this.b.setRequestProperty("Range", "bytes=" + paramLong + "-");
    this.b.setRequestMethod("POST");
    this.b.setPriority(1);
    this.b.fileType = this.mFileType;
    this.b.busiType = this.cWz;
    this.b.msgId = String.valueOf(this.mSessionId);
    this.mApp.getHttpCommunicatort().a(this.b);
    return true;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    if (this.mIsStop) {
      return;
    }
    this.a.M(paramaqog2.errCode, paramaqog2.getErrorString(), paramaqog2.cuw);
  }
  
  public void cancel()
  {
    this.mIsStop = true;
    if (this.b != null)
    {
      this.mApp.getHttpCommunicatort().f(this.b);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atua
 * JD-Core Version:    0.7.0.1
 */