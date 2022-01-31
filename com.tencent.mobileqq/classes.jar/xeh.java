import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class xeh
  implements DialogInterface.OnClickListener
{
  public xeh(GoldMsgAioState paramGoldMsgAioState, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GoldMsgAioState.a(((QQCustomDialog)paramDialogInterface).getWindow(), this.jdField_a_of_type_AndroidContentContext, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xeh
 * JD-Core Version:    0.7.0.1
 */