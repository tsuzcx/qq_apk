import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
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

public class trd
{
  public static String a = "ViolaBizUtils";
  private static String b = "8.0.6";
  
  public static String a()
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("platform", "Android");
        localJSONObject.put("osVersion", bgln.e());
        localJSONObject.put("appName", bgln.c());
        localJSONObject.put("appVersion", "8.4.1.4680");
        DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        float f1 = FlexConvertUtils.getScreenHeight(BaseApplication.getContext()) / localDisplayMetrics.density;
        float f2 = FlexConvertUtils.getScreenWidth(BaseApplication.getContext()) / localDisplayMetrics.density;
        float f3 = localDisplayMetrics.density;
        localJSONObject.put("deviceWidth", Math.min(f2, f1));
        localJSONObject.put("deviceHeight", Math.max(f2, f1));
        localJSONObject.put("dpToPxRatio", f3);
        localJSONObject.put("deviceModel", Build.MODEL);
        localJSONObject.put("violaVersion", b);
        localJSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        localJSONObject.put("appID", "1");
        localJSONObject.put("isDebug", 0);
        localJSONObject.put("navBarHeight", DisplayUtil.getNavigationBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        localJSONObject.put("deviceBrand", Build.BRAND);
        localJSONObject.put("appVersionId", "8.4.1");
        bqcd.a(BaseActivity.sTopActivity);
        if (!bqcd.b()) {
          continue;
        }
        i = 1;
        localJSONObject.put("isLiuHai", i);
        if (bhhb.a() != 1) {
          continue;
        }
        i = j;
        localJSONObject.put("isKindCard", i);
        localJSONObject.put("netType", nlw.a());
        localJSONObject.put("build", 102);
        if (BaseActivity.sTopActivity != null) {
          localJSONObject.put("nowNavBarHeight", CommonSuspensionGestureLayout.a(BaseActivity.sTopActivity) / localDisplayMetrics.density);
        }
        localJSONObject.put("androidVersion", Build.VERSION.SDK_INT);
      }
      catch (JSONException localJSONException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(a, 2, "env JSONException");
        continue;
      }
      return localJSONObject.toString();
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static String a(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "-1";
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = nku.a(paramString1);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      paramString1 = str + paramString1;
      paramString2 = nko.d(paramString2);
    } while (TextUtils.isEmpty(paramString2));
    return paramString1 + "/" + paramString2;
  }
  
  public static JSONObject a()
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
  
  public static JSONObject a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("receiveNewMessage", paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static boolean a(String paramString)
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
      paramString = a(str, paramString);
    } while ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()));
    return true;
  }
  
  public static float[] a()
  {
    float[] arrayOfFloat = new float[2];
    try
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        return arrayOfFloat;
      }
      localObject = ((Activity)localObject).getWindow().getDecorView();
      DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      float f2 = ((View)localObject).getWidth() / localDisplayMetrics.density;
      float f1 = ((View)localObject).getHeight() / localDisplayMetrics.density;
      f2 = Math.min(f2, f1);
      f1 = Math.max(f2, f1);
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = f1;
      return arrayOfFloat;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a, 1, "[getTopActivitySize]: " + localThrowable.getMessage());
    }
    return arrayOfFloat;
  }
  
  public static String b()
  {
    long l = System.currentTimeMillis();
    return "&time=" + String.valueOf(l).substring(0, 7);
  }
  
  public static String b(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return a(str, paramString);
  }
  
  public static JSONObject b()
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
  
  public static JSONObject b(int paramInt)
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
  
  public static String c(String paramString)
  {
    SharedPreferences localSharedPreferences;
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences = bmqa.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        QLog.d(a, 1, "failed to getItem");
      }
    }
    else
    {
      return null;
    }
    return localSharedPreferences.getString(paramString, null);
  }
  
  public static String d(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trd
 * JD-Core Version:    0.7.0.1
 */