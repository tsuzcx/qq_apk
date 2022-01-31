import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.Timer;

class gae
  implements View.OnClickListener
{
  gae(gad paramgad, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = DialogUtil.a(this.jdField_a_of_type_Gad.a, 2131562645);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView.show();
    new Timer().schedule(new gaf(this, paramView), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gae
 * JD-Core Version:    0.7.0.1
 */