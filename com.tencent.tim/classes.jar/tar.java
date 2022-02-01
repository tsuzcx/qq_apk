import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public final class tar
{
  private static String TAG = "smartdevice::smartdevicereport";
  protected static tar a;
  public long DU = 0L;
  public String aIF = "";
  public int bAQ = 0;
  
  public static tar a()
  {
    try
    {
      if (a == null) {
        a = new tar();
      }
      tar localtar = a;
      return localtar;
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
      QLog.d(TAG, 2, "smartdevice datareport, actionname:" + paramString1 + ", fromType:" + paramInt1 + ", actionResult = " + paramInt2 + ", ext2:" + paramInt3 + ", ext3:" + paramInt4 + ", ext4:" + paramString3 + ", ext5:" + paramString4);
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
      anot.a(localQQAppInterface, "CliOper", "", paramString2, "SmartDevice", paramString1, paramInt1, paramInt2, str1, str2, paramAppRuntime, paramString3);
      return;
      paramAppRuntime = paramString3;
      break;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    b(paramAppRuntime, paramString, paramInt);
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
    }
    long l = this.DU & 0xFFFFFFFF;
    if (this.aIF == null) {}
    for (paramAppRuntime = "";; paramAppRuntime = this.aIF)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "smartdevice datareport, actionname:" + paramString + ",result:" + paramInt + ", pid:" + Long.toString(this.bAQ) + ",sn:" + paramAppRuntime + ",seq:" + Long.toString(l));
      }
      if ((!"Net_Wifi_Config_Time_Used".equals(paramString)) && (!"Net_Wifi_Config_Ack_Time_Used".equals(paramString))) {
        break;
      }
      anot.a(localQQAppInterface, "CliOper", "", "0", "SmartDevice", paramString, 0, paramInt, Long.toString(this.bAQ), Long.toString(l), paramAppRuntime, "");
      return;
    }
    anot.a(localQQAppInterface, "CliOper", "", "0", "SmartDevice", paramString, paramInt, 0, Long.toString(this.bAQ), Long.toString(l), paramAppRuntime, "");
  }
  
  public void zh(int paramInt)
  {
    if (0L == this.DU) {}
    for (this.DU = (new Random().nextInt() & 0xFFFFFFFF);; this.DU += 1L) {
      switch (paramInt)
      {
      default: 
        this.DU %= 1431655765L;
        if (0L == this.DU) {
          this.DU += 1L;
        }
        return;
      }
    }
    this.DU = (this.DU % 1431655765L + 1431655765L);
    return;
    this.DU = (this.DU % 1431655765L + 2863311530L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tar
 * JD-Core Version:    0.7.0.1
 */