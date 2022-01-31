import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class txu
  implements View.OnClickListener
{
  public txu(TroopInfoActivity paramTroopInfoActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txu
 * JD-Core Version:    0.7.0.1
 */