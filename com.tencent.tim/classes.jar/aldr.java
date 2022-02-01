import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class aldr
  implements QQPermissionCallback
{
  public aldr(VipProfileCardPhotoHandlerActivity paramVipProfileCardPhotoHandlerActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "takePhoto requestPermission user denied");
    }
    aqha.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "takePhoto requestPermission user grant");
    }
    VipProfileCardPhotoHandlerActivity.a(this.a, ProfileActivity.a(this.a, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldr
 * JD-Core Version:    0.7.0.1
 */