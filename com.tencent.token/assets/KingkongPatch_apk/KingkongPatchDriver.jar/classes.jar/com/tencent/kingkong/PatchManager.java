package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PatchManager
{
  private static final String LOG_TAG = "KingKongPatchManager";
  private static final String PATCH_DISPATCHER_LIBRARY_FILE = "libPatchDispatcher.so";
  private static final String PATCH_DRIVER_LIBRARY_FILE = "libkkfixerdriver.so";
  private static Context mContext = null;
  private static String mPatchDownloadFolder = "";
  private static String mPatchFolder = "";
  private static String mPathSeparator = File.separator;
  
  public static void DoPatches(HashMap<String, Integer> paramHashMap)
  {
    Object localObject = createPatches();
    HashMap localHashMap = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      Patch localPatch = (Patch)((Iterator)localObject).next();
      PatchInfo localPatchInfo = localPatch.mPatchInfo;
      String str1 = localPatchInfo.mPreviousPatch;
      String str2 = localPatchInfo.mPatchName;
      if (paramHashMap.containsKey(localPatchInfo.mFlag))
      {
        Common.Log.d("KingKongPatchManager", "have already done the patch : " + localPatchInfo.mFlag);
      }
      else if ((!str1.equals("")) && ((!localHashMap.containsKey(str1)) || (((Integer)localHashMap.get(str1)).intValue() != 0)))
      {
        Common.Log.d("KingKongPatchManager", "Previouse patch " + str1 + " of " + str2 + " failed");
      }
      else
      {
        int i = localPatch.doPatch(mContext);
        localHashMap.put(str2, Integer.valueOf(i));
        Common.reportDoPatch(i, localPatch.mPatchName, localPatch.mPatchType, localPatch.mPatchVersion, "");
        paramHashMap.put(localPatchInfo.mFlag, Integer.valueOf(1));
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
        localObject2 = Patch.CreatePatch(mPatchFolder + File.separator + ((PatchInfo)localObject2).mFolder, (PatchInfo)localObject2);
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
  
  private static boolean loadSecureLibrary()
  {
    String str1 = Common.getDriverFolder() + File.separator + "libkkfixerdriver.so";
    String str2 = Common.getDriverFolder() + File.separator + "libPatchDispatcher.so";
    String str3 = Common.getDriverFolder() + File.separator + "libstlport_shared.so";
    try
    {
      System.load(str3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.PatchManager
 * JD-Core Version:    0.7.0.1
 */