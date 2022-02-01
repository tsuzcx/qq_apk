import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class wne
{
  private static volatile wne a;
  public static final String aTt;
  public static final String aTu = aTt + "eggs.xml";
  private ArrayList<wnh> qh;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    aTt = localBaseApplication.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/";
  }
  
  private ArrayList<wnh> a(XmlPullParser paramXmlPullParser)
    throws Exception
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    int i = paramXmlPullParser.getEventType();
    Object localObject1 = null;
    Object localObject4 = null;
    String str1;
    Object localObject3;
    Object localObject2;
    label398:
    String str2;
    if (i != 1) {
      if (i == 2)
      {
        str1 = paramXmlPullParser.getName();
        if (str1.equalsIgnoreCase("Item"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject2 = new wnh();
          ((wnh)localObject2).id = Integer.valueOf((String)localObject3).intValue();
          localObject3 = localObject1;
        }
        for (;;)
        {
          i = paramXmlPullParser.next();
          localObject4 = localObject2;
          localObject1 = localObject3;
          break;
          if (str1.equalsIgnoreCase("Keywords"))
          {
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (!TextUtils.isEmpty(str1))
              {
                if (localObject4.qi == null) {
                  localObject4.qi = new ArrayList();
                }
                localObject4.qi.add(str1);
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
          }
          else if (str1.equalsIgnoreCase("FloorLimit"))
          {
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              localObject4.bPy = Integer.valueOf(str1).intValue();
              localObject2 = localObject4;
              localObject3 = localObject1;
            }
          }
          else if (str1.equalsIgnoreCase("JumpLimit"))
          {
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              localObject4.bPz = Integer.valueOf(str1).intValue();
              localObject2 = localObject4;
              localObject3 = localObject1;
            }
          }
          else
          {
            if (!str1.equalsIgnoreCase("IsCrazyMode")) {
              break label398;
            }
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null) {
              if (str1.equalsIgnoreCase("true"))
              {
                localObject4.beD = true;
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
              else
              {
                localObject2 = localObject4;
                localObject3 = localObject1;
                if (str1.equalsIgnoreCase("false"))
                {
                  localObject4.beD = false;
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                }
              }
            }
          }
        }
        if (str1.equalsIgnoreCase("JumpImage"))
        {
          str1 = paramXmlPullParser.getAttributeValue(null, "type");
          localObject2 = paramXmlPullParser.getAttributeValue(null, "count");
          str2 = paramXmlPullParser.nextText();
          if (localObject2 == null) {
            break label941;
          }
          i = Integer.valueOf((String)localObject2).intValue();
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i <= 0) {
        break;
      }
      localObject2 = new wnh.b();
      if (str1 != null) {
        ((wnh.b)localObject2).imageType = wnh.b.bH(str1);
      }
      ((wnh.b)localObject2).value = str2;
      if (localObject4 != null)
      {
        if (localObject4.qj == null) {
          localObject4.qj = new ArrayList();
        }
        localObject4.qj.add(localObject2);
      }
      i -= 1;
      continue;
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (!str1.equalsIgnoreCase("businessData")) {
        break;
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (localObject4 == null) {
        break;
      }
      localObject4.a = new wnh.a();
      localObject2 = paramXmlPullParser.getAttributeValue(null, "bid");
      localObject3 = paramXmlPullParser.getAttributeValue(null, "startTs");
      str1 = paramXmlPullParser.getAttributeValue(null, "endTs");
      str2 = paramXmlPullParser.getAttributeValue(null, "actId");
      String str3 = paramXmlPullParser.getAttributeValue(null, "timeDelay");
      localObject4.a.bid = Integer.parseInt((String)localObject2);
      localObject4.a.bPA = Integer.parseInt((String)localObject3);
      localObject4.a.endTs = Integer.parseInt(str1);
      localObject4.a.bPB = Integer.parseInt(str3);
      localObject4.a.actId = Integer.parseInt(str2);
      localObject2 = localObject4;
      localObject3 = localObject1;
      break;
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i != 3) {
        break;
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (!paramXmlPullParser.getName().equalsIgnoreCase("Item")) {
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ArrayList();
      }
      boolean bool;
      if (localObject4 != null)
      {
        if ((localObject4.bPy != 0) || (localObject4.bPz != 0)) {
          break label869;
        }
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          ((ArrayList)localObject3).add(localObject4);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationConfigHelper", 2, "<== Item, id = " + localObject4.id + ",isValid = " + bool + "keywords:" + localObject4.qi.toString());
        }
        localObject2 = null;
        break;
        label869:
        if (localObject4.bPz > localObject4.bPy)
        {
          bool = true;
          continue;
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationConfigHelper", 2, "doParseRules :  cost time:" + (l2 - l1) + "ms");
          }
          return localObject1;
        }
        else
        {
          bool = false;
        }
      }
      label941:
      i = 1;
    }
  }
  
  public static wne a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new wne();
      }
      return a;
    }
    finally {}
  }
  
  private void dk(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromRes");
    }
    paramContext = paramContext.getResources().getXml(2131886083);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        this.qh = paramContext;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("AioAnimationConfigHelper", 2, "parseXmlFromRes doParseRules exception:", localException);
          paramContext = localObject;
        }
      }
    }
  }
  
  /* Error */
  private boolean hA(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 5
    //   10: astore_2
    //   11: new 33	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload 5
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 281	java/io/File:exists	()Z
    //   27: ifeq +13 -> 40
    //   30: aload 5
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 284	java/io/File:isFile	()Z
    //   37: ifne +58 -> 95
    //   40: aload 5
    //   42: astore_2
    //   43: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +35 -> 81
    //   49: aload 5
    //   51: astore_2
    //   52: ldc 214
    //   54: iconst_2
    //   55: new 22	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 286
    //   65: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iconst_0
    //   82: ifeq +11 -> 93
    //   85: new 293	java/lang/NullPointerException
    //   88: dup
    //   89: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   92: athrow
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: astore_2
    //   98: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +35 -> 136
    //   104: aload 5
    //   106: astore_2
    //   107: ldc 214
    //   109: iconst_2
    //   110: new 22	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 296
    //   120: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload 5
    //   138: astore_2
    //   139: new 298	java/io/FileInputStream
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 301	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   147: astore_1
    //   148: invokestatic 307	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   151: invokevirtual 311	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   154: astore_2
    //   155: aload_2
    //   156: aload_1
    //   157: ldc_w 313
    //   160: invokeinterface 317 3 0
    //   165: aload_0
    //   166: aload_2
    //   167: invokespecial 262	wne:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   170: astore_2
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 320	java/io/FileInputStream:close	()V
    //   179: aload_2
    //   180: ifnull -87 -> 93
    //   183: aload_0
    //   184: aload_2
    //   185: putfield 264	wne:qh	Ljava/util/ArrayList;
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_3
    //   191: aload 4
    //   193: astore_1
    //   194: aload_1
    //   195: astore_2
    //   196: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +15 -> 214
    //   202: aload_1
    //   203: astore_2
    //   204: ldc 214
    //   206: iconst_2
    //   207: ldc_w 322
    //   210: aload_3
    //   211: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload_1
    //   215: ifnull -122 -> 93
    //   218: aload_1
    //   219: invokevirtual 320	java/io/FileInputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: iconst_0
    //   226: ireturn
    //   227: astore_2
    //   228: aload_3
    //   229: astore_1
    //   230: aload_2
    //   231: astore_3
    //   232: aload_1
    //   233: astore_2
    //   234: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +15 -> 252
    //   240: aload_1
    //   241: astore_2
    //   242: ldc 214
    //   244: iconst_2
    //   245: ldc_w 322
    //   248: aload_3
    //   249: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload_1
    //   253: ifnull -160 -> 93
    //   256: aload_1
    //   257: invokevirtual 320	java/io/FileInputStream:close	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_1
    //   263: iconst_0
    //   264: ireturn
    //   265: astore_1
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 320	java/io/FileInputStream:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_1
    //   280: goto -101 -> 179
    //   283: astore_2
    //   284: goto -10 -> 274
    //   287: astore_3
    //   288: aload_1
    //   289: astore_2
    //   290: aload_3
    //   291: astore_1
    //   292: goto -26 -> 266
    //   295: astore_3
    //   296: goto -64 -> 232
    //   299: astore_3
    //   300: goto -106 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	wne
    //   0	303	1	paramString	String
    //   10	194	2	localObject1	Object
    //   227	4	2	localOutOfMemoryError1	OutOfMemoryError
    //   233	38	2	str1	String
    //   283	1	2	localIOException	java.io.IOException
    //   289	1	2	str2	String
    //   1	1	3	localObject2	Object
    //   190	39	3	localException1	Exception
    //   231	18	3	localObject3	Object
    //   287	4	3	localObject4	Object
    //   295	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   299	1	3	localException2	Exception
    //   6	186	4	localObject5	Object
    //   3	134	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	190	java/lang/Exception
    //   23	30	190	java/lang/Exception
    //   33	40	190	java/lang/Exception
    //   43	49	190	java/lang/Exception
    //   52	81	190	java/lang/Exception
    //   98	104	190	java/lang/Exception
    //   107	136	190	java/lang/Exception
    //   139	148	190	java/lang/Exception
    //   218	222	224	java/io/IOException
    //   11	20	227	java/lang/OutOfMemoryError
    //   23	30	227	java/lang/OutOfMemoryError
    //   33	40	227	java/lang/OutOfMemoryError
    //   43	49	227	java/lang/OutOfMemoryError
    //   52	81	227	java/lang/OutOfMemoryError
    //   98	104	227	java/lang/OutOfMemoryError
    //   107	136	227	java/lang/OutOfMemoryError
    //   139	148	227	java/lang/OutOfMemoryError
    //   256	260	262	java/io/IOException
    //   11	20	265	finally
    //   23	30	265	finally
    //   33	40	265	finally
    //   43	49	265	finally
    //   52	81	265	finally
    //   98	104	265	finally
    //   107	136	265	finally
    //   139	148	265	finally
    //   196	202	265	finally
    //   204	214	265	finally
    //   234	240	265	finally
    //   242	252	265	finally
    //   85	93	276	java/io/IOException
    //   175	179	279	java/io/IOException
    //   270	274	283	java/io/IOException
    //   148	171	287	finally
    //   148	171	295	java/lang/OutOfMemoryError
    //   148	171	299	java/lang/Exception
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int i = 1;
    try
    {
      aqhq.delete(aTt, false);
      aqhq.W(paramString, aTt, false);
      if (i != 0)
      {
        boolean bool = hA(aTu);
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompressZip success, parse from outside result = " + bool);
        }
        if (bool)
        {
          paramQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", paramLong).commit();
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        }
        i = 0;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AioAnimationConfigHelper", 2, "pareseRulesFromZip :  uncompress OOM Error =>", paramString);
        }
        i = 0;
      }
      dk(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    dk(paramQQAppInterface.getApplication());
  }
  
  public ArrayList<wnh> bH()
  {
    return this.qh;
  }
  
  public void dj(Context paramContext)
  {
    if (aqhq.fileExistsAndNotEmpty(aTu))
    {
      boolean bool = hA(aTu);
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromOutside: success = " + bool);
      }
      if (!bool) {
        dk(paramContext);
      }
      return;
    }
    dk(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wne
 * JD-Core Version:    0.7.0.1
 */