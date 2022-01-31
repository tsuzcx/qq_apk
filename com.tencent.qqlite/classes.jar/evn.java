import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomSplitDialog;

public class evn
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public evn(QQCustomSplitDialog paramQQCustomSplitDialog, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.a.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     evn
 * JD-Core Version:    0.7.0.1
 */