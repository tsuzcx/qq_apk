import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArNativeSoLoader.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class adeq
{
  public static boolean SP;
  private static final byte[] dc = new byte[0];
  public static boolean hasReport;
  
  public static boolean c(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ArConfig_ArNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      if (localXmlPullParser.getName().equalsIgnoreCase("ArMapEngine836"))
      {
        paramHashMap.put("ArMapEngine836", localXmlPullParser.nextText());
        break label104;
        ;;
        label104:
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_ArNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
          return true;
          if (i != 1) {
            switch (i)
            {
            }
          }
        }
      }
    }
  }
  
  public static byte d(String paramString)
  {
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = sm() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArNativeSoLoader", 2, "start arNativeSo: " + str);
    }
    File localFile = new File(str);
    if ((!SP) && (localFile.exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.i("ArConfig_ArNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArConfig_ArNativeSoLoader", 2, "load from ar dir failed.", localUnsatisfiedLinkError);
        b1 = -3;
        continue;
      }
      g(paramString, b1);
      return b1;
      b2 = -2;
      byte b1 = b2;
      if (QLog.isColorLevel())
      {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "no ar so in ar dir");
        b1 = b2;
      }
    }
  }
  
  /* Error */
  public static byte e(String arg0)
  {
    // Byte code:
    //   0: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 81
    //   8: iconst_2
    //   9: new 87	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   16: ldc 155
    //   18: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iconst_1
    //   32: putstatic 129	adeq:SP	Z
    //   35: aload_0
    //   36: invokestatic 113	adeq:sm	()Ljava/lang/String;
    //   39: invokestatic 161	aden:fn	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: new 26	java/util/HashMap
    //   45: dup
    //   46: invokespecial 162	java/util/HashMap:<init>	()V
    //   49: astore 5
    //   51: getstatic 168	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   54: ldc 170
    //   56: iconst_0
    //   57: invokevirtual 174	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: invokeinterface 180 1 0
    //   65: astore 4
    //   67: new 124	java/io/File
    //   70: dup
    //   71: new 87	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   78: invokestatic 113	adeq:sm	()Ljava/lang/String;
    //   81: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 182
    //   86: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 132	java/io/File:exists	()Z
    //   100: ifeq +309 -> 409
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_3
    //   106: invokestatic 188	aqhq:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +273 -> 386
    //   116: aload_0
    //   117: aload 5
    //   119: invokestatic 190	adeq:c	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   122: ifeq +264 -> 386
    //   125: getstatic 13	adeq:dc	[B
    //   128: astore_0
    //   129: aload_0
    //   130: monitorenter
    //   131: aload 5
    //   133: invokevirtual 194	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   136: invokeinterface 200 1 0
    //   141: astore_3
    //   142: aload_3
    //   143: invokeinterface 205 1 0
    //   148: ifeq +280 -> 428
    //   151: aload_3
    //   152: invokeinterface 208 1 0
    //   157: checkcast 210	java/util/Map$Entry
    //   160: astore 5
    //   162: new 87	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   169: invokestatic 113	adeq:sm	()Ljava/lang/String;
    //   172: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 115
    //   177: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokeinterface 213 1 0
    //   187: checkcast 33	java/lang/String
    //   190: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 117
    //   195: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 7
    //   203: new 124	java/io/File
    //   206: dup
    //   207: aload 7
    //   209: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 6
    //   214: aload 6
    //   216: invokevirtual 132	java/io/File:exists	()Z
    //   219: ifeq +162 -> 381
    //   222: aload 7
    //   224: invokestatic 219	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 7
    //   229: aload 5
    //   231: invokeinterface 222 1 0
    //   236: checkcast 33	java/lang/String
    //   239: aload 7
    //   241: invokevirtual 66	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   244: ifne +83 -> 327
    //   247: aload 6
    //   249: invokevirtual 225	java/io/File:delete	()Z
    //   252: pop
    //   253: iconst_2
    //   254: istore_1
    //   255: aload 4
    //   257: invokeinterface 230 1 0
    //   262: pop
    //   263: aload_0
    //   264: monitorexit
    //   265: iconst_0
    //   266: putstatic 129	adeq:SP	Z
    //   269: iload_1
    //   270: ireturn
    //   271: astore_0
    //   272: iconst_0
    //   273: putstatic 129	adeq:SP	Z
    //   276: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +31 -> 310
    //   282: ldc 81
    //   284: iconst_2
    //   285: new 87	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   292: ldc 232
    //   294: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: invokevirtual 235	java/io/IOException:getMessage	()Ljava/lang/String;
    //   301: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: invokestatic 113	adeq:sm	()Ljava/lang/String;
    //   313: iconst_0
    //   314: invokestatic 238	aqhq:delete	(Ljava/lang/String;Z)V
    //   317: iconst_m1
    //   318: ireturn
    //   319: astore_3
    //   320: aload_3
    //   321: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   324: goto -212 -> 112
    //   327: aload 4
    //   329: new 87	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   336: ldc 243
    //   338: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 5
    //   343: invokeinterface 213 1 0
    //   348: checkcast 33	java/lang/String
    //   351: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload 5
    //   359: invokeinterface 222 1 0
    //   364: checkcast 33	java/lang/String
    //   367: invokeinterface 247 3 0
    //   372: pop
    //   373: goto -231 -> 142
    //   376: astore_3
    //   377: aload_0
    //   378: monitorexit
    //   379: aload_3
    //   380: athrow
    //   381: iconst_3
    //   382: istore_1
    //   383: goto -128 -> 255
    //   386: iconst_4
    //   387: istore_2
    //   388: iload_2
    //   389: istore_1
    //   390: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq -128 -> 265
    //   396: ldc 81
    //   398: iconst_2
    //   399: ldc 249
    //   401: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: iload_2
    //   405: istore_1
    //   406: goto -141 -> 265
    //   409: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +11 -> 423
    //   415: ldc 81
    //   417: iconst_2
    //   418: ldc 251
    //   420: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: iconst_0
    //   424: istore_1
    //   425: goto -160 -> 265
    //   428: iconst_0
    //   429: istore_1
    //   430: goto -175 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   254	176	1	b1	byte
    //   387	18	2	b2	byte
    //   95	57	3	localObject1	Object
    //   319	2	3	localIOException	java.io.IOException
    //   376	4	3	localObject2	Object
    //   65	263	4	localEditor	android.content.SharedPreferences.Editor
    //   49	309	5	localObject3	Object
    //   212	36	6	localFile	File
    //   201	39	7	str	String
    // Exception table:
    //   from	to	target	type
    //   35	42	271	java/io/IOException
    //   105	110	319	java/io/IOException
    //   131	142	376	finally
    //   142	253	376	finally
    //   255	265	376	finally
    //   327	373	376	finally
    //   377	379	376	finally
  }
  
  private static void g(String paramString, byte paramByte)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    byte b = localSharedPreferences.getInt("ar_native_so_load_result" + paramString, 0);
    if ((!hasReport) || (b != paramByte))
    {
      hasReport = true;
      ThreadManager.post(new ArNativeSoLoader.1(paramString, paramByte, localSharedPreferences), 5, null, true);
    }
  }
  
  public static boolean kQ(String paramString)
  {
    return z(paramString, true);
  }
  
  public static boolean kR(String paramString)
  {
    return new File(sm() + "/lib" + paramString + ".so").exists();
  }
  
  public static String sm()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/ar";
  }
  
  public static boolean z(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    String str1 = sm() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist libPath=" + str1 + ", exist=" + ((File)???).exists() + ", isUncompressZip=" + SP);
    }
    boolean bool1 = bool3;
    if (!SP)
    {
      bool1 = bool3;
      if (((File)???).exists())
      {
        if (paramBoolean) {
          break label135;
        }
        bool1 = true;
      }
    }
    return bool1;
    for (;;)
    {
      synchronized (dc)
      {
        label135:
        String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("ar_native_" + paramString, null);
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: md5= " + str2);
        }
        if (str2 == null) {
          break label289;
        }
        if (str2.equalsIgnoreCase(alab.getFileMD5String(str1)))
        {
          break label289;
          return paramBoolean;
        }
      }
      paramBoolean = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
        paramBoolean = bool2;
        continue;
        label289:
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adeq
 * JD-Core Version:    0.7.0.1
 */