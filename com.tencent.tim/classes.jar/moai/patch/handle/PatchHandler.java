package moai.patch.handle;

import android.content.Context;
import android.content.Intent;
import java.io.File;
import moai.patch.log.Log;
import moai.patch.sharedpref.SharedPrefUtil;

public class PatchHandler
{
  public static final String PATCH_CMD_PATCH = "patch";
  public static final String PATCH_CMD_REODEX = "reodex";
  public static final String PATCH_CMD_REVERT = "revert";
  public static final String PATCH_FILE_PATH = "patchFilePath";
  public static final String PATCH_KEY = "patchKey";
  private static Log eventLogger;
  
  public static Log getLogger()
  {
    return eventLogger;
  }
  
  public static void handle(Context paramContext, String paramString1, String paramString2)
  {
    if (!new File(paramString2).exists()) {
      return;
    }
    Intent localIntent = new Intent(paramContext, PatchService.class);
    localIntent.putExtra("patchFilePath", paramString2);
    localIntent.putExtra("patchKey", paramString1);
    paramContext.startService(localIntent);
  }
  
  public static boolean isPatched(Context paramContext, String paramString)
  {
    return (paramString == null) || (paramString.equals("")) || (SharedPrefUtil.isKeyPatched(paramContext, paramString));
  }
  
  public static void reodex(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, PatchService.class);
    localIntent.putExtra("reodex", true);
    paramContext.startService(localIntent);
  }
  
  public static void setLogger(Log paramLog)
  {
    eventLogger = paramLog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchHandler
 * JD-Core Version:    0.7.0.1
 */