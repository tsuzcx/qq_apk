import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

public class dfk
  implements Runnable
{
  public dfk(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString) {}
  
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
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.a(), QQBrowserActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dfk
 * JD-Core Version:    0.7.0.1
 */