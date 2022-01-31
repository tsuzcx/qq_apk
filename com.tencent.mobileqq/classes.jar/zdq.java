import android.app.Activity;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zdq
  extends WebViewPlugin
{
  public zdq()
  {
    this.mPluginNameSpace = "location";
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!"Unknown".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("lat", paramSosoLbsInfo.a.jdField_a_of_type_Double);
        localJSONObject1.put("lon", paramSosoLbsInfo.a.b);
        localJSONObject1.put("nation", a(paramSosoLbsInfo.a.c));
        localJSONObject1.put("province", a(paramSosoLbsInfo.a.d));
        localJSONObject1.put("city", a(paramSosoLbsInfo.a.e));
        localJSONObject1.put("adcode", a(paramSosoLbsInfo.a.f));
        localJSONObject1.put("district", a(paramSosoLbsInfo.a.g));
        localJSONObject1.put("town", a(paramSosoLbsInfo.a.h));
        localJSONObject1.put("village", a(paramSosoLbsInfo.a.i));
        localJSONObject1.put("street", a(paramSosoLbsInfo.a.j));
        localJSONObject1.put("streetNo", a(paramSosoLbsInfo.a.k));
        Object localObject = paramSosoLbsInfo.a.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramSosoLbsInfo = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TencentPoi localTencentPoi = (TencentPoi)((Iterator)localObject).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("name", a(localTencentPoi.getName()));
            localJSONObject2.put("addr", a(localTencentPoi.getAddress()));
            localJSONObject2.put("distance", localTencentPoi.getDistance());
            localJSONObject2.put("catalog", a(localTencentPoi.getCatalog()));
            localJSONObject2.put("lat", localTencentPoi.getLatitude());
            localJSONObject2.put("lon", localTencentPoi.getLongitude());
            paramSosoLbsInfo.put(localJSONObject2);
          }
          localJSONObject1.put("pois", paramSosoLbsInfo);
        }
      }
      catch (Exception paramSosoLbsInfo)
      {
        QLog.e("LocationPlugin", 1, "onLocationFinish Failed!", paramSosoLbsInfo);
        callJs(paramString, new String[] { "-5", "{}" });
        return;
      }
      callJs(paramString, new String[] { "0", localJSONObject1.toString() });
      return;
    }
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPlugin", 2, "getPois:" + paramString);
    }
    if (this.mRuntime.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.w("LocationPlugin", 2, "getWebView()==null, return");
      }
    }
    Activity localActivity;
    String str;
    do
    {
      for (;;)
      {
        return;
        localActivity = this.mRuntime.a();
        if ((localActivity == null) || (localActivity.isFinishing()))
        {
          if (QLog.isColorLevel()) {
            QLog.w("LocationPlugin", 2, "context==null || isFinishing, return");
          }
        }
        else
        {
          str = paramString;
          if (paramString.charAt(0) == '{') {}
          try
          {
            paramString = new JSONObject(paramString);
            str = paramString.getString("callback");
            paramString.optLong("allowCacheTime", 0L);
            if (!TextUtils.isEmpty(str))
            {
              if (!(localActivity instanceof AppActivity)) {
                break label236;
              }
              paramString = ampk.a("webview");
              if ((paramString == null) || (paramString.a == null) || (paramString.a.jdField_a_of_type_JavaUtilList == null) || (paramString.a.jdField_a_of_type_JavaUtilList.size() <= 0)) {
                break label208;
              }
              a(paramString, str);
              return;
            }
          }
          catch (JSONException paramString) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("LocationPlugin", 2, "getLocation exception:", paramString);
    return;
    label208:
    ((AppActivity)localActivity).requestPermissions(new zdr(this, str), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    return;
    label236:
    callJs(str, new String[] { "-4", "{}" });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if ("getLocationWithPoi".equals(paramString3)) {
      a(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zdq
 * JD-Core Version:    0.7.0.1
 */