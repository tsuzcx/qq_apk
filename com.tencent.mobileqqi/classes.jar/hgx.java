import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;

public class hgx
  implements View.OnClickListener
{
  public hgx(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgx
 * JD-Core Version:    0.7.0.1
 */