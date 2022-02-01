import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dhp
  implements DialogInterface.OnClickListener
{
  public dhp(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      this.a.b = true;
      SendMultiPictureHelper.a(this.a);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhp
 * JD-Core Version:    0.7.0.1
 */