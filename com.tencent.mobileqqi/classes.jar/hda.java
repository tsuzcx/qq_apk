import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.SoftReference;

public class hda
  implements View.OnClickListener
{
  public hda(QQCustomDialogWtihInput paramQQCustomDialogWtihInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    paramView = QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).getText().toString();
    if (paramView != null)
    {
      if ((!QQText.a(paramView)) && (!QQText.b(paramView))) {
        break label77;
      }
      paramView = (Context)QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).get();
      if (paramView != null)
      {
        paramView = new QQToast(paramView);
        paramView.c(2000);
        paramView.b(2131562962);
        paramView.a();
      }
    }
    label77:
    do
    {
      return;
      if (24 >= paramView.getBytes().length) {
        break;
      }
      paramView = (Context)QQCustomDialogWtihInput.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput).get();
    } while (paramView == null);
    paramView = new QQToast(paramView);
    paramView.c(2000);
    paramView.b(2131561490);
    paramView.a();
    return;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hda
 * JD-Core Version:    0.7.0.1
 */