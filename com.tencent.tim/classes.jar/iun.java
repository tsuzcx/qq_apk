import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class iun
  extends acfd
{
  public iun(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.qqhead.getheadresp2");
    localIntent.putExtra("uin", paramString);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.getAppRuntime();
    if (this.a.iC.contains(paramString)) {
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    this.a.iC.remove(paramString);
    if (this.a.vy()) {
      localQQAppInterface.removeObserver(this.a.a);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo uin = " + paramString);
      QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo isSuccess = " + paramBoolean);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.getAppRuntime();
    Intent localIntent;
    if ((paramBoolean) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      localIntent.putExtra("uin", paramString);
      localObject = (acff)QQServiceForAV.m(this.a).getManager(51);
      if (localObject == null) {
        break label205;
      }
      localObject = ((acff)localObject).e(paramString);
      if (localObject == null) {
        break label205;
      }
    }
    label205:
    for (Object localObject = aqgv.c((Friends)localObject);; localObject = paramString)
    {
      localIntent.putExtra("nick", (String)localObject);
      localIntent.setPackage(localQQAppInterface.getApplication().getPackageName());
      localQQAppInterface.getApp().sendBroadcast(localIntent);
      this.a.iB.remove(paramString);
      if (this.a.vy()) {
        localQQAppInterface.removeObserver(this.a.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iun
 * JD-Core Version:    0.7.0.1
 */