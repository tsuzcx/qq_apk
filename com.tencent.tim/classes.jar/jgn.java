import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

public class jgn
{
  public static String RT = ".mp4";
  
  public static long bS()
  {
    File localFile = Environment.getExternalStorageDirectory();
    try
    {
      StatFs localStatFs = new StatFs(localFile.getPath());
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getAvailableBlocks();
      if (QLog.isColorLevel()) {
        QLog.d("FileSwapHelper", 2, "getStorageLeft left=" + l1 * l2);
      }
      return l1 * l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FileSwapHelper", 1, "getSpaceLeft exception:" + localThrowable + ", path=" + localFile, localThrowable);
    }
    return 2147483647L;
  }
  
  public static void e(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileSwapHelper", 2, "notifyMp4Saved=" + paramString);
    }
    rox.a(paramContext, new File(paramString));
  }
  
  public static long getFileSize(File paramFile)
    throws Exception
  {
    if (paramFile.exists())
    {
      paramFile = new FileInputStream(paramFile);
      long l = paramFile.available();
      paramFile.close();
      return l;
    }
    QLog.e("FileSwapHelper", 1, new Object[] { "获取文件大小", "文件不存在!" });
    return 0L;
  }
  
  public static String hn()
  {
    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    str = str + "/QQVideo/";
    str = str + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    str = str + RT;
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgn
 * JD-Core Version:    0.7.0.1
 */