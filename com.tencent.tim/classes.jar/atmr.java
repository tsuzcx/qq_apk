import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager.3;
import com.tencent.tim.cloudfile.troopFile.AutoRetryManager.3.1;
import java.util.ArrayList;
import java.util.List;

public class atmr
  extends atgg
{
  public atmr(AutoRetryManager.3.1 param1, long paramLong) {}
  
  public void onCheckExistInRecentFolderCallback(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (!paramBoolean)
    {
      paramArrayOfByte1 = new ArrayList();
      paramArrayOfByte1.add(this.a.a.b);
      this.a.a.this$0.nO(paramArrayOfByte1);
      new atmt(AutoRetryManager.a(this.a.a.this$0), new atms(this, paramArrayOfByte4)).a(this.a.a.b);
      return;
    }
    if (audx.mI(this.a.l.getFilePath()))
    {
      atgi.a().a(this.a.l, this.a.l.getFilePath(), true);
      QLog.i("AutoRetryManager.TroopAutoSaveToCloud", 1, "copyFileToCloudDisc exist in AIORecentFolder, update localPath");
      return;
    }
    QLog.i("AutoRetryManager.TroopAutoSaveToCloud", 1, "copyFileToCloudDisc exist in AIORecentFolder, so not need to copy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmr
 * JD-Core Version:    0.7.0.1
 */