package moai.patch.handle;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import moai.patch.exception.FastFail;
import moai.patch.log.PatchLog;
import moai.patch.multidex.MultiDex;
import moai.patch.sharedpref.SharedPrefUtil;
import moai.patch.util.DeviceUtil;
import moai.patch.util.PatchUtil;
import moai.patch.util.VersionUtil;

public class PatchCleanTask
{
  private void cleanUpPatch(Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    PatchLog.w(1013, "cleanUpPatch, isStartUp:" + paramBoolean);
    try
    {
      PatchUtil.deleteDirectory(new File(paramContext.getCacheDir(), "patch"));
      PatchUtil.deleteDirectory(paramContext.getDir("patch", 0));
      paramContext = MultiDex.getDefaultMultiDexDir(paramContext).listFiles(new PatchCleanTask.2(this));
      if (paramContext != null)
      {
        int j = paramContext.length;
        while (i < j)
        {
          File localFile = paramContext[i];
          PatchLog.d("delete file:" + localFile.getAbsolutePath());
          PatchUtil.forceDelete(localFile);
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      PatchLog.e(1014, "cleanUpPatch fail:" + paramContext.toString() + ",isStartUp:" + paramBoolean);
    }
  }
  
  private static File[] findPreviousVersions(File paramFile, int paramInt)
  {
    return paramFile.listFiles(new PatchCleanTask.1(paramInt));
  }
  
  public boolean checkCleanPatch(Context paramContext)
  {
    String str = SharedPrefUtil.getCurrentPatchKey(paramContext);
    if (VersionUtil.isCurrentVersionFirstLaunch(paramContext))
    {
      clean(paramContext);
      PatchLog.w(2000, "app first launch:" + VersionUtil.getVersionCode(paramContext) + ",key:" + str);
      return true;
    }
    if (SharedPrefUtil.isRevertPatch(paramContext))
    {
      clean(paramContext);
      PatchLog.w(1015, "revert patch. base version:" + VersionUtil.getVersionCode(paramContext) + ",key:" + str);
      return true;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (DeviceUtil.isPatchFingerPrint4x(paramContext)))
    {
      PatchLog.w(1039, "clean patch. api upgrade to:" + Build.VERSION.SDK_INT + ",fingerprint:" + SharedPrefUtil.getPatchRomFingerprint(paramContext) + ",key:" + str);
      clean(paramContext);
      return true;
    }
    return false;
  }
  
  public void clean(Context paramContext)
  {
    cleanUpPatch(paramContext, true);
    SharedPrefUtil.clear(paramContext);
    FastFail.clear(paramContext);
  }
  
  public void clearPreviousPatch(File paramFile, String paramString)
  {
    paramFile = findPreviousVersions(paramFile, Integer.parseInt(paramString.substring(paramString.lastIndexOf("_") + 1)));
    if ((paramFile != null) && (paramFile.length > 0)) {
      try
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          PatchUtil.deleteDirectory(paramFile[i]);
          i += 1;
        }
        return;
      }
      catch (IOException paramFile) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchCleanTask
 * JD-Core Version:    0.7.0.1
 */