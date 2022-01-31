package com.tencent.tmassistantsdk.e;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

public final class b
{
  private String a = null;
  private String b = null;
  private FileOutputStream c = null;
  private byte[] d = null;
  private long e = 0L;
  private int f = 0;
  
  public b(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = b();
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = d();
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  private boolean a(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null)) {
      return false;
    }
    if (paramLong != this.e)
    {
      j.b("TMAssistantFile", "writeData0 failed,filelen:" + this.e + ",offset:" + paramLong + ",filename:" + this.a);
      return false;
    }
    if (paramInt2 >= 16384) {}
    for (;;)
    {
      try
      {
        if (this.f > 0)
        {
          paramFileOutputStream.write(this.d, 0, this.f);
          this.f = 0;
        }
        paramFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        this.e += paramInt2;
        return true;
      }
      catch (IOException paramFileOutputStream)
      {
        paramFileOutputStream.printStackTrace();
        j.d("TMAssistantFile", "writeData1 failed " + paramFileOutputStream);
        return false;
      }
      if ((this.f + paramInt2 > 16384) && (this.f > 0)) {}
      try
      {
        paramFileOutputStream.write(this.d, 0, this.f);
        this.f = 0;
        System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.f, paramInt2);
        this.f += paramInt2;
        this.e += paramInt2;
      }
      catch (IOException paramFileOutputStream)
      {
        paramFileOutputStream.printStackTrace();
        j.d("TMAssistantFile", "writeData2 failed " + paramFileOutputStream);
      }
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new File(paramString1);
      if (paramString1.exists() == true)
      {
        boolean bool = paramString1.renameTo(new File(paramString2));
        if (bool) {
          e.e(paramString2);
        }
        return bool;
      }
    }
    j.d("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
    return false;
  }
  
  private static String b(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = d();
    } while (str == null);
    return str + "/.tmp/" + paramString + ".tmp";
  }
  
  public static String d()
  {
    Object localObject = e.a().b();
    if (localObject == null) {
      return null;
    }
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite())) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = ((Context)localObject).getPackageName();
      localObject = "/tencent/TMAssistantSDK/Download/" + (String)localObject;
      return Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;
    }
    return ((Context)localObject).getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.c != null)
      {
        int i = this.f;
        bool1 = bool2;
        if (i <= 0) {}
      }
      try
      {
        this.c.write(this.d, 0, this.f);
        this.f = 0;
        bool1 = true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          j.d("TMAssistantFile", "flush failed " + localIOException);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final void a()
  {
    String str = b(this.a);
    j.b("TMAssistantFile", "deleteFile 1 tmpFilePathString: " + str);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      j.b("TMAssistantFile", "deleteFile 2 file: " + localFile);
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        j.b("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
      }
    }
    else
    {
      return;
    }
    j.b("TMAssistantFile", "deleteFile 3");
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    String str2;
    boolean bool1;
    label79:
    try
    {
      if (this.c != null) {
        break label214;
      }
      str2 = b(this.a);
      if (str2 == null) {
        break label295;
      }
      try
      {
        if (!TextUtils.isEmpty(str2)) {
          break label79;
        }
        throw new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        j.d("TMAssistantFile", "write failed" + paramArrayOfByte);
        bool1 = bool2;
      }
      return bool1;
    }
    finally {}
    paramInt1 = str2.lastIndexOf("/");
    if ((paramInt1 == -1) || (str2.length() == 1)) {
      throw new InvalidParameterException("fileFullPath is not a valid full path. fileName: " + str2);
    }
    if (paramInt1 > 0) {}
    for (String str1 = str2.substring(0, paramInt1);; str1 = str2)
    {
      File localFile = new File(str1);
      if (!localFile.exists()) {}
      for (bool1 = localFile.mkdirs();; bool1 = true)
      {
        if (!bool1) {
          throw new IOException("Failed to create directory. dir: " + str1);
        }
        this.c = new FileOutputStream(str2, true);
        label214:
        if (this.d == null)
        {
          this.d = new byte[16384];
          this.f = 0;
        }
        bool2 = a(this.c, paramArrayOfByte, 0, paramInt2, paramLong);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        if ((paramBoolean == true) && (f() == true))
        {
          bool1 = a(b(this.a), a(this.b));
          break;
          label295:
          j.d("TMAssistantFile", "write failed tmpFilePathString is null");
          bool1 = bool2;
          break;
        }
        bool1 = true;
        break;
      }
    }
  }
  
  public final long b()
  {
    long l = 0L;
    Object localObject = a(this.b);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        break label81;
      }
      localObject = b(this.a);
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          break label70;
        }
        this.e = 0L;
      }
    }
    for (;;)
    {
      l = this.e;
      return l;
      label70:
      this.e = ((File)localObject).length();
      continue;
      label81:
      this.e = ((File)localObject).length();
    }
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 225	com/tencent/tmassistantsdk/e/b:f	()Z
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/tencent/tmassistantsdk/e/b:c	Ljava/io/FileOutputStream;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 26	com/tencent/tmassistantsdk/e/b:c	Ljava/io/FileOutputStream;
    //   18: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 26	com/tencent/tmassistantsdk/e/b:c	Ljava/io/FileOutputStream;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 28	com/tencent/tmassistantsdk/e/b:d	[B
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 30	com/tencent/tmassistantsdk/e/b:e	J
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   44: goto -23 -> 21
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	b
    //   39	2	1	localIOException	IOException
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	39	java/io/IOException
    //   2	7	47	finally
    //   7	21	47	finally
    //   21	36	47	finally
    //   40	44	47	finally
  }
  
  public final void e()
  {
    a(b(this.a), a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.b
 * JD-Core Version:    0.7.0.1
 */