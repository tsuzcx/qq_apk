import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class iul
  extends ajrw
{
  public iul(QQServiceForAV paramQQServiceForAV) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(", nickname=").append(paramString).append(", gender=").append(paramInt1).append(", age=").append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "QQServiceForAV.onNearbyCardDownload(), isSuccess: " + paramBoolean + ", card = " + ((StringBuilder)localObject).toString());
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.getNearByProfile");
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("nickname", paramString);
    localIntent.putExtra("gender", paramInt1);
    localIntent.putExtra("age", paramInt2);
    localObject = (QQAppInterface)this.a.getAppRuntime();
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (QQAppInterface)this.a.getAppRuntime();
    }
    if (paramString != null) {
      paramString.getApp().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iul
 * JD-Core Version:    0.7.0.1
 */