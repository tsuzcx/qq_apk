package moai.patch.handle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import moai.patch.MoaiApplication;
import moai.patch.conf.Action;
import moai.patch.exception.MoaiExceptionHandler;
import moai.patch.log.PatchLog;
import moai.patch.multidex.MultiDex;
import moai.patch.natives.CpuArch;
import moai.patch.sharedpref.SharedPrefUtil;
import moai.patch.util.BroadCastUtil;
import moai.patch.util.DeviceUtil;
import moai.patch.util.DexFilter;
import moai.patch.util.ExtractUtil;
import moai.patch.util.PatchUtil;
import moai.patch.util.VersionUtil;

@SuppressLint({"CommitPrefEdits"})
public class PatchTask
{
  public static final String PATCH_DIR = "patch";
  public static final String PATCH_DIR_WORKING_FINISH_FLAG_NAME = "working_finish";
  public static final String SP_NO_RES_PATCH = "res_patch";
  public static final String SP_PATCH_KEY = "patch_key";
  public static final String SP_RESTARTED = "patch_restarted";
  public static final String SP_REVERT = "patch_revert";
  public static final String SP_ROM_FINGERPRINT = "patch_rom_fingerprint";
  
  private boolean cleanUpCacheFile(Context paramContext)
  {
    try
    {
      PatchUtil.deleteDirectory(new File(paramContext.getCacheDir(), "patch"));
      return false;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        PatchLog.e(1012, "cleanUpCacheFile fail:" + paramContext.toString());
      }
    }
  }
  
  private boolean cleanUpWorkingDir(Context paramContext, File paramFile)
  {
    try
    {
      cleanUpCacheFile(paramContext);
      PatchUtil.deleteDirectory(paramFile);
      label10:
      return false;
    }
    catch (Exception paramContext)
    {
      break label10;
    }
  }
  
  public static boolean hasResPatch(Context paramContext)
  {
    return SharedPrefUtil.getPatchSharedPreference(paramContext).getBoolean("res_patch", true);
  }
  
  private void setPatched(Context paramContext, String paramString1, String paramString2)
  {
    PatchLog.w(1011, "setPatched,patchKey:" + paramString1 + ",patchDir:" + paramString2 + ",appVersion:" + VersionUtil.getVersionCode(paramContext));
    SharedPrefUtil.getEditor(paramContext).putString("patch_key", paramString1).putBoolean("patch_restarted", false).putString("patch_rom_fingerprint", DeviceUtil.getRomCurrentFingerprint()).putBoolean("patch_revert", false).commit();
  }
  
  private static void setResPatch(Context paramContext, boolean paramBoolean)
  {
    PatchLog.d("has res patch: " + paramBoolean);
    SharedPrefUtil.getEditor(paramContext).putBoolean("res_patch", paramBoolean).commit();
  }
  
  public static boolean setRevertPatch(Context paramContext)
  {
    SharedPrefUtil.getEditor(paramContext).putBoolean("patch_revert", true).putBoolean("patch_restarted", false).commit();
    return false;
  }
  
  public boolean install(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (SharedPrefUtil.isKeyPatched(paramContext, paramString1))
    {
      PatchLog.i(1001, "key patched:" + paramString1);
      return false;
    }
    int i = PatchBlackList.patchFailCount(paramContext, paramString1);
    if (i > 0)
    {
      PatchLog.w(1019, "patch crashed,count:" + i + ",patchKey:" + paramString1);
      if (i >= 2)
      {
        PatchLog.e(1020, "patch crashed over 2 times,reject to install,count:" + i + ",patchKey:" + paramString1);
        return false;
      }
    }
    long l1 = System.currentTimeMillis();
    if ((paramString2 == null) || (paramString2.equals("")) || (!new File(paramString2).exists()))
    {
      PatchLog.e(1002, "zip path invalid:" + paramString2);
      return false;
    }
    if (!PatchVerify.isAuthorized(paramContext, paramString2))
    {
      PatchLog.e(1003, "patch auth fail:" + paramString2);
      return false;
    }
    cleanUpCacheFile(paramContext);
    Object localObject1 = paramContext.getDir("patch", 0);
    File localFile1 = new File((File)localObject1, NameGenerator.nextPatchDirName((File)localObject1));
    try
    {
      PatchUtil.forceMkdir(localFile1);
      localObject2 = new File(paramContext.getCacheDir(), "patch");
      PatchUtil.forceMkdir((File)localObject2);
      if (!PatchUtil.unzip(paramString2, ((File)localObject2).getAbsolutePath()))
      {
        PatchLog.e(1004, "unzip patch fail:" + paramString2);
        return cleanUpCacheFile(paramContext);
      }
      localObject3 = ConfParser.parse(new File((File)localObject2, "patch.inf"));
      if ((((PatchConfig)localObject3).getCmd() == null) || ("".equals(((PatchConfig)localObject3).getCmd())))
      {
        PatchLog.e(1005, "patch invalid cmd:" + ((PatchConfig)localObject3).getCmd());
        return false;
      }
    }
    catch (Throwable paramString1)
    {
      PatchLog.e(1016, "patch fail:" + paramString1.toString() + "\n" + Log.getStackTraceString(paramString1));
      BroadCastUtil.send(paramContext, Action.ACTION_PATCH_FAIL.name());
      MoaiExceptionHandler.handle(paramContext, Thread.currentThread(), "patch_service_process", paramString1);
      return cleanUpWorkingDir(paramContext, localFile1);
    }
    if (((PatchConfig)localObject3).getCmd().equals("revert"))
    {
      PatchLog.w(1006, "patch revert:" + paramString1);
      return setRevertPatch(paramContext);
    }
    if (!((PatchConfig)localObject3).getCmd().equals("patch")) {
      throw new IllegalArgumentException("patch_invalid_cmd:" + ((PatchConfig)localObject3).getCmd());
    }
    paramString2 = new File((File)localObject2, "dex.patch");
    localObject1 = new File((File)localObject2, "dex.record");
    File localFile2 = new File((File)localObject2, "res.patch");
    File localFile3 = new File((File)localObject2, "res.record");
    if ((!paramString2.exists()) || (!((File)localObject1).exists()))
    {
      PatchLog.e(1007, "patch zip contains no essential file:" + paramString2.exists() + "," + ((File)localObject1).exists());
      return cleanUpCacheFile(paramContext);
    }
    boolean bool1 = bool2;
    if (localFile2.exists())
    {
      bool1 = bool2;
      if (localFile3.exists()) {
        bool1 = true;
      }
    }
    setResPatch(paramContext, bool1);
    if (bool1)
    {
      String str = ResPatch.patch(paramContext, (File)localObject2, localFile2, localFile3, (PatchConfig)localObject3);
      localFile2.delete();
      localFile3.delete();
      localObject2 = NewApkCreator.createApkNoDex(paramContext.getApplicationInfo().sourceDir, localFile1, (File)localObject2);
      PatchUtil.deleteDirectory(new File(str));
      if (!NativePatch.patch((PatchConfig)localObject3, (String)localObject2, localFile1, CpuArch.supportABIs()))
      {
        PatchLog.e(1008, "native patch fail");
        return cleanUpWorkingDir(paramContext, localFile1);
      }
    }
    Object localObject2 = DexPatch.patch(paramContext, localFile1, paramString2, (File)localObject1, (PatchConfig)localObject3);
    paramString2.delete();
    ((File)localObject1).delete();
    Object localObject3 = MultiDex.getDefaultMultiDexDir(paramContext);
    localObject1 = ((File)localObject2).listFiles(new DexFilter());
    paramString2 = (String)localObject1;
    if (Build.VERSION.SDK_INT > 19)
    {
      ExtractUtil.extractAllDexExcept(paramContext.getApplicationInfo().sourceDir, localFile1, (File)localObject2, (File[])localObject1);
      paramString2 = ((File)localObject2).listFiles(new DexFilter());
    }
    if ((paramString2 != null) && (paramString2.length > 0))
    {
      if (!DexPatch.optimizeAll(paramString2, (File)localObject3))
      {
        PatchLog.e(1009, "patch optimize dex fail");
        return cleanUpWorkingDir(paramContext, localFile1);
      }
    }
    else {
      throw new RuntimeException("allDexes empty");
    }
    cleanUpCacheFile(paramContext);
    if (!new File(localFile1, "working_finish").createNewFile()) {
      throw new RuntimeException("fail to create working finish flag file");
    }
    setPatched(paramContext, paramString1, localFile1.getAbsolutePath());
    long l2 = System.currentTimeMillis();
    PatchLog.w(1010, "patch success:" + PatchUtil.getDirSize(localFile1), l2 - l1);
    BroadCastUtil.send(paramContext, Action.ACTION_PATCH_SUCCESS.name());
    if (PatchUtil.isBackground(paramContext)) {
      MoaiApplication.killProcessIfNeed(paramContext, true);
    }
    return true;
  }
  
  public void reodex(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      File localFile = MultiDex.getDefaultMultiDexDir(paramContext);
      File[] arrayOfFile = new File(NameGenerator.getMaxMoaiPatchDir(paramContext, true), "dex").listFiles(new DexFilter());
      boolean bool1 = bool2;
      if (arrayOfFile != null)
      {
        bool1 = bool2;
        if (arrayOfFile.length > 0) {
          bool1 = DexPatch.optimizeAll(arrayOfFile, localFile);
        }
      }
      if (bool1)
      {
        SharedPrefUtil.getEditor(paramContext).putString("patch_rom_fingerprint", DeviceUtil.getRomCurrentFingerprint()).putBoolean("patch_restarted", false).commit();
        return;
      }
      throw new RuntimeException("reodex failed: " + Arrays.toString(arrayOfFile));
    }
    catch (Throwable localThrowable)
    {
      PatchLog.e(3006, "reodex failed, clean patch", localThrowable);
      new PatchCleanTask().clean(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchTask
 * JD-Core Version:    0.7.0.1
 */