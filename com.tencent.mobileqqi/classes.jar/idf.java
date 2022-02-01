import android.content.Context;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class idf
{
  private static final File a;
  public static String a;
  private static File jdField_b_of_type_JavaIoFile;
  private static final String jdField_b_of_type_JavaLangString = "InnerEnvironment";
  private static File c;
  private static File d;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString + File.separator + "Android" + File.separator + "data");
  }
  
  public static File a()
  {
    if (c != null) {
      return c;
    }
    c = new File(jdField_a_of_type_JavaIoFile, "com.qzone" + File.separator + "cache");
    return c;
  }
  
  public static File a(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext.getPackageName());
      boolean bool = paramContext.exists();
      if (!bool) {
        try
        {
          new File(jdField_a_of_type_JavaIoFile, ".nomedia").createNewFile();
          if (!paramContext.mkdirs())
          {
            QLog.w("InnerEnvironment", 2, "Unable to create external cache directory");
            return null;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return paramContext;
  }
  
  /* Error */
  public static File a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 71	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: invokestatic 100	idf:b	(Ljava/lang/String;)Ljava/io/File;
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 78	java/io/File:exists	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifne +39 -> 56
    //   20: new 22	java/io/File
    //   23: dup
    //   24: getstatic 52	idf:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   27: ldc 80
    //   29: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: invokevirtual 83	java/io/File:createNewFile	()Z
    //   35: pop
    //   36: aload_0
    //   37: invokevirtual 86	java/io/File:mkdirs	()Z
    //   40: ifne +16 -> 56
    //   43: ldc 10
    //   45: iconst_2
    //   46: ldc 102
    //   48: invokestatic 94	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: ldc 2
    //   53: monitorexit
    //   54: aconst_null
    //   55: areturn
    //   56: aload_1
    //   57: ifnonnull +8 -> 65
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: areturn
    //   65: new 22	java/io/File
    //   68: dup
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 78	java/io/File:exists	()Z
    //   79: ifne +46 -> 125
    //   82: aload_0
    //   83: invokevirtual 86	java/io/File:mkdirs	()Z
    //   86: ifne +39 -> 125
    //   89: ldc 10
    //   91: iconst_2
    //   92: new 30	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   99: ldc 104
    //   101: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 94	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: ldc 2
    //   116: monitorexit
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_0
    //   129: areturn
    //   130: astore_3
    //   131: goto -95 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	Context
    //   0	134	1	paramString	String
    //   15	2	2	bool	boolean
    //   130	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   3	16	119	finally
    //   20	36	119	finally
    //   36	54	119	finally
    //   60	63	119	finally
    //   65	117	119	finally
    //   120	123	119	finally
    //   125	128	119	finally
    //   20	36	130	java/io/IOException
  }
  
  public static File a(String paramString)
  {
    if (b != null) {
      return b;
    }
    b = new File(jdField_a_of_type_JavaIoFile, paramString + File.separator + "qzone" + File.separator + "cache");
    return b;
  }
  
  public static File b()
  {
    try
    {
      File localFile1 = a();
      boolean bool = localFile1.exists();
      if (!bool) {
        try
        {
          new File(jdField_a_of_type_JavaIoFile, ".nomedia").createNewFile();
          if (!localFile1.mkdirs())
          {
            QLog.w("InnerEnvironment", 2, "Unable to create external cache directory");
            return null;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return localFile2;
  }
  
  public static File b(String paramString)
  {
    if (d != null) {
      return d;
    }
    d = new File(jdField_a_of_type_JavaIoFile, paramString + File.separator + "qzone" + File.separator + "files");
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     idf
 * JD-Core Version:    0.7.0.1
 */