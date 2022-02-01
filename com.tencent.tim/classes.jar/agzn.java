import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class agzn
  extends agzk
{
  private MessageForTroopFile e = (MessageForTroopFile)this.v;
  
  public agzn(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
  }
  
  public agzi a()
  {
    agzm localagzm = new agzm(apsv.a(this.mApp, this.e));
    localagzm.a(new agzo(this));
    return localagzm;
  }
  
  public boolean amG()
  {
    apcy localapcy = apsv.a(this.mApp, this.e);
    if (localapcy == null) {
      QLog.i("TroopFileSaveModel<QFile>", 1, "stopDownload : file info is null. uniseq[" + this.e.uniseq + "]");
    }
    while ((localapcy.Status != 8) && (localapcy.Status != 9) && (localapcy.Status != 10)) {
      return false;
    }
    long l = Long.parseLong(this.e.frienduin);
    TroopFileTransferManager.a(this.mApp, l).d(localapcy.Id);
    return true;
  }
  
  public boolean amH()
  {
    apcy localapcy = apsv.a(this.mApp, this.e);
    return (localapcy != null) && (localapcy.Status == 8);
  }
  
  public boolean cu()
  {
    apcy localapcy = apsv.a(this.mApp, this.e);
    long l = Long.parseLong(this.e.frienduin);
    if (localapcy == null)
    {
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : file info is null. uniseq[" + this.e.uniseq + "]");
      return false;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload: uniseq[" + this.e.uniseq + "] fileId[" + localapcy.FilePath + "]");
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, l);
    localTroopFileTransferManager.a(localapcy.FilePath, localapcy.FileName, localapcy.ProgressTotal, localapcy.BusId);
    if ((localapcy.Status == 10) || (localapcy.Status == 9)) {
      if (localapcy.Id != null) {
        localTroopFileTransferManager.c(localapcy.Id);
      }
    }
    for (;;)
    {
      return true;
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
      return false;
      if (localapcy.Status != 7) {
        break;
      }
      localTroopFileTransferManager.a(localapcy.FilePath, localapcy.FileName, localapcy.ProgressTotal, localapcy.BusId);
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : can not handle file info status[" + localapcy.Status + ",download error");
    return false;
  }
  
  public long getFileSize()
  {
    apcy localapcy = apsv.a(this.mApp, this.e);
    if (localapcy == null) {
      return 0L;
    }
    return localapcy.ProgressTotal;
  }
  
  public String getLocalFilePath()
  {
    apcy localapcy = apsv.a(this.mApp, this.e);
    if (localapcy != null) {
      return localapcy.LocalFile;
    }
    return "";
  }
  
  public String vV()
  {
    return this.e.frienduin + this.e.uniseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzn
 * JD-Core Version:    0.7.0.1
 */