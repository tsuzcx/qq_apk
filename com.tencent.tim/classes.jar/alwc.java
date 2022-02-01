import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class alwc
{
  private String bYL;
  private FileOutputStream l;
  private String mCachePath;
  
  public alwc(String paramString)
    throws RuntimeException
  {
    this.mCachePath = paramString;
    this.mCachePath = (this.mCachePath + File.separator + "audio_data_cache" + File.separator);
    paramString = new File(this.mCachePath);
    boolean bool1 = paramString.mkdirs();
    boolean bool2 = paramString.isDirectory();
    if ((!bool1) && (!bool2))
    {
      paramString = new RuntimeException("AudioDataCache: mkd=" + bool1 + " isdir=" + bool2);
      QLog.e("AudioDataCache", 2, paramString, new Object[0]);
      ambe.j(paramString);
    }
  }
  
  private static void l(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("AudioDataCache", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("AudioDataCache", 2, "[@] " + paramString);
  }
  
  public boolean e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      FileOutputStream localFileOutputStream = this.l;
      bool1 = bool2;
      if (localFileOutputStream != null) {}
      try
      {
        this.l.write(paramArrayOfByte, paramInt1, paramInt2);
        bool1 = true;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          l("writeData: exp=", paramArrayOfByte);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public void qh()
  {
    File localFile;
    try
    {
      l("initCache: oldpath=" + this.bYL + " mOutStream=" + this.l, null);
      this.bYL = anlb.Ab();
      String str = this.mCachePath + this.bYL;
      localFile = new File(str);
      if (localFile.exists()) {
        throw new RuntimeException("AudioDataCache: file exists| " + str);
      }
    }
    finally {}
    try
    {
      this.l = new FileOutputStream(localFile);
      l("initCache: newPath=" + this.bYL, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.l = null;
      }
    }
  }
  
  public String wX()
  {
    return this.mCachePath + this.bYL;
  }
  
  /* Error */
  public String yC()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 20	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   9: ldc 131
    //   11: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 107	alwc:bYL	Ljava/lang/String;
    //   18: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: aconst_null
    //   25: invokestatic 100	alwc:l	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: new 20	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: getfield 18	alwc:mCachePath	Ljava/lang/String;
    //   39: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 107	alwc:bYL	Ljava/lang/String;
    //   46: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 87	alwc:l	Ljava/io/FileOutputStream;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +10 -> 69
    //   62: aload_0
    //   63: getfield 87	alwc:l	Ljava/io/FileOutputStream;
    //   66: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_2
    //   79: goto -10 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	alwc
    //   52	20	1	str	String
    //   73	4	1	localObject	Object
    //   57	2	2	localFileOutputStream	FileOutputStream
    //   78	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	58	73	finally
    //   62	69	73	finally
    //   62	69	78	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwc
 * JD-Core Version:    0.7.0.1
 */