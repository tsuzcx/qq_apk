package moai.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.system.Os;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;

public final class Files
{
  public static final String CACHE_URL = Environment.getExternalStorageDirectory() + "/tencent/weread/cache";
  public static final int FILE_COPY_ERROR_NOPERMISSION = -2;
  public static final int FILE_COPY_ERROR_NORMAL = -1;
  public static final int FILE_COPY_SUCCESS = 0;
  public static final String FILE_TYPE_BMP = "bmp";
  public static final String FILE_TYPE_EXE = "exe";
  public static final String FILE_TYPE_GIF = "gif";
  public static final String FILE_TYPE_ICO = "ico";
  public static final String FILE_TYPE_JPEG = "jpeg";
  public static final String FILE_TYPE_JPG = "jpg";
  public static final String FILE_TYPE_MIDI = "midi";
  public static final String FILE_TYPE_PNG = "png";
  public static final String FILE_TYPE_RAR = "rar";
  public static final String FILE_TYPE_UNKNOWN = "unknown";
  public static final String FILE_TYPE_ZIP = "zip";
  private static final String[] IMG_SUFFIX = { "png", "gif", "jpg", "jpeg", "bmp", "ico" };
  public static final String STORAGE_ROOT = "/storage";
  private static final char WINDOWS_SEPARATOR = '\\';
  
  public static boolean IsImageSufix(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < IMG_SUFFIX.length)
      {
        if (IMG_SUFFIX[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static boolean appendFile(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 105	java/io/FileOutputStream
    //   5: dup
    //   6: aload_2
    //   7: iconst_1
    //   8: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: iconst_0
    //   15: iload_1
    //   16: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   19: aload_2
    //   20: ifnull +7 -> 27
    //   23: aload_2
    //   24: invokevirtual 117	java/io/OutputStream:close	()V
    //   27: iconst_0
    //   28: ireturn
    //   29: astore_0
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull -6 -> 27
    //   36: aload_2
    //   37: invokevirtual 117	java/io/OutputStream:close	()V
    //   40: iconst_0
    //   41: ireturn
    //   42: astore_0
    //   43: iconst_0
    //   44: ireturn
    //   45: astore_0
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 117	java/io/OutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_2
    //   62: goto -6 -> 56
    //   65: astore_0
    //   66: goto -18 -> 48
    //   69: astore_0
    //   70: goto -38 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramArrayOfByte	byte[]
    //   0	73	1	paramInt	int
    //   0	73	2	paramString	String
    //   1	46	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	29	java/lang/Exception
    //   36	40	42	java/io/IOException
    //   2	12	45	finally
    //   23	27	58	java/io/IOException
    //   52	56	61	java/io/IOException
    //   12	19	65	finally
    //   12	19	69	java/lang/Exception
  }
  
  public static void cleanDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDelete(localFile);
        label126:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label126;
      }
    }
  }
  
  public static void clearFileContent(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new FileOutputStream(paramString, false);
        if (paramString == null) {}
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      finally
      {
        if (0 == 0) {
          break label61;
        }
      }
      try
      {
        paramString.close();
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    try
    {
      throw new NullPointerException();
      label61:
      throw paramString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static boolean compressBitmapToFile(android.graphics.Bitmap paramBitmap, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 105	java/io/FileOutputStream
    //   6: dup
    //   7: aload_3
    //   8: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_0
    //   13: aload_1
    //   14: iload_2
    //   15: aload_3
    //   16: invokevirtual 167	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   19: pop
    //   20: aload_3
    //   21: ifnull +7 -> 28
    //   24: aload_3
    //   25: invokevirtual 117	java/io/OutputStream:close	()V
    //   28: iconst_0
    //   29: ireturn
    //   30: astore_0
    //   31: aconst_null
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull -6 -> 28
    //   37: aload_3
    //   38: invokevirtual 117	java/io/OutputStream:close	()V
    //   41: goto -13 -> 28
    //   44: astore_0
    //   45: goto -17 -> 28
    //   48: astore_0
    //   49: aload 4
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 117	java/io/OutputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: astore_0
    //   63: goto -35 -> 28
    //   66: astore_1
    //   67: goto -7 -> 60
    //   70: astore_0
    //   71: goto -19 -> 52
    //   74: astore_0
    //   75: goto -42 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBitmap	android.graphics.Bitmap
    //   0	78	1	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	78	2	paramInt	int
    //   0	78	3	paramString	String
    //   1	49	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	30	java/lang/Exception
    //   37	41	44	java/io/IOException
    //   3	12	48	finally
    //   24	28	62	java/io/IOException
    //   56	60	66	java/io/IOException
    //   12	20	70	finally
    //   12	20	74	java/lang/Exception
  }
  
  /* Error */
  public static int copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: ifnull +7 -> 19
    //   15: aload_1
    //   16: ifnonnull +7 -> 23
    //   19: iconst_m1
    //   20: istore_2
    //   21: iload_2
    //   22: ireturn
    //   23: iload_3
    //   24: istore_2
    //   25: aload_0
    //   26: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: aload_1
    //   30: invokevirtual 175	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   33: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifne -15 -> 21
    //   39: new 177	java/io/BufferedInputStream
    //   42: dup
    //   43: new 179	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 184	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_0
    //   55: new 186	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 105	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: iconst_0
    //   65: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   68: invokespecial 192	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore 6
    //   73: sipush 1024
    //   76: newarray byte
    //   78: astore_1
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 196	java/io/BufferedInputStream:read	([B)I
    //   84: istore_2
    //   85: iload_2
    //   86: iconst_m1
    //   87: if_icmpeq +76 -> 163
    //   90: aload 6
    //   92: aload_1
    //   93: iconst_0
    //   94: iload_2
    //   95: invokevirtual 197	java/io/BufferedOutputStream:write	([BII)V
    //   98: goto -19 -> 79
    //   101: astore_1
    //   102: aload_0
    //   103: astore 5
    //   105: aload 6
    //   107: astore_0
    //   108: aload_1
    //   109: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: ldc 202
    //   116: invokevirtual 206	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   119: ifne +16 -> 135
    //   122: aload_1
    //   123: ldc 208
    //   125: invokevirtual 206	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   128: istore 4
    //   130: iload 4
    //   132: ifeq +56 -> 188
    //   135: bipush 254
    //   137: istore_2
    //   138: aload 5
    //   140: ifnull +8 -> 148
    //   143: aload 5
    //   145: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   148: aload_0
    //   149: ifnull -128 -> 21
    //   152: aload_0
    //   153: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   156: bipush 254
    //   158: ireturn
    //   159: astore_0
    //   160: bipush 254
    //   162: ireturn
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   171: iload_3
    //   172: istore_2
    //   173: aload 6
    //   175: ifnull -154 -> 21
    //   178: aload 6
    //   180: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_0
    //   186: iconst_0
    //   187: ireturn
    //   188: aload 5
    //   190: ifnull +8 -> 198
    //   193: aload 5
    //   195: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   206: iconst_m1
    //   207: ireturn
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_0
    //   211: aload 5
    //   213: astore_1
    //   214: aload_0
    //   215: ifnull +7 -> 222
    //   218: aload_0
    //   219: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_0
    //   235: aload 7
    //   237: astore 5
    //   239: aload 5
    //   241: ifnull +8 -> 249
    //   244: aload 5
    //   246: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   257: aload_1
    //   258: athrow
    //   259: astore_0
    //   260: goto -89 -> 171
    //   263: astore_1
    //   264: goto -116 -> 148
    //   267: astore_1
    //   268: goto -70 -> 198
    //   271: astore_0
    //   272: goto -66 -> 206
    //   275: astore_0
    //   276: goto -54 -> 222
    //   279: astore_0
    //   280: goto -50 -> 230
    //   283: astore 5
    //   285: goto -36 -> 249
    //   288: astore_0
    //   289: goto -32 -> 257
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 6
    //   296: aload_0
    //   297: astore 5
    //   299: aload 6
    //   301: astore_0
    //   302: goto -63 -> 239
    //   305: astore_1
    //   306: aload_0
    //   307: astore 5
    //   309: aload 6
    //   311: astore_0
    //   312: goto -73 -> 239
    //   315: astore_1
    //   316: goto -77 -> 239
    //   319: astore_1
    //   320: aload 5
    //   322: astore_1
    //   323: goto -109 -> 214
    //   326: astore_1
    //   327: aload 6
    //   329: astore_1
    //   330: goto -116 -> 214
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: aload 6
    //   338: astore 5
    //   340: goto -232 -> 108
    //   343: astore_1
    //   344: aconst_null
    //   345: astore 6
    //   347: aload_0
    //   348: astore 5
    //   350: aload 6
    //   352: astore_0
    //   353: goto -245 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramFile1	File
    //   0	356	1	paramFile2	File
    //   20	153	2	i	int
    //   10	162	3	j	int
    //   128	3	4	bool	boolean
    //   1	244	5	localObject1	Object
    //   283	1	5	localIOException	IOException
    //   297	52	5	localObject2	Object
    //   7	344	6	localBufferedOutputStream	BufferedOutputStream
    //   4	232	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   73	79	101	java/io/IOException
    //   79	85	101	java/io/IOException
    //   90	98	101	java/io/IOException
    //   152	156	159	java/io/IOException
    //   178	183	185	java/io/IOException
    //   39	55	208	java/lang/Exception
    //   39	55	232	finally
    //   167	171	259	java/io/IOException
    //   143	148	263	java/io/IOException
    //   193	198	267	java/io/IOException
    //   202	206	271	java/io/IOException
    //   218	222	275	java/io/IOException
    //   226	230	279	java/io/IOException
    //   244	249	283	java/io/IOException
    //   253	257	288	java/io/IOException
    //   55	73	292	finally
    //   73	79	305	finally
    //   79	85	305	finally
    //   90	98	305	finally
    //   108	130	315	finally
    //   55	73	319	java/lang/Exception
    //   73	79	326	java/lang/Exception
    //   79	85	326	java/lang/Exception
    //   90	98	326	java/lang/Exception
    //   39	55	333	java/io/IOException
    //   55	73	343	java/io/IOException
  }
  
  public static void delAllFile(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return;
      } while (!localFile.isDirectory());
      arrayOfString = localFile.list();
    } while (arrayOfString == null);
    int j = arrayOfString.length;
    int i = 0;
    label41:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if (!paramString.endsWith(File.separator)) {
        break label169;
      }
    }
    label169:
    for (localFile = new File(paramString + str);; localFile = new File(paramString + File.separator + str))
    {
      if (localFile.isFile()) {
        localFile.delete();
      }
      if (localFile.isDirectory())
      {
        delAllFile(paramString + "/" + str);
        delFolder(paramString + "/" + str);
      }
      i += 1;
      break label41;
      break;
    }
  }
  
  public static void delFile(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        delFile((String)paramArrayList.next());
      }
    }
  }
  
  public static void delFile(File[] paramArrayOfFile)
  {
    if ((paramArrayOfFile == null) || (paramArrayOfFile.length == 0)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delFile(paramArrayOfFile[i].getAbsolutePath());
        i += 1;
      }
    }
  }
  
  public static boolean delFile(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return true;
    }
    return paramString.delete();
  }
  
  public static void delFolder(String paramString)
  {
    delAllFile(paramString);
    new File(paramString).delete();
  }
  
  public static void deleteDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      if (!isSymlink(paramFile)) {
        cleanDirectory(paramFile);
      }
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        cleanDirectory(paramFile);
      }
      try
      {
        label17:
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public static void forceDelete(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static long getDirectorySize(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (!"".equals(paramString)) {
        break label25;
      }
      l2 = l1;
    }
    label25:
    int i;
    do
    {
      do
      {
        do
        {
          return l2;
          paramString = new File(paramString);
          l2 = l1;
        } while (!paramString.isDirectory());
        paramString = paramString.listFiles();
        l2 = l1;
      } while (paramString == null);
      i = 0;
      l2 = l1;
    } while (i >= paramString.length);
    l2 = l1;
    if (paramString[i] != null) {
      if (!paramString[i].isDirectory()) {
        break label108;
      }
    }
    label108:
    for (l2 = l1 + getDirectorySize(paramString[i].getAbsolutePath());; l2 = l1 + getFileSize(paramString[i].getAbsolutePath()))
    {
      i += 1;
      l1 = l2;
      break;
    }
  }
  
  @TargetApi(8)
  public static File getExternalCacheDir(Context paramContext)
  {
    Object localObject1 = null;
    if ((Build.VERSION.SDK_INT >= 8) && (paramContext.getExternalCacheDir() != null)) {
      paramContext = paramContext.getExternalCacheDir();
    }
    Object localObject2;
    do
    {
      do
      {
        return paramContext;
        localObject2 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + paramContext.getPackageName();
        paramContext = localObject1;
      } while (!mkdirs(new File((String)localObject2)));
      localObject2 = new File((String)localObject2 + "/cache/");
      paramContext = localObject1;
    } while (!mkdirs((File)localObject2));
    return localObject2;
  }
  
  public static String getFileNameSufix(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return getSuffix(paramString);
  }
  
  public static long getFileSize(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    do
    {
      return 0L;
      paramString = new File(paramString);
    } while (paramString.isDirectory());
    return paramString.length();
  }
  
  /* Error */
  public static String getFileTypeWithContent(String paramString)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: astore 4
    //   5: new 179	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: iconst_2
    //   17: newarray byte
    //   19: astore 6
    //   21: ldc_w 263
    //   24: astore 5
    //   26: aload 4
    //   28: astore_0
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: aload 6
    //   34: invokevirtual 329	java/io/FileInputStream:read	([B)I
    //   37: iconst_m1
    //   38: if_icmpeq +137 -> 175
    //   41: iconst_0
    //   42: istore_1
    //   43: aload 5
    //   45: astore_0
    //   46: aload_3
    //   47: astore_2
    //   48: iload_1
    //   49: aload 6
    //   51: arraylength
    //   52: if_icmpge +41 -> 93
    //   55: aload_3
    //   56: astore_2
    //   57: new 58	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   64: aload_0
    //   65: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 6
    //   70: iload_1
    //   71: baload
    //   72: sipush 255
    //   75: iand
    //   76: invokestatic 334	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   79: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_0
    //   86: iload_1
    //   87: iconst_1
    //   88: iadd
    //   89: istore_1
    //   90: goto -44 -> 46
    //   93: aload_3
    //   94: astore_2
    //   95: aload_0
    //   96: invokestatic 338	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: lookupswitch	default:+189->288, 6677:+222->321, 7173:+216->315, 7784:+192->291, 7790:+93->192, 8075:+204->303, 8297:+198->297, 13780:+99->198, 255216:+210->309
    //   173: aload_1
    //   174: astore_0
    //   175: aload_0
    //   176: astore 4
    //   178: aload_3
    //   179: ifnull +10 -> 189
    //   182: aload_3
    //   183: invokevirtual 339	java/io/FileInputStream:close	()V
    //   186: aload_0
    //   187: astore 4
    //   189: aload 4
    //   191: areturn
    //   192: ldc 19
    //   194: astore_0
    //   195: goto -20 -> 175
    //   198: ldc 37
    //   200: astore_0
    //   201: goto -26 -> 175
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_3
    //   207: aload_3
    //   208: astore_2
    //   209: aload_0
    //   210: invokevirtual 155	java/io/FileNotFoundException:printStackTrace	()V
    //   213: aload_3
    //   214: ifnull -25 -> 189
    //   217: aload_3
    //   218: invokevirtual 339	java/io/FileInputStream:close	()V
    //   221: ldc_w 263
    //   224: areturn
    //   225: astore_0
    //   226: ldc_w 263
    //   229: areturn
    //   230: astore_0
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_3
    //   234: astore_2
    //   235: aload_0
    //   236: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   239: aload_3
    //   240: ifnull -51 -> 189
    //   243: aload_3
    //   244: invokevirtual 339	java/io/FileInputStream:close	()V
    //   247: ldc_w 263
    //   250: areturn
    //   251: astore_0
    //   252: ldc_w 263
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_2
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 339	java/io/FileInputStream:close	()V
    //   267: aload_0
    //   268: athrow
    //   269: astore_2
    //   270: aload_0
    //   271: areturn
    //   272: astore_2
    //   273: goto -6 -> 267
    //   276: astore_0
    //   277: goto -18 -> 259
    //   280: astore_0
    //   281: goto -48 -> 233
    //   284: astore_0
    //   285: goto -78 -> 207
    //   288: goto -116 -> 172
    //   291: ldc 34
    //   293: astore_0
    //   294: goto -119 -> 175
    //   297: ldc 40
    //   299: astore_0
    //   300: goto -125 -> 175
    //   303: ldc 46
    //   305: astore_0
    //   306: goto -131 -> 175
    //   309: ldc 31
    //   311: astore_0
    //   312: goto -137 -> 175
    //   315: ldc 22
    //   317: astore_0
    //   318: goto -143 -> 175
    //   321: ldc 16
    //   323: astore_0
    //   324: goto -149 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramString	String
    //   42	48	1	i	int
    //   15	249	2	localFileInputStream1	java.io.FileInputStream
    //   269	1	2	localIOException1	IOException
    //   272	1	2	localIOException2	IOException
    //   13	231	3	localFileInputStream2	java.io.FileInputStream
    //   3	187	4	str1	String
    //   24	20	5	str2	String
    //   19	50	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	14	204	java/io/FileNotFoundException
    //   217	221	225	java/io/IOException
    //   5	14	230	java/io/IOException
    //   243	247	251	java/io/IOException
    //   5	14	256	finally
    //   182	186	269	java/io/IOException
    //   263	267	272	java/io/IOException
    //   16	21	276	finally
    //   31	41	276	finally
    //   48	55	276	finally
    //   57	86	276	finally
    //   95	172	276	finally
    //   209	213	276	finally
    //   235	239	276	finally
    //   16	21	280	java/io/IOException
    //   31	41	280	java/io/IOException
    //   48	55	280	java/io/IOException
    //   57	86	280	java/io/IOException
    //   95	172	280	java/io/IOException
    //   16	21	284	java/io/FileNotFoundException
    //   31	41	284	java/io/FileNotFoundException
    //   48	55	284	java/io/FileNotFoundException
    //   57	86	284	java/io/FileNotFoundException
    //   95	172	284	java/io/FileNotFoundException
  }
  
  public static String getName(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.substring(paramString.lastIndexOf(File.separator) + 1);
  }
  
  public static String getSuffix(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return "";
      i = paramString.lastIndexOf('.');
    } while (i <= 0);
    return paramString.substring(i + 1);
  }
  
  public static boolean isFileDir(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return false;
    }
    return new File(paramString).isDirectory();
  }
  
  public static boolean isFileExist(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }
  
  public static boolean isFileExist(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean isSymlink(File paramFile)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("File must not be null");
    }
    if (File.separatorChar == '\\') {
      return false;
    }
    if (paramFile.getParent() == null) {
      if (paramFile.getCanonicalFile().equals(paramFile.getAbsoluteFile())) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
      break;
    }
  }
  
  @TargetApi(21)
  public static List<String> lsof()
  {
    Object localObject = com.google.common.io.Files.fileTreeTraverser().breadthFirstTraversal(new File("/proc/self/fd")).filter(new Files.1());
    ArrayList localArrayList = new ArrayList(((FluentIterable)localObject).size());
    localObject = ((FluentIterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      File localFile = (File)((Iterator)localObject).next();
      try
      {
        localArrayList.add(Os.readlink(localFile.toString()));
      }
      catch (Exception localException) {}
    }
    return localArrayList;
  }
  
  /* Error */
  public static boolean mkdirs(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 125	java/io/File:exists	()Z
    //   7: ifeq +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 135	java/io/File:isDirectory	()Z
    //   14: ifne +19 -> 33
    //   17: aload_0
    //   18: invokevirtual 417	java/io/File:mkdirs	()Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +10 -> 33
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_1
    //   34: istore_1
    //   35: goto -7 -> 28
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramFile	File
    //   21	14	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	38	finally
    //   17	22	38	finally
  }
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 179	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 328	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: sipush 4096
    //   14: newarray byte
    //   16: astore_2
    //   17: new 421	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 422	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore 4
    //   26: aload_0
    //   27: aload_2
    //   28: invokevirtual 425	java/io/InputStream:read	([B)I
    //   31: istore_1
    //   32: iload_1
    //   33: ifle +29 -> 62
    //   36: aload 4
    //   38: aload_2
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 426	java/io/ByteArrayOutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: astore_2
    //   48: aload_3
    //   49: astore_2
    //   50: aload_0
    //   51: ifnull +9 -> 60
    //   54: aload_0
    //   55: invokevirtual 427	java/io/InputStream:close	()V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_2
    //   61: areturn
    //   62: aload 4
    //   64: invokevirtual 431	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: astore_2
    //   68: aload_2
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: aload_0
    //   73: ifnull -13 -> 60
    //   76: aload_0
    //   77: invokevirtual 427	java/io/InputStream:close	()V
    //   80: aload_3
    //   81: areturn
    //   82: astore_0
    //   83: aload_3
    //   84: areturn
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 427	java/io/InputStream:close	()V
    //   96: aload_2
    //   97: athrow
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: goto -6 -> 96
    //   105: astore_2
    //   106: goto -18 -> 88
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_0
    //   112: goto -64 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramString	String
    //   31	10	1	i	int
    //   16	23	2	arrayOfByte	byte[]
    //   47	1	2	localIOException	IOException
    //   49	23	2	localObject1	Object
    //   85	12	2	localObject2	Object
    //   105	1	2	localObject3	Object
    //   1	83	3	localObject4	Object
    //   24	39	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   11	26	47	java/io/IOException
    //   26	32	47	java/io/IOException
    //   36	44	47	java/io/IOException
    //   62	68	47	java/io/IOException
    //   76	80	82	java/io/IOException
    //   2	11	85	finally
    //   54	58	98	java/io/IOException
    //   92	96	101	java/io/IOException
    //   11	26	105	finally
    //   26	32	105	finally
    //   36	44	105	finally
    //   62	68	105	finally
    //   2	11	109	java/io/IOException
  }
  
  /* Error */
  public static String readFileByLine(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 58	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: new 435	java/io/FileReader
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 436	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: new 438	java/io/BufferedReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 441	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 444	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +40 -> 76
    //   39: aload_3
    //   40: aload 4
    //   42: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: invokestatic 449	com/google/common/base/Strings:isNullOrEmpty	(Ljava/lang/String;)Z
    //   50: ifne -22 -> 28
    //   53: aload_3
    //   54: aload_1
    //   55: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -31 -> 28
    //   62: astore_1
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 450	java/io/FileReader:close	()V
    //   71: aload_3
    //   72: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: areturn
    //   76: aload_0
    //   77: ifnull -6 -> 71
    //   80: aload_0
    //   81: invokevirtual 450	java/io/FileReader:close	()V
    //   84: goto -13 -> 71
    //   87: astore_0
    //   88: goto -17 -> 71
    //   91: astore_0
    //   92: aload_2
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 450	java/io/FileReader:close	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_0
    //   105: goto -34 -> 71
    //   108: astore_1
    //   109: goto -7 -> 102
    //   112: astore_2
    //   113: aload_0
    //   114: astore_1
    //   115: aload_2
    //   116: astore_0
    //   117: goto -23 -> 94
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -60 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramString1	String
    //   0	126	1	paramString2	String
    //   1	92	2	localBufferedReader	java.io.BufferedReader
    //   112	4	2	localObject	Object
    //   9	63	3	localStringBuilder	StringBuilder
    //   32	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   19	28	62	java/lang/Exception
    //   28	34	62	java/lang/Exception
    //   39	59	62	java/lang/Exception
    //   80	84	87	java/io/IOException
    //   10	19	91	finally
    //   67	71	104	java/io/IOException
    //   98	102	108	java/io/IOException
    //   19	28	112	finally
    //   28	34	112	finally
    //   39	59	112	finally
    //   10	19	120	java/lang/Exception
  }
  
  /* Error */
  public static String readFileByLine(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 58	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: new 435	java/io/FileReader
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 436	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: new 438	java/io/BufferedReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 441	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 444	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +39 -> 75
    //   39: aload_3
    //   40: aload 4
    //   42: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: iload_1
    //   47: ifeq -19 -> 28
    //   50: aload_3
    //   51: ldc_w 453
    //   54: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -30 -> 28
    //   61: astore_2
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 450	java/io/FileReader:close	()V
    //   70: aload_3
    //   71: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: areturn
    //   75: aload_0
    //   76: ifnull -6 -> 70
    //   79: aload_0
    //   80: invokevirtual 450	java/io/FileReader:close	()V
    //   83: goto -13 -> 70
    //   86: astore_0
    //   87: goto -17 -> 70
    //   90: astore_0
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 450	java/io/FileReader:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: goto -32 -> 70
    //   105: astore_2
    //   106: goto -7 -> 99
    //   109: astore_3
    //   110: aload_0
    //   111: astore_2
    //   112: aload_3
    //   113: astore_0
    //   114: goto -23 -> 91
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_0
    //   120: goto -58 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   0	123	1	paramBoolean	boolean
    //   1	28	2	localBufferedReader	java.io.BufferedReader
    //   61	35	2	localException	Exception
    //   105	1	2	localIOException	IOException
    //   111	1	2	str1	String
    //   9	62	3	localStringBuilder	StringBuilder
    //   109	4	3	localObject	Object
    //   32	9	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   19	28	61	java/lang/Exception
    //   28	34	61	java/lang/Exception
    //   39	46	61	java/lang/Exception
    //   50	58	61	java/lang/Exception
    //   79	83	86	java/io/IOException
    //   10	19	90	finally
    //   66	70	101	java/io/IOException
    //   95	99	105	java/io/IOException
    //   19	28	109	finally
    //   28	34	109	finally
    //   39	46	109	finally
    //   50	58	109	finally
    //   10	19	117	java/lang/Exception
  }
  
  /* Error */
  public static List<String> readFileByLine(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 239	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 455	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: new 435	java/io/FileReader
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 436	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: new 438	java/io/BufferedReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 441	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 444	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +23 -> 57
    //   37: aload_2
    //   38: aload_3
    //   39: invokevirtual 456	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: goto -15 -> 28
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull +7 -> 55
    //   51: aload_0
    //   52: invokevirtual 450	java/io/FileReader:close	()V
    //   55: aload_2
    //   56: areturn
    //   57: aload_0
    //   58: ifnull -3 -> 55
    //   61: aload_0
    //   62: invokevirtual 450	java/io/FileReader:close	()V
    //   65: aload_2
    //   66: areturn
    //   67: astore_0
    //   68: aload_2
    //   69: areturn
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 450	java/io/FileReader:close	()V
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: goto -6 -> 79
    //   88: astore_2
    //   89: aload_0
    //   90: astore_1
    //   91: aload_2
    //   92: astore_0
    //   93: goto -22 -> 71
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_0
    //   99: goto -52 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramString	String
    //   1	28	1	localBufferedReader	java.io.BufferedReader
    //   46	30	1	localException	Exception
    //   84	1	1	localIOException	IOException
    //   90	1	1	str1	String
    //   9	74	2	localArrayList	ArrayList
    //   88	4	2	localObject	Object
    //   32	7	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   19	28	46	java/lang/Exception
    //   28	33	46	java/lang/Exception
    //   37	43	46	java/lang/Exception
    //   61	65	67	java/io/IOException
    //   10	19	70	finally
    //   51	55	81	java/io/IOException
    //   75	79	84	java/io/IOException
    //   19	28	88	finally
    //   28	33	88	finally
    //   37	43	88	finally
    //   10	19	96	java/lang/Exception
  }
  
  public static String readFileList(Iterable<File> paramIterable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      File localFile = (File)paramIterable.next();
      if (isFileExist(localFile)) {
        localStringBuilder.append(readFileByLine(localFile.getAbsolutePath(), true));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String renameAndAutoSequence(String paramString1, String paramString2)
  {
    int k = 1;
    String str3 = paramString1.replaceFirst("/*$", "/");
    String str1;
    if ((paramString2 == null) || (paramString2.equals(""))) {
      str1 = "";
    }
    String[] arrayOfString;
    do
    {
      do
      {
        return str1;
        arrayOfString = paramString2.split("\\.");
        str1 = paramString2;
      } while (arrayOfString == null);
      str1 = paramString2;
    } while (arrayOfString.length <= 0);
    paramString1 = arrayOfString[0];
    String str4 = arrayOfString[(arrayOfString.length - 1)];
    int j;
    String str2;
    if (arrayOfString.length > 2)
    {
      int i = 1;
      str1 = paramString1;
      for (;;)
      {
        j = k;
        str2 = str1;
        paramString1 = paramString2;
        if (i >= arrayOfString.length - 1) {
          break;
        }
        str1 = str1 + "." + arrayOfString[i];
        i += 1;
      }
    }
    for (;;)
    {
      str1 = paramString1;
      if (!new File(str3 + paramString1).exists()) {
        break;
      }
      paramString1 = str2 + "(" + j + ")" + "." + str4;
      j += 1;
      continue;
      j = k;
      str2 = paramString1;
      paramString1 = paramString2;
    }
  }
  
  public static File renameFile(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1);
      paramString1 = new File(paramString2);
      paramString2.printStackTrace();
    }
    catch (Exception paramString2)
    {
      try
      {
        localFile.renameTo(paramString1);
        return paramString1;
      }
      catch (Exception paramString2)
      {
        break label29;
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    label29:
    return paramString1;
  }
  
  public static String stripAnchorPath(String paramString)
  {
    String str = paramString;
    if (paramString.contains("/storage")) {
      str = paramString.substring(paramString.indexOf("/storage"));
    }
    return str;
  }
  
  public static String trimFileNameSufix(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    int i;
    do
    {
      String str;
      do
      {
        return localObject;
        str = "";
        localObject = str;
      } while (paramString.equals(""));
      i = paramString.lastIndexOf('.');
      localObject = str;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  /* Error */
  public static boolean truncateFileToSize(File paramFile, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new 58	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 274
    //   23: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: new 504	java/util/Date
    //   29: dup
    //   30: invokespecial 505	java/util/Date:<init>	()V
    //   33: invokevirtual 508	java/util/Date:getTime	()J
    //   36: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 4
    //   44: new 121	java/io/File
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 5
    //   55: aload_0
    //   56: aload 5
    //   58: invokevirtual 491	java/io/File:renameTo	(Ljava/io/File;)Z
    //   61: ifeq -57 -> 4
    //   64: new 179	java/io/FileInputStream
    //   67: dup
    //   68: aload 5
    //   70: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore 4
    //   75: aload 4
    //   77: lconst_0
    //   78: aload 5
    //   80: invokevirtual 326	java/io/File:length	()J
    //   83: lload_1
    //   84: lsub
    //   85: invokestatic 517	java/lang/Math:max	(JJ)J
    //   88: invokevirtual 521	java/io/FileInputStream:skip	(J)J
    //   91: lconst_0
    //   92: lcmp
    //   93: ifle +126 -> 219
    //   96: sipush 8192
    //   99: newarray byte
    //   101: astore 6
    //   103: aload 6
    //   105: iconst_0
    //   106: invokestatic 527	java/util/Arrays:fill	([BB)V
    //   109: new 186	java/io/BufferedOutputStream
    //   112: dup
    //   113: new 105	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   122: invokespecial 192	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   125: astore_0
    //   126: aload 4
    //   128: aload 6
    //   130: invokevirtual 329	java/io/FileInputStream:read	([B)I
    //   133: istore_3
    //   134: iload_3
    //   135: ifle +64 -> 199
    //   138: aload_0
    //   139: aload 6
    //   141: iconst_0
    //   142: iload_3
    //   143: invokevirtual 197	java/io/BufferedOutputStream:write	([BII)V
    //   146: goto -20 -> 126
    //   149: astore 5
    //   151: aload_0
    //   152: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   155: aload 5
    //   157: athrow
    //   158: astore_0
    //   159: aload 4
    //   161: invokevirtual 339	java/io/FileInputStream:close	()V
    //   164: aload_0
    //   165: athrow
    //   166: astore_0
    //   167: ldc_w 529
    //   170: new 58	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 531
    //   180: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: invokevirtual 532	java/io/IOException:toString	()Ljava/lang/String;
    //   187: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 538	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   196: pop
    //   197: iconst_0
    //   198: ireturn
    //   199: aload_0
    //   200: bipush 10
    //   202: invokevirtual 540	java/io/BufferedOutputStream:write	(I)V
    //   205: aload_0
    //   206: invokevirtual 543	java/io/BufferedOutputStream:flush	()V
    //   209: aload_0
    //   210: invokevirtual 210	java/io/BufferedOutputStream:close	()V
    //   213: aload 5
    //   215: invokevirtual 228	java/io/File:delete	()Z
    //   218: pop
    //   219: aload 4
    //   221: invokevirtual 339	java/io/FileInputStream:close	()V
    //   224: iconst_1
    //   225: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramFile	File
    //   0	226	1	paramLong	long
    //   133	10	3	i	int
    //   42	178	4	localObject1	Object
    //   53	26	5	localFile	File
    //   149	65	5	localObject2	Object
    //   101	39	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   126	134	149	finally
    //   138	146	149	finally
    //   199	209	149	finally
    //   75	126	158	finally
    //   151	158	158	finally
    //   209	219	158	finally
    //   44	75	166	java/io/IOException
    //   159	166	166	java/io/IOException
    //   219	224	166	java/io/IOException
  }
  
  /* Error */
  public static boolean tryMkdirs(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 125	java/io/File:exists	()Z
    //   7: ifeq +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 135	java/io/File:isDirectory	()Z
    //   14: ifne +30 -> 44
    //   17: ldc_w 545
    //   20: aload_0
    //   21: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   24: invokestatic 548	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   27: pop
    //   28: aload_0
    //   29: invokevirtual 417	java/io/File:mkdirs	()Z
    //   32: istore_1
    //   33: iload_1
    //   34: ifne +10 -> 44
    //   37: iconst_0
    //   38: istore_1
    //   39: ldc 2
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: iconst_1
    //   45: istore_1
    //   46: goto -7 -> 39
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramFile	File
    //   32	14	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	49	finally
    //   17	33	49	finally
  }
  
  public static void writeFile(String paramString, Buffer paramBuffer)
    throws IOException
  {
    paramString = Okio.buffer(Okio.sink(new BufferedOutputStream(new FileOutputStream(paramString, false))));
    paramString.writeAll(paramBuffer);
    paramString.close();
  }
  
  public static void writeFile(String paramString, Buffer paramBuffer, boolean paramBoolean)
    throws IOException
  {
    paramString = Okio.buffer(Okio.sink(new BufferedOutputStream(new FileOutputStream(paramString, paramBoolean))));
    paramString.writeAll(paramBuffer);
    paramString.close();
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 105	java/io/FileOutputStream
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: aload_0
    //   13: iconst_0
    //   14: iload_1
    //   15: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   18: aload_2
    //   19: ifnull +7 -> 26
    //   22: aload_2
    //   23: invokevirtual 117	java/io/OutputStream:close	()V
    //   26: iconst_0
    //   27: ireturn
    //   28: astore_0
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -6 -> 26
    //   35: aload_2
    //   36: invokevirtual 117	java/io/OutputStream:close	()V
    //   39: iconst_0
    //   40: ireturn
    //   41: astore_0
    //   42: iconst_0
    //   43: ireturn
    //   44: astore_0
    //   45: aload_3
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokevirtual 117	java/io/OutputStream:close	()V
    //   55: aload_0
    //   56: athrow
    //   57: astore_0
    //   58: iconst_0
    //   59: ireturn
    //   60: astore_2
    //   61: goto -6 -> 55
    //   64: astore_0
    //   65: goto -18 -> 47
    //   68: astore_0
    //   69: goto -38 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramArrayOfByte	byte[]
    //   0	72	1	paramInt	int
    //   0	72	2	paramString	String
    //   1	45	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	28	java/lang/Exception
    //   35	39	41	java/io/IOException
    //   2	11	44	finally
    //   22	26	57	java/io/IOException
    //   51	55	60	java/io/IOException
    //   11	18	64	finally
    //   11	18	68	java/lang/Exception
  }
  
  public static long writePartialFile(byte[] paramArrayOfByte, int paramInt, String paramString, long paramLong)
  {
    try
    {
      paramString = new RandomAccessFile(paramString, "rwd");
      paramString.seek(paramLong);
      paramString.write(paramArrayOfByte, 0, paramInt);
      paramString.close();
      return paramLong + paramInt;
    }
    catch (Exception paramArrayOfByte) {}
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.Files
 * JD-Core Version:    0.7.0.1
 */