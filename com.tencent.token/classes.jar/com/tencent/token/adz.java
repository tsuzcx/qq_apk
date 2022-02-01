package com.tencent.token;

import android.app.Activity;
import com.tencent.turingfd.sdk.qps.Cumquat;
import com.tencent.turingfd.sdk.qps.Grape;

public class adz
{
  public static aeq a;
  public static aeq b;
  public static aeq c;
  public static boolean d = false;
  public static agr e;
  public static Cumquat f;
  public static boolean g = true;
  public static final acd h = new a();
  public static final acg i = new b();
  
  /* Error */
  public static void a(int paramInt1, int paramInt2, aeq arg2, Grape paramGrape)
  {
    // Byte code:
    //   0: getstatic 42	com/tencent/token/adl:a	Lcom/tencent/token/agi;
    //   3: invokevirtual 47	com/tencent/token/agi:b	()Ljava/lang/Object;
    //   6: checkcast 39	com/tencent/token/adl
    //   9: astore 5
    //   11: new 49	com/tencent/token/aea
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 52	com/tencent/token/aea:<init>	(Lcom/tencent/token/aeq;)V
    //   19: astore 6
    //   21: aload 5
    //   23: getfield 55	com/tencent/token/adl:b	Landroid/os/Handler;
    //   26: aload 6
    //   28: lconst_0
    //   29: invokevirtual 61	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   32: pop
    //   33: ldc 63
    //   35: monitorenter
    //   36: getstatic 66	com/tencent/token/agn:a	Landroid/content/Context;
    //   39: astore 5
    //   41: ldc 63
    //   43: monitorexit
    //   44: new 68	com/tencent/token/afe$a
    //   47: dup
    //   48: aload 5
    //   50: iload_0
    //   51: invokespecial 71	com/tencent/token/afe$a:<init>	(Landroid/content/Context;I)V
    //   54: astore 5
    //   56: aload_2
    //   57: getfield 76	com/tencent/token/aeq:h	I
    //   60: istore_0
    //   61: iload_0
    //   62: ifgt +12 -> 74
    //   65: aload 5
    //   67: lconst_1
    //   68: putfield 79	com/tencent/token/afe$a:b	J
    //   71: goto +27 -> 98
    //   74: iload_0
    //   75: bipush 12
    //   77: if_icmple +14 -> 91
    //   80: aload 5
    //   82: ldc2_w 80
    //   85: putfield 79	com/tencent/token/afe$a:b	J
    //   88: goto +10 -> 98
    //   91: aload 5
    //   93: iload_0
    //   94: i2l
    //   95: putfield 79	com/tencent/token/afe$a:b	J
    //   98: aload 5
    //   100: aload_3
    //   101: putfield 84	com/tencent/token/afe$a:f	Lcom/tencent/turingfd/sdk/qps/Grape;
    //   104: aload 5
    //   106: new 86	com/tencent/token/aeh
    //   109: dup
    //   110: aload_2
    //   111: invokespecial 87	com/tencent/token/aeh:<init>	(Lcom/tencent/token/aeq;)V
    //   114: putfield 90	com/tencent/token/afe$a:d	Lcom/tencent/token/afa;
    //   117: aload 5
    //   119: iload_1
    //   120: putfield 92	com/tencent/token/afe$a:e	I
    //   123: new 94	com/tencent/token/afe
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 97	com/tencent/token/afe:<init>	(Lcom/tencent/token/afe$a;)V
    //   132: astore 6
    //   134: getstatic 100	com/tencent/token/afk:a	Lcom/tencent/token/agi;
    //   137: invokevirtual 47	com/tencent/token/agi:b	()Ljava/lang/Object;
    //   140: checkcast 99	com/tencent/token/afk
    //   143: astore_2
    //   144: aload_2
    //   145: monitorenter
    //   146: aload_2
    //   147: aload 6
    //   149: getfield 102	com/tencent/token/afe:c	Landroid/content/Context;
    //   152: putfield 104	com/tencent/token/afk:e	Landroid/content/Context;
    //   155: aload_2
    //   156: aload 6
    //   158: putfield 107	com/tencent/token/afk:h	Lcom/tencent/token/afe;
    //   161: new 109	com/tencent/token/afk$b
    //   164: dup
    //   165: aload_2
    //   166: invokespecial 112	com/tencent/token/afk$b:<init>	(Lcom/tencent/token/afk;)V
    //   169: astore 7
    //   171: getstatic 115	com/tencent/token/acu:a	Lcom/tencent/token/agi;
    //   174: invokevirtual 47	com/tencent/token/agi:b	()Ljava/lang/Object;
    //   177: checkcast 114	com/tencent/token/acu
    //   180: astore_3
    //   181: aload_2
    //   182: getfield 117	com/tencent/token/afk:f	Landroid/os/Handler;
    //   185: astore 5
    //   187: aload_3
    //   188: aload 7
    //   190: putfield 120	com/tencent/token/acu:h	Lcom/tencent/token/acq;
    //   193: aload_3
    //   194: getfield 122	com/tencent/token/acu:b	Z
    //   197: ifeq +11 -> 208
    //   200: aload_3
    //   201: aload 5
    //   203: aload 7
    //   205: invokevirtual 125	com/tencent/token/acu:a	(Landroid/os/Handler;Lcom/tencent/token/acq;)V
    //   208: aload_3
    //   209: aload 6
    //   211: putfield 127	com/tencent/token/acu:g	Lcom/tencent/token/afe;
    //   214: aload_3
    //   215: iconst_1
    //   216: putfield 122	com/tencent/token/acu:b	Z
    //   219: aload_3
    //   220: getfield 130	com/tencent/token/acu:c	Lcom/tencent/token/act;
    //   223: ifnonnull +19 -> 242
    //   226: aload_3
    //   227: new 132	com/tencent/token/act
    //   230: dup
    //   231: aload 6
    //   233: getfield 102	com/tencent/token/afe:c	Landroid/content/Context;
    //   236: invokespecial 135	com/tencent/token/act:<init>	(Landroid/content/Context;)V
    //   239: putfield 130	com/tencent/token/acu:c	Lcom/tencent/token/act;
    //   242: aload_3
    //   243: getfield 130	com/tencent/token/acu:c	Lcom/tencent/token/act;
    //   246: astore 7
    //   248: aload 7
    //   250: ifnull +33 -> 283
    //   253: aload 7
    //   255: getfield 138	com/tencent/token/act:d	Landroid/util/SparseArray;
    //   258: astore 6
    //   260: aload 6
    //   262: monitorenter
    //   263: aload 7
    //   265: getfield 138	com/tencent/token/act:d	Landroid/util/SparseArray;
    //   268: invokevirtual 143	android/util/SparseArray:clear	()V
    //   271: aload 6
    //   273: monitorexit
    //   274: goto +9 -> 283
    //   277: astore_3
    //   278: aload 6
    //   280: monitorexit
    //   281: aload_3
    //   282: athrow
    //   283: aload_3
    //   284: getfield 146	com/tencent/token/acu:f	Ljava/util/List;
    //   287: astore 6
    //   289: aload 6
    //   291: monitorenter
    //   292: aload_3
    //   293: getfield 146	com/tencent/token/acu:f	Ljava/util/List;
    //   296: invokeinterface 149 1 0
    //   301: aload 6
    //   303: monitorexit
    //   304: aload_3
    //   305: aload 5
    //   307: putfield 151	com/tencent/token/acu:d	Landroid/os/Handler;
    //   310: aload 5
    //   312: aload_3
    //   313: getfield 155	com/tencent/token/acu:j	Ljava/lang/Runnable;
    //   316: invokevirtual 159	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   319: pop
    //   320: aload_2
    //   321: getfield 162	com/tencent/token/afk:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   324: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   327: istore 4
    //   329: iload 4
    //   331: ifeq +6 -> 337
    //   334: aload_2
    //   335: monitorexit
    //   336: return
    //   337: new 170	java/lang/Thread
    //   340: dup
    //   341: new 172	com/tencent/token/afm
    //   344: dup
    //   345: aload_2
    //   346: invokespecial 173	com/tencent/token/afm:<init>	(Lcom/tencent/token/afk;)V
    //   349: invokespecial 176	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   352: invokevirtual 179	java/lang/Thread:start	()V
    //   355: aload_2
    //   356: monitorexit
    //   357: return
    //   358: astore_3
    //   359: aload 6
    //   361: monitorexit
    //   362: aload_3
    //   363: athrow
    //   364: astore_3
    //   365: aload_2
    //   366: monitorexit
    //   367: aload_3
    //   368: athrow
    //   369: astore_2
    //   370: ldc 63
    //   372: monitorexit
    //   373: aload_2
    //   374: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramInt1	int
    //   0	375	1	paramInt2	int
    //   0	375	3	paramGrape	Grape
    //   327	3	4	bool	boolean
    //   9	302	5	localObject1	Object
    //   169	95	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   263	274	277	finally
    //   278	281	277	finally
    //   292	304	358	finally
    //   359	362	358	finally
    //   146	208	364	finally
    //   208	242	364	finally
    //   242	248	364	finally
    //   253	263	364	finally
    //   281	283	364	finally
    //   283	292	364	finally
    //   304	329	364	finally
    //   337	355	364	finally
    //   362	364	364	finally
    //   36	41	369	finally
  }
  
  public final class a
    implements acd
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Grape paramGrape)
    {
      if (paramInt1 == 100)
      {
        paramString = adz.c;
        if ((paramString != null) && (paramString.a()))
        {
          paramString = adz.c;
          break label59;
        }
      }
      if (paramInt1 == 999)
      {
        paramString = adz.a;
        if ((paramString != null) && (paramString.a()))
        {
          paramString = adz.a;
          break label59;
        }
      }
      paramString = null;
      label59:
      if (paramString != null) {
        adz.a(paramInt1, paramInt2, paramString, paramGrape);
      }
    }
  }
  
  public final class b
    implements acg
  {
    public final void a(Activity paramActivity)
    {
      try
      {
        paramActivity = adz.b;
        if ((paramActivity != null) && (paramActivity.a())) {
          new aem().start();
        }
        return;
      }
      finally {}
    }
    
    public final void b(Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adz
 * JD-Core Version:    0.7.0.1
 */