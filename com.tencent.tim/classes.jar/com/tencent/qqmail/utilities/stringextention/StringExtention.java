package com.tencent.qqmail.utilities.stringextention;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class StringExtention
{
  private static final String TAG = "StringExtention";
  private static byte[] base64DecodeChars = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  private static final char[] base64EncodeChars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final String emailRegex = "^(?:.*?<)?([-A-Za-z\\d+_=]+(:?\\.))*?[-A-Za-z\\d+_=]+@([-A-Za-z\\d_]+(:?\\.))+[-A-Za-z\\d_]+>?$";
  
  private static String MD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      paramString = toHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String MD5(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, 0, paramInt);
      paramArrayOfByte = toHexString(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      QMLog.log(6, "StringExtention", "MD5 with bytes err:" + paramArrayOfByte.toString());
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
      QMLog.log(6, "StringExtention", "MD5 with bytes err:" + paramArrayOfByte.toString());
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
          break label77;
        }
        localStringBuilder.append(base64EncodeChars[(j >>> 2)]);
        localStringBuilder.append(base64EncodeChars[((j & 0x3) << 4)]);
        localStringBuilder.append("==");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        label77:
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
  public static String calculateDigest(File paramFile, String paramString)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 4
    //   7: new 245	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 248	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_3
    //   16: aload_1
    //   17: invokestatic 153	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore_0
    //   21: aload_3
    //   22: aload 4
    //   24: invokevirtual 252	java/io/FileInputStream:read	([B)I
    //   27: istore_2
    //   28: iload_2
    //   29: ifle +27 -> 56
    //   32: aload_0
    //   33: aload 4
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 167	java/security/MessageDigest:update	([BII)V
    //   40: goto -19 -> 21
    //   43: astore_0
    //   44: aload_3
    //   45: ifnull +7 -> 52
    //   48: aload_3
    //   49: invokevirtual 255	java/io/FileInputStream:close	()V
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: aload_0
    //   57: invokevirtual 170	java/security/MessageDigest:digest	()[B
    //   60: invokestatic 174	com/tencent/qqmail/utilities/stringextention/StringExtention:toHexString	([B)Ljava/lang/String;
    //   63: invokestatic 215	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   66: invokevirtual 219	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 163	java/lang/String:length	()I
    //   74: bipush 32
    //   76: if_icmpge +26 -> 102
    //   79: new 180	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   86: ldc 221
    //   88: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore_0
    //   99: goto -29 -> 70
    //   102: aload_0
    //   103: astore_1
    //   104: aload_3
    //   105: ifnull -51 -> 54
    //   108: aload_3
    //   109: invokevirtual 255	java/io/FileInputStream:close	()V
    //   112: aload_0
    //   113: areturn
    //   114: astore_1
    //   115: aload_0
    //   116: areturn
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_3
    //   120: aload_3
    //   121: ifnull +7 -> 128
    //   124: aload_3
    //   125: invokevirtual 255	java/io/FileInputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: goto -79 -> 52
    //   134: astore_1
    //   135: goto -7 -> 128
    //   138: astore_0
    //   139: goto -19 -> 120
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_3
    //   145: goto -101 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramFile	File
    //   0	148	1	paramString	String
    //   27	10	2	i	int
    //   15	130	3	localFileInputStream	FileInputStream
    //   5	29	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	21	43	java/lang/Exception
    //   21	28	43	java/lang/Exception
    //   32	40	43	java/lang/Exception
    //   56	70	43	java/lang/Exception
    //   70	99	43	java/lang/Exception
    //   108	112	114	java/io/IOException
    //   7	16	117	finally
    //   48	52	130	java/io/IOException
    //   124	128	134	java/io/IOException
    //   16	21	138	finally
    //   21	28	138	finally
    //   32	40	138	finally
    //   56	70	138	finally
    //   70	99	138	finally
    //   7	16	142	java/lang/Exception
  }
  
  public static String clipString(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramString;
    }
    return paramString.substring(0, Math.min(paramString.length(), paramInt));
  }
  
  public static String clipStringWithEllipse(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.length() > paramInt) {
      str = paramString.substring(0, paramInt) + "...";
    }
    return str;
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
  
  public static String fileMD5(File paramFile)
  {
    if (paramFile == null) {
      QMLog.log(6, "StringExtention", "getFileMD5. file is null.");
    }
    do
    {
      return "";
      if (!paramFile.isFile())
      {
        QMLog.log(6, "StringExtention", "getFileMD5. not file:" + paramFile.getAbsolutePath());
        return "";
      }
    } while (!paramFile.exists());
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramFile.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      QMLog.log(6, "StringExtention", "fileMD5. get md5 err:" + paramFile.toString());
      return "";
    }
    paramFile = toHexString(localMessageDigest.digest());
    return paramFile;
  }
  
  public static String fileMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return fileMD5(new File(paramString));
  }
  
  public static String filterRegxpllega(String paramString)
  {
    return paramString.replaceAll("[{}\\[\\]()+\\$\\?*]", "\\\\$0");
  }
  
  public static String getCookies(String paramString1, String paramString2)
  {
    int i = new Random().nextInt(10000) + 1;
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("qqmAILDNscHEck");
    if (paramString2 == null) {}
    for (String str = "";; str = paramString2)
    {
      str = MD5With32Charactor(str).toLowerCase(Locale.getDefault()).substring(0, 8);
      if ((paramString1 != null) && (!paramString1.equals(""))) {
        break label175;
      }
      if (paramString2 == null) {
        break;
      }
      return "" + "appkey=" + str + ";k=" + i + ";curuin=" + paramString2;
    }
    return "" + "appkey=" + str + ";k=" + i;
    label175:
    if (paramString2 != null) {
      return "" + paramString1 + ";appkey=" + str + ";k=" + i + ";curuin=" + paramString2;
    }
    return "" + paramString1 + ";appkey=" + str + ";k=" + i;
  }
  
  @Deprecated
  public static String getHumanReadable(long paramLong)
  {
    return getHumanReadableSizeString(paramLong);
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
  
  public static JSONObject getKeyValueDict(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    paramString = paramString.split("&");
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        localJSONObject.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
    return localJSONObject;
  }
  
  public static String getUrl(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str2 = "";
    String str1 = str2;
    if (!paramString.contains("http:"))
    {
      str1 = str2;
      if (!paramString.contains("https:")) {
        str1 = "" + QMNetworkConfig.getCgiRequestHost(0);
      }
    }
    return replaceAllIgnoreCase(str1 + paramString, "&amp;", "&");
  }
  
  public static String getUrlHost(String paramString)
  {
    String str = null;
    try
    {
      paramString = new URL(paramString);
      if (paramString != null) {
        str = paramString.getHost();
      }
      return str;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static String getUrlPath(String paramString)
  {
    String str = null;
    try
    {
      paramString = new URL(paramString);
      if (paramString != null) {
        str = paramString.getPath();
      }
      return str;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
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
  
  private static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean isChinese(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (isChinese(paramString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isChineseCharacter(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        int k = paramString[i];
        if ((k >= 19968) && (k <= 40891)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isEmailPattern(String paramString)
  {
    if (isNullOrEmpty(paramString)) {}
    while (!Pattern.matches("^(?:.*?<)?([-A-Za-z\\d+_=]+(:?\\.))*?[-A-Za-z\\d+_=]+@([-A-Za-z\\d_]+(:?\\.))+[-A-Za-z\\d_]+>?$", paramString)) {
      return false;
    }
    return true;
  }
  
  public static boolean isFileDirEqual(String paramString1, String paramString2)
  {
    if ((isNullOrEmpty(paramString1)) || (isNullOrEmpty(paramString2))) {}
    String str;
    do
    {
      return false;
      str = paramString1;
      if (paramString1.endsWith(File.separator)) {
        str = paramString1.substring(0, paramString1.length() - 1);
      }
      paramString1 = paramString2;
      if (paramString2.endsWith(File.separator)) {
        paramString1 = paramString2.substring(0, paramString2.length() - 1);
      }
    } while (!str.equals(paramString1));
    return true;
  }
  
  public static boolean isNotNullAndEqual(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2));
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.equals(""));
  }
  
  public static boolean isNum(String paramString)
  {
    return paramString.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
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
    int n = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    int i1 = paramList.size();
    int k = 0;
    int m = 0;
    if (k < i1)
    {
      localObject = (NameValuePair)paramList.get(k);
      label58:
      int j;
      if (localObject == null)
      {
        i = 0;
        if (localObject != null) {
          break label109;
        }
        j = 0;
      }
      for (;;)
      {
        m += j + i;
        k += 1;
        break;
        if (((NameValuePair)localObject).getName() == null)
        {
          i = 0;
          break label58;
        }
        i = ((NameValuePair)localObject).getName().length();
        break label58;
        label109:
        if (((NameValuePair)localObject).getValue() == null) {
          j = 0;
        } else {
          j = ((NameValuePair)localObject).getValue().length();
        }
      }
    }
    Object localObject = new StringBuilder(i1 * 2 - 1 + m);
    int i = n;
    if (i < paramList.size())
    {
      NameValuePair localNameValuePair = (NameValuePair)paramList.get(i);
      if (localNameValuePair == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (((StringBuilder)localObject).length() == 0) {
          ((StringBuilder)localObject).append(localNameValuePair.getName()).append("=").append(localNameValuePair.getValue());
        } else {
          ((StringBuilder)localObject).append("&").append(localNameValuePair.getName()).append("=").append(localNameValuePair.getValue());
        }
      }
    }
    return ((StringBuilder)localObject).toString();
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
  
  public static String parseUrlParam(String paramString)
  {
    String str1 = "";
    String str2 = parseUrlWithoutParam(paramString);
    if (paramString.indexOf(str2) != -1) {
      str1 = paramString.substring(str2.length());
    }
    return str1;
  }
  
  public static String parseUrlWithoutParam(String paramString)
  {
    paramString = Pattern.compile("[http|https]+://([\\w-]+\\.)+[\\w-]+(/[\\w- /]*/)?").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return "";
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
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramHashMap = (Map.Entry)localIterator.next();
      String str2 = (String)paramHashMap.getKey();
      String str1 = (String)paramHashMap.getValue();
      paramHashMap = str1;
      if (str1 == null) {
        paramHashMap = "";
      }
      paramString = paramString.replace("$" + str2 + "$", paramHashMap);
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
  
  public static String safeNickName(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"").replace("'", "\\'").replace("<", "\\<").replace(">", "\\>");
  }
  
  public static String safeStringLiteral(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("\"", "\\\"");
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
      try
      {
        float f = Float.parseFloat(str);
        return (i * f);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QMLog.log(6, "StringExtention", "parse float error:" + localNumberFormatException + ",size:" + paramString + ",result:" + str);
        return 0L;
      }
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
  
  public static ArrayList<Long> splitToLongList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!isNullOrEmpty(paramString1))
    {
      paramString1 = paramString1.split(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Long.valueOf(paramString1[i]));
        i += 1;
      }
    }
    return localArrayList;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.stringextention.StringExtention
 * JD-Core Version:    0.7.0.1
 */