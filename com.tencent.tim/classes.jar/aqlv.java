import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public abstract class aqlv
{
  public static final int dZQ = oZ[0];
  public static final int dZR = oZ[2];
  private static QQRecorder.RecorderParam f = new QQRecorder.RecorderParam(dZR, 16000, 1);
  private static QQRecorder.RecorderParam g = new QQRecorder.RecorderParam(dZR, 16000, 1);
  public static final int[] oZ = { 8000, 12000, 16000, 24000, 36000, 44100, 48000 };
  private static boolean sInit;
  
  private static String I(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("SilkCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "getSavedSilkCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static int Ma()
  {
    return aA().length;
  }
  
  public static byte a(InputStream paramInputStream)
    throws Exception
  {
    byte b = -1;
    byte[] arrayOfByte = new byte[10];
    paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (u(arrayOfByte)) {
      b = arrayOfByte[0];
    }
    return b;
  }
  
  public static QQRecorder.RecorderParam a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ae(paramQQAppInterface, false);
    if (paramBoolean) {}
    for (paramQQAppInterface = g;; paramQQAppInterface = f) {
      return new QQRecorder.RecorderParam(paramQQAppInterface.mSampleRate, paramQQAppInterface.mBitRate, paramQQAppInterface.mAudioType);
    }
  }
  
  public static byte[] a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    return paramArrayOfByte;
  }
  
  public static byte[] aA()
  {
    return c(0, dZQ);
  }
  
  public static void ae(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((sInit) && (!paramBoolean)) {
      return;
    }
    sInit = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "init: false");
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = I(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "init from sp:" + paramQQAppInterface);
        }
        if (paramQQAppInterface != null)
        {
          i = paramQQAppInterface.length();
          if (i != 0) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i;
        int j;
        int k;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecordParams", 2, "init params: " + f.mAudioType + "-" + f.mSampleRate + "-" + f.mBitRate);
      QLog.d("RecordParams", 2, "init changer params: " + g.mAudioType + "-" + g.mSampleRate + "-" + g.mBitRate);
      return;
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 3))
      {
        i = Integer.valueOf(paramQQAppInterface[0]).intValue();
        j = Integer.valueOf(paramQQAppInterface[1]).intValue();
        k = Integer.valueOf(paramQQAppInterface[2]).intValue();
        f = new QQRecorder.RecorderParam(oZ[j], k, i);
        if (paramQQAppInterface.length >= 6)
        {
          i = Integer.valueOf(paramQQAppInterface[3]).intValue();
          j = Integer.valueOf(paramQQAppInterface[4]).intValue();
          k = Integer.valueOf(paramQQAppInterface[5]).intValue();
          g = new QQRecorder.RecorderParam(oZ[j], k, i);
        }
      }
    }
  }
  
  public static void bj(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putString("SilkCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, " " + paramString);
    }
  }
  
  public static byte[] c(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return j(paramInt2);
    }
    return "#!AMR\n".getBytes();
  }
  
  public static byte e(int paramInt)
  {
    int j;
    for (int i = 0; i < oZ.length; j = (byte)(i + 1)) {
      if (paramInt == oZ[i]) {
        return i;
      }
    }
    return -1;
  }
  
  public static int e(byte paramByte)
  {
    int j = 0;
    int i = j;
    if (paramByte >= 0)
    {
      i = j;
      if (paramByte < oZ.length) {
        i = oZ[paramByte];
      }
    }
    return i;
  }
  
  public static int f(double paramDouble)
  {
    return QQRecorder.d(paramDouble);
  }
  
  /* Error */
  public static int fj(String paramString)
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
    //   15: new 203	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: new 208	java/io/DataInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 211	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   48: invokevirtual 214	java/io/DataInputStream:read	([B)I
    //   51: aload 8
    //   53: arraylength
    //   54: if_icmpne +179 -> 233
    //   57: iload_3
    //   58: istore_2
    //   59: aload 8
    //   61: invokestatic 108	aqlv:u	([B)Z
    //   64: ifeq +5 -> 69
    //   67: iconst_1
    //   68: istore_1
    //   69: iload_1
    //   70: istore_2
    //   71: aload 4
    //   73: invokevirtual 217	java/io/DataInputStream:close	()V
    //   76: iload_1
    //   77: istore_2
    //   78: aload_0
    //   79: invokevirtual 218	java/io/FileInputStream:close	()V
    //   82: aconst_null
    //   83: astore_0
    //   84: aload 7
    //   86: astore 4
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 218	java/io/FileInputStream:close	()V
    //   96: iload_1
    //   97: istore_2
    //   98: aload 4
    //   100: ifnull +10 -> 110
    //   103: aload 4
    //   105: invokevirtual 217	java/io/DataInputStream:close	()V
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
    //   120: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 218	java/io/FileInputStream:close	()V
    //   131: iload_1
    //   132: istore_2
    //   133: aload 5
    //   135: ifnull -25 -> 110
    //   138: aload 5
    //   140: invokevirtual 217	java/io/DataInputStream:close	()V
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
    //   161: invokevirtual 218	java/io/FileInputStream:close	()V
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 217	java/io/DataInputStream:close	()V
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
    //   5	230	1	i	int
    //   1	221	2	j	int
    //   3	55	3	k	int
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
  
  public static byte[] j(int paramInt)
  {
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[0] = e(paramInt);
    System.arraycopy("#!SILK_V3".getBytes(), 0, arrayOfByte, 1, 9);
    return arrayOfByte;
  }
  
  public static int kg(int paramInt)
  {
    return paramInt * 20 * 2 / 1000;
  }
  
  public static int kh(int paramInt)
  {
    return paramInt;
  }
  
  public static void release()
  {
    sInit = false;
  }
  
  public static boolean u(byte[] paramArrayOfByte)
    throws Exception
  {
    boolean bool = true;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 10)) {
      bool = false;
    }
    String str;
    do
    {
      return bool;
      str = aqoj.b(paramArrayOfByte, 1, 9);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "getSilkFs " + paramArrayOfByte[0] + str);
      }
    } while (str.startsWith("#!SILK_V"));
    QLog.e("RecordParams", 1, "isSilkFileHead: headString = " + str);
    return false;
  }
  
  public static int z(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlv
 * JD-Core Version:    0.7.0.1
 */