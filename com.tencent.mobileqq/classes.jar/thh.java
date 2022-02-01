import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate.2;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class thh
  implements IReportDelegate
{
  public static String a;
  public HashMap<String, String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ViolaReportDelegate";
  }
  
  public thh()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private JSONObject a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = Uri.parse(paramString).getQueryParameter("v_bid");
    try
    {
      localJSONObject.put(ViolaEnvironment.COMMON_UIN, pay.a());
      localJSONObject.put(ViolaEnvironment.COMMON_NET, Integer.toString(pay.a(BaseApplication.getContext())));
      localJSONObject.put(ViolaEnvironment.COMMON_OPERATION_VERSION, DeviceInfoUtil.getDeviceOSVersion());
      localJSONObject.put(ViolaEnvironment.COMMON_QQ_VERSION, "8.4.8");
      localJSONObject.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
      String str2 = ViolaEnvironment.COMMON_BIZ;
      if (TextUtils.isEmpty(str1)) {}
      for (str1 = paramString;; str1 = paramString + "&offlineVersion=" + nny.a(str1))
      {
        localJSONObject.put(str2, URLEncoder.encode(str1));
        localJSONObject.put(ViolaEnvironment.COMMON_PLATFORM, "0");
        localJSONObject.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(tgc.a));
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
        QLog.e(jdField_a_of_type_JavaLangString, 2, "initCommonDataJson Exception:" + paramString.getMessage());
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ViolaReportDelegate.2(this), 8, null, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.post(new ViolaReportDelegate.1(this, paramString, paramInt), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) && (paramString2.equals(this.jdField_a_of_type_JavaUtilHashMap.get(paramString1)))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    }
  }
  
  public void addReportData(String paramString1, String paramString2)
  {
    if ((ViolaEnvironment.KEY_SO.equals(paramString1)) && (ViolaEnvironment.SO_START.equals(paramString2)))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 2)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void dropFrameMonitor(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.getInstance().stopMonitorScene(paramString, false);
      return;
    }
    DropFrameMonitor.getInstance().startMonitorScene(paramString);
  }
  
  public HashMap<String, String> getBaseReportData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = Uri.parse(paramString).getQueryParameter("v_bid");
      str2 = ViolaEnvironment.COMMON_BIZ;
      if (!TextUtils.isEmpty(str1)) {
        break label168;
      }
    }
    label168:
    for (String str1 = paramString;; str1 = paramString + "&offlineVersion=" + nny.a(str1))
    {
      localHashMap.put(str2, URLEncoder.encode(str1));
      localHashMap.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
      localHashMap.put(ViolaEnvironment.COMMON_UIN, pay.a());
      localHashMap.put(ViolaEnvironment.COMMON_NET, Integer.toString(pay.a(BaseApplication.getContext())));
      localHashMap.put(ViolaEnvironment.COMMON_OPERATION_VERSION, DeviceInfoUtil.getDeviceOSVersion());
      localHashMap.put(ViolaEnvironment.COMMON_QQ_VERSION, "8.4.8");
      localHashMap.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
      localHashMap.put(ViolaEnvironment.COMMON_PLATFORM, "0");
      localHashMap.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(tgc.a));
      localHashMap.put(ViolaEnvironment.COMMON_RELEASE, "1");
      localHashMap.put(ViolaEnvironment.COMMON_APPLICATION, "1");
      return localHashMap;
    }
  }
  
  public void reportData(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(ViolaEnvironment.COMMON_UIN)) {
        this.jdField_a_of_type_JavaUtilHashMap.putAll(getBaseReportData(paramString));
      }
      paramString = ViolaUtils.copyMap(this.jdField_a_of_type_JavaUtilHashMap);
      if (!paramString.isEmpty()) {
        pay.a(pay.a(), true, paramString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void reportHttpData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    pay.b(pay.a(), true, paramHashMap);
  }
  
  public void reportJsError(boolean paramBoolean, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("error_msg", paramString);
      localJSONObject.put("is_renderJs", paramBoolean);
      odq.a(null, null, "0X800AC69", "0X800AC69", 0, 0, "", "", "", localJSONObject.toString(), false);
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
  
  public void reportNVProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = a(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        pay.a(pay.a(), true, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "reportPageProcessNew Exception:" + paramString1.getMessage());
    }
  }
  
  public void reportNativeVueError(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error", paramString1);
      localJSONObject.put("url", paramString2);
      odq.a(null, null, "0X800B08D", "0X800B08D", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "reportNativeVueError: " + paramString1.getMessage());
      }
    }
  }
  
  public void reportPageProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = a(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        pay.a(pay.a(), true, paramString3);
        a();
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "reportPageProcessNew Exception:" + paramString1.getMessage());
    }
  }
  
  public void reportRunningData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    pay.c(pay.a(), true, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     thh
 * JD-Core Version:    0.7.0.1
 */