import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.widgets.ShareAioResultDialog;

public class bpl
  implements View.OnClickListener
{
  public bpl(ShareAioResultDialog paramShareAioResultDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog, 0);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpl
 * JD-Core Version:    0.7.0.1
 */