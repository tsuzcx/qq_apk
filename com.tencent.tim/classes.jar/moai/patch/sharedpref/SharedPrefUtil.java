package moai.patch.sharedpref;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import moai.patch.handle.NameGenerator;

@SuppressLint({"CommitPrefEdits"})
public class SharedPrefUtil
{
  private static final String MAIN_USING_DEX_DIR = "main_using_dex";
  
  public static void clear(Context paramContext)
  {
    getEditor(paramContext).clear().commit();
  }
  
  public static String getCurrentPatchKey(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).getString("patch_key", "");
  }
  
  public static SharedPreferences.Editor getEditor(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).edit();
  }
  
  public static String getPatchRomFingerprint(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).getString("patch_rom_fingerprint", "");
  }
  
  public static SharedPreferences getPatchSharedPreference(Context paramContext)
  {
    return paramContext.getSharedPreferences("moai_patch", 4);
  }
  
  public static boolean isAppPatched(Context paramContext)
  {
    return NameGenerator.getMaxMoaiPatchDir(paramContext, true) != null;
  }
  
  public static boolean isKeyPatched(Context paramContext, String paramString)
  {
    return getCurrentPatchKey(paramContext).equals(paramString);
  }
  
  public static boolean isMainProcessInitEnd(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).getBoolean("main_start_up_end", false);
  }
  
  public static boolean isPatchRestarted(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).getBoolean("patch_restarted", true);
  }
  
  public static boolean isRevertPatch(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).getBoolean("patch_revert", false);
  }
  
  public static String mainUsingDexDir(Context paramContext)
  {
    return getPatchSharedPreference(paramContext).getString("main_using_dex", "");
  }
  
  public static void markMainProcessInitEnd(Context paramContext, boolean paramBoolean)
  {
    getEditor(paramContext).putBoolean("main_start_up_end", paramBoolean).commit();
  }
  
  public static void setMainUsingDexDir(Context paramContext, String paramString)
  {
    getEditor(paramContext).putString("main_using_dex", paramString).commit();
  }
  
  public static void setPatchRestarted(Context paramContext)
  {
    getEditor(paramContext).putBoolean("patch_restarted", true).commit();
  }
  
  public static void setPatchRomFingerprint(Context paramContext, String paramString)
  {
    getEditor(paramContext).putString("patch_rom_fingerprint", paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.sharedpref.SharedPrefUtil
 * JD-Core Version:    0.7.0.1
 */