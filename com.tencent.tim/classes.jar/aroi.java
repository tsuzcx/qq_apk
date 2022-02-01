import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class aroi
{
  protected static String PLATFORM = "androidqq";
  protected static aroi a;
  protected String A2 = "";
  protected long awc;
  protected String cBf = "";
  protected String cBg = "";
  protected String cBh = "";
  protected Context mContext = BaseApplication.getContext();
  protected int mVersionCode = -1;
  protected String mVersionName = "";
  protected String reportData = "";
  protected String skey = "";
  protected long uin;
  
  public static aroi a()
  {
    try
    {
      if (a == null) {
        a = new aroi();
      }
      aroi localaroi = a;
      return localaroi;
    }
    finally {}
  }
  
  public String Db()
  {
    return this.reportData;
  }
  
  public void WH(String paramString)
  {
    this.skey = paramString;
  }
  
  public void WI(String paramString)
  {
    this.A2 = paramString;
  }
  
  public void WJ(String paramString)
  {
    this.reportData = paramString;
  }
  
  public void a(String paramString, Context paramContext, WebView paramWebView)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("imei", arxr.getImei());
      localJSONObject2.put("imsi", arxr.getImsi());
      localJSONObject2.put("mac_addr", arxr.Dy());
      localJSONObject2.put("model_info", Build.MODEL);
      localJSONObject2.put("network_type", arwo.bE(a().getContext()));
      localJSONObject2.put("network_operater", "");
      localJSONObject2.put("location", arxr.getLocation());
      localJSONObject2.put("android_id", alla.getString(a().getContext().getContentResolver(), "android_id"));
      localJSONObject2.put("os_api_level", Build.VERSION.SDK_INT);
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("params");
      if ((localJSONObject3 != null) && (localJSONObject3.length() > 0))
      {
        Iterator localIterator = localJSONObject3.keys();
        while (localIterator.hasNext())
        {
          String str2 = localIterator.next().toString();
          Object localObject = localJSONObject3.get(str2);
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject2.put(str2, localObject);
          }
        }
      }
      String str1;
      return;
    }
    catch (JSONException localJSONException)
    {
      arwt.e("AppUpdate", "getUpdateApp parse H5 params error : " + localJSONException.toString());
      if (!paramContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
      {
        arwt.d("AppUpdate", "getUpdateApp will do full report");
        arxu.a(paramContext, paramString, paramWebView, String.valueOf(a().getUin()), false);
        return;
        if (localJSONObject3 != null) {
          localJSONObject2.put("latest_used", b(localJSONObject3.optInt("latest_num", 10), paramContext));
        }
        for (;;)
        {
          localJSONException.put("params", localJSONObject2);
          str1 = localJSONException.toString();
          paramString = str1;
          break;
          localJSONObject2.put("latest_used", b(10, paramContext));
        }
      }
      if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
      {
        arwt.d("AppUpdate", "getUpdateApp will do incremental report");
        arxu.a(paramContext, null, 0, paramString, paramWebView, String.valueOf(a().getUin()));
        return;
      }
      arwt.d("AppUpdate", "getUpdateApp will get update app directly");
      arxv.a(paramContext, paramWebView, paramString, true, String.valueOf(a().getUin()));
    }
  }
  
  public String b(int paramInt, Context paramContext)
  {
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    PackageManager localPackageManager = paramContext.getPackageManager();
    int j = paramInt;
    if (paramInt <= 0) {
      j = 5;
    }
    localObject1 = ((ActivityManager)localObject1).getRecentTasks(64, 1);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int n;
    int k;
    Object localObject2;
    if (localObject1 != null)
    {
      n = ((List)localObject1).size();
      k = 0;
      paramInt = 0;
      if ((k < n) && (paramInt < j))
      {
        localObject2 = (ActivityManager.RecentTaskInfo)((List)localObject1).get(k);
        paramContext = ((ActivityManager.RecentTaskInfo)localObject2).baseIntent;
        localObject2 = ((ActivityManager.RecentTaskInfo)localObject2).origActivity;
        if (localObject2 != null) {
          paramContext = ((ComponentName)localObject2).getPackageName();
        }
      }
    }
    for (;;)
    {
      label135:
      int i = paramInt;
      if (paramContext != null)
      {
        if (localArrayList.contains(paramContext)) {}
        for (;;)
        {
          k += 1;
          break;
          if (paramContext == null) {
            break label398;
          }
          paramContext = paramContext.getComponent().getPackageName();
          break label135;
          localArrayList.add(paramContext);
          i = -1;
          try
          {
            localObject2 = localPackageManager.getPackageInfo(paramContext, 0);
            if (localObject2 != null) {
              break label208;
            }
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        label208:
        if (localObject2 != null)
        {
          i = ((PackageInfo)localObject2).versionCode;
          String str = ((PackageInfo)localObject2).versionName;
        }
        if ((((PackageInfo)localObject2).applicationInfo.flags & 0x1) == 0) {
          break label392;
        }
      }
      label392:
      for (int m = 1;; m = 0)
      {
        paramInt += 1;
        localStringBuilder.append("\"");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("\"");
        localStringBuilder.append(":");
        localStringBuilder.append("\"");
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        localStringBuilder.append(m);
        localStringBuilder.append("\"");
        i = paramInt;
        if (k < n - 1)
        {
          localStringBuilder.append(",");
          i = paramInt;
        }
        paramInt = i;
        break;
        paramInt = localStringBuilder.length();
        if (localStringBuilder.charAt(paramInt - 1) == ',') {
          localStringBuilder.deleteCharAt(paramInt - 1);
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      label398:
      paramContext = null;
    }
  }
  
  protected void ekF()
  {
    Object localObject = a().getContext().getApplicationContext();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      this.mVersionName = ((PackageInfo)localObject).versionName;
      this.cBf = (this.mVersionName + "." + ((PackageInfo)localObject).versionCode);
      this.cBg = this.mVersionName.substring(this.mVersionName.lastIndexOf('.') + 1, this.mVersionName.length());
      this.mVersionCode = ((PackageInfo)localObject).versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      arwt.e("AppUpdate", "getPackageInfo NameNotFoundException : " + localNameNotFoundException.toString());
      return;
    }
    catch (Exception localException)
    {
      arwt.e("AppUpdate", "getPackageInfo exception : " + localException.toString());
    }
  }
  
  public String getA2()
  {
    return this.A2;
  }
  
  public String getAgentVersion()
  {
    return "12";
  }
  
  public int getAppVersionCode()
  {
    if (this.mVersionCode != -1) {
      return this.mVersionCode;
    }
    ekF();
    return this.mVersionCode;
  }
  
  public String getAppVersionName()
  {
    if (!TextUtils.isEmpty(this.cBf)) {
      return this.cBf;
    }
    ekF();
    return this.cBf;
  }
  
  public Context getContext()
  {
    if (this.mContext == null) {
      return BaseApplication.getContext();
    }
    return this.mContext;
  }
  
  public String getPlatform()
  {
    return PLATFORM;
  }
  
  public String getQUA3()
  {
    if (!TextUtils.isEmpty(this.cBh)) {
      return this.cBh;
    }
    this.cBh = ("V1_AND_SQ_" + getAppVersionName());
    return this.cBh;
  }
  
  public String getSkey()
  {
    return this.skey;
  }
  
  public long getUin()
  {
    try
    {
      this.uin = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
      arwt.i("CommonDataAdapter", "get uin from app runtim succ:" + this.uin);
      label48:
      return this.uin;
    }
    catch (Throwable localThrowable)
    {
      break label48;
    }
  }
  
  public String getVersionName()
  {
    if (!TextUtils.isEmpty(this.mVersionName)) {
      return this.mVersionName;
    }
    ekF();
    return this.mVersionName;
  }
  
  public long hZ()
  {
    return this.awc;
  }
  
  public void mo(long paramLong)
  {
    this.awc = paramLong;
  }
  
  public void setContext(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aroi
 * JD-Core Version:    0.7.0.1
 */