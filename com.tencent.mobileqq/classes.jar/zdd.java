import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkMediaPlayer;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.statistics.battery.BatteryStats;

public class zdd
  extends zeq
{
  protected long a;
  private String a;
  protected long b;
  
  protected void a()
  {
    boolean bool2 = true;
    super.a();
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    MemoryManager.a().a(0, 0, this.c, this.d, 0L, 0L, 3);
    if (this.d >= 3L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) {
        break label217;
      }
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(bool1, new String[] { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", this.jdField_a_of_type_JavaLangString });
      this.d = 0L;
      if (!bool1) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      }
    }
    if ((this.jdField_a_of_type_Long >= 15L) && (!DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.disable_qzone_kill.name())))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString != null)
      {
        bool1 = true;
        label153:
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(bool1, "com.tencent.mobileqq:qzone");
        StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else if (this.b >= GuardManager.d) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) {
        break label227;
      }
    }
    label217:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(bool1, "com.tencent.mobileqq:tool");
      this.b = 0L;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label153;
    }
  }
  
  protected void a(String paramString)
  {
    if (!"com.tencent.mobileqq".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
      ArkMediaPlayer.a();
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    QQAppInterface.a().d();
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    CoreService.startCoreService(zeo.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if ("com.tencent.mobileqq".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      ArkMediaPlayer.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdd
 * JD-Core Version:    0.7.0.1
 */