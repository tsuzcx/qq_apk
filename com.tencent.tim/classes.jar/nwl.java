import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class nwl
{
  public static String TAG = "ViolaBizUtils";
  private static String aoB = "8.0.6";
  
  public static JSONObject N()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewDidAppear", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static JSONObject O()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewDidDisappear", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static String Z(String paramString1, String paramString2)
  {
    String str = jpe.dO(paramString1);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      paramString1 = str + paramString1;
      paramString2 = jpa.getFilePath(paramString2);
    } while (TextUtils.isEmpty(paramString2));
    return paramString1 + "/" + paramString2;
  }
  
  public static String aB(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return Z(str, paramString);
  }
  
  public static JSONObject d(int paramInt)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", paramInt);
      localJSONObject1.put("pageRefresh", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static boolean el(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      String str;
      do
      {
        return false;
        str = Uri.parse(paramString).getQueryParameter("v_bid");
      } while (TextUtils.isEmpty(str));
      paramString = Z(str, paramString);
    } while ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()));
    return true;
  }
  
  public static String ff(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "-1";
    }
    return paramString;
  }
  
  public static String fg(String paramString)
  {
    SharedPreferences localSharedPreferences;
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences = awit.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        QLog.d(TAG, 1, "failed to getItem");
      }
    }
    else
    {
      return null;
    }
    return localSharedPreferences.getString(paramString, null);
  }
  
  public static String fh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        return paramString;
      } while (!paramString.contains("v_url_base64"));
      str = Uri.parse(paramString).getQueryParameter("v_url_base64");
    } while (TextUtils.isEmpty(str));
    return new String(Base64.decode(str, 0));
  }
  
  public static String kO()
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("platform", "Android");
        localJSONObject.put("osVersion", aqgz.getDeviceOSVersion());
        localJSONObject.put("appName", aqgz.getQQVersion());
        localJSONObject.put("appVersion", "3.4.4.3058");
        DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        i = (int)(FlexConvertUtils.getScreenHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        int k = (int)(FlexConvertUtils.getScreenWidth(BaseApplication.getContext()) / localDisplayMetrics.density);
        float f = localDisplayMetrics.density;
        localJSONObject.put("deviceWidth", Math.min(k, i));
        localJSONObject.put("deviceHeight", Math.max(k, i));
        localJSONObject.put("dpToPxRatio", f);
        localJSONObject.put("deviceModel", Build.MODEL);
        localJSONObject.put("violaVersion", aoB);
        localJSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        localJSONObject.put("appID", "1");
        localJSONObject.put("isDebug", 0);
        localJSONObject.put("navBarHeight", DisplayUtil.getNavigationBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        localJSONObject.put("deviceBrand", Build.BRAND);
        localJSONObject.put("appVersionId", "3.4.4");
        ayxa.initLiuHaiProperty(BaseActivity.sTopActivity);
        if (!ayxa.isLiuHaiUseValid()) {
          continue;
        }
        i = 1;
        localJSONObject.put("isLiuHai", i);
        if (aqux.Mv() != 1) {
          continue;
        }
        i = j;
        localJSONObject.put("isKindCard", i);
        localJSONObject.put("netType", jqc.getNetWorkType());
        localJSONObject.put("build", 100);
        if (BaseActivity.sTopActivity != null) {
          localJSONObject.put("nowNavBarHeight", CommonSuspensionGestureLayout.getNavigationBarHeight(BaseActivity.sTopActivity) / localDisplayMetrics.density);
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "env JSONException");
        continue;
      }
      return localJSONObject.toString();
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static String kP()
  {
    long l = System.currentTimeMillis();
    return "&time=" + String.valueOf(l).substring(0, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwl
 * JD-Core Version:    0.7.0.1
 */