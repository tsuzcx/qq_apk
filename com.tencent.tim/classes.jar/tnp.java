import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tnp
{
  private tnk a;
  private String appVersion;
  private int bCz;
  private boolean enable;
  private String patchType;
  private String revision;
  
  public tnp(JSONObject paramJSONObject)
  {
    readFromJson(paramJSONObject);
  }
  
  private void readFromJson(JSONObject paramJSONObject)
  {
    int i = 0;
    this.enable = paramJSONObject.optBoolean("enable", false);
    this.patchType = paramJSONObject.optString("patchType", null);
    this.bCz = paramJSONObject.optInt("patchVersion", 0);
    this.appVersion = paramJSONObject.optString("appVersion", null);
    this.revision = paramJSONObject.optString("revision", null);
    paramJSONObject = paramJSONObject.optJSONArray("patchItemConfigs");
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (i < paramJSONObject.length())
        {
          tnk localtnk = tnk.a(this.patchType, paramJSONObject.getJSONObject(i));
          if (localtnk != null) {
            this.a = localtnk;
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PatchLogTag", 2, "PatchConfig readFromJsonString", paramJSONObject);
      }
      i += 1;
    }
  }
  
  public boolean Ol()
  {
    return (this.a != null) && (this.a.Ol());
  }
  
  public boolean Om()
  {
    return (this.a != null) && (this.a.Om());
  }
  
  public boolean On()
  {
    return this.enable;
  }
  
  public tnk a()
  {
    return this.a;
  }
  
  public boolean i(Context paramContext, boolean paramBoolean)
  {
    if (!this.enable)
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig enable is false");
      return false;
    }
    if (!"1d5677cf".equals(this.revision))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig revision not match expect: 1d5677cf");
      return false;
    }
    if ((TextUtils.isEmpty(this.appVersion)) || (!this.appVersion.equals(aewh.getVersionName(paramContext) + "." + aewh.getVersionCode(paramContext))))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig app version not match expect: " + aewh.getVersionName(paramContext) + "." + aewh.getVersionCode(paramContext));
      return false;
    }
    if ((this.a == null) || (!this.a.ae(paramBoolean)))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig patchItemConfig null or invalid");
      return false;
    }
    QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig return true");
    return true;
  }
  
  public String or()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("enable", this.enable);
      ((JSONObject)localObject2).put("patchType", this.patchType);
      ((JSONObject)localObject2).put("patchVersion", this.bCz);
      ((JSONObject)localObject2).put("appVersion", this.appVersion);
      ((JSONObject)localObject2).put("revision", this.revision);
      if (this.a != null)
      {
        String str = this.a.or();
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(0, new JSONObject(str));
        ((JSONObject)localObject2).put("patchItemConfigs", localJSONArray);
      }
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PatchLogTag", 2, "PatchConfig writeToJsonString", localJSONException);
    }
    return localObject1;
    return null;
  }
  
  public String os()
  {
    return this.patchType;
  }
  
  public String ot()
  {
    if (this.a != null) {
      return this.a.aJC;
    }
    return null;
  }
  
  public String ou()
  {
    String str = ot();
    if (Ol()) {}
    do
    {
      return str;
      if (PatchCommonUtil.isArtGeO()) {
        return "androidO7z_" + str;
      }
    } while (!PatchCommonUtil.isArtGeN());
    return "androidN7z_" + str;
  }
  
  public String ov()
  {
    if (this.a != null) {
      return this.a.patchUrl;
    }
    return null;
  }
  
  public int uX()
  {
    return this.bCz;
  }
  
  public int uY()
  {
    if (this.a != null) {
      return this.a.bCx;
    }
    return 0;
  }
  
  public int uZ()
  {
    if ((!Ol()) && (PatchCommonUtil.isArtGeN()) && (this.a != null)) {
      return ((tnl)this.a).uW();
    }
    return uY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tnp
 * JD-Core Version:    0.7.0.1
 */