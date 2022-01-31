package com.tencent.open.base;

import com.tencent.open.adapter.CommonDataAdapter;
import hlq;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class TicketUtils
{
  protected static final String a = "TicketUtils";
  public long a;
  public TicketUtils.TicketCallback a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  
  public TicketUtils()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new hlq(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback = null;
  }
  
  public void a(TicketUtils.TicketCallback paramTicketCallback)
  {
    this.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback = paramTicketCallback;
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong, String paramString)
  {
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)paramAppRuntime.getManager(1));
    byte[] arrayOfByte = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(CommonDataAdapter.a().a(), paramString);
    this.jdField_a_of_type_Long = paramLong;
    paramAppRuntime.ssoGetA1WithA1(CommonDataAdapter.a().a() + "", paramString.getBytes(), 16L, paramLong, 1L, "5.0".getBytes(), arrayOfByte, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  /* Error */
  public byte[] a(android.content.Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 90
    //   5: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: ldc 96
    //   10: iconst_3
    //   11: anewarray 98	java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: ldc 100
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: getstatic 106	java/lang/Long:TYPE	Ljava/lang/Class;
    //   24: aastore
    //   25: dup
    //   26: iconst_2
    //   27: getstatic 106	java/lang/Long:TYPE	Ljava/lang/Class;
    //   30: aastore
    //   31: invokevirtual 110	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: aload_0
    //   35: iconst_3
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: lload_2
    //   46: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: lload 4
    //   54: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: aastore
    //   58: invokevirtual 120	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore 7
    //   63: aload 7
    //   65: instanceof 122
    //   68: ifeq +27 -> 95
    //   71: aload 7
    //   73: checkcast 122	[B
    //   76: checkcast 122	[B
    //   79: astore 7
    //   81: aload 7
    //   83: astore 6
    //   85: aload 6
    //   87: areturn
    //   88: astore 7
    //   90: aload 7
    //   92: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   95: aload_1
    //   96: ifnonnull +7 -> 103
    //   99: iconst_0
    //   100: newarray byte
    //   102: areturn
    //   103: aload_1
    //   104: invokevirtual 129	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   107: astore_1
    //   108: new 54	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   115: ldc 131
    //   117: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 133
    //   122: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 135
    //   127: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 141	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   136: astore 7
    //   138: new 54	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   145: lload_2
    //   146: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc 64
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore 8
    //   159: new 54	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   166: lload 4
    //   168: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: ldc 64
    //   173: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore 9
    //   181: aload_1
    //   182: aload 7
    //   184: iconst_5
    //   185: anewarray 73	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: ldc 143
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc 145
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: ldc 147
    //   202: aastore
    //   203: dup
    //   204: iconst_3
    //   205: ldc 149
    //   207: aastore
    //   208: dup
    //   209: iconst_4
    //   210: ldc 151
    //   212: aastore
    //   213: ldc 153
    //   215: iconst_2
    //   216: anewarray 73	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: aload 8
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload 9
    //   228: aastore
    //   229: aconst_null
    //   230: invokevirtual 159	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   233: astore_1
    //   234: aload_1
    //   235: ifnull +114 -> 349
    //   238: aload_1
    //   239: astore 6
    //   241: aload_1
    //   242: invokeinterface 165 1 0
    //   247: ifeq +102 -> 349
    //   250: aload_1
    //   251: astore 6
    //   253: aload_1
    //   254: aload_1
    //   255: ldc 143
    //   257: invokeinterface 169 2 0
    //   262: invokeinterface 173 2 0
    //   267: pop
    //   268: aload_1
    //   269: astore 6
    //   271: aload_1
    //   272: aload_1
    //   273: ldc 149
    //   275: invokeinterface 169 2 0
    //   280: invokeinterface 177 2 0
    //   285: astore 7
    //   287: aload_1
    //   288: astore 6
    //   290: aload_1
    //   291: aload_1
    //   292: ldc 151
    //   294: invokeinterface 169 2 0
    //   299: invokeinterface 177 2 0
    //   304: astore 8
    //   306: aload_1
    //   307: astore 6
    //   309: aload 7
    //   311: invokestatic 183	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   314: aload 8
    //   316: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifeq +30 -> 349
    //   322: aload_1
    //   323: astore 6
    //   325: aload 7
    //   327: invokestatic 191	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   330: astore 7
    //   332: aload 7
    //   334: astore 6
    //   336: aload_1
    //   337: ifnull -252 -> 85
    //   340: aload_1
    //   341: invokeinterface 194 1 0
    //   346: aload 7
    //   348: areturn
    //   349: aload_1
    //   350: astore 6
    //   352: aload_1
    //   353: ifnull +12 -> 365
    //   356: aload_1
    //   357: invokeinterface 194 1 0
    //   362: aload_1
    //   363: astore 6
    //   365: aload 6
    //   367: ifnull +10 -> 377
    //   370: aload 6
    //   372: invokeinterface 194 1 0
    //   377: ldc 196
    //   379: invokestatic 191	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   382: areturn
    //   383: astore 7
    //   385: aconst_null
    //   386: astore_1
    //   387: aload_1
    //   388: astore 6
    //   390: ldc 8
    //   392: aload 7
    //   394: invokevirtual 199	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   397: aload 7
    //   399: invokestatic 205	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: aload_1
    //   403: astore 6
    //   405: aload_1
    //   406: ifnull -41 -> 365
    //   409: aload_1
    //   410: invokeinterface 194 1 0
    //   415: aload_1
    //   416: astore 6
    //   418: goto -53 -> 365
    //   421: astore_1
    //   422: aload 6
    //   424: ifnull +10 -> 434
    //   427: aload 6
    //   429: invokeinterface 194 1 0
    //   434: aload_1
    //   435: athrow
    //   436: astore_1
    //   437: goto -15 -> 422
    //   440: astore 7
    //   442: goto -55 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	TicketUtils
    //   0	445	1	paramContext	android.content.Context
    //   0	445	2	paramLong1	long
    //   0	445	4	paramLong2	long
    //   1	427	6	localObject1	Object
    //   61	21	7	localObject2	Object
    //   88	3	7	localException1	java.lang.Exception
    //   136	211	7	localObject3	Object
    //   383	15	7	localException2	java.lang.Exception
    //   440	1	7	localException3	java.lang.Exception
    //   157	158	8	str1	String
    //   179	48	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	81	88	java/lang/Exception
    //   138	234	383	java/lang/Exception
    //   138	234	421	finally
    //   241	250	436	finally
    //   253	268	436	finally
    //   271	287	436	finally
    //   290	306	436	finally
    //   309	322	436	finally
    //   325	332	436	finally
    //   390	402	436	finally
    //   241	250	440	java/lang/Exception
    //   253	268	440	java/lang/Exception
    //   271	287	440	java/lang/Exception
    //   290	306	440	java/lang/Exception
    //   309	322	440	java/lang/Exception
    //   325	332	440	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.TicketUtils
 * JD-Core Version:    0.7.0.1
 */