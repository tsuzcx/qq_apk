import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialogDevLock;

public class hgt
  implements View.OnClickListener
{
  public hgt(QQCustomDialogDevLock paramQQCustomDialogDevLock, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogDevLock, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogDevLock.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgt
 * JD-Core Version:    0.7.0.1
 */