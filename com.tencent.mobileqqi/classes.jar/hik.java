import android.app.ProgressDialog;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.open.agent.AuthorityActivity;

public class hik
  implements Runnable
{
  public hik(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if (this.a.w == 0) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131562746);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.a.a(this.a.getResources().getString(2131562443), new hil(this));
      return;
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.y);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hik
 * JD-Core Version:    0.7.0.1
 */