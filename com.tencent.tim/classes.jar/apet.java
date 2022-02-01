import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;

public class apet
  implements aqoi
{
  private apet.a a;
  private aqog b;
  private String bHV;
  private final int cWz;
  private final QQAppInterface mApp;
  private long mFileSize;
  private final int mFileType;
  private boolean mIsHttps;
  private boolean mIsStop = true;
  private final long mSessionId;
  
  public apet(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionId = paramLong1;
    this.cWz = paramInt1;
    this.mFileType = paramInt2;
    this.mFileSize = paramLong2;
    this.mIsHttps = paramBoolean;
    this.bHV = paramString;
  }
  
  public boolean D(String paramString, long paramLong)
  {
    apef.b.i("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.mIsStop = false;
    String str2 = "bytes=" + paramLong + "-";
    aqog localaqog = new aqog(paramString, null, this, true);
    localaqog.setInstanceFollowRedirects(false);
    String str1 = "gprs";
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localaqog.setRequestProperty("Net-type", str1);
    localaqog.setRequestProperty("cache-control", "no-cache");
    if (paramLong != 0L) {
      localaqog.setRequestProperty("Range", str2);
    }
    localaqog.setPriority(5);
    localaqog.SP(true);
    localaqog.fileType = this.mFileType;
    localaqog.busiType = this.cWz;
    localaqog.msgId = String.valueOf(this.mSessionId);
    localaqog.setRequestProperty("Accept-Encoding", "identity");
    if (this.a != null) {
      this.a.a(localaqog);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.mIsHttps) && (str1.startsWith("https")))
    {
      localaqog.mIsHttps = true;
      localaqog.cML = aglb.mp(paramString);
      localaqog.cux = this.bHV;
    }
    localaqog.d = ahav.a();
    this.mApp.getHttpCommunicatort().a(localaqog);
    this.b = localaqog;
    return true;
  }
  
  public void Hp(String paramString)
  {
    if (this.mIsStop) {}
    do
    {
      return;
      apef.b.e("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "] ftn download Redirect. " + paramString);
    } while (this.a == null);
    this.a.IK(paramString);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, aqog paramaqog)
  {
    apef.b.e("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.mIsStop = true;
    if (this.a != null) {
      this.a.b(paramInt, paramString1, paramString2, paramaqog);
    }
  }
  
  public void a(apet.a parama)
  {
    this.a = parama;
  }
  
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    if (this.mIsStop) {}
    long l;
    do
    {
      do
      {
        return;
        if (paramaqog1 == this.b) {
          break;
        }
        if ((paramaqog1 != null) && (this.b != null))
        {
          apef.b.e("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "],Req Serial[" + String.valueOf(paramaqog1.Mk()) + "], curRequest Serial[" + String.valueOf(this.b.Mk()) + "]");
          return;
        }
        if (paramaqog1 != null)
        {
          apef.b.e("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "],Req Serial[" + String.valueOf(paramaqog1.Mk()) + "]");
          return;
        }
      } while (this.b == null);
      apef.b.e("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "],curRequest Serial[" + String.valueOf(this.b.Mk()) + "]");
      return;
      if ((paramaqog2.getResponseCode() != 206) && (paramaqog2.getResponseCode() != 200)) {
        break;
      }
      paramaqog1 = paramaqog2.aB();
      l = paramaqog2.hR();
      if (this.mFileSize == 0L) {
        this.mFileSize = l;
      }
    } while (this.a == null);
    this.a.a(paramaqog1, l, paramaqog2.cuv);
    return;
    apef.b.e("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "] ftn download decode resp code no 200|206");
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.mIsStop) {}
    }
    while ((3 != paramInt) || (this.mIsStop) || (this.a == null))
    {
      do
      {
        return true;
        this.mIsStop = true;
      } while (this.a == null);
      this.a.onEnd();
      return true;
    }
    this.a.e(paramaqog2);
    return true;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    if (this.mIsStop) {
      return;
    }
    if (paramaqog2 != null)
    {
      a(paramaqog2.errCode, paramaqog2.getErrorString(), paramaqog2.cuw, paramaqog2);
      return;
    }
    a(9001, "err no response", "", null);
  }
  
  public void cancel()
  {
    this.mIsStop = true;
    if (this.b != null)
    {
      apef.b.i("FtnDownloader", apef.b.USR, "[" + this.mSessionId + "] cancel ftn download");
      this.mApp.getHttpCommunicatort().f(this.b);
      this.b = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void IK(String paramString);
    
    public abstract void a(aqog paramaqog);
    
    public abstract void a(byte[] paramArrayOfByte, long paramLong, String paramString);
    
    public abstract void b(int paramInt, String paramString1, String paramString2, aqog paramaqog);
    
    public abstract void e(aqog paramaqog);
    
    public abstract void onEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apet
 * JD-Core Version:    0.7.0.1
 */