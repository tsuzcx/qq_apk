import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class nue
  implements IReportDelegate
{
  public static String TAG = "ViolaReportDelegate";
  public HashMap<String, String> mHashMap = new HashMap();
  
  private JSONObject i(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = Uri.parse(paramString).getQueryParameter("v_bid");
    try
    {
      localJSONObject.put(ViolaEnvironment.COMMON_UIN, kxm.getAccount());
      localJSONObject.put(ViolaEnvironment.COMMON_NET, Integer.toString(kxm.Y(BaseApplication.getContext())));
      localJSONObject.put(ViolaEnvironment.COMMON_OPERATION_VERSION, aqgz.getDeviceOSVersion());
      localJSONObject.put(ViolaEnvironment.COMMON_QQ_VERSION, "3.4.4");
      localJSONObject.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
      String str2 = ViolaEnvironment.COMMON_BIZ;
      if (TextUtils.isEmpty(str1)) {}
      for (str1 = paramString;; str1 = paramString + "&offlineVersion=" + jpa.dL(str1))
      {
        localJSONObject.put(str2, URLEncoder.encode(str1));
        localJSONObject.put(ViolaEnvironment.COMMON_PLATFORM, "0");
        localJSONObject.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(ntp.bcI));
        if (!TextUtils.isEmpty(paramString)) {
          localJSONObject.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
        }
        localJSONObject.put(ViolaEnvironment.COMMON_RELEASE, "1");
        return localJSONObject;
      }
      return null;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "initCommonDataJson Exception:" + paramString.getMessage());
      }
    }
  }
  
  public void aB(int paramInt, String paramString)
  {
    ThreadManager.post(new ViolaReportDelegate.1(this, paramString, paramInt), 8, null, true);
  }
  
  public void addReportData(String paramString1, String paramString2)
  {
    if ((ViolaEnvironment.KEY_SO.equals(paramString1)) && (ViolaEnvironment.SO_START.equals(paramString2)))
    {
      if (this.mHashMap.size() >= 2)
      {
        this.mHashMap.clear();
        this.mHashMap.put(paramString1, paramString2);
        return;
      }
      this.mHashMap.put(paramString1, paramString2);
      return;
    }
    this.mHashMap.put(paramString1, paramString2);
  }
  
  public void bP(String paramString1, String paramString2)
  {
    if ((this.mHashMap.containsKey(paramString1)) && (paramString2.equals(this.mHashMap.get(paramString1)))) {
      this.mHashMap.remove(paramString1);
    }
  }
  
  public void bbw()
  {
    ThreadManager.post(new ViolaReportDelegate.2(this), 8, null, true);
  }
  
  public void dropFrameMonitor(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene(paramString, false);
      return;
    }
    txn.a().startMonitorScene(paramString);
  }
  
  public HashMap<String, String> getBaseReportData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str1 = Uri.parse(paramString).getQueryParameter("v_bid");
    localHashMap.put(ViolaEnvironment.COMMON_UIN, kxm.getAccount());
    localHashMap.put(ViolaEnvironment.COMMON_NET, Integer.toString(kxm.Y(BaseApplication.getContext())));
    localHashMap.put(ViolaEnvironment.COMMON_OPERATION_VERSION, aqgz.getDeviceOSVersion());
    localHashMap.put(ViolaEnvironment.COMMON_QQ_VERSION, "3.4.4");
    localHashMap.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
    String str2 = ViolaEnvironment.COMMON_BIZ;
    if (TextUtils.isEmpty(str1)) {}
    for (str1 = paramString;; str1 = paramString + "&offlineVersion=" + jpa.dL(str1))
    {
      localHashMap.put(str2, URLEncoder.encode(str1));
      localHashMap.put(ViolaEnvironment.COMMON_PLATFORM, "0");
      localHashMap.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(ntp.bcI));
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
      }
      localHashMap.put(ViolaEnvironment.COMMON_RELEASE, "1");
      localHashMap.put(ViolaEnvironment.COMMON_APPLICATION, "1");
      return localHashMap;
    }
  }
  
  public void reportData(String paramString)
  {
    if (!this.mHashMap.isEmpty())
    {
      if (!this.mHashMap.containsKey(ViolaEnvironment.COMMON_UIN)) {
        this.mHashMap.putAll(getBaseReportData(paramString));
      }
      paramString = ViolaUtils.copyMap(this.mHashMap);
      if (!paramString.isEmpty()) {
        kxm.a(kxm.getAppRuntime(), true, paramString);
      }
      this.mHashMap.clear();
    }
  }
  
  public void reportHttpData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    kxm.b(kxm.getAppRuntime(), true, paramHashMap);
  }
  
  public void reportJsError(boolean paramBoolean, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("error_msg", paramString);
      localJSONObject.put("is_renderJs", paramBoolean);
      kbp.a(null, null, "0X800AC69", "0X800AC69", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void reportPageProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = i(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        kxm.a(kxm.getAppRuntime(), true, paramString3);
        bbw();
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "reportPageProcessNew Exception:" + paramString1.getMessage());
    }
  }
  
  public void reportRunningData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    kxm.c(kxm.getAppRuntime(), true, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nue
 * JD-Core Version:    0.7.0.1
 */