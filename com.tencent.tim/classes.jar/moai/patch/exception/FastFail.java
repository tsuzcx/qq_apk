package moai.patch.exception;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import moai.patch.handle.PatchBlackList;
import moai.patch.handle.PatchTask;
import moai.patch.log.PatchLog;
import moai.patch.sharedpref.SharedPrefUtil;

@SuppressLint({"CommitPrefEdits"})
public class FastFail
{
  static final String FAST_FAIL_SP_NAME = "moai_patch_fast_fail";
  public static final int MAX_FAIL_COUNT = 2;
  
  public static void clear(Context paramContext)
  {
    getFastFailSp(paramContext).edit().clear().commit();
  }
  
  public static void fastFailHappen(Context paramContext, int paramInt, String paramString)
  {
    PatchLog.w(2029, "fast fail happen with count:" + paramInt + ",process:" + paramString);
    PatchBlackList.increasePatchFailCount(paramContext, SharedPrefUtil.getCurrentPatchKey(paramContext));
    PatchTask.setRevertPatch(paramContext);
  }
  
  public static SharedPreferences getFastFailSp(Context paramContext)
  {
    return paramContext.getSharedPreferences("moai_patch_fast_fail", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.exception.FastFail
 * JD-Core Version:    0.7.0.1
 */