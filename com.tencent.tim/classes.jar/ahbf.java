import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ahbf
{
  /* Error */
  private static String e(Uri paramUri)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 10	java/lang/String
    //   4: astore_2
    //   5: aload_2
    //   6: iconst_0
    //   7: ldc 12
    //   9: aastore
    //   10: invokestatic 18	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: invokevirtual 24	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: aload_0
    //   17: aload_2
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokestatic 30	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +98 -> 124
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokeinterface 36 1 0
    //   37: ifeq +87 -> 124
    //   40: aload_0
    //   41: astore_1
    //   42: aload_0
    //   43: aload_0
    //   44: aload_2
    //   45: iconst_0
    //   46: aaload
    //   47: invokeinterface 40 2 0
    //   52: invokeinterface 44 2 0
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: ifnull +9 -> 70
    //   64: aload_0
    //   65: invokeinterface 48 1 0
    //   70: aload_1
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 50
    //   79: iconst_1
    //   80: aload_2
    //   81: invokevirtual 54	java/lang/Exception:toString	()Ljava/lang/String;
    //   84: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: ifnull +34 -> 122
    //   91: aload_0
    //   92: invokeinterface 48 1 0
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +9 -> 112
    //   106: aload_1
    //   107: invokeinterface 48 1 0
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: goto -13 -> 102
    //   118: astore_2
    //   119: goto -44 -> 75
    //   122: aconst_null
    //   123: areturn
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -66 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramUri	Uri
    //   30	96	1	localObject1	Object
    //   4	55	2	localObject2	Object
    //   72	9	2	localException1	Exception
    //   118	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   10	25	72	java/lang/Exception
    //   10	25	99	finally
    //   31	40	114	finally
    //   42	58	114	finally
    //   77	87	114	finally
    //   31	40	118	java/lang/Exception
    //   42	58	118	java/lang/Exception
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    return aqhq.fileExistsAndNotEmpty(getRealPath(paramString));
  }
  
  public static String getRealPath(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.startsWith("content"));
    return e(Uri.parse(paramString));
  }
  
  public static boolean isFileExists(String paramString)
  {
    return aqhq.fileExists(getRealPath(paramString));
  }
  
  private static File j(String paramString1, String paramString2)
  {
    paramString1 = ahav.getFileName(paramString1);
    File localFile = new File(agmy.bmg);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString1 = new File(ahav.kW(localFile.getAbsolutePath() + "/" + paramString1 + paramString2));
    try
    {
      paramString1.createNewFile();
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String ld(String paramString)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString)) {
      paramString = null;
    }
    String str2;
    Object localObject4;
    String str1;
    Object localObject3;
    int i;
    Object localObject2;
    do
    {
      return paramString;
      str2 = ahav.getFileName(paramString);
      localObject4 = "";
      Object localObject1 = localObject4;
      str1 = str2;
      localObject3 = localObject4;
      try
      {
        if (str2.indexOf('.') < 0)
        {
          localObject3 = localObject4;
          localObject1 = "." + aqhq.estimateFileType(paramString);
          localObject3 = localObject1;
          str1 = str2 + (String)localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
          localObject2 = localObject3;
          str1 = str2;
        }
        localObject3 = BaseApplicationImpl.getContext();
        str2 = aopl.F((Context)localObject3, str1);
        int j = dz.l(paramString);
        localObject4 = new ContentValues();
        ((ContentValues)localObject4).put("title", str1);
        ((ContentValues)localObject4).put("_display_name", str1);
        ((ContentValues)localObject4).put("description", str1);
        ((ContentValues)localObject4).put("mime_type", str2);
        localObject2 = j(paramString, (String)localObject2);
        if (localObject2 != null) {
          continue;
        }
        return null;
        if (!new File(paramString).renameTo((File)localObject2)) {
          continue;
        }
        QLog.i("FilePathUtil<FileAssistant>", 1, "rename :" + paramString + " to:" + ((File)localObject2).getAbsolutePath());
        localObject2 = ((File)localObject2).getAbsolutePath();
        ((ContentValues)localObject4).put("_data", (String)localObject2);
        if (i != 0) {
          continue;
        }
        ((ContentValues)localObject4).put("datetaken", Long.valueOf(System.currentTimeMillis()));
        ((ContentValues)localObject4).put("orientation", Integer.valueOf(j));
        ((Context)localObject3).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject4);
        return localObject2;
        paramString = (String)localObject2;
      }
      i = ahav.getFileType(str1);
      if ((i != 2) && (i != 0))
      {
        QLog.w("FilePathUtil<FileAssistant>", 1, "unsupport type:" + i);
        return null;
      }
    } while (i != 2);
    long l = ShortVideoUtils.getDuration((String)localObject2);
    ((ContentValues)localObject4).put("datetaken", Long.valueOf(System.currentTimeMillis()));
    ((ContentValues)localObject4).put("duration", Long.valueOf(l));
    ((Context)localObject3).getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject4);
    return localObject2;
  }
  
  public static String le(String paramString)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString)) {}
    Object localObject4;
    String str2;
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    ContentValues localContentValues;
    do
    {
      return null;
      localObject4 = ahav.getFileName(paramString);
      str2 = "";
      String str1 = str2;
      localObject3 = localObject4;
      localObject2 = str2;
      try
      {
        if (((String)localObject4).indexOf('.') < 0)
        {
          localObject2 = str2;
          str1 = "." + aqhq.estimateFileType(paramString);
          localObject2 = str1;
          localObject3 = (String)localObject4 + str1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
          localObject1 = localObject2;
          localObject3 = localObject4;
        }
        localObject2 = BaseApplicationImpl.getContext();
        str2 = aopl.F((Context)localObject2, (String)localObject3);
        j = dz.l(paramString);
        localContentValues = new ContentValues();
        localContentValues.put("title", (String)localObject3);
        localContentValues.put("_display_name", (String)localObject3);
        localContentValues.put("description", (String)localObject3);
        localContentValues.put("mime_type", str2);
        localObject4 = j(paramString, (String)localObject1);
      }
      i = ahav.getFileType((String)localObject3);
      if ((i != 2) && (i != 0))
      {
        QLog.w("FilePathUtil<FileAssistant>", 1, "unsupport type:" + i);
        return null;
      }
    } while (localObject4 == null);
    Object localObject3 = ((File)localObject4).getAbsolutePath();
    localContentValues.put("_data", (String)localObject3);
    if (i == 0)
    {
      localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("orientation", Integer.valueOf(j));
      localObject1 = ((Context)localObject2).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
    }
    for (;;)
    {
      if (ahbr.a((Context)localObject2, paramString, (Uri)localObject1))
      {
        paramString = ((File)localObject4).getAbsolutePath();
        localObject1 = new ahbg();
        MediaScannerConnection.scanFile((Context)localObject2, new String[] { paramString }, new String[] { str2 }, (MediaScannerConnection.OnScanCompletedListener)localObject1);
      }
      return localObject3;
      if (i == 2)
      {
        long l = ShortVideoUtils.getDuration(paramString);
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("duration", Long.valueOf(l));
        localObject1 = ((Context)localObject2).getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
      }
      else
      {
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbf
 * JD-Core Version:    0.7.0.1
 */