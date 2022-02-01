import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.HornPublishActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.maproam.Utils;

public class cqm
  implements View.OnClickListener
{
  public cqm(HornPublishActivity paramHornPublishActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHornPublishActivity.a.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHornPublishActivity.b.a(new cqn(this));
    Utils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqm
 * JD-Core Version:    0.7.0.1
 */