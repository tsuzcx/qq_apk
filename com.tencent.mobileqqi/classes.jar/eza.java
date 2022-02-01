import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.QzonePluginProxyActivity;

public class eza
  extends fct
{
  private String a;
  
  public eza()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    if (this.jdField_a_of_type_Long >= fco.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(Process.myPid())) / 12000L) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
    }
    label180:
    do
    {
      return;
      if (this.b == 1L)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.f();
        return;
      }
      if ((this.b == 4L) || (this.b == 5L))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(new String[] { this.jdField_a_of_type_JavaLangString });
        String str1;
        if (QzonePluginProxyActivity.a)
        {
          str1 = "1";
          if (!QzonePluginProxyActivity.b) {
            break label180;
          }
        }
        for (String str2 = "1";; str2 = "0")
        {
          ReportController.b(null, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, str1, str2, "1", "");
          QzonePluginProxyActivity.b = false;
          QzonePluginProxyActivity.a = false;
          return;
          str1 = "0";
          break;
        }
      }
    } while ((this.b != 50L) && (this.b != 51L));
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(new String[0]);
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Long > 2L) {
      this.jdField_a_of_type_Long -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    ((QQAppInterface)BaseApplicationImpl.a.a()).a(BaseApplicationImpl.a);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    if ("fake_p_msg".equals(paramString)) {
      this.jdField_a_of_type_Long = (fco.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(Process.myPid())) / 12000L - 2L);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eza
 * JD-Core Version:    0.7.0.1
 */