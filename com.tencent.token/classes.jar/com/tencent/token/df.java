package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class df
{
  public static File a(Context paramContext)
  {
    Object localObject = new StringBuilder(".font");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Process.myTid());
    ((StringBuilder)localObject).append("-");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < 100)
    {
      File localFile = paramContext.getCacheDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(i);
      localFile = new File(localFile, localStringBuilder.toString());
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool) {
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        label111:
        break label111;
      }
      i += 1;
    }
    return null;
  }
  
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = a(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = a(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static ByteBuffer a(Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: ldc 78
    //   9: aconst_null
    //   10: invokevirtual 84	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +15 -> 32
    //   20: aload 4
    //   22: ifnull +8 -> 30
    //   25: aload 4
    //   27: invokevirtual 89	android/os/ParcelFileDescriptor:close	()V
    //   30: aconst_null
    //   31: areturn
    //   32: new 91	java/io/FileInputStream
    //   35: dup
    //   36: aload 4
    //   38: invokevirtual 95	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   41: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 102	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 108	java/nio/channels/FileChannel:size	()J
    //   56: lstore_2
    //   57: aload_0
    //   58: getstatic 114	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   61: lconst_0
    //   62: lload_2
    //   63: invokevirtual 118	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   66: astore_0
    //   67: aload 5
    //   69: invokevirtual 119	java/io/FileInputStream:close	()V
    //   72: aload 4
    //   74: ifnull +8 -> 82
    //   77: aload 4
    //   79: invokevirtual 89	android/os/ParcelFileDescriptor:close	()V
    //   82: aload_0
    //   83: areturn
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_1
    //   87: goto +7 -> 94
    //   90: astore_1
    //   91: aload_1
    //   92: athrow
    //   93: astore_0
    //   94: aload_1
    //   95: ifnull +22 -> 117
    //   98: aload 5
    //   100: invokevirtual 119	java/io/FileInputStream:close	()V
    //   103: goto +19 -> 122
    //   106: astore 5
    //   108: aload_1
    //   109: aload 5
    //   111: invokevirtual 123	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   114: goto +8 -> 122
    //   117: aload 5
    //   119: invokevirtual 119	java/io/FileInputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: goto +7 -> 134
    //   130: astore_0
    //   131: aload_0
    //   132: athrow
    //   133: astore_1
    //   134: aload 4
    //   136: ifnull +31 -> 167
    //   139: aload_0
    //   140: ifnull +22 -> 162
    //   143: aload 4
    //   145: invokevirtual 89	android/os/ParcelFileDescriptor:close	()V
    //   148: goto +19 -> 167
    //   151: astore 4
    //   153: aload_0
    //   154: aload 4
    //   156: invokevirtual 123	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   159: goto +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 89	android/os/ParcelFileDescriptor:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_0
    //   170: aconst_null
    //   171: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   0	172	1	paramUri	android.net.Uri
    //   56	7	2	l	long
    //   13	131	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   151	12	4	localThrowable1	java.lang.Throwable
    //   44	55	5	localFileInputStream	java.io.FileInputStream
    //   106	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   46	67	84	finally
    //   46	67	90	java/lang/Throwable
    //   91	93	93	finally
    //   98	103	106	java/lang/Throwable
    //   32	46	124	finally
    //   67	72	124	finally
    //   98	103	124	finally
    //   108	114	124	finally
    //   117	122	124	finally
    //   122	124	124	finally
    //   32	46	130	java/lang/Throwable
    //   67	72	130	java/lang/Throwable
    //   108	114	130	java/lang/Throwable
    //   117	122	130	java/lang/Throwable
    //   122	124	130	java/lang/Throwable
    //   131	133	133	finally
    //   143	148	151	java/lang/Throwable
    //   5	15	169	java/io/IOException
    //   25	30	169	java/io/IOException
    //   77	82	169	java/io/IOException
    //   143	148	169	java/io/IOException
    //   153	159	169	java/io/IOException
    //   162	167	169	java/io/IOException
    //   167	169	169	java/io/IOException
  }
  
  /* Error */
  private static ByteBuffer a(File paramFile)
  {
    // Byte code:
    //   0: new 91	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 102	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 108	java/nio/channels/FileChannel:size	()J
    //   20: lstore_1
    //   21: aload_0
    //   22: getstatic 114	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   25: lconst_0
    //   26: lload_1
    //   27: invokevirtual 118	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   30: astore_0
    //   31: aload 4
    //   33: invokevirtual 119	java/io/FileInputStream:close	()V
    //   36: aload_0
    //   37: areturn
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_0
    //   41: goto +7 -> 48
    //   44: astore_0
    //   45: aload_0
    //   46: athrow
    //   47: astore_3
    //   48: aload_0
    //   49: ifnull +22 -> 71
    //   52: aload 4
    //   54: invokevirtual 119	java/io/FileInputStream:close	()V
    //   57: goto +19 -> 76
    //   60: astore 4
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 123	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   68: goto +8 -> 76
    //   71: aload 4
    //   73: invokevirtual 119	java/io/FileInputStream:close	()V
    //   76: aload_3
    //   77: athrow
    //   78: astore_0
    //   79: aconst_null
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramFile	File
    //   20	7	1	l	long
    //   38	1	3	localObject1	Object
    //   47	30	3	localObject2	Object
    //   8	45	4	localFileInputStream	java.io.FileInputStream
    //   60	12	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   10	31	38	finally
    //   10	31	44	java/lang/Throwable
    //   45	47	47	finally
    //   52	57	60	java/lang/Throwable
    //   0	10	78	java/io/IOException
    //   31	36	78	java/io/IOException
    //   52	57	78	java/io/IOException
    //   62	68	78	java/io/IOException
    //   71	76	78	java/io/IOException
    //   76	78	78	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
    return;
  }
  
  /* Error */
  public static boolean a(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 136	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 139	com/tencent/token/df:a	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   11: istore_3
    //   12: aload_1
    //   13: invokestatic 141	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   16: iload_3
    //   17: ireturn
    //   18: astore_0
    //   19: goto +6 -> 25
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 141	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   29: aload_0
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	paramFile	File
    //   0	31	1	paramResources	Resources
    //   0	31	2	paramInt	int
    //   11	6	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	12	18	finally
    //   0	6	22	finally
  }
  
  /* Error */
  public static boolean a(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 143	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: astore_0
    //   15: sipush 1024
    //   18: newarray byte
    //   20: astore_3
    //   21: aload_1
    //   22: aload_3
    //   23: invokevirtual 152	java/io/InputStream:read	([B)I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmpeq +13 -> 42
    //   32: aload_0
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_2
    //   36: invokevirtual 156	java/io/FileOutputStream:write	([BII)V
    //   39: goto -18 -> 21
    //   42: aload_0
    //   43: invokestatic 141	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_1
    //   49: aload_0
    //   50: astore_3
    //   51: aload_1
    //   52: astore_0
    //   53: goto +40 -> 93
    //   56: astore_1
    //   57: goto +11 -> 68
    //   60: astore_0
    //   61: goto +32 -> 93
    //   64: astore_1
    //   65: aload 4
    //   67: astore_0
    //   68: aload_0
    //   69: astore_3
    //   70: new 10	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 158
    //   76: invokespecial 16	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: invokestatic 141	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_3
    //   94: invokestatic 141	com/tencent/token/df:a	(Ljava/io/Closeable;)V
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramFile	File
    //   0	99	1	paramInputStream	java.io.InputStream
    //   26	10	2	i	int
    //   4	90	3	localObject1	Object
    //   1	65	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	48	finally
    //   21	27	48	finally
    //   32	39	48	finally
    //   15	21	56	java/io/IOException
    //   21	27	56	java/io/IOException
    //   32	39	56	java/io/IOException
    //   5	15	60	finally
    //   70	87	60	finally
    //   5	15	64	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.df
 * JD-Core Version:    0.7.0.1
 */