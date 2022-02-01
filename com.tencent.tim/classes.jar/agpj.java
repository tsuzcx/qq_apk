import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.2;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.3;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.4;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class agpj
  implements IExcitingTransferRecvListener
{
  protected long ZF;
  protected final agpk a;
  private agpm a;
  protected String bIQ = "";
  public long bz;
  protected ExcitingTransferDownloadCompletedInfo c;
  protected final int cWz;
  protected final QQAppInterface mApp;
  public boolean mIsStop = true;
  protected int mResultCode = 201;
  protected final long mSessionId;
  protected final long ow;
  
  public agpj(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, agpk paramagpk)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionId = paramLong1;
    this.jdField_a_of_type_Agpk = paramagpk;
    this.ow = paramLong2;
    this.cWz = paramInt;
    this.mIsStop = true;
  }
  
  private void b(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.mIsStop) {
      return;
    }
    if (this.ZF != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.ZF);
      this.ZF = 0L;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.3(this, paramInt, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
  }
  
  public void OnOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (this.mIsStop) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.mSessionId).append("] ^_^ OnOneSlotComplete:").append(paramInt).append(" RP:");
    if (paramExcitingTransferOneSlotComplete != null)
    {
      str = paramExcitingTransferOneSlotComplete.toString();
      label52:
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, str);
      if (paramExcitingTransferOneSlotComplete == null) {
        break label106;
      }
    }
    label106:
    for (String str = paramExcitingTransferOneSlotComplete.m_strIp;; str = "")
    {
      this.bIQ = str;
      if (this.jdField_a_of_type_Agpm == null) {
        break;
      }
      this.jdField_a_of_type_Agpm.a(paramInt, paramExcitingTransferOneSlotComplete);
      return;
      str = "";
      break label52;
    }
  }
  
  public void OnSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if (this.mIsStop) {
      return;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.4(this, paramExcitingTransferDownloadSpeedInfo), 5, null, false);
  }
  
  public ExcitingTransferDownloadCompletedInfo a()
  {
    return this.c;
  }
  
  protected ExcitingTransferDownloadReqInfo a()
  {
    ExcitingTransferDownloadReqInfo localExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
    if (this.jdField_a_of_type_Agpk != null)
    {
      localExcitingTransferDownloadReqInfo.fileSize = this.jdField_a_of_type_Agpk.getFileSize();
      localExcitingTransferDownloadReqInfo.md5 = this.jdField_a_of_type_Agpk.aa();
      localExcitingTransferDownloadReqInfo.isSupportHttps = this.jdField_a_of_type_Agpk.alY();
      localExcitingTransferDownloadReqInfo.sslCName = this.jdField_a_of_type_Agpk.vy();
      localExcitingTransferDownloadReqInfo.strFileName = this.jdField_a_of_type_Agpk.vv();
      if (this.jdField_a_of_type_Agpk.eY() != null) {
        localExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])this.jdField_a_of_type_Agpk.eY().toArray(new ExcitingTransferHostInfo[this.jdField_a_of_type_Agpk.eY().size()]));
      }
      localExcitingTransferDownloadReqInfo.strFileName = this.jdField_a_of_type_Agpk.vv();
      localExcitingTransferDownloadReqInfo.serverPath = this.jdField_a_of_type_Agpk.vw();
    }
    for (;;)
    {
      localExcitingTransferDownloadReqInfo.strCookie = vu();
      localExcitingTransferDownloadReqInfo.strTempFilePath = vt();
      localExcitingTransferDownloadReqInfo.strSaveFileDir = vs();
      a(localExcitingTransferDownloadReqInfo);
      return localExcitingTransferDownloadReqInfo;
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] getDownloadInfo mFileInfo = null ^^^^");
    }
  }
  
  public void a(agpm paramagpm)
  {
    this.jdField_a_of_type_Agpm = paramagpm;
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  public boolean alX()
  {
    this.c = null;
    this.bz = 0L;
    this.mResultCode = 201;
    ExcitingTransferDownloadReqInfo localExcitingTransferDownloadReqInfo = a();
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] startDownloadFile >>>>");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] reqInfo   = {" + localExcitingTransferDownloadReqInfo.toString() + "}");
    long l = ExcitingTransferEngine.getInstance().recvFileEx(localExcitingTransferDownloadReqInfo, d(), this);
    if (l == -1L)
    {
      this.mIsStop = true;
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] startDownloadFile fail");
      return false;
    }
    this.mIsStop = false;
    this.ZF = l;
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] startDownloadFile excitingId:" + this.ZF);
    return true;
  }
  
  public void b(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] ^_^ ^_^ onSuccess");
    if (this.jdField_a_of_type_Agpm != null) {
      this.jdField_a_of_type_Agpm.a(0, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  public void c(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] *_* *_* onFailure errcode:" + paramInt);
    if (this.jdField_a_of_type_Agpm != null) {
      this.jdField_a_of_type_Agpm.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  protected abstract ExcitingTransferDownloadConfig d();
  
  public void diN()
  {
    if (this.mIsStop) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] stopDownloadFile ^^^^");
      this.mIsStop = true;
    } while (this.ZF == 0L);
    ExcitingTransferEngine.getInstance().cancelRecvFile(this.ZF);
    this.ZF = 0L;
  }
  
  public long fX()
  {
    return this.bz;
  }
  
  public int getResultCode()
  {
    return this.mResultCode;
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.mIsStop) {
      return;
    }
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.mSessionId).append("] onExcitingDownloadResult suc:").append(bool).append(" errcode:").append(paramInt).append(" RP:");
      if (paramExcitingTransferDownloadCompletedInfo == null) {
        break label164;
      }
      str = paramExcitingTransferDownloadCompletedInfo.toString();
      label70:
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, str);
      if ((bool) && (this.jdField_a_of_type_Agpk != null)) {
        this.bz = this.jdField_a_of_type_Agpk.getFileSize();
      }
      this.c = paramExcitingTransferDownloadCompletedInfo;
      this.mResultCode = paramInt;
      this.ZF = 0L;
      if (paramExcitingTransferDownloadCompletedInfo == null) {
        break label171;
      }
    }
    label164:
    label171:
    for (String str = paramExcitingTransferDownloadCompletedInfo.m_strLastServerHost;; str = "")
    {
      this.bIQ = str;
      if (!bool) {
        break label178;
      }
      ThreadManager.post(new ExtfBaseFileDownloader.2(this, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
      return;
      bool = false;
      break;
      str = "";
      break label70;
    }
    label178:
    b(paramInt, paramExcitingTransferDownloadCompletedInfo);
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.mIsStop) {
      return;
    }
    this.bz = paramLong2;
    ThreadManager.post(new ExtfBaseFileDownloader.1(this, paramLong1, paramLong3), 5, null, false);
  }
  
  public void onRecvStart()
  {
    if (this.mIsStop) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] onExcitingSendStart.");
    } while (this.jdField_a_of_type_Agpm == null);
    this.jdField_a_of_type_Agpm.diH();
  }
  
  public void t(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Agpm != null) {
      this.jdField_a_of_type_Agpm.s(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected String vs()
  {
    return ahaf.a().vZ();
  }
  
  protected abstract String vt();
  
  protected String vu()
  {
    if (this.jdField_a_of_type_Agpk != null) {
      return "Cookie:t=0;v=" + AppSetting.getAppId() + ";" + this.jdField_a_of_type_Agpk.vx() + ";\r\n";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpj
 * JD-Core Version:    0.7.0.1
 */