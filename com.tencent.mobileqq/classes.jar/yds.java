import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public final class yds
{
  protected static yds a;
  private static String b = "smartdevice::smartdevicereport";
  public int a;
  public long a;
  public String a;
  
  protected yds()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static yds a()
  {
    try
    {
      if (jdField_a_of_type_Yds == null) {
        jdField_a_of_type_Yds = new yds();
      }
      yds localyds = jdField_a_of_type_Yds;
      return localyds;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDReport", 2, "action:" + paramString + " fromType:" + paramInt1 + " result:" + paramInt2 + " din:" + paramLong + " ext2:" + paramInt3);
    }
    a(paramAppRuntime, paramString, "" + paramLong, paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDReport", 2, "action:" + paramString + " fromType:" + paramInt1 + " result:" + paramInt2 + " ext2:" + paramInt3);
    }
    a(paramAppRuntime, paramString, "", paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "smartdevice datareport, actionname:" + paramString1 + ", fromType:" + paramInt1 + ", actionResult = " + paramInt2 + ", ext2:" + paramInt3 + ", ext3:" + paramInt4 + ", ext4:" + paramString3 + ", ext5:" + paramString4);
    }
    String str1 = "" + paramInt3;
    String str2 = "" + paramInt4;
    if (paramString3 == null)
    {
      paramAppRuntime = "";
      if (paramString4 != null) {
        break label198;
      }
    }
    label198:
    for (paramString3 = "";; paramString3 = paramString4)
    {
      awqx.b(localQQAppInterface, "CliOper", "", paramString2, "SmartDevice", paramString1, paramInt1, paramInt2, str1, str2, paramAppRuntime, paramString3);
      return;
      paramAppRuntime = paramString3;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    if (0L == this.jdField_a_of_type_Long) {}
    for (this.jdField_a_of_type_Long = (new Random().nextInt() & 0xFFFFFFFF);; this.jdField_a_of_type_Long += 1L) {
      switch (paramInt)
      {
      default: 
        this.jdField_a_of_type_Long %= 1431655765L;
        if (0L == this.jdField_a_of_type_Long) {
          this.jdField_a_of_type_Long += 1L;
        }
        return;
      }
    }
    this.jdField_a_of_type_Long = (this.jdField_a_of_type_Long % 1431655765L + 1431655765L);
    return;
    this.jdField_a_of_type_Long = (this.jdField_a_of_type_Long % 1431655765L + 2863311530L);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    b(paramAppRuntime, paramString, paramInt);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
    }
    if (paramString2 == null) {}
    for (paramAppRuntime = "";; paramAppRuntime = paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "smartdevice datareport2, actionname:" + paramString1 + ",result:" + paramInt1 + ", pid:" + paramInt2 + ",sn:" + paramAppRuntime);
      }
      awqx.b(localQQAppInterface, "CliOper", "", "" + paramLong, "SmartDevice", paramString1, paramInt1, 0, Long.toString(paramInt2), "", paramAppRuntime, "");
      return;
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
    }
    long l = this.jdField_a_of_type_Long & 0xFFFFFFFF;
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramAppRuntime = "";; paramAppRuntime = this.jdField_a_of_type_JavaLangString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "smartdevice datareport, actionname:" + paramString + ",result:" + paramInt + ", pid:" + Long.toString(this.jdField_a_of_type_Int) + ",sn:" + paramAppRuntime + ",seq:" + Long.toString(l));
      }
      if ((!"Net_Wifi_Config_Time_Used".equals(paramString)) && (!"Net_Wifi_Config_Ack_Time_Used".equals(paramString))) {
        break;
      }
      awqx.b(localQQAppInterface, "CliOper", "", "0", "SmartDevice", paramString, 0, paramInt, Long.toString(this.jdField_a_of_type_Int), Long.toString(l), paramAppRuntime, "");
      return;
    }
    awqx.b(localQQAppInterface, "CliOper", "", "0", "SmartDevice", paramString, paramInt, 0, Long.toString(this.jdField_a_of_type_Int), Long.toString(l), paramAppRuntime, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yds
 * JD-Core Version:    0.7.0.1
 */