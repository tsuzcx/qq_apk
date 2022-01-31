import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

public class vox
  implements View.OnClickListener
{
  public vox(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(AppConstants.x))
    {
      if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        this.a.A();
        return;
      }
      paramView = new Intent();
      paramView.putExtra("nickname", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      paramView.putExtra("bitmap", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2, false));
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getString("square_url_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramView.putExtra("url", (String)localObject);
      }
      for (;;)
      {
        SmartDevicePluginLoader.a().a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
        return;
        paramView.putExtra("url", "http://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
      }
    }
    paramView = (SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject = paramView.a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      if (DeviceMsgChatPie.a(this.a)) {
        paramView.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (DeviceInfo)localObject, false);
      }
      this.a.A();
      return;
    }
    paramView.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (DeviceInfo)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vox
 * JD-Core Version:    0.7.0.1
 */