import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.MQPIntChkHandler;

public class fdi
  implements DialogInterface.OnClickListener
{
  public fdi(MQPIntChkHandler paramMQPIntChkHandler, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MQPIntChkHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMQPIntChkHandler, paramDialogInterface, paramInt, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdi
 * JD-Core Version:    0.7.0.1
 */