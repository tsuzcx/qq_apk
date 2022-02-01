import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.troopFile.CopyToCloudProcessor.1;
import com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity;

public class atmt
{
  private final String TAG = "CopyToCloudProcessor.TroopAutoSaveToCloud";
  private atmt.a a;
  private int count;
  private QQAppInterface mApp;
  
  public atmt(QQAppInterface paramQQAppInterface, atmt.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.a = parama;
  }
  
  public void a(TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity)
  {
    if (paramTroopFileCopyInfoEntity == null)
    {
      if (QLog.isDebugVersion()) {
        QLog.i("CopyToCloudProcessor.TroopAutoSaveToCloud", 1, "entity is null!");
      }
      return;
    }
    if (!((atgc)this.mApp.getManager(373)).aJe())
    {
      this.count += 1;
      if (this.count > 10)
      {
        QLog.e("CopyToCloudProcessor.TroopAutoSaveToCloud", 1, "sdk is 10m not init! so cancel!");
        this.a.a(false, paramTroopFileCopyInfoEntity);
        return;
      }
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new CopyToCloudProcessor.1(this, paramTroopFileCopyInfoEntity), 60000L);
      QLog.w("CopyToCloudProcessor.TroopAutoSaveToCloud", 1, "sdk is not init! delay 60 secend!");
      return;
    }
    auqa.a(this.mApp, true, paramTroopFileCopyInfoEntity.troopUin, paramTroopFileCopyInfoEntity, new atmu(this, paramTroopFileCopyInfoEntity));
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmt
 * JD-Core Version:    0.7.0.1
 */