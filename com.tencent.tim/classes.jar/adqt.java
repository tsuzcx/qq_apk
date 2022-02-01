import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class adqt
{
  private static boolean bQs;
  
  public static void cTP()
  {
    int i = 0;
    try
    {
      bQs = true;
      Object localObject1 = ArkAppCenter.sP();
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.CrashProtect", 2, "profiling clearAllCrashProtectedMark");
      }
      localObject1 = new File((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int j = localObject1.length;
          while (i < j)
          {
            Object localObject3 = localObject1[i];
            String str = localObject3.getName();
            if ((str != null) && (str.contains(".crash_file")))
            {
              if (QLog.isColorLevel()) {
                QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling clearCrashProtectedMark app=", str });
              }
              localObject3.delete();
            }
            i += 1;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private static String getFileName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(ArkAppCenter.sP());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".crash_file");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static boolean ld(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 10	adqt:bQs	Z
    //   8: ifne +87 -> 95
    //   11: aload_0
    //   12: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +80 -> 95
    //   18: aload_0
    //   19: invokestatic 89	adqt:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_3
    //   23: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc 24
    //   31: iconst_2
    //   32: iconst_4
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 91
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_0
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc 93
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: aload_3
    //   53: aastore
    //   54: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   57: new 32	java/io/File
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 96	java/io/File:createNewFile	()Z
    //   70: istore_2
    //   71: iload_2
    //   72: ifeq +18 -> 90
    //   75: ldc 2
    //   77: monitorexit
    //   78: iload_1
    //   79: ireturn
    //   80: astore_0
    //   81: ldc 24
    //   83: iconst_1
    //   84: ldc 98
    //   86: aload_0
    //   87: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: iconst_0
    //   91: istore_1
    //   92: goto -17 -> 75
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -22 -> 75
    //   100: astore_0
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramString	String
    //   1	96	1	bool1	boolean
    //   70	2	2	bool2	boolean
    //   22	40	3	str	String
    // Exception table:
    //   from	to	target	type
    //   66	71	80	java/io/IOException
    //   5	57	100	finally
    //   57	66	100	finally
    //   66	71	100	finally
    //   81	90	100	finally
  }
  
  public static boolean le(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if ((!bQs) && (!TextUtils.isEmpty(paramString)))
        {
          String str = getFileName(paramString);
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling clearCrashProtectedMark appname=", paramString, ",filePath=", str });
          }
          boolean bool2 = new File(str).delete();
          if (bool2) {
            return bool1;
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  public static boolean lf(String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((!bQs) && (!TextUtils.isEmpty(paramString)))
        {
          String str = getFileName(paramString);
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling isAppCrash appname=", paramString, ",filePath=", str });
          }
          if (new File(str).exists())
          {
            QLog.e("ArkApp.CrashProtect", 1, new Object[] { "profiling find preload crashed app=", paramString, ",filePath=", str });
            return bool;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqt
 * JD-Core Version:    0.7.0.1
 */