import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class txw
{
  public static int a;
  public static AtomicBoolean a;
  public static boolean a;
  public static int b;
  public static boolean b;
  public static int c = 25;
  public static int d = 2;
  public static int e = 2;
  public static int f;
  public static int g;
  public static int h;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 10;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Int != 0) {
      return;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(319);
    jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("strategy", 1);
    jdField_b_of_type_Int = localAladdinConfig.getIntegerFromString("ad_first_time", 10);
    c = localAladdinConfig.getIntegerFromString("ad_interval_time", 25);
    d = localAladdinConfig.getIntegerFromString("ad_pre_req", 2);
    e = localAladdinConfig.getIntegerFromString("ad_protect_gap", 2);
    f = localAladdinConfig.getIntegerFromString("ad_first_pos", 4);
    g = localAladdinConfig.getIntegerFromString("ad_interval_pos", 3);
    h = localAladdinConfig.getIntegerFromString("ad_protect_interval", 3);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    twp.a("VideoAdStrategy", "setAdStrategyFromAladin: strategy = " + jdField_a_of_type_Int + " adFirstTime = " + jdField_b_of_type_Int + " adIntervalTime = " + c + " adPreReq = " + d + " adProtectGap = " + e + " adFirstPos = " + f + " adIntervalPos = " + g + " adProtectInterval = " + h);
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      twp.a("VideoAdStrategyManager", "judge isNotVVStrategy : adStrategy = " + jdField_a_of_type_Int);
    }
    return (jdField_a_of_type_Int == 0) || (jdField_a_of_type_Int == 1);
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel()) {
      twp.a("VideoAdStrategyManager", "judge isNotTimeStrategy : adStrategy = " + jdField_a_of_type_Int);
    }
    return jdField_a_of_type_Int != 1;
  }
  
  public static boolean c()
  {
    return (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (jdField_a_of_type_Int == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txw
 * JD-Core Version:    0.7.0.1
 */