import MQQ.PrivExtV2Rsp;
import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class til
  extends VipInfoObserver
{
  public til(QQSettingMe paramQQSettingMe) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt >= 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putInt("key_selfvip_growthvalue", paramInt).commit();
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoObserver");
      }
      this.a.b((String)localObject);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == VipInfoHandler.a) && (paramBoolean))
    {
      paramObject = ((PrivExtV2Rsp)paramObject).vipInfo;
      if (paramObject != null)
      {
        paramObject = paramObject.sUri;
        if (paramObject != null)
        {
          QQSettingMe.b(this.a, paramObject);
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "vip url = " + paramObject);
          }
          paramObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramObject);
          if (Build.VERSION.SDK_INT >= 9) {
            break label145;
          }
          paramObject.commit();
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new tim(this));
      return;
      label145:
      paramObject.apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     til
 * JD-Core Version:    0.7.0.1
 */