import android.os.Bundle;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class agpp
  extends agpn
{
  agpo a;
  private FileManagerEntity c;
  private int cXp = 0;
  boolean cea = false;
  private QQAppInterface mApp;
  long mStartTime = 0L;
  
  public agpp(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
    this.c = paramFileManagerEntity;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Agpo.a.bIP = ahav.lb(this.c.fileName);
    this.jdField_a_of_type_Agpo.a.ZD = this.c.fileSize;
    this.jdField_a_of_type_Agpo.a.cYx = this.c.peerType;
    try
    {
      this.jdField_a_of_type_Agpo.a.ZC = Long.parseLong(this.c.peerUin);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramQQAppInterface.toString());
    }
  }
  
  private void b(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (paramExcitingTransferOneSlotComplete == null) {
      return;
    }
    String str = "";
    if (this.jdField_a_of_type_Agpo.a != null) {
      str = String.valueOf(this.jdField_a_of_type_Agpo.a.ZC);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_fromType", 1);
    localBundle.putInt("param_V6SelectType", this.cXp);
    localBundle.putInt("param_ipAddrType", ahbr.df(paramExcitingTransferOneSlotComplete.m_strIp));
    if (this.cea) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (paramInt == 0) {
        break;
      }
      ahav.a(this.mApp, this.c.nSessionId, "actFileDownDetail", this.mStartTime, paramExcitingTransferOneSlotComplete.m_strIp, str, this.c.Uuid, this.c.strFileMd5, paramInt, "", paramExcitingTransferOneSlotComplete.m_DownloadedSize, paramExcitingTransferOneSlotComplete.m_DownloadedSize, this.c.fileSize, paramExcitingTransferOneSlotComplete.m_strIp, "", 0, "", null, localBundle);
      return;
    }
    ahav.a(this.mApp, this.c.nSessionId, "actFileDownDetail", paramExcitingTransferOneSlotComplete.m_TotalTimes, paramExcitingTransferOneSlotComplete.m_strIp, str, this.c.Uuid, this.c.strFileMd5, paramExcitingTransferOneSlotComplete.m_DownloadedSize, paramExcitingTransferOneSlotComplete.m_DownloadedSize, this.c.fileSize, 0, null, localBundle);
  }
  
  private int hE(int paramInt)
  {
    int i;
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400) || (paramInt == 402) || (paramInt == 403)) {
      if (AppNetConnInfo.isNetSupport())
      {
        i = paramInt;
        if (this.mApp.isLogin()) {}
      }
      else
      {
        i = 9004;
      }
    }
    do
    {
      return i;
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503)) {
        break;
      }
      i = paramInt;
    } while (paramInt != 505);
    if (aqfo.isExistSDCard()) {}
    for (long l = aqfo.getSDCardAvailableSize() * 1024L;; l = aqfo.getSystemAvailableSize() * 1024L)
    {
      i = paramInt;
      if (this.c.fileSize <= l) {
        break;
      }
      return 506;
    }
  }
  
  public void OnOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int j = 3;
    if (paramExcitingTransferOneSlotComplete == null)
    {
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + paramInt + " slotInfo is null");
      return;
    }
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + paramInt + " slotInfo : " + paramExcitingTransferOneSlotComplete.toString());
    int i = hE(paramInt);
    int k = 4;
    if (i == 9004) {
      i = 5;
    }
    for (;;)
    {
      this.jdField_a_of_type_Agpo.a(i, j, paramExcitingTransferOneSlotComplete);
      b(paramInt, paramExcitingTransferOneSlotComplete);
      return;
      if (i == 506)
      {
        k = 3;
        j = i;
        i = k;
      }
      else
      {
        j = i;
        i = k;
      }
    }
  }
  
  public void OnSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    paramExcitingTransferDownloadSpeedInfo = ahbr.bs(paramExcitingTransferDownloadSpeedInfo.mTotalSpeed);
    this.c.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
  }
  
  protected agpd a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Agpo = new agpo(paramQQAppInterface);
    return this.jdField_a_of_type_Agpo;
  }
  
  public FileManagerEntity a()
  {
    return this.c;
  }
  
  protected void b(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    this.mStartTime = System.currentTimeMillis();
    this.jdField_a_of_type_Agpo.diO();
    this.cea = false;
    this.mApp.a().a(this.c.Uuid, this.c.fileIdCrc, this.c.bSend, false, new agpq(this, paramExcitingTransferDownloadReqInfo));
  }
  
  public String getFileId()
  {
    return this.c.WeiYunFileId;
  }
  
  public long getFileSize()
  {
    return this.c.fileSize;
  }
  
  public int getProgress()
  {
    return (int)(this.c.fProgress * 100.0F);
  }
  
  public int getStatus()
  {
    return this.c.status;
  }
  
  public String getTmpFilePath()
  {
    String str1 = this.jdField_a_of_type_Ahaf.wa();
    String str2 = MD5.toMD5(this.c.Uuid);
    return str1 + str2;
  }
  
  public void j(Object paramObject, int paramInt)
  {
    if (this.c.status != 16) {
      this.c.status = 0;
    }
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 12, null, 6, null);
    this.mApp.a().u(this.c);
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download result:" + paramInt);
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      this.jdField_a_of_type_Agpo.Op(ahbr.df(paramExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
    }
    if (paramInt != 0)
    {
      paramInt = hE(paramInt);
      this.jdField_a_of_type_Agpo.a.ZB = paramInt;
      this.jdField_a_of_type_Agpo.a.ZA = 4L;
      if (paramInt == 9004)
      {
        this.jdField_a_of_type_Agpo.a.ZA = 5L;
        this.jdField_a_of_type_Agpo.Oq(3);
        j(null, paramInt);
        this.mApp.a().u(this.c);
        if (paramExcitingTransferDownloadCompletedInfo != null)
        {
          this.jdField_a_of_type_Agpo.c(paramExcitingTransferDownloadCompletedInfo);
          paramExcitingTransferDownloadCompletedInfo = this.jdField_a_of_type_Agpo;
          if (paramInt != 0) {
            break label643;
          }
        }
      }
    }
    label643:
    for (boolean bool = true;; bool = false)
    {
      paramExcitingTransferDownloadCompletedInfo.Js(bool);
      return;
      if (paramInt == 506)
      {
        this.jdField_a_of_type_Agpo.a.ZA = 3L;
        this.jdField_a_of_type_Agpo.Oq(paramInt);
        break;
      }
      this.jdField_a_of_type_Agpo.Oq(paramInt);
      break;
      this.mApp.a().a(this.mApp.getCurrentUin(), this.c.Uuid, this.c.bUseMediaPlatform, this.c.fileIdCrc, null);
      this.jdField_a_of_type_Agpo.a.ZB = paramInt;
      this.jdField_a_of_type_Agpo.a.ZA = 0L;
      this.jdField_a_of_type_Agpo.Oq(0);
      String str = paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath;
      ahav.getFileSizes(str);
      this.c.fileName = ahav.getFileName(str);
      int i = str.length() - this.c.fileName.length();
      if (this.c.fileName.getBytes().length > 250 - i) {
        this.c.fileName = ahav.al(this.c.fileName, 250 - i);
      }
      this.c.setFilePath(str);
      this.c.fileName = ahav.getFileName(str);
      this.c.nFileType = ahav.getFileType(this.c.fileName);
      if (this.c.nFileType == 0)
      {
        this.c.strFileSha3 = agoy.t(ahav.A(str));
        if (this.c.fileSize < 104857600L) {
          this.c.strFileSHA = agoy.t(ahav.x(str));
        }
      }
      VFSFile localVFSFile = new VFSFile(str);
      this.c.localModifyTime = localVFSFile.lastModified();
      this.c.lastSuccessTime = anaz.gQ();
      this.c.status = 1;
      this.c.setCloudType(3);
      this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 11, new Object[] { str, "", Long.valueOf(this.c.fileSize), Boolean.valueOf(true), "", "" }, 0, null);
      if (this.c.nFileType == 0)
      {
        ahbh.O(this.c);
        ahbh.M(this.c);
        ahbh.a(this.c);
      }
      for (;;)
      {
        ahav.K(this.c);
        break;
        if (this.c.nFileType == 2) {
          ahav.J(this.c);
        }
      }
    }
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Agpo.jF(paramLong2);
    this.c.status = 2;
    this.c.fProgress = ((float)paramLong2 / (float)this.c.fileSize);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 16, null, 0, null);
  }
  
  public void onRecvStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpp
 * JD-Core Version:    0.7.0.1
 */