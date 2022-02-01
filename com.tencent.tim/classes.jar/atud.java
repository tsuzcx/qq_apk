import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.OfflineSendWorker.2;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.concurrent.Executor;

public class atud
  implements attu.b
{
  private long YR;
  private attu a;
  private String bHY;
  private final FileManagerEntity c;
  private boolean cdX;
  private boolean cdY;
  private agie e;
  private final QQAppInterface mApp;
  private long mEndTime;
  private boolean mIsStop;
  private long mStartTime;
  private int mStatus;
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "start OfflineFileHitReq:" + anaz.gQ());
    }
    audx.a.getExecutor().execute(new OfflineSendWorker.2(this, paramString, paramLong, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte2, paramArrayOfByte1));
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    paramagie = new audi();
    paramagie.bJz = paramFileManagerEntity.peerUin;
    paramagie.ej = paramArrayOfByte2;
    paramagie.ei = paramArrayOfByte1;
    paramagie.fileSize = paramFileManagerEntity.fileSize;
    paramFileManagerEntity.strFileMd5 = atwx.t(paramArrayOfByte3);
    paramagie.md5 = paramArrayOfByte3;
    byte[] arrayOfByte = new byte[paramArrayOfByte3.length + 4];
    aqoj.b(arrayOfByte, 0, paramArrayOfByte3, paramArrayOfByte3.length);
    aqoj.DWord2Byte(arrayOfByte, paramArrayOfByte3.length, paramFileManagerEntity.fileSize);
    this.bHY = HexUtil.bytes2HexStr(arrayOfByte).toLowerCase(Locale.US);
    if (paramLong <= 104857600L)
    {
      paramagie.cYU = 1700;
      paramString = audx.x(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSHA = atwx.t(paramString);
      paramagie.sha1 = paramString;
    }
    for (;;)
    {
      this.mApp.a().a(paramagie, this.e, paramFileManagerEntity);
      return;
      paramagie.cYU = 1600;
      arrayOfByte = audx.B(new String(paramArrayOfByte1));
      if (arrayOfByte == null)
      {
        j(null, 0);
        return;
      }
      paramagie.el = arrayOfByte;
      a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramLong, paramArrayOfByte3, arrayOfByte);
    }
  }
  
  private void c(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.a == null)
    {
      audx.a(this.mApp, this.c.nSessionId, "actFileUp", this.mStartTime, null, this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", 1L, paramLong, this.c.fileSize, null, paramString2, 0, paramString1, null);
      return;
    }
    audx.a(this.mApp, this.c.nSessionId, "actFileUp", this.mStartTime, this.a.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", 1L, paramLong, this.c.fileSize, this.a.getUrl(), paramString2, this.a.getRetryCount(), paramString1, null);
  }
  
  private void d(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.a == null)
    {
      audx.a(this.mApp, this.c.nSessionId, "actFileUpDetail", this.mStartTime, null, this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", 1L, paramLong, this.c.fileSize, null, null, 0, paramString2, null);
      return;
    }
    audx.a(this.mApp, this.c.nSessionId, "actFileUpDetail", this.mStartTime, this.a.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", 1L, paramLong, this.c.fileSize, this.a.getUrl(), paramString2, this.a.getRetryCount(), paramString1, null);
  }
  
  private void dhF()
  {
    clearTask();
    j(null, 0);
  }
  
  private void dhI()
  {
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 13, null, 0, null);
    this.mApp.a().o(this.c.nSessionId, 1002);
    this.c.status = 0;
    this.mApp.a().u(this.c);
    this.c.status = 2;
    this.c.setfProgress(0.0F);
    if (this.c.getFilePath() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.c.nSessionId + "], strFilePath is null");
      }
      l(0L, 9005, audx.ti());
      k(0L, 9005, audx.ti());
      dhF();
    }
    label468:
    do
    {
      return;
      if (this.c.strServerPath != null)
      {
        if (this.c.bombData != null) {}
        for (this.a = attu.a(this.mApp, this.c.nSessionId, this.c.peerType, 0, this.c.getFilePath(), new String(this.c.bombData), this.c.strFileSHA, this.c.strServerPath);; this.a = attu.a(this.mApp, this.c.nSessionId, this.c.peerType, 0, this.c.getFilePath(), this.c.strServerPath))
        {
          if (this.a == null) {
            break label468;
          }
          this.cdX = true;
          this.a.a(this);
          if (this.a.cd(0L)) {
            break;
          }
          setStatus(1005);
          this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 0, "");
          l(this.c.fileSize, 9045, "sendFile error");
          k(this.c.fileSize, 9045, "sendFile error");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("OfflineSendWorker<FileAssistant>", 2, "nSessionID[" + this.c.nSessionId + "],sendFile return false");
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.c.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.c.tmpSessionType > 0L) {
        this.c.tmpSessionSig = audx.a(this.mApp, this.c.peerUin, (int)this.c.tmpSessionType);
      }
      byte[] arrayOfByte2;
      byte[] arrayOfByte3;
      try
      {
        byte[] arrayOfByte1 = this.c.fileName.getBytes("utf-8");
        arrayOfByte2 = this.c.getFilePath().getBytes("utf-8");
        arrayOfByte3 = audx.t(this.c.getFilePath());
        if (arrayOfByte3 == null)
        {
          setStatus(0);
          l(0L, 9042, "get md5 failed");
          k(0L, 9042, "get md5 failed");
          this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.c.nSessionId + "], getMd5 failed");
        }
        setStatus(0);
        l(0L, 9005, audx.ti());
        k(0L, 9005, audx.ti());
        this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
        return;
      }
      a(this.c.peerUin, arrayOfByte2, localUnsupportedEncodingException, arrayOfByte3, this.c.fileSize, this.e, this.c);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.c.nSessionId) + "]");
  }
  
  private void dhJ()
  {
    this.mIsStop = true;
    this.cdY = true;
    this.mEndTime = System.currentTimeMillis();
    audx.jR(this.c.nSessionId);
    this.mApp.a().a(this.c, 5, "");
    this.mApp.a().a(this.c, this.mApp.getAccount(), this.c.peerUin, this.c.Uuid, this.e);
    audw.b localb = new audw.b();
    localb.bJE = "send_file_suc";
    localb.cYX = 1;
    audw.a(this.mApp.getCurrentAccountUin(), localb);
    this.c.status = 1;
    this.mApp.a().u(this.c);
  }
  
  private void k(long paramLong, int paramInt, String paramString)
  {
    c(paramLong, paramInt, paramString, null);
  }
  
  private void l(long paramLong, int paramInt, String paramString)
  {
    d(paramLong, paramInt, paramString, null);
  }
  
  private void setStatus(int paramInt)
  {
    paramInt = audx.hM(paramInt);
    if ((this.mStatus == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.mStatus = paramInt;
      this.c.status = paramInt;
    } while (paramInt == 2);
    this.mApp.a().u(this.c);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.mIsStop) {
      return;
    }
    if (paramInt == 0)
    {
      paramInt = 9001;
      paramString1 = "[Http_RespValue_Null]" + audx.ti();
    }
    for (;;)
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (!paramBoolean)
      {
        d(paramLong, paramInt, str, paramString2);
        return;
      }
      d(paramLong, paramInt, str, paramString2);
      dhF();
      return;
    }
  }
  
  public void c(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.mIsStop) {
      return;
    }
    if (!paramBoolean)
    {
      d(paramLong, 9009, paramString1, paramString2);
      return;
    }
    setStatus(1005);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
    clearTask();
    c(paramLong, 9009, paramString1, paramString2);
  }
  
  public void clearTask()
  {
    this.mIsStop = true;
    if (this.a != null) {
      this.a.bme();
    }
  }
  
  public void dgA()
  {
    this.mIsStop = true;
    this.cdY = true;
    this.mEndTime = System.currentTimeMillis();
    this.c.setCloudType(3);
    setStatus(1003);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 14, new Object[] { this.c.getFilePath(), Long.valueOf(this.c.fileSize), Boolean.valueOf(true), this.a.getUrl() }, 0, null);
    this.mApp.a().a(this.c, this.mApp.getAccount(), this.c.peerUin, this.c.Uuid, this.e);
    audw.b localb = new audw.b();
    localb.bJE = "send_file_suc";
    localb.cYX = 1;
    audw.a(this.mApp.getCurrentAccountUin(), localb);
    this.c.status = 1;
    this.mApp.a().u(this.c);
  }
  
  public void dgB()
  {
    if (this.cdX)
    {
      this.c.strServerPath = "";
      this.c.bombData = null;
      dhI();
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.c.nSessionId) + "]onOutDate, but not use last server path");
  }
  
  public void dgz()
  {
    dhJ();
  }
  
  public boolean isStop()
  {
    return this.mIsStop;
  }
  
  public void j(Object paramObject, int paramInt)
  {
    paramInt = 0;
    this.mApp.a().dhl();
    this.c.isReaded = false;
    paramObject = this.c;
    if (this.c.status != 16) {}
    for (;;)
    {
      paramObject.status = paramInt;
      this.mApp.a().u(this.c);
      this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
      return;
      paramInt = 16;
    }
  }
  
  public void jm(long paramLong)
  {
    this.c.setfProgress((float)paramLong / (float)this.c.fileSize);
    setStatus(1002);
    paramLong = System.currentTimeMillis();
    if (paramLong - this.YR >= 1000L)
    {
      this.YR = paramLong;
      this.c.setCloudType(3);
      this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 16, null, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atud
 * JD-Core Version:    0.7.0.1
 */