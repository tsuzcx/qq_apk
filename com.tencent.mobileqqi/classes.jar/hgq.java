import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class hgq
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public hgq(QQCustomDialog paramQQCustomDialog, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.onArrayItemClick != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.onArrayItemClick.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.customWhichToCallBack(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgq
 * JD-Core Version:    0.7.0.1
 */