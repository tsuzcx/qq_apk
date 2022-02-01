import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LebaIconDownloader.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil.b;
import com.tencent.qphone.base.util.QLog;

public class vfq
{
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, HttpDownloadUtil.b paramb)
  {
    if (paramContext == null) {}
    while ((paramString == null) || ("".equals(paramString)) || (paramQQAppInterface == null)) {
      return;
    }
    ThreadManager.post(new LebaIconDownloader.1(paramContext, paramString, paramQQAppInterface, paramb), 5, null, true);
  }
  
  /* Error */
  public static Drawable c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 38	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: aload_1
    //   15: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +117 -> 137
    //   23: aload_0
    //   24: invokevirtual 51	java/io/File:exists	()Z
    //   27: ifeq +110 -> 137
    //   30: new 53	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: new 58	android/graphics/drawable/BitmapDrawable
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 61	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   49: astore_2
    //   50: aload_2
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +9 -> 62
    //   56: aload_1
    //   57: invokevirtual 65	java/io/FileInputStream:close	()V
    //   60: aload_2
    //   61: astore_0
    //   62: aload_0
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +33 -> 105
    //   75: aload_1
    //   76: astore_0
    //   77: ldc 72
    //   79: iconst_2
    //   80: new 74	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   87: ldc 78
    //   89: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: invokevirtual 86	java/lang/Exception:toString	()Ljava/lang/String;
    //   96: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 65	java/io/FileInputStream:close	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -53 -> 62
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_0
    //   121: goto -59 -> 62
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 65	java/io/FileInputStream:close	()V
    //   135: aload_1
    //   136: athrow
    //   137: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq -136 -> 4
    //   143: ldc 72
    //   145: iconst_2
    //   146: new 74	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   153: ldc 93
    //   155: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 95
    //   164: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_0
    //   176: aload_2
    //   177: astore_0
    //   178: goto -116 -> 62
    //   181: astore_0
    //   182: goto -47 -> 135
    //   185: astore_1
    //   186: goto -59 -> 127
    //   189: astore_2
    //   190: goto -123 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramString	String
    //   49	12	2	localBitmapDrawable	BitmapDrawable
    //   64	113	2	localException1	java.lang.Exception
    //   189	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	39	64	java/lang/Exception
    //   109	113	118	java/lang/Exception
    //   30	39	124	finally
    //   56	60	175	java/lang/Exception
    //   131	135	181	java/lang/Exception
    //   41	50	185	finally
    //   69	75	185	finally
    //   77	105	185	finally
    //   41	50	189	java/lang/Exception
  }
  
  public static void c(String paramString, Drawable paramDrawable)
  {
    BaseApplicationImpl.sImageCache.put(paramString, paramDrawable);
  }
  
  public static Drawable d(Context paramContext, String paramString)
  {
    if (h(paramString) != null) {
      return h(paramString);
    }
    if (c(paramContext, paramString) != null)
    {
      c(paramString, c(paramContext, paramString));
      return c(paramContext, paramString);
    }
    return null;
  }
  
  public static Drawable h(String paramString)
  {
    paramString = BaseApplicationImpl.sImageCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    if (((paramString instanceof Drawable)) || ((paramString instanceof BitmapDrawable))) {
      return (Drawable)paramString;
    }
    return null;
  }
  
  public static class a
    implements HttpDownloadUtil.b
  {
    private vfq.b a;
    private Context context;
    private Object[] o;
    
    public a(Context paramContext, vfq.b paramb, Object... paramVarArgs)
    {
      this.a = paramb;
      this.o = paramVarArgs;
      this.context = paramContext.getApplicationContext();
    }
    
    public void cm(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaListViewAdapter", 2, "--onHttpStart");
      }
      if (this.a != null) {
        this.a.a(0, paramString, null, this.o);
      }
    }
    
    /* Error */
    public void cn(String paramString, int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   6: ifeq +28 -> 34
      //   9: ldc 42
      //   11: iconst_2
      //   12: new 58	java/lang/StringBuilder
      //   15: dup
      //   16: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   19: ldc 61
      //   21: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: iload_2
      //   25: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   28: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   31: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   34: iload_2
      //   35: ifne +286 -> 321
      //   38: new 74	java/io/File
      //   41: dup
      //   42: aload_0
      //   43: getfield 31	vfq$a:context	Landroid/content/Context;
      //   46: invokevirtual 78	android/content/Context:getFilesDir	()Ljava/io/File;
      //   49: aload_1
      //   50: invokespecial 81	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   53: astore_3
      //   54: aload_3
      //   55: ifnull +105 -> 160
      //   58: aload_3
      //   59: invokevirtual 84	java/io/File:exists	()Z
      //   62: ifne +98 -> 160
      //   65: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   68: ifeq +33 -> 101
      //   71: ldc 42
      //   73: iconst_2
      //   74: new 58	java/lang/StringBuilder
      //   77: dup
      //   78: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   81: ldc 86
      //   83: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: aload_1
      //   87: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: ldc 88
      //   92: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   98: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   101: aload_0
      //   102: getfield 21	vfq$a:a	Lvfq$b;
      //   105: ifnull +19 -> 124
      //   108: aload_0
      //   109: getfield 21	vfq$a:a	Lvfq$b;
      //   112: iconst_2
      //   113: aload_1
      //   114: aconst_null
      //   115: aload_0
      //   116: getfield 23	vfq$a:o	[Ljava/lang/Object;
      //   119: invokeinterface 53 5 0
      //   124: aload_0
      //   125: getfield 21	vfq$a:a	Lvfq$b;
      //   128: ifnull +19 -> 147
      //   131: aload_0
      //   132: getfield 21	vfq$a:a	Lvfq$b;
      //   135: iconst_2
      //   136: aload_1
      //   137: aconst_null
      //   138: aload_0
      //   139: getfield 23	vfq$a:o	[Ljava/lang/Object;
      //   142: invokeinterface 53 5 0
      //   147: iconst_0
      //   148: ifeq +11 -> 159
      //   151: new 90	java/lang/NullPointerException
      //   154: dup
      //   155: invokespecial 91	java/lang/NullPointerException:<init>	()V
      //   158: athrow
      //   159: return
      //   160: new 93	java/io/FileInputStream
      //   163: dup
      //   164: aload_3
      //   165: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   168: astore 4
      //   170: new 98	android/graphics/drawable/BitmapDrawable
      //   173: dup
      //   174: aload 4
      //   176: invokespecial 101	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
      //   179: astore_3
      //   180: aload_1
      //   181: aload_3
      //   182: invokestatic 105	vfq:c	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
      //   185: aload_0
      //   186: getfield 21	vfq$a:a	Lvfq$b;
      //   189: ifnull +19 -> 208
      //   192: aload_0
      //   193: getfield 21	vfq$a:a	Lvfq$b;
      //   196: iconst_2
      //   197: aload_1
      //   198: aload_3
      //   199: aload_0
      //   200: getfield 23	vfq$a:o	[Ljava/lang/Object;
      //   203: invokeinterface 53 5 0
      //   208: aload 4
      //   210: ifnull -51 -> 159
      //   213: aload 4
      //   215: invokevirtual 108	java/io/FileInputStream:close	()V
      //   218: return
      //   219: astore_1
      //   220: return
      //   221: astore 5
      //   223: aconst_null
      //   224: astore_3
      //   225: aconst_null
      //   226: astore 4
      //   228: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   231: ifeq +14 -> 245
      //   234: ldc 42
      //   236: iconst_2
      //   237: aload 5
      //   239: invokevirtual 109	java/lang/Exception:toString	()Ljava/lang/String;
      //   242: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   245: aload_0
      //   246: getfield 21	vfq$a:a	Lvfq$b;
      //   249: ifnull +19 -> 268
      //   252: aload_0
      //   253: getfield 21	vfq$a:a	Lvfq$b;
      //   256: iconst_2
      //   257: aload_1
      //   258: aconst_null
      //   259: aload_0
      //   260: getfield 23	vfq$a:o	[Ljava/lang/Object;
      //   263: invokeinterface 53 5 0
      //   268: aload 4
      //   270: ifnull -111 -> 159
      //   273: aload 4
      //   275: invokevirtual 108	java/io/FileInputStream:close	()V
      //   278: return
      //   279: astore_1
      //   280: return
      //   281: astore 4
      //   283: aconst_null
      //   284: astore_3
      //   285: aload_0
      //   286: getfield 21	vfq$a:a	Lvfq$b;
      //   289: ifnull +19 -> 308
      //   292: aload_0
      //   293: getfield 21	vfq$a:a	Lvfq$b;
      //   296: iconst_2
      //   297: aload_1
      //   298: aload_3
      //   299: aload_0
      //   300: getfield 23	vfq$a:o	[Ljava/lang/Object;
      //   303: invokeinterface 53 5 0
      //   308: aload 5
      //   310: ifnull +8 -> 318
      //   313: aload 5
      //   315: invokevirtual 108	java/io/FileInputStream:close	()V
      //   318: aload 4
      //   320: athrow
      //   321: aload_0
      //   322: getfield 21	vfq$a:a	Lvfq$b;
      //   325: ifnull -166 -> 159
      //   328: aload_0
      //   329: getfield 21	vfq$a:a	Lvfq$b;
      //   332: iconst_2
      //   333: aload_1
      //   334: aconst_null
      //   335: aload_0
      //   336: getfield 23	vfq$a:o	[Ljava/lang/Object;
      //   339: invokeinterface 53 5 0
      //   344: return
      //   345: astore_1
      //   346: return
      //   347: astore_1
      //   348: goto -30 -> 318
      //   351: astore 5
      //   353: aconst_null
      //   354: astore_3
      //   355: aload 4
      //   357: astore 6
      //   359: aload 5
      //   361: astore 4
      //   363: aload 6
      //   365: astore 5
      //   367: goto -82 -> 285
      //   370: astore 6
      //   372: aload 4
      //   374: astore 5
      //   376: aload 6
      //   378: astore 4
      //   380: goto -95 -> 285
      //   383: astore 6
      //   385: aload 4
      //   387: astore 5
      //   389: aload 6
      //   391: astore 4
      //   393: goto -108 -> 285
      //   396: astore 5
      //   398: aconst_null
      //   399: astore_3
      //   400: goto -172 -> 228
      //   403: astore 5
      //   405: goto -177 -> 228
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	408	0	this	a
      //   0	408	1	paramString	String
      //   0	408	2	paramInt	int
      //   53	347	3	localObject1	Object
      //   168	106	4	localFileInputStream	java.io.FileInputStream
      //   281	75	4	localObject2	Object
      //   361	31	4	localObject3	Object
      //   1	1	5	localObject4	Object
      //   221	93	5	localException1	java.lang.Exception
      //   351	9	5	localObject5	Object
      //   365	23	5	localObject6	Object
      //   396	1	5	localException2	java.lang.Exception
      //   403	1	5	localException3	java.lang.Exception
      //   357	7	6	localObject7	Object
      //   370	7	6	localObject8	Object
      //   383	7	6	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   213	218	219	java/lang/Exception
      //   38	54	221	java/lang/Exception
      //   58	101	221	java/lang/Exception
      //   101	124	221	java/lang/Exception
      //   160	170	221	java/lang/Exception
      //   273	278	279	java/lang/Exception
      //   38	54	281	finally
      //   58	101	281	finally
      //   101	124	281	finally
      //   160	170	281	finally
      //   151	159	345	java/lang/Exception
      //   313	318	347	java/lang/Exception
      //   170	180	351	finally
      //   180	185	370	finally
      //   228	245	383	finally
      //   170	180	396	java/lang/Exception
      //   180	185	403	java/lang/Exception
    }
    
    public void h(String paramString, long paramLong1, long paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaListViewAdapter", 2, "--onHttpProgress");
      }
      if (this.a != null) {
        this.a.a(1, paramString, null, this.o);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfq
 * JD-Core Version:    0.7.0.1
 */