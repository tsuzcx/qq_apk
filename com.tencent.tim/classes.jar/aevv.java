import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.MD5;

public class aevv
  extends aevq
  implements aevr
{
  public boolean bWH = true;
  private HashSet<String> bb;
  private HashMap<String, Long> ke = new HashMap(8);
  
  public aevv(short paramShort, byte paramByte)
  {
    super(paramShort, paramByte);
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 36	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_2
    //   13: invokevirtual 43	java/io/File:exists	()Z
    //   16: ifne +86 -> 102
    //   19: aload_2
    //   20: invokevirtual 46	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 48	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: iconst_1
    //   30: invokespecial 51	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   33: astore_2
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 55	java/io/FileOutputStream:write	([B)V
    //   39: aload_2
    //   40: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   43: aload_2
    //   44: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   47: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   50: ldc 70
    //   52: iconst_0
    //   53: invokevirtual 74	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   56: invokeinterface 80 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 82
    //   65: lload_3
    //   66: invokeinterface 88 4 0
    //   71: pop
    //   72: aload_1
    //   73: invokeinterface 91 1 0
    //   78: pop
    //   79: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +11 -> 93
    //   85: ldc 98
    //   87: iconst_2
    //   88: ldc 100
    //   90: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   101: return
    //   102: aload_2
    //   103: invokevirtual 107	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_2
    //   108: invokevirtual 46	java/io/File:createNewFile	()Z
    //   111: pop
    //   112: goto -88 -> 24
    //   115: astore_1
    //   116: aload 5
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull -19 -> 101
    //   123: aload_1
    //   124: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: return
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: goto -5 -> 141
    //   149: astore_1
    //   150: goto -17 -> 133
    //   153: astore_1
    //   154: aload_2
    //   155: astore_1
    //   156: goto -37 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	aevv
    //   0	159	1	paramArrayOfByte	byte[]
    //   0	159	2	paramString	String
    //   0	159	3	paramLong	long
    //   10	107	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	24	115	java/lang/Exception
    //   24	34	115	java/lang/Exception
    //   102	112	115	java/lang/Exception
    //   123	127	128	java/lang/Exception
    //   12	24	130	finally
    //   24	34	130	finally
    //   102	112	130	finally
    //   97	101	143	java/lang/Exception
    //   137	141	145	java/lang/Exception
    //   34	93	149	finally
    //   34	93	153	java/lang/Exception
  }
  
  private void deleteFile(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label25;
      }
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return;
      label25:
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          break;
        }
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  private boolean g(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_1
    //   7: istore_3
    //   8: new 36	java/io/File
    //   11: dup
    //   12: new 127	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 133	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 143
    //   33: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: new 36	java/io/File
    //   47: dup
    //   48: new 127	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   55: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   58: invokevirtual 133	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 148
    //   69: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_2
    //   83: aload 6
    //   85: invokevirtual 43	java/io/File:exists	()Z
    //   88: ifne +9 -> 97
    //   91: aload 6
    //   93: invokevirtual 151	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aload_2
    //   98: invokevirtual 43	java/io/File:exists	()Z
    //   101: ifne +45 -> 146
    //   104: aload_2
    //   105: invokevirtual 46	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 48	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: iconst_1
    //   115: invokespecial 51	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   118: astore_2
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 55	java/io/FileOutputStream:write	([B)V
    //   124: aload_2
    //   125: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   128: aload_2
    //   129: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 153	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 154	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iload_3
    //   145: ireturn
    //   146: aload_2
    //   147: invokevirtual 107	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_2
    //   152: invokevirtual 46	java/io/File:createNewFile	()Z
    //   155: pop
    //   156: goto -47 -> 109
    //   159: astore_1
    //   160: aload 4
    //   162: astore_1
    //   163: iconst_0
    //   164: istore_3
    //   165: aload_1
    //   166: ifnull -22 -> 144
    //   169: aload_1
    //   170: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_1
    //   190: aload 5
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   208: goto -7 -> 201
    //   211: astore_1
    //   212: goto -19 -> 193
    //   215: astore_1
    //   216: aload_2
    //   217: astore_1
    //   218: goto -55 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	aevv
    //   0	221	1	paramArrayOfByte	byte[]
    //   0	221	2	paramString	String
    //   7	158	3	bool	boolean
    //   4	157	4	localObject1	Object
    //   1	190	5	localObject2	Object
    //   42	50	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	97	159	java/lang/Exception
    //   97	109	159	java/lang/Exception
    //   109	119	159	java/lang/Exception
    //   146	156	159	java/lang/Exception
    //   169	173	175	java/io/IOException
    //   136	144	182	java/io/IOException
    //   83	97	189	finally
    //   97	109	189	finally
    //   109	119	189	finally
    //   146	156	189	finally
    //   197	201	203	java/io/IOException
    //   119	132	211	finally
    //   119	132	215	java/lang/Exception
  }
  
  /* Error */
  private boolean h(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_1
    //   7: istore_3
    //   8: new 36	java/io/File
    //   11: dup
    //   12: new 127	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 133	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 160
    //   33: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 162
    //   38: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: new 36	java/io/File
    //   52: dup
    //   53: new 127	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   60: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: invokevirtual 133	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   66: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 160
    //   74: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 162
    //   79: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 160
    //   84: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 7
    //   99: aload 4
    //   101: astore_2
    //   102: aload 6
    //   104: invokevirtual 43	java/io/File:exists	()Z
    //   107: ifne +12 -> 119
    //   110: aload 4
    //   112: astore_2
    //   113: aload 6
    //   115: invokevirtual 151	java/io/File:mkdirs	()Z
    //   118: pop
    //   119: aload 4
    //   121: astore_2
    //   122: aload 7
    //   124: invokevirtual 43	java/io/File:exists	()Z
    //   127: ifne +57 -> 184
    //   130: aload 4
    //   132: astore_2
    //   133: aload 7
    //   135: invokevirtual 46	java/io/File:createNewFile	()Z
    //   138: pop
    //   139: aload 4
    //   141: astore_2
    //   142: new 48	java/io/FileOutputStream
    //   145: dup
    //   146: aload 7
    //   148: iconst_1
    //   149: invokespecial 51	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   152: astore 4
    //   154: aload 4
    //   156: aload_1
    //   157: invokevirtual 55	java/io/FileOutputStream:write	([B)V
    //   160: aload 4
    //   162: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   165: aload 4
    //   167: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   170: iconst_0
    //   171: ifeq +11 -> 182
    //   174: new 153	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 154	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: iload_3
    //   183: ireturn
    //   184: aload 4
    //   186: astore_2
    //   187: aload 7
    //   189: invokevirtual 107	java/io/File:delete	()Z
    //   192: pop
    //   193: aload 4
    //   195: astore_2
    //   196: aload 7
    //   198: invokevirtual 46	java/io/File:createNewFile	()Z
    //   201: pop
    //   202: goto -63 -> 139
    //   205: astore 4
    //   207: aload 5
    //   209: astore_1
    //   210: aload_1
    //   211: astore_2
    //   212: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +15 -> 230
    //   218: aload_1
    //   219: astore_2
    //   220: ldc 164
    //   222: iconst_2
    //   223: ldc 166
    //   225: aload 4
    //   227: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: iconst_0
    //   231: istore_3
    //   232: aload_1
    //   233: ifnull -51 -> 182
    //   236: aload_1
    //   237: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   254: iconst_1
    //   255: ireturn
    //   256: astore_1
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_2
    //   268: aload_2
    //   269: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   272: goto -7 -> 265
    //   275: astore_1
    //   276: aload 4
    //   278: astore_2
    //   279: goto -22 -> 257
    //   282: astore_2
    //   283: aload 4
    //   285: astore_1
    //   286: aload_2
    //   287: astore 4
    //   289: goto -79 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	aevv
    //   0	292	1	paramArrayOfByte	byte[]
    //   0	292	2	paramString	String
    //   7	225	3	bool	boolean
    //   1	193	4	localFileOutputStream	java.io.FileOutputStream
    //   205	79	4	localException	Exception
    //   287	1	4	str	String
    //   4	204	5	localObject	Object
    //   47	67	6	localFile1	File
    //   97	100	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   102	110	205	java/lang/Exception
    //   113	119	205	java/lang/Exception
    //   122	130	205	java/lang/Exception
    //   133	139	205	java/lang/Exception
    //   142	154	205	java/lang/Exception
    //   187	193	205	java/lang/Exception
    //   196	202	205	java/lang/Exception
    //   236	240	242	java/io/IOException
    //   174	182	249	java/io/IOException
    //   102	110	256	finally
    //   113	119	256	finally
    //   122	130	256	finally
    //   133	139	256	finally
    //   142	154	256	finally
    //   187	193	256	finally
    //   196	202	256	finally
    //   212	218	256	finally
    //   220	230	256	finally
    //   261	265	267	java/io/IOException
    //   154	170	275	finally
    //   154	170	282	java/lang/Exception
  }
  
  public long E(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.size())) {
      return 0L;
    }
    return ((aevv.a)this.items.get(paramInt)).WR;
  }
  
  public void HA(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://"))) {}
    do
    {
      return;
      if (this.cType == 2) {
        synchronized (this.ke)
        {
          if ((this.ke.containsKey(paramString)) && (Math.abs(System.currentTimeMillis() - ((Long)this.ke.get(paramString)).longValue()) < 36000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicAndAdConf", 2, "sendImgRequest | retry interval is too small, " + paramString);
            }
            return;
          }
        }
      }
      if (this.bb == null) {
        this.bb = new HashSet();
      }
      this.bb.add(paramString);
      ??? = aehp.a();
    } while (??? == null);
    ((HttpCommunicator)???).a(new aqog(paramString, null, this, true));
  }
  
  public void Hp(String paramString) {}
  
  public aevv.a a(long paramLong, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6)
  {
    aevv.a locala = new aevv.a();
    locala.WR = paramLong;
    locala.description = paramString1;
    locala.bCq = paramString2;
    locala.aaK = paramString3;
    locala.bp = paramByte;
    locala.imagePath = paramString4;
    locala.time = paramString5;
    locala.ac = paramShort;
    locala.md5 = paramString6;
    locala.retry = 0;
    return locala;
  }
  
  public aevv.a a(long paramLong, String paramString1, byte paramByte, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    aevv.a locala = new aevv.a();
    locala.WR = paramLong;
    locala.description = paramString1;
    locala.bCq = paramString2;
    locala.imageData = paramArrayOfByte;
    locala.aaK = paramString3;
    locala.bp = paramByte;
    locala.retry = 0;
    return locala;
  }
  
  public aevv.a a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramString3, paramString4, paramString5, paramShort, "");
  }
  
  public aevv.a a(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramArrayOfByte, paramString3);
  }
  
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    if ((paramaqog1 == null) || (paramaqog2 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "flashlogo request huibao decode ");
    }
    j(paramaqog1.getUrl(), paramaqog2.aB());
  }
  
  public void a(DataOutputStream paramDataOutputStream)
    throws Exception
  {
    paramDataOutputStream.writeShort(this.ab);
    paramDataOutputStream.writeLong(this.WM);
    paramDataOutputStream.writeLong(this.WN);
    paramDataOutputStream.writeLong(this.WO);
    paramDataOutputStream.writeByte(this.cType);
    if ((this.items == null) || (this.items.size() == 0))
    {
      paramDataOutputStream.writeInt(0);
      return;
    }
    int j = this.items.size();
    paramDataOutputStream.writeInt(j);
    int i = 0;
    label78:
    aevv.a locala;
    if (i < j)
    {
      locala = (aevv.a)this.items.get(i);
      if (this.cType != 2) {
        break label117;
      }
      locala.c(paramDataOutputStream);
    }
    for (;;)
    {
      i += 1;
      break label78;
      break;
      label117:
      locala.b(paramDataOutputStream);
    }
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    if (paramInt == 3)
    {
      paramaqog2 = paramaqog2.pK("Content-Type");
      paramaqog1 = null;
      if (paramaqog2 != null) {
        paramaqog1 = paramaqog2.toLowerCase();
      }
      if ((paramaqog1 != null) && (paramaqog1.indexOf("image") != -1)) {
        return true;
      }
    }
    return false;
  }
  
  public String b(String paramString, byte paramByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    switch (paramByte)
    {
    default: 
      str = paramString;
    }
    for (;;)
    {
      paramString = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShanPing", 2, "flashlogo final request url = " + str);
      return str;
      str = paramString;
      if (!paramString.startsWith("/"))
      {
        str = "/" + paramString;
        continue;
        if ((paramString.startsWith("http://")) && (!paramString.endsWith(".png")))
        {
          if (this.cType == 6) {
            str = paramString + "_" + aehp.bi + "_" + aehp.bh + ".png";
          } else if (this.cType == 0) {
            str = paramString + "_" + (aehp.bh - 2) + ".png";
          } else if ((this.cType == 1) && (paramString.contains("[]"))) {
            str = paramString.replace("[]", aqgz.hI() + "x" + aqgz.hJ());
          } else {
            str = paramString + "_" + aehp.bh + ".png";
          }
        }
        else
        {
          str = paramString;
          if (paramString.startsWith("http://"))
          {
            str = paramString;
            if (this.cType == 1)
            {
              str = paramString;
              if (paramString.contains("[]")) {
                str = paramString.replace("[]", aqgz.hI() + "x" + aqgz.hJ());
              }
            }
          }
        }
      }
    }
  }
  
  public short b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.size())) {
      return -1;
    }
    return ((aevv.a)this.items.get(paramInt)).ac;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    int i = 0;
    while (i < this.items.size())
    {
      paramaqog2 = (aevv.a)this.items.get(i);
      if (paramaqog1.getUrl().startsWith(paramaqog2.bCq))
      {
        paramaqog2 = aehp.cP();
        if (paramaqog2 == null) {
          break;
        }
        paramaqog2 = paramaqog2.iterator();
        while (paramaqog2.hasNext()) {
          ((aehq)paramaqog2.next()).a(false, this.ab, i, paramaqog1.getUrl());
        }
      }
      i += 1;
    }
  }
  
  public void b(DataInputStream paramDataInputStream)
    throws Exception
  {
    this.ab = paramDataInputStream.readShort();
    this.WM = paramDataInputStream.readLong();
    this.WN = paramDataInputStream.readLong();
    this.WO = paramDataInputStream.readLong();
    this.cType = paramDataInputStream.readByte();
    int j = paramDataInputStream.readInt();
    if (j > 0)
    {
      int i = 0;
      if (i < j)
      {
        aevv.a locala = new aevv.a();
        if (this.cType == 2) {
          locala.d(paramDataInputStream);
        }
        for (;;)
        {
          addElement(locala);
          i += 1;
          break;
          locala.c(paramDataInputStream);
        }
      }
    }
  }
  
  public void cXt()
  {
    File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic");
    try
    {
      deleteFile(localFile);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void cXu()
  {
    if (this.cType == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownload NearbyBanner image");
      int i = 0;
      if (i < this.items.size())
      {
        aevv.a locala = (aevv.a)this.items.get(i);
        if (locala.imagePath != null)
        {
          File localFile = new File(locala.imagePath);
          if ((!localFile.exists()) || (!localFile.canRead())) {
            break label92;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label92:
          localStringBuilder.append(" | ").append(locala.WR);
          ThreadManager.post(new PicAndAdConf.1(this, locala), 5, null, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicAndAdConf", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void clearUp()
  {
    Hx(true);
    long l = this.WO;
    this.WN = -1L;
    this.WO = -1L;
    this.items.clear();
    switch (this.cType)
    {
    }
    for (;;)
    {
      return;
      cXt();
      return;
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
      try
      {
        if (localFile.exists())
        {
          localFile.delete();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public String dU(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.size())) {
      return "";
    }
    return ((aevv.a)this.items.get(paramInt)).time;
  }
  
  public String dV(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.size())) {
      return "";
    }
    return ((aevv.a)this.items.get(paramInt)).md5;
  }
  
  public String dW(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.size())) {
      return "";
    }
    return ((aevv.a)this.items.get(paramInt)).aaK;
  }
  
  public void j(String paramString, byte[] arg2)
  {
    if ((??? == null) || (???.length <= 0) || (paramString == null) || (paramString.length() <= 0))
    {
      if (!TextUtils.isEmpty(paramString)) {
        synchronized (this.ke)
        {
          this.ke.put(paramString, Long.valueOf(System.currentTimeMillis()));
          return;
        }
      }
    }
    else
    {
      ArrayList localArrayList = aehp.cP();
      int i = 0;
      while (i < this.items.size())
      {
        aevv.a locala = (aevv.a)this.items.get(i);
        if (paramString.startsWith(locala.bCq))
        {
          if (this.cType == 1)
          {
            locala.imagePath = (BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
            a(???, locala.imagePath, this.WN);
            if (localArrayList == null) {
              break;
            }
            ??? = localArrayList.iterator();
            while (???.hasNext()) {
              ((aehq)???.next()).a(true, this.ab, i, paramString);
            }
          }
          if (this.cType == 0)
          {
            g(???, String.valueOf(locala.md5));
            try
            {
              ??? = new File(locala.imagePath);
              if (!MD5.getFileMD5(???).equalsIgnoreCase(locala.md5))
              {
                ???.delete();
                if (locala.retry < 1)
                {
                  locala.retry += 1;
                  HA(locala.bCq);
                }
              }
              if (localArrayList == null) {
                break;
              }
              ??? = localArrayList.iterator();
              while (???.hasNext()) {
                ((aehq)???.next()).a(true, this.ab, i, paramString);
              }
            }
            catch (Exception ???)
            {
              for (;;)
              {
                ???.printStackTrace();
              }
            }
          }
          if (this.cType != 2) {
            break;
          }
          h(???, String.valueOf(locala.md5));
          for (;;)
          {
            try
            {
              ??? = new File(locala.imagePath);
              paramString = MD5.getFileMD5(???);
              if (!paramString.equalsIgnoreCase(locala.md5))
              {
                ???.delete();
                if (locala.retry >= 1) {
                  break label517;
                }
                locala.retry += 1;
                HA(locala.bCq);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PicAndAdConf", 2, "handle download NearbyBanner image, cid = " + locala.WR + ", md5 is " + paramString.equalsIgnoreCase(locala.md5));
              return;
            }
            catch (Exception paramString)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            QLog.d("PicAndAdConf", 2, "handleImgData exception, item md5 = " + locala.md5, paramString);
            return;
            label517:
            synchronized (this.ke)
            {
              this.ke.put(locala.bCq, Long.valueOf(System.currentTimeMillis()));
            }
          }
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public android.graphics.Bitmap l(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore 5
    //   13: iload_1
    //   14: iflt +18 -> 32
    //   17: iload_1
    //   18: aload_0
    //   19: getfield 175	aevv:items	Ljava/util/ArrayList;
    //   22: invokevirtual 181	java/util/ArrayList:size	()I
    //   25: if_icmplt +10 -> 35
    //   28: aload 4
    //   30: astore 5
    //   32: aload 5
    //   34: areturn
    //   35: aload 7
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 175	aevv:items	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual 185	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 8	aevv$a
    //   50: astore 8
    //   52: aload 7
    //   54: astore 5
    //   56: aload 8
    //   58: getfield 277	aevv$a:bp	B
    //   61: istore_2
    //   62: aload 4
    //   64: astore 5
    //   66: iload_2
    //   67: tableswitch	default:+25 -> 92, 1:+27->94, 2:+-35->32, 3:+44->111
    //   93: areturn
    //   94: aload 7
    //   96: astore 5
    //   98: aload 8
    //   100: getfield 271	aevv$a:bCq	Ljava/lang/String;
    //   103: invokestatic 550	aqcu:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   106: astore 4
    //   108: aload 4
    //   110: areturn
    //   111: aload 7
    //   113: astore 5
    //   115: aload_0
    //   116: getfield 175	aevv:items	Ljava/util/ArrayList;
    //   119: iload_1
    //   120: invokevirtual 185	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   123: checkcast 8	aevv$a
    //   126: getfield 299	aevv$a:imageData	[B
    //   129: astore 9
    //   131: aload 7
    //   133: astore 5
    //   135: aload_0
    //   136: getfield 175	aevv:items	Ljava/util/ArrayList;
    //   139: iload_1
    //   140: invokevirtual 185	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   143: checkcast 8	aevv$a
    //   146: getfield 280	aevv$a:imagePath	Ljava/lang/String;
    //   149: astore 10
    //   151: aload 10
    //   153: ifnull +47 -> 200
    //   156: aload 7
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 208	aevv:cType	B
    //   164: iconst_1
    //   165: if_icmpne +35 -> 200
    //   168: aload 7
    //   170: astore 5
    //   172: aload_0
    //   173: invokevirtual 553	aevv:isOutDate	()Z
    //   176: ifne +24 -> 200
    //   179: aload 7
    //   181: astore 5
    //   183: aload_0
    //   184: invokevirtual 556	aevv:aie	()Z
    //   187: ifne +13 -> 200
    //   190: aload 7
    //   192: astore 5
    //   194: aload 10
    //   196: invokestatic 550	aqcu:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   199: areturn
    //   200: aload 10
    //   202: ifnull +94 -> 296
    //   205: aload 7
    //   207: astore 5
    //   209: aload_0
    //   210: getfield 208	aevv:cType	B
    //   213: ifne +83 -> 296
    //   216: aload 7
    //   218: astore 5
    //   220: new 36	java/io/File
    //   223: dup
    //   224: aload 10
    //   226: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: invokevirtual 43	java/io/File:exists	()Z
    //   232: ifeq +45 -> 277
    //   235: aload 7
    //   237: astore 5
    //   239: aload 10
    //   241: invokestatic 550	aqcu:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   244: astore 4
    //   246: aload 4
    //   248: ifnonnull +263 -> 511
    //   251: aload 8
    //   253: getfield 559	aevv$a:bWI	Z
    //   256: ifeq +255 -> 511
    //   259: aload 8
    //   261: iconst_0
    //   262: putfield 559	aevv$a:bWI	Z
    //   265: aload_0
    //   266: aload 8
    //   268: getfield 271	aevv$a:bCq	Ljava/lang/String;
    //   271: invokevirtual 526	aevv:HA	(Ljava/lang/String;)V
    //   274: aload 4
    //   276: areturn
    //   277: aload 7
    //   279: astore 5
    //   281: aload_0
    //   282: aload 8
    //   284: getfield 271	aevv$a:bCq	Ljava/lang/String;
    //   287: invokevirtual 526	aevv:HA	(Ljava/lang/String;)V
    //   290: aconst_null
    //   291: astore 4
    //   293: goto -19 -> 274
    //   296: aload 7
    //   298: astore 5
    //   300: aload 10
    //   302: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +145 -> 450
    //   308: aload 7
    //   310: astore 5
    //   312: aload_0
    //   313: getfield 208	aevv:cType	B
    //   316: iconst_2
    //   317: if_icmpne +133 -> 450
    //   320: aload 7
    //   322: astore 5
    //   324: new 36	java/io/File
    //   327: dup
    //   328: aload 10
    //   330: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: invokevirtual 43	java/io/File:exists	()Z
    //   336: istore_3
    //   337: aload 6
    //   339: astore 4
    //   341: iload_3
    //   342: ifeq +14 -> 356
    //   345: aload 7
    //   347: astore 5
    //   349: aload 10
    //   351: invokestatic 550	aqcu:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   354: astore 4
    //   356: aload 4
    //   358: astore 5
    //   360: aload 4
    //   362: ifnonnull -330 -> 32
    //   365: aload 4
    //   367: astore 5
    //   369: aload_0
    //   370: aload 8
    //   372: getfield 271	aevv$a:bCq	Ljava/lang/String;
    //   375: invokevirtual 526	aevv:HA	(Ljava/lang/String;)V
    //   378: aload 4
    //   380: areturn
    //   381: astore 6
    //   383: aload 5
    //   385: astore 4
    //   387: aload 4
    //   389: astore 5
    //   391: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -362 -> 32
    //   397: ldc_w 561
    //   400: iconst_2
    //   401: aload 6
    //   403: invokestatic 565	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   406: invokestatic 568	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload 4
    //   411: areturn
    //   412: astore 9
    //   414: aload 6
    //   416: astore 4
    //   418: aload 7
    //   420: astore 5
    //   422: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -69 -> 356
    //   428: aload 7
    //   430: astore 5
    //   432: ldc 164
    //   434: iconst_2
    //   435: ldc_w 570
    //   438: aload 9
    //   440: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   443: aload 6
    //   445: astore 4
    //   447: goto -91 -> 356
    //   450: aload 4
    //   452: astore 5
    //   454: aload 9
    //   456: ifnull -424 -> 32
    //   459: aload 7
    //   461: astore 5
    //   463: aload 9
    //   465: arraylength
    //   466: istore_1
    //   467: aload 4
    //   469: astore 5
    //   471: iload_1
    //   472: ifle -440 -> 32
    //   475: aload 9
    //   477: iconst_0
    //   478: aload 9
    //   480: arraylength
    //   481: invokestatic 576	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   484: astore 4
    //   486: aload 4
    //   488: areturn
    //   489: astore 4
    //   491: aload 6
    //   493: astore 4
    //   495: goto -139 -> 356
    //   498: astore 6
    //   500: goto -113 -> 387
    //   503: astore 4
    //   505: aconst_null
    //   506: areturn
    //   507: astore 4
    //   509: aconst_null
    //   510: areturn
    //   511: goto -237 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	aevv
    //   0	514	1	paramInt	int
    //   61	6	2	i	int
    //   336	6	3	bool	boolean
    //   7	480	4	localObject1	Object
    //   489	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   493	1	4	localThrowable1	java.lang.Throwable
    //   503	1	4	localException1	Exception
    //   507	1	4	localThrowable2	java.lang.Throwable
    //   11	459	5	localObject2	Object
    //   1	337	6	localObject3	Object
    //   381	111	6	localThrowable3	java.lang.Throwable
    //   498	1	6	localThrowable4	java.lang.Throwable
    //   4	456	7	localObject4	Object
    //   50	321	8	locala	aevv.a
    //   129	1	9	arrayOfByte	byte[]
    //   412	67	9	localException2	Exception
    //   149	201	10	str	String
    // Exception table:
    //   from	to	target	type
    //   39	52	381	java/lang/Throwable
    //   56	62	381	java/lang/Throwable
    //   98	108	381	java/lang/Throwable
    //   115	131	381	java/lang/Throwable
    //   135	151	381	java/lang/Throwable
    //   160	168	381	java/lang/Throwable
    //   172	179	381	java/lang/Throwable
    //   183	190	381	java/lang/Throwable
    //   194	200	381	java/lang/Throwable
    //   209	216	381	java/lang/Throwable
    //   220	235	381	java/lang/Throwable
    //   239	246	381	java/lang/Throwable
    //   281	290	381	java/lang/Throwable
    //   300	308	381	java/lang/Throwable
    //   312	320	381	java/lang/Throwable
    //   324	337	381	java/lang/Throwable
    //   349	356	381	java/lang/Throwable
    //   369	378	381	java/lang/Throwable
    //   422	428	381	java/lang/Throwable
    //   432	443	381	java/lang/Throwable
    //   463	467	381	java/lang/Throwable
    //   349	356	412	java/lang/Exception
    //   349	356	489	java/lang/OutOfMemoryError
    //   251	274	498	java/lang/Throwable
    //   98	108	503	java/lang/Exception
    //   475	486	507	java/lang/Throwable
  }
  
  public class a
  {
    protected long WR;
    protected String aaK;
    protected short ac;
    public String bCq;
    protected boolean bWI = true;
    protected byte bp = 3;
    protected String description;
    protected byte[] imageData;
    protected String imagePath;
    protected String md5 = "";
    protected int retry;
    protected String time = "";
    
    public a() {}
    
    public void b(DataOutputStream paramDataOutputStream)
      throws Exception
    {
      if (this.description == null) {
        this.description = "";
      }
      if (this.bCq == null) {
        this.bCq = "";
      }
      if (this.aaK == null) {
        this.aaK = "";
      }
      if (this.imagePath == null) {
        this.imagePath = "";
      }
      paramDataOutputStream.writeLong(this.WR);
      paramDataOutputStream.writeUTF(this.description);
      paramDataOutputStream.writeUTF(this.bCq);
      paramDataOutputStream.writeUTF(this.aaK);
      paramDataOutputStream.writeByte(this.bp);
      paramDataOutputStream.writeUTF(this.imagePath);
      paramDataOutputStream.writeUTF(this.time);
      paramDataOutputStream.writeShort(this.ac);
    }
    
    public void c(DataInputStream paramDataInputStream)
      throws Exception
    {
      this.WR = paramDataInputStream.readLong();
      this.description = paramDataInputStream.readUTF();
      this.bCq = paramDataInputStream.readUTF();
      this.aaK = paramDataInputStream.readUTF();
      this.bp = paramDataInputStream.readByte();
      this.imagePath = paramDataInputStream.readUTF();
      this.time = paramDataInputStream.readUTF();
      this.ac = paramDataInputStream.readShort();
    }
    
    public void c(DataOutputStream paramDataOutputStream)
      throws Exception
    {
      b(paramDataOutputStream);
      if (this.md5 == null) {
        this.md5 = "";
      }
      paramDataOutputStream.writeUTF(this.md5);
    }
    
    public void d(DataInputStream paramDataInputStream)
      throws Exception
    {
      c(paramDataInputStream);
      this.md5 = paramDataInputStream.readUTF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevv
 * JD-Core Version:    0.7.0.1
 */