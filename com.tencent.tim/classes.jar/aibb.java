import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import org.json.JSONException;
import org.json.JSONObject;

public class aibb
{
  private static final String TAG = aibb.class.getSimpleName();
  private static aibb a;
  private JSONObject bA;
  private JSONObject bB;
  
  public static aibb a()
  {
    try
    {
      if (a == null) {
        a = new aibb();
      }
      aibb localaibb = a;
      return localaibb;
    }
    finally {}
  }
  
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode a(int paramInt)
  {
    YtSDKKitFramework.YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    switch (paramInt)
    {
    default: 
      return localYtSDKKitFrameworkWorkMode;
    case 0: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    case 1: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE;
    case 2: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE;
    case 3: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE;
    case 4: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE;
    }
    return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
  }
  
  public int L(String paramString1, String paramString2)
  {
    try
    {
      this.bA = new JSONObject(paramString1).getJSONObject("sdk_settings");
      this.bB = new JSONObject(paramString2).getJSONObject("ui_basic_config");
      return 0;
    }
    catch (JSONException paramString1)
    {
      QLog.e(TAG, 1, "initWithConfig error " + paramString1.getMessage());
    }
    return -1;
  }
  
  public JSONObject h(int paramInt)
  {
    return YtSDKKitConfigHelper.getSDKConfig(a(paramInt), this.bA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibb
 * JD-Core Version:    0.7.0.1
 */