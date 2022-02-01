import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.wadl.WadlJsBridgeCall.1;
import com.tencent.open.wadl.WadlJsBridgeDownloadInfo;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asbx
{
  private static Handler mHandler = new Handler(Looper.getMainLooper());
  private static Map<String, Boolean> oR = new HashMap();
  protected final String TAG = "WadlJsBridgeCall";
  
  public static void XC(String paramString)
  {
    oR.put(paramString, new Boolean(true));
    mHandler.postDelayed(new WadlJsBridgeCall.1(paramString), 2000L);
  }
  
  public static void XD(String paramString)
  {
    oR.put(paramString, new Boolean(false));
  }
  
  private void e(WadlParams paramWadlParams)
  {
    asbt.ai("WadlJsBridgeCall", 2, "dispatch wadlParams:" + paramWadlParams);
    switch (paramWadlParams.ekZ)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      return;
    case 2: 
    case 12: 
      awok.a().h(paramWadlParams);
      return;
    case 3: 
    case 10: 
      awok.a().eE(paramWadlParams.from, paramWadlParams.appId);
      return;
    case 4: 
      awok.a().eF(paramWadlParams.from, paramWadlParams.appId);
      return;
    }
    awok.a().c(paramWadlParams);
  }
  
  private void emA()
  {
    awok.a().emA();
  }
  
  private void nq(List<WadlJsBridgeDownloadInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((WadlJsBridgeDownloadInfo)paramList.next()).appId);
    }
    if (localArrayList.size() > 0) {
      awok.a().fz(localArrayList);
    }
  }
  
  public static boolean sE(String paramString)
  {
    paramString = (Boolean)oR.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public void XE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      awok.a().XE(paramString);
    }
  }
  
  public void Z(int paramInt, String paramString1, String paramString2)
  {
    awok.a().cC(paramInt, paramString1);
  }
  
  public int a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    asbt.i("WadlJsBridgeCall", "doDownloadAction params:" + paramString1 + ",fromWeb:" + paramBoolean + ",from:" + paramInt + ",weburl:" + paramString2);
    WadlParams localWadlParams = new WadlParams(paramString1);
    if (localWadlParams.dqZ) {
      localWadlParams.acT(1);
    }
    if (paramInt != 0)
    {
      localWadlParams.from = paramInt;
      localWadlParams.bLE = paramString2;
    }
    if ((paramInt == 1) || (paramInt == 2))
    {
      localWadlParams.setFlags(8);
      if ((paramInt == 1) && (!localWadlParams.dqZ)) {
        localWadlParams.setFlags(4);
      }
    }
    paramString2 = localWadlParams.appId;
    paramInt = localWadlParams.ekZ;
    if (paramBoolean) {}
    try
    {
      if (localWadlParams.dra)
      {
        tbb.X(paramString2, "DELAY_LIST");
        tbb.h(paramString2, paramString1, "DELAY_APPID_DETAIL_");
        tax.registerReceiver();
        return 0;
      }
      if (!localWadlParams.dqZ)
      {
        tbb.W(paramString2, "DELAY_LIST");
        tbb.Y(paramString2, "DELAY_APPID_DETAIL_");
      }
      if (localWadlParams.dqZ)
      {
        if (sE(localWadlParams.resName))
        {
          asbt.i("WadlJsBridgeCall", "##@Operation for wadlParams.resName:" + localWadlParams.resName + " is not returned! The opertion of action: " + paramInt + " is ignored!");
          return 1;
        }
        XC(localWadlParams.resName);
      }
      while ((TextUtils.isEmpty(localWadlParams.apkUrl)) && (!localWadlParams.dqZ))
      {
        tbb.a(null, "558", "202982", paramString2, "55801", "4", "430");
        asbt.i("WadlJsBridgeCall", "invalid url:" + localWadlParams);
        return -1;
        if (sE(paramString2))
        {
          asbt.i("WadlJsBridgeCall", "##@Operation for appid:" + paramString2 + " is not returned! The opertion of action: " + paramInt + " is ignored!");
          return 1;
        }
        XC(paramString2);
      }
      e(localWadlParams);
    }
    catch (Exception paramString1)
    {
      asbt.e("WadlJsBridgeCall", "doDownloadAction:", paramString1);
      return -1;
    }
    return 0;
  }
  
  public void emB()
  {
    try
    {
      emA();
      return;
    }
    catch (Exception localException)
    {
      asbt.e("WadlJsBridgeCall", "getQueryAllTask()>>>", localException);
    }
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("infolist");
      ((JSONObject)localObject).getString("guid");
      int j = paramString.length();
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
        localWadlJsBridgeDownloadInfo.appId = localJSONObject.optString("appid");
        localWadlJsBridgeDownloadInfo.cDG = localJSONObject.optString("myAppId");
        localWadlJsBridgeDownloadInfo.cCL = localJSONObject.optString("apkId");
        localWadlJsBridgeDownloadInfo.packageName = localJSONObject.optString("packageName");
        localWadlJsBridgeDownloadInfo.versionCode = localJSONObject.optInt("versionCode");
        ((List)localObject).add(localWadlJsBridgeDownloadInfo);
        i += 1;
      }
      nq((List)localObject);
      return;
    }
    catch (Exception paramString)
    {
      asbt.e("WadlJsBridgeCall", "query getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString1.getJSONObject(i);
        WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
        localWadlJsBridgeDownloadInfo.appId = localJSONObject.optString("appid");
        localWadlJsBridgeDownloadInfo.cDG = localJSONObject.optString("myAppId");
        localWadlJsBridgeDownloadInfo.cCL = localJSONObject.optString("apkId");
        localWadlJsBridgeDownloadInfo.packageName = localJSONObject.optString("packageName");
        localWadlJsBridgeDownloadInfo.versionCode = localJSONObject.optInt("versionCode");
        paramString2.add(localWadlJsBridgeDownloadInfo);
        i += 1;
      }
      nq(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      asbt.e("WadlJsBridgeCall", "getQueryDownloadAction(String,String)>>>", paramString1);
    }
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("via");
      paramString.getString("guid");
      XE(str);
      return;
    }
    catch (Exception paramString)
    {
      asbt.e("WadlJsBridgeCall", "query getQueryDownloadActionByVia>>>", paramString);
    }
  }
  
  public void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    asbt.i("WadlJsBridgeCall", "startDownload delay task" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (1 == paramInt) {
      a(paramString, false, 1, "YUYUE");
    }
    while (2 != paramInt) {
      return;
    }
    a(paramString, false, 2, "YANCHI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbx
 * JD-Core Version:    0.7.0.1
 */