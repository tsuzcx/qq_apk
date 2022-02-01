package moai.patch.handle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint({"CommitPrefEdits"})
public class PatchBlackList
{
  private static SharedPreferences getBlackSharedPref(Context paramContext)
  {
    return paramContext.getSharedPreferences("moai_patch_black_list", 4);
  }
  
  private static String getPatchKeyFailKey(String paramString)
  {
    return paramString + "_fail_count";
  }
  
  public static void increasePatchFailCount(Context paramContext, String paramString)
  {
    increasePatchFailCountBy(paramContext, paramString, 1);
  }
  
  public static void increasePatchFailCountBy(Context paramContext, String paramString, int paramInt)
  {
    getBlackSharedPref(paramContext).edit().putInt(getPatchKeyFailKey(paramString), patchFailCount(paramContext, paramString) + paramInt).commit();
  }
  
  static boolean isPatchKeyBlack(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (getBlackSharedPref(paramContext).getInt(paramString, 0) >= 2) {
      bool = true;
    }
    return bool;
  }
  
  static int patchFailCount(Context paramContext, String paramString)
  {
    return getBlackSharedPref(paramContext).getInt(getPatchKeyFailKey(paramString), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchBlackList
 * JD-Core Version:    0.7.0.1
 */