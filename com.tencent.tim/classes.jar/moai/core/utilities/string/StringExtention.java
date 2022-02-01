package moai.core.utilities.string;

import alkw;
import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.log.MLog;
import moai.log.MLogManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class StringExtention
{
  public static final String BR = "<br\\s*/?>";
  public static final String CONTENT_HTML_NEWLINE = "<br/><br/>";
  public static final String CONTENT_PLAIN_NEWLINE = "\n\n";
  public static final String EMPTYSPACE = " ";
  public static final String HTML_EMPTYSPACE = "&nbsp;";
  public static final String HTML_NEWLINE = "<br/>";
  public static final String MESSAGE_DIGEST_TYPE_MD5 = "MD5";
  public static final String MESSAGE_DIGEST_TYPE_SHA1 = "SHA-1";
  public static final String PLAIN_EMPTYSPACE = " ";
  public static final String PLAIN_NEWLINE = "\n";
  private static final String TAG;
  public static final String UTF_8 = "UTF-8";
  private static byte[] base64DecodeChars = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  private static final char[] base64EncodeChars;
  private static final String emailRegex = "([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)";
  private static final MLog logger = MLogManager.getLogger("moailog");
  
  static
  {
    TAG = StringExtention.class.getSimpleName();
    base64EncodeChars = new char[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  }
  
  private static String MD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      paramString = new BigInteger(1, localMessageDigest.digest()).toString(16);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static byte[] MD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      logger.i(TAG, "MD5 with bytes err:" + paramArrayOfByte.toString());
    }
    return null;
  }
  
  public static String MD5With16Charactor(String paramString)
  {
    return MD5With32Charactor(paramString).substring(0, 16);
  }
  
  public static String MD5With32Charactor(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = null;
      return str;
    }
    for (paramString = MD5(paramString).toUpperCase(Locale.getDefault());; paramString = "0" + paramString)
    {
      str = paramString;
      if (paramString.length() >= 32) {
        break;
      }
    }
  }
  
  public static String appendString(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String base64Encode(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int m;
      int j;
      if (i < paramInt)
      {
        m = i + 1;
        j = paramArrayOfByte[i] & 0xFF;
        if (m != paramInt) {
          break label78;
        }
        localStringBuilder.append(base64EncodeChars[(j >>> 2)]);
        localStringBuilder.append(base64EncodeChars[((j & 0x3) << 4)]);
        localStringBuilder.append("==");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        label78:
        k = m + 1;
        m = paramArrayOfByte[m] & 0xFF;
        if (k != paramInt) {
          break;
        }
        localStringBuilder.append(base64EncodeChars[(j >>> 2)]);
        localStringBuilder.append(base64EncodeChars[((j & 0x3) << 4 | (m & 0xF0) >>> 4)]);
        localStringBuilder.append(base64EncodeChars[((m & 0xF) << 2)]);
        localStringBuilder.append("=");
      }
      i = k + 1;
      int k = paramArrayOfByte[k] & 0xFF;
      localStringBuilder.append(base64EncodeChars[(j >>> 2)]);
      localStringBuilder.append(base64EncodeChars[((j & 0x3) << 4 | (m & 0xF0) >>> 4)]);
      localStringBuilder.append(base64EncodeChars[((m & 0xF) << 2 | (k & 0xC0) >>> 6)]);
      localStringBuilder.append(base64EncodeChars[(k & 0x3F)]);
    }
  }
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String calculateDigest(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 4
    //   7: new 296	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_3
    //   16: aload_1
    //   17: invokestatic 200	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore_0
    //   21: aload_3
    //   22: aload 4
    //   24: invokevirtual 303	java/io/FileInputStream:read	([B)I
    //   27: istore_2
    //   28: iload_2
    //   29: ifle +27 -> 56
    //   32: aload_0
    //   33: aload 4
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 214	java/security/MessageDigest:update	([BII)V
    //   40: goto -19 -> 21
    //   43: astore_0
    //   44: aload_3
    //   45: ifnull +7 -> 52
    //   48: aload_3
    //   49: invokevirtual 306	java/io/FileInputStream:close	()V
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: new 216	java/math/BigInteger
    //   59: dup
    //   60: iconst_1
    //   61: aload_0
    //   62: invokevirtual 219	java/security/MessageDigest:digest	()[B
    //   65: invokespecial 222	java/math/BigInteger:<init>	(I[B)V
    //   68: bipush 16
    //   70: invokevirtual 226	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   73: invokestatic 264	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   76: invokevirtual 268	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 210	java/lang/String:length	()I
    //   84: bipush 32
    //   86: if_icmpge +27 -> 113
    //   89: new 232	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 270
    //   99: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: goto -30 -> 80
    //   113: aload_0
    //   114: astore_1
    //   115: aload_3
    //   116: ifnull -62 -> 54
    //   119: aload_3
    //   120: invokevirtual 306	java/io/FileInputStream:close	()V
    //   123: aload_0
    //   124: areturn
    //   125: astore_1
    //   126: aload_0
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 306	java/io/FileInputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: goto -90 -> 52
    //   145: astore_1
    //   146: goto -7 -> 139
    //   149: astore_0
    //   150: goto -19 -> 131
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: goto -112 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramFile	java.io.File
    //   0	159	1	paramString	String
    //   27	10	2	i	int
    //   15	141	3	localFileInputStream	java.io.FileInputStream
    //   5	29	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	21	43	java/lang/Exception
    //   21	28	43	java/lang/Exception
    //   32	40	43	java/lang/Exception
    //   56	80	43	java/lang/Exception
    //   80	110	43	java/lang/Exception
    //   119	123	125	java/io/IOException
    //   7	16	128	finally
    //   48	52	141	java/io/IOException
    //   135	139	145	java/io/IOException
    //   16	21	149	finally
    //   21	28	149	finally
    //   32	40	149	finally
    //   56	80	149	finally
    //   80	110	149	finally
    //   7	16	153	java/lang/Exception
  }
  
  public static String clipString(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramString;
    }
    return paramString.substring(0, Math.min(paramString.length(), paramInt));
  }
  
  public static boolean containChinese(String paramString)
  {
    return paramString.getBytes().length != paramString.length();
  }
  
  public static boolean containInheritKey(Map<?, ?> paramMap, String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        int j = paramArrayOfString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramMap.get(paramArrayOfString[i]);
          if (localObject == null) {
            return false;
          }
          if (i != j - 1)
          {
            paramMap = (Map)localObject;
            i += 1;
          }
        }
        else
        {
          return true;
        }
      }
      catch (Exception paramMap)
      {
        return false;
      }
    }
  }
  
  public static void copyToClipboard(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT > 11)
    {
      paramContext = (android.content.ClipboardManager)paramContext.getSystemService("clipboard");
      paramString = ClipData.newPlainText("", paramString);
      alkw.a(paramContext, paramString);
      paramContext.setPrimaryClip(paramString);
      return;
    }
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
  
  public static byte[] decode(String paramString)
  {
    paramString = paramString.getBytes();
    int k = paramString.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(k);
    int i = 0;
    if (i < k) {}
    for (int j = i;; j = i)
    {
      byte[] arrayOfByte = base64DecodeChars;
      i = j + 1;
      int n = arrayOfByte[paramString[j]];
      if ((i >= k) || (n != -1))
      {
        j = i;
        if (n == -1) {}
        label63:
        int m;
        do
        {
          return localByteArrayOutputStream.toByteArray();
          do
          {
            j = i;
            arrayOfByte = base64DecodeChars;
            i = j + 1;
            m = arrayOfByte[paramString[j]];
          } while ((i < k) && (m == -1));
        } while (m == -1);
        localByteArrayOutputStream.write(n << 2 | (m & 0x30) >>> 4);
        for (j = i;; j = i)
        {
          i = j + 1;
          j = paramString[j];
          if (j == 61) {
            return localByteArrayOutputStream.toByteArray();
          }
          n = base64DecodeChars[j];
          if ((i >= k) || (n != -1))
          {
            if (n == -1) {
              break label63;
            }
            localByteArrayOutputStream.write((m & 0xF) << 4 | (n & 0x3C) >>> 2);
            for (j = i;; j = i)
            {
              i = j + 1;
              j = paramString[j];
              if (j == 61) {
                return localByteArrayOutputStream.toByteArray();
              }
              j = base64DecodeChars[j];
              if ((i >= k) || (j != -1))
              {
                if (j == -1) {
                  break label63;
                }
                localByteArrayOutputStream.write(j | (n & 0x3) << 6);
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public static String decodeURI(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = new String(paramString);
    try
    {
      str = urlDecode(str).replaceAll("%26", "&");
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String encodeURI(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = new String(paramString);
    try
    {
      str = urlEncode(str).replaceAll("&", "%26").replaceAll("\\{", "%7B").replaceAll("\\}", "%7D");
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String[] encodeURIArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfString.length];
    if (paramArrayOfString.length > 0)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[i] = encodeURI(paramArrayOfString[i]);
        i += 1;
      }
    }
    return arrayOfString;
  }
  
  public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramCharSequence1 == paramCharSequence2) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramCharSequence1 == null);
      bool1 = bool2;
    } while (paramCharSequence2 == null);
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return paramCharSequence1.equals(paramCharSequence2);
    }
    return regionMatches(paramCharSequence1, false, 0, paramCharSequence2, 0, Math.max(paramCharSequence1.length(), paramCharSequence2.length()));
  }
  
  /* Error */
  public static String fileMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +19 -> 22
    //   6: getstatic 58	moai/core/utilities/string/StringExtention:logger	Lmoai/log/MLog;
    //   9: getstatic 66	moai/core/utilities/string/StringExtention:TAG	Ljava/lang/String;
    //   12: ldc_w 430
    //   15: invokeinterface 433 3 0
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: invokevirtual 439	java/io/File:isFile	()Z
    //   26: ifne +39 -> 65
    //   29: getstatic 58	moai/core/utilities/string/StringExtention:logger	Lmoai/log/MLog;
    //   32: getstatic 66	moai/core/utilities/string/StringExtention:TAG	Ljava/lang/String;
    //   35: new 232	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 441
    //   45: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 444	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokeinterface 447 3 0
    //   63: aconst_null
    //   64: areturn
    //   65: ldc_w 346
    //   68: astore_2
    //   69: aload_0
    //   70: invokevirtual 450	java/io/File:exists	()Z
    //   73: ifeq -53 -> 20
    //   76: ldc 26
    //   78: invokestatic 200	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   81: astore_2
    //   82: new 452	java/io/BufferedInputStream
    //   85: dup
    //   86: new 296	java/io/FileInputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 455	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore_0
    //   98: sipush 1024
    //   101: newarray byte
    //   103: astore_3
    //   104: aload_0
    //   105: aload_3
    //   106: invokevirtual 458	java/io/InputStream:read	([B)I
    //   109: istore_1
    //   110: iload_1
    //   111: iconst_m1
    //   112: if_icmpeq +59 -> 171
    //   115: aload_2
    //   116: aload_3
    //   117: iconst_0
    //   118: iload_1
    //   119: invokevirtual 214	java/security/MessageDigest:update	([BII)V
    //   122: goto -18 -> 104
    //   125: astore_2
    //   126: aload_0
    //   127: invokevirtual 459	java/io/InputStream:close	()V
    //   130: aload_2
    //   131: athrow
    //   132: astore_0
    //   133: getstatic 58	moai/core/utilities/string/StringExtention:logger	Lmoai/log/MLog;
    //   136: getstatic 66	moai/core/utilities/string/StringExtention:TAG	Ljava/lang/String;
    //   139: new 232	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 461
    //   149: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: invokevirtual 462	java/lang/Exception:toString	()Ljava/lang/String;
    //   156: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokeinterface 447 3 0
    //   167: ldc_w 346
    //   170: areturn
    //   171: aload_0
    //   172: invokevirtual 459	java/io/InputStream:close	()V
    //   175: aload_2
    //   176: invokevirtual 219	java/security/MessageDigest:digest	()[B
    //   179: invokestatic 464	moai/core/utilities/string/StringExtention:toHexString	([B)Ljava/lang/String;
    //   182: astore_0
    //   183: aload_0
    //   184: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramFile	java.io.File
    //   109	10	1	i	int
    //   1	115	2	localObject1	Object
    //   125	51	2	localObject2	Object
    //   103	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   104	110	125	finally
    //   115	122	125	finally
    //   76	104	132	java/lang/Exception
    //   126	132	132	java/lang/Exception
    //   171	183	132	java/lang/Exception
  }
  
  public static String filterRegxpllega(String paramString)
  {
    return paramString.replaceAll("[{}\\[\\]()+\\$\\?*]", "\\\\$0");
  }
  
  public static String getHumanReadable(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
    if (paramLong >= 1048576L) {
      return localDecimalFormat.format(paramLong / 1048576.0D) + "M";
    }
    if (paramLong >= 1024L) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K";
    }
    return localDecimalFormat.format(paramLong / 1.0D) + "B";
  }
  
  public static String getHumanReadableSizeString(long paramLong)
  {
    if (paramLong >= 1073741824.0D) {
      return String.format(Locale.getDefault(), "%.2fG", new Object[] { Double.valueOf(paramLong / 1073741824.0D) });
    }
    if (paramLong >= 1048576.0D) {
      return String.format(Locale.getDefault(), "%.2fM", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
    }
    if (paramLong >= 1024.0D) {
      return String.format(Locale.getDefault(), "%.2fK", new Object[] { Double.valueOf(paramLong / 1024.0D) });
    }
    if (paramLong <= 1L) {
      return "0K";
    }
    return String.format(Locale.getDefault(), "%.2fB", new Object[] { Double.valueOf(paramLong / 1.0D) });
  }
  
  public static String hashKeyForDisk(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = bytesToHexString(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return String.valueOf(paramString.hashCode());
  }
  
  public static String hexDecode(String paramString)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replaceAll("\\\\x", "%");
    }
    return str;
  }
  
  public static String htmlDecode(String paramString)
  {
    return StringEscapeUtils.unescapeHtml4(paramString);
  }
  
  public static String htmlEncode(String paramString)
  {
    return StringEscapeUtils.escapeHtml4(paramString);
  }
  
  public static String indexDecode(String paramString)
  {
    return replaceAllWithSeparator(paramString, "%5F", "", "_");
  }
  
  public static String indexEncode(String paramString)
  {
    return replaceAllWithSeparator(paramString, "_", "", "%5F");
  }
  
  public static boolean isBase64String(String paramString)
  {
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      int j = paramString.charAt(i);
      if (((j < 65) || (j > 90)) && ((j < 97) || (j > 122)) && ((j < 48) || (j > 57)) && (j != 43) && (j != 47) && (j != 61)) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public static boolean isBlank(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramCharSequence != null)
    {
      j = paramCharSequence.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean isEmail(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    while (!Pattern.matches("([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)", paramString)) {
      return false;
    }
    return true;
  }
  
  public static boolean isNullOrEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static boolean isNum(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label49;
      }
      if (!Character.isDigit(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
  
  public static String join(List<?> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramList.get(i)));
      if (i < j - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String join(Object[] paramArrayOfObject, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramArrayOfObject.length;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramArrayOfObject[i]));
      if (i < j - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String paramsString(List<NameValuePair> paramList)
  {
    if (paramList == null) {
      paramList = "";
    }
    String str;
    do
    {
      return paramList;
      str = null;
      int i = 0;
      if (i < paramList.size())
      {
        NameValuePair localNameValuePair = (NameValuePair)paramList.get(i);
        if (str == null) {}
        for (str = localNameValuePair.getName() + '=' + localNameValuePair.getValue();; str = str + '&' + localNameValuePair.getName() + '=' + localNameValuePair.getValue())
        {
          i += 1;
          break;
        }
      }
      paramList = str;
    } while (str != null);
    return "";
  }
  
  public static List<NameValuePair> parseParams(String paramString1, String paramString2)
  {
    return parseParams(paramString1, paramString2, false);
  }
  
  public static List<NameValuePair> parseParams(String paramString1, String paramString2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return localArrayList;
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return localArrayList;
    }
    String[] arrayOfString = paramString1.split(paramString2);
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString2 = arrayOfString[i];
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        int j = paramString2.indexOf('=');
        if (j > 0)
        {
          String str = paramString2.substring(0, j);
          paramString1 = "";
          if (j + 1 < paramString2.length()) {
            paramString1 = paramString2.substring(j + 1, paramString2.length());
          }
          paramString2 = paramString1;
          if (paramBoolean) {
            paramString2 = decodeURI(paramString1);
          }
          localArrayList.add(new BasicNameValuePair(str, paramString2));
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<NameValuePair> parseParams(String paramString, boolean paramBoolean)
  {
    return parseParams(paramString, "&", paramBoolean);
  }
  
  public static String parseUrlHost(String paramString)
  {
    paramString = Pattern.compile("[http|https]+://([\\w-]+\\.)+[\\w-]+(/[\\w- /]*/)?").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return "";
  }
  
  public static String parseUrlParam(String paramString)
  {
    String str1 = "";
    String str2 = parseUrlHost(paramString);
    if (paramString.indexOf(str2) != -1) {
      str1 = paramString.substring(str2.length());
    }
    return str1;
  }
  
  public static String quickReplace(String paramString1, HashMap<String, String> paramHashMap, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramHashMap == null) || (paramHashMap.size() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString1.length());
    int i = 0;
    label228:
    for (;;)
    {
      int k = paramString1.indexOf(paramString2, i);
      int j;
      if (k == -1) {
        j = i;
      }
      int m;
      do
      {
        for (;;)
        {
          if (j < paramString1.length()) {
            localStringBuilder.append(paramString1, j, paramString1.length());
          }
          return localStringBuilder.toString();
          j = paramString1.indexOf('\n', k + 1);
          m = paramString1.indexOf(paramString2, k + 1);
          if (j >= m) {
            break;
          }
          localStringBuilder.append(paramString1, i, j);
          i = j + 1;
          if (i < paramString1.length()) {
            break label228;
          }
          j = i;
        }
        j = i;
      } while (m == -1);
      String str = (String)paramHashMap.get(paramString1.substring(k + 1, m));
      if (str != null)
      {
        localStringBuilder.append(paramString1, i, k);
        localStringBuilder.append(str);
      }
      for (;;)
      {
        i = m + 1;
        break;
        localStringBuilder.append(paramString1, i, m + 1);
      }
    }
  }
  
  static boolean regionMatches(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    int i = paramInt1;
    int j = paramInt2;
    int k = paramInt3;
    boolean bool1;
    if ((paramCharSequence1 instanceof String))
    {
      i = paramInt1;
      j = paramInt2;
      k = paramInt3;
      if ((paramCharSequence2 instanceof String))
      {
        bool1 = ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
        return bool1;
      }
    }
    for (;;)
    {
      paramInt2 = k - 1;
      if (k <= 0) {
        break label176;
      }
      paramInt1 = i + 1;
      char c1 = paramCharSequence1.charAt(i);
      paramInt3 = j + 1;
      char c2 = paramCharSequence2.charAt(j);
      if (c1 == c2)
      {
        k = paramInt2;
        i = paramInt1;
        j = paramInt3;
      }
      else
      {
        bool1 = bool2;
        if (!paramBoolean) {
          break;
        }
        if (Character.toUpperCase(c1) != Character.toUpperCase(c2))
        {
          bool1 = bool2;
          if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
            break;
          }
        }
        k = paramInt2;
        i = paramInt1;
        j = paramInt3;
      }
    }
    label176:
    return true;
  }
  
  public static String removeHtmlLableByName(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString3);
    paramString3 = "<" + paramString2;
    paramString2 = "</" + paramString2;
    if (i < 0) {
      return paramString1;
    }
    int k = paramString1.substring(0, i).lastIndexOf(paramString3);
    int j = 1;
    for (;;)
    {
      int m;
      int n;
      if ((i >= 0) && (j > 0))
      {
        m = paramString1.indexOf(paramString3, i);
        n = paramString1.indexOf(paramString2, i);
        if (n >= 0) {}
      }
      else
      {
        if ((k < 0) || (i < 0) || (i < k)) {
          break;
        }
        return paramString1.replace(paramString1.substring(k, i), " ");
      }
      if ((m > 0) && (m < n))
      {
        j += 1;
        i = paramString3.length() + m;
      }
      else
      {
        j -= 1;
        i = paramString2.length() + n + 1;
      }
    }
  }
  
  public static String removeTokenFromUrl(String paramString1, String paramString2)
  {
    Matcher localMatcher = Pattern.compile("(\\?|&+)(.+?)=([^&]*)").matcher(paramString1);
    do
    {
      str = paramString1;
      if (!localMatcher.find()) {
        break;
      }
      str = localMatcher.group(0).substring(1);
    } while (!str.contains(paramString2));
    String str = paramString1.replace(str, "");
    return str;
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    return replaceTemplateWithSeparator(paramString1, paramString2, "$", paramString3);
  }
  
  public static String replaceAllIgnoreCase(String paramString1, String paramString2, String paramString3)
  {
    return Pattern.compile(paramString2, 2).matcher(paramString1).replaceAll(paramString3);
  }
  
  public static String replaceAllWithSeparator(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString1;
    if (paramString1.indexOf(paramString3 + paramString2 + paramString3) > -1) {
      str = paramString1.replaceAll(paramString3 + paramString2 + paramString3, paramString4);
    }
    return str;
  }
  
  public static String replaceBackIllegalUrl(String paramString)
  {
    return paramString.replace("%23", "#").replace("%27", "\\").replace("%3f", "\\?").replace("%25", "%");
  }
  
  public static String replaceIllegalUrl(String paramString)
  {
    return paramString.replace("%", "%25").replace("#", "%23").replace("\\", "%27").replace("\\?", "%3f");
  }
  
  public static String replaceObjcharater(String paramString)
  {
    return paramString.replace(' ', ' ').replace(65532, ' ').trim();
  }
  
  public static String replaceTemplateWithSeparator(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString4 == null) {
      str = "";
    }
    return paramString1.replace(paramString3 + paramString2 + paramString3, str);
  }
  
  public static String replaceWithDictionary(String paramString, HashMap<String, String> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      paramString = paramString.replace("$" + str + "$", (CharSequence)localObject);
    }
    return paramString;
  }
  
  public static String replaceWithEncodeURIValue(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    return replace(paramString1, paramString2, encodeURI(str));
  }
  
  public static String replaceWithURIValue(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    return replace(paramString1, paramString2, str);
  }
  
  public static long sizeStrToLong(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return 0L;
    }
    String str = "";
    int i = 0;
    char c;
    if (i < paramString.length())
    {
      c = paramString.charAt(i);
      if (c == 'B') {
        i = 1;
      }
    }
    for (;;)
    {
      float f = Float.parseFloat(str);
      return (i * f);
      if (c == 'K')
      {
        i = 1024;
      }
      else if (c == 'M')
      {
        i = 1048576;
      }
      else if (c == 'G')
      {
        i = 1073741824;
      }
      else
      {
        if ((Character.isDigit(c)) || (c == '.'))
        {
          str = str + c;
          i += 1;
          break;
        }
        i = 1;
      }
    }
  }
  
  public static boolean strictEmpty(HashMap<?, String> paramHashMap, Object paramObject)
  {
    return (paramHashMap.get(paramObject) == null) || (((String)paramHashMap.get(paramObject)).length() == 0);
  }
  
  public static String textToHtml(String paramString)
  {
    return htmlEncode(paramString).replace("\n", "<br/>").replace(" ", "&nbsp;");
  }
  
  private static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0" + str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static Long toLong(String paramString)
  {
    Long localLong2 = Long.valueOf(0L);
    Long localLong1 = localLong2;
    if (paramString != null)
    {
      localLong1 = localLong2;
      if (paramString.equals("")) {}
    }
    try
    {
      long l = Long.parseLong(paramString);
      localLong1 = Long.valueOf(l);
      return localLong1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      logger.d(TAG, "parse long error. snum is : " + paramString);
    }
    return localLong2;
  }
  
  public static String urlDecode(String paramString)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString != null) {}
    try
    {
      str = URLDecoder.decode(paramString, "utf-8");
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String urlEncode(String paramString)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString != null) {
      str = URLEncoder.encode(paramString, "utf-8").replaceAll("%3D", "=").replaceAll("%40", "@").replaceAll("%2C", ",");
    }
    return str;
  }
  
  public static String urlEncodeParams(List<NameValuePair> paramList)
    throws UnsupportedEncodingException
  {
    String str1 = null;
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (NameValuePair)paramList.get(i);
      String str3 = ((NameValuePair)localObject).getName();
      String str2 = ((NameValuePair)localObject).getValue();
      localObject = str2;
      if (str2 != null) {
        localObject = urlEncode(str2);
      }
      if (str1 == null) {}
      for (str1 = str3 + '=' + (String)localObject;; str1 = str1 + '&' + str3 + '=' + (String)localObject)
      {
        i += 1;
        break;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.string.StringExtention
 * JD-Core Version:    0.7.0.1
 */