import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wxx
  extends FriendListObserver
{
  public wxx(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (this.a.a == null) || (!this.a.a.a.equals(paramSetting.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "onGetHeadInfo， fail");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onGetHeadInfo: uin=" + paramSetting.uin);
    }
    String str2 = QQHeadDownloadHandler.a(paramSetting.url, paramSetting.bFaceFlags);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = MsfSdkUtils.insertMtype("QQHeadIcon", str2);
    }
    this.a.d = paramSetting.headImgTimestamp;
    ThreadManager.getUIHandler().post(new wxz(this, str1));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      ThreadManager.excute(new wxy(this), 32, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */