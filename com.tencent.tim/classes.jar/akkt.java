import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class akkt
  implements QQPermissionCallback
{
  akkt(Context paramContext, String paramString, AppActivity paramAppActivity, Intent paramIntent) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "permissions deny");
    }
    aqha.a(this.c, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "permissions grant");
    }
    try
    {
      akks.getDefaultSharedPreferences(this.U).edit().putString("camera_photo_path", this.val$path).commit();
      this.c.startActivityForResult(this.A, 1001);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "takePhoto");
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, paramArrayOfString, new Object[0]);
      QQToast.a(this.U, 2131691243, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkt
 * JD-Core Version:    0.7.0.1
 */