package tmsdkdual;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

public class l
{
  private static final char[] ac = "0123456789abcdef".toCharArray();
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 3);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append(ac[(k >> 4)]);
      localStringBuilder.append(ac[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject = null;
    File localFile = paramContext.getDir("lib", 0);
    if (localFile.exists())
    {
      localFile = new File(localFile.getAbsolutePath() + File.separator, "lib" + paramString + ".so");
      m.b("CommonUtils", "[Spec] file: " + localFile.getAbsolutePath());
      if (localFile.exists()) {
        try
        {
          System.load(localFile.getAbsolutePath());
          return true;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
    m.b("CommonUtils", "loadLibrary [normal] loading ... ");
    if (0 == 0) {}
    String str2;
    int i;
    try
    {
      str2 = paramContext.getCacheDir().toString();
      localObject = str2;
      if (str2.endsWith("/") == true) {
        localObject = str2.substring(0, str2.length() - 2);
      }
      i = ((String)localObject).lastIndexOf('/');
      if (i == -1) {
        break label487;
      }
      localObject = ((String)localObject).substring(0, i);
      localObject = (String)localObject + "/lib/";
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        label487:
        str1 = "/data/data/" + paramContext.getPackageName() + "/lib/";
      }
    }
    if (((String)localObject).length() != 0) {
      if (!new File((String)localObject + paramString).exists()) {
        break label574;
      }
    }
    for (;;)
    {
      try
      {
        System.load((String)localObject + paramString);
        i = 1;
      }
      catch (Throwable paramContext)
      {
        i = 0;
        continue;
      }
      if ((i == 0) && (!paramString.endsWith(".so")))
      {
        str2 = paramString + ".so";
        j = i;
        paramContext = str2;
        if (new File((String)localObject + str2).exists()) {}
        try
        {
          System.load((String)localObject + str2);
          j = 1;
          paramContext = str2;
        }
        catch (Throwable paramContext)
        {
          j = i;
          paramContext = str2;
          continue;
          i = j;
          continue;
        }
        if ((j == 0) && (!paramContext.startsWith("lib")))
        {
          paramContext = "lib" + paramContext;
          if (new File((String)localObject + paramContext).exists())
          {
            try
            {
              System.load((String)localObject + paramContext);
              i = 1;
            }
            catch (Throwable paramContext)
            {
              i = j;
              continue;
            }
            if (i == 0) {}
            try
            {
              System.loadLibrary(paramString);
              return true;
            }
            catch (Throwable paramContext)
            {
              return false;
            }
            localObject = "";
            break;
            try
            {
              String str1;
              System.loadLibrary(paramString);
            }
            catch (Throwable paramContext)
            {
              return false;
            }
          }
        }
      }
      paramContext = paramString;
      int j = i;
      continue;
      label574:
      i = 0;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, RSAPublicKey paramRSAPublicKey)
  {
    Object localObject = null;
    if (paramRSAPublicKey != null) {}
    try
    {
      localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      ((Cipher)localObject).init(2, paramRSAPublicKey);
      localObject = ((Cipher)localObject).doFinal(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(c(paramArrayOfByte));
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static RSAPublicKey d(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (RSAPublicKey)X509Certificate.getInstance(paramArrayOfByte).getPublicKey();
      return paramArrayOfByte;
    }
    catch (CertificateException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String e(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 204	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: invokevirtual 208	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 214	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   17: astore_1
    //   18: new 216	java/io/InputStreamReader
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 219	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: astore_3
    //   27: new 221	java/io/BufferedReader
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_0
    //   36: aload_1
    //   37: astore 4
    //   39: aload_3
    //   40: astore 5
    //   42: aload_0
    //   43: astore 6
    //   45: new 23	java/lang/StringBuilder
    //   48: dup
    //   49: ldc 128
    //   51: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: astore 8
    //   56: aload_1
    //   57: astore 4
    //   59: aload_3
    //   60: astore 5
    //   62: aload_0
    //   63: astore 6
    //   65: aload_0
    //   66: invokevirtual 228	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore 9
    //   71: aload 9
    //   73: ifnull +86 -> 159
    //   76: aload_1
    //   77: astore 4
    //   79: aload_3
    //   80: astore 5
    //   82: aload_0
    //   83: astore 6
    //   85: aload 8
    //   87: aload 9
    //   89: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: astore 4
    //   96: aload_3
    //   97: astore 5
    //   99: aload_0
    //   100: astore 6
    //   102: aload 8
    //   104: bipush 10
    //   106: invokevirtual 31	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: goto -54 -> 56
    //   113: astore_2
    //   114: aload_1
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: aload_0
    //   121: astore 6
    //   123: aload_2
    //   124: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 231	java/io/BufferedReader:close	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   143: aload 7
    //   145: astore_0
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokevirtual 235	java/io/InputStream:close	()V
    //   154: aload 7
    //   156: astore_0
    //   157: aload_0
    //   158: areturn
    //   159: aload_1
    //   160: astore 4
    //   162: aload_3
    //   163: astore 5
    //   165: aload_0
    //   166: astore 6
    //   168: aload_2
    //   169: invokevirtual 238	java/lang/Process:waitFor	()I
    //   172: ifeq +39 -> 211
    //   175: aload_1
    //   176: astore 4
    //   178: aload_3
    //   179: astore 5
    //   181: aload_0
    //   182: astore 6
    //   184: ldc 74
    //   186: new 23	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   193: ldc 240
    //   195: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_2
    //   199: invokevirtual 243	java/lang/Process:exitValue	()I
    //   202: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 82	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   211: aload_1
    //   212: astore 4
    //   214: aload_3
    //   215: astore 5
    //   217: aload_0
    //   218: astore 6
    //   220: aload 8
    //   222: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_2
    //   226: aload_0
    //   227: ifnull +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 231	java/io/BufferedReader:close	()V
    //   234: aload_3
    //   235: ifnull +7 -> 242
    //   238: aload_3
    //   239: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   242: aload_2
    //   243: astore_0
    //   244: aload_1
    //   245: ifnull -88 -> 157
    //   248: aload_1
    //   249: invokevirtual 235	java/io/InputStream:close	()V
    //   252: aload_2
    //   253: areturn
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   259: aload_2
    //   260: areturn
    //   261: astore_2
    //   262: aload_1
    //   263: astore 4
    //   265: aload_3
    //   266: astore 5
    //   268: aload_0
    //   269: astore 6
    //   271: ldc 74
    //   273: aload_2
    //   274: invokestatic 249	tmsdkdual/m:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   277: goto -66 -> 211
    //   280: astore_0
    //   281: aload 6
    //   283: astore_2
    //   284: aload 5
    //   286: astore_1
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 231	java/io/BufferedReader:close	()V
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   303: aload 4
    //   305: ifnull +8 -> 313
    //   308: aload 4
    //   310: invokevirtual 235	java/io/InputStream:close	()V
    //   313: aload_0
    //   314: athrow
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   320: goto -86 -> 234
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   328: goto -86 -> 242
    //   331: astore_0
    //   332: aload_0
    //   333: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   336: goto -201 -> 135
    //   339: astore_0
    //   340: aload_0
    //   341: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   344: goto -201 -> 143
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_2
    //   355: aload_2
    //   356: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   359: goto -64 -> 295
    //   362: astore_1
    //   363: aload_1
    //   364: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   367: goto -64 -> 303
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   375: goto -62 -> 313
    //   378: astore_0
    //   379: aconst_null
    //   380: astore 4
    //   382: aconst_null
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_2
    //   386: goto -99 -> 287
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_3
    //   392: aconst_null
    //   393: astore_2
    //   394: aload_1
    //   395: astore 4
    //   397: aload_3
    //   398: astore_1
    //   399: goto -112 -> 287
    //   402: astore_0
    //   403: aconst_null
    //   404: astore_2
    //   405: aload_1
    //   406: astore 4
    //   408: aload_3
    //   409: astore_1
    //   410: goto -123 -> 287
    //   413: astore_2
    //   414: aconst_null
    //   415: astore_1
    //   416: aconst_null
    //   417: astore_3
    //   418: aconst_null
    //   419: astore_0
    //   420: goto -306 -> 114
    //   423: astore_2
    //   424: aconst_null
    //   425: astore_3
    //   426: aconst_null
    //   427: astore_0
    //   428: goto -314 -> 114
    //   431: astore_2
    //   432: aconst_null
    //   433: astore_0
    //   434: goto -320 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramString	String
    //   6	294	1	localObject1	Object
    //   362	2	1	localIOException1	java.io.IOException
    //   370	2	1	localIOException2	java.io.IOException
    //   383	33	1	localObject2	Object
    //   12	2	2	localProcess	java.lang.Process
    //   113	86	2	localException1	Exception
    //   225	35	2	str1	String
    //   261	13	2	localInterruptedException	java.lang.InterruptedException
    //   283	9	2	localObject3	Object
    //   354	2	2	localIOException3	java.io.IOException
    //   385	20	2	localObject4	Object
    //   413	1	2	localException2	Exception
    //   423	1	2	localException3	Exception
    //   431	1	2	localException4	Exception
    //   26	400	3	localInputStreamReader1	java.io.InputStreamReader
    //   37	370	4	localObject5	Object
    //   40	245	5	localInputStreamReader2	java.io.InputStreamReader
    //   43	239	6	str2	String
    //   1	154	7	localObject6	Object
    //   54	167	8	localStringBuilder	StringBuilder
    //   69	19	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   45	56	113	java/lang/Exception
    //   65	71	113	java/lang/Exception
    //   85	93	113	java/lang/Exception
    //   102	110	113	java/lang/Exception
    //   168	175	113	java/lang/Exception
    //   184	211	113	java/lang/Exception
    //   220	226	113	java/lang/Exception
    //   271	277	113	java/lang/Exception
    //   248	252	254	java/io/IOException
    //   168	175	261	java/lang/InterruptedException
    //   184	211	261	java/lang/InterruptedException
    //   45	56	280	finally
    //   65	71	280	finally
    //   85	93	280	finally
    //   102	110	280	finally
    //   123	127	280	finally
    //   168	175	280	finally
    //   184	211	280	finally
    //   220	226	280	finally
    //   271	277	280	finally
    //   230	234	315	java/io/IOException
    //   238	242	323	java/io/IOException
    //   131	135	331	java/io/IOException
    //   139	143	339	java/io/IOException
    //   150	154	347	java/io/IOException
    //   291	295	354	java/io/IOException
    //   299	303	362	java/io/IOException
    //   308	313	370	java/io/IOException
    //   7	18	378	finally
    //   18	27	389	finally
    //   27	36	402	finally
    //   7	18	413	java/lang/Exception
    //   18	27	423	java/lang/Exception
    //   27	36	431	java/lang/Exception
  }
  
  public static String r()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String s()
  {
    return Build.MODEL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.l
 * JD-Core Version:    0.7.0.1
 */