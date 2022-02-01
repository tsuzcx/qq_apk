package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.service.a.a;
import com.huawei.updatesdk.service.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class h
{
  private static h a = new h();
  private String b;
  private String c;
  private String d = null;
  
  public static h a()
  {
    return a;
  }
  
  public void a(Context paramContext)
  {
    this.c = null;
    if (!c.b(paramContext)) {
      return;
    }
    long l = a.a().d();
    if (Math.abs(System.currentTimeMillis() - l) < 86400000L)
    {
      paramContext = a.a().e();
      a().b(paramContext);
      Log.i("ServiceZoneUtil", "less than one day from the last query, return accountZone:" + paramContext);
      return;
    }
    paramContext = new a(null);
    paramContext.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
    try
    {
      paramContext.get(1000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (Exception localException)
    {
      paramContext.cancel(true);
      Log.e("ServiceZoneUtil", "init AccountZone error: " + localException.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return this.b;
    }
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean d()
  {
    if (this.b != null) {
      return this.b.equals(this.c);
    }
    return true;
  }
  
  static class a
    extends AsyncTask<Void, Void, String>
  {
    /* Error */
    protected String a(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc 20
      //   4: invokestatic 26	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   7: astore_1
      //   8: invokestatic 31	com/huawei/updatesdk/a/b/a/a:a	()Lcom/huawei/updatesdk/a/b/a/a;
      //   11: invokevirtual 35	com/huawei/updatesdk/a/b/a/a:b	()Landroid/content/Context;
      //   14: invokevirtual 41	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   17: aload_1
      //   18: aconst_null
      //   19: aconst_null
      //   20: aconst_null
      //   21: aconst_null
      //   22: invokestatic 47	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   25: astore_1
      //   26: aload_1
      //   27: ifnull +93 -> 120
      //   30: aload_1
      //   31: invokeinterface 53 1 0
      //   36: ifeq +84 -> 120
      //   39: aload_1
      //   40: aload_1
      //   41: ldc 55
      //   43: invokeinterface 59 2 0
      //   48: invokeinterface 63 2 0
      //   53: astore_3
      //   54: invokestatic 66	com/huawei/updatesdk/service/otaupdate/h:a	()Lcom/huawei/updatesdk/service/otaupdate/h;
      //   57: aload_3
      //   58: invokevirtual 69	com/huawei/updatesdk/service/otaupdate/h:b	(Ljava/lang/String;)V
      //   61: invokestatic 74	com/huawei/updatesdk/service/a/a:a	()Lcom/huawei/updatesdk/service/a/a;
      //   64: invokestatic 80	java/lang/System:currentTimeMillis	()J
      //   67: invokevirtual 83	com/huawei/updatesdk/service/a/a:b	(J)V
      //   70: invokestatic 74	com/huawei/updatesdk/service/a/a:a	()Lcom/huawei/updatesdk/service/a/a;
      //   73: aload_3
      //   74: invokevirtual 84	com/huawei/updatesdk/service/a/a:b	(Ljava/lang/String;)V
      //   77: ldc 86
      //   79: new 88	java/lang/StringBuilder
      //   82: dup
      //   83: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   86: ldc 91
      //   88: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   91: aload_3
      //   92: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   98: invokestatic 105	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   101: pop
      //   102: aload_3
      //   103: astore_2
      //   104: aload_2
      //   105: astore_3
      //   106: aload_1
      //   107: ifnull +11 -> 118
      //   110: aload_1
      //   111: invokeinterface 108 1 0
      //   116: aload_2
      //   117: astore_3
      //   118: aload_3
      //   119: areturn
      //   120: ldc 86
      //   122: ldc 110
      //   124: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   127: pop
      //   128: aconst_null
      //   129: astore_2
      //   130: goto -26 -> 104
      //   133: astore_1
      //   134: ldc 86
      //   136: ldc 115
      //   138: invokestatic 121	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   141: aload_2
      //   142: areturn
      //   143: astore_3
      //   144: aconst_null
      //   145: astore_1
      //   146: ldc 86
      //   148: new 88	java/lang/StringBuilder
      //   151: dup
      //   152: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   155: ldc 123
      //   157: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   160: aload_3
      //   161: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
      //   164: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   167: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   170: invokestatic 113	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   173: pop
      //   174: aload_1
      //   175: astore_3
      //   176: aload_2
      //   177: ifnull -59 -> 118
      //   180: aload_2
      //   181: invokeinterface 108 1 0
      //   186: aload_1
      //   187: areturn
      //   188: astore_2
      //   189: ldc 86
      //   191: ldc 115
      //   193: invokestatic 121	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   196: aload_1
      //   197: areturn
      //   198: astore_2
      //   199: aconst_null
      //   200: astore_1
      //   201: aload_1
      //   202: ifnull +9 -> 211
      //   205: aload_1
      //   206: invokeinterface 108 1 0
      //   211: aload_2
      //   212: athrow
      //   213: astore_1
      //   214: ldc 86
      //   216: ldc 115
      //   218: invokestatic 121	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   221: goto -10 -> 211
      //   224: astore_2
      //   225: goto -24 -> 201
      //   228: astore_3
      //   229: aload_2
      //   230: astore_1
      //   231: aload_3
      //   232: astore_2
      //   233: goto -32 -> 201
      //   236: astore_3
      //   237: aconst_null
      //   238: astore 4
      //   240: aload_1
      //   241: astore_2
      //   242: aload 4
      //   244: astore_1
      //   245: goto -99 -> 146
      //   248: astore 4
      //   250: aload_1
      //   251: astore_2
      //   252: aload_3
      //   253: astore_1
      //   254: aload 4
      //   256: astore_3
      //   257: goto -111 -> 146
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	260	0	this	a
      //   0	260	1	paramVarArgs	Void[]
      //   1	180	2	localObject1	Object
      //   188	1	2	localException1	Exception
      //   198	14	2	localObject2	Object
      //   224	6	2	localObject3	Object
      //   232	20	2	localObject4	Object
      //   53	66	3	localObject5	Object
      //   143	18	3	localException2	Exception
      //   175	1	3	arrayOfVoid	Void[]
      //   228	4	3	localObject6	Object
      //   236	17	3	localException3	Exception
      //   256	1	3	localObject7	Object
      //   238	5	4	localObject8	Object
      //   248	7	4	localException4	Exception
      // Exception table:
      //   from	to	target	type
      //   110	116	133	java/lang/Exception
      //   8	26	143	java/lang/Exception
      //   180	186	188	java/lang/Exception
      //   8	26	198	finally
      //   205	211	213	java/lang/Exception
      //   30	54	224	finally
      //   54	102	224	finally
      //   120	128	224	finally
      //   146	174	228	finally
      //   30	54	236	java/lang/Exception
      //   120	128	236	java/lang/Exception
      //   54	102	248	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.h
 * JD-Core Version:    0.7.0.1
 */