import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class aqsi
{
  public static void aS(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      File localFile1;
      try
      {
        localFile1 = g(paramContext);
        paramContext = bA(paramContext);
        try
        {
          String str1 = localFile1.getAbsolutePath() + "_temp";
          File localFile2 = new File(str1);
          if (localFile2.exists()) {
            aqhq.delete(str1, false);
          }
          aqhq.W(paramContext, str1, false);
          if (localFile1.exists()) {
            aqhq.delete(localFile1.getAbsolutePath(), false);
          }
          int j = 1;
          boolean bool = true;
          String[] arrayOfString = localFile2.list();
          if (arrayOfString != null)
          {
            int i = arrayOfString.length;
            paramInt = 0;
            j = bool;
            if (paramInt < i)
            {
              String str2 = arrayOfString[paramInt];
              if (!str2.startsWith("crc_")) {
                break label453;
              }
              File localFile3 = new File(localFile2, "gldrawable.dex");
              File localFile4 = new File(localFile2, "jni/armeabi-v7a/libgldrawable.so");
              File localFile5 = new File(localFile2, "jni/arm64-v8a/libgldrawable.so");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("crc_");
              localStringBuilder.append(Long.toHexString(IOUtil.getCRC32Value(localFile3))).append("_");
              localStringBuilder.append(Long.toHexString(IOUtil.getCRC32Value(localFile4))).append("_");
              localStringBuilder.append(Long.toHexString(IOUtil.getCRC32Value(localFile5)));
              bool = str2.toLowerCase().equals(localStringBuilder.toString().toLowerCase());
              break label453;
            }
          }
          if (j == 0) {
            continue;
          }
          aqhq.rename(str1, localFile1.getAbsolutePath());
          QLog.d("GLDrawable", 1, "unzip succ..." + new File(paramContext).length() + "..." + arwv.encodeFileHexStr(paramContext));
        }
        catch (IOException localIOException)
        {
          aqsl.iu("unzip", localIOException.getMessage());
          QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + localFile1, " zipPath=" + paramContext, localIOException });
          continue;
        }
        return;
      }
      finally {}
      aqsl.iu("unzip", "unzip crc not valid.");
      continue;
      QLog.e("GLDrawable", 1, "error: " + paramInt);
      continue;
      label453:
      paramInt += 1;
    }
  }
  
  public static String bA(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "GLDrawableV836.zip";
    }
    return paramContext + File.separator + "GLDrawableV836.zip";
  }
  
  public static boolean cg(Context paramContext)
  {
    return new File(bA(paramContext)).exists();
  }
  
  public static void efo()
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(1004L, "GLDrawableV836", "GLDrawable");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static File g(Context paramContext)
  {
    return aqsj.h(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsi
 * JD-Core Version:    0.7.0.1
 */