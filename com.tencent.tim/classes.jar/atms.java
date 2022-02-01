import android.text.TextUtils;
import com.tencent.cloudfile.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager.3;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager.3.1;
import com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity;

class atms
  implements atmt.a
{
  atms(atmr paramatmr, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean, TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity)
  {
    AutoRetryManager.a(this.a.a.a.this$0, paramTroopFileCopyInfoEntity, paramBoolean);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramTroopFileCopyInfoEntity.cloudId)))
    {
      FileInfo localFileInfo = athu.a(AutoRetryManager.a(this.a.a.a.this$0), this.a.a.l, false);
      localFileInfo.aioRecentFileExt.creatorUin = this.a.ayt;
      atgi.a().notifyAirCopySuccess(paramTroopFileCopyInfoEntity.cloudId.getBytes(), this.hL, localFileInfo);
      if (audx.mI(this.a.a.l.getFilePath())) {
        atgi.a().a(this.a.a.l, this.a.a.l.getFilePath(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atms
 * JD-Core Version:    0.7.0.1
 */