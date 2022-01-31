import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.base.CardViewController;
import java.util.HashMap;

public class wjl
  extends AsyncTask
{
  public wjl(CardViewController paramCardViewController, String paramString, wjp paramwjp) {}
  
  protected HashMap a(Void... paramVarArgs)
  {
    paramVarArgs = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramVarArgs = CardViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, this.jdField_a_of_type_JavaLangString);
    }
    return paramVarArgs;
  }
  
  protected void a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    String str = (String)paramHashMap.get("displayedStr ");
    paramHashMap = (String)paramHashMap.get("displayingStr ");
    CardViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, str);
    CardViewController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, paramHashMap);
    if (this.jdField_a_of_type_Wjp != null)
    {
      this.jdField_a_of_type_Wjp.a();
      return;
    }
    CardViewController.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjl
 * JD-Core Version:    0.7.0.1
 */