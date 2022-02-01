import android.app.Activity;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ste
  extends WebViewPlugin
{
  public ste()
  {
    this.mPluginNameSpace = "location";
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("lat", paramSosoLbsInfo.a.cd);
        localJSONObject1.put("lon", paramSosoLbsInfo.a.ce);
        localJSONObject1.put("nation", dealLocationStr(paramSosoLbsInfo.a.nation));
        localJSONObject1.put("province", dealLocationStr(paramSosoLbsInfo.a.province));
        localJSONObject1.put("city", dealLocationStr(paramSosoLbsInfo.a.city));
        localJSONObject1.put("adcode", dealLocationStr(paramSosoLbsInfo.a.cityCode));
        localJSONObject1.put("district", dealLocationStr(paramSosoLbsInfo.a.district));
        localJSONObject1.put("town", dealLocationStr(paramSosoLbsInfo.a.town));
        localJSONObject1.put("village", dealLocationStr(paramSosoLbsInfo.a.village));
        localJSONObject1.put("street", dealLocationStr(paramSosoLbsInfo.a.street));
        localJSONObject1.put("streetNo", dealLocationStr(paramSosoLbsInfo.a.Qw));
        Object localObject = paramSosoLbsInfo.a.yi;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramSosoLbsInfo = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TencentPoi localTencentPoi = (TencentPoi)((Iterator)localObject).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("name", dealLocationStr(localTencentPoi.getName()));
            localJSONObject2.put("addr", dealLocationStr(localTencentPoi.getAddress()));
            localJSONObject2.put("distance", localTencentPoi.getDistance());
            localJSONObject2.put("catalog", dealLocationStr(localTencentPoi.getCatalog()));
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
  
  private String dealLocationStr(String paramString)
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if ("getLocationWithPoi".equals(paramString3)) {
      tH(paramJsBridgeListener);
    }
    return true;
  }
  
  public void tH(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPlugin", 2, "getPois:" + paramString);
    }
    if (this.mRuntime.getWebView() == null) {
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
        localActivity = this.mRuntime.getActivity();
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
              paramString = aczc.a("webview");
              if ((paramString == null) || (paramString.a == null) || (paramString.a.yi == null) || (paramString.a.yi.size() <= 0)) {
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
    ((AppActivity)localActivity).requestPermissions(new stf(this, str), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    return;
    label236:
    callJs(str, new String[] { "-4", "{}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ste
 * JD-Core Version:    0.7.0.1
 */