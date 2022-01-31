import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

public class uyo
  implements FileManagerUtil.TipsClickedInterface
{
  public uyo(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("device_info", ((SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    SmartDevicePluginLoader.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView, "com.tencent.device.activities.DeviceUnBindActivity", -1, null, SmartDevicePluginProxyActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyo
 * JD-Core Version:    0.7.0.1
 */