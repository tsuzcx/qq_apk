import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.qphone.base.util.QLog;

public class aotm
  implements URLDrawableHandler
{
  public aotm(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload onFileDownloadFailed", new Object[0]));
    }
  }
  
  public void onFileDownloadStarted()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload onFileDownloadStarted", new Object[0]));
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload onFileDownloadSucceed", new Object[0]));
    }
  }
  
  public void publishProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload publishProgress", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */