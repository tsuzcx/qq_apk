package com.tencent.kingkong;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DriverPatch
  extends Patch
{
  private static final String LOG_TAG = "KingKongDriverPatch";
  private static final String SP_DRIVER_CLASS_NAME = "SP_DRIVER_CLASS_NAME";
  private static final String TAG_BASIC_CONFIG = "basic_config";
  private static final String TAG_CLASS_NAME = "class_name";
  private static final String TAG_PATCH_NAME = "name";
  private static final String TAG_TYPE = "type";
  private static final String TAG_VERSION = "ver";
  private String mClassName = "";
  
  public DriverPatch(String paramString1, String paramString2)
  {
    this.mPath = paramString1;
    this.mPatchName = paramString2;
  }
  
  public static Patch CreatePatch(String paramString, PatchInfo paramPatchInfo)
  {
    paramString = new DriverPatch(paramString, paramPatchInfo.mPatchName);
    if (paramString.parseConfig(paramString.getConfigFileName())) {
      return paramString;
    }
    return null;
  }
  
  private boolean parseConfig(String paramString)
  {
    paramString = Utils.ReadFileToString(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.mPatchName = paramString.getString("name");
      this.mPatchVersion = paramString.getString("ver");
      this.mPatchType = paramString.getString("type");
      this.mClassName = paramString.getJSONObject("basic_config").getString("class_name").trim();
      Common.Log.d("KingKongDriverPatch", "--> driver Class Name : " + this.mClassName);
      return true;
    }
    catch (JSONException paramString)
    {
      Common.Log.d("KingKongDriverPatch", "Parse driver config failed : " + paramString);
    }
    return false;
  }
  
  public int doPatch(Context paramContext)
  {
    Common.Log.d("KingKongDriverPatch", "DriverPatch doPatch : mPatchInfo.mFolder = " + this.mPatchInfo.mFolder);
    Common.setDriverFolder(Common.makeInstallName(this.mPatchInfo.mFolder));
    if (!TextUtils.isEmpty(this.mClassName))
    {
      Common.Log.d("KingKongDriverPatch", "DriverPatch doPatch : mClassName = " + this.mClassName);
      Common.setDriverValue("SP_DRIVER_CLASS_NAME", this.mClassName);
    }
    return 0;
  }
  
  public boolean initPatch()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.DriverPatch
 * JD-Core Version:    0.7.0.1
 */