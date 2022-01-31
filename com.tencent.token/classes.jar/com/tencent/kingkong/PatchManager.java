package com.tencent.kingkong;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PatchManager
{
  private static final String LOG_TAG = "KingKongPatchManager";
  private static final String PATCH_ART50_LIBRARY_FILE = "libxposed_art50.so";
  private static final String PATCH_ART51_LIBRARY_FILE = "libxposed_art51.so";
  private static final String PATCH_ART60_LIBRARY_FILE = "libxposed_art60.so";
  private static final String PATCH_ASSET_FILE = "KingkongPatch.apk";
  private static final String PATCH_DALVIK_LIBRARY_FILE = "libxposed_dalvik.so";
  private static final String PATCH_DISPATCHER_LIBRARY_FILE = "libPatchDispatcher.so";
  private static final String PATCH_DRIVER_LIBRARY_FILE = "libkkfixerdriver.so";
  private static final String PATCH_LIST_FILE = ".cfg";
  private static Context mContext = null;
  private static String mPatchDownloadFolder = "";
  private static String mPatchFolder = "";
  private static String mPathSeparator = "/";
  
  public static void DoPatches()
  {
    Common.savePointLog(true);
    Object localObject1 = createPatches();
    Common.savePointLog(true);
    HashMap localHashMap = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      Patch localPatch = (Patch)((Iterator)localObject1).next();
      Object localObject2 = localPatch.mPatchInfo;
      String str = ((PatchInfo)localObject2).mPreviousPatch;
      localObject2 = ((PatchInfo)localObject2).mPatchName;
      if ((!str.equals("")) && ((!localHashMap.containsKey(str)) || (((Integer)localHashMap.get(str)).intValue() != 0)))
      {
        Common.Log.d("KingKongPatchManager", "Previouse patch " + str + " of " + (String)localObject2 + " failed");
      }
      else
      {
        int i = localPatch.doPatch(mContext);
        localHashMap.put(localObject2, Integer.valueOf(i));
        Common.reportDoPatch(i, localPatch.mPatchName, localPatch.mPatchType, localPatch.mPatchVersion, "");
      }
    }
  }
  
  public static boolean InitPatchManager(Context paramContext)
  {
    boolean bool1 = true;
    if (paramContext == null) {}
    for (;;)
    {
      return bool1;
      try
      {
        mContext = paramContext.getApplicationContext();
        mPatchDownloadFolder = Common.GetDownloadFolder();
        mPatchFolder = Common.GetPatchFolder();
        Common.savePointLog(true);
        if (!initPatchFiles())
        {
          bool1 = false;
          continue;
        }
        Common.savePointLog(true);
        boolean bool2 = loadSecureLibrary();
        if (bool2) {
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  private static ArrayList<Patch> createPatches()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = MainConfig.getMainConfig(mContext).getPatchList().iterator();
    int i;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        localObject1 = new ArrayList();
        i = 0;
        if (i < localArrayList1.size()) {
          break;
        }
        label56:
        return localArrayList2;
      }
      localObject2 = (PatchInfo)((Iterator)localObject1).next();
      if (((PatchInfo)localObject2).mStatus.equals("READY"))
      {
        localObject2 = Patch.CreatePatch(mPatchFolder, (PatchInfo)localObject2);
        if (localObject2 != null) {
          localArrayList1.add(localObject2);
        }
      }
    }
    Object localObject2 = localArrayList1.iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        if (localArrayList2.size() == localArrayList1.size()) {
          break label56;
        }
        i += 1;
        break;
      }
      Patch localPatch = (Patch)((Iterator)localObject2).next();
      if (!localArrayList2.contains(localPatch))
      {
        String str1 = localPatch.mPatchInfo.mPreviousPatch;
        String str2 = localPatch.mPatchInfo.mPatchName;
        if (str1.equals(""))
        {
          Common.Log.d("KingKongPatchManager", "Patch is ready -->" + str2);
          localArrayList2.add(localPatch);
          ((ArrayList)localObject1).add(str2);
        }
        else if (((ArrayList)localObject1).contains(str1))
        {
          Common.Log.d("KingKongPatchManager", "Patch is ready -->" + str2 + ", previous patch is " + str1);
          localArrayList2.add(localPatch);
          ((ArrayList)localObject1).add(str2);
        }
      }
    }
  }
  
  public static boolean initPatchFiles()
  {
    if (Common.GetInitializeStatus() == 1) {
      return true;
    }
    try
    {
      Object localObject = new File(mPatchDownloadFolder);
      if (!((File)localObject).exists())
      {
        if (((File)localObject).mkdirs()) {
          Common.Log.d("KingKongPatchManager", "Create patch download folder : " + mPatchDownloadFolder + " OK");
        }
      }
      else
      {
        localObject = new File(mPatchFolder);
        if (!((File)localObject).exists())
        {
          if (!((File)localObject).mkdirs()) {
            break label203;
          }
          Common.Log.d("KingKongPatchManager", "Create patch folder : " + mPatchFolder + " OK");
        }
        localObject = new File(mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk");
        if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
          break label233;
        }
        Common.Log.d("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      Common.Log.d("KingKongPatchManager", "Create patch download folder : " + mPatchDownloadFolder + " failed");
      return false;
      label203:
      Common.Log.d("KingKongPatchManager", "Create patch folder : " + mPatchFolder + " failed");
      return false;
      label233:
      if (!((File)localObject).exists())
      {
        if (!Utils.copyAssetToFile(mContext, "KingkongPatch.apk", ((File)localObject).getAbsolutePath()))
        {
          Common.Log.d("KingKongPatchManager", "Copy KingkongPatch.apk from asset failed");
          return false;
        }
        Common.Log.d("KingKongPatchManager", "Copy KingkongPatch.apk from asset OK");
      }
      localObject = mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk";
      if (!Utils.reloadFile(mPatchFolder + mPathSeparator + "libkkfixerdriver.so", (String)localObject, "libkkfixerdriver.so", false)) {
        return false;
      }
      localObject = mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk";
      if (!Utils.reloadFile(mPatchFolder + mPathSeparator + "libPatchDispatcher.so", (String)localObject, "libPatchDispatcher.so", false)) {
        return false;
      }
      if (Build.VERSION.SDK_INT == 23)
      {
        localObject = mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk";
        if (!Utils.reloadFile(mPatchFolder + mPathSeparator + "libxposed_art60.so", (String)localObject, "libxposed_art60.so", false)) {
          return false;
        }
      }
      else if (Build.VERSION.SDK_INT == 22)
      {
        localObject = mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk";
        if (!Utils.reloadFile(mPatchFolder + mPathSeparator + "libxposed_art51.so", (String)localObject, "libxposed_art51.so", false)) {
          return false;
        }
      }
      else if (Build.VERSION.SDK_INT == 21)
      {
        localObject = mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk";
        if (!Utils.reloadFile(mPatchFolder + mPathSeparator + "libxposed_art50.so", (String)localObject, "libxposed_art50.so", false)) {
          return false;
        }
      }
      else if (Build.VERSION.SDK_INT >= 14)
      {
        localObject = mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk";
        if (!Utils.reloadFile(mPatchFolder + mPathSeparator + "libxposed_dalvik.so", (String)localObject, "libxposed_dalvik.so", false)) {
          return false;
        }
      }
      localObject = new File(mPatchDownloadFolder + mPathSeparator + "KingkongPatch.apk");
      if ((((File)localObject).exists()) && (!((File)localObject).delete()))
      {
        Common.Log.d("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      Common.SetInitializeStatus(1);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private static boolean loadSecureLibrary()
  {
    String str1 = mPatchFolder + mPathSeparator + "libkkfixerdriver.so";
    String str2 = mPatchFolder + mPathSeparator + "libPatchDispatcher.so";
    try
    {
      System.load(str2);
      System.load(str1);
      Common.Log.d("KingKongPatchManager", "Load library " + str1 + " OK");
      return true;
    }
    catch (Exception localException)
    {
      Common.Log.d("KingKongPatchManager", "Load library " + str1 + " failed : " + localException);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Common.Log.d("KingKongPatchManager", "Load library " + str1 + " failed : " + localThrowable);
    }
    return false;
  }
  
  public static native int nativeCalcGotHookPoint(String paramString);
  
  public static native int nativeCalcJumperPoint(String paramString);
  
  public static native int nativeCalcParameter(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public static native boolean nativeDoPatch(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5);
  
  public static native byte[] nativeGetFingerprint(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public static native boolean nativeHoldLibStrongRef(String paramString);
  
  public static native boolean nativeVerifyPatchParams(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.PatchManager
 * JD-Core Version:    0.7.0.1
 */