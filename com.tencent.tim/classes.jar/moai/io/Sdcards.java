package moai.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.Method;

public final class Sdcards
{
  private static String TAG = Sdcards.class.getSimpleName();
  private static final boolean sdkVersionKitKat;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool = true;; bool = false)
    {
      sdkVersionKitKat = bool;
      return;
    }
  }
  
  public static boolean createExternalCacheDirectory()
  {
    if (!hasSdcard()) {
      return false;
    }
    File localFile = new File(Files.CACHE_URL);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return true;
  }
  
  @TargetApi(9)
  public static long getUsableSpace(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return paramFile.getUsableSpace();
    }
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getBlockSize();
    return paramFile.getAvailableBlocks() * l;
  }
  
  public static boolean hasSdcard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  private static boolean isAppDefaultStorageDirectory(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      if (!paramString.substring(0, 1).equals("/")) {
        break label122;
      }
    }
    label122:
    for (String str = paramString.substring(1);; str = paramString)
    {
      int i = str.split("/").length;
      if (i < 3) {}
      do
      {
        do
        {
          return true;
          if (3 == i)
          {
            if (paramString.contains("/Android")) {}
            for (boolean bool = true;; bool = false) {
              return bool;
            }
          }
          if (4 != i) {
            break;
          }
        } while (paramString.contains("/Android/data"));
        return false;
      } while (paramString.contains("/Android/data/" + paramContext.getPackageName()));
      return false;
      return false;
    }
  }
  
  private static boolean isAppDefaultStorageDirectoryRoot(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      String str = paramString;
      if (paramString.substring(0, 1).equals("/")) {
        str = paramString.substring(1);
      }
      if (str.split("/").length < 5) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isAvaiableSpace(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (hasSdcard())
    {
      bool1 = bool2;
      if (getUsableSpace(new File(Environment.getExternalStorageDirectory().getPath())) > paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isCurrentSdcardDirectoryWritable(Context paramContext, String paramString)
  {
    return (!Files.isFileDir(paramString)) || (!isAppDefaultStorageDirectoryRoot(paramString)) || (isInnerStorageDirectory(paramContext, paramString)) || (!sdkVersionKitKat);
  }
  
  @TargetApi(9)
  public static boolean isExternalStorageRemovable()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
  
  private static boolean isInnerStorageDirectory(Context paramContext, String paramString)
  {
    Object localObject = Environment.getExternalStorageDirectory();
    if (localObject != null)
    {
      localObject = ((File)localObject).getAbsolutePath();
      paramContext = (StorageManager)paramContext.getSystemService("storage");
      try
      {
        paramContext = (String[])paramContext.getClass().getMethod("getVolumePaths", new Class[0]).invoke(paramContext, new Object[0]);
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = paramContext[i];
          if (paramString.contains(localCharSequence))
          {
            boolean bool = localCharSequence.equalsIgnoreCase((String)localObject);
            return bool;
          }
          i += 1;
        }
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean isSdcardDirectoryOnWritablePath(Context paramContext, String paramString)
  {
    return (!Files.isFileDir(paramString)) || (isAppDefaultStorageDirectory(paramContext, paramString)) || (!sdkVersionKitKat) || (isInnerStorageDirectory(paramContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.Sdcards
 * JD-Core Version:    0.7.0.1
 */