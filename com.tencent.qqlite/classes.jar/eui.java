import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialogDevLock;

public class eui
  implements View.OnClickListener
{
  public eui(QQCustomDialogDevLock paramQQCustomDialogDevLock, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogDevLock, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogDevLock.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eui
 * JD-Core Version:    0.7.0.1
 */