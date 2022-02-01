package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class n
{
  private static n a = null;
  private static Context b = null;
  
  static n a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new n();
      }
      b = paramContext.getApplicationContext();
      return a;
    }
    finally {}
  }
  
  /* Error */
  private Properties e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 35	com/tencent/smtt/sdk/n:a	()Ljava/io/File;
    //   6: astore_2
    //   7: new 37	java/util/Properties
    //   10: dup
    //   11: invokespecial 38	java/util/Properties:<init>	()V
    //   14: astore_1
    //   15: aload_2
    //   16: ifnull +115 -> 131
    //   19: aload_1
    //   20: ifnull +111 -> 131
    //   23: new 40	java/io/BufferedInputStream
    //   26: dup
    //   27: new 42	java/io/FileInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 48	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 51	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   52: aload_1
    //   53: astore_3
    //   54: aload_3
    //   55: areturn
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   61: goto -9 -> 52
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   73: aload_1
    //   74: astore_3
    //   75: aload_2
    //   76: ifnull -22 -> 54
    //   79: aload_2
    //   80: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: aload_3
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   110: goto -7 -> 103
    //   113: astore_1
    //   114: goto -19 -> 95
    //   117: astore_1
    //   118: goto -23 -> 95
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: goto -55 -> 69
    //   127: astore_3
    //   128: goto -59 -> 69
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -89 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	n
    //   14	77	1	localProperties	Properties
    //   92	12	1	localObject1	Object
    //   113	1	1	localObject2	Object
    //   117	1	1	localObject3	Object
    //   6	43	2	localObject4	Object
    //   56	2	2	localIOException1	IOException
    //   66	14	2	localObject5	Object
    //   85	2	2	localIOException2	IOException
    //   94	6	2	localObject6	Object
    //   105	2	2	localIOException3	IOException
    //   123	10	2	localObject7	Object
    //   1	54	3	localObject8	Object
    //   64	6	3	localException1	java.lang.Exception
    //   74	20	3	localObject9	Object
    //   121	1	3	localException2	java.lang.Exception
    //   127	1	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	56	java/io/IOException
    //   2	15	64	java/lang/Exception
    //   79	83	85	java/io/IOException
    //   2	15	92	finally
    //   23	39	92	finally
    //   99	103	105	java/io/IOException
    //   39	44	113	finally
    //   69	73	117	finally
    //   23	39	121	java/lang/Exception
    //   39	44	127	java/lang/Exception
  }
  
  File a()
  {
    q.a();
    File localFile = new File(q.t(b), "tbscoreinstall.txt");
    if ((localFile != null) && (!localFile.exists())) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  void a(int paramInt)
  {
    a("dexopt_retry_num", paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a("copy_core_ver", paramInt1);
    a("copy_status", paramInt2);
  }
  
  void a(String paramString)
  {
    a("install_apk_path", paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    a(paramString, String.valueOf(paramInt));
  }
  
  /* Error */
  void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 106	com/tencent/smtt/sdk/n:e	()Ljava/util/Properties;
    //   7: astore 5
    //   9: aload 4
    //   11: astore_3
    //   12: aload 5
    //   14: ifnull +64 -> 78
    //   17: aload 5
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 110	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 35	com/tencent/smtt/sdk/n:a	()Ljava/io/File;
    //   29: astore_2
    //   30: aload 4
    //   32: astore_3
    //   33: aload_2
    //   34: ifnull +44 -> 78
    //   37: new 112	java/io/FileOutputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload 5
    //   50: aload_3
    //   51: new 115	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   58: ldc 118
    //   60: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 124
    //   69: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 132	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: aload_1
    //   99: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   102: aload_3
    //   103: ifnull -17 -> 86
    //   106: aload_3
    //   107: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   116: return
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   135: goto -7 -> 128
    //   138: astore_1
    //   139: goto -19 -> 120
    //   142: astore_1
    //   143: goto -47 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	n
    //   0	146	1	paramString1	String
    //   0	146	2	paramString2	String
    //   11	96	3	localObject1	Object
    //   1	30	4	localObject2	Object
    //   7	42	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   3	9	93	java/lang/Exception
    //   17	30	93	java/lang/Exception
    //   37	46	93	java/lang/Exception
    //   106	110	111	java/io/IOException
    //   3	9	117	finally
    //   17	30	117	finally
    //   37	46	117	finally
    //   124	128	130	java/io/IOException
    //   48	78	138	finally
    //   98	102	138	finally
    //   48	78	142	java/lang/Exception
  }
  
  int b()
  {
    return c("install_core_ver");
  }
  
  int b(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return -1;
  }
  
  void b(int paramInt)
  {
    a("unzip_retry_num", paramInt);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    a("tpatch_ver", paramInt1);
    a("tpatch_status", paramInt2);
  }
  
  int c()
  {
    return b("install_status");
  }
  
  int c(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return 0;
  }
  
  void c(int paramInt)
  {
    a("incrupdate_status", paramInt);
  }
  
  void c(int paramInt1, int paramInt2)
  {
    a("install_core_ver", paramInt1);
    a("install_status", paramInt2);
  }
  
  int d()
  {
    return b("incrupdate_status");
  }
  
  String d(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return localProperties.getProperty(paramString);
    }
    return null;
  }
  
  void d(int paramInt)
  {
    a("unlzma_status", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.n
 * JD-Core Version:    0.7.0.1
 */