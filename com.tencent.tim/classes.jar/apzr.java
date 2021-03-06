import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class apzr
{
  private static volatile apzr a;
  private static final byte[] dA = new byte[0];
  public static final String mFileDir = BaseApplicationImpl.context.getCacheDir().getAbsolutePath() + "/tts_cache/";
  
  static
  {
    if (QLog.isColorLevel()) {
      QLog.d("TtsFileCache", 2, "tts_cache: " + mFileDir);
    }
  }
  
  public static apzr a()
  {
    if (a == null) {}
    synchronized (dA)
    {
      if (a == null) {
        a = new apzr();
      }
      return a;
    }
  }
  
  /* Error */
  public void a(String paramString, java.io.ByteArrayOutputStream paramByteArrayOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 76	apzr:clearCache	()V
    //   6: aload_1
    //   7: invokestatic 82	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +34 -> 51
    //   20: aload_2
    //   21: new 90	java/io/FileOutputStream
    //   24: dup
    //   25: new 14	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   32: getstatic 46	apzr:mFileDir	Ljava/lang/String;
    //   35: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   48: invokevirtual 99	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: ldc 54
    //   57: iconst_1
    //   58: ldc 101
    //   60: aload_1
    //   61: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   64: goto -13 -> 51
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: ldc 54
    //   75: iconst_1
    //   76: ldc 101
    //   78: aload_1
    //   79: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: goto -31 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	apzr
    //   0	85	1	paramString	String
    //   0	85	2	paramByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   15	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   20	51	54	java/io/IOException
    //   2	16	67	finally
    //   20	51	67	finally
    //   55	64	67	finally
    //   73	82	67	finally
    //   20	51	72	java/lang/Exception
  }
  
  public void clearCache()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(mFileDir);
        if (!((File)localObject).exists()) {
          return;
        }
        File[] arrayOfFile = ((File)localObject).listFiles();
        int j = arrayOfFile.length;
        i = 0;
        if (i < j)
        {
          localObject = arrayOfFile[i];
          boolean bool = ((File)localObject).delete();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("delete cache: ").append(((File)localObject).getName());
            if (bool)
            {
              localObject = "succ";
              QLog.d("TtsFileCache", 1, (String)localObject);
            }
            else
            {
              localObject = "failed";
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("TtsFileCache", 1, "clearCache Exception: ", localException);
      }
      i += 1;
    }
  }
  
  public InputStream get(String paramString)
  {
    int k = 0;
    Object localObject = new File(mFileDir);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TtsFileCache", 1, "get: dir does not exist");
      }
      if (!((File)localObject).mkdirs())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TtsFileCache", 1, "get: mkdir failed");
        }
        return null;
      }
    }
    localObject = ((File)localObject).listFiles();
    int m = localObject.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (localObject[i].getName().equals(paramString)) {
          j = 1;
        }
      }
      else {
        if (j == 0) {
          break;
        }
      }
      try
      {
        paramString = new BufferedInputStream(new FileInputStream(mFileDir + paramString));
        return paramString;
        i += 1;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          QLog.e("TtsFileCache", 1, "get failed: ", paramString);
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzr
 * JD-Core Version:    0.7.0.1
 */