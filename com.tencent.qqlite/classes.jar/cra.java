import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.SetSplashImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class cra
  extends cuj
{
  private String a;
  
  public cra()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    if ((this.b == 1L) && (SetSplashImpl.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
      }
      ReportController.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
      System.exit(-1);
    }
    if (this.jdField_a_of_type_Long >= cuf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.a(Process.myPid())) / 12000L) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (this.b == 1L)
      {
        MemoryManager.a().a();
        return;
      }
      if ((this.b == 3L) || (this.b == 4L))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[] { this.jdField_a_of_type_JavaLangString });
        return;
      }
    } while ((this.b != 50L) && (this.b != 51L));
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[0]);
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
    super.b(paramString);
    ((QQAppInterface)BaseApplicationImpl.a.a()).a(BaseApplicationImpl.a);
    this.jdField_a_of_type_JavaLangString = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.jdField_a_of_type_Long = (cuf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.a(Process.myPid())) / 12000L - 2L);
    }
    CoreService.a();
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.e();
    BaseApplicationImpl.a.a().onGuardEvent(1, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cra
 * JD-Core Version:    0.7.0.1
 */