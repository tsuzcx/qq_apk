import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import java.util.ArrayList;

public class vsc
  implements DialogInterface.OnClickListener
{
  public vsc(DeviceMsgChatPie paramDeviceMsgChatPie, ArrayList paramArrayList, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DeviceMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsc
 * JD-Core Version:    0.7.0.1
 */