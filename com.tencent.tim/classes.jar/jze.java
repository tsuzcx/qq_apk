import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class jze
  extends jyy
{
  public jze.a a;
  public int aEH;
  public String hL;
  public String mCoverUrl;
  public long mDuration;
  public String mVideoUrl;
  
  public static jze a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    jze localjze;
    Object localObject;
    for (;;)
    {
      return null;
      localjze = new jze();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localjze.mCoverUrl = ((JSONObject)localObject).optString("coverUrl");
          localjze.mVideoUrl = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localjze.mVideoUrl))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AdModuleVideo", 2, "video url is null");
            return null;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
    }
    localjze.mDuration = paramJSONObject.optLong("duration");
    localjze.aEH = paramJSONObject.optInt("mixType");
    localjze.hL = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new jze.a();
      ((jze.a)localObject).appId = paramJSONObject.optString("appid");
      ((jze.a)localObject).scheme = paramJSONObject.optString("scheme");
      ((jze.a)localObject).packageName = paramJSONObject.optString("packageName");
      ((jze.a)localObject).androidDownloadUrl = paramJSONObject.optString("androidDownloadUrl");
      ((jze.a)localObject).appName = paramJSONObject.optString("appName");
      localjze.a = ((jze.a)localObject);
    }
    return localjze;
  }
  
  public void aBp() {}
  
  public static class a
  {
    public String androidDownloadUrl;
    public String appId;
    public String appName;
    public String packageName;
    public String scheme;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jze
 * JD-Core Version:    0.7.0.1
 */