package com.tencent.kingkong;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.kingkong.xposed.DvmPatchInterface;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigPatch
  extends Patch
{
  private static final String LOG_TAG = "KingKongConfigPatch";
  private static final String TAG_BASIC_CONFIG = "basic_config";
  private static final String TAG_CLASS_NAME = "class_name";
  private static final String TAG_PATCH_NAME = "name";
  private static final String TAG_TYPE = "type";
  private static final String TAG_VERSION = "ver";
  private String mClassName = "";
  
  public ConfigPatch(String paramString1, String paramString2)
  {
    this.mPath = paramString1;
    this.mPatchName = paramString2;
  }
  
  public static Patch CreatePatch(String paramString, PatchInfo paramPatchInfo)
  {
    paramString = new ConfigPatch(paramString, paramPatchInfo.mPatchName);
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
      Common.Log.d("KingKongConfigPatch", "--> Config Class Name : " + this.mClassName);
      return true;
    }
    catch (JSONException paramString)
    {
      Common.Log.d("KingKongConfigPatch", "Parse Config config failed : " + paramString);
    }
    return false;
  }
  
  public int doPatch(Context paramContext)
  {
    if (paramContext == null)
    {
      Common.Log.d("KingKongConfigPatch", "ConfigPatch doPath context is null");
      return 1;
    }
    if ((TextUtils.isEmpty(this.mPath)) || (TextUtils.isEmpty(this.mPatchName)) || (TextUtils.isEmpty(this.mPatchType)) || (TextUtils.isEmpty(this.mPatchVersion)) || (TextUtils.isEmpty(this.mClassName)))
    {
      Common.Log.d("KingKongConfigPatch", "ConfigPatch doPath value is empty");
      return 2;
    }
    Common.Log.d("KingKongConfigPatch", "doPatch");
    try
    {
      Object localObject = new DexClassLoader(this.mPath + File.separator + this.mPatchName + ".jar", this.mPath, null, Common.getDexClassLoader());
      Class localClass;
      String str1;
      String str2;
      String str3;
      Common.Log.d("KingKongConfigPatch", "ConfigPatch Dex load fail : " + paramContext);
    }
    catch (Exception paramContext)
    {
      try
      {
        localObject = ((DexClassLoader)localObject).loadClass(this.mClassName);
        localClass = Integer.TYPE;
        str1 = this.mPatchName;
        str2 = this.mPatchType;
        str3 = this.mPatchVersion;
        ((DvmPatchInterface)((Class)localObject).getConstructor(new Class[] { localClass, String.class, String.class, String.class }).newInstance(new Object[] { Integer.valueOf(0), str1, str2, str3 })).onLoad(paramContext);
        return 0;
      }
      catch (Exception paramContext)
      {
        break label227;
      }
      paramContext = paramContext;
    }
    label227:
    return 5;
  }
  
  public boolean initPatch()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.ConfigPatch
 * JD-Core Version:    0.7.0.1
 */