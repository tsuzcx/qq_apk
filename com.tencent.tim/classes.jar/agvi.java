import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class agvi
  implements agsv
{
  agvi(aguu paramaguu) {}
  
  public void djp()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.c.b();
    apcy localapcy = apsv.a(this.this$0.mAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(aguu.a(this.this$0))) && (localapcy.Id != null)) {
      aguu.a(this.this$0, localapcy.Id.toString());
    }
    apca localapca = new apca(localFileManagerEntity.TroopUin, this.this$0.mAppInterface, this.this$0.mContext);
    if (((localapcy.Status == 3) || (localapcy.Status == 2)) && (localapcy.Id != null)) {
      localapca.a(localapcy.Id);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void djq()
  {
    Object localObject = this.this$0.c.b();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.this$0.mAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = apsv.a(this.this$0.mAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(aguu.a(this.this$0)))
    {
      localTroopFileTransferManager.a(UUID.fromString(aguu.a(this.this$0)));
      aguu.a(this.this$0, (apcy)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvi
 * JD-Core Version:    0.7.0.1
 */