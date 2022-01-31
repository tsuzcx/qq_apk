import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class bov
  implements View.OnClickListener
{
  bov(bou parambou, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bov
 * JD-Core Version:    0.7.0.1
 */