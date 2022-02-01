package com.tencent.mobileqq.mini.utils;

import android.os.Build.VERSION;
import android.system.Os;
import android.system.StructStat;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class FileUtils
{
  private static final String TAG = "[mini] FileUtils";
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static JSONObject getStats(String paramString)
  {
    JSONObject localJSONObject;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramString = Os.stat(paramString);
        localJSONObject = new JSONObject();
        localJSONObject.put("mode", paramString.st_mode);
        localJSONObject.put("size", paramString.st_size);
        localJSONObject.put("lastAccessedTime", paramString.st_atime);
        localJSONObject.put("lastModifiedTime", paramString.st_mtime);
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] FileUtils", 1, "getStats error. " + paramString);
      }
    }
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        localJSONObject = new JSONObject();
        localJSONObject.put("mode", 0);
        localJSONObject.put("size", paramString.length());
        localJSONObject.put("lastAccessedTime", paramString.lastModified());
        localJSONObject.put("lastModifiedTime", paramString.lastModified());
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] FileUtils", 1, "getStats error. " + paramString);
      }
    }
  }
  
  public static JSONObject getStatsByDir(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("/", getStats(paramString));
      Object localObject = aqhq.getChildFiles(paramString, true);
      paramString = new File(paramString);
      paramString = paramString.getCanonicalPath() + "/";
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str.replace(paramString, ""), getStats(str));
      }
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("[mini] FileUtils", 1, "getStatsByDir error. " + paramString);
      return null;
    }
  }
  
  /* Error */
  public static String readFileFromAssets(String paramString)
  {
    // Byte code:
    //   0: invokestatic 183	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 189	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_0
    //   7: invokevirtual 195	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 199	java/io/InputStream:available	()I
    //   17: newarray byte
    //   19: astore_2
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 23	java/io/InputStream:read	([B)I
    //   27: pop
    //   28: aload_1
    //   29: astore_0
    //   30: new 167	java/lang/String
    //   33: dup
    //   34: aload_2
    //   35: ldc 201
    //   37: invokespecial 204	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 207	java/io/InputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore_0
    //   52: ldc 209
    //   54: iconst_1
    //   55: new 107	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   62: ldc 211
    //   64: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: ldc 209
    //   86: iconst_1
    //   87: new 107	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   94: ldc 213
    //   96: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 207	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: ldc 209
    //   122: iconst_1
    //   123: new 107	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   130: ldc 211
    //   132: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto -28 -> 117
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 207	java/io/InputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: ldc 209
    //   164: iconst_1
    //   165: new 107	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   172: ldc 211
    //   174: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: goto -28 -> 159
    //   190: astore_1
    //   191: goto -40 -> 151
    //   194: astore_2
    //   195: goto -113 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   10	104	1	localInputStream	InputStream
    //   148	12	1	localObject1	Object
    //   190	1	1	localObject2	Object
    //   19	59	2	localObject3	Object
    //   79	21	2	localException1	Exception
    //   194	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   0	11	79	java/lang/Exception
    //   113	117	119	java/io/IOException
    //   0	11	148	finally
    //   155	159	161	java/io/IOException
    //   13	20	190	finally
    //   22	28	190	finally
    //   30	41	190	finally
    //   84	109	190	finally
    //   13	20	194	java/lang/Exception
    //   22	28	194	java/lang/Exception
    //   30	41	194	java/lang/Exception
  }
  
  public static String readFileToStr(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = readFileToString(paramFile);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        QLog.e("[mini] FileUtils", 2, "readFileToStr", paramFile);
        return "";
      }
    }
    return null;
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 41	java/io/File:exists	()Z
    //   16: ifeq +81 -> 97
    //   19: aload_0
    //   20: invokevirtual 227	java/io/File:isDirectory	()Z
    //   23: ifeq +35 -> 58
    //   26: new 17	java/io/IOException
    //   29: dup
    //   30: new 107	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   37: ldc 229
    //   39: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc 231
    //   48: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 232	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   57: athrow
    //   58: aload_0
    //   59: invokevirtual 235	java/io/File:canRead	()Z
    //   62: ifne +67 -> 129
    //   65: new 17	java/io/IOException
    //   68: dup
    //   69: new 107	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   76: ldc 229
    //   78: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: ldc 237
    //   87: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 232	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   96: athrow
    //   97: new 239	java/io/FileNotFoundException
    //   100: dup
    //   101: new 107	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   108: ldc 229
    //   110: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc 241
    //   119: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokespecial 242	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: new 244	java/io/FileInputStream
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: new 249	java/io/InputStreamReader
    //   141: dup
    //   142: aload_3
    //   143: ldc 251
    //   145: invokespecial 254	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   148: astore_2
    //   149: aload_0
    //   150: invokevirtual 130	java/io/File:length	()J
    //   153: l2i
    //   154: istore_1
    //   155: iload_1
    //   156: sipush 12288
    //   159: if_icmple +100 -> 259
    //   162: sipush 4096
    //   165: newarray char
    //   167: astore_0
    //   168: new 107	java/lang/StringBuilder
    //   171: dup
    //   172: sipush 12288
    //   175: invokespecial 257	java/lang/StringBuilder:<init>	(I)V
    //   178: astore 5
    //   180: aload_2
    //   181: aload_0
    //   182: invokevirtual 260	java/io/InputStreamReader:read	([C)I
    //   185: istore_1
    //   186: iconst_m1
    //   187: iload_1
    //   188: if_icmpeq +42 -> 230
    //   191: aload 5
    //   193: aload_0
    //   194: iconst_0
    //   195: iload_1
    //   196: invokevirtual 263	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -20 -> 180
    //   203: astore_0
    //   204: aload_2
    //   205: astore_0
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 207	java/io/InputStream:close	()V
    //   214: aload 4
    //   216: astore_3
    //   217: aload_0
    //   218: ifnull -208 -> 10
    //   221: aload_0
    //   222: invokevirtual 264	java/io/InputStreamReader:close	()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: areturn
    //   230: aload 5
    //   232: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore_0
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 207	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: astore_3
    //   246: aload_2
    //   247: ifnull -237 -> 10
    //   250: aload_2
    //   251: invokevirtual 264	java/io/InputStreamReader:close	()V
    //   254: aload_0
    //   255: areturn
    //   256: astore_2
    //   257: aload_0
    //   258: areturn
    //   259: iload_1
    //   260: newarray char
    //   262: astore_0
    //   263: new 167	java/lang/String
    //   266: dup
    //   267: aload_0
    //   268: iconst_0
    //   269: aload_2
    //   270: aload_0
    //   271: invokevirtual 260	java/io/InputStreamReader:read	([C)I
    //   274: invokespecial 267	java/lang/String:<init>	([CII)V
    //   277: astore_0
    //   278: goto -42 -> 236
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aconst_null
    //   285: astore_2
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 207	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 264	java/io/InputStreamReader:close	()V
    //   302: aload_0
    //   303: athrow
    //   304: astore_3
    //   305: goto -61 -> 244
    //   308: astore_2
    //   309: goto -95 -> 214
    //   312: astore_3
    //   313: goto -19 -> 294
    //   316: astore_2
    //   317: goto -15 -> 302
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_2
    //   323: goto -37 -> 286
    //   326: astore_0
    //   327: goto -41 -> 286
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_3
    //   335: goto -129 -> 206
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -135 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramFile	File
    //   154	106	1	i	int
    //   148	103	2	localInputStreamReader	java.io.InputStreamReader
    //   256	14	2	localException1	Exception
    //   285	14	2	localObject1	Object
    //   308	1	2	localException2	Exception
    //   316	1	2	localException3	Exception
    //   322	1	2	localObject2	Object
    //   9	282	3	localObject3	Object
    //   304	1	3	localException4	Exception
    //   312	1	3	localException5	Exception
    //   334	1	3	localObject4	Object
    //   1	214	4	localObject5	Object
    //   178	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   149	155	203	java/lang/Exception
    //   162	180	203	java/lang/Exception
    //   180	186	203	java/lang/Exception
    //   191	200	203	java/lang/Exception
    //   230	236	203	java/lang/Exception
    //   259	278	203	java/lang/Exception
    //   221	225	227	java/lang/Exception
    //   250	254	256	java/lang/Exception
    //   129	138	281	finally
    //   240	244	304	java/lang/Exception
    //   210	214	308	java/lang/Exception
    //   290	294	312	java/lang/Exception
    //   298	302	316	java/lang/Exception
    //   138	149	320	finally
    //   149	155	326	finally
    //   162	180	326	finally
    //   180	186	326	finally
    //   191	200	326	finally
    //   230	236	326	finally
    //   259	278	326	finally
    //   129	138	330	java/lang/Exception
    //   138	149	338	java/lang/Exception
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label39:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label39;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */