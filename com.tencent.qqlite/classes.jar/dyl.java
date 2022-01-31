import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.log.ReportLogHelper;
import java.util.Timer;

class dyl
  implements View.OnClickListener
{
  dyl(dyk paramdyk, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = ReportLogHelper.a(this.jdField_a_of_type_Dyk.a, 2131363569);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView.show();
    new Timer().schedule(new dym(this, paramView), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyl
 * JD-Core Version:    0.7.0.1
 */