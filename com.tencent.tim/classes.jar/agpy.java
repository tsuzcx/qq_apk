import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadFileEntry;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.2;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.3;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class agpy
  implements IExcitingTransferSendListener
{
  private static long ZY;
  private static long ZZ;
  protected final String QI;
  protected long ZF;
  protected agqa a;
  protected agqc a;
  private agqd a;
  public long bz;
  protected final int cWz;
  protected int cXp = 0;
  protected int cYF;
  protected byte[] eb;
  protected final QQAppInterface mApp;
  public boolean mIsStop = true;
  protected final long mSessionId;
  protected final long ow;
  
  public agpy(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, agqa paramagqa, agqc paramagqc)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionId = paramLong1;
    this.jdField_a_of_type_Agqa = paramagqa;
    this.jdField_a_of_type_Agqc = paramagqc;
    this.ow = paramLong2;
    this.cWz = paramInt;
    this.QI = paramQQAppInterface.getCurrentUin();
    this.mIsStop = true;
    this.cYF = 0;
    djb();
  }
  
  private ExcitingTransferEngine.ExcitingSendInfo a()
  {
    int j = 0;
    ExcitingTransferEngine.ExcitingSendInfo localExcitingSendInfo = new ExcitingTransferEngine.ExcitingSendInfo();
    localExcitingSendInfo.mFileEntry = new ExcitingTransferUploadFileEntry();
    localExcitingSendInfo.mFileEntry.strLocalFilePath = this.jdField_a_of_type_Agqa.vA();
    localExcitingSendInfo.mFileEntry.strFileName = this.jdField_a_of_type_Agqa.vB();
    localExcitingSendInfo.mFileEntry.uFileSize = this.jdField_a_of_type_Agqa.fZ();
    localExcitingSendInfo.mFileEntry.buf10MMd5 = this.jdField_a_of_type_Agqa.ad();
    localExcitingSendInfo.mFileEntry.bufMd5 = this.jdField_a_of_type_Agqa.ac();
    localExcitingSendInfo.mFileEntry.bufSha = this.jdField_a_of_type_Agqa.af();
    localExcitingSendInfo.mFileEntry.bufSha3 = this.jdField_a_of_type_Agqa.ae();
    a(localExcitingSendInfo.mFileEntry);
    localExcitingSendInfo.mBusInfo = new ExcitingTransferUploadBizInfo();
    localExcitingSendInfo.mBusInfo.commandId = ED();
    localExcitingSendInfo.mBusInfo.chateType = kw();
    localExcitingSendInfo.mBusInfo.businessType = wJ();
    localExcitingSendInfo.mBusInfo.bufSig = this.eb;
    localExcitingSendInfo.mBusInfo.senderUin = Long.valueOf(this.QI).longValue();
    localExcitingSendInfo.mBusInfo.receiverUin = this.ow;
    localExcitingSendInfo.mBusInfo.client_type = 2;
    localExcitingSendInfo.mBusInfo.client_ver = AppSetting.getRevision();
    localExcitingSendInfo.mBusInfo.terminal_type = 2;
    localExcitingSendInfo.mBusInfo.terminal_ver = AppSetting.getVersion();
    Object localObject = this.jdField_a_of_type_Agqc.fa();
    int i;
    ExcitingTransferHostInfo localExcitingTransferHostInfo;
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i > 0)
      {
        localExcitingSendInfo.mBusInfo.vecFtnLanIpV4AndPorts = new ExcitingTransferHostInfo[i];
        localObject = ((List)localObject).iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((Iterator)localObject).next();
          localExcitingSendInfo.mBusInfo.vecFtnLanIpV4AndPorts[i] = localExcitingTransferHostInfo;
          i += 1;
        }
      }
    }
    localObject = this.jdField_a_of_type_Agqc.fb();
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i > 0)
      {
        localExcitingSendInfo.mBusInfo.vecFtnLanIpV6AndPorts = new ExcitingTransferHostInfo[i];
        localObject = ((List)localObject).iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((Iterator)localObject).next();
          localExcitingSendInfo.mBusInfo.vecFtnLanIpV6AndPorts[i] = localExcitingTransferHostInfo;
          i += 1;
        }
      }
    }
    localExcitingSendInfo.mBusInfo.bufBusinessExt = this.jdField_a_of_type_Agqc.ag();
    a(localExcitingSendInfo.mBusInfo);
    localExcitingSendInfo.mReqInfo = new ExcitingTransferUploadReqInfo();
    localObject = eZ();
    if (localObject != null)
    {
      if (((List)localObject).size() > 4) {}
      for (i = 4;; i = ((List)localObject).size())
      {
        localExcitingSendInfo.mReqInfo.vecSrvIpAndPorts = new ExcitingTransferHostInfo[i];
        while (j < i)
        {
          localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((List)localObject).get(j);
          localExcitingSendInfo.mReqInfo.vecSrvIpAndPorts[j] = localExcitingTransferHostInfo;
          j += 1;
        }
      }
    }
    localExcitingSendInfo.mReqInfo.bSupportHttps = this.jdField_a_of_type_Agqc.amf();
    localExcitingSendInfo.mReqInfo.strSSLCName = this.jdField_a_of_type_Agqc.vD();
    a(localExcitingSendInfo.mReqInfo);
    localExcitingSendInfo.mConfig = d();
    return localExcitingSendInfo;
  }
  
  private boolean amc()
  {
    return (this.eb != null) && (this.eb.length > 0);
  }
  
  private static void cV(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((ZZ >= 100L) || (l - ZY <= 6000L));
    ZY = l;
    ZZ += 1L;
    QLog.w("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "!!!getBigDataSigFromHwSvr. count:" + ZZ + " lastTime:" + ZY);
    HwServlet.getConfig(paramQQAppInterface, paramQQAppInterface.getCurrentUin());
  }
  
  private void djb()
  {
    try
    {
      SessionInfo localSessionInfo = SessionInfo.getInstance(this.QI);
      if (localSessionInfo.getHttpconn_sig_session() != null)
      {
        int i = localSessionInfo.getHttpconn_sig_session().length;
        this.eb = new byte[i];
        System.arraycopy(localSessionInfo.getHttpconn_sig_session(), 0, this.eb, 0, i);
      }
      if ((this.eb == null) || (this.eb.length == 0)) {
        QLog.e("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "!!!!!Id[" + this.mSessionId + "] ExtfFileUploader ERR: BigDataSig is null.!!!!!");
      }
      return;
    }
    finally {}
  }
  
  protected abstract int ED();
  
  public int EE()
  {
    return this.cYF;
  }
  
  public int EF()
  {
    return this.cXp;
  }
  
  public void a(agqd paramagqd)
  {
    this.jdField_a_of_type_Agqd = paramagqd;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo) {}
  
  protected void a(ExcitingTransferUploadFileEntry paramExcitingTransferUploadFileEntry) {}
  
  protected void a(ExcitingTransferUploadReqInfo paramExcitingTransferUploadReqInfo) {}
  
  protected void aTU()
  {
    this.cYF = 0;
    this.bz = 0L;
    this.ZF = 0L;
  }
  
  public boolean amd()
  {
    aTU();
    if (!amc())
    {
      djb();
      if (!amc()) {
        cV(this.mApp);
      }
    }
    ExcitingTransferEngine.ExcitingSendInfo localExcitingSendInfo = a();
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] startSendFile >>>>");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] ReqInfo   = {" + localExcitingSendInfo.mReqInfo.toString() + "}");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] FileEntry = {" + localExcitingSendInfo.mFileEntry.toString() + "}");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] BusInfo   = {" + localExcitingSendInfo.mBusInfo.toString() + "}");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] Config    = {" + localExcitingSendInfo.mConfig.toString() + "}");
    long l = ExcitingTransferEngine.getInstance().sendFile(localExcitingSendInfo, this);
    if (l == 0L)
    {
      this.mIsStop = true;
      QLog.e("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] startSendFile fail");
      return false;
    }
    this.mIsStop = false;
    this.ZF = l;
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] startSendFile excitingId:" + this.ZF);
    return true;
  }
  
  public void b(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.mIsStop) {
      return;
    }
    if (this.ZF != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelSendFile(this.ZF);
      this.ZF = 0L;
    }
    ThreadManager.post(new ExtfBaseFileUploader.3(this, paramInt, paramExcitingTransferUploadResultRp), 5, null, false);
  }
  
  public void b(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] ^_^ ^_^ onSuccess");
    if (this.jdField_a_of_type_Agqd != null) {
      this.jdField_a_of_type_Agqd.a(0, paramExcitingTransferUploadResultRp);
    }
  }
  
  public void c(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    QLog.e("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] *_* *_* onFailure errcode:" + paramInt);
    if (this.jdField_a_of_type_Agqd != null) {
      this.jdField_a_of_type_Agqd.a(paramInt, paramExcitingTransferUploadResultRp);
    }
  }
  
  protected abstract ExcitingTransferUploadChnConfigInfo d();
  
  public void djc()
  {
    if (this.mIsStop) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] stopSendFile^^^^");
      this.mIsStop = true;
    } while (this.ZF == 0L);
    ExcitingTransferEngine.getInstance().cancelSendFile(this.ZF);
    this.ZF = 0L;
  }
  
  protected List<ExcitingTransferHostInfo> eZ()
  {
    this.cXp = 1;
    return agpf.a().t(false);
  }
  
  public long fY()
  {
    return this.bz;
  }
  
  protected abstract int kw();
  
  public void onExcitingSendProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.mIsStop) {
      return;
    }
    this.bz = paramLong1;
    ThreadManager.post(new ExtfBaseFileUploader.1(this, paramLong2, paramLong3), 5, null, false);
  }
  
  public void onExcitingSendResult(boolean paramBoolean, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.mIsStop) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.mSessionId).append("] onExcitingSendResult suc:").append(paramBoolean).append(" errcode:").append(paramInt).append(" RP:");
    String str;
    if (paramExcitingTransferUploadResultRp != null)
    {
      str = paramExcitingTransferUploadResultRp.toString();
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, str);
      if (paramBoolean) {
        this.bz = this.jdField_a_of_type_Agqa.fZ();
      }
      this.ZF = 0L;
      if (paramExcitingTransferUploadResultRp != null)
      {
        if (!paramBoolean) {
          break label257;
        }
        if (this.jdField_a_of_type_Agqa.fZ() - paramExcitingTransferUploadResultRp.m_u64StartSize <= 0L) {
          break label312;
        }
      }
    }
    label257:
    label299:
    label306:
    label312:
    for (long l = this.jdField_a_of_type_Agqa.fZ() - paramExcitingTransferUploadResultRp.m_u64StartSize;; l = 0L)
    {
      paramExcitingTransferUploadResultRp.m_u64TransferSize = l;
      if ((l > 0L) && (paramExcitingTransferUploadResultRp.m_u64HttpTime > 0L))
      {
        float f = (float)paramExcitingTransferUploadResultRp.m_u64HttpTime / 1000.0F;
        paramExcitingTransferUploadResultRp.m_u64TransferSpeed = (((float)l / f));
        label186:
        QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] SendResultRP:" + paramExcitingTransferUploadResultRp.toString());
        if (!paramBoolean) {
          break label299;
        }
        ThreadManager.post(new ExtfBaseFileUploader.2(this, paramExcitingTransferUploadResultRp), 5, null, false);
        return;
        str = "";
        break;
        if (this.bz - paramExcitingTransferUploadResultRp.m_u64StartSize <= 0L) {
          break label306;
        }
      }
      for (l = this.bz - paramExcitingTransferUploadResultRp.m_u64StartSize;; l = 0L)
      {
        paramExcitingTransferUploadResultRp.m_u64TransferSize = l;
        break;
        paramExcitingTransferUploadResultRp.m_u64TransferSpeed = 0L;
        break label186;
        b(paramInt, paramExcitingTransferUploadResultRp);
        return;
      }
    }
  }
  
  public void onExcitingSendStart()
  {
    if (this.mIsStop) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] onExcitingSendStart.");
    } while (this.jdField_a_of_type_Agqd == null);
    this.jdField_a_of_type_Agqd.dja();
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.mSessionId).append("] ^_^ onExcitingSubSenderResult:").append(paramInt).append(" RP:");
    if (paramExcitingTransferUploaderRp != null) {}
    for (String str = paramExcitingTransferUploaderRp.toString();; str = "")
    {
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, str);
      if (this.jdField_a_of_type_Agqd != null) {
        this.jdField_a_of_type_Agqd.a(paramInt, paramExcitingTransferUploaderRp);
      }
      return;
    }
  }
  
  public void t(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Agqd != null) {
      this.jdField_a_of_type_Agqd.u(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected abstract int wJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpy
 * JD-Core Version:    0.7.0.1
 */