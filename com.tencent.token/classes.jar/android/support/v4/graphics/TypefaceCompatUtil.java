package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatUtil
{
  private static final String CACHE_FILE_PREFIX = ".font";
  private static final String TAG = "TypefaceCompatUtil";
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  @Nullable
  @RequiresApi(19)
  public static ByteBuffer copyToDirectBuffer(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = getTempFile(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = copyToFile(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = mmap(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 59	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 62	android/support/v4/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   11: istore_3
    //   12: aload_1
    //   13: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   16: iload_3
    //   17: ireturn
    //   18: astore_0
    //   19: goto +6 -> 25
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
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
  public static boolean copyToFile(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 66	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: astore_0
    //   15: sipush 1024
    //   18: newarray byte
    //   20: astore_3
    //   21: aload_1
    //   22: aload_3
    //   23: invokevirtual 75	java/io/InputStream:read	([B)I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmpeq +13 -> 42
    //   32: aload_0
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_2
    //   36: invokevirtual 79	java/io/FileOutputStream:write	([BII)V
    //   39: goto -18 -> 21
    //   42: aload_0
    //   43: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_1
    //   49: aload_0
    //   50: astore_3
    //   51: aload_1
    //   52: astore_0
    //   53: goto +67 -> 120
    //   56: astore_1
    //   57: goto +11 -> 68
    //   60: astore_0
    //   61: goto +59 -> 120
    //   64: astore_1
    //   65: aload 4
    //   67: astore_0
    //   68: aload_0
    //   69: astore_3
    //   70: new 81	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   77: astore 4
    //   79: aload_0
    //   80: astore_3
    //   81: aload 4
    //   83: ldc 84
    //   85: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_0
    //   90: astore_3
    //   91: aload 4
    //   93: aload_1
    //   94: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_0
    //   102: astore_3
    //   103: ldc 15
    //   105: aload 4
    //   107: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 101	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: aload_0
    //   115: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_3
    //   121: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramFile	File
    //   0	126	1	paramInputStream	java.io.InputStream
    //   26	10	2	i	int
    //   4	117	3	localObject	Object
    //   1	105	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	21	48	finally
    //   21	27	48	finally
    //   32	39	48	finally
    //   15	21	56	java/io/IOException
    //   21	27	56	java/io/IOException
    //   32	39	56	java/io/IOException
    //   5	15	60	finally
    //   70	79	60	finally
    //   81	89	60	finally
    //   91	101	60	finally
    //   103	114	60	finally
    //   5	15	64	java/io/IOException
  }
  
  @Nullable
  public static File getTempFile(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(".font");
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
        label116:
        break label116;
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  public static ByteBuffer mmap(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc 136
    //   9: aload_1
    //   10: invokevirtual 142	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: aload_2
    //   19: ifnull +7 -> 26
    //   22: aload_2
    //   23: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: areturn
    //   28: new 147	java/io/FileInputStream
    //   31: dup
    //   32: aload_2
    //   33: invokevirtual 151	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   36: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 158	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 164	java/nio/channels/FileChannel:size	()J
    //   51: lstore_3
    //   52: aload_0
    //   53: getstatic 170	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   56: lconst_0
    //   57: lload_3
    //   58: invokevirtual 174	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   61: astore_0
    //   62: aload 5
    //   64: invokevirtual 175	java/io/FileInputStream:close	()V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: goto +7 -> 87
    //   83: astore_0
    //   84: aload_0
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull +22 -> 110
    //   91: aload 5
    //   93: invokevirtual 175	java/io/FileInputStream:close	()V
    //   96: goto +19 -> 115
    //   99: astore 5
    //   101: aload_0
    //   102: aload 5
    //   104: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   107: goto +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 175	java/io/FileInputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_1
    //   120: goto +7 -> 127
    //   123: astore_1
    //   124: aload_1
    //   125: athrow
    //   126: astore_0
    //   127: aload_2
    //   128: ifnull +27 -> 155
    //   131: aload_1
    //   132: ifnull +19 -> 151
    //   135: aload_2
    //   136: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   139: goto +16 -> 155
    //   142: astore_2
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: astore_0
    //   158: aconst_null
    //   159: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramContext	Context
    //   0	160	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	160	2	paramUri	android.net.Uri
    //   51	7	3	l	long
    //   39	53	5	localFileInputStream	java.io.FileInputStream
    //   99	12	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   41	62	77	finally
    //   41	62	83	java/lang/Throwable
    //   84	86	86	finally
    //   91	96	99	java/lang/Throwable
    //   28	41	117	finally
    //   62	67	117	finally
    //   91	96	117	finally
    //   101	107	117	finally
    //   110	115	117	finally
    //   115	117	117	finally
    //   28	41	123	java/lang/Throwable
    //   62	67	123	java/lang/Throwable
    //   101	107	123	java/lang/Throwable
    //   110	115	123	java/lang/Throwable
    //   115	117	123	java/lang/Throwable
    //   124	126	126	finally
    //   135	139	142	java/lang/Throwable
    //   5	14	157	java/io/IOException
    //   22	26	157	java/io/IOException
    //   71	75	157	java/io/IOException
    //   135	139	157	java/io/IOException
    //   143	148	157	java/io/IOException
    //   151	155	157	java/io/IOException
    //   155	157	157	java/io/IOException
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  private static ByteBuffer mmap(File paramFile)
  {
    // Byte code:
    //   0: new 147	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 158	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 164	java/nio/channels/FileChannel:size	()J
    //   20: lstore_1
    //   21: aload_0
    //   22: getstatic 170	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   25: lconst_0
    //   26: lload_1
    //   27: invokevirtual 174	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   30: astore_0
    //   31: aload 4
    //   33: invokevirtual 175	java/io/FileInputStream:close	()V
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
    //   54: invokevirtual 175	java/io/FileInputStream:close	()V
    //   57: goto +19 -> 76
    //   60: astore 4
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   68: goto +8 -> 76
    //   71: aload 4
    //   73: invokevirtual 175	java/io/FileInputStream:close	()V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatUtil
 * JD-Core Version:    0.7.0.1
 */