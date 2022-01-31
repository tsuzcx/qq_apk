package cooperation.qzone.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import flp;
import java.io.File;

public class ImageFilePathUtil
{
  private static final File a;
  public static final String a;
  private static File b;
  public static String b;
  private static final String c = "com.qzone";
  
  static
  {
    jdField_a_of_type_JavaLangString = "file" + File.separator + "image";
    jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_a_of_type_JavaIoFile = new File(jdField_b_of_type_JavaLangString + File.separator + "Android" + File.separator + "data");
  }
  
  public static File a(String paramString)
  {
    if (jdField_b_of_type_JavaIoFile != null) {
      return jdField_b_of_type_JavaIoFile;
    }
    jdField_b_of_type_JavaIoFile = new File(jdField_a_of_type_JavaIoFile, paramString + File.separator + "qzone" + File.separator + "cache");
    return jdField_b_of_type_JavaIoFile;
  }
  
  private static String a()
  {
    File localFile = flp.b();
    if (localFile == null) {
      return null;
    }
    return localFile.getAbsolutePath();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = UrlKeyGenerator.a().a(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int i = paramString.hashCode();
      if (a())
      {
        paramContext = b(paramContext, jdField_a_of_type_JavaLangString, false);
        if (paramContext != null) {
          break label64;
        }
      }
      label64:
      for (paramContext = null;; paramContext = paramContext + File.separator + String.valueOf(i))
      {
        return paramContext;
        paramContext = a(paramContext, jdField_a_of_type_JavaLangString, false);
        break;
      }
      paramString = str;
    }
  }
  
  private static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramBoolean);
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    if (paramContext.isFile()) {
      FileUtil.a(paramContext);
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  private static String a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone";
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "qzone";
  }
  
  private static boolean a()
  {
    return "mounted".equals(b());
  }
  
  private static final String b()
  {
    return Environment.getExternalStorageState();
  }
  
  private static String b(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (jdField_a_of_type_JavaLangString.equals(paramString))
    {
      paramContext = a();
      if (paramContext != null) {
        break label31;
      }
      localObject = null;
    }
    label31:
    do
    {
      return localObject;
      paramContext = b(paramContext, paramBoolean);
      break;
      localObject = paramContext;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(paramContext + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtil.a(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  private static String b(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramContext = flp.a(paramContext); paramContext == null; paramContext = flp.a(paramContext, "cache")) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qzone.util.ImageFilePathUtil
 * JD-Core Version:    0.7.0.1
 */