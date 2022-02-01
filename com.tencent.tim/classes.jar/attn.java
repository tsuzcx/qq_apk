import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class attn
  extends agie
{
  long HO;
  
  protected void a(boolean paramBoolean, agib.b paramb, achq.a parama)
  {
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.this$0.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      this.this$0.setStatus(1005);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 15, null, paramb.retCode, paramb.retMsg);
      if (paramb.retCode == -100001) {}
      for (int i = 9043;; i = 9045)
      {
        audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, i, String.valueOf(parama.appSeq) + "&" + String.valueOf(paramb.retCode), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, attm.a(this.this$0), "", attm.a(this.this$0), "setSuccFaild", null);
        audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, i, String.valueOf(parama.appSeq) + "&" + String.valueOf(paramb.retCode), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, attm.a(this.this$0), "", attm.b(this.this$0), "setSuccFaild", null);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.this$0.nSessionId) + "],retCode[" + String.valueOf(paramb.retCode) + "]");
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.this$0.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.this$0.app.a().a(this.this$0.strUin, this.this$0.c, attm.a(this.this$0));
  }
  
  protected void a(boolean paramBoolean, agib.b paramb, achq.a parama, List<String> paramList)
  {
    if (this.this$0.isStop())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.this$0.nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    this.this$0.YF = 0L;
    int i;
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.this$0.nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
      this.this$0.setStatus(1005);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 15, null, paramb.retCode, paramb.retMsg);
      if (paramb.retCode == -100001) {}
      for (i = 9043;; i = 9045)
      {
        paramList = "server retError";
        if (paramb.retMsg != null) {
          paramList = paramb.retMsg;
        }
        audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, i, String.valueOf(parama.appSeq) + "&" + String.valueOf(paramb.retCode), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, attm.a(this.this$0), "", attm.a(this.this$0), paramList, null);
        audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, i, String.valueOf(parama.appSeq) + "&" + String.valueOf(paramb.retCode), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, attm.a(this.this$0), "", attm.b(this.this$0), paramList, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.this$0.nSessionId) + "],retCode[" + String.valueOf(paramb.retCode) + "]");
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.this$0.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramb.strIP == null) || (paramb.strIP.length() == 0))
    {
      this.this$0.setStatus(1005);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 15, null, paramb.retCode, paramb.retMsg);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.this$0.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      if (paramb.retCode == 0) {}
      for (i = 9048;; i = paramb.retCode)
      {
        audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, i, String.valueOf(parama.appSeq) + "&" + String.valueOf(paramb.retCode), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, attm.a(this.this$0), "", attm.a(this.this$0), "onUpSend ip url error", null);
        audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.bHN, this.this$0.startTime, attm.a(this.this$0), this.this$0.strUin, this.this$0.bHK, this.this$0.c.strFileMd5, i, String.valueOf(parama.appSeq) + "&" + String.valueOf(paramb.retCode), this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, attm.a(this.this$0), "", attm.b(this.this$0), "onUpSend ip url error", null);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.this$0.nSessionId) + "],retCode[" + String.valueOf(paramb.retCode) + "]");
    if ((paramb.retMsg != null) && (paramb.retMsg.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.this$0.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramb.retCode) + "], retMsg:" + paramb.retMsg);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 4, null, paramb.retCode, paramb.retMsg);
    }
    if ((paramb.uuid != null) && (paramb.uuid.length > 0))
    {
      this.this$0.bHK = new String(paramb.uuid);
      this.this$0.c.Uuid = this.this$0.bHK;
    }
    for (;;)
    {
      localObject = new byte[this.this$0.dO.length + 4];
      aqoj.b((byte[])localObject, 0, this.this$0.dO, this.this$0.dO.length);
      aqoj.DWord2Byte((byte[])localObject, this.this$0.dO.length, this.this$0.nFileSize);
      if ((paramb.fileExist != true) || (paramb.fileSize > 104857600L)) {
        break;
      }
      this.this$0.YG = System.currentTimeMillis();
      this.this$0.endTime = System.currentTimeMillis();
      audx.jR(this.this$0.c.nSessionId);
      this.this$0.app.a().a(this.this$0.c, 5, this.this$0.serverPath);
      this.this$0.app.a().a(this.this$0.c, this.this$0.selfUin, this.this$0.strUin, this.this$0.c.Uuid, attm.a(this.this$0));
      paramb = new audw.b();
      paramb.bJE = "send_file_suc";
      paramb.cYX = 1;
      audw.a(this.this$0.app.getCurrentAccountUin(), paramb);
      this.this$0.c.status = 1;
      this.this$0.app.a().u(this.this$0.c);
      return;
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
    parama = HexUtil.bytes2HexStr(paramb.key);
    Object localObject = HexUtil.bytes2HexStr((byte[])localObject).toLowerCase(Locale.US);
    if (paramList == null)
    {
      paramList = new ArrayList();
      paramList.add(paramb.strIP + ":" + paramb.ag);
      if (atvz.ceo)
      {
        paramList.clear();
        paramList.add(0, "14.17.29.27:" + paramb.ag);
      }
      if (paramb.cXe != 2) {
        break label2171;
      }
    }
    label2171:
    for (parama = "/ftn_handler";; parama = attm.a(this.this$0, parama, (String)localObject, this.this$0.nFileSize))
    {
      attm.a(this.this$0, new attx(this.this$0.app, paramList, parama));
      attm.a(this.this$0, paramb);
      attm.a(this.this$0, this.this$0.serverPath);
      this.this$0.c.strServerPath = this.this$0.serverPath;
      this.this$0.c.status = 0;
      this.this$0.app.a().u(this.this$0.c);
      this.this$0.c.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "]");
      }
      if ((!paramb.fileExist) || (paramb.cXe != 1)) {
        break label2192;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.this$0.nSessionId + "], onUpdateSendOfflineFile: file Exist");
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.this$0.nSessionId + "], FileSize[" + this.this$0.nFileSize + "], Uuid[" + this.this$0.bHK + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "CS秒传,nSessionID[" + String.valueOf(this.this$0.c.nSessionId) + "]");
      }
      this.this$0.YG = System.currentTimeMillis();
      this.this$0.endTime = System.currentTimeMillis();
      audx.jR(this.this$0.c.nSessionId);
      this.this$0.app.a().a(this.this$0.c, 5, this.this$0.serverPath);
      this.this$0.app.a().a(this.this$0.c, this.this$0.selfUin, this.this$0.strUin, this.this$0.c.Uuid, attm.a(this.this$0));
      paramb = new audw.b();
      paramb.bJE = "send_file_suc";
      paramb.cYX = 1;
      audw.a(this.this$0.app.getCurrentAccountUin(), paramb);
      return;
      paramList.add(0, paramb.strIP + ":" + paramb.ag);
      break;
    }
    label2192:
    this.this$0.YE = paramb.packetSize;
    if (paramb.cXe == 2)
    {
      this.this$0.d(this.this$0.serverPath, 0L, paramb.key);
      return;
    }
    this.this$0.aj(this.this$0.serverPath, 0L);
  }
  
  public void as(long paramLong1, long paramLong2)
  {
    this.this$0.c.setfProgress((float)paramLong1 / (float)paramLong2);
    this.this$0.c.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.HO >= 1000L)
    {
      this.HO = paramLong1;
      this.this$0.c.setCloudType(3);
      this.this$0.app.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.this$0.c.nSessionId) + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  protected void b(boolean paramBoolean, agib.b paramb, achq.a parama)
  {
    super.b(paramBoolean, paramb, parama);
    if ((paramBoolean) && ((paramb.cXd == 2) || (paramb.cXd == 0)) && (!this.this$0.c.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramb.retCode + "],retMsg[" + paramb.retMsg + "],retStat[" + paramb.cXd + "]. need to send file receipt");
      if (this.this$0.c.strSrcName != null)
      {
        this.this$0.app.a().a(this.this$0.strUin, this.this$0.c.strSrcName, this.this$0.c.Uuid, this.this$0.nFileSize, this.this$0.c.uniseq);
        return;
      }
      this.this$0.app.a().a(this.this$0.strUin, this.this$0.c.fileName, this.this$0.c.Uuid, this.this$0.nFileSize, this.this$0.c.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramb.retCode + "],retMsg[" + paramb.retMsg + "],retStat[" + paramb.cXd + "]. don't need to send file receipt");
  }
  
  protected void b(boolean paramBoolean, agib.b paramb, achq.a parama, List<String> paramList)
  {
    if ((paramb.retCode == 0) && (!this.this$0.isStop))
    {
      if (this.this$0.a != null) {
        this.this$0.a.stop();
      }
      this.this$0.clearTask();
      if ((paramb.uuid == null) || (paramb.uuid.length <= 0)) {
        break label272;
      }
      this.this$0.bHK = new String(paramb.uuid);
      this.this$0.c.Uuid = this.this$0.bHK;
    }
    for (;;)
    {
      this.this$0.YG = System.currentTimeMillis();
      this.this$0.endTime = System.currentTimeMillis();
      audx.jR(this.this$0.c.nSessionId);
      this.this$0.app.a().a(this.this$0.c, 5, this.this$0.serverPath);
      this.this$0.app.a().a(this.this$0.c, this.this$0.selfUin, this.this$0.strUin, this.this$0.c.Uuid, attm.a(this.this$0));
      paramb = new audw.b();
      paramb.bJE = "send_file_suc";
      paramb.cYX = 1;
      audw.a(this.this$0.app.getCurrentAccountUin(), paramb);
      this.this$0.c.status = 1;
      this.this$0.app.a().u(this.this$0.c);
      return;
      label272:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
  
  public void dgt()
  {
    this.this$0.dhv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attn
 * JD-Core Version:    0.7.0.1
 */