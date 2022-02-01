import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class arxr
{
  protected static String cCY;
  protected static String imei;
  protected static String imsi;
  protected static String location;
  protected static String resolution;
  
  public static String A(boolean paramBoolean)
  {
    try
    {
      Context localContext = aroi.a().getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = localStringBuilder.append("imei=");
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = "";
        ((StringBuilder)localObject2).append((String)localObject1).append('&');
        localStringBuilder.append("model=").append(Build.MODEL).append('&');
        localStringBuilder.append("os=").append(Build.VERSION.RELEASE).append('&');
        localStringBuilder.append("apilevel=").append(Build.VERSION.SDK_INT).append('&');
        localObject2 = arwo.K(localContext);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localStringBuilder.append("network=").append((String)localObject1).append('&');
        localObject1 = localStringBuilder.append("sdcard=");
        if (!Environment.getExternalStorageState().equals("mounted")) {
          break label231;
        }
      }
      label231:
      for (int i = 1;; i = 0)
      {
        ((StringBuilder)localObject1).append(i).append('&');
        localStringBuilder.append("display=").append(getResolution()).append('&');
        localStringBuilder.append("manu=").append(Build.MANUFACTURER).append("&");
        localStringBuilder.append("wifi=").append(arwo.bH(localContext));
        return localStringBuilder.toString();
        localObject1 = getImei();
        break;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  public static String Dy()
  {
    if (TextUtils.isEmpty(cCY)) {
      cCY = "";
    }
    try
    {
      Object localObject = aroi.a().getContext();
      if (localObject != null)
      {
        cCY = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("wifi_mac_address", "");
        if (TextUtils.isEmpty(cCY))
        {
          cCY = auri.rv("7ef1aa");
          if (cCY != null)
          {
            localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
            ((SharedPreferences.Editor)localObject).putString("wifi_mac_address", cCY);
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return cCY;
  }
  
  public static String getCity()
  {
    return "";
  }
  
  public static String getImei()
  {
    Object localObject;
    if (TextUtils.isEmpty(imei))
    {
      imei = "";
      localObject = aroi.a().getContext();
      if (localObject != null)
      {
        imei = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("imei", "");
        if (!TextUtils.isEmpty(imei)) {}
      }
    }
    try
    {
      imei = auri.getIMEI("52b7f2");
      label61:
      if (imei != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("imei", imei);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return imei;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public static String getImsi()
  {
    Object localObject;
    if (TextUtils.isEmpty(imsi))
    {
      imsi = "";
      localObject = aroi.a().getContext();
      if (localObject != null)
      {
        imsi = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).getString("imsi", "");
        if (!TextUtils.isEmpty(imsi)) {}
      }
    }
    try
    {
      imsi = auri.ru("ea6862");
      label61:
      if (imsi != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("appcenter_mobileinfo", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("imsi", imsi);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return imsi;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public static String getLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String getLocation()
  {
    if (!TextUtils.isEmpty(location)) {
      return location;
    }
    Object localObject1 = aroi.a().getContext();
    if (localObject1 == null) {
      return "";
    }
    try
    {
      localObject1 = (LocationManager)((Context)localObject1).getSystemService("location");
      Object localObject2 = new Criteria();
      ((Criteria)localObject2).setCostAllowed(false);
      ((Criteria)localObject2).setAccuracy(2);
      localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
      if (localObject2 != null)
      {
        localObject1 = alky.a((LocationManager)localObject1, (String)localObject2);
        if (localObject1 == null) {
          return "";
        }
        double d1 = ((Location)localObject1).getLatitude();
        double d2 = ((Location)localObject1).getLongitude();
        localObject1 = d1 + "*" + d2;
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      arwt.e("getLocation", "getLocation>>>", localException);
    }
    return "";
  }
  
  public static String getMobileInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", aroi.a().getQUA3());
      localJSONObject.put("longitude", getLocation());
      localJSONObject.put("platform", aroi.a().getPlatform());
      localJSONObject.put("uin", aroi.a().getUin());
      localJSONObject.put("imei", getImei());
      localJSONObject.put("imei", getImei());
      localJSONObject.put("resolution", getResolution());
      localJSONObject.put("network", arwo.bE(aroi.a().getContext()));
      localJSONObject.put("wifimac", Dy());
      localJSONObject.put("mobile_pf", "1");
      localJSONObject.put("os_ver", Build.VERSION.RELEASE);
      localJSONObject.put("lang", getLanguage());
      localJSONObject.put("device", Build.DEVICE);
      localJSONObject.put("model_name", Build.MODEL);
      localJSONObject.put("sdk_ver", "1.5");
      localJSONObject.put("timezone", TimeZone.getDefault().getID());
      localJSONObject.put("city", getCity());
      localJSONObject.put("longitude", getLocation());
      localJSONObject.put("ret_code", "0");
      localJSONObject.put("qua", aroi.a().getQUA3());
      localJSONObject.put("qz_ver", aroi.a().getAppVersionName());
      localJSONObject.put("imsi", getImsi());
      localJSONObject.put("androidID", alla.getString(aroi.a().getContext().getContentResolver(), "android_id"));
      localJSONObject.put("os_api_level", Build.VERSION.SDK_INT);
      localJSONObject.put("sdkVersionCode", 1);
      localJSONObject.put("QVersionCode", aroi.a().getAppVersionCode());
      localJSONObject.put("brand", GlobalUtil.getInstance().getBrand());
      localJSONObject.put("manufacture", GlobalUtil.getInstance().getManufacture());
      localJSONObject.put("product", GlobalUtil.getInstance().getProduct());
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("getMobileInfo", "gather mobile info exception.");
      }
    }
  }
  
  public static String getResolution()
  {
    if (!TextUtils.isEmpty(resolution)) {
      return resolution;
    }
    WindowManager localWindowManager = (WindowManager)aroi.a().getContext().getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    return i + "x" + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxr
 * JD-Core Version:    0.7.0.1
 */