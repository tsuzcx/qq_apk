package com.tencent.turingfd.sdk.base;

import com.tencent.token.fh;
import java.util.ArrayList;

public class ef
{
  public static eg a;
  public static eg b;
  public static eg c;
  public static boolean d = false;
  public static el e;
  public static Durian f;
  public static boolean g = true;
  public static final au h = new es();
  public static final aw i = new dm();
  
  public static void a()
  {
    try
    {
      if (b.a())
      {
        b.b();
        new dw().start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, eg parameg, Guava paramGuava)
  {
    Object localObject = e.p();
    if (localObject != null) {
      ((fh)localObject).a();
    }
    parameg.b();
    localObject = new eu(ed.b(), paramInt1, null);
    paramInt1 = parameg.h;
    if (paramInt1 < 1) {
      ((eu)localObject).b = 1L;
    }
    for (;;)
    {
      ((eu)localObject).f = paramGuava;
      ((eu)localObject).d = new dr(parameg);
      ((eu)localObject).e = paramInt2;
      parameg = new et((eu)localObject, null);
      ((i)i.a.b()).a(parameg);
      return;
      if (paramInt1 > 12) {
        ((eu)localObject).b = 12L;
      } else {
        ((eu)localObject).b = paramInt1;
      }
    }
  }
  
  /* Error */
  public static void a(el paramel)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 132	com/tencent/turingfd/sdk/base/el:o	()Landroid/content/Context;
    //   7: invokestatic 135	com/tencent/turingfd/sdk/base/ed:b	(Landroid/content/Context;)Z
    //   10: pop
    //   11: aload_0
    //   12: putstatic 56	com/tencent/turingfd/sdk/base/ef:e	Lcom/tencent/turingfd/sdk/base/el;
    //   15: new 137	com/tencent/turingfd/sdk/base/Durian
    //   18: dup
    //   19: invokespecial 138	com/tencent/turingfd/sdk/base/Durian:<init>	()V
    //   22: astore_2
    //   23: new 140	com/tencent/turingfd/sdk/base/Flat
    //   26: dup
    //   27: invokespecial 141	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   30: astore_3
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 143	com/tencent/turingfd/sdk/base/el:i	()Ljava/lang/String;
    //   36: putfield 147	com/tencent/turingfd/sdk/base/Durian:metaData	Ljava/lang/String;
    //   39: aload_3
    //   40: aload_0
    //   41: invokevirtual 150	com/tencent/turingfd/sdk/base/el:k	()Ljava/lang/String;
    //   44: putfield 153	com/tencent/turingfd/sdk/base/Flat:version	Ljava/lang/String;
    //   47: aload_3
    //   48: aload_0
    //   49: invokevirtual 156	com/tencent/turingfd/sdk/base/el:j	()Ljava/lang/String;
    //   52: putfield 159	com/tencent/turingfd/sdk/base/Flat:Qb	Ljava/lang/String;
    //   55: aload_3
    //   56: aload_0
    //   57: invokevirtual 162	com/tencent/turingfd/sdk/base/el:m	()Ljava/lang/String;
    //   60: putfield 165	com/tencent/turingfd/sdk/base/Flat:aa	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: invokevirtual 169	com/tencent/turingfd/sdk/base/el:l	()I
    //   68: putfield 172	com/tencent/turingfd/sdk/base/Flat:Ac	I
    //   71: aload_2
    //   72: aload_3
    //   73: putfield 176	com/tencent/turingfd/sdk/base/Durian:uc	Lcom/tencent/turingfd/sdk/base/Flat;
    //   76: aload_2
    //   77: putstatic 178	com/tencent/turingfd/sdk/base/ef:f	Lcom/tencent/turingfd/sdk/base/Durian;
    //   80: getstatic 180	com/tencent/turingfd/sdk/base/ef:d	Z
    //   83: istore_1
    //   84: iload_1
    //   85: ifeq +7 -> 92
    //   88: ldc 2
    //   90: monitorexit
    //   91: return
    //   92: iconst_1
    //   93: putstatic 180	com/tencent/turingfd/sdk/base/ef:d	Z
    //   96: invokestatic 185	com/tencent/turingfd/sdk/base/ai:a	()Lcom/tencent/turingfd/sdk/base/ai;
    //   99: astore_2
    //   100: aload_0
    //   101: invokevirtual 132	com/tencent/turingfd/sdk/base/el:o	()Landroid/content/Context;
    //   104: astore_3
    //   105: aload_2
    //   106: aload_3
    //   107: bipush 100
    //   109: invokevirtual 188	com/tencent/turingfd/sdk/base/ai:a	(Landroid/content/Context;I)Lcom/tencent/turingfd/sdk/base/eg;
    //   112: putstatic 190	com/tencent/turingfd/sdk/base/ef:c	Lcom/tencent/turingfd/sdk/base/eg;
    //   115: getstatic 190	com/tencent/turingfd/sdk/base/ef:c	Lcom/tencent/turingfd/sdk/base/eg;
    //   118: ifnonnull +32 -> 150
    //   121: new 40	com/tencent/turingfd/sdk/base/eg
    //   124: dup
    //   125: aload_3
    //   126: aload_0
    //   127: invokevirtual 192	com/tencent/turingfd/sdk/base/el:g	()I
    //   130: aload_0
    //   131: invokevirtual 194	com/tencent/turingfd/sdk/base/el:h	()I
    //   134: aload_0
    //   135: invokevirtual 196	com/tencent/turingfd/sdk/base/el:f	()I
    //   138: aload_0
    //   139: invokevirtual 198	com/tencent/turingfd/sdk/base/el:e	()I
    //   142: bipush 100
    //   144: invokespecial 201	com/tencent/turingfd/sdk/base/eg:<init>	(Landroid/content/Context;IIIII)V
    //   147: putstatic 190	com/tencent/turingfd/sdk/base/ef:c	Lcom/tencent/turingfd/sdk/base/eg;
    //   150: aload_2
    //   151: aload_3
    //   152: sipush 999
    //   155: invokevirtual 188	com/tencent/turingfd/sdk/base/ai:a	(Landroid/content/Context;I)Lcom/tencent/turingfd/sdk/base/eg;
    //   158: putstatic 203	com/tencent/turingfd/sdk/base/ef:a	Lcom/tencent/turingfd/sdk/base/eg;
    //   161: getstatic 203	com/tencent/turingfd/sdk/base/ef:a	Lcom/tencent/turingfd/sdk/base/eg;
    //   164: ifnonnull +24 -> 188
    //   167: new 40	com/tencent/turingfd/sdk/base/eg
    //   170: dup
    //   171: aload_3
    //   172: bipush 20
    //   174: bipush 6
    //   176: bipush 30
    //   178: iconst_3
    //   179: sipush 999
    //   182: invokespecial 201	com/tencent/turingfd/sdk/base/eg:<init>	(Landroid/content/Context;IIIII)V
    //   185: putstatic 203	com/tencent/turingfd/sdk/base/ef:a	Lcom/tencent/turingfd/sdk/base/eg;
    //   188: aload_2
    //   189: aload_3
    //   190: sipush 998
    //   193: invokevirtual 188	com/tencent/turingfd/sdk/base/ai:a	(Landroid/content/Context;I)Lcom/tencent/turingfd/sdk/base/eg;
    //   196: putstatic 38	com/tencent/turingfd/sdk/base/ef:b	Lcom/tencent/turingfd/sdk/base/eg;
    //   199: getstatic 38	com/tencent/turingfd/sdk/base/ef:b	Lcom/tencent/turingfd/sdk/base/eg;
    //   202: ifnonnull +24 -> 226
    //   205: new 40	com/tencent/turingfd/sdk/base/eg
    //   208: dup
    //   209: aload_3
    //   210: iconst_1
    //   211: iconst_1
    //   212: sipush 3600
    //   215: bipush 6
    //   217: sipush 998
    //   220: invokespecial 201	com/tencent/turingfd/sdk/base/eg:<init>	(Landroid/content/Context;IIIII)V
    //   223: putstatic 38	com/tencent/turingfd/sdk/base/ef:b	Lcom/tencent/turingfd/sdk/base/eg;
    //   226: getstatic 206	com/tencent/turingfd/sdk/base/z:a	Lcom/tencent/turingfd/sdk/base/dj;
    //   229: invokevirtual 110	com/tencent/turingfd/sdk/base/dj:b	()Ljava/lang/Object;
    //   232: checkcast 205	com/tencent/turingfd/sdk/base/z
    //   235: aload_0
    //   236: invokevirtual 210	com/tencent/turingfd/sdk/base/el:q	()Lcom/tencent/turingfd/sdk/base/dg;
    //   239: invokevirtual 213	com/tencent/turingfd/sdk/base/z:a	(Lcom/tencent/turingfd/sdk/base/dg;)V
    //   242: aload_0
    //   243: invokevirtual 132	com/tencent/turingfd/sdk/base/el:o	()Landroid/content/Context;
    //   246: getstatic 30	com/tencent/turingfd/sdk/base/ef:h	Lcom/tencent/turingfd/sdk/base/au;
    //   249: getstatic 35	com/tencent/turingfd/sdk/base/ef:i	Lcom/tencent/turingfd/sdk/base/aw;
    //   252: invokestatic 218	com/tencent/turingfd/sdk/base/em:a	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/base/au;Lcom/tencent/turingfd/sdk/base/aw;)V
    //   255: invokestatic 219	com/tencent/turingfd/sdk/base/em:a	()V
    //   258: aload_0
    //   259: invokevirtual 223	com/tencent/turingfd/sdk/base/el:n	()Landroid/app/Activity;
    //   262: ifnull +10 -> 272
    //   265: aload_0
    //   266: invokevirtual 223	com/tencent/turingfd/sdk/base/el:n	()Landroid/app/Activity;
    //   269: invokestatic 226	com/tencent/turingfd/sdk/base/em:a	(Landroid/app/Activity;)V
    //   272: invokestatic 227	com/tencent/turingfd/sdk/base/ef:a	()V
    //   275: goto -187 -> 88
    //   278: astore_0
    //   279: ldc 2
    //   281: monitorexit
    //   282: aload_0
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramel	el
    //   83	2	1	bool	boolean
    //   22	167	2	localObject1	Object
    //   30	180	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	84	278	finally
    //   92	150	278	finally
    //   150	188	278	finally
    //   188	226	278	finally
    //   226	272	278	finally
    //   272	275	278	finally
  }
  
  public static void b()
  {
    try
    {
      Guava localGuava = new Guava();
      localGuava.cd = System.currentTimeMillis();
      localGuava.duration = 0;
      localGuava.dd = new ArrayList();
      a(998, 0, b, localGuava);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ef
 * JD-Core Version:    0.7.0.1
 */