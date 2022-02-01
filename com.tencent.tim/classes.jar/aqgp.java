import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.xmlpull.v1.XmlPullParser;

public abstract class aqgp
{
  public static String aTt;
  public static String aTu;
  
  private void dk(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseConfigFileParser", 2, "parseXmlFromRes");
    }
    int i = LS();
    paramContext = paramContext.getResources().getXml(i);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        bA(paramContext);
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
          QLog.e("BaseConfigFileParser", 2, "parseXmlFromRes doParseRules exception:", localException);
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
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload 4
    //   7: astore_2
    //   8: new 66	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload 4
    //   19: astore_2
    //   20: aload_1
    //   21: invokevirtual 72	java/io/File:exists	()Z
    //   24: ifeq +13 -> 37
    //   27: aload 4
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 75	java/io/File:isFile	()Z
    //   34: ifne +57 -> 91
    //   37: aload 4
    //   39: astore_2
    //   40: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +34 -> 77
    //   46: aload 4
    //   48: astore_2
    //   49: ldc 24
    //   51: iconst_2
    //   52: new 77	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   59: ldc 80
    //   61: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_0
    //   78: ifeq +11 -> 89
    //   81: new 95	java/lang/NullPointerException
    //   84: dup
    //   85: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   88: athrow
    //   89: iconst_0
    //   90: ireturn
    //   91: aload 4
    //   93: astore_2
    //   94: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +34 -> 131
    //   100: aload 4
    //   102: astore_2
    //   103: ldc 24
    //   105: iconst_2
    //   106: new 77	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   113: ldc 98
    //   115: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   122: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload 4
    //   133: astore_2
    //   134: new 100	java/io/FileInputStream
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   142: astore_1
    //   143: invokestatic 109	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   146: invokevirtual 113	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   149: astore_2
    //   150: aload_2
    //   151: aload_1
    //   152: ldc 115
    //   154: invokeinterface 121 3 0
    //   159: aload_0
    //   160: aload_2
    //   161: invokevirtual 50	aqgp:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/Object;
    //   164: astore_2
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 124	java/io/FileInputStream:close	()V
    //   173: aload_2
    //   174: ifnull -85 -> 89
    //   177: aload_0
    //   178: aload_2
    //   179: invokevirtual 54	aqgp:bA	(Ljava/lang/Object;)V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore_2
    //   185: aload_3
    //   186: astore_1
    //   187: aload_2
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +14 -> 208
    //   197: aload_1
    //   198: astore_2
    //   199: ldc 24
    //   201: iconst_2
    //   202: ldc 126
    //   204: aload_3
    //   205: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_1
    //   209: ifnull -120 -> 89
    //   212: aload_1
    //   213: invokevirtual 124	java/io/FileInputStream:close	()V
    //   216: iconst_0
    //   217: ireturn
    //   218: astore_1
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 124	java/io/FileInputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_1
    //   236: goto -63 -> 173
    //   239: astore_2
    //   240: goto -10 -> 230
    //   243: astore_3
    //   244: aload_1
    //   245: astore_2
    //   246: aload_3
    //   247: astore_1
    //   248: goto -26 -> 222
    //   251: astore_3
    //   252: goto -63 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	aqgp
    //   0	255	1	paramString	String
    //   7	172	2	localObject1	Object
    //   184	4	2	localException1	Exception
    //   190	37	2	str1	String
    //   239	1	2	localIOException	java.io.IOException
    //   245	1	2	str2	String
    //   4	201	3	localObject2	Object
    //   243	4	3	localObject3	Object
    //   251	1	3	localException2	Exception
    //   1	131	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	184	java/lang/Exception
    //   20	27	184	java/lang/Exception
    //   30	37	184	java/lang/Exception
    //   40	46	184	java/lang/Exception
    //   49	77	184	java/lang/Exception
    //   94	100	184	java/lang/Exception
    //   103	131	184	java/lang/Exception
    //   134	143	184	java/lang/Exception
    //   212	216	218	java/io/IOException
    //   8	17	221	finally
    //   20	27	221	finally
    //   30	37	221	finally
    //   40	46	221	finally
    //   49	77	221	finally
    //   94	100	221	finally
    //   103	131	221	finally
    //   134	143	221	finally
    //   191	197	221	finally
    //   199	208	221	finally
    //   81	89	232	java/io/IOException
    //   169	173	235	java/io/IOException
    //   226	230	239	java/io/IOException
    //   143	165	243	finally
    //   143	165	251	java/lang/Exception
  }
  
  protected abstract void B(QQAppInterface paramQQAppInterface, long paramLong);
  
  protected abstract int LS();
  
  protected abstract Object a(XmlPullParser paramXmlPullParser)
    throws Exception;
  
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
          QLog.d("BaseConfigFileParser", 2, "pareseRulesFromZip : delete and uncompressZip success, parse from outside result = " + bool);
        }
        if (bool)
        {
          B(paramQQAppInterface, paramLong);
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
          QLog.e("BaseConfigFileParser", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        }
        i = 0;
      }
      dk(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseConfigFileParser", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    dk(paramQQAppInterface.getApplication());
  }
  
  protected abstract void bA(Object paramObject);
  
  public void dj(Context paramContext)
  {
    if (aqhq.fileExistsAndNotEmpty(aTu))
    {
      boolean bool = hA(aTu);
      if (QLog.isColorLevel()) {
        QLog.d("BaseConfigFileParser", 2, "parseXmlFromOutside: success = " + bool);
      }
      if (!bool) {
        dk(paramContext);
      }
      return;
    }
    dk(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgp
 * JD-Core Version:    0.7.0.1
 */