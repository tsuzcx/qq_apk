package com.tencent.base.os;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.base.Global;
import com.tencent.base.os.info.StorageDash;
import com.tencent.base.util.DataUtils;
import com.tencent.base.util.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Native
{
  private static final String DEFAULT_ASSETS_SO_DIR_NAME = "lib/armeabi";
  private static final String DEFAULT_LIB_DIR_NAME = "qzlib";
  private static final String PREFENCE_NAME = "guarder";
  private static final String TAG = "LibraryLoader";
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return new String(arrayOfChar);
      }
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = digits[(j & 0xF)];
      i += 1;
    }
  }
  
  private static boolean copyAssetLib(String paramString1, String paramString2, String paramString3)
    throws Throwable
  {
    for (;;)
    {
      Object localObject1;
      boolean bool;
      Object localObject2;
      Object localObject4;
      try
      {
        localObject1 = Global.getContext();
        if ((localObject1 == null) || (paramString2 == null))
        {
          bool = false;
          return bool;
        }
        if (paramString3 != null)
        {
          localObject2 = paramString3;
          if (paramString3.trim().length() != 0) {}
        }
        else
        {
          localObject2 = ((Context)localObject1).getFilesDir().getAbsolutePath();
        }
        paramString3 = new File((String)localObject2);
        localObject4 = null;
        paramString3.mkdirs();
        paramString3 = null;
        Object localObject3 = null;
      }
      finally {}
      try
      {
        localObject1 = ((Context)localObject1).getAssets().open(paramString2);
        paramString3 = (String)localObject1;
        paramString1 = new File((String)localObject2, paramString1);
      }
      catch (Throwable paramString1)
      {
        localObject2 = localThrowable;
        paramString2 = localObject4;
        continue;
      }
      try
      {
        if (paramString1.exists()) {
          delete(paramString1);
        }
        paramString1.createNewFile();
        localObject2 = new FileOutputStream(paramString1);
        try
        {
          paramString2 = new byte[4096];
          if (((InputStream)localObject1).available() <= 0)
          {
            ((FileOutputStream)localObject2).close();
            ((InputStream)localObject1).close();
            bool = true;
          }
          else
          {
            int i = ((InputStream)localObject1).read(paramString2);
            if (i > 0)
            {
              ((FileOutputStream)localObject2).write(paramString2, 0, i);
              continue;
              DataUtils.closeDataObject(localObject2);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          paramString2 = paramString1;
          paramString3 = (String)localObject1;
          paramString1 = localThrowable;
        }
      }
      catch (Throwable paramString3)
      {
        paramString2 = paramString1;
        paramString1 = paramString3;
        paramString3 = (String)localObject1;
        localObject2 = localThrowable;
      }
    }
    DataUtils.closeDataObject(paramString3);
    delete(paramString2);
    throw paramString1;
  }
  
  private static void copySoFile(String paramString)
    throws Native.NativeException
  {
    String str = getAssetsPath(paramString);
    try
    {
      copyAssetLib(paramString, str, getLibDir().getAbsolutePath());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new NativeException("copy file:" + paramString + " failed!", localThrowable);
    }
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    File[] arrayOfFile;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (paramBoolean) {
          break;
        }
        paramFile.delete();
        return;
      }
      delete(arrayOfFile[i], paramBoolean);
      i += 1;
    }
  }
  
  private static boolean downloadNativeLibs()
  {
    if (StorageDash.hasExternal()) {}
    for (File localFile = new File(Environment.getExternalStorageDirectory(), "Tencent" + File.separator + "wns");; localFile = Global.getCacheDir())
    {
      localFile = new File(localFile, "wns_network_lib.zip");
      if (localFile.exists()) {
        localFile.delete();
      }
      if (Http.isSuccess(Http.download("http://d3g.qq.com/sngapp/qzone/client/20140228110117_2650/qzone_so_for_4_0_new.zip", localFile))) {
        break;
      }
      return false;
    }
    boolean bool = FileUtils.unzip(localFile, getLibDir());
    if (localFile.exists()) {
      localFile.delete();
    }
    return bool;
  }
  
  /* Error */
  public static String encrypt(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 235	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   4: astore_1
    //   5: sipush 1024
    //   8: newarray byte
    //   10: astore_3
    //   11: aload_0
    //   12: aload_3
    //   13: invokevirtual 129	java/io/InputStream:read	([B)I
    //   16: istore_2
    //   17: iload_2
    //   18: ifgt +18 -> 36
    //   21: aload_1
    //   22: invokevirtual 239	java/security/MessageDigest:digest	()[B
    //   25: invokestatic 241	com/tencent/base/os/Native:bytes2HexStr	([B)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_0
    //   30: invokestatic 139	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_1
    //   35: areturn
    //   36: aload_1
    //   37: aload_3
    //   38: iconst_0
    //   39: iload_2
    //   40: invokevirtual 244	java/security/MessageDigest:update	([BII)V
    //   43: goto -32 -> 11
    //   46: astore_1
    //   47: aload_0
    //   48: invokestatic 139	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   51: pop
    //   52: aconst_null
    //   53: areturn
    //   54: astore_1
    //   55: aload_0
    //   56: invokestatic 139	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aconst_null
    //   61: areturn
    //   62: astore_1
    //   63: aload_0
    //   64: invokestatic 139	com/tencent/base/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramInputStream	InputStream
    //   0	70	1	paramString	String
    //   16	24	2	i	int
    //   10	28	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	11	46	java/io/IOException
    //   11	17	46	java/io/IOException
    //   21	29	46	java/io/IOException
    //   36	43	46	java/io/IOException
    //   0	11	54	java/security/NoSuchAlgorithmException
    //   11	17	54	java/security/NoSuchAlgorithmException
    //   21	29	54	java/security/NoSuchAlgorithmException
    //   36	43	54	java/security/NoSuchAlgorithmException
    //   0	11	62	finally
    //   11	17	62	finally
    //   21	29	62	finally
    //   36	43	62	finally
  }
  
  public static void forceCopySoFile(String paramString, String... paramVarArgs)
    throws Native.NativeException
  {
    int j;
    int i;
    if (paramVarArgs != null)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return;
      }
      String str = paramVarArgs[i];
      copySoFile(str);
      setCopiedInSpecifiedVersion(paramString, str, true);
      i += 1;
    }
  }
  
  private static String getAssetsPath(String paramString)
  {
    return "lib/armeabi" + File.separator + paramString;
  }
  
  private static String getCopiedKey(String paramString1, String paramString2)
  {
    return "check_" + paramString1 + "_" + paramString2;
  }
  
  private static String getDefaultVersionName()
  {
    try
    {
      String str = Global.getPackageManager().getPackageInfo(Global.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException) {}
    return String.valueOf(System.currentTimeMillis());
  }
  
  private static String getFileMd5(InputStream paramInputStream)
  {
    return encrypt(paramInputStream, "MD5");
  }
  
  private static String getInstallPath()
  {
    File localFile2 = Global.getFilesDir();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = Global.getCacheDir();
    }
    if (localFile1 != null) {
      return localFile1.getParent();
    }
    return "/data/data/" + Global.getPackageName();
  }
  
  public static File getLibDir()
  {
    return new File(getInstallPath() + File.separator + "qzlib");
  }
  
  private static boolean hasCopiedInSpecifiedVersion(String paramString1, String paramString2)
  {
    return Global.getSharedPreferences("guarder", 0).getBoolean(getCopiedKey(paramString1, paramString2), false);
  }
  
  private static boolean isFileInAssetsPath(String paramString)
  {
    try
    {
      String[] arrayOfString = Global.getContext().getAssets().list("lib/armeabi");
      if (arrayOfString == null) {
        return false;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString.equalsIgnoreCase(arrayOfString[i]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  private static boolean isSameLength(String paramString)
  {
    // Byte code:
    //   0: new 79	java/io/File
    //   3: dup
    //   4: new 79	java/io/File
    //   7: dup
    //   8: invokestatic 148	com/tencent/base/os/Native:getLibDir	()Ljava/io/File;
    //   11: aload_0
    //   12: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 10
    //   23: invokestatic 337	com/tencent/base/Global:getAssets	()Landroid/content/res/AssetManager;
    //   26: astore 11
    //   28: aload_0
    //   29: invokestatic 145	com/tencent/base/os/Native:getAssetsPath	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_0
    //   33: iconst_0
    //   34: istore_2
    //   35: iconst_0
    //   36: istore 5
    //   38: iconst_0
    //   39: istore_3
    //   40: iload 5
    //   42: istore 4
    //   44: aload 11
    //   46: aload_0
    //   47: invokevirtual 341	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   50: astore 12
    //   52: aload 12
    //   54: ifnonnull +5 -> 59
    //   57: iconst_1
    //   58: ireturn
    //   59: iload 5
    //   61: istore 4
    //   63: aload 10
    //   65: invokevirtual 343	java/io/File:length	()J
    //   68: lstore 6
    //   70: iload 5
    //   72: istore 4
    //   74: aload 12
    //   76: invokevirtual 348	android/content/res/AssetFileDescriptor:getLength	()J
    //   79: lstore 8
    //   81: iload_2
    //   82: istore_1
    //   83: lload 6
    //   85: lload 8
    //   87: lcmp
    //   88: ifne +7 -> 95
    //   91: iconst_1
    //   92: istore_3
    //   93: iload_2
    //   94: istore_1
    //   95: iload_3
    //   96: istore 4
    //   98: iload_1
    //   99: ifeq +78 -> 177
    //   102: iload_3
    //   103: istore 4
    //   105: aload 11
    //   107: aload_0
    //   108: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   111: astore_0
    //   112: aload 10
    //   114: invokevirtual 343	java/io/File:length	()J
    //   117: lstore 6
    //   119: aload_0
    //   120: invokevirtual 121	java/io/InputStream:available	()I
    //   123: istore_1
    //   124: lload 6
    //   126: iload_1
    //   127: i2l
    //   128: lcmp
    //   129: ifne +5 -> 134
    //   132: iconst_1
    //   133: istore_3
    //   134: iload_3
    //   135: istore 4
    //   137: aload_0
    //   138: invokevirtual 125	java/io/InputStream:close	()V
    //   141: iload_3
    //   142: istore 4
    //   144: goto +33 -> 177
    //   147: astore 10
    //   149: iload_3
    //   150: istore 4
    //   152: aload_0
    //   153: invokevirtual 125	java/io/InputStream:close	()V
    //   156: iload_3
    //   157: istore 4
    //   159: goto +18 -> 177
    //   162: astore 10
    //   164: iload_3
    //   165: istore 4
    //   167: aload_0
    //   168: invokevirtual 125	java/io/InputStream:close	()V
    //   171: iload_3
    //   172: istore 4
    //   174: aload 10
    //   176: athrow
    //   177: iload 4
    //   179: ireturn
    //   180: astore_0
    //   181: iconst_1
    //   182: ireturn
    //   183: astore 12
    //   185: iconst_1
    //   186: istore_1
    //   187: goto -92 -> 95
    //   190: astore_0
    //   191: goto -14 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramString	String
    //   82	105	1	i	int
    //   34	60	2	j	int
    //   39	133	3	bool1	boolean
    //   42	136	4	bool2	boolean
    //   36	35	5	bool3	boolean
    //   68	57	6	l1	long
    //   79	7	8	l2	long
    //   21	92	10	localFile	File
    //   147	1	10	localIOException1	IOException
    //   162	13	10	localObject	Object
    //   26	80	11	localAssetManager	AssetManager
    //   50	25	12	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   183	1	12	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   112	124	147	java/io/IOException
    //   112	124	162	finally
    //   44	52	180	java/io/FileNotFoundException
    //   63	70	180	java/io/FileNotFoundException
    //   74	81	180	java/io/FileNotFoundException
    //   44	52	183	java/io/IOException
    //   63	70	183	java/io/IOException
    //   74	81	183	java/io/IOException
    //   44	52	190	java/lang/Exception
    //   63	70	190	java/lang/Exception
    //   74	81	190	java/lang/Exception
    //   105	112	190	java/lang/Exception
    //   137	141	190	java/lang/Exception
    //   152	156	190	java/lang/Exception
    //   167	171	190	java/lang/Exception
    //   174	177	190	java/lang/Exception
  }
  
  private static boolean isSameMd5(String paramString)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    bool1 = bool3;
    bool2 = bool4;
    try
    {
      String str = getFileMd5(Global.getAssets().open(getAssetsPath(paramString)));
      bool1 = bool3;
      bool2 = bool4;
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      bool1 = bool3;
      bool2 = bool4;
      bool3 = str.equals(getFileMd5(new FileInputStream(new File(getLibDir(), paramString))));
      bool1 = bool3;
      bool2 = bool3;
      new StringBuilder().append(getLibDir()).append(File.separator).append(paramString).toString();
      bool1 = bool3;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  /* Error */
  public static boolean loadLibrary(String paramString)
  {
    // Byte code:
    //   0: new 152	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 375
    //   7: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 377
    //   17: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore 4
    //   25: new 79	java/io/File
    //   28: dup
    //   29: invokestatic 148	com/tencent/base/os/Native:getLibDir	()Ljava/io/File;
    //   32: aload 4
    //   34: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_0
    //   39: invokestatic 379	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   42: iconst_1
    //   43: ireturn
    //   44: astore_0
    //   45: aload_3
    //   46: invokevirtual 105	java/io/File:exists	()Z
    //   49: ifeq +14 -> 63
    //   52: invokestatic 381	com/tencent/base/os/Native:getDefaultVersionName	()Ljava/lang/String;
    //   55: aload 4
    //   57: invokestatic 383	com/tencent/base/os/Native:hasCopiedInSpecifiedVersion	(Ljava/lang/String;Ljava/lang/String;)Z
    //   60: ifne +26 -> 86
    //   63: aload 4
    //   65: invokestatic 385	com/tencent/base/os/Native:isFileInAssetsPath	(Ljava/lang/String;)Z
    //   68: ifne +105 -> 173
    //   71: invokestatic 387	com/tencent/base/os/Native:downloadNativeLibs	()Z
    //   74: ifeq +97 -> 171
    //   77: invokestatic 381	com/tencent/base/os/Native:getDefaultVersionName	()Ljava/lang/String;
    //   80: aload 4
    //   82: iconst_1
    //   83: invokestatic 252	com/tencent/base/os/Native:setCopiedInSpecifiedVersion	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   86: aload_3
    //   87: invokevirtual 105	java/io/File:exists	()Z
    //   90: ifeq +13 -> 103
    //   93: aload_3
    //   94: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: invokestatic 390	java/lang/System:load	(Ljava/lang/String;)V
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_0
    //   103: iconst_0
    //   104: istore_2
    //   105: iload_2
    //   106: istore_1
    //   107: aload 4
    //   109: invokestatic 385	com/tencent/base/os/Native:isFileInAssetsPath	(Ljava/lang/String;)Z
    //   112: ifeq +12 -> 124
    //   115: aload_3
    //   116: invokevirtual 105	java/io/File:exists	()Z
    //   119: ifne +76 -> 195
    //   122: iconst_1
    //   123: istore_1
    //   124: iload_1
    //   125: ifne +18 -> 143
    //   128: invokestatic 387	com/tencent/base/os/Native:downloadNativeLibs	()Z
    //   131: ifeq +92 -> 223
    //   134: invokestatic 381	com/tencent/base/os/Native:getDefaultVersionName	()Ljava/lang/String;
    //   137: aload 4
    //   139: iconst_1
    //   140: invokestatic 252	com/tencent/base/os/Native:setCopiedInSpecifiedVersion	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   143: iload_1
    //   144: ifeq +18 -> 162
    //   147: invokestatic 381	com/tencent/base/os/Native:getDefaultVersionName	()Ljava/lang/String;
    //   150: iconst_1
    //   151: anewarray 50	java/lang/String
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: aastore
    //   159: invokestatic 392	com/tencent/base/os/Native:forceCopySoFile	(Ljava/lang/String;[Ljava/lang/String;)V
    //   162: aload_3
    //   163: invokevirtual 105	java/io/File:exists	()Z
    //   166: ifne +59 -> 225
    //   169: iconst_0
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: invokestatic 381	com/tencent/base/os/Native:getDefaultVersionName	()Ljava/lang/String;
    //   176: iconst_1
    //   177: anewarray 50	java/lang/String
    //   180: dup
    //   181: iconst_0
    //   182: aload 4
    //   184: aastore
    //   185: invokestatic 392	com/tencent/base/os/Native:forceCopySoFile	(Ljava/lang/String;[Ljava/lang/String;)V
    //   188: goto -102 -> 86
    //   191: astore_0
    //   192: goto -106 -> 86
    //   195: aload 4
    //   197: invokestatic 394	com/tencent/base/os/Native:isSameLength	(Ljava/lang/String;)Z
    //   200: ifne +8 -> 208
    //   203: iconst_1
    //   204: istore_1
    //   205: goto -81 -> 124
    //   208: iload_2
    //   209: istore_1
    //   210: aload 4
    //   212: invokestatic 396	com/tencent/base/os/Native:isSameMd5	(Ljava/lang/String;)Z
    //   215: ifne -91 -> 124
    //   218: iconst_1
    //   219: istore_1
    //   220: goto -96 -> 124
    //   223: iconst_0
    //   224: ireturn
    //   225: aload_3
    //   226: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   229: invokestatic 390	java/lang/System:load	(Ljava/lang/String;)V
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_0
    //   235: iconst_0
    //   236: ireturn
    //   237: astore_0
    //   238: goto -193 -> 45
    //   241: astore_0
    //   242: goto -197 -> 45
    //   245: astore_0
    //   246: goto -11 -> 235
    //   249: astore_0
    //   250: goto -15 -> 235
    //   253: astore_0
    //   254: goto -92 -> 162
    //   257: astore_0
    //   258: goto -96 -> 162
    //   261: astore_0
    //   262: goto -159 -> 103
    //   265: astore_0
    //   266: goto -163 -> 103
    //   269: astore_0
    //   270: goto -184 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramString	String
    //   106	114	1	i	int
    //   104	105	2	j	int
    //   37	189	3	localFile	File
    //   23	188	4	str	String
    // Exception table:
    //   from	to	target	type
    //   38	42	44	java/lang/UnsatisfiedLinkError
    //   93	100	102	java/lang/UnsatisfiedLinkError
    //   173	188	191	com/tencent/base/os/Native$NativeException
    //   225	232	234	java/lang/UnsatisfiedLinkError
    //   38	42	237	java/lang/Exception
    //   38	42	241	java/lang/Error
    //   225	232	245	java/lang/Error
    //   225	232	249	java/lang/Exception
    //   147	162	253	java/lang/Exception
    //   147	162	257	com/tencent/base/os/Native$NativeException
    //   93	100	261	java/lang/Error
    //   93	100	265	java/lang/Exception
    //   173	188	269	java/lang/Exception
  }
  
  private static void setCopiedInSpecifiedVersion(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = Global.getSharedPreferences("guarder", 0);
    paramString1 = getCopiedKey(paramString1, paramString2);
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static class NativeException
    extends RuntimeException
  {
    private static final long serialVersionUID = 411247780482311098L;
    
    public NativeException() {}
    
    public NativeException(String paramString)
    {
      super();
    }
    
    public NativeException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.Native
 * JD-Core Version:    0.7.0.1
 */