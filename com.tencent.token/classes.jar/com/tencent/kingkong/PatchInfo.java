package com.tencent.kingkong;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchInfo
{
  private static final String LOG_TAG = "PatchInfo";
  public static final String STATUS_DISABLED = "DISABLED";
  public static final String STATUS_READY = "READY";
  public static final String STATUS_UPDATED = "UPDATED";
  public static final String STATUS_UPDATING = "UPDATING";
  private static final String TAG_DRIVER_VERSION = "driver";
  private static final String TAG_ENABLED = "enabled";
  private static final String TAG_PATCH_NAME = "name";
  private static final String TAG_PREVIOUS_PATCH = "pre_patch";
  private static final String TAG_STATUS = "status";
  private static final String TAG_SYSTEM_VERSION = "system";
  private static final String TAG_TYPE = "type";
  private static final String TAG_URL = "url";
  private static final String TAG_VERSION = "ver";
  public String mAllowDelayLoad;
  public String mDriver;
  public String mEnabled;
  public String mIsCritical;
  public String mPatchName;
  public String mPreviousPatch;
  public String mStatus;
  public String mSystem;
  public String mType;
  public String mUrl;
  public String mVer;
  
  public PatchInfo() {}
  
  public PatchInfo(SharedPreferences paramSharedPreferences, String paramString)
  {
    String str1 = concat("ver", paramString);
    String str2 = concat("system", paramString);
    String str3 = concat("driver", paramString);
    String str4 = concat("url", paramString);
    String str5 = concat("type", paramString);
    String str6 = concat("status", paramString);
    String str7 = concat("pre_patch", paramString);
    String str8 = concat("enabled", paramString);
    this.mVer = paramSharedPreferences.getString(str1, "");
    this.mSystem = paramSharedPreferences.getString(str2, "");
    this.mDriver = paramSharedPreferences.getString(str3, "");
    this.mUrl = paramSharedPreferences.getString(str4, "");
    this.mType = paramSharedPreferences.getString(str5, "");
    this.mStatus = paramSharedPreferences.getString(str6, "");
    this.mPreviousPatch = paramSharedPreferences.getString(str7, "").trim();
    this.mPatchName = paramString;
    this.mEnabled = paramSharedPreferences.getString(str8, "").trim();
  }
  
  public PatchInfo(JSONObject paramJSONObject) {}
  
  private String concat(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static PatchInfo parseFromJSON(JSONObject paramJSONObject)
  {
    PatchInfo localPatchInfo = new PatchInfo();
    try
    {
      localPatchInfo.mPatchName = paramJSONObject.getString("name").trim();
      localPatchInfo.mVer = paramJSONObject.getString("ver").trim();
      localPatchInfo.mSystem = paramJSONObject.getString("system").trim();
      localPatchInfo.mDriver = paramJSONObject.getString("driver").trim();
      localPatchInfo.mUrl = paramJSONObject.getString("url").trim();
      localPatchInfo.mType = paramJSONObject.getString("type").trim();
      localPatchInfo.mEnabled = paramJSONObject.getString("enabled").trim();
      localPatchInfo.mPreviousPatch = paramJSONObject.optString("pre_patch", "").trim();
      return localPatchInfo;
    }
    catch (Exception paramJSONObject)
    {
      Common.Log.d("PatchInfo", "Parse PatchInfo from JSON exception " + paramJSONObject);
    }
    return null;
  }
  
  public JSONObject getJSONObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.mPatchName);
      localJSONObject.put("ver", this.mVer);
      localJSONObject.put("system", this.mSystem);
      localJSONObject.put("driver", this.mDriver);
      localJSONObject.put("url", this.mUrl);
      localJSONObject.put("type", this.mType);
      localJSONObject.put("enabled", this.mEnabled);
      localJSONObject.put("pre_patch", this.mPreviousPatch);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Common.Log.d("PatchInfo", "Get JSON String failed " + localJSONException);
    }
    return new JSONObject();
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled.equals("true");
  }
  
  public boolean isSupported()
  {
    if ((!Utils.isSupportSystem(this.mSystem)) || (!Utils.isSupportDriver(this.mDriver))) {}
    while ((this.mType.equals("DVM")) && (!DvmPatch.isDeviceSupportDVM())) {
      return false;
    }
    return true;
  }
  
  public void removeConfig(SharedPreferences.Editor paramEditor)
  {
    String str1 = concat("ver", this.mPatchName);
    String str2 = concat("system", this.mPatchName);
    String str3 = concat("driver", this.mPatchName);
    String str4 = concat("url", this.mPatchName);
    String str5 = concat("type", this.mPatchName);
    String str6 = concat("status", this.mPatchName);
    String str7 = concat("pre_patch", this.mPatchName);
    String str8 = concat("enabled", this.mPatchName);
    paramEditor.remove(str1);
    paramEditor.remove(str2);
    paramEditor.remove(str3);
    paramEditor.remove(str4);
    paramEditor.remove(str5);
    paramEditor.remove(str6);
    paramEditor.remove(str7);
    paramEditor.remove(str8);
    paramEditor.commit();
  }
  
  public String toString()
  {
    return "I'm Patch " + this.mPatchName + "," + this.mEnabled + "," + this.mType + "," + this.mUrl + "," + this.mIsCritical + "," + this.mPreviousPatch + "," + this.mAllowDelayLoad + "," + this.mStatus;
  }
  
  public void updateConfig(SharedPreferences.Editor paramEditor)
  {
    String str1 = concat("ver", this.mPatchName);
    String str2 = concat("system", this.mPatchName);
    String str3 = concat("driver", this.mPatchName);
    String str4 = concat("url", this.mPatchName);
    String str5 = concat("type", this.mPatchName);
    String str6 = concat("status", this.mPatchName);
    String str7 = concat("pre_patch", this.mPatchName);
    String str8 = concat("enabled", this.mPatchName);
    paramEditor.putString(str1, this.mVer);
    paramEditor.putString(str2, this.mSystem);
    paramEditor.putString(str3, this.mDriver);
    paramEditor.putString(str4, this.mUrl);
    paramEditor.putString(str5, this.mType);
    paramEditor.putString(str6, this.mStatus);
    paramEditor.putString(str7, this.mPreviousPatch);
    paramEditor.putString(str8, this.mEnabled);
    paramEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.PatchInfo
 * JD-Core Version:    0.7.0.1
 */