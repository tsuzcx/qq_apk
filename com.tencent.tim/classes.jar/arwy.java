import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class arwy
{
  protected arwy.a a;
  protected WtloginManager a;
  protected long awH;
  protected SSOAccountObserver c = new arwz(this);
  
  public void a(arwy.a parama)
  {
    this.jdField_a_of_type_Arwy$a = parama;
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong, String paramString)
  {
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)paramAppRuntime.getManager(1));
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(aroi.a().getContext(), paramString);
      this.awH = paramLong;
      paramAppRuntime.ssoGetA1WithA1(aroi.a().getUin() + "", paramString.getBytes(), 16L, paramLong, 1L, "5.0".getBytes(), arrayOfByte, this.c);
    }
  }
  
  public void destory()
  {
    this.jdField_a_of_type_Arwy$a = null;
  }
  
  /* Error */
  public byte[] get_cp_pubkey(android.content.Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 95
    //   5: invokevirtual 99	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: ldc 100
    //   10: iconst_3
    //   11: anewarray 102	java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: ldc 104
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: getstatic 110	java/lang/Long:TYPE	Ljava/lang/Class;
    //   24: aastore
    //   25: dup
    //   26: iconst_2
    //   27: getstatic 110	java/lang/Long:TYPE	Ljava/lang/Class;
    //   30: aastore
    //   31: invokevirtual 114	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
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
    //   46: invokestatic 118	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: lload 4
    //   54: invokestatic 118	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: aastore
    //   58: invokevirtual 124	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore 7
    //   63: aload 7
    //   65: instanceof 126
    //   68: ifeq +27 -> 95
    //   71: aload 7
    //   73: checkcast 126	[B
    //   76: checkcast 126	[B
    //   79: astore 7
    //   81: aload 7
    //   83: astore 6
    //   85: aload 6
    //   87: areturn
    //   88: astore 7
    //   90: aload 7
    //   92: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   95: aload_1
    //   96: ifnonnull +7 -> 103
    //   99: iconst_0
    //   100: newarray byte
    //   102: areturn
    //   103: aload_1
    //   104: invokevirtual 133	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   107: astore_1
    //   108: new 56	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   115: ldc 135
    //   117: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 137
    //   122: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 139
    //   127: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 145	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   136: astore 7
    //   138: new 56	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   145: lload_2
    //   146: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc 67
    //   151: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore 8
    //   159: new 56	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   166: lload 4
    //   168: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: ldc 67
    //   173: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore 9
    //   181: aload_1
    //   182: aload 7
    //   184: iconst_5
    //   185: anewarray 76	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: ldc 147
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc 149
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: ldc 151
    //   202: aastore
    //   203: dup
    //   204: iconst_3
    //   205: ldc 153
    //   207: aastore
    //   208: dup
    //   209: iconst_4
    //   210: ldc 155
    //   212: aastore
    //   213: ldc 157
    //   215: iconst_2
    //   216: anewarray 76	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: aload 8
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload 9
    //   228: aastore
    //   229: aconst_null
    //   230: invokestatic 163	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   233: astore_1
    //   234: aload_1
    //   235: ifnull +114 -> 349
    //   238: aload_1
    //   239: astore 6
    //   241: aload_1
    //   242: invokeinterface 169 1 0
    //   247: ifeq +102 -> 349
    //   250: aload_1
    //   251: astore 6
    //   253: aload_1
    //   254: aload_1
    //   255: ldc 147
    //   257: invokeinterface 173 2 0
    //   262: invokeinterface 177 2 0
    //   267: pop
    //   268: aload_1
    //   269: astore 6
    //   271: aload_1
    //   272: aload_1
    //   273: ldc 153
    //   275: invokeinterface 173 2 0
    //   280: invokeinterface 181 2 0
    //   285: astore 7
    //   287: aload_1
    //   288: astore 6
    //   290: aload_1
    //   291: aload_1
    //   292: ldc 155
    //   294: invokeinterface 173 2 0
    //   299: invokeinterface 181 2 0
    //   304: astore 8
    //   306: aload_1
    //   307: astore 6
    //   309: aload 7
    //   311: invokestatic 187	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   314: aload 8
    //   316: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifeq +30 -> 349
    //   322: aload_1
    //   323: astore 6
    //   325: aload 7
    //   327: invokestatic 195	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   330: astore 7
    //   332: aload 7
    //   334: astore 6
    //   336: aload_1
    //   337: ifnull -252 -> 85
    //   340: aload_1
    //   341: invokeinterface 198 1 0
    //   346: aload 7
    //   348: areturn
    //   349: aload_1
    //   350: ifnull +9 -> 359
    //   353: aload_1
    //   354: invokeinterface 198 1 0
    //   359: ldc 200
    //   361: invokestatic 195	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   364: areturn
    //   365: astore 7
    //   367: aconst_null
    //   368: astore_1
    //   369: aload_1
    //   370: astore 6
    //   372: ldc 202
    //   374: aload 7
    //   376: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   379: aload 7
    //   381: invokestatic 211	arwt:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: aload_1
    //   385: ifnull -26 -> 359
    //   388: aload_1
    //   389: invokeinterface 198 1 0
    //   394: goto -35 -> 359
    //   397: astore_1
    //   398: aload 6
    //   400: ifnull +10 -> 410
    //   403: aload 6
    //   405: invokeinterface 198 1 0
    //   410: aload_1
    //   411: athrow
    //   412: astore_1
    //   413: goto -15 -> 398
    //   416: astore 7
    //   418: goto -49 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	arwy
    //   0	421	1	paramContext	android.content.Context
    //   0	421	2	paramLong1	long
    //   0	421	4	paramLong2	long
    //   1	403	6	localObject1	Object
    //   61	21	7	localObject2	Object
    //   88	3	7	localException1	java.lang.Exception
    //   136	211	7	localObject3	Object
    //   365	15	7	localException2	java.lang.Exception
    //   416	1	7	localException3	java.lang.Exception
    //   157	158	8	str1	String
    //   179	48	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	81	88	java/lang/Exception
    //   138	234	365	java/lang/Exception
    //   138	234	397	finally
    //   241	250	412	finally
    //   253	268	412	finally
    //   271	287	412	finally
    //   290	306	412	finally
    //   309	322	412	finally
    //   325	332	412	finally
    //   372	384	412	finally
    //   241	250	416	java/lang/Exception
    //   253	268	416	java/lang/Exception
    //   271	287	416	java/lang/Exception
    //   290	306	416	java/lang/Exception
    //   309	322	416	java/lang/Exception
    //   325	332	416	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void G(String paramString, byte[] paramArrayOfByte);
    
    public abstract void elT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwy
 * JD-Core Version:    0.7.0.1
 */