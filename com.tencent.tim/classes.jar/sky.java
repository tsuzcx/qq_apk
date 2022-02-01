import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class sky
  extends aook
{
  public sky(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko;
    Bundle localBundle;
    if ((TroopMemberApiService.j(this.d) instanceof QQAppInterface))
    {
      localaoko = (aoko)paramMessage.obj;
      localBundle = new Bundle();
      localBundle.putInt("seq", this.d.bxz);
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
          if (localaoko.fileType != 64) {
            break;
          }
          this.d.bxx = aomd.bxx;
        } while (this.d.bxx == this.d.bxy);
        this.d.bxy = this.d.bxx;
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + this.d.bxx);
        }
        paramMessage = (ajrs)((QQAppInterface)TroopMemberApiService.k(this.d)).getBusinessHandler(60);
        if (paramMessage != null) {
          paramMessage.q(this.d.yc, this.d.bxx, true);
        }
        localBundle.putInt("head_id", this.d.bxx);
        localBundle.putString("video_id", this.d.yc);
        localBundle.putBoolean("isSuccess", true);
        this.d.j(75, localBundle);
        return;
        if (localaoko.fileType == 39)
        {
          this.d.yc = ((aomd)localaoko.a).yc;
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + this.d.yc);
          }
          ajrm.as((QQAppInterface)TroopMemberApiService.l(this.d), this.d.aEu);
          return;
        }
        localBundle.putBoolean("isSuccess", false);
        this.d.j(75, localBundle);
      } while (!QLog.isColorLevel());
      QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed. STATUS_SEND_ERROR");
    }
    localBundle.putBoolean("isSuccess", false);
    this.d.j(75, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sky
 * JD-Core Version:    0.7.0.1
 */