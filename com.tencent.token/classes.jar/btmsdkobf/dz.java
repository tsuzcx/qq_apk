package btmsdkobf;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.base.utils.FileOP.CheckResult;
import com.tmsdk.base.utils.HttpGetFile;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import tmsdk.Protocol.MConfigUpdate.SCConfInfo;
import tmsdk.Protocol.MConfigUpdate.ServerConfInfo;

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
          if (!bool)
          {
            j = bool;
            break;
          }
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
    //   87: goto +74 -> 161
    //   90: astore_3
    //   91: aload_1
    //   92: astore_0
    //   93: aload_3
    //   94: astore_1
    //   95: goto +11 -> 106
    //   98: astore_0
    //   99: goto +62 -> 161
    //   102: astore_1
    //   103: aload 4
    //   105: astore_0
    //   106: aload_0
    //   107: astore_3
    //   108: new 63	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload_0
    //   118: astore_3
    //   119: aload 4
    //   121: ldc 133
    //   123: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_0
    //   128: astore_3
    //   129: aload 4
    //   131: aload_1
    //   132: invokevirtual 134	java/lang/Throwable:toString	()Ljava/lang/String;
    //   135: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_0
    //   140: astore_3
    //   141: ldc 136
    //   143: aload 4
    //   145: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 142	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   159: iconst_0
    //   160: ireturn
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   169: aload_0
    //   170: athrow
    //   171: astore_0
    //   172: iload_2
    //   173: ireturn
    //   174: astore_1
    //   175: goto -6 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramArrayOfByte	byte[]
    //   0	178	1	paramString	String
    //   1	172	2	bool	boolean
    //   16	71	3	localObject1	Object
    //   90	4	3	localThrowable	Throwable
    //   107	59	3	arrayOfByte	byte[]
    //   9	135	4	localStringBuilder	StringBuilder
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
    //   108	117	98	finally
    //   119	127	98	finally
    //   129	139	98	finally
    //   141	151	98	finally
    //   17	26	102	java/lang/Throwable
    //   29	36	102	java/lang/Throwable
    //   39	50	102	java/lang/Throwable
    //   53	58	102	java/lang/Throwable
    //   61	71	102	java/lang/Throwable
    //   78	82	171	java/lang/Throwable
    //   155	159	171	java/lang/Throwable
    //   165	169	174	java/lang/Throwable
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
    //   11: ldc 144
    //   13: invokestatic 150	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore_2
    //   17: sipush 8192
    //   20: newarray byte
    //   22: astore 5
    //   24: aload_0
    //   25: aload 5
    //   27: invokevirtual 153	java/io/InputStream:read	([B)I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +14 -> 47
    //   36: aload_2
    //   37: aload 5
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 156	java/security/MessageDigest:update	([BII)V
    //   44: goto -20 -> 24
    //   47: aload_2
    //   48: invokevirtual 159	java/security/MessageDigest:digest	()[B
    //   51: invokestatic 163	btmsdkobf/dz:bytesToString	([B)Ljava/lang/String;
    //   54: astore_2
    //   55: goto +27 -> 82
    //   58: astore_2
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 164	java/io/InputStream:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: aload_0
    //   70: ifnull +21 -> 91
    //   73: aload 4
    //   75: astore_2
    //   76: aload_0
    //   77: invokevirtual 164	java/io/InputStream:close	()V
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
    //   0: new 199	com/tmsdk/base/utils/FileOP$CheckResult
    //   3: dup
    //   4: invokespecial 200	com/tmsdk/base/utils/FileOP$CheckResult:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: putfield 203	com/tmsdk/base/utils/FileOP$CheckResult:mFileName	Ljava/lang/String;
    //   15: new 205	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 206	java/util/ArrayList:<init>	()V
    //   22: astore 7
    //   24: new 208	tmsdk/Protocol/MConfigUpdate/ClientConfInfo
    //   27: dup
    //   28: invokespecial 209	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:<init>	()V
    //   31: astore 8
    //   33: aload 8
    //   35: iload_0
    //   36: putfield 213	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:fileId	I
    //   39: aload 7
    //   41: aload 8
    //   43: invokevirtual 216	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: iload_3
    //   48: ifle +25 -> 73
    //   51: aload 8
    //   53: iload_2
    //   54: putfield 219	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:version	I
    //   57: aload 8
    //   59: iload_3
    //   60: putfield 222	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:timestamp	I
    //   63: aload 8
    //   65: aload 4
    //   67: putfield 226	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:md5Bin	[B
    //   70: goto +150 -> 220
    //   73: new 54	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: iconst_1
    //   79: invokestatic 232	com/tmsdk/base/utils/FileOP:getAssetWupFile	(Ljava/lang/String;Z)Ljava/lang/String;
    //   82: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 78	java/io/File:exists	()Z
    //   90: ifeq +110 -> 200
    //   93: new 12	java/io/FileInputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: astore_1
    //   102: iconst_4
    //   103: newarray byte
    //   105: astore 4
    //   107: aload_1
    //   108: aload 4
    //   110: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   113: pop
    //   114: aload 8
    //   116: aload 4
    //   118: invokestatic 237	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   121: putfield 219	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:version	I
    //   124: aload_1
    //   125: aload 4
    //   127: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   130: pop
    //   131: aload 8
    //   133: aload 4
    //   135: invokestatic 237	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   138: putfield 222	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:timestamp	I
    //   141: bipush 16
    //   143: newarray byte
    //   145: astore 4
    //   147: aload_1
    //   148: aload 4
    //   150: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   153: pop
    //   154: aload 8
    //   156: aload 4
    //   158: putfield 226	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:md5Bin	[B
    //   161: aload_1
    //   162: invokevirtual 42	java/io/FileInputStream:close	()V
    //   165: goto +55 -> 220
    //   168: astore 4
    //   170: goto +10 -> 180
    //   173: goto +20 -> 193
    //   176: astore 4
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 42	java/io/FileInputStream:close	()V
    //   188: aload 4
    //   190: athrow
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +26 -> 220
    //   197: goto -36 -> 161
    //   200: aload 8
    //   202: iconst_0
    //   203: putfield 219	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:version	I
    //   206: aload 8
    //   208: iconst_0
    //   209: putfield 222	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:timestamp	I
    //   212: aload 8
    //   214: iconst_0
    //   215: newarray byte
    //   217: putfield 226	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:md5Bin	[B
    //   220: new 239	tmsdk/Protocol/MConfigUpdate/CSConfInfo
    //   223: dup
    //   224: invokespecial 240	tmsdk/Protocol/MConfigUpdate/CSConfInfo:<init>	()V
    //   227: astore 4
    //   229: aload 4
    //   231: aload 7
    //   233: putfield 244	tmsdk/Protocol/MConfigUpdate/CSConfInfo:vecInfo	Ljava/util/ArrayList;
    //   236: aload 4
    //   238: iconst_1
    //   239: putfield 247	tmsdk/Protocol/MConfigUpdate/CSConfInfo:updatetype	I
    //   242: new 4	java/lang/Object
    //   245: dup
    //   246: invokespecial 248	java/lang/Object:<init>	()V
    //   249: astore_1
    //   250: invokestatic 254	java/lang/System:currentTimeMillis	()J
    //   253: pop2
    //   254: bipush 108
    //   256: aload 4
    //   258: new 256	tmsdk/Protocol/MConfigUpdate/SCConfInfo
    //   261: dup
    //   262: invokespecial 257	tmsdk/Protocol/MConfigUpdate/SCConfInfo:<init>	()V
    //   265: iconst_0
    //   266: new 6	btmsdkobf/dz$1
    //   269: dup
    //   270: aload 6
    //   272: aload_1
    //   273: invokespecial 260	btmsdkobf/dz$1:<init>	(Lcom/tmsdk/base/utils/FileOP$CheckResult;Ljava/lang/Object;)V
    //   276: iload 5
    //   278: i2l
    //   279: invokestatic 266	com/tmsdk/base/TMSDKBaseContext:sendShark	(ILcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;ILcom/tmsdk/base/ISharkCallBackOut;J)V
    //   282: aload_1
    //   283: monitorenter
    //   284: aload_1
    //   285: invokevirtual 269	java/lang/Object:wait	()V
    //   288: goto +8 -> 296
    //   291: astore 4
    //   293: goto +8 -> 301
    //   296: aload_1
    //   297: monitorexit
    //   298: aload 6
    //   300: areturn
    //   301: aload_1
    //   302: monitorexit
    //   303: aload 4
    //   305: athrow
    //   306: astore_1
    //   307: goto -116 -> 191
    //   310: astore 4
    //   312: goto -139 -> 173
    //   315: astore_1
    //   316: goto -96 -> 220
    //   319: astore_1
    //   320: goto -132 -> 188
    //   323: astore 4
    //   325: goto -29 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramInt1	int
    //   0	328	1	paramString	String
    //   0	328	2	paramInt2	int
    //   0	328	3	paramInt3	int
    //   0	328	4	paramArrayOfByte	byte[]
    //   0	328	5	paramInt4	int
    //   7	292	6	localCheckResult	FileOP.CheckResult
    //   22	210	7	localArrayList	ArrayList
    //   31	182	8	localClientConfInfo	tmsdk.Protocol.MConfigUpdate.ClientConfInfo
    // Exception table:
    //   from	to	target	type
    //   102	161	168	finally
    //   93	102	176	finally
    //   284	288	291	finally
    //   296	298	291	finally
    //   301	303	291	finally
    //   93	102	306	java/lang/Throwable
    //   102	161	310	java/lang/Throwable
    //   161	165	315	java/lang/Throwable
    //   184	188	319	java/lang/Throwable
    //   284	288	323	java/lang/Throwable
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
    //   8: ifeq +293 -> 301
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
    //   32: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_0
    //   36: new 276	java/io/BufferedInputStream
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 279	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 5
    //   47: new 281	java/io/BufferedOutputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 284	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_1
    //   56: sipush 8192
    //   59: newarray byte
    //   61: astore 6
    //   63: aload 5
    //   65: aload 6
    //   67: invokevirtual 285	java/io/BufferedInputStream:read	([B)I
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpeq +14 -> 87
    //   76: aload_1
    //   77: aload 6
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 286	java/io/BufferedOutputStream:write	([BII)V
    //   84: goto -21 -> 63
    //   87: aload_1
    //   88: invokevirtual 289	java/io/BufferedOutputStream:flush	()V
    //   91: aload 5
    //   93: invokevirtual 290	java/io/BufferedInputStream:close	()V
    //   96: aload_1
    //   97: invokevirtual 291	java/io/BufferedOutputStream:close	()V
    //   100: aload 4
    //   102: invokevirtual 164	java/io/InputStream:close	()V
    //   105: aload_0
    //   106: invokevirtual 294	java/io/OutputStream:close	()V
    //   109: goto +292 -> 401
    //   112: astore 8
    //   114: aload_1
    //   115: astore 6
    //   117: aload 4
    //   119: astore 7
    //   121: aload 8
    //   123: astore_1
    //   124: aload 5
    //   126: astore 4
    //   128: goto +87 -> 215
    //   131: aload_1
    //   132: astore 6
    //   134: aload 5
    //   136: astore_1
    //   137: goto +129 -> 266
    //   140: astore_1
    //   141: aload 4
    //   143: astore 7
    //   145: aload 5
    //   147: astore 4
    //   149: goto +66 -> 215
    //   152: astore_1
    //   153: aconst_null
    //   154: astore 5
    //   156: aload 4
    //   158: astore 7
    //   160: aload 5
    //   162: astore 4
    //   164: goto +51 -> 215
    //   167: aconst_null
    //   168: astore_1
    //   169: aload 7
    //   171: astore 6
    //   173: goto +93 -> 266
    //   176: astore_1
    //   177: aconst_null
    //   178: astore 5
    //   180: aload 5
    //   182: astore_0
    //   183: aload 4
    //   185: astore 7
    //   187: aload 5
    //   189: astore 4
    //   191: goto +24 -> 215
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_0
    //   197: astore_1
    //   198: aload 7
    //   200: astore 6
    //   202: goto +64 -> 266
    //   205: astore_1
    //   206: aconst_null
    //   207: astore 4
    //   209: aload 4
    //   211: astore_0
    //   212: aload_0
    //   213: astore 7
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 290	java/io/BufferedInputStream:close	()V
    //   225: aload 6
    //   227: ifnull +8 -> 235
    //   230: aload 6
    //   232: invokevirtual 291	java/io/BufferedOutputStream:close	()V
    //   235: aload 7
    //   237: ifnull +8 -> 245
    //   240: aload 7
    //   242: invokevirtual 164	java/io/InputStream:close	()V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 294	java/io/OutputStream:close	()V
    //   253: aload_1
    //   254: athrow
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_0
    //   258: astore_1
    //   259: aload_1
    //   260: astore 4
    //   262: aload 7
    //   264: astore 6
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 290	java/io/BufferedInputStream:close	()V
    //   274: aload 6
    //   276: ifnull +8 -> 284
    //   279: aload 6
    //   281: invokevirtual 291	java/io/BufferedOutputStream:close	()V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 164	java/io/InputStream:close	()V
    //   294: aload_0
    //   295: ifnull +106 -> 401
    //   298: goto -193 -> 105
    //   301: aload_0
    //   302: invokevirtual 81	java/io/File:isDirectory	()Z
    //   305: ifeq +96 -> 401
    //   308: aload_0
    //   309: invokevirtual 85	java/io/File:listFiles	()[Ljava/io/File;
    //   312: astore_0
    //   313: aload_1
    //   314: invokevirtual 297	java/io/File:mkdir	()Z
    //   317: pop
    //   318: aload_0
    //   319: ifnull +82 -> 401
    //   322: iload_2
    //   323: aload_0
    //   324: arraylength
    //   325: if_icmpge +76 -> 401
    //   328: aload_0
    //   329: iload_2
    //   330: aaload
    //   331: invokevirtual 113	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   334: astore 4
    //   336: new 63	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   343: astore 5
    //   345: aload 5
    //   347: aload_1
    //   348: invokevirtual 113	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   351: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 5
    //   357: getstatic 58	java/io/File:separator	Ljava/lang/String;
    //   360: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 5
    //   366: aload_0
    //   367: iload_2
    //   368: aaload
    //   369: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   372: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 4
    //   378: new 54	java/io/File
    //   381: dup
    //   382: aload 5
    //   384: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: invokestatic 305	btmsdkobf/dz:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   393: pop
    //   394: iload_2
    //   395: iconst_1
    //   396: iadd
    //   397: istore_2
    //   398: goto -76 -> 322
    //   401: iconst_1
    //   402: ireturn
    //   403: astore_0
    //   404: goto -149 -> 255
    //   407: astore_0
    //   408: goto -214 -> 194
    //   411: astore_1
    //   412: goto -245 -> 167
    //   415: astore_1
    //   416: aload 7
    //   418: astore 6
    //   420: aload 5
    //   422: astore_1
    //   423: goto -157 -> 266
    //   426: astore 6
    //   428: goto -297 -> 131
    //   431: astore 5
    //   433: goto -337 -> 96
    //   436: astore_1
    //   437: goto -337 -> 100
    //   440: astore_1
    //   441: goto -336 -> 105
    //   444: astore_0
    //   445: goto -44 -> 401
    //   448: astore 4
    //   450: goto -225 -> 225
    //   453: astore 4
    //   455: goto -220 -> 235
    //   458: astore 4
    //   460: goto -215 -> 245
    //   463: astore_0
    //   464: goto -211 -> 253
    //   467: astore_1
    //   468: goto -194 -> 274
    //   471: astore_1
    //   472: goto -188 -> 284
    //   475: astore_1
    //   476: goto -182 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	paramFile1	File
    //   0	479	1	paramFile2	File
    //   6	392	2	i	int
    //   4	4	3	bool	boolean
    //   25	352	4	localObject1	Object
    //   448	1	4	localException1	java.lang.Exception
    //   453	1	4	localThrowable1	Throwable
    //   458	1	4	localException2	java.lang.Exception
    //   45	376	5	localObject2	Object
    //   431	1	5	localException3	java.lang.Exception
    //   15	404	6	localObject3	Object
    //   426	1	6	localThrowable2	Throwable
    //   12	405	7	localObject4	Object
    //   112	10	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   56	63	112	finally
    //   63	71	112	finally
    //   76	84	112	finally
    //   87	91	112	finally
    //   47	56	140	finally
    //   36	47	152	finally
    //   27	36	176	finally
    //   17	27	205	finally
    //   17	27	403	java/lang/Throwable
    //   27	36	407	java/lang/Throwable
    //   36	47	411	java/lang/Throwable
    //   47	56	415	java/lang/Throwable
    //   56	63	426	java/lang/Throwable
    //   63	71	426	java/lang/Throwable
    //   76	84	426	java/lang/Throwable
    //   87	91	426	java/lang/Throwable
    //   91	96	431	java/lang/Exception
    //   96	100	436	java/lang/Throwable
    //   100	105	440	java/lang/Exception
    //   105	109	444	java/lang/Exception
    //   220	225	448	java/lang/Exception
    //   230	235	453	java/lang/Throwable
    //   240	245	458	java/lang/Exception
    //   249	253	463	java/lang/Exception
    //   270	274	467	java/lang/Exception
    //   279	284	471	java/lang/Throwable
    //   289	294	475	java/lang/Exception
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete failed: ");
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
    //   1: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 44
    //   9: areturn
    //   10: invokestatic 361	btmsdkobf/bc:n	()Landroid/content/Context;
    //   13: astore 9
    //   15: new 63	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   22: astore 5
    //   24: aload 5
    //   26: aload 9
    //   28: invokevirtual 366	android/content/Context:getFilesDir	()Ljava/io/File;
    //   31: invokevirtual 367	java/io/File:toString	()Ljava/lang/String;
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
    //   87: ifeq +189 -> 276
    //   90: iload_1
    //   91: ifeq +185 -> 276
    //   94: aload 9
    //   96: invokevirtual 371	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   99: aload_0
    //   100: iconst_1
    //   101: invokevirtual 377	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   104: astore 5
    //   106: iconst_4
    //   107: newarray byte
    //   109: astore 11
    //   111: aload 5
    //   113: aload 11
    //   115: invokevirtual 153	java/io/InputStream:read	([B)I
    //   118: pop
    //   119: aload 5
    //   121: aload 11
    //   123: invokevirtual 153	java/io/InputStream:read	([B)I
    //   126: pop
    //   127: aload 11
    //   129: invokestatic 237	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   132: istore_3
    //   133: aload 5
    //   135: ifnull +11 -> 146
    //   138: aload 5
    //   140: invokevirtual 164	java/io/InputStream:close	()V
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
    //   180: invokestatic 237	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   183: istore_2
    //   184: aload 5
    //   186: invokevirtual 42	java/io/FileInputStream:close	()V
    //   189: goto +91 -> 280
    //   192: astore_0
    //   193: goto +10 -> 203
    //   196: goto +25 -> 221
    //   199: astore_0
    //   200: aconst_null
    //   201: astore 5
    //   203: aload 5
    //   205: ifnull +11 -> 216
    //   208: aload 5
    //   210: invokevirtual 42	java/io/FileInputStream:close	()V
    //   213: goto +3 -> 216
    //   216: aload_0
    //   217: athrow
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 42	java/io/FileInputStream:close	()V
    //   231: aload 8
    //   233: areturn
    //   234: astore_0
    //   235: goto +10 -> 245
    //   238: goto +25 -> 263
    //   241: astore_0
    //   242: aconst_null
    //   243: astore 5
    //   245: aload 5
    //   247: ifnull +11 -> 258
    //   250: aload 5
    //   252: invokevirtual 164	java/io/InputStream:close	()V
    //   255: goto +3 -> 258
    //   258: aload_0
    //   259: athrow
    //   260: aconst_null
    //   261: astore 5
    //   263: aload 5
    //   265: ifnull +8 -> 273
    //   268: aload 5
    //   270: invokevirtual 164	java/io/InputStream:close	()V
    //   273: aload 8
    //   275: areturn
    //   276: iconst_0
    //   277: istore_2
    //   278: iconst_0
    //   279: istore_3
    //   280: iload_1
    //   281: ifeq +29 -> 310
    //   284: iload 4
    //   286: ifeq +8 -> 294
    //   289: iload_3
    //   290: iload_2
    //   291: if_icmpgt +19 -> 310
    //   294: iload 4
    //   296: ifne +6 -> 302
    //   299: goto +11 -> 310
    //   302: aconst_null
    //   303: astore_0
    //   304: aload_0
    //   305: astore 5
    //   307: goto +83 -> 390
    //   310: iload 4
    //   312: ifeq +9 -> 321
    //   315: aload 10
    //   317: invokevirtual 99	java/io/File:delete	()Z
    //   320: pop
    //   321: aload 9
    //   323: invokevirtual 381	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   326: invokevirtual 384	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   329: aload_0
    //   330: iconst_1
    //   331: invokevirtual 377	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   334: astore_0
    //   335: new 124	java/io/FileOutputStream
    //   338: dup
    //   339: aload 10
    //   341: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   344: astore 5
    //   346: sipush 8192
    //   349: newarray byte
    //   351: astore 6
    //   353: aload_0
    //   354: aload 6
    //   356: invokevirtual 153	java/io/InputStream:read	([B)I
    //   359: istore_2
    //   360: iload_2
    //   361: ifle +15 -> 376
    //   364: aload 5
    //   366: aload 6
    //   368: iconst_0
    //   369: iload_2
    //   370: invokevirtual 385	java/io/FileOutputStream:write	([BII)V
    //   373: goto -20 -> 353
    //   376: aload 5
    //   378: invokevirtual 389	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   381: iconst_1
    //   382: invokevirtual 395	java/nio/channels/FileChannel:force	(Z)V
    //   385: aload 5
    //   387: invokevirtual 396	java/io/FileOutputStream:flush	()V
    //   390: aload_0
    //   391: ifnull +10 -> 401
    //   394: aload_0
    //   395: invokevirtual 164	java/io/InputStream:close	()V
    //   398: goto +3 -> 401
    //   401: aload 5
    //   403: ifnull +8 -> 411
    //   406: aload 5
    //   408: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   411: aload 8
    //   413: areturn
    //   414: astore 7
    //   416: aload_0
    //   417: astore 6
    //   419: aload 7
    //   421: astore_0
    //   422: goto +31 -> 453
    //   425: astore 5
    //   427: aconst_null
    //   428: astore 7
    //   430: aload_0
    //   431: astore 6
    //   433: aload 5
    //   435: astore_0
    //   436: aload 7
    //   438: astore 5
    //   440: goto +13 -> 453
    //   443: aconst_null
    //   444: astore 5
    //   446: goto +38 -> 484
    //   449: astore_0
    //   450: aconst_null
    //   451: astore 5
    //   453: aload 6
    //   455: ifnull +11 -> 466
    //   458: aload 6
    //   460: invokevirtual 164	java/io/InputStream:close	()V
    //   463: goto +3 -> 466
    //   466: aload 5
    //   468: ifnull +8 -> 476
    //   471: aload 5
    //   473: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   476: aload_0
    //   477: athrow
    //   478: aconst_null
    //   479: astore 5
    //   481: aload 7
    //   483: astore_0
    //   484: aload_0
    //   485: ifnull +10 -> 495
    //   488: aload_0
    //   489: invokevirtual 164	java/io/InputStream:close	()V
    //   492: goto +3 -> 495
    //   495: aload 5
    //   497: ifnull +8 -> 505
    //   500: aload 5
    //   502: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   505: aload 8
    //   507: areturn
    //   508: astore_0
    //   509: goto -31 -> 478
    //   512: astore_0
    //   513: goto -253 -> 260
    //   516: astore_0
    //   517: goto -279 -> 238
    //   520: astore_0
    //   521: aload 8
    //   523: areturn
    //   524: astore_0
    //   525: goto -307 -> 218
    //   528: astore_0
    //   529: goto -333 -> 196
    //   532: astore_0
    //   533: aload 8
    //   535: areturn
    //   536: astore_0
    //   537: aload 8
    //   539: areturn
    //   540: astore_0
    //   541: aload 8
    //   543: areturn
    //   544: astore_0
    //   545: aload 8
    //   547: areturn
    //   548: astore_0
    //   549: aload 8
    //   551: areturn
    //   552: astore 5
    //   554: goto -111 -> 443
    //   557: astore 6
    //   559: goto -113 -> 446
    //   562: astore_0
    //   563: goto -162 -> 401
    //   566: astore_0
    //   567: aload 8
    //   569: areturn
    //   570: astore 6
    //   572: goto -106 -> 466
    //   575: astore 5
    //   577: goto -101 -> 476
    //   580: astore_0
    //   581: goto -86 -> 495
    //   584: astore_0
    //   585: aload 8
    //   587: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramString	String
    //   0	588	1	paramBoolean	boolean
    //   183	187	2	i	int
    //   132	160	3	j	int
    //   83	228	4	bool	boolean
    //   22	385	5	localObject1	Object
    //   425	9	5	localObject2	Object
    //   438	63	5	localObject3	Object
    //   552	1	5	localThrowable1	Throwable
    //   575	1	5	localIOException1	java.io.IOException
    //   65	394	6	localObject4	Object
    //   557	1	6	localThrowable2	Throwable
    //   570	1	6	localIOException2	java.io.IOException
    //   62	1	7	localObject5	Object
    //   414	6	7	localObject6	Object
    //   428	54	7	localObject7	Object
    //   59	527	8	str	String
    //   13	309	9	localContext	Context
    //   76	264	10	localFile	File
    //   109	70	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   157	184	192	finally
    //   146	157	199	finally
    //   106	133	234	finally
    //   94	106	241	finally
    //   346	353	414	finally
    //   353	360	414	finally
    //   364	373	414	finally
    //   376	390	414	finally
    //   335	346	425	finally
    //   67	85	449	finally
    //   138	143	449	finally
    //   184	189	449	finally
    //   208	213	449	finally
    //   216	218	449	finally
    //   226	231	449	finally
    //   250	255	449	finally
    //   258	260	449	finally
    //   268	273	449	finally
    //   315	321	449	finally
    //   321	335	449	finally
    //   67	85	508	java/lang/Throwable
    //   216	218	508	java/lang/Throwable
    //   258	260	508	java/lang/Throwable
    //   315	321	508	java/lang/Throwable
    //   321	335	508	java/lang/Throwable
    //   94	106	512	java/lang/Throwable
    //   106	133	516	java/lang/Throwable
    //   138	143	520	java/lang/Throwable
    //   146	157	524	java/lang/Throwable
    //   157	184	528	java/lang/Throwable
    //   184	189	532	java/lang/Throwable
    //   208	213	536	java/lang/Throwable
    //   226	231	540	java/lang/Throwable
    //   250	255	544	java/lang/Throwable
    //   268	273	548	java/lang/Throwable
    //   335	346	552	java/lang/Throwable
    //   346	353	557	java/lang/Throwable
    //   353	360	557	java/lang/Throwable
    //   364	373	557	java/lang/Throwable
    //   376	390	557	java/lang/Throwable
    //   394	398	562	java/io/IOException
    //   406	411	566	java/io/IOException
    //   458	463	570	java/io/IOException
    //   471	476	575	java/io/IOException
    //   488	492	580	java/io/IOException
    //   500	505	584	java/io/IOException
  }
  
  /* Error */
  public static tmsdk.QQPIM.CommList loadWupObjectFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 400	tmsdk/QQPIM/CommList
    //   12: dup
    //   13: invokespecial 401	tmsdk/QQPIM/CommList:<init>	()V
    //   16: astore 4
    //   18: new 54	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 78	java/io/File:exists	()Z
    //   31: ifne +5 -> 36
    //   34: aconst_null
    //   35: areturn
    //   36: new 403	com/qq/jce/wup/UniAttribute
    //   39: dup
    //   40: invokespecial 404	com/qq/jce/wup/UniAttribute:<init>	()V
    //   43: astore 5
    //   45: new 12	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore_3
    //   54: iconst_4
    //   55: newarray byte
    //   57: astore 6
    //   59: aload_3
    //   60: aload 6
    //   62: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   65: pop
    //   66: aload 6
    //   68: invokestatic 237	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   71: pop
    //   72: aload_3
    //   73: aload 6
    //   75: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   78: pop
    //   79: aload 6
    //   81: invokestatic 237	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   84: pop
    //   85: bipush 16
    //   87: newarray byte
    //   89: astore 6
    //   91: aload_3
    //   92: aload 6
    //   94: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   97: pop
    //   98: aload_3
    //   99: invokevirtual 22	java/io/FileInputStream:available	()I
    //   102: newarray byte
    //   104: astore 7
    //   106: aload_3
    //   107: aload 7
    //   109: invokevirtual 29	java/io/FileInputStream:read	([B)I
    //   112: pop
    //   113: aload 7
    //   115: invokestatic 410	com/tmsdk/base/utils/MD5Util:encrypt	([B)[B
    //   118: invokestatic 413	com/tmsdk/base/utils/ConvertUtil:bytesToHexString	([B)Ljava/lang/String;
    //   121: aload 6
    //   123: invokestatic 413	com/tmsdk/base/utils/ConvertUtil:bytesToHexString	([B)Ljava/lang/String;
    //   126: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifne +5 -> 134
    //   132: aconst_null
    //   133: areturn
    //   134: aload 7
    //   136: aconst_null
    //   137: invokestatic 419	tmsdk/common/tcc/b:decrypt	([B[B)[B
    //   140: astore 6
    //   142: aload_1
    //   143: ifnull +16 -> 159
    //   146: aload_1
    //   147: invokevirtual 422	java/lang/String:length	()I
    //   150: ifle +9 -> 159
    //   153: aload 5
    //   155: aload_1
    //   156: invokevirtual 425	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   159: aload 5
    //   161: aload 6
    //   163: invokevirtual 427	com/qq/jce/wup/UniAttribute:decode	([B)V
    //   166: aload_0
    //   167: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   170: astore_1
    //   171: aload_1
    //   172: ldc_w 429
    //   175: invokevirtual 432	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   178: istore_2
    //   179: aload_1
    //   180: astore_0
    //   181: iload_2
    //   182: ifle +10 -> 192
    //   185: aload_1
    //   186: iconst_0
    //   187: iload_2
    //   188: invokevirtual 321	java/lang/String:substring	(II)Ljava/lang/String;
    //   191: astore_0
    //   192: aload 5
    //   194: aload_0
    //   195: aload 4
    //   197: invokevirtual 436	com/qq/jce/wup/UniAttribute:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: checkcast 400	tmsdk/QQPIM/CommList
    //   203: astore_0
    //   204: aload_0
    //   205: areturn
    //   206: aload_3
    //   207: astore_0
    //   208: goto +5 -> 213
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 42	java/io/FileInputStream:close	()V
    //   221: aload 4
    //   223: areturn
    //   224: astore_0
    //   225: goto -14 -> 211
    //   228: astore_0
    //   229: goto -23 -> 206
    //   232: astore_0
    //   233: goto -12 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString1	String
    //   0	236	1	paramString2	String
    //   178	10	2	i	int
    //   53	154	3	localFileInputStream	FileInputStream
    //   16	206	4	localCommList	tmsdk.QQPIM.CommList
    //   43	150	5	localUniAttribute	com.qq.jce.wup.UniAttribute
    //   57	105	6	arrayOfByte1	byte[]
    //   104	31	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	34	224	java/lang/Throwable
    //   36	54	224	java/lang/Throwable
    //   54	132	228	java/lang/Throwable
    //   134	142	228	java/lang/Throwable
    //   146	159	228	java/lang/Throwable
    //   159	179	228	java/lang/Throwable
    //   185	192	228	java/lang/Throwable
    //   192	204	228	java/lang/Throwable
    //   217	221	232	java/lang/Throwable
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