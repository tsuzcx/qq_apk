import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class usx
  implements FMDialogUtil.FMDialogInterface
{
  usx(usw paramusw, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct) {}
  
  public void a()
  {
    ((DeviceMsgHandle)this.jdField_a_of_type_Usw.a.a.a(49)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceSingleStruct);
    DeviceSingleStructBuilder.a(this.jdField_a_of_type_Usw.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceSingleStruct);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usx
 * JD-Core Version:    0.7.0.1
 */