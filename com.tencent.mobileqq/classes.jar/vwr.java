import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

class vwr
  implements DialogInterface.OnClickListener
{
  vwr(vwp paramvwp, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramDialogInterface.putLong("switch_city" + this.jdField_a_of_type_Vwp.a.a.getCurrentAccountUin(), System.currentTimeMillis());
    paramDialogInterface.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwr
 * JD-Core Version:    0.7.0.1
 */