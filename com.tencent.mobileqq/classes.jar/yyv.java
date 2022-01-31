import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.device.AdCarrier;
import com.tencent.ad.tangram.device.AdDeviceIdMD5Digest;
import com.tencent.ad.tangram.device.AdMacAddressMD5Digest;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class yyv
{
  private static String a = "GdtDeviceUtil";
  
  @Deprecated
  public static final int a(Context paramContext)
  {
    return AdCarrier.getType(paramContext);
  }
  
  @Deprecated
  public static String a(Context paramContext)
  {
    return AdDeviceIdMD5Digest.get(paramContext);
  }
  
  @Deprecated
  public static qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      yxs.d(a, "getDeviceInfo error");
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new qq_ad_get.QQAdGet.DeviceInfo();
      Object localObject = a(paramContext);
      String str = b(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localDeviceInfo.muid.set((String)localObject);
        localDeviceInfo.muid_type.set(1);
        label58:
        localDeviceInfo.conn.set(yxu.a(paramContext));
        localObject = c(paramContext);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      try
      {
        int i = Integer.parseInt((String)localObject);
        localDeviceInfo.carrier_code.set(i);
        localDeviceInfo.os_ver.set(Build.VERSION.RELEASE);
        localDeviceInfo.qq_ver.set(yxv.a());
        localDeviceInfo.os_type.set(2);
        localDeviceInfo.app_version_id.set(AppSetting.a());
        localObject = GdtLocationUtil.INSTANCE.getLocation(paramContext);
        paramContext = localDeviceInfo;
        if (localObject == null) {
          continue;
        }
        paramContext = localDeviceInfo;
        if (localObject.length != 2) {
          continue;
        }
        paramContext = new qq_ad_get.QQAdGet.DeviceInfo.Location();
        paramContext.coordinates_type.set(0);
        paramContext.latitude.set(localObject[0]);
        paramContext.longitude.set(localObject[1]);
        localDeviceInfo.location.set(paramContext);
        return localDeviceInfo;
        if (!TextUtils.isEmpty(str))
        {
          localDeviceInfo.muid.set(str);
          localDeviceInfo.muid_type.set(3);
          break label58;
        }
        localDeviceInfo.muid_type.set(0);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          yxs.d(a, "initDeviceInfo", localThrowable);
        }
      }
    }
  }
  
  @Deprecated
  public static String b(Context paramContext)
  {
    return AdMacAddressMD5Digest.get(paramContext);
  }
  
  @Deprecated
  public static final String c(Context paramContext)
  {
    return AdCarrier.getCode(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyv
 * JD-Core Version:    0.7.0.1
 */