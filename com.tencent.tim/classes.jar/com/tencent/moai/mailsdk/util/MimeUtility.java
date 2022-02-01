package com.tencent.moai.mailsdk.util;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.EncodeString;
import com.tencent.moai.mailsdk.protocol.mime.ContentDisposition;
import com.tencent.moai.mailsdk.protocol.mime.ContentType;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.mime.model.MimePart;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.BASE64DecoderStream;
import com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream;
import com.tencent.moai.mailsdk.util.stream.BEncoderStream;
import com.tencent.moai.mailsdk.util.stream.QEncoderStream;
import com.tencent.moai.mailsdk.util.stream.QPDecoderStream;
import com.tencent.moai.mailsdk.util.stream.QPEncoderStream;
import com.tencent.moai.mailsdk.util.stream.UUDecoderStream;
import com.tencent.moai.mailsdk.util.stream.UUEncoderStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MimeUtility
{
  public static final int ALL = -1;
  public static final int ALL_ASCII = 1;
  private static final String[] CHARSETS;
  public static final String DEFAULT_CHARSET = "utf-8";
  public static final int MOSTLY_ASCII = 2;
  public static final int MOSTLY_NONASCII = 3;
  private static final String TAG = "MimeUtility";
  private static final boolean decodeStrict = true;
  private static String defaultJavaCharset;
  private static String defaultMIMECharset;
  private static final boolean encodeEolStrict = false;
  private static final boolean foldEncodedWords = false;
  private static final boolean foldText = true;
  private static final boolean ignoreUnknownEncoding = false;
  private static Map<String, String> java2mime;
  private static Map<String, String> mime2java;
  private static final Map<String, Boolean> nonAsciiCharsetMap;
  
  static
  {
    if (!MimeUtility.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      nonAsciiCharsetMap = new HashMap();
      java2mime = new HashMap(40);
      mime2java = new HashMap(10);
      if (java2mime.isEmpty())
      {
        java2mime.put("8859_1", "ISO-8859-1");
        java2mime.put("iso8859_1", "ISO-8859-1");
        java2mime.put("iso8859-1", "ISO-8859-1");
        java2mime.put("8859_2", "ISO-8859-2");
        java2mime.put("iso8859_2", "ISO-8859-2");
        java2mime.put("iso8859-2", "ISO-8859-2");
        java2mime.put("8859_3", "ISO-8859-3");
        java2mime.put("iso8859_3", "ISO-8859-3");
        java2mime.put("iso8859-3", "ISO-8859-3");
        java2mime.put("8859_4", "ISO-8859-4");
        java2mime.put("iso8859_4", "ISO-8859-4");
        java2mime.put("iso8859-4", "ISO-8859-4");
        java2mime.put("8859_5", "ISO-8859-5");
        java2mime.put("iso8859_5", "ISO-8859-5");
        java2mime.put("iso8859-5", "ISO-8859-5");
        java2mime.put("8859_6", "ISO-8859-6");
        java2mime.put("iso8859_6", "ISO-8859-6");
        java2mime.put("iso8859-6", "ISO-8859-6");
        java2mime.put("8859_7", "ISO-8859-7");
        java2mime.put("iso8859_7", "ISO-8859-7");
        java2mime.put("iso8859-7", "ISO-8859-7");
        java2mime.put("8859_8", "ISO-8859-8");
        java2mime.put("iso8859_8", "ISO-8859-8");
        java2mime.put("iso8859-8", "ISO-8859-8");
        java2mime.put("8859_9", "ISO-8859-9");
        java2mime.put("iso8859_9", "ISO-8859-9");
        java2mime.put("iso8859-9", "ISO-8859-9");
        java2mime.put("sjis", "Shift_JIS");
        java2mime.put("jis", "ISO-2022-JP");
        java2mime.put("iso2022jp", "ISO-2022-JP");
        java2mime.put("euc_jp", "euc-jp");
        java2mime.put("koi8_r", "koi8-r");
        java2mime.put("euc_cn", "euc-cn");
        java2mime.put("euc_tw", "euc-tw");
        java2mime.put("euc_kr", "euc-kr");
      }
      if (mime2java.isEmpty())
      {
        mime2java.put("iso-2022-cn", "ISO2022CN");
        mime2java.put("iso-2022-kr", "ISO2022KR");
        mime2java.put("utf-8", "UTF8");
        mime2java.put("utf8", "UTF8");
        mime2java.put("ja_jp.iso2022-7", "ISO2022JP");
        mime2java.put("ja_jp.eucjp", "EUCJIS");
        mime2java.put("euc-kr", "KSC5601");
        mime2java.put("euckr", "KSC5601");
        mime2java.put("us-ascii", "ISO-8859-1");
        mime2java.put("x-us-ascii", "ISO-8859-1");
      }
      CHARSETS = new String[] { "", "utf-8", "Big5", "gb2312", "euc-kr", "Shift-JIS", "iso-8859-1", "us-ascii" };
      return;
    }
  }
  
  public static int checkAscii(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    int i;
    byte[] arrayOfByte;
    int i2;
    int k;
    int j;
    int m;
    int i1;
    int n;
    int i3;
    if (paramInt != 0)
    {
      if (paramInt == -1) {}
      for (i = 4096;; i = Math.min(paramInt, 4096))
      {
        arrayOfByte = new byte[i];
        i2 = 0;
        k = 0;
        j = 0;
        m = 0;
        i1 = paramInt;
        n = i;
        i = i2;
        paramInt = i;
        i2 = j;
        i3 = k;
        if (i1 != 0) {}
        try
        {
          i4 = paramInputStream.read(arrayOfByte, 0, n);
          if (i4 != -1) {
            break;
          }
          i3 = k;
          i2 = j;
          paramInt = i;
        }
        catch (IOException paramInputStream)
        {
          for (;;)
          {
            int i4;
            paramInt = i;
            i2 = j;
            i3 = k;
          }
          m = k;
          k = i;
          i = j;
          j = paramInt;
        }
        if ((i1 != 0) || (!paramBoolean)) {
          break label257;
        }
        return 3;
      }
      i2 = m;
      m = 0;
      paramInt = j;
      i3 = k;
      k = i2;
      j = i;
      i = i3;
      label127:
      if (m < i4)
      {
        i3 = arrayOfByte[m] & 0xFF;
        if ((i3 == 13) || (i3 == 10)) {
          break label349;
        }
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = nonascii(i3);
        if (bool)
        {
          if (paramBoolean)
          {
            return 3;
            i2 = k + 1;
            k = i2;
            if (i2 <= 998) {
              continue;
            }
            j = 1;
            k = i2;
            continue;
          }
          paramInt += 1;
          m += 1;
          break label127;
        }
        i += 1;
        continue;
        if (i1 == -1) {
          break label308;
        }
        i1 -= i4;
        m = k;
        k = i;
        i = j;
        j = paramInt;
      }
      catch (IOException paramInputStream)
      {
        label257:
        i2 = paramInt;
        paramInt = j;
        i3 = i;
      }
      if (i2 == 0)
      {
        if (paramInt != 0) {
          return 2;
        }
        return 1;
      }
      if (i3 > i2) {
        return 2;
      }
      return 3;
      label308:
      break;
      n = 4096;
      j = 0;
      m = 0;
      i = 0;
      k = 0;
      arrayOfByte = null;
      i1 = paramInt;
      break;
      label349:
      k = 0;
    }
  }
  
  public static int checkAscii(String paramString)
  {
    int j = 0;
    int m = paramString.length();
    int i = 0;
    int k = 0;
    if (i < m)
    {
      if (nonascii(paramString.charAt(i))) {
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        k += 1;
      }
    }
    if (j == 0) {
      return 1;
    }
    if (k > j) {
      return 2;
    }
    return 3;
  }
  
  public static int checkAscii(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    if (i < paramArrayOfByte.length)
    {
      if (nonascii(paramArrayOfByte[i] & 0xFF)) {
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        k += 1;
      }
    }
    if (j == 0) {
      return 1;
    }
    if (k > j) {
      return 2;
    }
    return 3;
  }
  
  public static boolean checkCharset(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    label16:
    if (i < j)
    {
      int k = paramString.charAt(i);
      if ((k >= 65) && (k <= 90)) {}
      for (;;)
      {
        i += 1;
        break label16;
        if (((k < 97) || (k > 122)) && ((k < 48) || (k > 57)) && ((k != 45) || (i == 0)) && ((k != 43) || (i == 0)) && ((k != 58) || (i == 0)) && ((k != 95) || (i == 0))) {
          if ((k != 46) || (i == 0)) {
            break;
          }
        }
      }
    }
    return Charset.isSupported(paramString);
  }
  
  private static String checkWord(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws UnsupportedEncodingException
  {
    int i = checkAscii(paramString1);
    if (i == 1) {
      return paramString1;
    }
    String str = paramString3;
    if (paramString3 == null) {
      if (i == 3) {
        break label41;
      }
    }
    label41:
    for (str = "Q";; str = "B") {
      return encodeWord(paramString1, paramString2, str, paramBoolean);
    }
  }
  
  private static byte[] convertCharset(byte[] paramArrayOfByte, int paramInt, String paramString)
    throws UnsupportedEncodingException
  {
    return new String(paramArrayOfByte, paramString).getBytes("utf-8");
  }
  
  public static InputStream decode(InputStream paramInputStream, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return paramInputStream;
      if (paramString.equalsIgnoreCase("base64")) {
        return new BASE64DecoderStream(paramInputStream);
      }
      if (paramString.equalsIgnoreCase("quoted-printable")) {
        return new QPDecoderStream(paramInputStream);
      }
      if ((paramString.equalsIgnoreCase("uuencode")) || (paramString.equalsIgnoreCase("x-uuencode")) || (paramString.equalsIgnoreCase("x-uue"))) {
        return new UUDecoderStream(paramInputStream);
      }
    } while ((paramString.equalsIgnoreCase("binary")) || (paramString.equalsIgnoreCase("7bit")) || (!paramString.equalsIgnoreCase("8bit")));
    return paramInputStream;
  }
  
  /* Error */
  public static byte[] decode(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 317	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 318	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 320	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 323	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore_3
    //   24: aload 6
    //   26: astore_0
    //   27: aload_3
    //   28: aload_1
    //   29: invokestatic 325	com/tencent/moai/mailsdk/util/MimeUtility:decode	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: sipush 8192
    //   38: newarray byte
    //   40: astore 5
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: aload 5
    //   47: invokevirtual 327	java/io/InputStream:read	([B)I
    //   50: istore_2
    //   51: iload_2
    //   52: ifle +54 -> 106
    //   55: aload_1
    //   56: astore_0
    //   57: aload 4
    //   59: aload 5
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 331	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -24 -> 42
    //   69: astore 5
    //   71: aload_3
    //   72: astore_1
    //   73: aload_0
    //   74: astore_3
    //   75: aload 5
    //   77: astore_0
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 334	java/io/InputStream:close	()V
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 335	java/io/ByteArrayInputStream:close	()V
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 336	java/io/ByteArrayOutputStream:close	()V
    //   104: aload_0
    //   105: athrow
    //   106: aload_1
    //   107: astore_0
    //   108: new 203	java/lang/String
    //   111: dup
    //   112: aload 4
    //   114: invokevirtual 340	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: ldc 17
    //   119: invokespecial 278	java/lang/String:<init>	([BLjava/lang/String;)V
    //   122: invokevirtual 342	java/lang/String:getBytes	()[B
    //   125: astore 5
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 334	java/io/InputStream:close	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 335	java/io/ByteArrayInputStream:close	()V
    //   143: aload 4
    //   145: ifnull +8 -> 153
    //   148: aload 4
    //   150: invokevirtual 336	java/io/ByteArrayOutputStream:close	()V
    //   153: aload 5
    //   155: areturn
    //   156: astore_0
    //   157: goto -22 -> 135
    //   160: astore_0
    //   161: goto -18 -> 143
    //   164: astore_0
    //   165: aload 5
    //   167: areturn
    //   168: astore_3
    //   169: goto -83 -> 86
    //   172: astore_1
    //   173: goto -79 -> 94
    //   176: astore_1
    //   177: goto -73 -> 104
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: aconst_null
    //   184: astore 4
    //   186: aload 5
    //   188: astore_3
    //   189: goto -111 -> 78
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_1
    //   195: aload 5
    //   197: astore_3
    //   198: goto -120 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramArrayOfByte	byte[]
    //   0	201	1	paramString	String
    //   50	13	2	i	int
    //   23	117	3	localObject1	Object
    //   168	1	3	localIOException	IOException
    //   188	10	3	arrayOfByte1	byte[]
    //   13	172	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   1	59	5	arrayOfByte2	byte[]
    //   69	7	5	localObject2	Object
    //   125	71	5	arrayOfByte3	byte[]
    //   4	21	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	69	finally
    //   35	42	69	finally
    //   44	51	69	finally
    //   57	66	69	finally
    //   108	127	69	finally
    //   131	135	156	java/io/IOException
    //   139	143	160	java/io/IOException
    //   148	153	164	java/io/IOException
    //   82	86	168	java/io/IOException
    //   90	94	172	java/io/IOException
    //   99	104	176	java/io/IOException
    //   6	15	180	finally
    //   15	24	192	finally
  }
  
  public static byte[] decodeData(byte[] paramArrayOfByte, String paramString1, String paramString2)
    throws IOException
  {
    Object localObject1 = null;
    ByteArrayOutputStream localByteArrayOutputStream;
    int i;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      if (!StringUtility.isNullOrEmpty(paramString1))
      {
        paramString1 = decode(new ByteArrayInputStream(paramArrayOfByte), paramString1);
        paramArrayOfByte = new byte[8192];
        for (;;)
        {
          i = paramString1.read(paramArrayOfByte, 0, 8192);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
        }
        if (paramString1 == null) {}
      }
    }
    finally
    {
      paramString1 = null;
      paramString2 = localObject1;
    }
    for (;;)
    {
      paramString1.close();
      if (paramString2 != null) {
        paramString2.close();
      }
      throw paramArrayOfByte;
      localByteArrayOutputStream.flush();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      for (;;)
      {
        if (!checkCharset(paramString2)) {
          if ((paramString2 == null) || (!paramString2.contains(","))) {
            break label345;
          }
        }
        label345:
        for (paramString1 = getRealCharset(paramString2);; paramString1 = null)
        {
          paramString1 = getCharsetFromContent(paramArrayOfByte, paramArrayOfByte.length, paramString1);
          Logger.log(5, "MimeUtility", "convert charset from " + paramString2 + " to " + paramString1);
          if ((!"utf-8".equalsIgnoreCase(paramString1)) && (checkCharset(paramString1)))
          {
            paramArrayOfByte = convertCharset(paramArrayOfByte, paramArrayOfByte.length, paramString1);
            if (0 != 0) {
              throw new NullPointerException();
            }
            if (0 != 0) {
              throw new NullPointerException();
            }
          }
          label217:
          do
          {
            return paramArrayOfByte;
            if (0 != 0) {
              throw new NullPointerException();
            }
          } while (0 == 0);
          throw new NullPointerException();
          paramArrayOfByte = new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte), paramString2);
          try
          {
            localByteArrayOutputStream.reset();
            paramString2 = new OutputStreamWriter(localByteArrayOutputStream, "utf-8");
          }
          finally
          {
            try
            {
              paramString1 = new char[8192];
              for (;;)
              {
                i = paramArrayOfByte.read(paramString1);
                if (i == -1) {
                  break;
                }
                paramString2.write(paramString1, 0, i);
              }
              paramString2.flush();
              paramString1 = localByteArrayOutputStream.toByteArray();
              if (paramArrayOfByte != null) {
                paramArrayOfByte.close();
              }
              paramArrayOfByte = paramString1;
              if (paramString2 == null) {
                break label217;
              }
              paramString2.close();
              return paramString1;
            }
            finally
            {
              paramString1 = paramArrayOfByte;
              paramArrayOfByte = localObject2;
            }
            paramString2 = finally;
            paramString1 = paramArrayOfByte;
            paramArrayOfByte = paramString2;
            paramString2 = localObject1;
          }
          break;
        }
      }
    }
  }
  
  private static String decodeInnerWords(String paramString)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      int j = paramString.indexOf("=?", i);
      Object localObject2;
      int k;
      if (j >= 0) {
        if (i < j) {
          if (j > i + 1)
          {
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              localStringBuilder.append(decodeWord((EncodeString)localObject1));
              localObject2 = null;
            }
            localStringBuilder.append(paramString.substring(i, j));
            localObject1 = localObject2;
            k = paramString.indexOf('?', j + 2);
            if (k >= 0) {
              break label132;
            }
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        label132:
        String str;
        if (i == 0)
        {
          return paramString;
          localObject2 = paramString.substring(i, j);
          if (!" ".equals(localObject2)) {
            localStringBuilder.append((String)localObject2);
          }
          break;
          k = paramString.indexOf('?', k + 1);
          localObject2 = localObject1;
          if (k < 0) {
            continue;
          }
          k = paramString.indexOf("?=", k + 1);
          localObject2 = localObject1;
          if (k < 0) {
            continue;
          }
          str = paramString.substring(j, k + 2);
          try
          {
            localObject2 = decodeWord(str);
            if ((localObject1 != null) && (((EncodeString)localObject1).isSameEncode((EncodeString)localObject2)))
            {
              i = ((EncodeString)localObject1).getDecodingBytesCnt() + ((EncodeString)localObject2).getDecodingBytesCnt();
              byte[] arrayOfByte = new byte[i];
              if (((EncodeString)localObject1).getDecodingBytes() != null) {
                System.arraycopy(((EncodeString)localObject1).getDecodingBytes(), 0, arrayOfByte, 0, ((EncodeString)localObject1).getDecodingBytesCnt());
              }
              if (((EncodeString)localObject2).getDecodingBytes() != null) {
                System.arraycopy(((EncodeString)localObject2).getDecodingBytes(), 0, arrayOfByte, ((EncodeString)localObject1).getDecodingBytesCnt(), ((EncodeString)localObject2).getDecodingBytesCnt());
              }
              ((EncodeString)localObject2).setDecodingBytes(arrayOfByte, i);
              localObject1 = localObject2;
            }
            else
            {
              localStringBuilder.append(decodeWord((EncodeString)localObject1));
              localObject1 = localObject2;
            }
          }
          catch (MessageException localMessageException)
          {
            if (localObject1 == null) {
              break label378;
            }
          }
          localStringBuilder.append(decodeWord((EncodeString)localObject1));
          localObject1 = null;
        }
        label378:
        for (;;)
        {
          localStringBuilder.append(str);
          break;
          if (localMessageException != null) {
            localStringBuilder.append(decodeWord(localMessageException));
          }
          if (i < paramString.length()) {
            localStringBuilder.append(paramString.substring(i));
          }
          return localStringBuilder.toString();
        }
        Object localObject3 = localObject1;
      }
      i = k + 2;
    }
  }
  
  public static String decodeText(String paramString)
    throws IOException
  {
    return decodeText(paramString, null);
  }
  
  public static String decodeText(String paramString1, String paramString2)
    throws IOException
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return paramString1;
    }
    if (!paramString1.contains("=?"))
    {
      if (paramString2 != null) {}
      for (paramString1 = paramString1.getBytes(paramString2);; paramString1 = ASCIIUtility.getBytes(paramString1)) {
        return new String(decodeData(paramString1, null, ""), "utf-8");
      }
    }
    return decodeInnerWords(paramString1);
  }
  
  /* Error */
  private static EncodeString decodeWord(String paramString)
    throws MessageException, UnsupportedEncodingException
  {
    // Byte code:
    //   0: new 443	com/tencent/moai/mailsdk/model/EncodeString
    //   3: dup
    //   4: invokespecial 480	com/tencent/moai/mailsdk/model/EncodeString:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: ldc_w 416
    //   13: invokevirtual 483	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   16: ifne +32 -> 48
    //   19: new 414	com/tencent/moai/mailsdk/exception/MessageException
    //   22: dup
    //   23: iconst_2
    //   24: new 371	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 485
    //   34: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 488	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   47: athrow
    //   48: aload_0
    //   49: bipush 63
    //   51: iconst_2
    //   52: invokevirtual 430	java/lang/String:indexOf	(II)I
    //   55: istore_1
    //   56: iload_1
    //   57: iconst_m1
    //   58: if_icmpne +32 -> 90
    //   61: new 414	com/tencent/moai/mailsdk/exception/MessageException
    //   64: dup
    //   65: iconst_2
    //   66: new 371	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 490
    //   76: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 488	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   89: athrow
    //   90: aload_0
    //   91: iconst_2
    //   92: iload_1
    //   93: invokevirtual 428	java/lang/String:substring	(II)Ljava/lang/String;
    //   96: astore 4
    //   98: aload 4
    //   100: bipush 42
    //   102: invokevirtual 493	java/lang/String:indexOf	(I)I
    //   105: istore_2
    //   106: aload 4
    //   108: astore_3
    //   109: iload_2
    //   110: iflt +11 -> 121
    //   113: aload 4
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 428	java/lang/String:substring	(II)Ljava/lang/String;
    //   120: astore_3
    //   121: aload_3
    //   122: invokestatic 496	com/tencent/moai/mailsdk/util/MimeUtility:javaCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_3
    //   126: aload 5
    //   128: aload_3
    //   129: invokevirtual 500	com/tencent/moai/mailsdk/model/EncodeString:setCharset	(Ljava/lang/String;)V
    //   132: iload_1
    //   133: iconst_1
    //   134: iadd
    //   135: istore_1
    //   136: aload_0
    //   137: bipush 63
    //   139: iload_1
    //   140: invokevirtual 430	java/lang/String:indexOf	(II)I
    //   143: istore_2
    //   144: iload_2
    //   145: iconst_m1
    //   146: if_icmpne +32 -> 178
    //   149: new 414	com/tencent/moai/mailsdk/exception/MessageException
    //   152: dup
    //   153: iconst_2
    //   154: new 371	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 502
    //   164: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 488	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   177: athrow
    //   178: aload_0
    //   179: iload_1
    //   180: iload_2
    //   181: invokevirtual 428	java/lang/String:substring	(II)Ljava/lang/String;
    //   184: astore 6
    //   186: aload 5
    //   188: aload 6
    //   190: invokevirtual 505	com/tencent/moai/mailsdk/model/EncodeString:setEncoding	(Ljava/lang/String;)V
    //   193: iload_2
    //   194: iconst_1
    //   195: iadd
    //   196: istore_1
    //   197: aload_0
    //   198: ldc_w 438
    //   201: iload_1
    //   202: invokevirtual 420	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   205: istore_2
    //   206: iload_2
    //   207: iconst_m1
    //   208: if_icmpne +32 -> 240
    //   211: new 414	com/tencent/moai/mailsdk/exception/MessageException
    //   214: dup
    //   215: iconst_2
    //   216: new 371	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 507
    //   226: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 488	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   239: athrow
    //   240: aload_0
    //   241: iload_1
    //   242: iload_2
    //   243: invokevirtual 428	java/lang/String:substring	(II)Ljava/lang/String;
    //   246: astore_0
    //   247: aload 5
    //   249: aload_0
    //   250: invokevirtual 510	com/tencent/moai/mailsdk/model/EncodeString:setContent	(Ljava/lang/String;)V
    //   253: aload_0
    //   254: invokevirtual 242	java/lang/String:length	()I
    //   257: ifle +136 -> 393
    //   260: new 320	java/io/ByteArrayInputStream
    //   263: dup
    //   264: aload_0
    //   265: invokestatic 475	com/tencent/moai/mailsdk/util/ASCIIUtility:getBytes	(Ljava/lang/String;)[B
    //   268: invokespecial 323	java/io/ByteArrayInputStream:<init>	([B)V
    //   271: astore 4
    //   273: aload 6
    //   275: ldc_w 272
    //   278: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   281: ifeq +42 -> 323
    //   284: new 291	com/tencent/moai/mailsdk/util/stream/BASE64DecoderStream
    //   287: dup
    //   288: aload 4
    //   290: invokespecial 294	com/tencent/moai/mailsdk/util/stream/BASE64DecoderStream:<init>	(Ljava/io/InputStream;)V
    //   293: astore_0
    //   294: aload 4
    //   296: invokevirtual 513	java/io/ByteArrayInputStream:available	()I
    //   299: istore_1
    //   300: iload_1
    //   301: newarray byte
    //   303: astore 4
    //   305: aload 5
    //   307: aload 4
    //   309: aload_0
    //   310: aload 4
    //   312: iconst_0
    //   313: iload_1
    //   314: invokevirtual 227	java/io/InputStream:read	([BII)I
    //   317: invokevirtual 463	com/tencent/moai/mailsdk/model/EncodeString:setDecodingBytes	([BI)V
    //   320: aload 5
    //   322: areturn
    //   323: aload 6
    //   325: ldc_w 267
    //   328: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   331: ifeq +19 -> 350
    //   334: new 515	com/tencent/moai/mailsdk/util/stream/QDecoderStream
    //   337: dup
    //   338: aload 4
    //   340: invokespecial 516	com/tencent/moai/mailsdk/util/stream/QDecoderStream:<init>	(Ljava/io/InputStream;)V
    //   343: astore_0
    //   344: goto -50 -> 294
    //   347: astore_0
    //   348: aload_0
    //   349: athrow
    //   350: new 263	java/io/UnsupportedEncodingException
    //   353: dup
    //   354: new 371	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 518
    //   364: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 6
    //   369: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokespecial 520	java/io/UnsupportedEncodingException:<init>	(Ljava/lang/String;)V
    //   378: athrow
    //   379: astore_0
    //   380: new 414	com/tencent/moai/mailsdk/exception/MessageException
    //   383: dup
    //   384: iconst_2
    //   385: aload_0
    //   386: invokevirtual 521	java/io/IOException:toString	()Ljava/lang/String;
    //   389: invokespecial 488	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   392: athrow
    //   393: aload 5
    //   395: areturn
    //   396: astore_0
    //   397: new 263	java/io/UnsupportedEncodingException
    //   400: dup
    //   401: aload_3
    //   402: invokespecial 520	java/io/UnsupportedEncodingException:<init>	(Ljava/lang/String;)V
    //   405: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramString	String
    //   55	259	1	i	int
    //   105	138	2	j	int
    //   108	294	3	localObject1	Object
    //   96	243	4	localObject2	Object
    //   7	387	5	localEncodeString	EncodeString
    //   184	184	6	str	String
    // Exception table:
    //   from	to	target	type
    //   253	294	347	java/io/UnsupportedEncodingException
    //   294	320	347	java/io/UnsupportedEncodingException
    //   323	344	347	java/io/UnsupportedEncodingException
    //   350	379	347	java/io/UnsupportedEncodingException
    //   253	294	379	java/io/IOException
    //   294	320	379	java/io/IOException
    //   323	344	379	java/io/IOException
    //   350	379	379	java/io/IOException
    //   253	294	396	java/lang/IllegalArgumentException
    //   294	320	396	java/lang/IllegalArgumentException
    //   323	344	396	java/lang/IllegalArgumentException
    //   350	379	396	java/lang/IllegalArgumentException
  }
  
  public static String decodeWord(EncodeString paramEncodeString)
    throws UnsupportedEncodingException
  {
    if (paramEncodeString == null) {
      return "";
    }
    int i = paramEncodeString.getDecodingBytesCnt();
    String str = paramEncodeString.getCharset();
    byte[] arrayOfByte = paramEncodeString.getDecodingBytes();
    paramEncodeString = str;
    if (!checkCharset(str)) {
      if ((str == null) || (!str.contains(","))) {
        break label162;
      }
    }
    label162:
    for (paramEncodeString = getRealCharset(str);; paramEncodeString = str)
    {
      paramEncodeString = getCharsetFromContent(arrayOfByte, arrayOfByte.length, paramEncodeString);
      Logger.log(5, "MimeUtility", "convert charset from " + str + " to " + paramEncodeString);
      if (!"utf-8".equalsIgnoreCase(paramEncodeString)) {
        return new String(arrayOfByte, 0, arrayOfByte.length, paramEncodeString);
      }
      if (checkCharset(paramEncodeString))
      {
        if (i <= 0) {
          return "";
        }
        return new String(arrayOfByte, 0, i, paramEncodeString);
      }
      if (i <= 0) {
        return "";
      }
      return new String(arrayOfByte, 0, i, "utf-8");
    }
  }
  
  private static void doEncode(String paramString1, boolean paramBoolean1, String paramString2, int paramInt, String paramString3, boolean paramBoolean2, boolean paramBoolean3, StringBuffer paramStringBuffer)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = paramString1.getBytes(paramString2);
    if (paramBoolean1) {
      BEncoderStream.encodedLength(arrayOfByte);
    }
    for (;;)
    {
      paramString2 = new ByteArrayOutputStream();
      if (paramBoolean1) {
        paramString1 = new BEncoderStream(paramString2);
      }
      try
      {
        for (;;)
        {
          paramString1.write(arrayOfByte);
          paramString1.close();
          label48:
          paramString1 = paramString2.toByteArray();
          if (!paramBoolean2) {
            paramStringBuffer.append(" ");
          }
          paramStringBuffer.append(paramString3);
          paramInt = 0;
          while (paramInt < paramString1.length)
          {
            paramStringBuffer.append((char)paramString1[paramInt]);
            paramInt += 1;
          }
          QEncoderStream.encodedLength(arrayOfByte, paramBoolean3);
          break;
          paramString1 = new QEncoderStream(paramString2, paramBoolean3);
        }
        paramStringBuffer.append("?=");
        return;
      }
      catch (IOException paramString1)
      {
        break label48;
      }
    }
  }
  
  public static OutputStream encode(OutputStream paramOutputStream, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return paramOutputStream;
      if (paramString.equalsIgnoreCase("base64")) {
        return new BASE64EncoderStream(paramOutputStream);
      }
      if (paramString.equalsIgnoreCase("quoted-printable")) {
        return new QPEncoderStream(paramOutputStream);
      }
      if ((paramString.equalsIgnoreCase("uuencode")) || (paramString.equalsIgnoreCase("x-uuencode")) || (paramString.equalsIgnoreCase("x-uue"))) {
        return new UUEncoderStream(paramOutputStream);
      }
    } while ((paramString.equalsIgnoreCase("binary")) || (paramString.equalsIgnoreCase("7bit")) || (!paramString.equalsIgnoreCase("8bit")));
    return paramOutputStream;
  }
  
  public static String encodeAddress(String paramString)
    throws UnsupportedEncodingException
  {
    return encodeWord(paramString, null, "B", false);
  }
  
  public static String encodeText(String paramString)
    throws UnsupportedEncodingException
  {
    return encodeText(paramString, null, null);
  }
  
  private static String encodeText(String paramString1, String paramString2, String paramString3)
    throws UnsupportedEncodingException
  {
    return checkWord(paramString1, paramString2, paramString3, false);
  }
  
  private static String encodeWord(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws UnsupportedEncodingException
  {
    String str;
    if (paramString2 == null)
    {
      str = getDefaultJavaCharset();
      paramString2 = getDefaultMIMECharset();
      if (!paramString3.equalsIgnoreCase("B")) {
        break label105;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      doEncode(paramString1, bool, str, 68 - paramString2.length(), "=?" + paramString2 + "?" + paramString3 + "?", true, paramBoolean, localStringBuffer);
      return localStringBuffer.toString();
      str = javaCharset(paramString2);
      break;
      label105:
      if (!paramString3.equalsIgnoreCase("Q")) {
        break label121;
      }
    }
    label121:
    throw new UnsupportedEncodingException("Unknown transfer encoding: " + paramString3);
  }
  
  public static String fold(int paramInt, String paramString)
  {
    int j = paramString.length() - 1;
    String str;
    for (;;)
    {
      if (j >= 0)
      {
        k = paramString.charAt(j);
        if ((k == 32) || (k == 9) || (k == 13) || (k == 10)) {}
      }
      else
      {
        str = paramString;
        if (j != paramString.length() - 1) {
          str = paramString.substring(0, j + 1);
        }
        if (str.length() + paramInt > 76) {
          break;
        }
        return makesafe(str);
      }
      j -= 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 4);
    int k = 0;
    j = paramInt;
    int i;
    for (paramInt = k;; paramInt = i)
    {
      paramString = str;
      int n;
      int m;
      if (str.length() + j > 76)
      {
        k = -1;
        n = 0;
        m = paramInt;
        paramInt = n;
      }
      for (;;)
      {
        if ((paramInt >= str.length()) || ((k != -1) && (j + paramInt > 76)))
        {
          if (k != -1) {
            break;
          }
          localStringBuilder.append(str);
          paramString = "";
          localStringBuilder.append(paramString);
          return makesafe(localStringBuilder);
        }
        int i1 = str.charAt(paramInt);
        if (i1 != 32)
        {
          n = k;
          if (i1 != 9) {}
        }
        else
        {
          n = k;
          if (m != 32)
          {
            n = k;
            if (m != 9) {
              n = paramInt;
            }
          }
        }
        paramInt += 1;
        m = i1;
        k = n;
      }
      localStringBuilder.append(str.substring(0, k));
      localStringBuilder.append("\r\n");
      i = str.charAt(k);
      localStringBuilder.append(i);
      str = str.substring(k + 1);
      j = 1;
    }
  }
  
  public static String getCharset(String paramString)
  {
    try
    {
      String str = new ContentType(paramString).getParam(MimeDefine.CHARSET);
      paramString = str;
      if (str == null) {
        paramString = MimeDefine.X_UNKNOWN;
      }
      paramString = javaCharset(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return MimeDefine.X_UNKNOWN;
  }
  
  private static String getCharsetFromContent(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    paramInt = tellCharsetEx(paramArrayOfByte, paramInt);
    if (paramInt > 0) {
      paramString = CHARSETS[paramInt];
    }
    return paramString;
  }
  
  public static String getCharsetFromContentParam(String paramString)
  {
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      paramString = paramString.toLowerCase(Locale.ENGLISH);
      int j = paramString.indexOf("\"charset\"");
      if (j != -1)
      {
        int i = paramString.indexOf("\"", j + 9);
        if (i == j + 10)
        {
          j = paramString.indexOf("\"", i + 1);
          if (j == -1) {
            return "";
          }
          return paramString.substring(i + 1, j);
        }
        i = paramString.indexOf('{', j + 9);
        if (i != -1)
        {
          j = paramString.indexOf('}', i + 1);
          if (j == -1) {
            return "";
          }
          try
          {
            i = Integer.parseInt(paramString.substring(i + 1, j));
            if ((i > 0) && (j + i < paramString.length()))
            {
              String str = paramString.substring(j + 1);
              paramString = str;
              if (str.charAt(0) == '\r')
              {
                paramString = str;
                if (str.charAt(1) == '\n') {
                  paramString = str.substring(2);
                }
              }
              if (paramString.length() >= i) {
                return paramString.substring(0, i);
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Logger.log(5, "MimeUtility", localException.getMessage());
              i = 0;
            }
          }
        }
      }
    }
    return MimeDefine.X_UNKNOWN;
  }
  
  public static String getContentDisposition(MimePart paramMimePart)
  {
    Object localObject = null;
    String str = paramMimePart.getDisposition();
    paramMimePart = localObject;
    if (str != null) {}
    try
    {
      paramMimePart = new ContentDisposition(str).getDisposition();
      return paramMimePart;
    }
    catch (MessageException paramMimePart)
    {
      Logger.osslog(new Object[] { "parse_exception", paramMimePart.getMessage() });
    }
    return null;
  }
  
  public static String getContentType(MimePart paramMimePart)
  {
    Object localObject = null;
    String str = paramMimePart.getContentType();
    paramMimePart = localObject;
    if (str != null) {}
    try
    {
      paramMimePart = new ContentType(str).getType();
      return paramMimePart;
    }
    catch (MessageException paramMimePart)
    {
      Logger.osslog(new Object[] { "parse_exception", paramMimePart.getMessage() });
    }
    return null;
  }
  
  public static String getContentType(File paramFile)
  {
    return MimeDefine.APPLICATION_OCTET_STREAM;
  }
  
  public static String getDefaultJavaCharset()
  {
    Object localObject;
    if (defaultJavaCharset == null) {
      localObject = null;
    }
    try
    {
      String str = System.getProperty("mail.mime.charset");
      localObject = str;
    }
    catch (SecurityException localSecurityException2)
    {
      label17:
      break label17;
    }
    if ((localObject != null) && (localObject.length() > 0))
    {
      defaultJavaCharset = javaCharset(localObject);
      return defaultJavaCharset;
    }
    try
    {
      defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
      return defaultJavaCharset;
    }
    catch (SecurityException localSecurityException1)
    {
      for (;;)
      {
        defaultJavaCharset = new InputStreamReader(new MimeUtility.1NullInputStream()).getEncoding();
        if (defaultJavaCharset == null) {
          defaultJavaCharset = "8859_1";
        }
      }
    }
  }
  
  public static String getDefaultMIMECharset()
  {
    if (defaultMIMECharset == null) {}
    try
    {
      defaultMIMECharset = System.getProperty("mail.mime.charset");
      label15:
      if (defaultMIMECharset == null) {
        defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
      }
      return defaultMIMECharset;
    }
    catch (SecurityException localSecurityException)
    {
      break label15;
    }
  }
  
  public static String getFileName(MimePart paramMimePart)
  {
    Object localObject3 = null;
    String str = paramMimePart.getDisposition();
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      localObject1 = new ContentDisposition(str).getParam(MimeDefine.FILE_NAME);
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        paramMimePart = paramMimePart.getContentType();
        localObject3 = localObject1;
        if (paramMimePart == null) {}
      }
      try
      {
        localObject3 = new ContentType(paramMimePart).getParam(MimeDefine.NAME);
        return localObject3;
      }
      catch (MessageException paramMimePart)
      {
        return localObject1;
      }
    }
    catch (MessageException localMessageException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private static String getRealCharset(String paramString)
  {
    Object localObject1 = null;
    String[] arrayOfString = paramString.split(",");
    int j = arrayOfString.length;
    int i = 0;
    paramString = null;
    Object localObject2;
    if (i < j)
    {
      localObject2 = arrayOfString[i];
      if (!checkCharset((String)localObject2)) {
        break label93;
      }
      if (localObject1 == null)
      {
        paramString = Charset.forName((String)localObject2);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      i += 1;
      localObject2 = localObject1;
      localObject1 = paramString;
      paramString = (String)localObject2;
      break;
      Charset localCharset = Charset.forName((String)localObject2);
      if (localCharset.contains((Charset)localObject1))
      {
        localObject1 = localObject2;
        paramString = localCharset;
        continue;
        return paramString;
      }
      else
      {
        label93:
        localObject2 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  private static int indexOfAny(String paramString1, String paramString2)
  {
    return indexOfAny(paramString1, paramString2, 0);
  }
  
  private static int indexOfAny(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      int i = paramString1.length();
      while (paramInt < i)
      {
        int j = paramString2.indexOf(paramString1.charAt(paramInt));
        if (j >= 0) {
          return paramInt;
        }
        paramInt += 1;
      }
      return -1;
    }
    catch (StringIndexOutOfBoundsException paramString1) {}
    return -1;
  }
  
  public static boolean isTextDataPart(String paramString)
  {
    return (paramString == null) || (paramString.equalsIgnoreCase(MimeDefine.TEXT_PLAIN)) || (paramString.equalsIgnoreCase(MimeDefine.TEXT_HTML)) || (paramString.equals(MimeDefine.TEXT_CALENDAR));
  }
  
  private static int isUTF8(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt <= 0)) {}
    label12:
    label162:
    for (;;)
    {
      return -1;
      int j = 0;
      int i;
      for (;;)
      {
        if (j >= paramInt) {
          break label164;
        }
        i = paramArrayOfByte[j] & 0xFF;
        if (i >= 127) {
          break;
        }
        j += 1;
      }
      if ((i >= 192) && (i <= 253))
      {
        if (i >= 252) {
          i = 5;
        }
        for (;;)
        {
          if (j + i > paramInt) {
            break label162;
          }
          int k = j + 1;
          int m = 0;
          for (;;)
          {
            j = k;
            if (m >= i) {
              break label12;
            }
            j = paramArrayOfByte[k] & 0xFF;
            if ((j < 128) || (j > 191)) {
              break;
            }
            k += 1;
            m += 1;
          }
          if (i >= 248) {
            i = 4;
          } else if (i >= 240) {
            i = 3;
          } else if (i >= 224) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
    }
    label164:
    return 0;
  }
  
  public static String javaCharset(String paramString)
  {
    if ((mime2java == null) || (paramString == null)) {}
    String str;
    do
    {
      return paramString;
      str = (String)mime2java.get(paramString.toLowerCase(Locale.ENGLISH));
    } while (str == null);
    return str;
  }
  
  private static String makesafe(CharSequence paramCharSequence)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramCharSequence.length())
      {
        int j = paramCharSequence.charAt(i);
        if ((j != 13) && (j != 10)) {}
      }
      else
      {
        if (i != paramCharSequence.length()) {
          break;
        }
        return paramCharSequence.toString();
      }
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() + 1);
    BufferedReader localBufferedReader = new BufferedReader(new StringReader(paramCharSequence.toString()));
    for (;;)
    {
      String str;
      try
      {
        str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.trim().length() == 0) {
          continue;
        }
        if (localStringBuilder.length() <= 0) {
          break label188;
        }
        localStringBuilder.append("\r\n");
        if ((!$assertionsDisabled) && (str.length() <= 0)) {
          throw new AssertionError();
        }
      }
      catch (IOException localIOException)
      {
        return paramCharSequence.toString();
      }
      i = str.charAt(0);
      if ((i != 32) && (i != 9)) {
        localIOException.append(' ');
      }
      label188:
      localIOException.append(str);
    }
    return localIOException.toString();
  }
  
  public static String mimeCharset(String paramString)
  {
    if ((java2mime == null) || (paramString == null)) {}
    String str;
    do
    {
      return paramString;
      str = (String)java2mime.get(paramString.toLowerCase(Locale.ENGLISH));
    } while (str == null);
    return str;
  }
  
  /* Error */
  private static boolean nonAsciiCharset(ContentType paramContentType)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ldc_w 770
    //   6: invokevirtual 615	com/tencent/moai/mailsdk/protocol/mime/ContentType:getParam	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getstatic 629	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   20: invokevirtual 633	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   23: astore_3
    //   24: getstatic 55	com/tencent/moai/mailsdk/util/MimeUtility:nonAsciiCharsetMap	Ljava/util/Map;
    //   27: astore_0
    //   28: aload_0
    //   29: monitorenter
    //   30: getstatic 55	com/tencent/moai/mailsdk/util/MimeUtility:nonAsciiCharsetMap	Ljava/util/Map;
    //   33: aload_3
    //   34: invokeinterface 741 2 0
    //   39: checkcast 772	java/lang/Boolean
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: astore_0
    //   47: aload_2
    //   48: ifnonnull +60 -> 108
    //   51: ldc_w 599
    //   54: aload_3
    //   55: invokevirtual 282	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   58: astore_0
    //   59: aload_0
    //   60: arraylength
    //   61: iconst_2
    //   62: if_icmpne +77 -> 139
    //   65: aload_0
    //   66: iconst_0
    //   67: baload
    //   68: bipush 13
    //   70: if_icmpne +69 -> 139
    //   73: aload_0
    //   74: iconst_1
    //   75: baload
    //   76: bipush 10
    //   78: if_icmpeq +6 -> 84
    //   81: goto +58 -> 139
    //   84: iload_1
    //   85: invokestatic 776	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   88: astore_0
    //   89: getstatic 55	com/tencent/moai/mailsdk/util/MimeUtility:nonAsciiCharsetMap	Ljava/util/Map;
    //   92: astore_2
    //   93: aload_2
    //   94: monitorenter
    //   95: getstatic 55	com/tencent/moai/mailsdk/util/MimeUtility:nonAsciiCharsetMap	Ljava/util/Map;
    //   98: aload_3
    //   99: aload_0
    //   100: invokeinterface 75 3 0
    //   105: pop
    //   106: aload_2
    //   107: monitorexit
    //   108: aload_0
    //   109: invokevirtual 779	java/lang/Boolean:booleanValue	()Z
    //   112: ireturn
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: astore_0
    //   119: getstatic 783	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   122: astore_0
    //   123: goto -34 -> 89
    //   126: astore_0
    //   127: getstatic 786	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   130: astore_0
    //   131: goto -42 -> 89
    //   134: astore_0
    //   135: aload_2
    //   136: monitorexit
    //   137: aload_0
    //   138: athrow
    //   139: iconst_1
    //   140: istore_1
    //   141: goto -57 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContentType	ContentType
    //   1	140	1	bool	boolean
    //   113	23	2	localObject2	Object
    //   23	76	3	str	String
    // Exception table:
    //   from	to	target	type
    //   30	45	113	finally
    //   114	116	113	finally
    //   51	65	118	java/io/UnsupportedEncodingException
    //   51	65	126	java/lang/RuntimeException
    //   95	108	134	finally
    //   135	137	134	finally
  }
  
  private static final boolean nonascii(int paramInt)
  {
    return (paramInt >= 127) || ((paramInt < 32) && (paramInt != 13) && (paramInt != 10) && (paramInt != 9));
  }
  
  public static String quote(String paramString1, String paramString2)
  {
    int j;
    if (paramString1 == null)
    {
      j = 0;
      if (j != 0) {
        break label27;
      }
      paramString2 = "\"\"";
    }
    label27:
    int k;
    do
    {
      return paramString2;
      j = paramString1.length();
      break;
      int i = 0;
      k = 0;
      while (i < j)
      {
        int m = paramString1.charAt(i);
        if ((m == 34) || (m == 92) || (m == 13) || (m == 10))
        {
          paramString2 = new StringBuilder(j + 3);
          paramString2.append('"');
          paramString2.append(paramString1.substring(0, i));
          k = 0;
          if (i < j)
          {
            char c = paramString1.charAt(i);
            if (((c != '"') && (c != '\\') && (c != '\r') && (c != '\n')) || ((c == '\n') && (k == 13))) {}
            for (;;)
            {
              paramString2.append(c);
              i += 1;
              k = c;
              break;
              paramString2.append('\\');
            }
          }
          paramString2.append('"');
          return paramString2.toString();
        }
        if ((m < 32) || (m >= 127) || (paramString2.indexOf(m) >= 0)) {
          k = 1;
        }
        i += 1;
      }
      paramString2 = paramString1;
    } while (k == 0);
    return "\"" + paramString1 + '"';
  }
  
  private static int tellCharsetEx(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1)) {
      return -1;
    }
    int i2 = 0;
    int j = 0;
    int m = 0;
    int i1 = 0;
    int n = 0;
    int i = 0;
    int k;
    int i10;
    int i4;
    for (int i8 = 0;; i8 = k)
    {
      if ((i8 >= paramInt - 2) || (i2 > 1000))
      {
        if (i2 != 0) {
          break label595;
        }
        return 7;
      }
      k = 0;
      i10 = (short)paramArrayOfByte[i8] & 0xFF;
      i4 = (short)paramArrayOfByte[(i8 + 1)] & 0xFF;
      if (i10 > 128) {
        break;
      }
      k = i8 + 1;
      i4 = j;
      j = i;
      i = j;
      j = i4;
    }
    int i3 = i;
    int i9 = k;
    if (i10 >= 160)
    {
      i3 = i;
      i9 = k;
      if (i10 <= 255) {
        if ((i4 < 65) || (i4 > 90))
        {
          i3 = i;
          i9 = k;
          if (i4 >= 97)
          {
            i3 = i;
            i9 = k;
            if (i4 > 122) {}
          }
        }
        else
        {
          i3 = i + 1;
          i9 = 1;
        }
      }
    }
    int i6;
    int i5;
    int i7;
    if (((i10 >= 129) && (i10 <= 159) && (i4 >= 64) && (i4 <= 252)) || ((i10 >= 224) && (i10 <= 252) && (i4 >= 127) && (i4 <= 160)))
    {
      i6 = i1 + 1;
      k = i3 + 1;
      i = i2 + 1;
      i4 = j;
      i5 = m;
      i7 = n;
    }
    for (;;)
    {
      i3 = i8 + 2;
      j = k;
      n = i7;
      i1 = i6;
      m = i5;
      i2 = i;
      k = i3;
      break;
      if ((i10 >= 161) && (i10 <= 254) && (i4 >= 64) && (i4 <= 126))
      {
        i7 = n + 1;
        i = i2 + 1;
        k = i3;
        i6 = i1;
        i5 = m;
        i4 = j;
      }
      else if ((i4 >= 161) && (i4 <= 254))
      {
        i9 = i2 + 1;
        i2 = j;
        if (i10 >= 176)
        {
          i2 = j;
          if (i10 <= 200) {
            i2 = j + 1;
          }
        }
        k = i3;
        i7 = n;
        i6 = i1;
        i5 = m;
        i4 = i2;
        i = i9;
        if (i10 >= 176)
        {
          k = i3;
          i7 = n;
          i6 = i1;
          i5 = m;
          i4 = i2;
          i = i9;
          if (i10 <= 214)
          {
            i5 = m + 1;
            k = i3;
            i7 = n;
            i6 = i1;
            i4 = i2;
            i = i9;
          }
        }
      }
      else
      {
        k = i3;
        i7 = n;
        i6 = i1;
        i5 = m;
        i4 = j;
        i = i2;
        if (i9 == 0)
        {
          k = i3 + 1;
          i7 = n;
          i6 = i1;
          i5 = m;
          i4 = j;
          i = i2;
        }
      }
    }
    label595:
    float f1 = i / i2;
    float f2 = i1 / i2;
    float f3 = n / i2;
    float f4 = j / i2;
    float f5 = m / i2;
    if (isUTF8(paramArrayOfByte, paramInt) == 0) {
      return 1;
    }
    if ((f1 >= f3) && (f1 >= f2) && (f1 >= f5) && (f1 > 0.1D)) {
      return 6;
    }
    if (f5 > 0.95D) {
      return 3;
    }
    if ((f3 > 0.1D) && (f3 > f5)) {
      return 2;
    }
    if (f2 > 0.1D) {
      return 5;
    }
    if (f4 > 0.9D) {
      return 4;
    }
    return 3;
  }
  
  public static String unfold(String paramString)
  {
    Object localObject1 = null;
    for (;;)
    {
      int k = indexOfAny(paramString, "\r\n");
      if (k < 0) {
        break;
      }
      int m = paramString.length();
      int j = k + 1;
      int i = j;
      if (j < m)
      {
        i = j;
        if (paramString.charAt(j - 1) == '\r')
        {
          i = j;
          if (paramString.charAt(j) == '\n') {
            i = j + 1;
          }
        }
      }
      if ((k == 0) || (paramString.charAt(k - 1) != '\\'))
      {
        if (i < m)
        {
          j = paramString.charAt(i);
          if ((j == 32) || (j == 9))
          {
            i += 1;
            while (i < m)
            {
              j = paramString.charAt(i);
              if ((j != 32) && (j != 9)) {
                break;
              }
              i += 1;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new StringBuilder(paramString.length());
            }
            if (k != 0)
            {
              ((StringBuilder)localObject2).append(paramString.substring(0, k));
              ((StringBuilder)localObject2).append(' ');
            }
            paramString = paramString.substring(i);
            localObject1 = localObject2;
            continue;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuilder(paramString.length());
        }
        ((StringBuilder)localObject2).append(paramString.substring(0, i));
        paramString = paramString.substring(i);
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuilder(paramString.length());
        }
        ((StringBuilder)localObject2).append(paramString.substring(0, k - 1));
        ((StringBuilder)localObject2).append(paramString.substring(k, i));
        paramString = paramString.substring(i);
        localObject1 = localObject2;
      }
    }
    Object localObject2 = paramString;
    if (localObject1 != null)
    {
      localObject1.append(paramString);
      localObject2 = localObject1.toString();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.MimeUtility
 * JD-Core Version:    0.7.0.1
 */