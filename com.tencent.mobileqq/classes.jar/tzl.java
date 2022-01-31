import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

class tzl
  implements Runnable
{
  tzl(tzk paramtzk, String paramString) {}
  
  public void run()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_Tzk.a.app.getManager(60);
    if (localSubAccountManager != null) {
      localSubAccountManager.a(this.jdField_a_of_type_JavaLangString, 0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tzl
 * JD-Core Version:    0.7.0.1
 */