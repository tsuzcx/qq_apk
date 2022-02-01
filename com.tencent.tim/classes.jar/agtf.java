import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class agtf
  implements agsw
{
  private UUID d;
  private apcy e;
  protected QQAppInterface mAppInterface;
  
  public agtf(QQAppInterface paramQQAppInterface, apcy paramapcy)
  {
    this.e = paramapcy;
    this.d = this.e.Id;
    if (this.d == null) {
      throw new NullPointerException("TroopFileStatusInfo Id null");
    }
    this.mAppInterface = paramQQAppInterface;
  }
  
  public void JB(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.e.TroopUin);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.e.Id);
    if (localItem != null)
    {
      if (paramBoolean)
      {
        localTroopFileTransferManager.c(localItem, 12);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VideoForTroop<QFile>", 1, "notifyFileFaild isInvalid[" + paramBoolean + "], itemStatus[" + localItem.Status + "]");
      }
      if ((!apbr.a.lZ(localItem.Status)) && (this.e.Status != 7)) {
        break label134;
      }
      localTroopFileTransferManager.c(localItem, 10);
    }
    for (;;)
    {
      agkw.a(this);
      return;
      label134:
      localTroopFileTransferManager.c(localItem, 3);
    }
  }
  
  public void Jk(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.e.TroopUin);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.e.Id);
    if (localItem != null)
    {
      boolean bool = apbr.a.lZ(localItem.Status);
      if (QLog.isColorLevel()) {
        QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + localItem.Status + "]");
      }
      if ((!bool) && (this.e.Status != 7)) {
        break label126;
      }
      localItem.LocalFile = paramString;
      localTroopFileTransferManager.c(localItem, 11);
    }
    for (;;)
    {
      agkw.a(this);
      return;
      label126:
      localTroopFileTransferManager.c(localItem, 6);
    }
  }
  
  public void a(agkw.a parama)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.e.TroopUin);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.e.FilePath, this.e.FileName, this.e.ProgressTotal, this.e.BusId, new agtg(this, parama));
  }
  
  public String getFileName()
  {
    return this.e.FileName;
  }
  
  public long getFileSize()
  {
    return this.e.ProgressTotal;
  }
  
  public void jL(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.e.TroopUin);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.e.Id);
    } while (localItem == null);
    localItem.ProgressValue = paramLong;
    localTroopFileTransferManager.c(localItem, 8);
  }
  
  public String vL()
  {
    return ahaf.a().wa() + atad.toMD5(this.e.FilePath);
  }
  
  public String ve()
  {
    return this.e.FilePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */