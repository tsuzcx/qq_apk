import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.downloadnew.MyAppDialog;

public class hso
  implements View.OnClickListener
{
  public hso(MyAppDialog paramMyAppDialog, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hso
 * JD-Core Version:    0.7.0.1
 */