import android.view.View;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.item.DevicePicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vax
  implements ActionSheet.OnButtonClickListener
{
  public vax(DevicePicItemBuilder paramDevicePicItemBuilder, MessageForDeviceFile paramMessageForDeviceFile, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ("device_groupchat".equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.extStr)) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.a.a(49)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.b();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vax
 * JD-Core Version:    0.7.0.1
 */