package com.tencent.open.base;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
import hps;
import hpt;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MD5Utils
{
  protected static Comparator a;
  protected static List a;
  protected static Comparator b;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new hpt();
    b = new hps();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static String a(String paramString)
  {
    return HexUtil.a(a(paramString));
  }
  
  /* Error */
  protected static byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 52	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: new 54	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 61	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 63	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_2
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_0
    //   39: aload_2
    //   40: aload_0
    //   41: invokevirtual 70	java/io/FileInputStream:read	([B)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +26 -> 73
    //   50: aload_3
    //   51: aload_0
    //   52: iconst_0
    //   53: iload_1
    //   54: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   57: goto -18 -> 39
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   65: aload_2
    //   66: invokevirtual 80	java/io/FileInputStream:close	()V
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: areturn
    //   73: aload_3
    //   74: invokevirtual 84	java/security/MessageDigest:digest	()[B
    //   77: astore_0
    //   78: aload_2
    //   79: invokevirtual 80	java/io/FileInputStream:close	()V
    //   82: goto -11 -> 71
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   90: goto -19 -> 71
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -36 -> 71
    //   110: astore_0
    //   111: aload_2
    //   112: invokevirtual 80	java/io/FileInputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 86	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   129: goto -14 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   44	10	1	i	int
    //   32	47	2	localFileInputStream	java.io.FileInputStream
    //   85	27	2	localIOException1	java.io.IOException
    //   124	2	2	localIOException2	java.io.IOException
    //   5	69	3	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   39	45	60	java/io/IOException
    //   50	57	60	java/io/IOException
    //   73	78	60	java/io/IOException
    //   78	82	85	java/io/IOException
    //   0	22	93	java/io/FileNotFoundException
    //   24	39	93	java/io/FileNotFoundException
    //   65	69	93	java/io/FileNotFoundException
    //   78	82	93	java/io/FileNotFoundException
    //   86	90	93	java/io/FileNotFoundException
    //   101	105	93	java/io/FileNotFoundException
    //   111	115	93	java/io/FileNotFoundException
    //   115	117	93	java/io/FileNotFoundException
    //   125	129	93	java/io/FileNotFoundException
    //   65	69	100	java/io/IOException
    //   39	45	110	finally
    //   50	57	110	finally
    //   61	65	110	finally
    //   73	78	110	finally
    //   0	22	117	java/security/NoSuchAlgorithmException
    //   24	39	117	java/security/NoSuchAlgorithmException
    //   65	69	117	java/security/NoSuchAlgorithmException
    //   78	82	117	java/security/NoSuchAlgorithmException
    //   86	90	117	java/security/NoSuchAlgorithmException
    //   101	105	117	java/security/NoSuchAlgorithmException
    //   111	115	117	java/security/NoSuchAlgorithmException
    //   115	117	117	java/security/NoSuchAlgorithmException
    //   125	129	117	java/security/NoSuchAlgorithmException
    //   111	115	124	java/io/IOException
  }
  
  protected static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = HexUtil.a(a(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString).listFiles();
    if (paramString == null) {
      return "";
    }
    Arrays.sort(paramString, b);
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      localIterator = paramString[i];
      if (localIterator.isFile()) {
        jdField_a_of_type_JavaUtilList.add(a(localIterator.getAbsolutePath()));
      }
      for (;;)
      {
        i += 1;
        break;
        c(localIterator.getAbsolutePath());
      }
    }
    Collections.sort(jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
    paramString = new StringBuilder();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      paramString.append((String)localIterator.next());
    }
    jdField_a_of_type_JavaUtilList.clear();
    return b(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.MD5Utils
 * JD-Core Version:    0.7.0.1
 */