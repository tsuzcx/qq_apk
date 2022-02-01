import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class asgf
{
  private static asge a;
  public static AtomicBoolean ez = new AtomicBoolean(false);
  public static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
  public static final String[] ix = { "libicudata_53.so", "libicuuc_53.so", "libicui18n_53.so", "libJavaScriptCore.so", "libqg.so" };
  
  private static File M()
  {
    Object localObject = new File(jpe.dO("1018") + "1018");
    if (!((File)localObject).isDirectory()) {}
    do
    {
      return null;
      localObject = ((File)localObject).listFiles(new asgg());
    } while ((localObject == null) || (localObject.length == 0));
    return localObject[0];
  }
  
  private static int No()
  {
    Object localObject = M();
    if (localObject == null) {
      return 0;
    }
    localObject = ((File)localObject).getName();
    try
    {
      i = Integer.parseInt(((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")));
      try
      {
        QLog.d("QGLoader", 1, new Object[] { "getQGLocalVersion version success. version=", Integer.valueOf(i) });
        return i;
      }
      catch (NumberFormatException localNumberFormatException1) {}
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    QLog.e("QGLoader", 1, new Object[] { "getQGLocalVersion version error. fileName=", localObject });
    return i;
  }
  
  public static void b(String paramString, boolean paramBoolean, asge.a parama)
  {
    if (a == null) {
      a = asge.a();
    }
    a.a(paramString, paramBoolean, parama);
  }
  
  public static boolean loadSo(String paramString)
  {
    boolean bool2 = isSoLoaded.get();
    if (QLog.isColorLevel()) {
      QLog.d("QGLoader", 2, new Object[] { paramString + " load so enter. soloaded=", Boolean.valueOf(bool2) });
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGLoader", 2, "load offline so");
      }
      if (No() >= 6) {
        break label113;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QGLoader", 2, new Object[] { "so version low. min version is: ", Integer.valueOf(6) });
      }
      bool1 = false;
    }
    label113:
    do
    {
      return bool1;
      bool2 = sG("1018");
      bool1 = bool2;
    } while (!bool2);
    isSoLoaded.set(true);
    return bool2;
  }
  
  private static boolean sF(String paramString)
  {
    paramString = new File(paramString).listFiles(new asgh());
    boolean bool2;
    if ((paramString == null) || (paramString.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGLoader", 2, "load so files empty.");
      }
      bool2 = false;
      return bool2;
    }
    Object localObject1 = new ArrayList();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = paramString[i];
        try
        {
          System.load(localObject2.getAbsolutePath());
          i += 1;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QGLoader", 1, new Object[] { "load so error=", localUnsatisfiedLinkError2.getMessage() });
            }
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
    }
    paramString = ((ArrayList)localObject1).iterator();
    boolean bool1 = true;
    for (;;)
    {
      bool2 = bool1;
      if (!paramString.hasNext()) {
        break;
      }
      localObject1 = (File)paramString.next();
      try
      {
        System.load(((File)localObject1).getAbsolutePath());
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QGLoader", 1, new Object[] { "load so again error=", localUnsatisfiedLinkError1.getMessage() });
          }
          bool1 = false;
        }
      }
    }
  }
  
  /* Error */
  private static boolean sG(String paramString)
  {
    // Byte code:
    //   0: invokestatic 212	com/tencent/mobileqq/utils/SoLoadUtil:aFd	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: new 44	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: invokestatic 54	jpe:dO	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   29: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 218
    //   34: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 4
    //   48: invokestatic 82	asgf:M	()Ljava/io/File;
    //   51: astore_0
    //   52: aload_0
    //   53: ifnonnull +9 -> 62
    //   56: aload 4
    //   58: invokestatic 220	asgf:sF	(Ljava/lang/String;)Z
    //   61: ireturn
    //   62: new 170	java/util/ArrayList
    //   65: dup
    //   66: invokespecial 171	java/util/ArrayList:<init>	()V
    //   69: astore 5
    //   71: new 222	java/io/BufferedReader
    //   74: dup
    //   75: new 224	java/io/FileReader
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 227	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   83: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore_2
    //   87: aload_2
    //   88: astore_0
    //   89: aload_2
    //   90: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_2
    //   95: astore_0
    //   96: aload_3
    //   97: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +24 -> 124
    //   103: aload_2
    //   104: astore_0
    //   105: aload 5
    //   107: aload_3
    //   108: invokeinterface 242 2 0
    //   113: pop
    //   114: aload_2
    //   115: astore_0
    //   116: aload_2
    //   117: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore_3
    //   121: goto -27 -> 94
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 245	java/io/BufferedReader:close	()V
    //   132: iconst_1
    //   133: istore_1
    //   134: iload_1
    //   135: ifne +113 -> 248
    //   138: aload 4
    //   140: invokestatic 220	asgf:sF	(Ljava/lang/String;)Z
    //   143: istore_1
    //   144: iload_1
    //   145: ireturn
    //   146: astore_0
    //   147: ldc 102
    //   149: iconst_1
    //   150: ldc 247
    //   152: aload_0
    //   153: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: iconst_1
    //   157: istore_1
    //   158: goto -24 -> 134
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_2
    //   165: astore_0
    //   166: ldc 102
    //   168: iconst_1
    //   169: new 44	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   176: ldc 253
    //   178: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_3
    //   182: invokevirtual 254	java/lang/Exception:toString	()Ljava/lang/String;
    //   185: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 256	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 245	java/io/BufferedReader:close	()V
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -70 -> 134
    //   207: astore_0
    //   208: ldc 102
    //   210: iconst_1
    //   211: ldc 247
    //   213: aload_0
    //   214: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: iconst_0
    //   218: istore_1
    //   219: goto -85 -> 134
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_0
    //   225: aload_0
    //   226: ifnull +7 -> 233
    //   229: aload_0
    //   230: invokevirtual 245	java/io/BufferedReader:close	()V
    //   233: aload_2
    //   234: athrow
    //   235: astore_0
    //   236: ldc 102
    //   238: iconst_1
    //   239: ldc 247
    //   241: aload_0
    //   242: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -12 -> 233
    //   248: aload 5
    //   250: invokeinterface 258 1 0
    //   255: ifne +92 -> 347
    //   258: aload 5
    //   260: invokeinterface 259 1 0
    //   265: astore_0
    //   266: aload_0
    //   267: invokeinterface 197 1 0
    //   272: ifeq +72 -> 344
    //   275: aload_0
    //   276: invokeinterface 201 1 0
    //   281: checkcast 15	java/lang/String
    //   284: astore_2
    //   285: new 44	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   292: aload 4
    //   294: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_2
    //   298: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 179	java/lang/System:load	(Ljava/lang/String;)V
    //   307: goto -41 -> 266
    //   310: astore_0
    //   311: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +25 -> 339
    //   317: ldc 102
    //   319: iconst_1
    //   320: iconst_2
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc 181
    //   328: aastore
    //   329: dup
    //   330: iconst_1
    //   331: aload_0
    //   332: invokevirtual 184	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   335: aastore
    //   336: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   339: iconst_0
    //   340: istore_1
    //   341: goto -197 -> 144
    //   344: goto -200 -> 144
    //   347: iconst_0
    //   348: istore_1
    //   349: goto -205 -> 144
    //   352: astore_2
    //   353: goto -128 -> 225
    //   356: astore_3
    //   357: goto -193 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramString	String
    //   133	216	1	bool	boolean
    //   86	113	2	localBufferedReader	java.io.BufferedReader
    //   222	12	2	localObject1	Object
    //   284	14	2	str1	String
    //   352	1	2	localObject2	Object
    //   93	28	3	str2	String
    //   161	21	3	localException1	java.lang.Exception
    //   356	1	3	localException2	java.lang.Exception
    //   46	247	4	str3	String
    //   69	190	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   128	132	146	java/io/IOException
    //   71	87	161	java/lang/Exception
    //   198	202	207	java/io/IOException
    //   71	87	222	finally
    //   229	233	235	java/io/IOException
    //   258	266	310	java/lang/UnsatisfiedLinkError
    //   266	307	310	java/lang/UnsatisfiedLinkError
    //   89	94	352	finally
    //   96	103	352	finally
    //   105	114	352	finally
    //   116	121	352	finally
    //   166	194	352	finally
    //   89	94	356	java/lang/Exception
    //   96	103	356	java/lang/Exception
    //   105	114	356	java/lang/Exception
    //   116	121	356	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgf
 * JD-Core Version:    0.7.0.1
 */