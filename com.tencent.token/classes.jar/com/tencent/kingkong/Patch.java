package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

public abstract class Patch
{
  public static final String LOG_TAG = "KingKongPatchInfo";
  public static final String PATCH_TYPE_ARBITRARY = "arbitrary";
  public static final String PATCH_TYPE_ART = "ART";
  public static final String PATCH_TYPE_DVM = "DVM";
  public static final String PATCH_TYPE_JAVA = "java";
  public static final String PATCH_TYPE_NATIVE = "Native";
  public static String mPathSeparator = File.separator;
  public PatchInfo mPatchInfo = null;
  public String mPatchName = "";
  public String mPatchType = "";
  public String mPatchVersion = "";
  public String mPath = "";
  
  public static Patch CreatePatch(String paramString, PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.mType;
    if (str.equals("Native")) {
      paramString = NativePatch.CreatePatch(paramString, paramPatchInfo);
    }
    while (paramString == null)
    {
      return null;
      if ((str.equals("DVM")) || (str.equals("ART")))
      {
        paramString = DvmPatch.CreatePatch(paramString, paramPatchInfo);
      }
      else
      {
        Common.Log.d("KingKongPatchInfo", "Unsupported patch type : " + str);
        return null;
      }
    }
    if ((!paramString.mPatchName.equals(paramPatchInfo.mPatchName)) || (!paramString.mPatchVersion.equals(paramPatchInfo.mVer)) || (!paramString.mPatchType.equals(paramPatchInfo.mType)))
    {
      Common.Log.d("KingKongPatchInfo", "Patch name, version or type mismatch : " + paramString.mPatchName + ", " + paramString.mPatchVersion + ", " + paramString.mPatchType);
      return null;
    }
    paramString.mPatchInfo = paramPatchInfo;
    return paramString;
  }
  
  public static ArrayList<String> getFileList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
      return localArrayList;
    }
    if ((paramString2.equals("DVM")) || (paramString2.equals("ART")))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add(paramString1 + ".jar");
      return localArrayList;
    }
    return null;
  }
  
  public static ArrayList<String> getFilesFileList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
    }
    while ((!paramString2.equals("DVM")) && (!paramString2.equals("ART"))) {
      return localArrayList;
    }
    localArrayList.add(paramString1 + ".cfg");
    localArrayList.add(paramString1 + ".jar");
    localArrayList.add(paramString1 + ".dex");
    return localArrayList;
  }
  
  public abstract int doPatch(Context paramContext);
  
  public String getConfigFileName()
  {
    return this.mPath + mPathSeparator + this.mPatchName + ".cfg";
  }
  
  public ArrayList<String> getFileList()
  {
    return getFileList(this.mPatchName, this.mPatchType);
  }
  
  public abstract boolean initPatch();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.Patch
 * JD-Core Version:    0.7.0.1
 */