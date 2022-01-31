package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public abstract class RecordParams
{
  public static final byte a = 2;
  public static final int a = 0;
  private static QQRecorder.RecorderParam a;
  public static final String a = "RecordParams";
  public static final boolean a = false;
  public static final int[] a;
  public static final int b = 1;
  private static QQRecorder.RecorderParam b = new QQRecorder.RecorderParam(k, 16000, 1);
  public static final String b = "SPD";
  public static final boolean b = true;
  public static final int c = 8;
  public static final String c = "#!SILK_V3";
  private static boolean c = false;
  public static final int d = 9;
  public static final String d = "#!SILK_V";
  private static final boolean d = true;
  public static final int e = 10;
  public static final String e = "#!AMR\n";
  public static final int f;
  public static final int g = 0;
  public static final int h = 10;
  public static final int i = 2;
  public static final int j = 20;
  private static final int k;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 8000, 12000, 16000, 24000, 36000, 44100, 48000 };
    f = jdField_a_of_type_ArrayOfInt[0];
    k = jdField_a_of_type_ArrayOfInt[2];
    c = false;
    jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(f, 8000, 0);
  }
  
  public static byte a(int paramInt)
  {
    int n;
    for (int m = 0; m < jdField_a_of_type_ArrayOfInt.length; n = (byte)(m + 1)) {
      if (paramInt == jdField_a_of_type_ArrayOfInt[m]) {
        return m;
      }
    }
    return -1;
  }
  
  public static byte a(InputStream paramInputStream)
  {
    byte b1 = -1;
    byte[] arrayOfByte = new byte[10];
    paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (a(arrayOfByte)) {
      b1 = arrayOfByte[0];
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "getSilkFs " + String.valueOf(PkgTools.c(arrayOfByte, 0, 10)));
    }
    return b1;
  }
  
  public static int a()
  {
    return a().length;
  }
  
  public static int a(byte paramByte)
  {
    int n = 0;
    int m = n;
    if (paramByte >= 0)
    {
      m = n;
      if (paramByte < jdField_a_of_type_ArrayOfInt.length) {
        m = jdField_a_of_type_ArrayOfInt[paramByte];
      }
    }
    return m;
  }
  
  public static int a(double paramDouble)
  {
    return QQRecorder.a(paramDouble);
  }
  
  public static int a(int paramInt)
  {
    return paramInt * 20 * 2 / 1000;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore_1
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: new 124	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: new 129	java/io/DataInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 132	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore 4
    //   34: iload_3
    //   35: istore_2
    //   36: bipush 10
    //   38: newarray byte
    //   40: astore 8
    //   42: iload_3
    //   43: istore_2
    //   44: aload 4
    //   46: aload 8
    //   48: invokevirtual 135	java/io/DataInputStream:read	([B)I
    //   51: aload 8
    //   53: arraylength
    //   54: if_icmpne +179 -> 233
    //   57: iload_3
    //   58: istore_2
    //   59: aload 8
    //   61: invokestatic 75	com/tencent/mobileqq/utils/RecordParams:a	([B)Z
    //   64: ifeq +5 -> 69
    //   67: iconst_1
    //   68: istore_1
    //   69: iload_1
    //   70: istore_2
    //   71: aload 4
    //   73: invokevirtual 138	java/io/DataInputStream:close	()V
    //   76: iload_1
    //   77: istore_2
    //   78: aload_0
    //   79: invokevirtual 139	java/io/FileInputStream:close	()V
    //   82: aconst_null
    //   83: astore_0
    //   84: aload 7
    //   86: astore 4
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 139	java/io/FileInputStream:close	()V
    //   96: iload_1
    //   97: istore_2
    //   98: aload 4
    //   100: ifnull +10 -> 110
    //   103: aload 4
    //   105: invokevirtual 138	java/io/DataInputStream:close	()V
    //   108: iload_1
    //   109: istore_2
    //   110: iload_2
    //   111: ireturn
    //   112: astore 4
    //   114: aconst_null
    //   115: astore_0
    //   116: iconst_0
    //   117: istore_1
    //   118: aload 4
    //   120: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 139	java/io/FileInputStream:close	()V
    //   131: iload_1
    //   132: istore_2
    //   133: aload 5
    //   135: ifnull -25 -> 110
    //   138: aload 5
    //   140: invokevirtual 138	java/io/DataInputStream:close	()V
    //   143: iload_1
    //   144: ireturn
    //   145: astore_0
    //   146: iload_1
    //   147: ireturn
    //   148: astore 4
    //   150: aconst_null
    //   151: astore_0
    //   152: aload 6
    //   154: astore 5
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 139	java/io/FileInputStream:close	()V
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 138	java/io/DataInputStream:close	()V
    //   174: aload 4
    //   176: athrow
    //   177: astore_0
    //   178: goto -4 -> 174
    //   181: astore 4
    //   183: aload 6
    //   185: astore 5
    //   187: goto -31 -> 156
    //   190: astore 6
    //   192: aload 4
    //   194: astore 5
    //   196: aload 6
    //   198: astore 4
    //   200: goto -44 -> 156
    //   203: astore 4
    //   205: goto -49 -> 156
    //   208: astore 4
    //   210: iload_2
    //   211: istore_1
    //   212: goto -94 -> 118
    //   215: astore 6
    //   217: aload 4
    //   219: astore 5
    //   221: iload_2
    //   222: istore_1
    //   223: aload 6
    //   225: astore 4
    //   227: goto -109 -> 118
    //   230: astore_0
    //   231: iload_1
    //   232: ireturn
    //   233: iconst_0
    //   234: istore_1
    //   235: goto -147 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramString	String
    //   5	230	1	m	int
    //   1	221	2	n	int
    //   3	55	3	i1	int
    //   32	72	4	localObject1	Object
    //   112	7	4	localException1	Exception
    //   148	27	4	localObject2	Object
    //   181	12	4	localObject3	Object
    //   198	1	4	localObject4	Object
    //   203	1	4	localObject5	Object
    //   208	10	4	localException2	Exception
    //   225	1	4	localException3	Exception
    //   7	213	5	localObject6	Object
    //   10	174	6	localObject7	Object
    //   190	7	6	localObject8	Object
    //   215	9	6	localException4	Exception
    //   13	72	7	localObject9	Object
    //   40	20	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	24	112	java/lang/Exception
    //   127	131	145	java/lang/Exception
    //   138	143	145	java/lang/Exception
    //   15	24	148	finally
    //   160	164	177	java/lang/Exception
    //   169	174	177	java/lang/Exception
    //   24	34	181	finally
    //   78	82	181	finally
    //   36	42	190	finally
    //   44	57	190	finally
    //   59	67	190	finally
    //   71	76	190	finally
    //   118	123	203	finally
    //   24	34	208	java/lang/Exception
    //   78	82	208	java/lang/Exception
    //   36	42	215	java/lang/Exception
    //   44	57	215	java/lang/Exception
    //   59	67	215	java/lang/Exception
    //   71	76	215	java/lang/Exception
    //   92	96	230	java/lang/Exception
    //   103	108	230	java/lang/Exception
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);
  }
  
  public static QQRecorder.RecorderParam a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    a(paramQQAppInterface, false);
    if (paramBoolean) {}
    for (paramQQAppInterface = b;; paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam) {
      return new QQRecorder.RecorderParam(paramQQAppInterface.a, paramQQAppInterface.b, paramQQAppInterface.c);
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).getString("PttCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "getSavedPttCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void a()
  {
    c = false;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).edit().putString("PttCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "savePttCfg: " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((c) && (!paramBoolean)) {
      return;
    }
    c = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "init: false");
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "init from sp:" + paramQQAppInterface);
        }
        if (paramQQAppInterface != null)
        {
          m = paramQQAppInterface.length();
          if (m != 0) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int m;
        int n;
        int i1;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecordParams", 2, "init params: " + jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c + "-" + jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a + "-" + jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b);
      QLog.d("RecordParams", 2, "init changer params: " + b.c + "-" + b.a + "-" + b.b);
      return;
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 3))
      {
        m = Integer.valueOf(paramQQAppInterface[0]).intValue();
        n = Integer.valueOf(paramQQAppInterface[1]).intValue();
        i1 = Integer.valueOf(paramQQAppInterface[2]).intValue();
        jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(jdField_a_of_type_ArrayOfInt[n], i1, m);
        if (paramQQAppInterface.length >= 6)
        {
          m = Integer.valueOf(paramQQAppInterface[3]).intValue();
          n = Integer.valueOf(paramQQAppInterface[4]).intValue();
          i1 = Integer.valueOf(paramQQAppInterface[5]).intValue();
          b = new QQRecorder.RecorderParam(jdField_a_of_type_ArrayOfInt[n], i1, m);
        }
      }
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 10)) {
      bool = false;
    }
    while (String.valueOf(PkgTools.c(paramArrayOfByte, 1, 9)).startsWith("#!SILK_V")) {
      return bool;
    }
    return false;
  }
  
  public static byte[] a()
  {
    return a(0, f);
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[0] = a(paramInt);
    System.arraycopy("#!SILK_V3".getBytes(), 0, arrayOfByte, 1, 9);
    return arrayOfByte;
  }
  
  public static byte[] a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return a(paramInt2);
    }
    return "#!AMR\n".getBytes();
  }
  
  public static int b(int paramInt)
  {
    return paramInt;
  }
  
  public static byte[] b(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RecordParams
 * JD-Core Version:    0.7.0.1
 */