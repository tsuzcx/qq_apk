import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;

public class bet
  implements View.OnClickListener
{
  public bet(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    ((RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).b(String.valueOf(100005));
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramView = new Intent(this.a.a(), IndividuationSetActivity.class);
    this.a.a(paramView);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting_native", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bet
 * JD-Core Version:    0.7.0.1
 */