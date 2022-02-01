import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public abstract class adjk
{
  /* Error */
  public static byte a(int paramInt, String arg1)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_3
    //   2: iload_0
    //   3: iconst_1
    //   4: invokestatic 12	adjk:bt	(IZ)V
    //   7: aload_1
    //   8: iload_0
    //   9: invokestatic 16	adjk:dH	(I)Ljava/lang/String;
    //   12: invokestatic 20	adjk:fn	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 22	java/util/HashMap
    //   18: dup
    //   19: invokespecial 26	java/util/HashMap:<init>	()V
    //   22: astore 6
    //   24: getstatic 32	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: ldc 34
    //   29: iconst_4
    //   30: invokevirtual 38	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: invokeinterface 44 1 0
    //   38: astore 5
    //   40: new 46	java/io/File
    //   43: dup
    //   44: new 48	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   51: iload_0
    //   52: invokestatic 16	adjk:dH	(I)Ljava/lang/String;
    //   55: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 55
    //   60: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 66	java/io/File:exists	()Z
    //   76: ifeq +369 -> 445
    //   79: aconst_null
    //   80: astore_1
    //   81: aload 4
    //   83: invokestatic 72	aqhq:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   86: astore 4
    //   88: aload 4
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +332 -> 424
    //   95: iload_0
    //   96: aload_1
    //   97: aload 6
    //   99: invokestatic 75	adjk:a	(ILjava/lang/String;Ljava/util/HashMap;)Z
    //   102: ifeq +322 -> 424
    //   105: iload_0
    //   106: invokestatic 79	adjk:n	(I)Ljava/lang/Object;
    //   109: astore_1
    //   110: aload_1
    //   111: monitorenter
    //   112: aload 6
    //   114: invokevirtual 83	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   117: invokeinterface 89 1 0
    //   122: astore 4
    //   124: aload 4
    //   126: invokeinterface 94 1 0
    //   131: ifeq +333 -> 464
    //   134: aload 4
    //   136: invokeinterface 98 1 0
    //   141: checkcast 100	java/util/Map$Entry
    //   144: astore 6
    //   146: iload_0
    //   147: aload 6
    //   149: invokeinterface 103 1 0
    //   154: checkcast 105	java/lang/String
    //   157: invokestatic 109	adjk:y	(ILjava/lang/String;)Ljava/lang/String;
    //   160: astore 7
    //   162: new 48	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   169: iload_0
    //   170: invokestatic 16	adjk:dH	(I)Ljava/lang/String;
    //   173: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   179: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 7
    //   184: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 9
    //   192: new 46	java/io/File
    //   195: dup
    //   196: aload 9
    //   198: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 66	java/io/File:exists	()Z
    //   208: ifeq +211 -> 419
    //   211: aload 9
    //   213: invokestatic 119	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 9
    //   218: aload 6
    //   220: invokeinterface 122 1 0
    //   225: checkcast 105	java/lang/String
    //   228: aload 9
    //   230: invokevirtual 126	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   233: ifne +88 -> 321
    //   236: aload 8
    //   238: invokevirtual 129	java/io/File:delete	()Z
    //   241: pop
    //   242: iconst_2
    //   243: istore_2
    //   244: aload 5
    //   246: invokeinterface 134 1 0
    //   251: pop
    //   252: aload_1
    //   253: monitorexit
    //   254: iload_0
    //   255: iconst_0
    //   256: invokestatic 12	adjk:bt	(IZ)V
    //   259: iload_2
    //   260: ireturn
    //   261: astore_1
    //   262: iload_0
    //   263: iconst_0
    //   264: invokestatic 12	adjk:bt	(IZ)V
    //   267: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +31 -> 301
    //   273: ldc 141
    //   275: iconst_2
    //   276: new 48	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   283: ldc 143
    //   285: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokevirtual 146	java/io/IOException:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: iload_0
    //   302: invokestatic 16	adjk:dH	(I)Ljava/lang/String;
    //   305: iconst_0
    //   306: invokestatic 153	aqhq:delete	(Ljava/lang/String;Z)V
    //   309: iconst_m1
    //   310: ireturn
    //   311: astore 4
    //   313: aload 4
    //   315: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   318: goto -227 -> 91
    //   321: aload 5
    //   323: new 48	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   330: ldc 158
    //   332: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 7
    //   337: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: aload 6
    //   345: invokeinterface 122 1 0
    //   350: checkcast 105	java/lang/String
    //   353: invokeinterface 162 3 0
    //   358: pop
    //   359: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -238 -> 124
    //   365: ldc 141
    //   367: iconst_2
    //   368: new 48	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   375: ldc 164
    //   377: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 7
    //   382: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc 166
    //   387: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 6
    //   392: invokeinterface 122 1 0
    //   397: checkcast 105	java/lang/String
    //   400: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: goto -285 -> 124
    //   412: astore 4
    //   414: aload_1
    //   415: monitorexit
    //   416: aload 4
    //   418: athrow
    //   419: iconst_3
    //   420: istore_2
    //   421: goto -177 -> 244
    //   424: iload_3
    //   425: istore_2
    //   426: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -175 -> 254
    //   432: ldc 141
    //   434: iconst_2
    //   435: ldc 168
    //   437: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iload_3
    //   441: istore_2
    //   442: goto -188 -> 254
    //   445: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq +11 -> 459
    //   451: ldc 141
    //   453: iconst_2
    //   454: ldc 170
    //   456: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: iconst_0
    //   460: istore_2
    //   461: goto -207 -> 254
    //   464: iconst_0
    //   465: istore_2
    //   466: goto -222 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramInt	int
    //   243	223	2	b1	byte
    //   1	440	3	b2	byte
    //   69	66	4	localObject1	Object
    //   311	3	4	localIOException	java.io.IOException
    //   412	5	4	localObject2	Object
    //   38	284	5	localEditor	android.content.SharedPreferences.Editor
    //   22	369	6	localObject3	Object
    //   160	221	7	str1	String
    //   201	36	8	localFile	File
    //   190	39	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	15	261	java/io/IOException
    //   81	88	311	java/io/IOException
    //   112	124	412	finally
    //   124	242	412	finally
    //   244	254	412	finally
    //   321	409	412	finally
    //   414	416	412	finally
  }
  
  public static byte a(int paramInt, boolean paramBoolean, String paramString)
  {
    byte b2 = 0;
    byte b1 = 0;
    if (paramString == null) {
      b1 = -1;
    }
    File localFile;
    for (;;)
    {
      return b1;
      String str = dH(paramInt) + File.separator + x(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.BaseMiniSoLoader", 2, "start loadMiniNativeSo: " + str);
      }
      localFile = new File(str);
      if ((!paramBoolean) && (localFile.exists())) {
        try
        {
          SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
          System.load(str);
          if (QLog.isColorLevel())
          {
            QLog.i("MiniRecog.BaseMiniSoLoader", 2, "load " + str + " success!");
            return 0;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          QLog.d("MiniRecog.BaseMiniSoLoader", 1, "load from mini dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
          return -2;
        }
      }
    }
    b1 = b2;
    if (paramBoolean)
    {
      b1 = b2;
      if (!localFile.exists()) {
        b1 = -3;
      }
    }
    b2 = b1;
    if (paramBoolean)
    {
      b2 = b1;
      if (localFile.exists()) {
        b2 = -4;
      }
    }
    b1 = b2;
    if (!paramBoolean)
    {
      b1 = b2;
      if (!localFile.exists()) {
        b1 = -5;
      }
    }
    QLog.d("MiniRecog.BaseMiniSoLoader", 1, "no mini so in mini dir,libName = " + paramString);
    return b1;
  }
  
  public static boolean a(int paramInt, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramInt == 0) {
      return adjs.e(paramString, paramHashMap);
    }
    if (paramInt == 1) {
      return adju.e(paramString, paramHashMap);
    }
    if (paramInt == 2) {
      return adjt.e(paramString, paramHashMap);
    }
    return false;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str1 = dH(paramInt) + File.separator + x(paramInt, paramString);
    Object localObject = new File(str1);
    boolean bool1 = bool3;
    if (!paramBoolean)
    {
      bool1 = bool3;
      if (((File)localObject).exists())
      {
        localObject = n(paramInt);
        bool1 = bool3;
        if (localObject == null) {}
      }
    }
    label273:
    for (;;)
    {
      try
      {
        String str2 = w(paramInt, paramString);
        str1 = alab.getFileMD5String(str1);
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,spmd5 = " + str2 + ",fileMD5 = " + str1);
        }
        if (str2 != null) {
          if (str2.equalsIgnoreCase(str1))
          {
            break label273;
            if (QLog.isColorLevel()) {
              QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,result = " + bool1 + ",isUncompressZip = " + paramBoolean);
            }
            return bool1;
          }
          else
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
            bool1 = bool2;
            continue;
          }
        }
        bool1 = true;
      }
      finally {}
    }
  }
  
  protected static void bt(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      adjs.Gm(paramBoolean);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        adju.Gm(paramBoolean);
        return;
      }
    } while (paramInt != 2);
    adjt.Gm(paramBoolean);
  }
  
  protected static String dH(int paramInt)
  {
    if (paramInt == 0) {
      return adjs.sD();
    }
    if (paramInt == 1) {
      return adju.sD();
    }
    if (paramInt == 2) {
      return adjt.sD();
    }
    return "";
  }
  
  /* Error */
  public static void fn(String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 141
    //   10: iconst_2
    //   11: new 48	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 258
    //   21: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 260	com/tencent/commonsdk/zip/QZipFile
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 261	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 265	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   49: astore 7
    //   51: sipush 8192
    //   54: newarray byte
    //   56: astore 6
    //   58: aload 7
    //   60: invokeinterface 270 1 0
    //   65: ifeq +333 -> 398
    //   68: aload 7
    //   70: invokeinterface 273 1 0
    //   75: checkcast 275	java/util/zip/ZipEntry
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 278	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +413 -> 500
    //   90: aload_0
    //   91: ldc_w 280
    //   94: invokevirtual 284	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifeq +6 -> 103
    //   100: goto -42 -> 58
    //   103: new 48	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   110: aload_1
    //   111: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload 5
    //   130: invokevirtual 287	java/util/zip/ZipEntry:isDirectory	()Z
    //   133: ifeq +27 -> 160
    //   136: new 46	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 66	java/io/File:exists	()Z
    //   149: ifne +354 -> 503
    //   152: aload_0
    //   153: invokevirtual 290	java/io/File:mkdir	()Z
    //   156: pop
    //   157: goto +346 -> 503
    //   160: aload_0
    //   161: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   164: invokevirtual 294	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   167: istore_2
    //   168: aload_0
    //   169: iconst_0
    //   170: iload_2
    //   171: invokevirtual 298	java/lang/String:substring	(II)Ljava/lang/String;
    //   174: astore 8
    //   176: aload_0
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: invokevirtual 300	java/lang/String:substring	(I)Ljava/lang/String;
    //   183: ldc_w 302
    //   186: invokevirtual 305	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   189: ifeq +6 -> 195
    //   192: goto -134 -> 58
    //   195: new 46	java/io/File
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore 8
    //   206: aload 8
    //   208: invokevirtual 66	java/io/File:exists	()Z
    //   211: ifne +9 -> 220
    //   214: aload 8
    //   216: invokevirtual 290	java/io/File:mkdir	()Z
    //   219: pop
    //   220: new 46	java/io/File
    //   223: dup
    //   224: new 48	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   231: aload_0
    //   232: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 307
    //   238: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore 8
    //   249: new 46	java/io/File
    //   252: dup
    //   253: aload_0
    //   254: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: astore 9
    //   259: aload 8
    //   261: invokevirtual 66	java/io/File:exists	()Z
    //   264: ifeq +9 -> 273
    //   267: aload 8
    //   269: invokevirtual 129	java/io/File:delete	()Z
    //   272: pop
    //   273: new 309	java/io/FileOutputStream
    //   276: dup
    //   277: aload 8
    //   279: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: astore_0
    //   283: aload 4
    //   285: aload 5
    //   287: invokevirtual 316	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   290: astore 5
    //   292: aload 5
    //   294: aload 6
    //   296: iconst_0
    //   297: aload 6
    //   299: arraylength
    //   300: invokevirtual 322	java/io/InputStream:read	([BII)I
    //   303: istore_2
    //   304: iload_2
    //   305: iconst_m1
    //   306: if_icmpeq +52 -> 358
    //   309: aload_0
    //   310: aload 6
    //   312: iconst_0
    //   313: iload_2
    //   314: invokevirtual 326	java/io/FileOutputStream:write	([BII)V
    //   317: goto -25 -> 292
    //   320: astore 6
    //   322: aload 5
    //   324: astore_1
    //   325: aload_0
    //   326: astore_3
    //   327: aload 6
    //   329: astore_0
    //   330: aload_3
    //   331: ifnull +7 -> 338
    //   334: aload_3
    //   335: invokevirtual 329	java/io/FileOutputStream:close	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 330	java/io/InputStream:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 331	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   356: aload_0
    //   357: athrow
    //   358: aload_0
    //   359: invokevirtual 334	java/io/FileOutputStream:flush	()V
    //   362: aload_0
    //   363: invokevirtual 329	java/io/FileOutputStream:close	()V
    //   366: aload 5
    //   368: invokevirtual 330	java/io/InputStream:close	()V
    //   371: aload 8
    //   373: aload 9
    //   375: invokestatic 338	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   378: ifne +125 -> 503
    //   381: aload 8
    //   383: aload 9
    //   385: invokestatic 341	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   388: pop
    //   389: goto +114 -> 503
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -65 -> 330
    //   398: iconst_0
    //   399: ifeq +11 -> 410
    //   402: new 343	java/lang/NullPointerException
    //   405: dup
    //   406: invokespecial 344	java/lang/NullPointerException:<init>	()V
    //   409: athrow
    //   410: iconst_0
    //   411: ifeq +11 -> 422
    //   414: new 343	java/lang/NullPointerException
    //   417: dup
    //   418: invokespecial 344	java/lang/NullPointerException:<init>	()V
    //   421: athrow
    //   422: aload 4
    //   424: ifnull +8 -> 432
    //   427: aload 4
    //   429: invokevirtual 331	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   432: return
    //   433: astore_0
    //   434: aload_0
    //   435: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   438: goto -28 -> 410
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   446: goto -24 -> 422
    //   449: astore_0
    //   450: aload_0
    //   451: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   454: return
    //   455: astore_3
    //   456: aload_3
    //   457: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   460: goto -122 -> 338
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   468: goto -122 -> 346
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   476: goto -120 -> 356
    //   479: astore_0
    //   480: aconst_null
    //   481: astore 4
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -155 -> 330
    //   488: astore 5
    //   490: aconst_null
    //   491: astore_1
    //   492: aload_0
    //   493: astore_3
    //   494: aload 5
    //   496: astore_0
    //   497: goto -167 -> 330
    //   500: goto -442 -> 58
    //   503: goto -445 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramString1	String
    //   0	506	1	paramString2	String
    //   167	147	2	i	int
    //   1	334	3	str1	String
    //   455	2	3	localIOException	java.io.IOException
    //   493	1	3	str2	String
    //   42	440	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   78	289	5	localObject1	Object
    //   488	7	5	localObject2	Object
    //   56	255	6	arrayOfByte	byte[]
    //   320	8	6	localObject3	Object
    //   49	20	7	localEnumeration	java.util.Enumeration
    //   174	208	8	localObject4	Object
    //   257	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   292	304	320	finally
    //   309	317	320	finally
    //   358	371	320	finally
    //   44	58	392	finally
    //   58	86	392	finally
    //   90	100	392	finally
    //   103	157	392	finally
    //   160	192	392	finally
    //   195	220	392	finally
    //   220	273	392	finally
    //   273	283	392	finally
    //   371	389	392	finally
    //   402	410	433	java/io/IOException
    //   414	422	441	java/io/IOException
    //   427	432	449	java/io/IOException
    //   334	338	455	java/io/IOException
    //   342	346	463	java/io/IOException
    //   351	356	471	java/io/IOException
    //   34	44	479	finally
    //   283	292	488	finally
  }
  
  public static Object n(int paramInt)
  {
    if (paramInt == 0) {
      return adjs.getLock();
    }
    if (paramInt == 1) {
      return adju.getLock();
    }
    if (paramInt == 2) {
      return adjt.getLock();
    }
    return null;
  }
  
  public static String w(int paramInt, String paramString)
  {
    paramString = x(paramInt, paramString);
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.BaseMiniSoLoader", 2, "getFileMd5BySP ,resName = " + paramString + ",md5 = " + str);
    }
    return str;
  }
  
  public static String x(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return adjs.getFileName(paramString);
    }
    if (paramInt == 1) {
      return adju.getFileName(paramString);
    }
    if (paramInt == 2) {
      return adjt.getFileName(paramString);
    }
    return "";
  }
  
  public static String y(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return adjs.jO(paramString);
    }
    if (paramInt == 1) {
      return adju.jO(paramString);
    }
    if (paramInt == 2) {
      return adjt.jO(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjk
 * JD-Core Version:    0.7.0.1
 */