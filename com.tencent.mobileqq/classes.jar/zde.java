import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.battery.BatteryStats;

public class zde
  extends zeq
{
  private String a;
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    MemoryManager.a().a(0, 0, this.c, this.d, 0L, 0L, 3);
    QQAppInterface.a().d();
    this.jdField_a_of_type_JavaLangString = paramString;
    CoreService.startCoreService(zeo.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.c();
  }
  
  protected void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zde
 * JD-Core Version:    0.7.0.1
 */