import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.net.AdIPV4;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class yoy
{
  private static volatile int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "GdtDeviceInfoHelper";
  private static volatile Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      yny.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    ypc.a().a(paramContext, new ypd());
    Object localObject = AdDeviceInfo.create(paramContext);
    if (localObject != null) {}
    for (localObject = ((AdDeviceInfo.Result)localObject).deviceInfo; localObject == null; localObject = null)
    {
      yny.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid)) {
      localDeviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid);
    }
    localDeviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid_type);
    localDeviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).conn);
    localDeviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).carrier_code);
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver)) {
      localDeviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver);
    }
    localDeviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_type);
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).manufacturer)) {
      localDeviceInfo.manufacturer.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).manufacturer);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model)) {
      localDeviceInfo.device_brand_and_model.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).qadid)) {
      localDeviceInfo.qadid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).qadid);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac)) {
      localDeviceInfo.md5_mac.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id)) {
      localDeviceInfo.md5_android_id.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4)) {
      localDeviceInfo.client_ipv4.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4);
    }
    if (!TextUtils.isEmpty(yoc.a())) {
      localDeviceInfo.qq_ver.set(yoc.a());
    }
    localDeviceInfo.app_version_id.set(AppSetting.a());
    paramContext = GdtLocationUtil.INSTANCE.getLocation(paramContext);
    if ((paramContext != null) && (paramContext.length == 2))
    {
      localObject = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      ((qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).coordinates_type.set(0);
      ((qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).latitude.set(paramContext[0]);
      ((qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).longitude.set(paramContext[1]);
      localDeviceInfo.location.set((MessageMicro)localObject);
    }
    localDeviceInfo.is_googleplay_version.set(false);
    return localDeviceInfo;
  }
  
  public static ypa a(Context paramContext, yoz paramyoz)
  {
    if ((paramContext == null) || (paramyoz == null) || (Looper.myLooper() == Looper.getMainLooper()))
    {
      yny.d(jdField_a_of_type_JavaLangString, String.format("create businessId:%s error", new Object[] { paramyoz.jdField_a_of_type_JavaLangString }));
      return null;
    }
    yny.b(jdField_a_of_type_JavaLangString, String.format("create businessId:%s", new Object[] { paramyoz.jdField_a_of_type_JavaLangString }));
    long l = System.currentTimeMillis();
    ypc.a().a(paramContext, new ypd());
    ypa localypa = new ypa();
    localypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    a(paramContext, paramyoz, localypa);
    b(paramContext, paramyoz, localypa);
    c(paramContext, paramyoz, localypa);
    d(paramContext, paramyoz, localypa);
    localypa.jdField_a_of_type_JavaUtilList.add(AdReporterForAnalysis.createEventForDeviceInfoEnd(paramContext, String.valueOf(paramyoz.jdField_a_of_type_JavaLangString), System.currentTimeMillis() - l));
    e(paramContext, paramyoz, localypa);
    return localypa;
  }
  
  static void a(Context paramContext)
  {
    yny.b(jdField_a_of_type_JavaLangString, String.format("init %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean) }));
    if (jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_Boolean = true;
    AdIPV4.INSTANCE.init(paramContext);
    b(0L);
  }
  
  private static void a(Context paramContext, yoz paramyoz, ypa paramypa)
  {
    AdDeviceInfo.Result localResult = AdDeviceInfo.create(paramContext);
    com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo;
    if (localResult != null)
    {
      localDeviceInfo = localResult.deviceInfo;
      if ((paramContext != null) && (paramyoz != null) && (paramypa != null) && (paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null) && (localDeviceInfo != null)) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      localDeviceInfo = null;
      break;
      paramypa.jdField_a_of_type_JavaUtilList.addAll(localResult.eventsForAnalysis);
      if (!TextUtils.isEmpty(localDeviceInfo.muid)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid.set(localDeviceInfo.muid);
      }
      paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid_type.set(localDeviceInfo.muid_type);
      paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.conn.set(localDeviceInfo.conn);
      paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.carrier_code.set(localDeviceInfo.carrier_code);
      if (!TextUtils.isEmpty(localDeviceInfo.os_ver)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_ver.set(localDeviceInfo.os_ver);
      }
      paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.set(localDeviceInfo.os_type);
      if (!TextUtils.isEmpty(localDeviceInfo.manufacturer)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.manufacturer.set(localDeviceInfo.manufacturer);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.device_brand_and_model)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_brand_and_model.set(localDeviceInfo.device_brand_and_model);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.qadid)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qadid.set(localDeviceInfo.qadid);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.md5_mac)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_mac.set(localDeviceInfo.md5_mac);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.md5_android_id)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_android_id.set(localDeviceInfo.md5_android_id);
      }
    } while (TextUtils.isEmpty(localDeviceInfo.client_ipv4));
    paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.client_ipv4.set(localDeviceInfo.client_ipv4);
  }
  
  private static int b(yow paramyow)
  {
    int j = d(paramyow);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramyow.jdField_a_of_type_JavaLangString)) {
        i = 10;
      }
    }
    return i;
  }
  
  private static void b(long paramLong)
  {
    yny.b(jdField_a_of_type_JavaLangString, String.format("updateForAidTicketAndTaidTicket delayMillis:%d count:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(jdField_a_of_type_Int) }));
    AdThreadManager.INSTANCE.postDelayed(new GdtDeviceInfoHelper.1(paramLong), 4, paramLong);
  }
  
  private static void b(Context paramContext, yoz paramyoz, ypa paramypa)
  {
    boolean bool2 = false;
    if ((paramContext == null) || (paramyoz == null) || (paramypa == null) || (paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    paramyoz = akfu.a("gdt_tangram");
    if ((paramyoz != null) && (paramyoz.a != null))
    {
      qq_ad_get.QQAdGet.DeviceInfo.Location localLocation = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      localLocation.coordinates_type.set(0);
      localLocation.latitude.set(Double.valueOf(paramyoz.a.jdField_a_of_type_Double * 1000000.0D).intValue());
      localLocation.longitude.set(Double.valueOf(paramyoz.a.b * 1000000.0D).intValue());
      paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.set(localLocation);
    }
    boolean bool1 = bool2;
    if (paramyoz != null)
    {
      bool1 = bool2;
      if (paramyoz.a != null) {
        bool1 = true;
      }
    }
    paramypa = paramypa.jdField_a_of_type_JavaUtilList;
    if (bool1) {}
    for (long l = System.currentTimeMillis() - paramyoz.a.jdField_a_of_type_Long;; l = -2147483648L)
    {
      paramypa.add(AdReporterForAnalysis.createEventForLocation(paramContext, bool1, l));
      return;
    }
  }
  
  private static int c(yow paramyow)
  {
    int j = d(paramyow);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramyow.b)) {
        i = 1;
      }
    }
    return i;
  }
  
  private static void c(Context paramContext, yoz paramyoz, ypa paramypa)
  {
    int j = -2147483648;
    if ((paramContext == null) || (paramyoz == null) || (paramypa == null) || (paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramyoz.jdField_a_of_type_JavaLangString;
    paramyoz = you.a().a((String)localObject);
    int k;
    if (paramyoz != null)
    {
      yny.b(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket businessId:%s errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d aidTicket:%s taidTicket:%s", new Object[] { localObject, Integer.valueOf(paramyoz.jdField_a_of_type_Int), Long.valueOf(paramyoz.jdField_a_of_type_Long), paramyoz.jdField_a_of_type_JavaLangString, paramyoz.b }));
      if (!TextUtils.isEmpty(paramyoz.jdField_a_of_type_JavaLangString)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.aid_ticket.set(paramyoz.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramyoz.b)) {
        paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.set(paramyoz.b);
      }
      l = System.currentTimeMillis() - l;
      localObject = paramypa.jdField_a_of_type_JavaUtilList;
      k = b(paramyoz);
      if (paramyoz == null) {
        break label262;
      }
    }
    label262:
    for (int i = paramyoz.jdField_a_of_type_Int;; i = -2147483648)
    {
      ((List)localObject).add(AdReporterForAnalysis.createEventForAidTicket(paramContext, k, i, l));
      paramypa = paramypa.jdField_a_of_type_JavaUtilList;
      k = c(paramyoz);
      i = j;
      if (paramyoz != null) {
        i = paramyoz.jdField_a_of_type_Int;
      }
      paramypa.add(AdReporterForAnalysis.createEventForTaidTicket(paramContext, k, i, l));
      return;
      yny.d(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket return null, businessId:%s", new Object[] { localObject }));
      break;
    }
  }
  
  private static int d(yow paramyow)
  {
    if (paramyow == null) {}
    do
    {
      return 1;
      if (paramyow.jdField_a_of_type_Int == 0) {
        return 0;
      }
      if (paramyow.jdField_a_of_type_Int == -10001) {
        return 6;
      }
      if (paramyow.jdField_a_of_type_Int == -10008) {
        return 8;
      }
      if (paramyow.jdField_a_of_type_Int == -10009) {
        return 7;
      }
      if (paramyow.jdField_a_of_type_Int == 10010) {
        return 5;
      }
      if (paramyow.jdField_a_of_type_Int == -10011) {
        return 2;
      }
      if ((paramyow.jdField_a_of_type_Int == -10004) || (paramyow.jdField_a_of_type_Int == -10012) || (paramyow.jdField_a_of_type_Int == -21052) || (paramyow.jdField_a_of_type_Int == -22056)) {
        return 3;
      }
      if (paramyow.jdField_a_of_type_Int == -30014) {
        return 10;
      }
      if (paramyow.jdField_a_of_type_Int == -2147483648) {
        return 4;
      }
      if (paramyow.jdField_a_of_type_Int == -2147483647) {
        return 9;
      }
      if (paramyow.jdField_a_of_type_Int == -2147483646) {
        return 205;
      }
    } while (paramyow.jdField_a_of_type_Int != -2147483645);
    return 206;
  }
  
  private static void d(Context paramContext, yoz paramyoz, ypa paramypa)
  {
    if ((paramContext == null) || (paramyoz == null) || (paramypa == null) || (paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    if (!TextUtils.isEmpty(yoc.a())) {
      paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qq_ver.set(yoc.a());
    }
    paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.app_version_id.set(AppSetting.a());
    paramypa.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.is_googleplay_version.set(false);
  }
  
  private static void e(Context paramContext, yoz paramyoz, ypa paramypa)
  {
    if ((paramyoz != null) && (!TextUtils.isEmpty(paramyoz.jdField_a_of_type_JavaLangString))) {}
    for (String str = paramyoz.jdField_a_of_type_JavaLangString; (paramyoz == null) || (paramypa == null) || (paramypa.jdField_a_of_type_JavaUtilList == null) || (paramypa.jdField_a_of_type_JavaUtilList.isEmpty()); str = "null") {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      paramyoz = (Long)jdField_a_of_type_JavaUtilMap.get(str);
      if ((paramyoz != null) && (l - paramyoz.longValue() < 60000L)) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
    yny.b(jdField_a_of_type_JavaLangString, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramypa.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yoy
 * JD-Core Version:    0.7.0.1
 */