package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainConfig
{
  private static final String LOG_TAG = "KingKongMainConfig";
  private static final String SHARED_PREFERENCE_PATCH_LIST = "PATCH_LIST";
  public static final String STATUS_DISABLED = "disabled";
  public static final String STATUS_ENABLED = "enabled";
  public static final String STATUS_INSTALL = "install";
  public static final String STATUS_UPDATE = "update";
  private static final String TAG_APP_NAME = "app";
  private static final String TAG_PATCHES = "patches";
  private static MainConfig mMainConfig = null;
  public String mAppName = "";
  private ArrayList<PatchInfo> mPatches = new ArrayList();
  private SharedPreferences mSharedPref = null;
  private SharedPreferences.Editor mSharedPrefEditor = null;
  
  private MainConfig() {}
  
  private MainConfig(Context paramContext)
  {
    this.mSharedPref = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0);
    this.mSharedPrefEditor = this.mSharedPref.edit();
    paramContext = this.mSharedPref.getString("PATCH_LIST", "").split(";");
    int j = paramContext.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Object localObject = paramContext[i];
      if (!((String)localObject).equals(""))
      {
        localObject = new PatchInfo(this.mSharedPref, (String)localObject);
        Common.Log.d("KingKongMainConfig", "--> " + localObject);
        this.mPatches.add(localObject);
      }
      i += 1;
    }
  }
  
  public static MainConfig getMainConfig(Context paramContext)
  {
    if (mMainConfig != null) {
      return mMainConfig;
    }
    try
    {
      if (mMainConfig != null)
      {
        paramContext = mMainConfig;
        return paramContext;
      }
    }
    finally {}
    mMainConfig = new MainConfig(paramContext);
    paramContext = mMainConfig;
    return paramContext;
  }
  
  public static MainConfig parseFromFile(String paramString)
  {
    Common.Log.d("KingKongMainConfig", "Analysing Config File " + paramString);
    if (DataReport.getPackageName() == null)
    {
      Common.Log.d("KingKongMainConfig", "Unable to get application name");
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      MainConfig localMainConfig = new MainConfig();
      try
      {
        paramString = Utils.ReadFileToString(paramString);
        Common.Log.d("KingKongMainConfig", "Main config : " + paramString);
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("patches");
        int i = 0;
        for (;;)
        {
          paramString = localMainConfig;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramString = PatchInfo.parseFromJSON(localJSONArray.getJSONObject(i));
          if (paramString == null) {
            return null;
          }
          Common.Log.d("KingKongMainConfig", "-->" + paramString);
          localMainConfig.mPatches.add(paramString);
          i += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        Common.Log.d("KingKongMainConfig", "Parse main config exception " + paramString);
      }
    }
  }
  
  private void updatePatchNames()
  {
    String str = "";
    Iterator localIterator = this.mPatches.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mSharedPrefEditor.putString("PATCH_LIST", str);
        this.mSharedPrefEditor.commit();
        return;
      }
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      str = str + localPatchInfo.mPatchName + ";";
    }
  }
  
  public PatchInfo findPatch(String paramString)
  {
    Iterator localIterator = this.mPatches.iterator();
    PatchInfo localPatchInfo;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localPatchInfo = (PatchInfo)localIterator.next();
    } while (!localPatchInfo.mPatchName.equals(paramString));
    return localPatchInfo;
  }
  
  public ArrayList<PatchInfo> getPatchList()
  {
    return this.mPatches;
  }
  
  public void removePatch(PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.mPatchName;
    Iterator localIterator = this.mPatches.iterator();
    if (!localIterator.hasNext()) {}
    for (;;)
    {
      paramPatchInfo.removeConfig(this.mSharedPrefEditor);
      updatePatchNames();
      return;
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (!localPatchInfo.mPatchName.equals(str)) {
        break;
      }
      this.mPatches.remove(localPatchInfo);
    }
  }
  
  public void removePatch(String paramString)
  {
    Iterator localIterator = this.mPatches.iterator();
    if (!localIterator.hasNext()) {}
    for (;;)
    {
      updatePatchNames();
      return;
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (!localPatchInfo.mPatchName.equals(paramString)) {
        break;
      }
      localPatchInfo.removeConfig(this.mSharedPrefEditor);
      this.mPatches.remove(localPatchInfo);
    }
  }
  
  public void updatePatch(PatchInfo paramPatchInfo)
  {
    int j = -1;
    int i = 0;
    if (i >= this.mPatches.size())
    {
      i = j;
      label17:
      if (i == -1) {
        break label75;
      }
      this.mPatches.set(i, paramPatchInfo);
    }
    for (;;)
    {
      paramPatchInfo.updateConfig(this.mSharedPrefEditor);
      return;
      if (((PatchInfo)this.mPatches.get(i)).mPatchName.equals(paramPatchInfo.mPatchName)) {
        break label17;
      }
      i += 1;
      break;
      label75:
      this.mPatches.add(paramPatchInfo);
      updatePatchNames();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.MainConfig
 * JD-Core Version:    0.7.0.1
 */