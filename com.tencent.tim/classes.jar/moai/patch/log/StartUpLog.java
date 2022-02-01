package moai.patch.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import moai.patch.util.VersionUtil;

public class StartUpLog
{
  private static final String KEY_ATTACH_BASE_CONTEXT = "attach_base_context_";
  private static final String KEY_ATTACH_REAL_CONTEXT = "attach_real_context_";
  private static final String SP_NAME = "moai_patch_start_up_info";
  private static SharedPreferences.Editor sEditor;
  private static boolean sMain;
  private static SharedPreferences sSp;
  private static int sVersionCode;
  
  public static void attachBaseContext(long paramLong)
  {
    if (!sMain) {
      return;
    }
    if (logIfNotExists("attach_base_context_" + sVersionCode, paramLong))
    {
      PatchLog.w(2022, "Main Process first attachBaseContext", paramLong);
      return;
    }
    PatchLog.w(2026, "Main Process attachBaseContext", paramLong);
  }
  
  public static void attachRealContext(long paramLong)
  {
    if (!sMain) {
      return;
    }
    if (logIfNotExists("attach_real_context_" + sVersionCode, paramLong))
    {
      PatchLog.w(2023, "Main Process first attachRealContext", paramLong);
      return;
    }
    PatchLog.w(2027, "Main Process attachRealContext", paramLong);
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    sMain = paramBoolean;
    if (!sMain) {
      return;
    }
    sSp = paramContext.getSharedPreferences("moai_patch_start_up_info", 0);
    sEditor = sSp.edit();
    sVersionCode = VersionUtil.getVersionCode(paramContext);
  }
  
  private static boolean logIfNotExists(String paramString, long paramLong)
  {
    if (sSp.getLong(paramString, -1L) == -1L)
    {
      sEditor.putLong(paramString, paramLong).apply();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.StartUpLog
 * JD-Core Version:    0.7.0.1
 */