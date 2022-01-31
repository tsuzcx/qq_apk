package com.tencent.kingkong;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class UpdateManager
{
  public static final String LOG_TAG = "KingKongUpdateManager";
  public static Context mContext = null;
  public static String mPackageName = "";
  public static String mPatchDownloadFolder = "";
  public static final String mSignature = "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4";
  public static UpdateThread mUpdateThread = null;
  
  public static void ContinueUpdate()
  {
    Iterator localIterator = MainConfig.getMainConfig(mContext).getPatchList().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (localPatchInfo.mStatus.equals("UPDATING"))
      {
        Common.Log.d("KingKongUpdateManager", "Continue udpating " + localPatchInfo.mPatchName);
        Update(localPatchInfo, true);
      }
    }
  }
  
  private static boolean InitPatch(Patch paramPatch)
  {
    return paramPatch.initPatch();
  }
  
  public static void InitUpdateManager(Context paramContext)
  {
    mContext = paramContext;
    mPatchDownloadFolder = Common.GetDownloadFolder();
    mPackageName = DataReport.getPackageName();
    Constant.MAIN_CONFIG_URL += mPackageName;
    Constant.MAIN_CONFIG_URL_OFFLINE = Constant.MAIN_CONFIG_URL_OFFLINE + mPackageName + ".apk";
    if (mUpdateThread == null)
    {
      mUpdateThread = new UpdateThread();
      mUpdateThread.start();
    }
  }
  
  public static void InstallUpdates()
  {
    Object localObject2 = MainConfig.getMainConfig(mContext).getPatchList();
    Object localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    if (!((Iterator)localObject2).hasNext())
    {
      if ((removeObsoletedPatches((ArrayList)localObject1)) && (installPatches((ArrayList)localObject1))) {
        break label111;
      }
      Common.Log.d("KingKongUpdateManager", "Do Install updates failed");
      label53:
      localObject1 = ((ArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        return;
        PatchInfo localPatchInfo = (PatchInfo)((Iterator)localObject2).next();
        if ((!localPatchInfo.mStatus.equals("UPDATED")) && (!localPatchInfo.mStatus.equals("DISABLED"))) {
          break;
        }
        ((ArrayList)localObject1).add(localPatchInfo);
        break;
        label111:
        Common.Log.d("KingKongUpdateManager", "Install updates success!");
        break label53;
      }
      clearPatchDownloadFiles((PatchInfo)((Iterator)localObject1).next());
    }
  }
  
  public static boolean ShouldContinueUpdate()
  {
    return Utils.getCurrentProcessName(mContext).equals(Utils.getPackageName(mContext));
  }
  
  public static boolean ShouldInstallUpdates()
  {
    if (!Utils.getCurrentProcessName(mContext).equals(Utils.getPackageName(mContext))) {}
    String str;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = MainConfig.getMainConfig(mContext).getPatchList().iterator();
      }
      str = ((PatchInfo)localIterator.next()).mStatus;
    } while ((!str.equals("DISABLED")) && (!str.equals("UPDATED")));
    return true;
  }
  
  public static void Update(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!Common.shouldLoadSecureLibrary()) {}
    do
    {
      return;
      if ((mUpdateThread != null) && (mUpdateThread.mHandler != null)) {
        break;
      }
      Common.Log.d("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.initFileFolder();
    } while (!Common.mInterProcessLock.lock());
    try
    {
      paramJSONObject = PatchInfo.parseFromJSON(new JSONObject(paramJSONObject.toString()));
      paramContext = MainConfig.getMainConfig(paramContext);
      if (shouldDoUpdate(paramContext, paramJSONObject, paramBoolean))
      {
        Common.Log.d("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.updatePatch(paramJSONObject);
      }
      Common.mInterProcessLock.unlock();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Common.Log.d("KingKongUpdateManager", "Update Exception : " + paramContext);
      }
    }
    paramContext = paramJSONObject.toString();
    paramJSONObject = mUpdateThread.mHandler.obtainMessage();
    Bundle localBundle = new Bundle();
    localBundle.putString("PATCH_JSON_STRING", paramContext);
    localBundle.putBoolean("PATCH_FORCE_UPDATE", paramBoolean);
    paramJSONObject.setData(localBundle);
    mUpdateThread.mHandler.sendMessage(paramJSONObject);
  }
  
  public static void Update(PatchInfo paramPatchInfo, boolean paramBoolean)
  {
    MainConfig localMainConfig = MainConfig.getMainConfig(mContext);
    String str = paramPatchInfo.mPatchName;
    if (shouldDoUpdate(localMainConfig, paramPatchInfo, paramBoolean))
    {
      Common.Log.d("KingKongUpdateManager", "--> Updating patch : " + paramPatchInfo);
      localMainConfig.updatePatch(paramPatchInfo);
      if ("DISABLED".equals(paramPatchInfo.mStatus)) {
        localMainConfig.updatePatch(paramPatchInfo);
      }
    }
    else
    {
      return;
    }
    if (!downloadPatch(paramPatchInfo))
    {
      localMainConfig.updatePatch(paramPatchInfo);
      clearPatchDownloadFiles(paramPatchInfo);
      Common.Log.d("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!extractPatchFiles(paramPatchInfo)) || (Patch.CreatePatch(mPatchDownloadFolder, paramPatchInfo) == null))
    {
      Common.Log.d("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramPatchInfo.mStatus = "DISABLED";
      localMainConfig.updatePatch(paramPatchInfo);
      return;
    }
    paramPatchInfo.mStatus = "UPDATED";
    localMainConfig.updatePatch(paramPatchInfo);
    Common.Log.d("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static void clearPatchDownloadFiles(PatchInfo paramPatchInfo)
  {
    Object localObject = paramPatchInfo.mPatchName;
    paramPatchInfo = paramPatchInfo.mType;
    Common.Log.d("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramPatchInfo = Patch.getFilesFileList((String)localObject, paramPatchInfo).iterator();
    if (!paramPatchInfo.hasNext())
    {
      paramPatchInfo = Common.makeDownloadName(localObject + ".apk");
      localObject = new File(paramPatchInfo);
      if (((File)localObject).exists()) {
        break label151;
      }
    }
    label151:
    while (((File)localObject).delete())
    {
      return;
      String str = Common.makeDownloadName((String)paramPatchInfo.next());
      File localFile = new File(str);
      if ((!localFile.exists()) || (localFile.delete())) {
        break;
      }
      Common.Log.d("KingKongUpdateManager", "Delete file failed " + str);
      break;
    }
    Common.Log.d("KingKongUpdateManager", "Delete file failed " + paramPatchInfo);
  }
  
  public static void clearPatchInstallFiles(String paramString)
  {
    Common.Log.d("KingKongUpdateManager", "Clear update patch folder : " + paramString);
    Utils.ZapFolder(new File(Common.makeInstallName(paramString)));
    Utils.deletePatchFolder(paramString);
  }
  
  public static boolean downloadPatch(PatchInfo paramPatchInfo)
  {
    String str1 = paramPatchInfo.mUrl;
    String str2 = Common.makeDownloadName(paramPatchInfo.mPatchName + ".apk");
    if (!Utils.download(str1, str2)) {}
    while (!Utils.checkFileSignature(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.reportByType(2085, paramPatchInfo.mPatchName, paramPatchInfo.mVer);
    return true;
  }
  
  private static boolean extractPatchFiles(PatchInfo paramPatchInfo)
  {
    String str1 = paramPatchInfo.mPatchName;
    paramPatchInfo = Patch.getFileList(str1, paramPatchInfo.mType);
    if ((paramPatchInfo == null) || (paramPatchInfo.size() == 0))
    {
      Common.Log.d("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramPatchInfo.size()) {
        return true;
      }
      String str2 = (String)paramPatchInfo.get(i);
      String str3 = Common.makeDownloadName(str2);
      if (!Utils.extractFile(Common.makeDownloadName(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
  }
  
  private static boolean installPatches(ArrayList<PatchInfo> paramArrayList)
  {
    Common.Log.d("KingKongUpdateManager", "Installing updated patches");
    MainConfig localMainConfig = MainConfig.getMainConfig(mContext);
    paramArrayList = paramArrayList.iterator();
    PatchInfo localPatchInfo;
    String str1;
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return true;
      }
      localPatchInfo = (PatchInfo)paramArrayList.next();
      localObject = localPatchInfo.mStatus;
      str1 = localPatchInfo.mPatchName;
      if (!((String)localObject).equals("DISABLED")) {
        break;
      }
      Common.Log.d("KingKongUpdateManager", "Removed " + str1);
    }
    Common.Log.d("KingKongUpdateManager", "--> Installing " + str1);
    Object localObject = Patch.getFileList(str1, localPatchInfo.mType).iterator();
    String str3;
    String str2;
    do
    {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = Patch.CreatePatch(mPatchDownloadFolder, localPatchInfo);
        if ((localObject == null) || (!InitPatch((Patch)localObject))) {
          Common.Log.d("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localPatchInfo.mStatus = "READY";
        localMainConfig.updatePatch(localPatchInfo);
        Common.Log.d("KingKongUpdateManager", "Installed " + str1);
        break;
      }
      str3 = (String)((Iterator)localObject).next();
      str2 = Common.makeDownloadName(str3);
      Utils.mkdirPatchFolder(localPatchInfo.mFolder);
      str3 = Common.makeInstallName(localPatchInfo.mFolder + File.separator + str3);
    } while (Utils.copyFile(str3, str2));
    Common.Log.d("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
    localPatchInfo.mStatus = "UPDATING";
    localMainConfig.updatePatch(localPatchInfo);
    return false;
  }
  
  private static boolean removeObsoletedPatches(ArrayList<PatchInfo> paramArrayList)
  {
    Common.Log.d("KingKongUpdateManager", "Removing obsoleted patches");
    MainConfig localMainConfig = MainConfig.getMainConfig(mContext);
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return true;
      }
      PatchInfo localPatchInfo = (PatchInfo)paramArrayList.next();
      if ((localPatchInfo.mType.equals("Driver")) && (localPatchInfo.mStatus.equals("DISABLED")))
      {
        if (Common.getDriverUsing())
        {
          Common.setDriverUsing(false);
          Common.setDriverFolder("");
          return true;
        }
        Common.setDriverUsing(true);
      }
      clearPatchInstallFiles(localPatchInfo.mFolder);
      Common.removePatchSPs(localPatchInfo.mFlag);
      localMainConfig.removePatch(localPatchInfo.mFlag);
    }
  }
  
  public static boolean shouldDoUpdate(MainConfig paramMainConfig, PatchInfo paramPatchInfo, boolean paramBoolean)
  {
    PatchInfo localPatchInfo = paramMainConfig.findPatch(paramPatchInfo.mFlag);
    StringBuilder localStringBuilder1 = Utils.obtainStringBuild();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramPatchInfo.isEnabled()).append(", support " + paramPatchInfo.isSupported());
    StringBuilder localStringBuilder3 = new StringBuilder(", old version ");
    if (localPatchInfo == null)
    {
      paramMainConfig = "None";
      localStringBuilder2.append(paramMainConfig).append(", new version " + paramPatchInfo.mVer);
      if ((!paramBoolean) && (paramPatchInfo.isEnabled()) && (paramPatchInfo.isSupported()) && (localPatchInfo != null) && (localPatchInfo.mVer.equals(paramPatchInfo.mVer))) {
        break label377;
      }
      if ((paramPatchInfo.isEnabled()) && (paramPatchInfo.isSupported())) {
        break label286;
      }
      if (localPatchInfo != null)
      {
        Common.Log.d("KingKongUpdateManager", "close old patch : " + localPatchInfo.mPatchName + " , " + localPatchInfo.mVer);
        Common.reportByType(2084, localPatchInfo.mPatchName, localPatchInfo.mVer);
      }
    }
    for (paramPatchInfo.mStatus = "DISABLED";; paramPatchInfo.mStatus = "UPDATING")
    {
      Common.Log.d("KingKongUpdateManager", " --> Passed");
      return true;
      paramMainConfig = localPatchInfo.mVer;
      break;
      label286:
      if ((localPatchInfo != null) && (!localPatchInfo.mVer.equals(paramPatchInfo.mVer))) {
        Common.Log.d("KingKongUpdateManager", "upgrade patch : from " + localPatchInfo.mPatchName + " , " + localPatchInfo.mVer + " to " + paramPatchInfo.mPatchName + " , " + paramPatchInfo.mVer);
      }
    }
    label377:
    Common.Log.d("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  static class UpdateHandler
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      paramMessage = paramMessage.getData();
      try
      {
        String str = paramMessage.getString("PATCH_JSON_STRING");
        boolean bool = paramMessage.getBoolean("PATCH_FORCE_UPDATE");
        paramMessage = PatchInfo.parseFromJSON(new JSONObject(str));
        if (paramMessage != null) {
          UpdateManager.Update(paramMessage, bool);
        }
        return;
      }
      catch (Exception paramMessage)
      {
        Common.Log.d("KingKongUpdateManager", "Update patch exception : " + paramMessage);
      }
    }
  }
  
  public static class UpdateThread
    extends Thread
  {
    public static final String KEY_PATCH_FORCE_UPDATE = "PATCH_FORCE_UPDATE";
    public static final String KEY_PATCH_JSON_STRING = "PATCH_JSON_STRING";
    private UpdateManager.UpdateHandler mHandler = null;
    
    public void run()
    {
      Looper.prepare();
      this.mHandler = new UpdateManager.UpdateHandler();
      Looper.loop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */