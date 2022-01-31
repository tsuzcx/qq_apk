import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;

public class biw
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public biw(AVActivity paramAVActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        return;
        paramDialogInterface.dismiss();
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a().jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a().jdField_a_of_type_Int == 2))
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 0);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.a.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 0);
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a().jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a().jdField_a_of_type_Int != 4));
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.r();
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a().j, 0);
      return;
    case 1: 
      paramDialogInterface.dismiss();
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 0);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 0);
      return;
    case 3: 
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 0);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     biw
 * JD-Core Version:    0.7.0.1
 */