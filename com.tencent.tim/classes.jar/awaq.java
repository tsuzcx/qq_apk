import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class awaq
  extends awap
{
  static int ezK = -1;
  static int ezL = -1;
  static int ezM = -1;
  
  int a(int paramInt, TelephonyManager paramTelephonyManager, int[] paramArrayOfInt, Method paramMethod, boolean paramBoolean)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException
  {
    int i = 0;
    if (i < 9) {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        int k = paramArrayOfInt.length;
        j = 0;
        label26:
        if (j >= k) {
          break label195;
        }
        if (paramArrayOfInt[j] != i) {}
      }
    }
    label195:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {}
      for (;;)
      {
        i += 1;
        break;
        j += 1;
        break label26;
        if (paramBoolean) {}
        for (Object localObject = paramMethod.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(i) }); localObject != null; localObject = paramMethod.invoke(paramTelephonyManager, new Object[] { Long.valueOf(i) })) {
          switch (paramInt)
          {
          default: 
            break;
          case 1: 
            eu(i, localObject.toString());
            break;
          }
        }
        a(i, (Boolean)localObject);
        continue;
        ev(i, localObject.toString());
      }
      return 0;
    }
  }
  
  public int a(Context paramContext, int[] paramArrayOfInt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException
  {
    boolean bool2 = false;
    boolean bool1 = false;
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Class localClass = localTelephonyManager.getClass();
    Method localMethod = null;
    paramContext = null;
    if ((ezK == -1) || (ezK == 1)) {
      paramContext = localMethod;
    }
    try
    {
      localMethod = localClass.getDeclaredMethod("getSubscriberId", new Class[] { Integer.TYPE });
      paramContext = localMethod;
      ezK = 1;
      paramContext = localMethod;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          localMethod = localClass.getDeclaredMethod("getSubscriberId", new Class[] { Long.TYPE });
          paramContext = localMethod;
        }
        catch (Throwable localThrowable2)
        {
          bool1 = true;
        }
        try
        {
          ezK = 2;
          if ((ezK != -1) && (paramContext != null)) {
            break;
          }
          return -2;
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            bool1 = bool2;
          }
        }
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
        continue;
        QZLog.e("UniKingCardHelper/SimManager", "initAllIMSI error:" + localThrowable2.getMessage());
      }
    }
    if ((ezK == -1) || (ezK == 2)) {}
    for (;;)
    {
      return a(1, localTelephonyManager, paramArrayOfInt, paramContext, bool1);
      bool1 = true;
    }
  }
  
  public int a(t paramt)
  {
    int j = 0;
    int i;
    if (paramt == null)
    {
      i = -2;
      return i;
    }
    for (;;)
    {
      try
      {
        int k = paramt.S();
        if (k >= 0)
        {
          i = 0;
          if (i <= 10)
          {
            paramt = a(i);
            if (paramt == null) {
              break label156;
            }
            if (i != k) {
              break label163;
            }
            bool = true;
            paramt.WU(bool);
            break label156;
          }
          paramt = a(k);
          i = j;
          if (paramt == null) {
            break;
          }
          i = j;
          if (TextUtils.isEmpty(paramt.getIMSI())) {
            break;
          }
          awao localawao = a(10);
          i = j;
          if (localawao == null) {
            break;
          }
          i = j;
          if (!paramt.getIMSI().equals(localawao.getIMSI())) {
            break;
          }
          localawao.WU(true);
          return 0;
        }
      }
      catch (Throwable paramt)
      {
        QZLog.e("UniKingCardHelper/SimManager", "initAllDataByAIDL 1 error:" + paramt.getMessage());
      }
      return -3;
      label156:
      i += 1;
      continue;
      label163:
      boolean bool = false;
    }
  }
  
  protected int b(Context paramContext, int[] paramArrayOfInt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException
  {
    return -3;
  }
  
  /* Error */
  protected int c(Context paramContext, int[] paramArrayOfInt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 73
    //   3: invokevirtual 79	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 81	android/telephony/TelephonyManager
    //   9: astore 7
    //   11: aload 7
    //   13: invokevirtual 85	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: astore 8
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore_1
    //   23: getstatic 16	awaq:ezM	I
    //   26: iconst_m1
    //   27: if_icmpeq +10 -> 37
    //   30: getstatic 16	awaq:ezM	I
    //   33: iconst_1
    //   34: if_icmpne +35 -> 69
    //   37: aload 5
    //   39: astore_1
    //   40: aload 8
    //   42: ldc 161
    //   44: iconst_1
    //   45: anewarray 89	java/lang/Class
    //   48: dup
    //   49: iconst_0
    //   50: getstatic 93	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   53: aastore
    //   54: invokevirtual 97	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   57: astore 5
    //   59: aload 5
    //   61: astore_1
    //   62: iconst_1
    //   63: putstatic 16	awaq:ezM	I
    //   66: aload 5
    //   68: astore_1
    //   69: getstatic 16	awaq:ezM	I
    //   72: iconst_m1
    //   73: if_icmpeq +10 -> 83
    //   76: getstatic 16	awaq:ezM	I
    //   79: iconst_2
    //   80: if_icmpne +330 -> 410
    //   83: aload 8
    //   85: ldc 161
    //   87: iconst_1
    //   88: anewarray 89	java/lang/Class
    //   91: dup
    //   92: iconst_0
    //   93: getstatic 98	java/lang/Long:TYPE	Ljava/lang/Class;
    //   96: aastore
    //   97: invokevirtual 97	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   100: astore 5
    //   102: iconst_2
    //   103: putstatic 16	awaq:ezM	I
    //   106: aload 5
    //   108: astore_1
    //   109: iconst_0
    //   110: istore_3
    //   111: getstatic 16	awaq:ezM	I
    //   114: iconst_m1
    //   115: if_icmpeq +16 -> 131
    //   118: iload_3
    //   119: istore 4
    //   121: aload_1
    //   122: astore 5
    //   124: getstatic 16	awaq:ezM	I
    //   127: iconst_3
    //   128: if_icmpne +29 -> 157
    //   131: aload 8
    //   133: ldc 163
    //   135: iconst_1
    //   136: anewarray 89	java/lang/Class
    //   139: dup
    //   140: iconst_0
    //   141: getstatic 93	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   144: aastore
    //   145: invokevirtual 97	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   148: astore 5
    //   150: iconst_3
    //   151: putstatic 16	awaq:ezM	I
    //   154: iconst_1
    //   155: istore 4
    //   157: getstatic 16	awaq:ezM	I
    //   160: iconst_m1
    //   161: if_icmpeq +10 -> 171
    //   164: getstatic 16	awaq:ezM	I
    //   167: iconst_4
    //   168: if_icmpne +233 -> 401
    //   171: aload 8
    //   173: ldc 163
    //   175: iconst_1
    //   176: anewarray 89	java/lang/Class
    //   179: dup
    //   180: iconst_0
    //   181: getstatic 98	java/lang/Long:TYPE	Ljava/lang/Class;
    //   184: aastore
    //   185: invokevirtual 97	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   188: astore_1
    //   189: iconst_4
    //   190: putstatic 16	awaq:ezM	I
    //   193: iconst_0
    //   194: istore_3
    //   195: getstatic 16	awaq:ezM	I
    //   198: iconst_m1
    //   199: if_icmpeq +7 -> 206
    //   202: aload_1
    //   203: ifnonnull +156 -> 359
    //   206: bipush 254
    //   208: ireturn
    //   209: astore 5
    //   211: ldc 103
    //   213: new 105	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   220: ldc 165
    //   222: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 5
    //   227: invokevirtual 115	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 122	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -170 -> 69
    //   242: astore 5
    //   244: iconst_1
    //   245: istore_3
    //   246: ldc 103
    //   248: new 105	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   255: ldc 167
    //   257: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 5
    //   262: invokevirtual 115	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 122	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: goto -163 -> 111
    //   277: astore 6
    //   279: ldc 103
    //   281: new 105	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   288: ldc 169
    //   290: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 6
    //   295: invokevirtual 115	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   298: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 122	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: iload_3
    //   308: istore 4
    //   310: aload_1
    //   311: astore 5
    //   313: goto -156 -> 157
    //   316: astore 6
    //   318: aload 5
    //   320: astore_1
    //   321: iload 4
    //   323: istore_3
    //   324: aload 6
    //   326: astore 5
    //   328: ldc 103
    //   330: new 105	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   337: ldc 171
    //   339: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 5
    //   344: invokevirtual 115	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   347: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 122	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: goto -161 -> 195
    //   359: aload_0
    //   360: iconst_3
    //   361: aload 7
    //   363: aload_2
    //   364: aload_1
    //   365: iload_3
    //   366: invokevirtual 124	awaq:a	(ILandroid/telephony/TelephonyManager;[ILjava/lang/reflect/Method;Z)I
    //   369: ireturn
    //   370: astore 5
    //   372: iconst_0
    //   373: istore_3
    //   374: goto -46 -> 328
    //   377: astore 6
    //   379: iconst_1
    //   380: istore_3
    //   381: aload 5
    //   383: astore_1
    //   384: goto -105 -> 279
    //   387: astore 6
    //   389: aload 5
    //   391: astore_1
    //   392: iconst_0
    //   393: istore_3
    //   394: aload 6
    //   396: astore 5
    //   398: goto -152 -> 246
    //   401: aload 5
    //   403: astore_1
    //   404: iload 4
    //   406: istore_3
    //   407: goto -212 -> 195
    //   410: iconst_1
    //   411: istore_3
    //   412: goto -301 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	awaq
    //   0	415	1	paramContext	Context
    //   0	415	2	paramArrayOfInt	int[]
    //   110	302	3	bool1	boolean
    //   119	286	4	bool2	boolean
    //   19	130	5	localObject1	Object
    //   209	17	5	localThrowable1	Throwable
    //   242	19	5	localThrowable2	Throwable
    //   311	32	5	localObject2	Object
    //   370	20	5	localThrowable3	Throwable
    //   396	6	5	localObject3	Object
    //   277	17	6	localThrowable4	Throwable
    //   316	9	6	localThrowable5	Throwable
    //   377	1	6	localThrowable6	Throwable
    //   387	8	6	localThrowable7	Throwable
    //   9	353	7	localTelephonyManager	TelephonyManager
    //   16	156	8	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   40	59	209	java/lang/Throwable
    //   62	66	209	java/lang/Throwable
    //   83	102	242	java/lang/Throwable
    //   131	150	277	java/lang/Throwable
    //   171	189	316	java/lang/Throwable
    //   189	193	370	java/lang/Throwable
    //   150	154	377	java/lang/Throwable
    //   102	106	387	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awaq
 * JD-Core Version:    0.7.0.1
 */