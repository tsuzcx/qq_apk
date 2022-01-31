package btmsdkobf;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.base.utils.ConvertUtil;
import com.tmsdk.base.utils.FileOP.CheckResult;
import com.tmsdk.base.utils.HttpGetFile;
import com.tmsdk.base.utils.MD5Util;
import java.io.File;
import java.io.FileInputStream;
import tmsdk.QQPIM.CommList;
import tmsdk.common.tcc.b;

public class dz
{
  /* Error */
  public static byte[] G(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 10	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 14	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 16	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokevirtual 20	java/io/FileInputStream:available	()I
    //   20: invokespecial 23	java/io/ByteArrayOutputStream:<init>	(I)V
    //   23: astore_3
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore_0
    //   30: aload_2
    //   31: aload_0
    //   32: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: iflt +40 -> 77
    //   40: aload_3
    //   41: aload_0
    //   42: iconst_0
    //   43: iload_1
    //   44: invokevirtual 31	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -17 -> 30
    //   50: astore_0
    //   51: aload_3
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   61: aload_2
    //   62: ifnull +120 -> 182
    //   65: aload_2
    //   66: invokevirtual 36	java/io/FileInputStream:close	()V
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +63 -> 135
    //   75: aload_0
    //   76: areturn
    //   77: aload_3
    //   78: invokevirtual 40	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: astore_0
    //   82: aload_3
    //   83: ifnull +7 -> 90
    //   86: aload_3
    //   87: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   90: aload_2
    //   91: ifnull +96 -> 187
    //   94: aload_2
    //   95: invokevirtual 36	java/io/FileInputStream:close	()V
    //   98: goto -27 -> 71
    //   101: astore_2
    //   102: goto -31 -> 71
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -37 -> 71
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_2
    //   114: aload 4
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 36	java/io/FileInputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: ldc 42
    //   137: invokevirtual 47	java/lang/String:getBytes	()[B
    //   140: areturn
    //   141: astore_3
    //   142: goto -52 -> 90
    //   145: astore_0
    //   146: goto -85 -> 61
    //   149: astore_3
    //   150: goto -25 -> 125
    //   153: astore_2
    //   154: goto -21 -> 133
    //   157: astore_0
    //   158: aload 4
    //   160: astore_3
    //   161: goto -44 -> 117
    //   164: astore_0
    //   165: goto -48 -> 117
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_2
    //   173: goto -120 -> 53
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_0
    //   179: goto -126 -> 53
    //   182: aconst_null
    //   183: astore_0
    //   184: goto -113 -> 71
    //   187: goto -116 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   35	9	1	i	int
    //   11	84	2	localFileInputStream	FileInputStream
    //   101	1	2	localThrowable1	Throwable
    //   113	17	2	localObject1	Object
    //   153	1	2	localThrowable2	Throwable
    //   172	1	2	localObject2	Object
    //   23	99	3	localObject3	Object
    //   141	1	3	localThrowable3	Throwable
    //   149	1	3	localThrowable4	Throwable
    //   160	1	3	localObject4	Object
    //   1	158	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   24	30	50	java/lang/Throwable
    //   30	36	50	java/lang/Throwable
    //   40	47	50	java/lang/Throwable
    //   77	82	50	java/lang/Throwable
    //   94	98	101	java/lang/Throwable
    //   65	69	105	java/lang/Throwable
    //   3	12	111	finally
    //   86	90	141	java/lang/Throwable
    //   57	61	145	java/lang/Throwable
    //   121	125	149	java/lang/Throwable
    //   129	133	153	java/lang/Throwable
    //   12	24	157	finally
    //   24	30	164	finally
    //   30	36	164	finally
    //   40	47	164	finally
    //   77	82	164	finally
    //   3	12	168	java/lang/Throwable
    //   12	24	176	java/lang/Throwable
  }
  
  public static boolean H(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator)) {
      localObject = paramString + File.separator;
    }
    paramString = new File((String)localObject);
    label59:
    int i;
    int j;
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      break label107;
      return false;
    }
    else
    {
      localObject = paramString.listFiles();
      i = 0;
      j = 1;
    }
    for (;;)
    {
      if (i < localObject.length)
      {
        if (localObject[i].isFile())
        {
          bool = deleteFile(localObject[i].getAbsolutePath());
          j = bool;
          if (bool) {
            break label139;
          }
          j = bool;
        }
      }
      else
      {
        label107:
        if ((j == 0) || (!paramString.delete())) {
          break label59;
        }
        return true;
      }
      boolean bool = H(localObject[i].getAbsolutePath());
      j = bool;
      if (!bool) {
        break;
      }
      j = bool;
      label139:
      i += 1;
    }
  }
  
  public static String a(File paramFile)
  {
    try
    {
      paramFile = b(new FileInputStream(paramFile));
      return paramFile;
    }
    catch (Throwable paramFile) {}
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
    //   6: iload_2
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 5
    //   16: astore_3
    //   17: new 52	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload 5
    //   28: astore_3
    //   29: aload_1
    //   30: invokevirtual 76	java/io/File:exists	()Z
    //   33: ifne +25 -> 58
    //   36: aload 5
    //   38: astore_3
    //   39: aload_1
    //   40: invokevirtual 111	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   43: invokevirtual 114	java/io/File:getParentFile	()Ljava/io/File;
    //   46: invokevirtual 117	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload 5
    //   52: astore_3
    //   53: aload_1
    //   54: invokevirtual 120	java/io/File:createNewFile	()Z
    //   57: pop
    //   58: aload 5
    //   60: astore_3
    //   61: new 122	java/io/FileOutputStream
    //   64: dup
    //   65: aload_1
    //   66: iconst_0
    //   67: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 128	java/io/FileOutputStream:write	([B)V
    //   76: iconst_1
    //   77: istore_2
    //   78: aload_1
    //   79: ifnull -73 -> 6
    //   82: aload_1
    //   83: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_0
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_1
    //   92: aload 4
    //   94: astore_0
    //   95: aload_0
    //   96: astore_3
    //   97: ldc 131
    //   99: new 61	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   106: ldc 133
    //   108: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 134	java/lang/Throwable:toString	()Ljava/lang/String;
    //   115: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 140	btmsdkobf/eg:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: ifnull -119 -> 6
    //   128: aload_0
    //   129: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_0
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_0
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore_1
    //   149: goto -3 -> 146
    //   152: astore_0
    //   153: aload_1
    //   154: astore_3
    //   155: goto -17 -> 138
    //   158: astore_3
    //   159: aload_1
    //   160: astore_0
    //   161: aload_3
    //   162: astore_1
    //   163: goto -68 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramArrayOfByte	byte[]
    //   0	166	1	paramString	String
    //   1	77	2	bool	boolean
    //   16	139	3	localObject1	Object
    //   158	4	3	localThrowable	Throwable
    //   12	81	4	localObject2	Object
    //   9	50	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   82	86	88	java/lang/Throwable
    //   17	26	91	java/lang/Throwable
    //   29	36	91	java/lang/Throwable
    //   39	50	91	java/lang/Throwable
    //   53	58	91	java/lang/Throwable
    //   61	71	91	java/lang/Throwable
    //   128	132	134	java/lang/Throwable
    //   17	26	137	finally
    //   29	36	137	finally
    //   39	50	137	finally
    //   53	58	137	finally
    //   61	71	137	finally
    //   97	124	137	finally
    //   142	146	148	java/lang/Throwable
    //   71	76	152	finally
    //   71	76	158	java/lang/Throwable
  }
  
  /* Error */
  public static String b(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +61 -> 67
    //   9: ldc 142
    //   11: invokestatic 148	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   14: astore_2
    //   15: sipush 8192
    //   18: newarray byte
    //   20: astore_3
    //   21: aload_0
    //   22: aload_3
    //   23: invokevirtual 151	java/io/InputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_m1
    //   29: if_icmpeq +30 -> 59
    //   32: aload_2
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 154	java/security/MessageDigest:update	([BII)V
    //   39: goto -18 -> 21
    //   42: astore_2
    //   43: aload 4
    //   45: astore_3
    //   46: aload_0
    //   47: ifnull +10 -> 57
    //   50: aload_0
    //   51: invokevirtual 155	java/io/InputStream:close	()V
    //   54: aload 4
    //   56: astore_3
    //   57: aload_3
    //   58: areturn
    //   59: aload_2
    //   60: invokevirtual 158	java/security/MessageDigest:digest	()[B
    //   63: invokestatic 162	btmsdkobf/dz:bytesToString	([B)Ljava/lang/String;
    //   66: astore_2
    //   67: aload_2
    //   68: astore_3
    //   69: aload_0
    //   70: ifnull -13 -> 57
    //   73: aload_0
    //   74: invokevirtual 155	java/io/InputStream:close	()V
    //   77: aload_2
    //   78: areturn
    //   79: astore_0
    //   80: aload_2
    //   81: areturn
    //   82: astore_2
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 155	java/io/InputStream:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_0
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: goto -6 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramInputStream	java.io.InputStream
    //   26	10	1	i	int
    //   1	32	2	localMessageDigest	java.security.MessageDigest
    //   42	18	2	localThrowable	Throwable
    //   66	15	2	str	String
    //   82	10	2	localObject1	Object
    //   20	49	3	localObject2	Object
    //   3	52	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	42	java/lang/Throwable
    //   21	27	42	java/lang/Throwable
    //   32	39	42	java/lang/Throwable
    //   59	67	42	java/lang/Throwable
    //   73	77	79	java/lang/Throwable
    //   9	21	82	finally
    //   21	27	82	finally
    //   32	39	82	finally
    //   59	67	82	finally
    //   50	54	93	java/lang/Throwable
    //   87	91	96	java/lang/Throwable
  }
  
  public static String bytesToString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp6_5 = arrayOfChar1;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4 & 0xF)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
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
  public static FileOP.CheckResult check(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    // Byte code:
    //   0: new 197	com/tmsdk/base/utils/FileOP$CheckResult
    //   3: dup
    //   4: invokespecial 198	com/tmsdk/base/utils/FileOP$CheckResult:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: putfield 201	com/tmsdk/base/utils/FileOP$CheckResult:mFileName	Ljava/lang/String;
    //   15: new 203	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 204	java/util/ArrayList:<init>	()V
    //   22: astore 7
    //   24: new 206	tmsdk/Protocol/MConfigUpdate/ClientConfInfo
    //   27: dup
    //   28: invokespecial 207	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:<init>	()V
    //   31: astore 8
    //   33: aload 8
    //   35: iload_0
    //   36: putfield 211	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:fileId	I
    //   39: aload 7
    //   41: aload 8
    //   43: invokevirtual 214	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: iload_3
    //   48: ifle +95 -> 143
    //   51: aload 8
    //   53: iload_2
    //   54: putfield 217	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:version	I
    //   57: aload 8
    //   59: iload_3
    //   60: putfield 220	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:timestamp	I
    //   63: aload 8
    //   65: aload 4
    //   67: putfield 224	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:md5Bin	[B
    //   70: new 226	tmsdk/Protocol/MConfigUpdate/CSConfInfo
    //   73: dup
    //   74: invokespecial 227	tmsdk/Protocol/MConfigUpdate/CSConfInfo:<init>	()V
    //   77: astore 4
    //   79: aload 4
    //   81: aload 7
    //   83: putfield 231	tmsdk/Protocol/MConfigUpdate/CSConfInfo:vecInfo	Ljava/util/ArrayList;
    //   86: aload 4
    //   88: iconst_1
    //   89: putfield 234	tmsdk/Protocol/MConfigUpdate/CSConfInfo:updatetype	I
    //   92: new 4	java/lang/Object
    //   95: dup
    //   96: invokespecial 235	java/lang/Object:<init>	()V
    //   99: astore_1
    //   100: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   103: pop2
    //   104: bipush 108
    //   106: aload 4
    //   108: new 243	tmsdk/Protocol/MConfigUpdate/SCConfInfo
    //   111: dup
    //   112: invokespecial 244	tmsdk/Protocol/MConfigUpdate/SCConfInfo:<init>	()V
    //   115: iconst_0
    //   116: new 246	btmsdkobf/ir
    //   119: dup
    //   120: aload 6
    //   122: aload_1
    //   123: invokespecial 249	btmsdkobf/ir:<init>	(Lcom/tmsdk/base/utils/FileOP$CheckResult;Ljava/lang/Object;)V
    //   126: iload 5
    //   128: i2l
    //   129: invokestatic 255	com/tmsdk/base/TMSDKBaseContext:sendShark	(ILcom/qq/taf/jce/JceStruct;Lcom/qq/taf/jce/JceStruct;ILcom/tmsdk/base/ISharkCallBackOut;J)V
    //   132: aload_1
    //   133: monitorenter
    //   134: aload_1
    //   135: invokevirtual 258	java/lang/Object:wait	()V
    //   138: aload_1
    //   139: monitorexit
    //   140: aload 6
    //   142: areturn
    //   143: new 52	java/io/File
    //   146: dup
    //   147: aload_1
    //   148: iconst_1
    //   149: invokestatic 264	com/tmsdk/base/utils/FileOP:getAssetWupFile	(Ljava/lang/String;Z)Ljava/lang/String;
    //   152: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 76	java/io/File:exists	()Z
    //   160: ifeq +120 -> 280
    //   163: aconst_null
    //   164: astore 4
    //   166: new 10	java/io/FileInputStream
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: astore_1
    //   175: iconst_4
    //   176: newarray byte
    //   178: astore 4
    //   180: aload_1
    //   181: aload 4
    //   183: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   186: pop
    //   187: aload 8
    //   189: aload 4
    //   191: invokestatic 269	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   194: putfield 217	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:version	I
    //   197: aload_1
    //   198: aload 4
    //   200: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   203: pop
    //   204: aload 8
    //   206: aload 4
    //   208: invokestatic 269	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   211: putfield 220	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:timestamp	I
    //   214: bipush 16
    //   216: newarray byte
    //   218: astore 4
    //   220: aload_1
    //   221: aload 4
    //   223: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   226: pop
    //   227: aload 8
    //   229: aload 4
    //   231: putfield 224	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:md5Bin	[B
    //   234: aload_1
    //   235: ifnull -165 -> 70
    //   238: aload_1
    //   239: invokevirtual 36	java/io/FileInputStream:close	()V
    //   242: goto -172 -> 70
    //   245: astore_1
    //   246: goto -176 -> 70
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull -183 -> 70
    //   256: aload_1
    //   257: invokevirtual 36	java/io/FileInputStream:close	()V
    //   260: goto -190 -> 70
    //   263: astore_1
    //   264: goto -194 -> 70
    //   267: astore_1
    //   268: aload 4
    //   270: ifnull +8 -> 278
    //   273: aload 4
    //   275: invokevirtual 36	java/io/FileInputStream:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: aload 8
    //   282: iconst_0
    //   283: putfield 217	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:version	I
    //   286: aload 8
    //   288: iconst_0
    //   289: putfield 220	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:timestamp	I
    //   292: aload 8
    //   294: iconst_0
    //   295: newarray byte
    //   297: putfield 224	tmsdk/Protocol/MConfigUpdate/ClientConfInfo:md5Bin	[B
    //   300: goto -230 -> 70
    //   303: astore 4
    //   305: aload_1
    //   306: monitorexit
    //   307: aload 4
    //   309: athrow
    //   310: astore 4
    //   312: goto -34 -> 278
    //   315: astore 4
    //   317: goto -179 -> 138
    //   320: astore 6
    //   322: aload_1
    //   323: astore 4
    //   325: aload 6
    //   327: astore_1
    //   328: goto -60 -> 268
    //   331: astore 4
    //   333: goto -81 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramInt1	int
    //   0	336	1	paramString	String
    //   0	336	2	paramInt2	int
    //   0	336	3	paramInt3	int
    //   0	336	4	paramArrayOfByte	byte[]
    //   0	336	5	paramInt4	int
    //   7	134	6	localCheckResult	FileOP.CheckResult
    //   320	6	6	localObject	Object
    //   22	60	7	localArrayList	java.util.ArrayList
    //   31	262	8	localClientConfInfo	tmsdk.Protocol.MConfigUpdate.ClientConfInfo
    // Exception table:
    //   from	to	target	type
    //   238	242	245	java/lang/Throwable
    //   166	175	249	java/lang/Throwable
    //   256	260	263	java/lang/Throwable
    //   166	175	267	finally
    //   134	138	303	finally
    //   138	140	303	finally
    //   305	307	303	finally
    //   273	278	310	java/lang/Throwable
    //   134	138	315	java/lang/Throwable
    //   175	234	320	finally
    //   175	234	331	java/lang/Throwable
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: invokevirtual 86	java/io/File:isFile	()Z
    //   12: ifeq +212 -> 224
    //   15: new 10	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: new 122	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_3
    //   33: new 276	java/io/BufferedInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 279	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore 4
    //   43: new 281	java/io/BufferedOutputStream
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 284	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: astore 5
    //   53: sipush 8192
    //   56: newarray byte
    //   58: astore_1
    //   59: aload 4
    //   61: aload_1
    //   62: invokevirtual 285	java/io/BufferedInputStream:read	([B)I
    //   65: istore_2
    //   66: iload_2
    //   67: iconst_m1
    //   68: if_icmpeq +58 -> 126
    //   71: aload 5
    //   73: aload_1
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 286	java/io/BufferedOutputStream:write	([BII)V
    //   79: goto -20 -> 59
    //   82: astore_1
    //   83: aload_3
    //   84: astore_1
    //   85: aload_0
    //   86: astore_3
    //   87: aload 5
    //   89: astore_0
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 287	java/io/BufferedInputStream:close	()V
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 288	java/io/BufferedOutputStream:close	()V
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 155	java/io/InputStream:close	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 291	java/io/OutputStream:close	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: aload 5
    //   128: invokevirtual 294	java/io/BufferedOutputStream:flush	()V
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 287	java/io/BufferedInputStream:close	()V
    //   141: aload 5
    //   143: ifnull +8 -> 151
    //   146: aload 5
    //   148: invokevirtual 288	java/io/BufferedOutputStream:close	()V
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 155	java/io/InputStream:close	()V
    //   159: aload_3
    //   160: ifnull -36 -> 124
    //   163: aload_3
    //   164: invokevirtual 291	java/io/OutputStream:close	()V
    //   167: goto -43 -> 124
    //   170: astore_0
    //   171: goto -47 -> 124
    //   174: astore_1
    //   175: aconst_null
    //   176: astore 4
    //   178: aconst_null
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_0
    //   182: aload 6
    //   184: astore 5
    //   186: aload 4
    //   188: ifnull +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 287	java/io/BufferedInputStream:close	()V
    //   196: aload 5
    //   198: ifnull +8 -> 206
    //   201: aload 5
    //   203: invokevirtual 288	java/io/BufferedOutputStream:close	()V
    //   206: aload_0
    //   207: ifnull +7 -> 214
    //   210: aload_0
    //   211: invokevirtual 155	java/io/InputStream:close	()V
    //   214: aload_3
    //   215: ifnull +7 -> 222
    //   218: aload_3
    //   219: invokevirtual 291	java/io/OutputStream:close	()V
    //   222: aload_1
    //   223: athrow
    //   224: aload_0
    //   225: invokevirtual 79	java/io/File:isDirectory	()Z
    //   228: ifeq -104 -> 124
    //   231: aload_0
    //   232: invokevirtual 83	java/io/File:listFiles	()[Ljava/io/File;
    //   235: astore_0
    //   236: aload_1
    //   237: invokevirtual 297	java/io/File:mkdir	()Z
    //   240: pop
    //   241: aload_0
    //   242: ifnull -118 -> 124
    //   245: iload_2
    //   246: aload_0
    //   247: arraylength
    //   248: if_icmpge -124 -> 124
    //   251: aload_0
    //   252: iload_2
    //   253: aaload
    //   254: invokevirtual 111	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   257: new 52	java/io/File
    //   260: dup
    //   261: new 61	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   268: aload_1
    //   269: invokevirtual 111	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   272: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: getstatic 56	java/io/File:separator	Ljava/lang/String;
    //   278: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: iload_2
    //   283: aaload
    //   284: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   287: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   296: invokestatic 305	btmsdkobf/dz:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   299: pop
    //   300: iload_2
    //   301: iconst_1
    //   302: iadd
    //   303: istore_2
    //   304: goto -59 -> 245
    //   307: astore_1
    //   308: goto -167 -> 141
    //   311: astore_1
    //   312: goto -161 -> 151
    //   315: astore_0
    //   316: goto -157 -> 159
    //   319: astore 4
    //   321: goto -221 -> 100
    //   324: astore_0
    //   325: goto -217 -> 108
    //   328: astore_0
    //   329: goto -213 -> 116
    //   332: astore_0
    //   333: goto -209 -> 124
    //   336: astore 4
    //   338: goto -142 -> 196
    //   341: astore 4
    //   343: goto -137 -> 206
    //   346: astore_0
    //   347: goto -133 -> 214
    //   350: astore_0
    //   351: goto -129 -> 222
    //   354: astore_1
    //   355: aconst_null
    //   356: astore 4
    //   358: aconst_null
    //   359: astore_3
    //   360: aload 6
    //   362: astore 5
    //   364: goto -178 -> 186
    //   367: astore_1
    //   368: aconst_null
    //   369: astore 4
    //   371: aload 6
    //   373: astore 5
    //   375: goto -189 -> 186
    //   378: astore_1
    //   379: aload 6
    //   381: astore 5
    //   383: goto -197 -> 186
    //   386: astore_1
    //   387: goto -201 -> 186
    //   390: astore_0
    //   391: aconst_null
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_3
    //   397: aload 5
    //   399: astore 4
    //   401: goto -311 -> 90
    //   404: astore_1
    //   405: aconst_null
    //   406: astore 4
    //   408: aconst_null
    //   409: astore_1
    //   410: aload_0
    //   411: astore_3
    //   412: aload 4
    //   414: astore_0
    //   415: aload 5
    //   417: astore 4
    //   419: goto -329 -> 90
    //   422: astore_1
    //   423: aconst_null
    //   424: astore 4
    //   426: aload_3
    //   427: astore_1
    //   428: aload_0
    //   429: astore_3
    //   430: aload 4
    //   432: astore_0
    //   433: aload 5
    //   435: astore 4
    //   437: goto -347 -> 90
    //   440: astore_1
    //   441: aconst_null
    //   442: astore 5
    //   444: aload_3
    //   445: astore_1
    //   446: aload_0
    //   447: astore_3
    //   448: aload 5
    //   450: astore_0
    //   451: goto -361 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	paramFile1	File
    //   0	454	1	paramFile2	File
    //   1	303	2	i	int
    //   32	416	3	localObject1	Object
    //   41	151	4	localBufferedInputStream	java.io.BufferedInputStream
    //   319	1	4	localException1	java.lang.Exception
    //   336	1	4	localException2	java.lang.Exception
    //   341	1	4	localThrowable	Throwable
    //   356	80	4	localObject2	Object
    //   6	443	5	localObject3	Object
    //   3	377	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   53	59	82	java/lang/Throwable
    //   59	66	82	java/lang/Throwable
    //   71	79	82	java/lang/Throwable
    //   126	131	82	java/lang/Throwable
    //   163	167	170	java/lang/Exception
    //   15	24	174	finally
    //   136	141	307	java/lang/Exception
    //   146	151	311	java/lang/Throwable
    //   155	159	315	java/lang/Exception
    //   95	100	319	java/lang/Exception
    //   104	108	324	java/lang/Throwable
    //   112	116	328	java/lang/Exception
    //   120	124	332	java/lang/Exception
    //   191	196	336	java/lang/Exception
    //   201	206	341	java/lang/Throwable
    //   210	214	346	java/lang/Exception
    //   218	222	350	java/lang/Exception
    //   24	33	354	finally
    //   33	43	367	finally
    //   43	53	378	finally
    //   53	59	386	finally
    //   59	66	386	finally
    //   71	79	386	finally
    //   126	131	386	finally
    //   15	24	390	java/lang/Throwable
    //   24	33	404	java/lang/Throwable
    //   33	43	422	java/lang/Throwable
    //   43	53	440	java/lang/Throwable
  }
  
  public static final String d(String paramString1, String paramString2)
  {
    int i;
    if (0 == 0)
    {
      str = Uri.decode(paramString1);
      if (str != null)
      {
        i = str.indexOf('?');
        paramString1 = str;
        if (i > 0) {
          paramString1 = str.substring(0, i);
        }
        if (!paramString1.endsWith("/"))
        {
          i = paramString1.lastIndexOf('/') + 1;
          if (i <= 0) {}
        }
      }
    }
    for (String str = paramString1.substring(i);; str = null)
    {
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
  }
  
  public static boolean deleteDir(File paramFile)
  {
    boolean bool1 = true;
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int m = arrayOfString.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        if (!deleteDir(new File(paramFile, arrayOfString[j]))) {
          i = 0;
        }
        j += 1;
      }
    }
    int k = 1;
    boolean bool2 = paramFile.delete();
    if ((k != 0) && (bool2)) {}
    for (;;)
    {
      if (!bool1) {
        eg.f("FileUtil", "delete failed: " + paramFile.getAbsolutePath());
      }
      return bool1;
      bool1 = false;
    }
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
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 8
    //   11: aload_0
    //   12: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +10 -> 25
    //   18: ldc 42
    //   20: astore 6
    //   22: aload 6
    //   24: areturn
    //   25: invokestatic 361	btmsdkobf/bc:n	()Landroid/content/Context;
    //   28: astore 11
    //   30: new 61	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   37: aload 11
    //   39: invokevirtual 366	android/content/Context:getFilesDir	()Ljava/io/File;
    //   42: invokevirtual 367	java/io/File:toString	()Ljava/lang/String;
    //   45: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 56	java/io/File:separator	Ljava/lang/String;
    //   51: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 7
    //   63: new 52	java/io/File
    //   66: dup
    //   67: aload 7
    //   69: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 10
    //   74: aload 10
    //   76: invokevirtual 76	java/io/File:exists	()Z
    //   79: istore 4
    //   81: iload 4
    //   83: ifeq +730 -> 813
    //   86: iload_1
    //   87: ifeq +726 -> 813
    //   90: aload 11
    //   92: invokevirtual 371	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   95: aload_0
    //   96: iconst_1
    //   97: invokevirtual 377	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   100: astore 5
    //   102: iconst_4
    //   103: newarray byte
    //   105: astore 12
    //   107: aload 5
    //   109: aload 12
    //   111: invokevirtual 151	java/io/InputStream:read	([B)I
    //   114: pop
    //   115: aload 5
    //   117: aload 12
    //   119: invokevirtual 151	java/io/InputStream:read	([B)I
    //   122: pop
    //   123: aload 12
    //   125: invokestatic 269	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   128: istore_3
    //   129: aload 5
    //   131: ifnull +8 -> 139
    //   134: aload 5
    //   136: invokevirtual 155	java/io/InputStream:close	()V
    //   139: new 10	java/io/FileInputStream
    //   142: dup
    //   143: aload 10
    //   145: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: iconst_4
    //   151: newarray byte
    //   153: astore 12
    //   155: aload 5
    //   157: aload 12
    //   159: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   162: pop
    //   163: aload 5
    //   165: aload 12
    //   167: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   170: pop
    //   171: aload 12
    //   173: invokestatic 269	com/tmsdk/base/utils/ConvertUtil:bytesToInt	([B)I
    //   176: istore_2
    //   177: aload 5
    //   179: ifnull +631 -> 810
    //   182: aload 5
    //   184: invokevirtual 36	java/io/FileInputStream:close	()V
    //   187: iload_1
    //   188: ifeq +18 -> 206
    //   191: iload 4
    //   193: ifeq +8 -> 201
    //   196: iload_3
    //   197: iload_2
    //   198: if_icmpgt +8 -> 206
    //   201: iload 4
    //   203: ifne +598 -> 801
    //   206: iload 4
    //   208: ifeq +9 -> 217
    //   211: aload 10
    //   213: invokevirtual 95	java/io/File:delete	()Z
    //   216: pop
    //   217: aload 11
    //   219: invokevirtual 381	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   222: invokevirtual 384	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   225: aload_0
    //   226: iconst_1
    //   227: invokevirtual 377	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   230: astore_0
    //   231: new 122	java/io/FileOutputStream
    //   234: dup
    //   235: aload 10
    //   237: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   240: astore 5
    //   242: sipush 8192
    //   245: newarray byte
    //   247: astore 6
    //   249: aload_0
    //   250: aload 6
    //   252: invokevirtual 151	java/io/InputStream:read	([B)I
    //   255: istore_2
    //   256: iload_2
    //   257: ifle +403 -> 660
    //   260: aload 5
    //   262: aload 6
    //   264: iconst_0
    //   265: iload_2
    //   266: invokevirtual 385	java/io/FileOutputStream:write	([BII)V
    //   269: goto -20 -> 249
    //   272: astore 6
    //   274: aload_0
    //   275: ifnull +7 -> 282
    //   278: aload_0
    //   279: invokevirtual 155	java/io/InputStream:close	()V
    //   282: aload 7
    //   284: astore 6
    //   286: aload 5
    //   288: ifnull -266 -> 22
    //   291: aload 5
    //   293: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   296: aload 7
    //   298: areturn
    //   299: astore_0
    //   300: aload 7
    //   302: areturn
    //   303: astore_0
    //   304: iconst_0
    //   305: ifeq +11 -> 316
    //   308: new 387	java/lang/NullPointerException
    //   311: dup
    //   312: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   315: athrow
    //   316: aload 7
    //   318: astore 6
    //   320: iconst_0
    //   321: ifeq -299 -> 22
    //   324: new 387	java/lang/NullPointerException
    //   327: dup
    //   328: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   331: athrow
    //   332: astore_0
    //   333: aload 7
    //   335: areturn
    //   336: astore_0
    //   337: aconst_null
    //   338: astore 5
    //   340: aload 5
    //   342: ifnull +8 -> 350
    //   345: aload 5
    //   347: invokevirtual 155	java/io/InputStream:close	()V
    //   350: iconst_0
    //   351: ifeq +11 -> 362
    //   354: new 387	java/lang/NullPointerException
    //   357: dup
    //   358: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   361: athrow
    //   362: aload 7
    //   364: astore 6
    //   366: iconst_0
    //   367: ifeq -345 -> 22
    //   370: new 387	java/lang/NullPointerException
    //   373: dup
    //   374: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   377: athrow
    //   378: astore_0
    //   379: aload 7
    //   381: areturn
    //   382: astore_0
    //   383: iconst_0
    //   384: ifeq +11 -> 395
    //   387: new 387	java/lang/NullPointerException
    //   390: dup
    //   391: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   394: athrow
    //   395: aload 7
    //   397: astore 6
    //   399: iconst_0
    //   400: ifeq -378 -> 22
    //   403: new 387	java/lang/NullPointerException
    //   406: dup
    //   407: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   410: athrow
    //   411: astore_0
    //   412: aload 7
    //   414: areturn
    //   415: astore_0
    //   416: aconst_null
    //   417: astore 5
    //   419: aload 5
    //   421: ifnull +8 -> 429
    //   424: aload 5
    //   426: invokevirtual 155	java/io/InputStream:close	()V
    //   429: aload_0
    //   430: athrow
    //   431: astore_0
    //   432: aconst_null
    //   433: astore_0
    //   434: aload 8
    //   436: astore 5
    //   438: goto -164 -> 274
    //   441: astore_0
    //   442: iconst_0
    //   443: ifeq +11 -> 454
    //   446: new 387	java/lang/NullPointerException
    //   449: dup
    //   450: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   453: athrow
    //   454: aload 7
    //   456: astore 6
    //   458: iconst_0
    //   459: ifeq -437 -> 22
    //   462: new 387	java/lang/NullPointerException
    //   465: dup
    //   466: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   469: athrow
    //   470: astore_0
    //   471: aload 7
    //   473: areturn
    //   474: astore_0
    //   475: iconst_0
    //   476: ifeq +11 -> 487
    //   479: new 387	java/lang/NullPointerException
    //   482: dup
    //   483: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   486: athrow
    //   487: aload 7
    //   489: astore 6
    //   491: iconst_0
    //   492: ifeq -470 -> 22
    //   495: new 387	java/lang/NullPointerException
    //   498: dup
    //   499: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   502: athrow
    //   503: astore_0
    //   504: aload 7
    //   506: areturn
    //   507: astore_0
    //   508: aconst_null
    //   509: astore 5
    //   511: aload 5
    //   513: ifnull +8 -> 521
    //   516: aload 5
    //   518: invokevirtual 36	java/io/FileInputStream:close	()V
    //   521: iconst_0
    //   522: ifeq +11 -> 533
    //   525: new 387	java/lang/NullPointerException
    //   528: dup
    //   529: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   532: athrow
    //   533: aload 7
    //   535: astore 6
    //   537: iconst_0
    //   538: ifeq -516 -> 22
    //   541: new 387	java/lang/NullPointerException
    //   544: dup
    //   545: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   548: athrow
    //   549: astore_0
    //   550: aload 7
    //   552: areturn
    //   553: astore_0
    //   554: iconst_0
    //   555: ifeq +11 -> 566
    //   558: new 387	java/lang/NullPointerException
    //   561: dup
    //   562: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   565: athrow
    //   566: aload 7
    //   568: astore 6
    //   570: iconst_0
    //   571: ifeq -549 -> 22
    //   574: new 387	java/lang/NullPointerException
    //   577: dup
    //   578: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   581: athrow
    //   582: astore_0
    //   583: aload 7
    //   585: areturn
    //   586: astore_0
    //   587: aconst_null
    //   588: astore 5
    //   590: aload 5
    //   592: ifnull +8 -> 600
    //   595: aload 5
    //   597: invokevirtual 36	java/io/FileInputStream:close	()V
    //   600: aload_0
    //   601: athrow
    //   602: astore 5
    //   604: aconst_null
    //   605: astore_0
    //   606: aload_0
    //   607: ifnull +7 -> 614
    //   610: aload_0
    //   611: invokevirtual 155	java/io/InputStream:close	()V
    //   614: aload 6
    //   616: ifnull +8 -> 624
    //   619: aload 6
    //   621: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   624: aload 5
    //   626: athrow
    //   627: astore_0
    //   628: iconst_0
    //   629: ifeq +11 -> 640
    //   632: new 387	java/lang/NullPointerException
    //   635: dup
    //   636: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   639: athrow
    //   640: aload 7
    //   642: astore 6
    //   644: iconst_0
    //   645: ifeq -623 -> 22
    //   648: new 387	java/lang/NullPointerException
    //   651: dup
    //   652: invokespecial 388	java/lang/NullPointerException:<init>	()V
    //   655: athrow
    //   656: astore_0
    //   657: aload 7
    //   659: areturn
    //   660: aload 5
    //   662: invokevirtual 392	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   665: iconst_1
    //   666: invokevirtual 398	java/nio/channels/FileChannel:force	(Z)V
    //   669: aload 5
    //   671: invokevirtual 399	java/io/FileOutputStream:flush	()V
    //   674: aload_0
    //   675: astore 6
    //   677: aload 5
    //   679: astore_0
    //   680: aload 6
    //   682: ifnull +8 -> 690
    //   685: aload 6
    //   687: invokevirtual 155	java/io/InputStream:close	()V
    //   690: aload 7
    //   692: astore 6
    //   694: aload_0
    //   695: ifnull -673 -> 22
    //   698: aload_0
    //   699: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   702: aload 7
    //   704: areturn
    //   705: astore_0
    //   706: aload 7
    //   708: areturn
    //   709: astore_0
    //   710: goto -394 -> 316
    //   713: astore_0
    //   714: goto -319 -> 395
    //   717: astore_0
    //   718: goto -356 -> 362
    //   721: astore_0
    //   722: goto -268 -> 454
    //   725: astore_0
    //   726: goto -239 -> 487
    //   729: astore_0
    //   730: goto -164 -> 566
    //   733: astore_0
    //   734: goto -201 -> 533
    //   737: astore_0
    //   738: goto -98 -> 640
    //   741: astore 5
    //   743: goto -53 -> 690
    //   746: astore_0
    //   747: goto -465 -> 282
    //   750: astore_0
    //   751: goto -137 -> 614
    //   754: astore_0
    //   755: goto -131 -> 624
    //   758: astore 5
    //   760: goto -154 -> 606
    //   763: astore 7
    //   765: aload 5
    //   767: astore 6
    //   769: aload 7
    //   771: astore 5
    //   773: goto -167 -> 606
    //   776: astore 5
    //   778: aload 8
    //   780: astore 5
    //   782: goto -508 -> 274
    //   785: astore_0
    //   786: goto -196 -> 590
    //   789: astore_0
    //   790: goto -279 -> 511
    //   793: astore_0
    //   794: goto -375 -> 419
    //   797: astore_0
    //   798: goto -458 -> 340
    //   801: aconst_null
    //   802: astore 6
    //   804: aload 9
    //   806: astore_0
    //   807: goto -127 -> 680
    //   810: goto -623 -> 187
    //   813: iconst_0
    //   814: istore_3
    //   815: goto -628 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramString	String
    //   0	818	1	paramBoolean	boolean
    //   1	265	2	i	int
    //   128	687	3	j	int
    //   79	128	4	bool	boolean
    //   100	496	5	localObject1	Object
    //   602	76	5	localObject2	Object
    //   741	1	5	localIOException	java.io.IOException
    //   758	8	5	localObject3	Object
    //   771	1	5	localObject4	Object
    //   776	1	5	localThrowable1	Throwable
    //   780	1	5	localObject5	Object
    //   3	260	6	localObject6	Object
    //   272	1	6	localThrowable2	Throwable
    //   284	519	6	localObject7	Object
    //   61	646	7	str	String
    //   763	7	7	localObject8	Object
    //   9	770	8	localObject9	Object
    //   6	799	9	localObject10	Object
    //   72	164	10	localFile	File
    //   28	190	11	localContext	Context
    //   105	67	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   242	249	272	java/lang/Throwable
    //   249	256	272	java/lang/Throwable
    //   260	269	272	java/lang/Throwable
    //   660	674	272	java/lang/Throwable
    //   291	296	299	java/io/IOException
    //   134	139	303	java/lang/Throwable
    //   324	332	332	java/io/IOException
    //   90	102	336	java/lang/Throwable
    //   370	378	378	java/io/IOException
    //   345	350	382	java/lang/Throwable
    //   403	411	411	java/io/IOException
    //   90	102	415	finally
    //   63	81	431	java/lang/Throwable
    //   211	217	431	java/lang/Throwable
    //   217	231	431	java/lang/Throwable
    //   429	431	431	java/lang/Throwable
    //   600	602	431	java/lang/Throwable
    //   424	429	441	java/lang/Throwable
    //   462	470	470	java/io/IOException
    //   182	187	474	java/lang/Throwable
    //   495	503	503	java/io/IOException
    //   139	150	507	java/lang/Throwable
    //   541	549	549	java/io/IOException
    //   516	521	553	java/lang/Throwable
    //   574	582	582	java/io/IOException
    //   139	150	586	finally
    //   63	81	602	finally
    //   134	139	602	finally
    //   182	187	602	finally
    //   211	217	602	finally
    //   217	231	602	finally
    //   345	350	602	finally
    //   424	429	602	finally
    //   429	431	602	finally
    //   516	521	602	finally
    //   595	600	602	finally
    //   600	602	602	finally
    //   595	600	627	java/lang/Throwable
    //   648	656	656	java/io/IOException
    //   698	702	705	java/io/IOException
    //   308	316	709	java/io/IOException
    //   387	395	713	java/io/IOException
    //   354	362	717	java/io/IOException
    //   446	454	721	java/io/IOException
    //   479	487	725	java/io/IOException
    //   558	566	729	java/io/IOException
    //   525	533	733	java/io/IOException
    //   632	640	737	java/io/IOException
    //   685	690	741	java/io/IOException
    //   278	282	746	java/io/IOException
    //   610	614	750	java/io/IOException
    //   619	624	754	java/io/IOException
    //   231	242	758	finally
    //   242	249	763	finally
    //   249	256	763	finally
    //   260	269	763	finally
    //   660	674	763	finally
    //   231	242	776	java/lang/Throwable
    //   150	177	785	finally
    //   150	177	789	java/lang/Throwable
    //   102	129	793	finally
    //   102	129	797	java/lang/Throwable
  }
  
  public static CommList loadWupObjectFromFile(String paramString1, String paramString2)
  {
    byte[] arrayOfByte1 = null;
    if (TextUtils.isEmpty(paramString1)) {}
    CommList localCommList;
    for (;;)
    {
      return null;
      localCommList = new CommList();
      try
      {
        paramString1 = new File(paramString1);
        if (paramString1.exists())
        {
          localUniAttribute = new UniAttribute();
          localFileInputStream = new FileInputStream(paramString1);
        }
      }
      catch (Throwable paramString1)
      {
        try
        {
          UniAttribute localUniAttribute;
          arrayOfByte1 = new byte[4];
          localFileInputStream.read(arrayOfByte1);
          ConvertUtil.bytesToInt(arrayOfByte1);
          localFileInputStream.read(arrayOfByte1);
          ConvertUtil.bytesToInt(arrayOfByte1);
          arrayOfByte1 = new byte[16];
          localFileInputStream.read(arrayOfByte1);
          byte[] arrayOfByte2 = new byte[localFileInputStream.available()];
          localFileInputStream.read(arrayOfByte2);
          if (!ConvertUtil.bytesToHexString(MD5Util.encrypt(arrayOfByte2)).equals(ConvertUtil.bytesToHexString(arrayOfByte1))) {
            continue;
          }
          arrayOfByte1 = b.decrypt(arrayOfByte2, null);
          if ((paramString2 != null) && (paramString2.length() > 0)) {
            localUniAttribute.setEncodeName(paramString2);
          }
          localUniAttribute.decode(arrayOfByte1);
          paramString2 = paramString1.getName();
          int i = paramString2.lastIndexOf(".");
          paramString1 = paramString2;
          if (i > 0) {
            paramString1 = paramString2.substring(0, i);
          }
          paramString1 = (CommList)localUniAttribute.getByClass(paramString1, localCommList);
          return paramString1;
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            FileInputStream localFileInputStream;
            label217:
            paramString1 = localFileInputStream;
          }
        }
        paramString1 = paramString1;
        paramString1 = arrayOfByte1;
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return localCommList;
          }
          catch (Throwable paramString1)
          {
            break label217;
          }
        }
      }
    }
    return localCommList;
  }
  
  public static int update(FileOP.CheckResult paramCheckResult)
  {
    if (paramCheckResult.mStatusCode == -209) {
      return -209;
    }
    if ((paramCheckResult != null) && (paramCheckResult.mStatusCode == -208) && (!TextUtils.isEmpty(paramCheckResult.mUrl)) && (!TextUtils.isEmpty(paramCheckResult.mFileName)))
    {
      HttpGetFile localHttpGetFile = new HttpGetFile(TMSDKBaseContext.getApplicationContext());
      localHttpGetFile.setSavePath(TMSDKBaseContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/");
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