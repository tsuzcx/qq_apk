import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.OfflineSendWorker.3.1;
import java.util.ArrayList;
import java.util.List;

public class atue
  extends agie
{
  protected void a(boolean paramBoolean, agib.b paramb, achq.a parama)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + atud.a(this.this$0).nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      atud.a(this.this$0, 1005);
      atud.a(this.this$0).a().a(atud.a(this.this$0).uniseq, atud.a(this.this$0).nSessionId, atud.a(this.this$0).peerUin, atud.a(this.this$0).peerType, 15, null, paramb.retCode, paramb.retMsg);
      int i = 9045;
      if (-100001 == paramb.retCode) {
        i = 9043;
      }
      atud.a(this.this$0, atud.a(this.this$0).fileSize, i, "setSuccFaild");
      atud.b(this.this$0, atud.a(this.this$0).fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + atud.a(this.this$0).nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    atud.a(this.this$0).a().a(atud.a(this.this$0).peerUin, atud.a(this.this$0), atud.a(this.this$0));
  }
  
  protected void a(boolean paramBoolean, agib.b paramb, achq.a parama, List<String> paramList)
  {
    if (this.this$0.isStop())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + atud.a(this.this$0).nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    int i;
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + atud.a(this.this$0).nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
      atud.a(this.this$0, 1005);
      atud.a(this.this$0).a().a(atud.a(this.this$0).uniseq, atud.a(this.this$0).nSessionId, atud.a(this.this$0).peerUin, atud.a(this.this$0).peerType, 15, null, paramb.retCode, paramb.retMsg);
      i = 9045;
      if (-100001 == paramb.retCode) {
        i = 9043;
      }
      parama = "server retError";
      if (paramb.retMsg != null) {
        parama = paramb.retMsg;
      }
      atud.a(this.this$0, atud.a(this.this$0).fileSize, i, parama);
      atud.b(this.this$0, atud.a(this.this$0).fileSize, i, parama);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + atud.a(this.this$0).nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramb.strIP == null) || (paramb.strIP.length() == 0))
    {
      atud.a(this.this$0, 1005);
      atud.a(this.this$0).a().a(atud.a(this.this$0).uniseq, atud.a(this.this$0).nSessionId, atud.a(this.this$0).peerUin, atud.a(this.this$0).peerType, 15, null, paramb.retCode, paramb.retMsg);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(atud.a(this.this$0).nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramb.retCode;
      parama = paramb.retMsg;
      if (paramb.retCode == 0)
      {
        i = 9048;
        parama = "onUpSend ip url error";
      }
      atud.a(this.this$0, atud.a(this.this$0).fileSize, i, parama);
      atud.b(this.this$0, atud.a(this.this$0).fileSize, i, parama);
      return;
    }
    parama = new ArrayList();
    if (paramList == null) {
      parama.add(paramb.strIP + ":" + paramb.ag);
    }
    for (;;)
    {
      ThreadManager.post(new OfflineSendWorker.3.1(this, paramb, parama), 5, null, false);
      return;
      parama.addAll(paramList);
      parama.add(0, paramb.strIP + ":" + paramb.ag);
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
      atud.a(this.this$0).Uuid = new String(paramb.uuid);
      this.this$0.clearTask();
      atud.b(this.this$0);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atue
 * JD-Core Version:    0.7.0.1
 */