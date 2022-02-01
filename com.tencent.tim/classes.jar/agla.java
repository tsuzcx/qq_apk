import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class agla
  implements aqoi
{
  private long YO = -1L;
  private long YP;
  private long YQ;
  private agla.a a;
  private QQAppInterface app;
  private String bHW;
  private aqog c;
  private final int cXC = 3;
  private int cXD;
  private int cXE;
  private FileOutputStream h;
  private String mCookie;
  private String mFileName;
  private long mFileSize;
  private int mRetryTimes;
  private long mStartTime;
  private String mUrl;
  
  public agla(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void Ji(boolean paramBoolean)
  {
    this.YP = 0L;
    try
    {
      if (this.h != null)
      {
        this.h.close();
        this.h = null;
        QLog.i("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.YO + " closeFileStream");
      }
      for (;;)
      {
        if (this.c != null) {
          this.app.getHttpCommunicatort().f(this.c);
        }
        if (paramBoolean) {
          ahbj.deleteFile(this.bHW);
        }
        return;
        QLog.w("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.YO + " closeFileStream had closed: stream = null");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.h = null;
        QLog.e("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.YO + " closeFileStream");
        localIOException.printStackTrace();
      }
    }
  }
  
  private void dhC()
  {
    if (this.h == null) {}
    try
    {
      QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.YO + "] runDownload...tmpname[" + String.valueOf(this.bHW) + "]");
      this.h = new FileOutputStream(this.bHW, true);
      aqog localaqog = new aqog(this.mUrl, null, this, true);
      String str = "gprs";
      if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localaqog.setRequestProperty("Net-type", str);
      localaqog.setRequestProperty("Range", "bytes=0-");
      localaqog.setPriority(5);
      localaqog.SP(true);
      localaqog.fileType = 0;
      localaqog.busiType = 0;
      localaqog.msgId = String.valueOf(this.YO);
      QLog.d("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.YO + "] start runDownload... , url[" + this.mUrl + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localaqog.busiType) + "]");
      localaqog.setRequestProperty("Accept-Encoding", "identity");
      if (!TextUtils.isEmpty(this.mCookie)) {
        localaqog.setRequestProperty("Cookie", this.mCookie);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ZipThumbDownloader", 1, "cookie:" + this.mCookie);
      }
      this.app.getHttpCommunicatort().a(localaqog);
      this.c = localaqog;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      do
      {
        Ji(true);
      } while (this.a == null);
      this.a.a(this.mUrl, false, -2, null, this.YO);
    }
  }
  
  public void Hp(String paramString) {}
  
  public void a(long paramLong, String paramString1, String paramString2, agla.a parama)
  {
    this.YO = paramLong;
    this.mUrl = paramString2;
    this.mFileName = paramString1;
    this.bHW = (paramString1 + ".tmp");
    this.a = parama;
    QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.YO + "] add WaitDowloadTask waiting...");
    this.mStartTime = System.currentTimeMillis();
    ThreadManager.post(new HttpThumbDownloader.1(this), 8, null, false);
  }
  
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    boolean bool = false;
    long l1 = -1L;
    if (paramaqog2 != null) {
      l1 = Long.parseLong(paramaqog2.msgId);
    }
    if (l1 != this.YO) {
      QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + " but [currentTaskId] = " + this.YO);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramaqog2 != null) {
            break;
          }
          QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + "] decode resp = null ");
          Ji(true);
        } while (this.a == null);
        this.a.a(this.mUrl, false, -7, null, this.YO);
        return;
      } while ((paramaqog2.getResponseCode() != 206) && (paramaqog2.getResponseCode() != 200));
      if (this.h != null) {
        break;
      }
      Ji(true);
    } while (this.a == null);
    this.a.a(this.mUrl, false, -8, null, this.YO);
    return;
    for (;;)
    {
      try
      {
        this.h.write(paramaqog2.aB());
        if (0L == this.mFileSize)
        {
          long l2 = paramaqog2.hR();
          QLog.i("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + "]  [thumb Size] = " + String.valueOf(l2));
          this.mFileSize = l2;
        }
        this.YQ = paramaqog2.aB().length;
        this.YP += this.YQ;
        QLog.d("ZipThumbDownloader", 4, "decode : recv packeg[" + this.YQ + "],total[" + String.valueOf(this.YP) + "] thumb Size[" + String.valueOf(this.mFileSize) + "]");
        if (this.YP < this.mFileSize) {
          break label581;
        }
        this.c = null;
      }
      catch (Exception paramaqog1)
      {
        try
        {
          this.h.flush();
          this.h.getFD().sync();
          Ji(false);
          if (aqhq.renameFile(new File(this.bHW), new File(this.mFileName))) {
            break label620;
          }
          i = -9;
          QLog.e("ZipThumbDownloader", 1, "decode : [downloadThumb] = " + this.YO + " renameFile failed");
          if (this.a == null) {
            break;
          }
          this.a.a(this.mUrl, bool, i, this.mFileName, this.YO);
          return;
        }
        catch (IOException paramaqog1)
        {
          paramaqog1.printStackTrace();
          Ji(true);
        }
        paramaqog1 = paramaqog1;
        paramaqog1.printStackTrace();
        Ji(true);
      }
      if (this.a == null) {
        break;
      }
      this.a.a(this.mUrl, false, -8, null, this.YO);
      return;
      if (this.a == null) {
        break;
      }
      this.a.a(this.mUrl, false, -8, null, this.YO);
      return;
      label581:
      int i = (int)((float)this.YP / (float)this.mFileSize * 10000.0F);
      if (this.a == null) {
        break;
      }
      this.a.r(this.mUrl, i);
      return;
      label620:
      i = 0;
      bool = true;
    }
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    return true;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    int i = -1;
    long l = -1L;
    if (paramaqog1 != null) {
      l = Long.parseLong(paramaqog1.msgId);
    }
    if (l != this.YO) {
      QLog.e("ZipThumbDownloader", 1, "handleError : [thumbId] = " + l + " but [currentTaskId] = " + this.YO);
    }
    int j;
    do
    {
      do
      {
        return;
        if (paramaqog2 != null) {
          break;
        }
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " response is null");
        Ji(true);
      } while (this.a == null);
      this.a.a(this.mUrl, false, -1, null, this.YO);
      return;
      String str2 = paramaqog2.getErrorString();
      String str1 = str2;
      if (str2 == null) {
        str1 = "null";
      }
      j = paramaqog2.errCode;
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " handleError retCode [errCode] = " + j + ", [retMsg] = " + str1);
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break;
      }
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " net is broken");
      Ji(true);
    } while (this.a == null);
    this.a.a(this.mUrl, false, -3, null, this.YO);
    return;
    if (paramaqog1 == null)
    {
      i = -6;
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " request = null. over");
    }
    for (;;)
    {
      Ji(true);
      if (this.a == null) {
        break;
      }
      this.a.a(this.mUrl, false, i, null, this.YO);
      return;
      if (!paramaqog2.aFq())
      {
        i = -4;
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " response.permitRetry = false. over");
      }
      else
      {
        if (this.mRetryTimes < 3)
        {
          QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " try it. [retryTimes] = " + this.mRetryTimes + " [eofRetry] = " + this.cXE);
          this.mRetryTimes += 1;
          if ((j == 9056) && (this.cXE < 3))
          {
            QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " [Error_Exp_Eof retryTimes] = " + this.mRetryTimes + " [eofRetry] = " + this.cXE);
            this.mRetryTimes -= 1;
          }
          for (this.cXE += 1;; this.cXE = 0)
          {
            Ji(true);
            if (this.a != null) {
              this.a.IP(this.mUrl);
            }
            this.cXD += 1;
            dhC();
            return;
          }
        }
        QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.YO + " try it. retryTimes > " + 3 + " download over....");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agla
 * JD-Core Version:    0.7.0.1
 */