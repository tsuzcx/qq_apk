package moai.patch.handle;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;
import moai.patch.bsdiff.BSPatch;
import moai.patch.exception.FileInvalidException;
import moai.patch.log.PatchLog;
import moai.patch.util.PatchUtil;

public class ResPatch
{
  public static String patch(Context paramContext, File paramFile1, File paramFile2, File paramFile3, PatchConfig paramPatchConfig)
  {
    long l1;
    File localFile2;
    File localFile1;
    try
    {
      l1 = System.currentTimeMillis();
      localFile2 = new File(paramFile1, "old_res_merge_file");
      localFile1 = new File(paramFile1, "new_res_merge_file");
      PatchMergeFile.mergeDiffFile(paramContext.getApplicationInfo().sourceDir, paramFile3.getAbsolutePath(), localFile2.getAbsolutePath());
      if (!localFile2.exists()) {
        throw new FileInvalidException("old res merge file not exist");
      }
    }
    catch (Exception paramContext)
    {
      PatchLog.e(4001, "res patch fail:" + paramContext.toString() + "\n" + Log.getStackTraceString(paramContext));
      throw new RuntimeException(paramContext);
    }
    long l2 = PatchUtil.adler32(localFile2);
    if (l2 != paramPatchConfig.getOld_res_merge_file_adler32()) {
      throw new FileInvalidException("old res merge file invalid:" + l2 + ", conf:" + paramPatchConfig.getOld_res_merge_file_adler32());
    }
    BSPatch.patchFast(new File(localFile2.getAbsolutePath()), new File(localFile1.getAbsolutePath()), new File(paramFile2.getAbsolutePath()), 0);
    if (!localFile1.exists()) {
      throw new FileInvalidException("new res merge file not exist after patch");
    }
    l2 = PatchUtil.adler32(localFile1);
    if (l2 != paramPatchConfig.getNew_res_merge_file_adler32()) {
      throw new FileInvalidException("new res merge file invalid:" + l2 + ", conf:" + paramPatchConfig.getNew_res_merge_file_adler32());
    }
    localFile2.delete();
    paramContext = new File(paramFile1, "res");
    PatchUtil.forceMkdir(paramContext.getParentFile());
    int i = PatchMergeFile.recover(localFile1.getAbsolutePath(), paramFile3.getAbsolutePath(), paramContext.getAbsolutePath());
    localFile1.delete();
    PatchLog.i(4000, "res patch count:" + i, System.currentTimeMillis() - l1);
    paramContext = paramContext.getAbsolutePath();
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.ResPatch
 * JD-Core Version:    0.7.0.1
 */