import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class vxf
  implements DialogInterface.OnClickListener
{
  public vxf(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.jdField_a_of_type_AndroidContentContext, TroopLowCreditLevelNotifyActivity.class);
    paramDialogInterface.putExtra("troopUin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */