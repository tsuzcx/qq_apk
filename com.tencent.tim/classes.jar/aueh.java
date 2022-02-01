import android.content.Context;
import android.text.TextUtils;
import com.tencent.cloudfile.CloudDir;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class aueh
{
  public static FileInfo a(atin paramatin)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.setName(paramatin.name);
    localFileInfo.setDirectory(true);
    localFileInfo.bf(paramatin.Y());
    localFileInfo.be(paramatin.a.pLogicDirKey);
    return localFileInfo;
  }
  
  public static FileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.setName(paramFileManagerEntity.fileName);
    if (paramFileManagerEntity.cloudFile == null)
    {
      localFileInfo.bf(paramFileManagerEntity.cloudId);
      localFileInfo.be(paramFileManagerEntity.pDirKey);
    }
    for (;;)
    {
      localFileInfo.setDirectory(false);
      return localFileInfo;
      localFileInfo.bf(paramFileManagerEntity.cloudFile.cloudId);
      localFileInfo.be(paramFileManagerEntity.cloudFile.pLogicDirKey);
    }
  }
  
  public static String aC(Context paramContext)
  {
    paramContext = new File(aqft.aZ(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String ba(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.endsWith(File.separator)) {}
    for (paramString1 = "";; paramString1 = File.separator) {
      return paramString1 + paramString2;
    }
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0) {
        bool2 = bool3;
      }
    }
    try
    {
      bool3 = deleteFile(new File(paramString));
      bool1 = bool3;
      if (bool3)
      {
        bool2 = bool3;
        ahav.JJ(paramString);
        bool1 = bool3;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.delete", 2, "" + paramString.getMessage());
    }
    return bool1;
    return bool2;
  }
  
  /* Error */
  public static boolean f(android.graphics.Bitmap paramBitmap, String paramString)
    throws java.io.IOException, java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ireturn
    //   12: new 163	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 165	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc 167
    //   26: invokespecial 170	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   29: astore_1
    //   30: aload_0
    //   31: getstatic 176	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   34: bipush 70
    //   36: aload_1
    //   37: invokevirtual 182	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: aload_1
    //   44: ifnull -34 -> 10
    //   47: aload_1
    //   48: invokevirtual 187	java/io/OutputStream:flush	()V
    //   51: aload_1
    //   52: invokevirtual 190	java/io/OutputStream:close	()V
    //   55: iload_3
    //   56: ireturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 187	java/io/OutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 190	java/io/OutputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -15 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBitmap	android.graphics.Bitmap
    //   0	78	1	paramString	String
    //   9	34	2	bool1	boolean
    //   40	16	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	30	57	finally
    //   30	41	74	finally
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static String g(long paramLong)
  {
    return aqhp.bO(paramLong);
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static String getFileDirectoryOf(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i < 0);
    return paramString.substring(0, i + 1);
  }
  
  public static long getFileSize(String paramString)
  {
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return 0L;
        try
        {
          paramString = new File(paramString);
          if ((paramString != null) && (paramString.exists()) && (paramString.length() > 0L))
          {
            long l = paramString.length();
            return l;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileUtils", 2, ahav.ti());
    return 0L;
  }
  
  public static ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramString.length)
      {
        Object localObject = paramString[i];
        if ((!paramBoolean) && (localObject.getName().startsWith("."))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localObject.isDirectory()) || (localObject.length() != 0L))
          {
            FileInfo localFileInfo = new FileInfo();
            localFileInfo.setName(localObject.getName());
            localFileInfo.setDirectory(localObject.isDirectory());
            localFileInfo.setPath(localObject.getPath());
            localFileInfo.setSize(localObject.length());
            localFileInfo.setDate(localObject.lastModified());
            localArrayList.add(localFileInfo);
          }
        }
      }
      if (paramInt == 0) {
        Collections.sort(localArrayList, new aueh.a());
      }
      for (;;)
      {
        return localArrayList;
        Collections.sort(localArrayList, new audv());
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean isFileExists(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).exists();
      return bool1;
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.isFileExists", 2, "" + paramString.getMessage());
    }
    return false;
  }
  
  public static String rr(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        return paramString.substring(i + 1);
      }
      return "";
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static boolean sV(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).canRead();
      return bool1;
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.isFileExists", 2, "" + paramString.getMessage());
    }
    return false;
  }
  
  public static class a
    implements Comparator<FileInfo>
  {
    public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
    {
      if (paramFileInfo1.isDirectory()) {
        if (paramFileInfo2.isDirectory()) {
          break label25;
        }
      }
      label25:
      while (paramFileInfo1.getDate() > paramFileInfo2.getDate())
      {
        return -1;
        if (paramFileInfo2.isDirectory()) {
          return 1;
        }
      }
      if (paramFileInfo1.getDate() == paramFileInfo2.getDate()) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aueh
 * JD-Core Version:    0.7.0.1
 */