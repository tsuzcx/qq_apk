import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aglm
  extends agie
{
  aglm(agll paramagll) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      agll.a(this.this$0, 1005);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      agll.a(this.this$0, this.this$0.c.fileSize, paramInt, "sendCCFaild");
      agll.b(this.this$0, this.this$0.c.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      agll.a(this.this$0, 1005);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, 5, null);
      agll.a(this.this$0, this.this$0.c.fileSize, 58, "ServerMasking");
      agll.b(this.this$0, this.this$0.c.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.this$0.a != null)
    {
      localObject1 = localObject2;
      if (this.this$0.a.Ep() > 0) {
        localObject1 = "ChanedUrlCount[" + this.this$0.a.Ep() + "]";
      }
    }
    this.this$0.IQ((String)localObject1);
    wte.a().h(this.this$0.mApp, paramLong3);
  }
  
  protected void a(boolean paramBoolean, agib.b paramb, achq.a parama)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.this$0.c.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      agll.a(this.this$0, 1005);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, paramb.retCode, paramb.retMsg);
      int i = 9045;
      if (-100001 == paramb.retCode) {
        i = 9043;
      }
      agll.a(this.this$0, this.this$0.c.fileSize, i, "setSuccFaild");
      agll.b(this.this$0, this.this$0.c.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.this$0.c.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.this$0.mApp.a().a(this.this$0.c.peerUin, this.this$0.c, agll.a(this.this$0));
  }
  
  protected void a(boolean paramBoolean, agib.b paramb, achq.a parama, List<String> paramList)
  {
    if (this.this$0.isStop())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + this.this$0.c.nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    int i;
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + this.this$0.c.nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
      agll.a(this.this$0, 1005);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, paramb.retCode, paramb.retMsg);
      i = paramb.retCode;
      if (-100001 == paramb.retCode) {
        i = 9043;
      }
      parama = "server retError";
      if (paramb.retMsg != null) {
        parama = paramb.retMsg;
      }
      agll.a(this.this$0, this.this$0.c.fileSize, i, parama);
      agll.b(this.this$0, this.this$0.c.fileSize, i, parama);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.this$0.c.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if (agll.a(this.this$0, paramb))
    {
      agll.a(this.this$0, 1005);
      this.this$0.mApp.a().a(this.this$0.c.uniseq, this.this$0.c.nSessionId, this.this$0.c.peerUin, this.this$0.c.peerType, 15, null, paramb.retCode, paramb.retMsg);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.this$0.c.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramb.retCode;
      parama = paramb.retMsg;
      if (paramb.retCode == 0)
      {
        i = 9048;
        parama = "onUpSend ip url error";
      }
      agll.a(this.this$0, this.this$0.c.fileSize, i, parama);
      agll.b(this.this$0, this.this$0.c.fileSize, i, parama);
      return;
    }
    boolean bool = false;
    Object localObject1 = null;
    short s2 = paramb.ag;
    paramBoolean = bool;
    parama = (achq.a)localObject1;
    short s1 = s2;
    if (agmx.aE(this.this$0.mApp))
    {
      paramBoolean = bool;
      parama = (achq.a)localObject1;
      s1 = s2;
      if (paramb.cXe == 2)
      {
        paramBoolean = bool;
        parama = (achq.a)localObject1;
        s1 = s2;
        if (!TextUtils.isEmpty(paramb.bHe))
        {
          bool = true;
          localObject1 = paramb.bHe;
          s2 = paramb.ah;
          paramBoolean = bool;
          parama = (achq.a)localObject1;
          s1 = s2;
          if (s2 == 0)
          {
            s1 = 443;
            parama = (achq.a)localObject1;
            paramBoolean = bool;
          }
        }
      }
    }
    localObject1 = new ArrayList();
    if (paramList != null)
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((List)localObject1).add(str + ":" + s1);
      }
    }
    ((List)localObject1).add(0, paramb.strIP + ":" + s1);
    Object localObject2 = new ArrayList();
    if (paramList != null) {
      ((List)localObject2).addAll(paramList);
    }
    ((List)localObject2).add(0, paramb.strIP);
    if (!this.this$0.alF()) {
      this.this$0.cea = paramBoolean;
    }
    if (agll.b(this.this$0, paramb))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. is config enable IPv6. domain[" + paramb.bHg + "]");
      paramList = new agke.a(paramb.bHg, s1);
      paramList = agke.a().a(this.this$0.mApp, paramList, 1);
      if ((paramList != null) && (!paramList.alz()))
      {
        if (agke.alt())
        {
          QLog.d("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. debugIsDisableIPv4OnDoubleStack");
          ((List)localObject1).clear();
          ((List)localObject2).clear();
        }
        agke.a(paramList.Bb, (List)localObject1, false, false);
        agke.a(paramList.Bb, (List)localObject2, true, false);
        this.this$0.cXp = 2;
        if (paramList.cXn == 1) {
          this.this$0.cXp = 3;
        }
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv6. iplist:" + localObject1.toString());
      }
    }
    for (;;)
    {
      agll.a(this.this$0, paramb, paramBoolean, parama, s1, (List)localObject1, (List)localObject2);
      return;
      this.this$0.cXp = 1;
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv4");
      continue;
      this.this$0.cXp = 1;
    }
  }
  
  protected void b(boolean paramBoolean, agib.b paramb, achq.a parama, List<String> paramList)
  {
    if (this.this$0.isStop()) {}
    while (paramb.retCode != 0) {
      return;
    }
    if ((paramb.uuid != null) && (paramb.uuid.length > 0))
    {
      this.this$0.c.Uuid = new String(paramb.uuid);
      this.this$0.clearTask();
      this.this$0.cdZ = true;
      agll.a(this.this$0);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aglm
 * JD-Core Version:    0.7.0.1
 */