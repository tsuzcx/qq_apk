import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class apfa
  implements apee.a, apet.a, apeu
{
  protected final apee a;
  protected apet a;
  protected apev a;
  protected long aro;
  protected long arp;
  protected String bHE;
  protected long bz;
  protected boolean cQi = true;
  private boolean cQj;
  protected int dTX;
  protected FileOutputStream m;
  protected String mCookie;
  protected long mFileSize;
  protected String mIp;
  public boolean mIsStop = true;
  protected int mPort;
  protected String mSavePath;
  public final long mSessionId;
  protected long mStartTime;
  
  protected apfa(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.mSessionId = paramLong1;
    this.mFileSize = paramLong2;
    this.mSavePath = paramString1;
    this.jdField_a_of_type_Apee = new apee(paramQQAppInterface, paramList, paramString2, this.mSessionId, paramBoolean, this);
    this.bHE = this.jdField_a_of_type_Apee.Ba();
    paramString1 = apef.a(this.bHE);
    if (paramString1 != null)
    {
      this.mIp = paramString1.ip;
      this.mPort = paramString1.port;
      this.dTX = paramString1.proxyType;
    }
    this.mCookie = paramString3;
    this.jdField_a_of_type_Apet = new apet(paramQQAppInterface, paramLong1, 1, 0, paramLong2, paramBoolean, paramString4);
    this.jdField_a_of_type_Apet.a(this);
  }
  
  public static apeu a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      apef.b.e("TroopFileDownloader", apef.b.USR, "getFileDownloader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strSavePath is empty";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString2 == null) {
        str = "urlParams is null";
      } else if (paramString2.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new apfa(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  private void dZf()
  {
    if (this.mIsStop) {
      return;
    }
    apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] reDownload mstrUrl:" + this.bHE);
    dZe();
    if (this.jdField_a_of_type_Apev != null) {
      this.jdField_a_of_type_Apev.dYT();
    }
    this.bz = ahav.getFileSizes(this.mSavePath);
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      g(true, 9004, "no net work", "");
      return;
    }
    dZc();
  }
  
  private boolean mn(String paramString)
  {
    return (paramString.indexOf("-6101") > 0) || (paramString.indexOf("-7003") > 0) || (paramString.indexOf("-403") > 0) || (paramString.indexOf("-9006") > 0) || (paramString.indexOf("-9004") > 0) || (paramString.indexOf("-9017") > 0) || (paramString.indexOf("-29150") > 0) || (paramString.indexOf("-28137") > 0);
  }
  
  private boolean qs(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717")));
  }
  
  private boolean qt(String paramString)
  {
    return (paramString.indexOf("-29120") > 0) || (paramString.indexOf("-502") > 0) || (paramString.indexOf("HTTP_PROXY_AUTH") > 0) || (paramString.indexOf("-21122") > 0) || (paramString.indexOf("-28123") > 0) || (paramString.indexOf("-25081") > 0) || (paramString.indexOf("-28126") > 0);
  }
  
  public int EA()
  {
    return this.mPort;
  }
  
  public int Ez()
  {
    return this.jdField_a_of_type_Apee.Ez();
  }
  
  public void IK(String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    g(true, 9062, "net redirect", "");
  }
  
  public void SO(String paramString)
  {
    if (this.mIsStop)
    {
      apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] onRetry but stoped");
      return;
    }
    int i = 0;
    if (!this.bHE.equalsIgnoreCase(paramString))
    {
      i = 1;
      apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] onRetry urlChanged");
    }
    this.bHE = paramString;
    if (i != 0)
    {
      paramString = apef.a(this.bHE);
      if (paramString != null)
      {
        this.mIp = paramString.ip;
        this.mPort = paramString.port;
        this.dTX = paramString.proxyType;
      }
      this.jdField_a_of_type_Apev.IC(this.bHE);
    }
    dZf();
  }
  
  public void a(apev paramapev)
  {
    this.jdField_a_of_type_Apev = paramapev;
  }
  
  public void a(aqog paramaqog)
  {
    paramaqog.setRequestProperty("User-Agent", "TroopFile");
    if (!TextUtils.isEmpty(this.mCookie)) {
      paramaqog.setRequestProperty("Cookie", "FTN5K=" + this.mCookie);
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    if (this.mIsStop) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.mFileSize == 0L) && (paramLong != 0L))
          {
            apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] onData getted filesize=" + paramLong);
            this.mFileSize = paramLong;
          }
        } while ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0));
        try
        {
          this.m.write(paramArrayOfByte);
          paramLong = paramArrayOfByte.length;
          this.bz += paramLong;
          this.arp = (paramLong + this.arp);
          if (!this.cQj)
          {
            this.cQj = true;
            this.jdField_a_of_type_Apee.SN(this.bHE);
          }
          if (this.bz == this.mFileSize)
          {
            dYX();
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          if (paramArrayOfByte.getMessage().contains("ENOSPC")) {}
          g(true, 9301, "write exception", paramString);
          return;
        }
        if (this.bz > this.mFileSize)
        {
          g(true, -5001, "transfersize > filesize", paramString);
          return;
        }
      } while (!this.cQi);
      paramLong = System.currentTimeMillis();
    } while (((this.aro != 0L) && (paramLong - this.aro < 1000L)) || (this.jdField_a_of_type_Apev == null));
    this.jdField_a_of_type_Apev.onDownloadProgress(this.bz, this.mFileSize);
  }
  
  public boolean aAW()
  {
    if (!arug.cC())
    {
      g(true, 9039, "no sdcard", null);
      return true;
    }
    VFSFile localVFSFile = new VFSFile(this.mSavePath);
    if (!localVFSFile.exists()) {}
    try
    {
      localVFSFile.createNewFile();
      this.bz = ahav.getFileSizes(this.mSavePath);
      if (this.mFileSize == 0L)
      {
        apef.b.w("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] checkexcpover fileSize=0");
        return false;
      }
    }
    catch (IOException localIOException)
    {
      g(true, -5000, "create new file excption", null);
      return true;
    }
    if (this.bz > this.mFileSize)
    {
      new VFSFile(this.mSavePath).delete();
      this.bz = 0L;
    }
    long l1;
    long l2;
    do
    {
      return false;
      if (this.bz == this.mFileSize)
      {
        apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] checkexcpover tmpfilesize=filesize");
        dYX();
        return true;
      }
      l1 = this.mFileSize;
      l2 = this.bz;
    } while (ahaf.a().gc() >= l1 - l2);
    g(true, 9040, "no enugh space", null);
    return true;
  }
  
  public boolean aAX()
  {
    closeOutputStream();
    try
    {
      this.m = new FileOutputStream(this.mSavePath, true);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      apef.b.e("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] openOutputStream excp");
      this.m = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public boolean alZ()
  {
    return this.jdField_a_of_type_Apee.alZ();
  }
  
  public void b(int paramInt, String paramString1, String paramString2, aqog paramaqog)
  {
    if (this.mIsStop) {
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      g(true, -29602, paramString1, paramString2);
      return;
    }
    if ((paramaqog != null) && (paramaqog.f != null) && (qs(paramaqog.f.getHeaderField("User-ReturnCode"))))
    {
      g(true, -5003, paramString1, paramString2);
      return;
    }
    if (mn(paramString1))
    {
      g(true, 9042, paramString1, paramString2);
      return;
    }
    if (("content zero".equalsIgnoreCase(paramString1)) && (paramString2 != null) && (paramString2.indexOf("-31713") > 0))
    {
      g(true, 9042, paramString1, paramString2);
      return;
    }
    if (paramString1.contains("SSLPeerUnverifiedException"))
    {
      g(true, paramInt, paramString1, paramString2);
      return;
    }
    if (qt(paramString1)) {
      paramInt = 9042;
    }
    for (boolean bool = true;; bool = false)
    {
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        g(true, 9004, paramString1, paramString2);
        return;
      }
      this.cQj = false;
      apef.b.e("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] onErr errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
      if (this.jdField_a_of_type_Apee.g(this.bHE, paramInt, bool))
      {
        g(false, paramInt, paramString1, paramString2);
        return;
      }
      g(true, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void bme()
  {
    apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] cancelTask");
    this.mIsStop = true;
    closeOutputStream();
    dZd();
  }
  
  protected void closeOutputStream()
  {
    if (this.m != null) {}
    try
    {
      this.m.close();
      this.m = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        apef.b.e("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] closeOutputStream excp");
        localIOException.printStackTrace();
      }
    }
  }
  
  protected void dYX()
  {
    this.mIsStop = true;
    closeOutputStream();
    dZd();
    long l = System.currentTimeMillis();
    apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] onSuc. cost:" + (l - this.mStartTime));
    if (this.jdField_a_of_type_Apev != null) {
      this.jdField_a_of_type_Apev.onDownloadSuccess(this.mSavePath);
    }
  }
  
  public void dZc()
  {
    dZd();
    this.jdField_a_of_type_Apet.D(this.bHE, this.bz);
  }
  
  protected void dZd()
  {
    this.jdField_a_of_type_Apet.cancel();
  }
  
  protected void dZe()
  {
    if (this.m != null) {}
    try
    {
      this.m.flush();
      this.arp = 0L;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        apef.b.e("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] flushOutputStream excp");
        localIOException.printStackTrace();
      }
    }
  }
  
  public void download()
  {
    this.mIsStop = false;
    this.mStartTime = System.currentTimeMillis();
    apef.b.i("TroopFileDownloader", apef.b.USR, "[" + this.mSessionId + "] download url:" + this.bHE);
    ThreadManager.post(new TroopFileDownloader.1(this), 8, null, false);
  }
  
  public void e(aqog paramaqog) {}
  
  public void g(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    long l = 0L;
    if (paramBoolean)
    {
      this.mIsStop = true;
      closeOutputStream();
      dZd();
      l = System.currentTimeMillis();
    }
    int i = apef.b.USR;
    StringBuilder localStringBuilder = new StringBuilder().append("[").append(this.mSessionId).append("] onErr errCode:").append(paramInt).append(" bFinished:").append(paramBoolean).append(" errMsg:").append(paramString1).append(" rspHeader:").append(paramString2).append(" cost:");
    if (paramBoolean) {}
    for (Object localObject = Long.valueOf(l - this.mStartTime);; localObject = "")
    {
      apef.b.e("TroopFileDownloader", i, localObject);
      if (this.jdField_a_of_type_Apev != null) {
        this.jdField_a_of_type_Apev.a(paramBoolean, this.bz, paramInt, paramString1, paramString2, new Bundle());
      }
      return;
    }
  }
  
  public int getProxyType()
  {
    return this.dTX;
  }
  
  public String getUrl()
  {
    return this.bHE;
  }
  
  public long hq()
  {
    return 100L;
  }
  
  public void onEnd() {}
  
  public String vz()
  {
    return this.mIp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfa
 * JD-Core Version:    0.7.0.1
 */