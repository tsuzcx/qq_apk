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

public class yyp
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
      yxp.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    yyt.a().a(paramContext, new yyu());
    Object localObject = AdDeviceInfo.create(paramContext);
    if (localObject != null) {}
    for (localObject = ((AdDeviceInfo.Result)localObject).deviceInfo; localObject == null; localObject = null)
    {
      yxp.d(jdField_a_of_type_JavaLangString, "create error");
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
    if (!TextUtils.isEmpty(yxs.a())) {
      localDeviceInfo.qq_ver.set(yxs.a());
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
  
  public static yyr a(Context paramContext, yyq paramyyq)
  {
    if ((paramContext == null) || (paramyyq == null) || (Looper.myLooper() == Looper.getMainLooper()))
    {
      yxp.d(jdField_a_of_type_JavaLangString, String.format("create businessId:%s error", new Object[] { paramyyq.jdField_a_of_type_JavaLangString }));
      return null;
    }
    yxp.b(jdField_a_of_type_JavaLangString, String.format("create businessId:%s", new Object[] { paramyyq.jdField_a_of_type_JavaLangString }));
    long l = System.currentTimeMillis();
    yyt.a().a(paramContext, new yyu());
    yyr localyyr = new yyr();
    localyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    a(paramContext, paramyyq, localyyr);
    b(paramContext, paramyyq, localyyr);
    c(paramContext, paramyyq, localyyr);
    d(paramContext, paramyyq, localyyr);
    localyyr.jdField_a_of_type_JavaUtilList.add(AdReporterForAnalysis.createEventForDeviceInfoEnd(paramContext, String.valueOf(paramyyq.jdField_a_of_type_JavaLangString), System.currentTimeMillis() - l));
    e(paramContext, paramyyq, localyyr);
    return localyyr;
  }
  
  static void a(Context paramContext)
  {
    yxp.b(jdField_a_of_type_JavaLangString, String.format("init %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean) }));
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
  
  private static void a(Context paramContext, yyq paramyyq, yyr paramyyr)
  {
    AdDeviceInfo.Result localResult = AdDeviceInfo.create(paramContext);
    com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo;
    if (localResult != null)
    {
      localDeviceInfo = localResult.deviceInfo;
      if ((paramContext != null) && (paramyyq != null) && (paramyyr != null) && (paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null) && (localDeviceInfo != null)) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      localDeviceInfo = null;
      break;
      paramyyr.jdField_a_of_type_JavaUtilList.addAll(localResult.eventsForAnalysis);
      if (!TextUtils.isEmpty(localDeviceInfo.muid)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid.set(localDeviceInfo.muid);
      }
      paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid_type.set(localDeviceInfo.muid_type);
      paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.conn.set(localDeviceInfo.conn);
      paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.carrier_code.set(localDeviceInfo.carrier_code);
      if (!TextUtils.isEmpty(localDeviceInfo.os_ver)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_ver.set(localDeviceInfo.os_ver);
      }
      paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.set(localDeviceInfo.os_type);
      if (!TextUtils.isEmpty(localDeviceInfo.manufacturer)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.manufacturer.set(localDeviceInfo.manufacturer);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.device_brand_and_model)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_brand_and_model.set(localDeviceInfo.device_brand_and_model);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.qadid)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qadid.set(localDeviceInfo.qadid);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.md5_mac)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_mac.set(localDeviceInfo.md5_mac);
      }
      if (!TextUtils.isEmpty(localDeviceInfo.md5_android_id)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_android_id.set(localDeviceInfo.md5_android_id);
      }
    } while (TextUtils.isEmpty(localDeviceInfo.client_ipv4));
    paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.client_ipv4.set(localDeviceInfo.client_ipv4);
  }
  
  private static int b(yym paramyym)
  {
    int j = d(paramyym);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramyym.jdField_a_of_type_JavaLangString)) {
        i = 10;
      }
    }
    return i;
  }
  
  private static void b(long paramLong)
  {
    yxp.b(jdField_a_of_type_JavaLangString, String.format("updateForAidTicketAndTaidTicket delayMillis:%d count:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(jdField_a_of_type_Int) }));
    AdThreadManager.INSTANCE.postDelayed(new GdtDeviceInfoHelper.1(paramLong), 4, paramLong);
  }
  
  private static void b(Context paramContext, yyq paramyyq, yyr paramyyr)
  {
    boolean bool2 = false;
    if ((paramContext == null) || (paramyyq == null) || (paramyyr == null) || (paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    paramyyq = akuf.a("gdt_tangram");
    if ((paramyyq != null) && (paramyyq.a != null))
    {
      qq_ad_get.QQAdGet.DeviceInfo.Location localLocation = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      localLocation.coordinates_type.set(0);
      localLocation.latitude.set(Double.valueOf(paramyyq.a.jdField_a_of_type_Double * 1000000.0D).intValue());
      localLocation.longitude.set(Double.valueOf(paramyyq.a.b * 1000000.0D).intValue());
      paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.set(localLocation);
    }
    boolean bool1 = bool2;
    if (paramyyq != null)
    {
      bool1 = bool2;
      if (paramyyq.a != null) {
        bool1 = true;
      }
    }
    paramyyr = paramyyr.jdField_a_of_type_JavaUtilList;
    if (bool1) {}
    for (long l = System.currentTimeMillis() - paramyyq.a.jdField_a_of_type_Long;; l = -2147483648L)
    {
      paramyyr.add(AdReporterForAnalysis.createEventForLocation(paramContext, bool1, l));
      return;
    }
  }
  
  private static int c(yym paramyym)
  {
    int j = d(paramyym);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramyym.b)) {
        i = 1;
      }
    }
    return i;
  }
  
  private static void c(Context paramContext, yyq paramyyq, yyr paramyyr)
  {
    int j = -2147483648;
    if ((paramContext == null) || (paramyyq == null) || (paramyyr == null) || (paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramyyq.jdField_a_of_type_JavaLangString;
    paramyyq = yyk.a().a((String)localObject);
    int k;
    if (paramyyq != null)
    {
      yxp.b(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket businessId:%s errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d aidTicket:%s taidTicket:%s", new Object[] { localObject, Integer.valueOf(paramyyq.jdField_a_of_type_Int), Long.valueOf(paramyyq.jdField_a_of_type_Long), paramyyq.jdField_a_of_type_JavaLangString, paramyyq.b }));
      if (!TextUtils.isEmpty(paramyyq.jdField_a_of_type_JavaLangString)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.aid_ticket.set(paramyyq.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramyyq.b)) {
        paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.set(paramyyq.b);
      }
      l = System.currentTimeMillis() - l;
      localObject = paramyyr.jdField_a_of_type_JavaUtilList;
      k = b(paramyyq);
      if (paramyyq == null) {
        break label262;
      }
    }
    label262:
    for (int i = paramyyq.jdField_a_of_type_Int;; i = -2147483648)
    {
      ((List)localObject).add(AdReporterForAnalysis.createEventForAidTicket(paramContext, k, i, l));
      paramyyr = paramyyr.jdField_a_of_type_JavaUtilList;
      k = c(paramyyq);
      i = j;
      if (paramyyq != null) {
        i = paramyyq.jdField_a_of_type_Int;
      }
      paramyyr.add(AdReporterForAnalysis.createEventForTaidTicket(paramContext, k, i, l));
      return;
      yxp.d(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket return null, businessId:%s", new Object[] { localObject }));
      break;
    }
  }
  
  private static int d(yym paramyym)
  {
    if (paramyym == null) {}
    do
    {
      return 1;
      if (paramyym.jdField_a_of_type_Int == 0) {
        return 0;
      }
      if (paramyym.jdField_a_of_type_Int == -10001) {
        return 6;
      }
      if (paramyym.jdField_a_of_type_Int == -10008) {
        return 8;
      }
      if (paramyym.jdField_a_of_type_Int == -10009) {
        return 7;
      }
      if (paramyym.jdField_a_of_type_Int == 10010) {
        return 5;
      }
      if (paramyym.jdField_a_of_type_Int == -10011) {
        return 2;
      }
      if ((paramyym.jdField_a_of_type_Int == -10004) || (paramyym.jdField_a_of_type_Int == -10012) || (paramyym.jdField_a_of_type_Int == -21052) || (paramyym.jdField_a_of_type_Int == -22056)) {
        return 3;
      }
      if (paramyym.jdField_a_of_type_Int == -30014) {
        return 10;
      }
      if (paramyym.jdField_a_of_type_Int == -2147483648) {
        return 4;
      }
      if (paramyym.jdField_a_of_type_Int == -2147483647) {
        return 9;
      }
      if (paramyym.jdField_a_of_type_Int == -2147483646) {
        return 205;
      }
    } while (paramyym.jdField_a_of_type_Int != -2147483645);
    return 206;
  }
  
  private static void d(Context paramContext, yyq paramyyq, yyr paramyyr)
  {
    if ((paramContext == null) || (paramyyq == null) || (paramyyr == null) || (paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    if (!TextUtils.isEmpty(yxs.a())) {
      paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qq_ver.set(yxs.a());
    }
    paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.app_version_id.set(AppSetting.a());
    paramyyr.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.is_googleplay_version.set(false);
  }
  
  private static void e(Context paramContext, yyq paramyyq, yyr paramyyr)
  {
    if ((paramyyq != null) && (!TextUtils.isEmpty(paramyyq.jdField_a_of_type_JavaLangString))) {}
    for (String str = paramyyq.jdField_a_of_type_JavaLangString; (paramyyq == null) || (paramyyr == null) || (paramyyr.jdField_a_of_type_JavaUtilList == null) || (paramyyr.jdField_a_of_type_JavaUtilList.isEmpty()); str = "null") {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      paramyyq = (Long)jdField_a_of_type_JavaUtilMap.get(str);
      if ((paramyyq != null) && (l - paramyyq.longValue() < 60000L)) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
    yxp.b(jdField_a_of_type_JavaLangString, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramyyr.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyp
 * JD-Core Version:    0.7.0.1
 */