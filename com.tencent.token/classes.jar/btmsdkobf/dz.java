package btmsdkobf;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.aoo;
import com.tencent.token.aop;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.base.utils.FileOP.CheckResult;
import com.tmsdk.base.utils.HttpGetFile;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class dz
{
  /* Error */
  public static byte[] G(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: new 12	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 18	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokevirtual 22	java/io/FileInputStream:available	()I
    //   25: invokespecial 25	java/io/ByteArrayOutputStream:<init>	(I)V
    //   28: astore_2
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 5
    //   36: aload_0
    //   37: aload 5
    //   39: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: iflt +14 -> 58
    //   47: aload_2
    //   48: aload 5
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 33	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -19 -> 36
    //   58: aload_2
    //   59: invokevirtual 37	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   62: astore 5
    //   64: aload_2
    //   65: invokevirtual 41	java/io/ByteArrayOutputStream:close	()V
    //   68: aload 5
    //   70: astore_2
    //   71: aload_0
    //   72: invokevirtual 42	java/io/FileInputStream:close	()V
    //   75: goto +90 -> 165
    //   78: astore 4
    //   80: aload_2
    //   81: astore_3
    //   82: aload_0
    //   83: astore_2
    //   84: aload 4
    //   86: astore_0
    //   87: goto +30 -> 117
    //   90: goto +52 -> 142
    //   93: astore 4
    //   95: aload 5
    //   97: astore_3
    //   98: aload_0
    //   99: astore_2
    //   100: aload 4
    //   102: astore_0
    //   103: goto +14 -> 117
    //   106: aconst_null
    //   107: astore_2
    //   108: goto +34 -> 142
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_2
    //   114: aload 5
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +10 -> 128
    //   121: aload_3
    //   122: invokevirtual 41	java/io/ByteArrayOutputStream:close	()V
    //   125: goto +3 -> 128
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 42	java/io/FileInputStream:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: astore_0
    //   142: aload_2
    //   143: ifnull +10 -> 153
    //   146: aload_2
    //   147: invokevirtual 41	java/io/ByteArrayOutputStream:close	()V
    //   150: goto +3 -> 153
    //   153: aload 4
    //   155: astore_2
    //   156: aload_0
    //   157: ifnull +8 -> 165
    //   160: aload_3
    //   161: astore_2
    //   162: goto -91 -> 71
    //   165: aload_2
    //   166: ifnull +5 -> 171
    //   169: aload_2
    //   170: areturn
    //   171: ldc 44
    //   173: invokevirtual 49	java/lang/String:getBytes	()[B
    //   176: areturn
    //   177: astore_0
    //   178: goto -40 -> 138
    //   181: astore_2
    //   182: goto -76 -> 106
    //   185: astore 5
    //   187: goto -97 -> 90
    //   190: astore_2
    //   191: aload 5
    //   193: astore_2
    //   194: goto -123 -> 71
    //   197: astore_0
    //   198: goto -33 -> 165
    //   201: astore_3
    //   202: goto -74 -> 128
    //   205: astore_2
    //   206: goto -70 -> 136
    //   209: astore_2
    //   210: goto -57 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   42	10	1	i	int
    //   28	142	2	localObject1	Object
    //   181	1	2	localThrowable1	Throwable
    //   190	1	2	localThrowable2	Throwable
    //   193	1	2	localThrowable3	Throwable
    //   205	1	2	localThrowable4	Throwable
    //   209	1	2	localThrowable5	Throwable
    //   7	154	3	localObject2	Object
    //   201	1	3	localThrowable6	Throwable
    //   4	1	4	localObject3	Object
    //   78	7	4	localObject4	Object
    //   93	61	4	localObject5	Object
    //   1	114	5	arrayOfByte	byte[]
    //   185	7	5	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	36	78	finally
    //   36	43	78	finally
    //   47	55	78	finally
    //   58	64	78	finally
    //   17	29	93	finally
    //   8	17	111	finally
    //   8	17	177	java/lang/Throwable
    //   17	29	181	java/lang/Throwable
    //   29	36	185	java/lang/Throwable
    //   36	43	185	java/lang/Throwable
    //   47	55	185	java/lang/Throwable
    //   58	64	185	java/lang/Throwable
    //   64	68	190	java/lang/Throwable
    //   71	75	197	java/lang/Throwable
    //   121	125	201	java/lang/Throwable
    //   132	136	205	java/lang/Throwable
    //   146	150	209	java/lang/Throwable
  }
  
  public static boolean H(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new File((String)localObject);
    if (paramString.exists())
    {
      if (!paramString.isDirectory()) {
        return false;
      }
      localObject = paramString.listFiles();
      int i = 0;
      int j = 1;
      while (i < localObject.length)
      {
        boolean bool;
        if (localObject[i].isFile())
        {
          bool = deleteFile(localObject[i].getAbsolutePath());
          j = bool;
          if (!bool)
          {
            j = bool;
            break;
          }
        }
        else
        {
          bool = H(localObject[i].getAbsolutePath());
          j = bool;
          if (!bool) {
            break;
          }
          j = bool;
        }
        i += 1;
      }
      if (j == 0) {
        return false;
      }
      if (paramString.delete()) {
        return true;
      }
    }
    return false;
  }
  
  public static String a(File paramFile)
  {
    try
    {
      paramFile = b(new FileInputStream(paramFile));
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 5
    //   16: astore_3
    //   17: new 54	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload 5
    //   28: astore_3
    //   29: aload_1
    //   30: invokevirtual 78	java/io/File:exists	()Z
    //   33: ifne +25 -> 58
    //   36: aload 5
    //   38: astore_3
    //   39: aload_1
    //   40: invokevirtual 113	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   43: invokevirtual 116	java/io/File:getParentFile	()Ljava/io/File;
    //   46: invokevirtual 119	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload 5
    //   52: astore_3
    //   53: aload_1
    //   54: invokevirtual 122	java/io/File:createNewFile	()Z
    //   57: pop
    //   58: aload 5
    //   60: astore_3
    //   61: new 124	java/io/FileOutputStream
    //   64: dup
    //   65: aload_1
    //   66: iconst_0
    //   67: invokespecial 127	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 130	java/io/FileOutputStream:write	([B)V
    //   76: iconst_1
    //   77: istore_2
    //   78: aload_1
    //   79: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_0
    //   85: aload_1
    //   86: astore_3
    //   87: goto +66 -> 153
    //   90: astore_3
    //   91: aload_1
    //   92: astore_0
    //   93: aload_3
    //   94: astore_1
    //   95: goto +11 -> 106
    //   98: astore_0
    //   99: goto +54 -> 153
    //   102: astore_1
    //   103: aload 4
    //   105: astore_0
    //   106: aload_0
    //   107: astore_3
    //   108: new 63	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 133
    //   114: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: astore 4
    //   119: aload_0
    //   120: astore_3
    //   121: aload 4
    //   123: aload_1
    //   124: invokevirtual 135	java/lang/Throwable:toString	()Ljava/lang/String;
    //   127: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: astore_3
    //   133: ldc 137
    //   135: aload 4
    //   137: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 143	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: iload_2
    //   165: ireturn
    //   166: astore_1
    //   167: goto -6 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramArrayOfByte	byte[]
    //   0	170	1	paramString	String
    //   1	164	2	bool	boolean
    //   16	71	3	localObject1	Object
    //   90	4	3	localThrowable	Throwable
    //   107	51	3	arrayOfByte	byte[]
    //   9	127	4	localStringBuilder	StringBuilder
    //   12	47	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   71	76	84	finally
    //   71	76	90	java/lang/Throwable
    //   17	26	98	finally
    //   29	36	98	finally
    //   39	50	98	finally
    //   53	58	98	finally
    //   61	71	98	finally
    //   108	119	98	finally
    //   121	131	98	finally
    //   133	143	98	finally
    //   17	26	102	java/lang/Throwable
    //   29	36	102	java/lang/Throwable
    //   39	50	102	java/lang/Throwable
    //   53	58	102	java/lang/Throwable
    //   61	71	102	java/lang/Throwable
    //   78	82	163	java/lang/Throwable
    //   147	151	163	java/lang/Throwable
    //   157	161	166	java/lang/Throwable
  }
  
  /* Error */
  public static String b(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_0
    //   8: ifnull +74 -> 82
    //   11: ldc 145
    //   13: invokestatic 151	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore_2
    //   17: sipush 8192
    //   20: newarray byte
    //   22: astore 5
    //   24: aload_0
    //   25: aload 5
    //   27: invokevirtual 154	java/io/InputStream:read	([B)I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +14 -> 47
    //   36: aload_2
    //   37: aload 5
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 157	java/security/MessageDigest:update	([BII)V
    //   44: goto -20 -> 24
    //   47: aload_2
    //   48: invokevirtual 160	java/security/MessageDigest:digest	()[B
    //   51: invokestatic 164	btmsdkobf/dz:bytesToString	([B)Ljava/lang/String;
    //   54: astore_2
    //   55: goto +27 -> 82
    //   58: astore_2
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 165	java/io/InputStream:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: aload_0
    //   70: ifnull +21 -> 91
    //   73: aload 4
    //   75: astore_2
    //   76: aload_0
    //   77: invokevirtual 165	java/io/InputStream:close	()V
    //   80: aload_2
    //   81: areturn
    //   82: aload_2
    //   83: astore_3
    //   84: aload_0
    //   85: ifnull +6 -> 91
    //   88: goto -12 -> 76
    //   91: aload_3
    //   92: areturn
    //   93: astore_2
    //   94: goto -25 -> 69
    //   97: astore_0
    //   98: goto -31 -> 67
    //   101: astore_0
    //   102: aload_2
    //   103: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	java.io.InputStream
    //   30	11	1	i	int
    //   1	54	2	localObject1	Object
    //   58	10	2	localObject2	Object
    //   75	8	2	localObject3	Object
    //   93	10	2	localThrowable	Throwable
    //   3	89	3	localObject4	Object
    //   5	69	4	localObject5	Object
    //   22	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	24	58	finally
    //   24	31	58	finally
    //   36	44	58	finally
    //   47	55	58	finally
    //   11	24	93	java/lang/Throwable
    //   24	31	93	java/lang/Throwable
    //   36	44	93	java/lang/Throwable
    //   47	55	93	java/lang/Throwable
    //   63	67	97	java/lang/Throwable
    //   76	80	101	java/lang/Throwable
  }
  
  public static String bytesToString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      int k = i * 2;
      arrayOfChar2[k] = arrayOfChar1[(j >>> 4 & 0xF)];
      arrayOfChar2[(k + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static boolean cR()
  {
    try
    {
      String str = Environment.getExternalStorageState();
      if (str == null) {
        return false;
      }
      boolean bool = str.equals("mounted");
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  /* Error */
  public static FileOP.CheckResult check(int paramInt1, final String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    // Byte code:
    //   0: new 200	com/tmsdk/base/utils/FileOP$CheckResult
    //   3: dup
    //   4: invokespecial 201	com/tmsdk/base/utils/FileOP$CheckResult:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: putfield 204	com/tmsdk/base/utils/FileOP$CheckResult:mFileName	Ljava/lang/String;
    //   15: new 206	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 207	java/util/ArrayList:<init>	()V
    //   22: astore 7
    //   24: new 209	com/tencent/token/aon
    //   27: dup
    //   28: invokespecial 210	com/tencent/token/aon:<init>	()V
    //   31: astore 8
    //   33: aload 8
    //   35: iload_0
    //   36: putfield 213	com/tencent/token/aon:a	I
    //   39: aload 7
    //   41: aload 8
    //   43: invokevirtual 216	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: iload_3
    //   48: ifle +25 -> 73
    //   51: aload 8
    //   53: iload_2
    //   54: putfield 219	com/tencent/token/aon:f	I
    //   57: aload 8
    //   59: iload_3
    //   60: putfield 222	com/tencent/token/aon:c	I
    //   63: aload 8
    //   65: aload 4
    //   67: putfield 225	com/tencent/token/aon:b	[B
    //   70: goto +155 -> 225
    //   73: new 54	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: iconst_1
    //   79: invokestatic 231	com/tmsdk/base/utils/FileOP:getAssetWupFile	(Ljava/lang/String;Z)Ljava/lang/String;
    //   82: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 78	java/io/File:exists	()Z
    //   90: ifeq +115 -> 205
    //   93: aconst_null
    //   94: astore 4
    //   96: new 12	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: astore_1
    //   105: iconst_4
    //   106: newarray byte
    //   108: astore 4
    //   110: aload_1
    //   111: aload 4
    //   113: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   116: pop
    //   117: aload 8
    //   119: aload 4
    //   121: invokestatic 236	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   124: putfield 219	com/tencent/token/aon:f	I
    //   127: aload_1
    //   128: aload 4
    //   130: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   133: pop
    //   134: aload 8
    //   136: aload 4
    //   138: invokestatic 236	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   141: putfield 222	com/tencent/token/aon:c	I
    //   144: bipush 16
    //   146: newarray byte
    //   148: astore 4
    //   150: aload_1
    //   151: aload 4
    //   153: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   156: pop
    //   157: aload 8
    //   159: aload 4
    //   161: putfield 225	com/tencent/token/aon:b	[B
    //   164: aload_1
    //   165: invokevirtual 42	java/io/FileInputStream:close	()V
    //   168: goto +57 -> 225
    //   171: astore 4
    //   173: goto +10 -> 183
    //   176: goto +18 -> 194
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 42	java/io/FileInputStream:close	()V
    //   191: aload 4
    //   193: athrow
    //   194: aload_1
    //   195: ifnull +30 -> 225
    //   198: aload_1
    //   199: invokevirtual 42	java/io/FileInputStream:close	()V
    //   202: goto +23 -> 225
    //   205: aload 8
    //   207: iconst_0
    //   208: putfield 219	com/tencent/token/aon:f	I
    //   211: aload 8
    //   213: iconst_0
    //   214: putfield 222	com/tencent/token/aon:c	I
    //   217: aload 8
    //   219: iconst_0
    //   220: newarray byte
    //   222: putfield 225	com/tencent/token/aon:b	[B
    //   225: new 238	com/tencent/token/aom
    //   228: dup
    //   229: invokespecial 239	com/tencent/token/aom:<init>	()V
    //   232: astore 4
    //   234: aload 4
    //   236: aload 7
    //   238: putfield 242	com/tencent/token/aom:a	Ljava/util/ArrayList;
    //   241: aload 4
    //   243: iconst_1
    //   244: putfield 244	com/tencent/token/aom:b	I
    //   247: new 4	java/lang/Object
    //   250: dup
    //   251: invokespecial 245	java/lang/Object:<init>	()V
    //   254: astore_1
    //   255: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   258: pop2
    //   259: bipush 108
    //   261: aload 4
    //   263: new 253	com/tencent/token/aoo
    //   266: dup
    //   267: invokespecial 254	com/tencent/token/aoo:<init>	()V
    //   270: iconst_0
    //   271: new 6	btmsdkobf/dz$1
    //   274: dup
    //   275: aload 6
    //   277: aload_1
    //   278: invokespecial 257	btmsdkobf/dz$1:<init>	(Lcom/tmsdk/base/utils/FileOP$CheckResult;Ljava/lang/Object;)V
    //   281: iload 5
    //   283: i2l
    //   284: invokestatic 263	com/tmsdk/base/TMSDKBaseContext:sendShark	(ILcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;ILcom/tmsdk/base/ISharkCallBackOut;J)V
    //   287: aload_1
    //   288: monitorenter
    //   289: aload_1
    //   290: invokevirtual 266	java/lang/Object:wait	()V
    //   293: goto +8 -> 301
    //   296: astore 4
    //   298: goto +8 -> 306
    //   301: aload_1
    //   302: monitorexit
    //   303: aload 6
    //   305: areturn
    //   306: aload_1
    //   307: monitorexit
    //   308: aload 4
    //   310: athrow
    //   311: astore_1
    //   312: aload 4
    //   314: astore_1
    //   315: goto -121 -> 194
    //   318: astore 4
    //   320: goto -144 -> 176
    //   323: astore_1
    //   324: goto -99 -> 225
    //   327: astore_1
    //   328: goto -137 -> 191
    //   331: astore 4
    //   333: goto -32 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramInt1	int
    //   0	336	1	paramString	String
    //   0	336	2	paramInt2	int
    //   0	336	3	paramInt3	int
    //   0	336	4	paramArrayOfByte	byte[]
    //   0	336	5	paramInt4	int
    //   7	297	6	localCheckResult	FileOP.CheckResult
    //   22	215	7	localArrayList	ArrayList
    //   31	187	8	localaon	com.tencent.token.aon
    // Exception table:
    //   from	to	target	type
    //   105	164	171	finally
    //   96	105	179	finally
    //   289	293	296	finally
    //   301	303	296	finally
    //   306	308	296	finally
    //   96	105	311	java/lang/Throwable
    //   105	164	318	java/lang/Throwable
    //   164	168	323	java/lang/Throwable
    //   198	202	323	java/lang/Throwable
    //   187	191	327	java/lang/Throwable
    //   289	293	331	java/lang/Throwable
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 88	java/io/File:isFile	()Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_3
    //   8: ifeq +290 -> 298
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 6
    //   17: new 12	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: new 124	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_0
    //   36: new 273	java/io/BufferedInputStream
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 276	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 5
    //   47: new 278	java/io/BufferedOutputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 281	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_1
    //   56: sipush 8192
    //   59: newarray byte
    //   61: astore 6
    //   63: aload 5
    //   65: aload 6
    //   67: invokevirtual 282	java/io/BufferedInputStream:read	([B)I
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpeq +14 -> 87
    //   76: aload_1
    //   77: aload 6
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 283	java/io/BufferedOutputStream:write	([BII)V
    //   84: goto -21 -> 63
    //   87: aload_1
    //   88: invokevirtual 286	java/io/BufferedOutputStream:flush	()V
    //   91: aload 5
    //   93: invokevirtual 287	java/io/BufferedInputStream:close	()V
    //   96: aload_1
    //   97: invokevirtual 288	java/io/BufferedOutputStream:close	()V
    //   100: aload 4
    //   102: invokevirtual 165	java/io/InputStream:close	()V
    //   105: aload_0
    //   106: invokevirtual 291	java/io/OutputStream:close	()V
    //   109: goto +289 -> 398
    //   112: astore 8
    //   114: aload_1
    //   115: astore 6
    //   117: aload 4
    //   119: astore 7
    //   121: aload 8
    //   123: astore_1
    //   124: aload 5
    //   126: astore 4
    //   128: goto +83 -> 211
    //   131: astore_1
    //   132: aload 4
    //   134: astore 7
    //   136: aload 5
    //   138: astore 4
    //   140: goto +71 -> 211
    //   143: aconst_null
    //   144: astore_1
    //   145: goto +118 -> 263
    //   148: astore_1
    //   149: aconst_null
    //   150: astore 5
    //   152: aload 4
    //   154: astore 7
    //   156: aload 5
    //   158: astore 4
    //   160: goto +51 -> 211
    //   163: aconst_null
    //   164: astore_1
    //   165: aload 7
    //   167: astore 5
    //   169: goto +94 -> 263
    //   172: astore_1
    //   173: aconst_null
    //   174: astore 5
    //   176: aload 5
    //   178: astore_0
    //   179: aload 4
    //   181: astore 7
    //   183: aload 5
    //   185: astore 4
    //   187: goto +24 -> 211
    //   190: aconst_null
    //   191: astore_0
    //   192: aload_0
    //   193: astore_1
    //   194: aload 7
    //   196: astore 5
    //   198: goto +65 -> 263
    //   201: astore_1
    //   202: aconst_null
    //   203: astore 4
    //   205: aload 4
    //   207: astore_0
    //   208: aload_0
    //   209: astore 7
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 287	java/io/BufferedInputStream:close	()V
    //   221: aload 6
    //   223: ifnull +8 -> 231
    //   226: aload 6
    //   228: invokevirtual 288	java/io/BufferedOutputStream:close	()V
    //   231: aload 7
    //   233: ifnull +8 -> 241
    //   236: aload 7
    //   238: invokevirtual 165	java/io/InputStream:close	()V
    //   241: aload_0
    //   242: ifnull +7 -> 249
    //   245: aload_0
    //   246: invokevirtual 291	java/io/OutputStream:close	()V
    //   249: aload_1
    //   250: athrow
    //   251: aconst_null
    //   252: astore_0
    //   253: aload_0
    //   254: astore 4
    //   256: aload 4
    //   258: astore_1
    //   259: aload 7
    //   261: astore 5
    //   263: aload 5
    //   265: ifnull +8 -> 273
    //   268: aload 5
    //   270: invokevirtual 287	java/io/BufferedInputStream:close	()V
    //   273: aload_1
    //   274: ifnull +7 -> 281
    //   277: aload_1
    //   278: invokevirtual 288	java/io/BufferedOutputStream:close	()V
    //   281: aload 4
    //   283: ifnull +8 -> 291
    //   286: aload 4
    //   288: invokevirtual 165	java/io/InputStream:close	()V
    //   291: aload_0
    //   292: ifnull +106 -> 398
    //   295: goto -190 -> 105
    //   298: aload_0
    //   299: invokevirtual 81	java/io/File:isDirectory	()Z
    //   302: ifeq +96 -> 398
    //   305: aload_0
    //   306: invokevirtual 85	java/io/File:listFiles	()[Ljava/io/File;
    //   309: astore_0
    //   310: aload_1
    //   311: invokevirtual 294	java/io/File:mkdir	()Z
    //   314: pop
    //   315: aload_0
    //   316: ifnull +82 -> 398
    //   319: iload_2
    //   320: aload_0
    //   321: arraylength
    //   322: if_icmpge +76 -> 398
    //   325: aload_0
    //   326: iload_2
    //   327: aaload
    //   328: invokevirtual 113	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   331: astore 4
    //   333: new 63	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   340: astore 5
    //   342: aload 5
    //   344: aload_1
    //   345: invokevirtual 113	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   348: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 5
    //   354: getstatic 58	java/io/File:separator	Ljava/lang/String;
    //   357: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 5
    //   363: aload_0
    //   364: iload_2
    //   365: aaload
    //   366: invokevirtual 300	java/io/File:getName	()Ljava/lang/String;
    //   369: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 4
    //   375: new 54	java/io/File
    //   378: dup
    //   379: aload 5
    //   381: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   387: invokestatic 302	btmsdkobf/dz:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   390: pop
    //   391: iload_2
    //   392: iconst_1
    //   393: iadd
    //   394: istore_2
    //   395: goto -76 -> 319
    //   398: iconst_1
    //   399: ireturn
    //   400: astore_0
    //   401: goto -150 -> 251
    //   404: astore_0
    //   405: goto -215 -> 190
    //   408: astore_1
    //   409: goto -246 -> 163
    //   412: astore_1
    //   413: goto -270 -> 143
    //   416: astore 6
    //   418: goto -273 -> 145
    //   421: astore 5
    //   423: goto -327 -> 96
    //   426: astore_1
    //   427: goto -327 -> 100
    //   430: astore_1
    //   431: goto -326 -> 105
    //   434: astore_0
    //   435: goto -37 -> 398
    //   438: astore 4
    //   440: goto -219 -> 221
    //   443: astore 4
    //   445: goto -214 -> 231
    //   448: astore 4
    //   450: goto -209 -> 241
    //   453: astore_0
    //   454: goto -205 -> 249
    //   457: astore 5
    //   459: goto -186 -> 273
    //   462: astore_1
    //   463: goto -182 -> 281
    //   466: astore_1
    //   467: goto -176 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramFile1	File
    //   0	470	1	paramFile2	File
    //   6	389	2	i	int
    //   4	4	3	bool	boolean
    //   25	349	4	localObject1	Object
    //   438	1	4	localException1	java.lang.Exception
    //   443	1	4	localThrowable1	Throwable
    //   448	1	4	localException2	java.lang.Exception
    //   45	335	5	localObject2	Object
    //   421	1	5	localException3	java.lang.Exception
    //   457	1	5	localException4	java.lang.Exception
    //   15	212	6	localObject3	Object
    //   416	1	6	localThrowable2	Throwable
    //   12	248	7	localObject4	Object
    //   112	10	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   56	63	112	finally
    //   63	71	112	finally
    //   76	84	112	finally
    //   87	91	112	finally
    //   47	56	131	finally
    //   36	47	148	finally
    //   27	36	172	finally
    //   17	27	201	finally
    //   17	27	400	java/lang/Throwable
    //   27	36	404	java/lang/Throwable
    //   36	47	408	java/lang/Throwable
    //   47	56	412	java/lang/Throwable
    //   56	63	416	java/lang/Throwable
    //   63	71	416	java/lang/Throwable
    //   76	84	416	java/lang/Throwable
    //   87	91	416	java/lang/Throwable
    //   91	96	421	java/lang/Exception
    //   96	100	426	java/lang/Throwable
    //   100	105	430	java/lang/Exception
    //   105	109	434	java/lang/Exception
    //   216	221	438	java/lang/Exception
    //   226	231	443	java/lang/Throwable
    //   236	241	448	java/lang/Exception
    //   245	249	453	java/lang/Exception
    //   268	273	457	java/lang/Exception
    //   277	281	462	java/lang/Throwable
    //   286	291	466	java/lang/Exception
  }
  
  public static final String d(String paramString1, String paramString2)
  {
    String str = Uri.decode(paramString1);
    if (str != null)
    {
      int i = str.indexOf('?');
      paramString1 = str;
      if (i > 0) {
        paramString1 = str.substring(0, i);
      }
      if (!paramString1.endsWith("/"))
      {
        i = paramString1.lastIndexOf('/') + 1;
        if (i > 0)
        {
          str = paramString1.substring(i);
          break label63;
        }
      }
    }
    str = null;
    label63:
    paramString1 = str;
    if (str == null) {
      paramString1 = paramString2;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "downloadfile";
    }
    return paramString2;
  }
  
  public static boolean deleteDir(File paramFile)
  {
    boolean bool1 = paramFile.isDirectory();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      localObject = paramFile.list();
      int m = localObject.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        if (!deleteDir(new File(paramFile, localObject[j]))) {
          i = 0;
        }
        j += 1;
      }
    }
    int k = 1;
    boolean bool3 = paramFile.delete();
    bool1 = bool2;
    if (k != 0)
    {
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
    }
    if (!bool1)
    {
      localObject = new StringBuilder("delete failed: ");
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      eg.f("FileUtil", ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public static boolean deleteFile(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.isFile()) {
        return false;
      }
      boolean bool = paramString.delete();
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  /* Error */
  public static String getAssetWupFile(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 44
    //   9: areturn
    //   10: invokestatic 357	btmsdkobf/bc:n	()Landroid/content/Context;
    //   13: astore 9
    //   15: new 63	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   22: astore 5
    //   24: aload 5
    //   26: aload 9
    //   28: invokevirtual 362	android/content/Context:getFilesDir	()Ljava/io/File;
    //   31: invokevirtual 363	java/io/File:toString	()Ljava/lang/String;
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 5
    //   40: getstatic 58	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: aload_0
    //   50: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 8
    //   61: aconst_null
    //   62: astore 7
    //   64: aconst_null
    //   65: astore 6
    //   67: new 54	java/io/File
    //   70: dup
    //   71: aload 8
    //   73: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 10
    //   78: aload 10
    //   80: invokevirtual 78	java/io/File:exists	()Z
    //   83: istore 4
    //   85: iload 4
    //   87: ifeq +183 -> 270
    //   90: iload_1
    //   91: ifeq +179 -> 270
    //   94: aload 9
    //   96: invokevirtual 367	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   99: aload_0
    //   100: iconst_1
    //   101: invokevirtual 373	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   104: astore 5
    //   106: iconst_4
    //   107: newarray byte
    //   109: astore 11
    //   111: aload 5
    //   113: aload 11
    //   115: invokevirtual 154	java/io/InputStream:read	([B)I
    //   118: pop
    //   119: aload 5
    //   121: aload 11
    //   123: invokevirtual 154	java/io/InputStream:read	([B)I
    //   126: pop
    //   127: aload 11
    //   129: invokestatic 236	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   132: istore_3
    //   133: aload 5
    //   135: ifnull +11 -> 146
    //   138: aload 5
    //   140: invokevirtual 165	java/io/InputStream:close	()V
    //   143: goto +3 -> 146
    //   146: new 12	java/io/FileInputStream
    //   149: dup
    //   150: aload 10
    //   152: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   155: astore 5
    //   157: iconst_4
    //   158: newarray byte
    //   160: astore 11
    //   162: aload 5
    //   164: aload 11
    //   166: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   169: pop
    //   170: aload 5
    //   172: aload 11
    //   174: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   177: pop
    //   178: aload 11
    //   180: invokestatic 236	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   183: istore_2
    //   184: aload 5
    //   186: invokevirtual 42	java/io/FileInputStream:close	()V
    //   189: goto +85 -> 274
    //   192: astore_0
    //   193: goto +7 -> 200
    //   196: astore_0
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: ifnull +11 -> 213
    //   205: aload 5
    //   207: invokevirtual 42	java/io/FileInputStream:close	()V
    //   210: goto +3 -> 213
    //   213: aload_0
    //   214: athrow
    //   215: aconst_null
    //   216: astore 5
    //   218: aload 5
    //   220: ifnull +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 42	java/io/FileInputStream:close	()V
    //   228: aload 8
    //   230: areturn
    //   231: astore_0
    //   232: goto +7 -> 239
    //   235: astore_0
    //   236: aconst_null
    //   237: astore 5
    //   239: aload 5
    //   241: ifnull +11 -> 252
    //   244: aload 5
    //   246: invokevirtual 165	java/io/InputStream:close	()V
    //   249: goto +3 -> 252
    //   252: aload_0
    //   253: athrow
    //   254: aconst_null
    //   255: astore 5
    //   257: aload 5
    //   259: ifnull +8 -> 267
    //   262: aload 5
    //   264: invokevirtual 165	java/io/InputStream:close	()V
    //   267: aload 8
    //   269: areturn
    //   270: iconst_0
    //   271: istore_2
    //   272: iconst_0
    //   273: istore_3
    //   274: iload_1
    //   275: ifeq +29 -> 304
    //   278: iload 4
    //   280: ifeq +8 -> 288
    //   283: iload_3
    //   284: iload_2
    //   285: if_icmpgt +19 -> 304
    //   288: iload 4
    //   290: ifne +6 -> 296
    //   293: goto +11 -> 304
    //   296: aconst_null
    //   297: astore_0
    //   298: aload_0
    //   299: astore 5
    //   301: goto +83 -> 384
    //   304: iload 4
    //   306: ifeq +9 -> 315
    //   309: aload 10
    //   311: invokevirtual 99	java/io/File:delete	()Z
    //   314: pop
    //   315: aload 9
    //   317: invokevirtual 377	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   320: invokevirtual 380	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   323: aload_0
    //   324: iconst_1
    //   325: invokevirtual 373	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   328: astore_0
    //   329: new 124	java/io/FileOutputStream
    //   332: dup
    //   333: aload 10
    //   335: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   338: astore 5
    //   340: sipush 8192
    //   343: newarray byte
    //   345: astore 6
    //   347: aload_0
    //   348: aload 6
    //   350: invokevirtual 154	java/io/InputStream:read	([B)I
    //   353: istore_2
    //   354: iload_2
    //   355: ifle +15 -> 370
    //   358: aload 5
    //   360: aload 6
    //   362: iconst_0
    //   363: iload_2
    //   364: invokevirtual 381	java/io/FileOutputStream:write	([BII)V
    //   367: goto -20 -> 347
    //   370: aload 5
    //   372: invokevirtual 385	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   375: iconst_1
    //   376: invokevirtual 391	java/nio/channels/FileChannel:force	(Z)V
    //   379: aload 5
    //   381: invokevirtual 392	java/io/FileOutputStream:flush	()V
    //   384: aload_0
    //   385: ifnull +10 -> 395
    //   388: aload_0
    //   389: invokevirtual 165	java/io/InputStream:close	()V
    //   392: goto +3 -> 395
    //   395: aload 5
    //   397: ifnull +8 -> 405
    //   400: aload 5
    //   402: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   405: aload 8
    //   407: areturn
    //   408: astore 7
    //   410: aload_0
    //   411: astore 6
    //   413: aload 7
    //   415: astore_0
    //   416: goto +35 -> 451
    //   419: goto +63 -> 482
    //   422: astore 5
    //   424: aconst_null
    //   425: astore 7
    //   427: aload_0
    //   428: astore 6
    //   430: aload 5
    //   432: astore_0
    //   433: aload 7
    //   435: astore 5
    //   437: goto +14 -> 451
    //   440: aload 7
    //   442: astore 5
    //   444: goto +38 -> 482
    //   447: astore_0
    //   448: aconst_null
    //   449: astore 5
    //   451: aload 6
    //   453: ifnull +11 -> 464
    //   456: aload 6
    //   458: invokevirtual 165	java/io/InputStream:close	()V
    //   461: goto +3 -> 464
    //   464: aload 5
    //   466: ifnull +8 -> 474
    //   469: aload 5
    //   471: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   474: aload_0
    //   475: athrow
    //   476: aconst_null
    //   477: astore_0
    //   478: aload 7
    //   480: astore 5
    //   482: aload_0
    //   483: ifnull +10 -> 493
    //   486: aload_0
    //   487: invokevirtual 165	java/io/InputStream:close	()V
    //   490: goto +3 -> 493
    //   493: aload 5
    //   495: ifnull +8 -> 503
    //   498: aload 5
    //   500: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   503: aload 8
    //   505: areturn
    //   506: astore_0
    //   507: goto -31 -> 476
    //   510: astore_0
    //   511: goto -257 -> 254
    //   514: astore_0
    //   515: goto -258 -> 257
    //   518: astore_0
    //   519: aload 8
    //   521: areturn
    //   522: astore_0
    //   523: goto -308 -> 215
    //   526: astore_0
    //   527: goto -309 -> 218
    //   530: astore_0
    //   531: aload 8
    //   533: areturn
    //   534: astore_0
    //   535: aload 8
    //   537: areturn
    //   538: astore_0
    //   539: aload 8
    //   541: areturn
    //   542: astore_0
    //   543: aload 8
    //   545: areturn
    //   546: astore_0
    //   547: aload 8
    //   549: areturn
    //   550: astore 5
    //   552: goto -112 -> 440
    //   555: astore 6
    //   557: goto -138 -> 419
    //   560: astore_0
    //   561: goto -166 -> 395
    //   564: astore_0
    //   565: aload 8
    //   567: areturn
    //   568: astore 6
    //   570: goto -106 -> 464
    //   573: astore 5
    //   575: goto -101 -> 474
    //   578: astore_0
    //   579: goto -86 -> 493
    //   582: astore_0
    //   583: aload 8
    //   585: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	paramString	String
    //   0	586	1	paramBoolean	boolean
    //   183	181	2	i	int
    //   132	154	3	j	int
    //   83	222	4	bool	boolean
    //   22	379	5	localObject1	Object
    //   422	9	5	localObject2	Object
    //   435	64	5	localObject3	Object
    //   550	1	5	localThrowable1	Throwable
    //   573	1	5	localIOException1	java.io.IOException
    //   65	392	6	localObject4	Object
    //   555	1	6	localThrowable2	Throwable
    //   568	1	6	localIOException2	java.io.IOException
    //   62	1	7	localObject5	Object
    //   408	6	7	localObject6	Object
    //   425	54	7	localObject7	Object
    //   59	525	8	str	String
    //   13	303	9	localContext	Context
    //   76	258	10	localFile	File
    //   109	70	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   157	184	192	finally
    //   146	157	196	finally
    //   106	133	231	finally
    //   94	106	235	finally
    //   340	347	408	finally
    //   347	354	408	finally
    //   358	367	408	finally
    //   370	384	408	finally
    //   329	340	422	finally
    //   67	85	447	finally
    //   138	143	447	finally
    //   184	189	447	finally
    //   205	210	447	finally
    //   213	215	447	finally
    //   223	228	447	finally
    //   244	249	447	finally
    //   252	254	447	finally
    //   262	267	447	finally
    //   309	315	447	finally
    //   315	329	447	finally
    //   67	85	506	java/lang/Throwable
    //   213	215	506	java/lang/Throwable
    //   252	254	506	java/lang/Throwable
    //   309	315	506	java/lang/Throwable
    //   315	329	506	java/lang/Throwable
    //   94	106	510	java/lang/Throwable
    //   106	133	514	java/lang/Throwable
    //   138	143	518	java/lang/Throwable
    //   146	157	522	java/lang/Throwable
    //   157	184	526	java/lang/Throwable
    //   184	189	530	java/lang/Throwable
    //   205	210	534	java/lang/Throwable
    //   223	228	538	java/lang/Throwable
    //   244	249	542	java/lang/Throwable
    //   262	267	546	java/lang/Throwable
    //   329	340	550	java/lang/Throwable
    //   340	347	555	java/lang/Throwable
    //   347	354	555	java/lang/Throwable
    //   358	367	555	java/lang/Throwable
    //   370	384	555	java/lang/Throwable
    //   388	392	560	java/io/IOException
    //   400	405	564	java/io/IOException
    //   456	461	568	java/io/IOException
    //   469	474	573	java/io/IOException
    //   486	490	578	java/io/IOException
    //   498	503	582	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.token.aor loadWupObjectFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 396	com/tencent/token/aor
    //   17: dup
    //   18: invokespecial 397	com/tencent/token/aor:<init>	()V
    //   21: astore 6
    //   23: new 54	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 78	java/io/File:exists	()Z
    //   36: ifne +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: new 399	com/qq/jce/wup/UniAttribute
    //   44: dup
    //   45: invokespecial 400	com/qq/jce/wup/UniAttribute:<init>	()V
    //   48: astore 7
    //   50: new 12	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore 4
    //   60: iconst_4
    //   61: newarray byte
    //   63: astore 5
    //   65: aload 4
    //   67: aload 5
    //   69: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   72: pop
    //   73: aload 5
    //   75: invokestatic 236	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   78: pop
    //   79: aload 4
    //   81: aload 5
    //   83: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   86: pop
    //   87: aload 5
    //   89: invokestatic 236	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   92: pop
    //   93: bipush 16
    //   95: newarray byte
    //   97: astore 5
    //   99: aload 4
    //   101: aload 5
    //   103: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   106: pop
    //   107: aload 4
    //   109: invokevirtual 22	java/io/FileInputStream:available	()I
    //   112: newarray byte
    //   114: astore 8
    //   116: aload 4
    //   118: aload 8
    //   120: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   123: pop
    //   124: aload 8
    //   126: invokestatic 406	com/tmsdk/base/utils/MD5Util:encrypt	([B)[B
    //   129: invokestatic 409	com/tmsdk/base/utils/ConvertUtil:bytesToHexString	([B)Ljava/lang/String;
    //   132: aload 5
    //   134: invokestatic 409	com/tmsdk/base/utils/ConvertUtil:bytesToHexString	([B)Ljava/lang/String;
    //   137: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne +5 -> 145
    //   143: aconst_null
    //   144: areturn
    //   145: aload 8
    //   147: aconst_null
    //   148: invokestatic 414	com/tencent/token/ass:b	([B[B)[B
    //   151: astore 5
    //   153: aload_1
    //   154: ifnull +16 -> 170
    //   157: aload_1
    //   158: invokevirtual 417	java/lang/String:length	()I
    //   161: ifle +9 -> 170
    //   164: aload 7
    //   166: aload_1
    //   167: invokevirtual 420	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   170: aload 7
    //   172: aload 5
    //   174: invokevirtual 422	com/qq/jce/wup/UniAttribute:decode	([B)V
    //   177: aload_0
    //   178: invokevirtual 300	java/io/File:getName	()Ljava/lang/String;
    //   181: astore_1
    //   182: aload_1
    //   183: ldc_w 424
    //   186: invokevirtual 427	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   189: istore_2
    //   190: aload_1
    //   191: astore_0
    //   192: iload_2
    //   193: ifle +10 -> 203
    //   196: aload_1
    //   197: iconst_0
    //   198: iload_2
    //   199: invokevirtual 318	java/lang/String:substring	(II)Ljava/lang/String;
    //   202: astore_0
    //   203: aload 7
    //   205: aload_0
    //   206: aload 6
    //   208: invokevirtual 431	com/qq/jce/wup/UniAttribute:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: checkcast 396	com/tencent/token/aor
    //   214: astore_0
    //   215: aload_0
    //   216: areturn
    //   217: aload 4
    //   219: astore_0
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 42	java/io/FileInputStream:close	()V
    //   228: aload 6
    //   230: areturn
    //   231: astore_0
    //   232: aload 5
    //   234: astore_0
    //   235: goto -15 -> 220
    //   238: astore_0
    //   239: goto -22 -> 217
    //   242: astore_0
    //   243: goto -15 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString1	String
    //   0	246	1	paramString2	String
    //   189	10	2	i	int
    //   4	5	3	bool	boolean
    //   58	160	4	localFileInputStream	FileInputStream
    //   6	227	5	arrayOfByte1	byte[]
    //   21	208	6	localaor	com.tencent.token.aor
    //   48	156	7	localUniAttribute	com.qq.jce.wup.UniAttribute
    //   114	32	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	39	231	java/lang/Throwable
    //   41	60	231	java/lang/Throwable
    //   60	143	238	java/lang/Throwable
    //   145	153	238	java/lang/Throwable
    //   157	170	238	java/lang/Throwable
    //   170	190	238	java/lang/Throwable
    //   196	203	238	java/lang/Throwable
    //   203	215	238	java/lang/Throwable
    //   224	228	242	java/lang/Throwable
  }
  
  public static int update(FileOP.CheckResult paramCheckResult)
  {
    if (paramCheckResult.mStatusCode == -209) {
      return -209;
    }
    if ((paramCheckResult != null) && (paramCheckResult.mStatusCode == -208) && (!TextUtils.isEmpty(paramCheckResult.mUrl)) && (!TextUtils.isEmpty(paramCheckResult.mFileName)))
    {
      HttpGetFile localHttpGetFile = new HttpGetFile(TMSDKBaseContext.getApplicationContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TMSDKBaseContext.getApplicationContext().getFilesDir().getAbsolutePath());
      localStringBuilder.append("/");
      localHttpGetFile.setSavePath(localStringBuilder.toString());
      localHttpGetFile.setSaveName(paramCheckResult.mFileName);
      int i;
      do
      {
        i = localHttpGetFile.doGetFile(null, paramCheckResult.mUrl, false, null);
      } while (i == -7);
      if (i == 0) {
        return 0;
      }
    }
    return -999;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dz
 * JD-Core Version:    0.7.0.1
 */