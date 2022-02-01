import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.SafeReport.LogItem;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QSecRptController.1;
import com.tencent.qqprotect.common.QSecRptControllerImpl;
import mqq.app.MobileQQ;

public class asxw
{
  private static void a(QQAppInterface paramQQAppInterface, SafeReport.ReqBody paramReqBody)
  {
    if (paramReqBody == null) {
      return;
    }
    if (paramQQAppInterface == null) {
      paramQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    for (;;)
    {
      jnm.a(paramQQAppInterface, new asxx(), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    SafeReport.ReqBody localReqBody = new SafeReport.ReqBody();
    SafeReport.LogItem localLogItem = new SafeReport.LogItem();
    localLogItem.uint32_rpt_id.set(paramInt1);
    String str = gA(kU(paramInt1));
    paramString = str + "," + paramInt2 + "," + paramString;
    localLogItem.bytes_rpt_data.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.LogItem_reportdata.add(localLogItem);
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, paramString);
    }
    ThreadManager.post(new QSecRptController.1(paramQQAppInterface, localReqBody), 5, null, true);
  }
  
  public static void ao(String paramString, int paramInt1, int paramInt2)
  {
    r(paramString, paramInt1, 0, paramInt2);
  }
  
  public static void cN(String paramString, int paramInt)
  {
    r(paramString, paramInt, 0, 1);
  }
  
  public static String gA(int paramInt)
  {
    try
    {
      localObject = NetConnInfoCenter.GUID;
      String str2 = aqgz.getDeviceOSVersion();
      String str3 = aqgz.bd(MobileQQ.sMobileQQ);
      String str4 = asxv.Em();
      String str5 = asxv.En();
      String str6 = Build.CPU_ABI;
      String str7 = Build.MODEL;
      String str8 = Build.MANUFACTURER;
      asxz localasxz = new asxz();
      localasxz.a((byte[])localObject).a(str2).a(str3).a(str4).a(str5).a(str6).a(str7).a(str8);
      if (paramInt >= 2) {
        localasxz.a(asxv.getAppPackageName()).a(AppSetting.getAppId()).a(aqgz.getAndroidID()).a("").a("");
      }
      localObject = localasxz.toString();
    }
    catch (Throwable localThrowable)
    {
      do
      {
        Object localObject;
        localThrowable.printStackTrace();
        String str1 = ",,,,,,,";
      } while (paramInt < 2);
    }
    return localObject;
    return ",,,,,,," + ",,,,";
  }
  
  public static void gL(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0, null);
  }
  
  public static int kU(int paramInt)
  {
    if (paramInt > 100) {
      return 2;
    }
    return 1;
  }
  
  public static void r(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QSecRptControllerImpl.a().s(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  protected void s(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxw
 * JD-Core Version:    0.7.0.1
 */