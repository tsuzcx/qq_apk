import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

class vtp
  implements DialogInterface.OnClickListener
{
  vtp(vtn paramvtn, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramDialogInterface.putLong("switch_city" + this.jdField_a_of_type_Vtn.a.a.getCurrentAccountUin(), System.currentTimeMillis());
    paramDialogInterface.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtp
 * JD-Core Version:    0.7.0.1
 */