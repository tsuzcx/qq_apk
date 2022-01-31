import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class tmy
  implements Runnable
{
  public tmy(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
      return;
    }
    Object localObject1 = localObject2;
    if (!((String)localObject2).startsWith("http://")) {
      localObject1 = "http://" + (String)localObject2;
    }
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.app, "CliOper", "", "", "0X800665B", "0X800665B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmy
 * JD-Core Version:    0.7.0.1
 */