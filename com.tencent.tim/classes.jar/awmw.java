import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuReport.UserActionReport;
import cooperation.vip.pb.TianShuReport.UserCommReport;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;

public class awmw
{
  private static String Tn = "";
  private static String cRL = "";
  
  public static String Hi()
  {
    switch (aqiw.getNetworkType(BaseApplicationImpl.getContext()))
    {
    default: 
      return "UNKNOW";
    case 1: 
      return "WIFI";
    case 4: 
      return "4G";
    case 3: 
      return "3G";
    }
    return "2G";
  }
  
  public static TianShuReport.UserActionReport a(awmu paramawmu)
  {
    TianShuReport.UserActionReport localUserActionReport = new TianShuReport.UserActionReport();
    localUserActionReport.to_uid.set(String.valueOf(paramawmu.cRD));
    localUserActionReport.trace_id.set(String.valueOf(paramawmu.mTraceId));
    localUserActionReport.trace_num.set(paramawmu.eBX);
    localUserActionReport.trace_detail.set(String.valueOf(paramawmu.cRE));
    localUserActionReport.trace_index.set(String.valueOf(paramawmu.cRF));
    localUserActionReport.appid.set(String.valueOf(paramawmu.mAppId));
    localUserActionReport.page_id.set(String.valueOf(paramawmu.cNQ));
    localUserActionReport.item_id.set(String.valueOf(paramawmu.cNR));
    localUserActionReport.sub_item_id.set(String.valueOf(paramawmu.cRG));
    localUserActionReport.module_id.set(String.valueOf(paramawmu.mModuleId));
    localUserActionReport.sub_module_id.set(String.valueOf(paramawmu.cRH));
    localUserActionReport.position_id.set(String.valueOf(paramawmu.cRI));
    localUserActionReport.test_id.set(paramawmu.mTestId);
    localUserActionReport.rule_id.set(paramawmu.eBY);
    localUserActionReport.oper_time.set(paramawmu.aBn);
    localUserActionReport.action_id.set(paramawmu.mActionId);
    localUserActionReport.action_value.set(paramawmu.eBB);
    localUserActionReport.action_attr.set(paramawmu.eBZ);
    localUserActionReport.trigger_info.set(String.valueOf(paramawmu.cRJ));
    localUserActionReport.busi_info.set(String.valueOf(paramawmu.cRK));
    localUserActionReport.item_type.set(String.valueOf(paramawmu.cNS));
    return localUserActionReport;
  }
  
  public static TianShuReport.UserCommReport a()
  {
    TianShuReport.UserCommReport localUserCommReport = new TianShuReport.UserCommReport();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localUserCommReport.uid.set(str);
    localUserCommReport.guid.set(String.valueOf(getIMEI()));
    str = aczc.getCityCode();
    localUserCommReport.city_code.set(String.valueOf(str));
    localUserCommReport.platform.set("AND");
    localUserCommReport.client_type.set("SQ");
    localUserCommReport.app_version.set(AppSetting.getVersion());
    localUserCommReport.qua.set(String.valueOf(avpq.getQUA3()));
    localUserCommReport.network_type.set(Hi());
    localUserCommReport.mobile_type.set(String.valueOf(Build.MODEL));
    localUserCommReport.os_version.set(String.valueOf(aqgz.getDeviceOSVersion()));
    localUserCommReport.qimei.set(String.valueOf(getQIMEI()));
    return localUserCommReport;
  }
  
  public static String getIMEI()
  {
    if ((Tn != null) && (Tn.length() > 0)) {
      return Tn;
    }
    try
    {
      Tn = auri.getIMEI("07aa5e");
      label28:
      return Tn;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public static String getQIMEI()
  {
    if ((cRL != null) && (cRL.length() > 0)) {
      return cRL;
    }
    try
    {
      cRL = UserAction.getQIMEI();
      label25:
      return cRL;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public static Bundle parseUrlParams(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            QLog.e("tools", 1, "parseUrlParams", localIllegalArgumentException);
          }
        }
      }
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmw
 * JD-Core Version:    0.7.0.1
 */