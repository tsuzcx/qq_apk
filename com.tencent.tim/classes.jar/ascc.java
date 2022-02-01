import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import org.json.JSONObject;

public class ascc
{
  public static int a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 9) {
      paramInt = 6;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 6)
      {
        i = paramInt;
        if (!aqhq.fileExists(paramString2)) {
          i = 0;
        }
      }
      return i;
    }
  }
  
  public static JSONObject a(WadlResult paramWadlResult)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramWadlResult != null) {}
    try
    {
      if (paramWadlResult.a != null)
      {
        WadlParams localWadlParams = paramWadlResult.a;
        localJSONObject.put("appid", localWadlParams.appId);
        localJSONObject.put("state", kR(paramWadlResult.bBa));
        localJSONObject.put("pro", paramWadlResult.progress);
        localJSONObject.put("packagename", localWadlParams.packageName);
        localJSONObject.put("ismyapp", 0);
        localJSONObject.put("download_from", 0);
        localJSONObject.put("realDownloadType", 0);
        localJSONObject.put("via", localWadlParams.via);
        localJSONObject.put("writecodestate", 0);
        localJSONObject.put("extraInfo", localWadlParams.extraData);
        localJSONObject.put("isAutoInstallBySDK", localWadlParams.nO(1));
        localJSONObject.put("isRes", localWadlParams.dqZ);
        int i = kS(paramWadlResult.errCode);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", gy(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
  
  public static boolean cf(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.trim();
    paramString2 = paramString2.trim();
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wadl_AppInfo", 4).edit();
    localEditor.putString(paramString1, paramString2);
    boolean bool = localEditor.commit();
    asbt.i("WadlJsBridgeUtil", "savePackageInfo:appid:" + paramString2 + ",packageName:" + paramString1 + ",flag:" + bool);
    return bool;
  }
  
  public static String gy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return aroi.a().getContext().getString(2131696629);
    case 0: 
      return "";
    case 1: 
      return aroi.a().getContext().getString(2131696634);
    case 2: 
      return aroi.a().getContext().getString(2131696638);
    case 3: 
      return aroi.a().getContext().getString(2131696636);
    case 4: 
      return aroi.a().getContext().getString(2131696632);
    case 5: 
      return aroi.a().getContext().getString(2131696629);
    }
    return aroi.a().getContext().getString(2131696629);
  }
  
  public static int kR(int paramInt)
  {
    if (paramInt == 6) {
      return 4;
    }
    if (paramInt == 4) {
      return 2;
    }
    if (paramInt == 5) {
      return 3;
    }
    if ((paramInt == 7) || (paramInt == 14)) {
      return -2;
    }
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 9) {
      return 6;
    }
    if (paramInt == 11) {
      return 9;
    }
    if (paramInt == 12) {
      return 10;
    }
    if ((paramInt == 2) || (paramInt == 13)) {
      return 20;
    }
    if (paramInt == 10) {
      return 13;
    }
    return 0;
  }
  
  public static int kS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 6;
    case 0: 
      return 0;
    case -71: 
    case -30: 
    case -26: 
    case -25: 
    case -24: 
    case -23: 
    case -16: 
    case -15: 
    case -1: 
      return 1;
    case -51: 
    case -11: 
      return 2;
    case -40: 
    case -12: 
      return 3;
    case 999: 
      return 7;
    }
    return 5;
  }
  
  public static String qR(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      asbt.e("WadlJsBridgeUtil", "getAppid error packageName is empty");
      return "";
    }
    String str3 = paramString.trim();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    for (;;)
    {
      try
      {
        paramString = localBaseApplication.getSharedPreferences("wadl_AppInfo", 4).getString(str3, "");
        String str1 = paramString;
        asbt.e("WadlJsBridgeUtil", "getAppid error", localOutOfMemoryError1);
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            str1 = localBaseApplication.getSharedPreferences("wadlAppInfo", 0).getString(str3, "");
          }
          asbt.i("WadlJsBridgeUtil", "getAppid packageName=" + str3 + ",appId=" + str1);
          return str1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          String str2;
          break label106;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramString = "";
      }
      label106:
      str2 = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ascc
 * JD-Core Version:    0.7.0.1
 */