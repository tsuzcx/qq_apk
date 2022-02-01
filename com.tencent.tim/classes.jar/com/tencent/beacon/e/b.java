package com.tencent.beacon.e;

import com.tencent.beacon.a.a.c;
import com.tencent.beacon.a.a.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class b
  implements d
{
  private static volatile b a;
  protected int A = 1;
  protected int b = 48;
  protected int c = 2000;
  protected int d = 48;
  protected int e = 3000;
  protected boolean f = true;
  protected boolean g = true;
  protected Set<String> h = null;
  protected Map<String, Float> i = null;
  protected boolean j = false;
  protected boolean k = false;
  protected boolean l = false;
  protected float m = 1.0F;
  protected boolean n = false;
  protected boolean o = false;
  protected boolean p = false;
  protected int q = 1;
  protected long r = 6400L;
  protected int s = 20;
  protected int t = 300;
  protected boolean u = true;
  protected boolean v = true;
  protected boolean w = true;
  protected boolean x = true;
  protected int y = 10000;
  protected boolean z = false;
  
  protected b()
  {
    com.tencent.beacon.a.a.b.a().a(8, this);
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private void b(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("d_m", new HashMap(paramMap));
    com.tencent.beacon.a.a.b.a().b(new c(2, localHashMap));
  }
  
  /* Error */
  public void a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +588 -> 591
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 139	com/tencent/beacon/e/b:b	(Ljava/util/Map;)V
    //   11: aload_0
    //   12: aload_1
    //   13: ldc 141
    //   15: invokeinterface 147 2 0
    //   20: checkcast 149	java/lang/String
    //   23: aload_0
    //   24: getfield 48	com/tencent/beacon/e/b:b	I
    //   27: bipush 24
    //   29: bipush 100
    //   31: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   34: putfield 48	com/tencent/beacon/e/b:b	I
    //   37: aload_0
    //   38: aload_1
    //   39: ldc 156
    //   41: invokeinterface 147 2 0
    //   46: checkcast 149	java/lang/String
    //   49: aload_0
    //   50: getfield 50	com/tencent/beacon/e/b:c	I
    //   53: sipush 1000
    //   56: sipush 10000
    //   59: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   62: putfield 50	com/tencent/beacon/e/b:c	I
    //   65: aload_0
    //   66: aload_1
    //   67: ldc 158
    //   69: invokeinterface 147 2 0
    //   74: checkcast 149	java/lang/String
    //   77: aload_0
    //   78: getfield 54	com/tencent/beacon/e/b:e	I
    //   81: sipush 2000
    //   84: ldc 159
    //   86: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   89: putfield 54	com/tencent/beacon/e/b:e	I
    //   92: aload_0
    //   93: aload_1
    //   94: ldc 161
    //   96: invokeinterface 147 2 0
    //   101: checkcast 149	java/lang/String
    //   104: aload_0
    //   105: getfield 52	com/tencent/beacon/e/b:d	I
    //   108: bipush 24
    //   110: bipush 100
    //   112: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   115: putfield 52	com/tencent/beacon/e/b:d	I
    //   118: aload_0
    //   119: aload_1
    //   120: ldc 163
    //   122: invokeinterface 147 2 0
    //   127: checkcast 149	java/lang/String
    //   130: aload_0
    //   131: getfield 58	com/tencent/beacon/e/b:g	Z
    //   134: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   137: putfield 58	com/tencent/beacon/e/b:g	Z
    //   140: aload_0
    //   141: aload_1
    //   142: ldc 168
    //   144: invokeinterface 147 2 0
    //   149: checkcast 149	java/lang/String
    //   152: aload_0
    //   153: getfield 64	com/tencent/beacon/e/b:j	Z
    //   156: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   159: putfield 64	com/tencent/beacon/e/b:j	Z
    //   162: aload_0
    //   163: aload_1
    //   164: ldc 170
    //   166: invokeinterface 147 2 0
    //   171: checkcast 149	java/lang/String
    //   174: aload_0
    //   175: getfield 66	com/tencent/beacon/e/b:k	Z
    //   178: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   181: putfield 66	com/tencent/beacon/e/b:k	Z
    //   184: aload_0
    //   185: aload_1
    //   186: ldc 172
    //   188: invokeinterface 147 2 0
    //   193: checkcast 149	java/lang/String
    //   196: aload_0
    //   197: getfield 68	com/tencent/beacon/e/b:l	Z
    //   200: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   203: putfield 68	com/tencent/beacon/e/b:l	Z
    //   206: aload_1
    //   207: ldc 174
    //   209: invokeinterface 147 2 0
    //   214: checkcast 149	java/lang/String
    //   217: astore_3
    //   218: aload_3
    //   219: ifnull +55 -> 274
    //   222: aload_3
    //   223: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 182	java/lang/String:length	()I
    //   231: istore_2
    //   232: iload_2
    //   233: ifle +41 -> 274
    //   236: aload_3
    //   237: ldc 184
    //   239: invokevirtual 188	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   242: astore_3
    //   243: aload_3
    //   244: arraylength
    //   245: istore_2
    //   246: iload_2
    //   247: iconst_2
    //   248: if_icmpne +26 -> 274
    //   251: aload_0
    //   252: aload_3
    //   253: iconst_0
    //   254: aaload
    //   255: invokestatic 194	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   258: invokevirtual 198	java/lang/Float:floatValue	()F
    //   261: aload_3
    //   262: iconst_1
    //   263: aaload
    //   264: invokestatic 194	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   267: invokevirtual 198	java/lang/Float:floatValue	()F
    //   270: fdiv
    //   271: putfield 70	com/tencent/beacon/e/b:m	F
    //   274: aload_0
    //   275: aload_1
    //   276: ldc 200
    //   278: invokeinterface 147 2 0
    //   283: checkcast 149	java/lang/String
    //   286: aload_0
    //   287: getfield 98	com/tencent/beacon/e/b:z	Z
    //   290: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   293: putfield 98	com/tencent/beacon/e/b:z	Z
    //   296: aload_0
    //   297: aload_1
    //   298: ldc 202
    //   300: invokeinterface 147 2 0
    //   305: checkcast 149	java/lang/String
    //   308: aload_0
    //   309: getfield 100	com/tencent/beacon/e/b:A	I
    //   312: iconst_1
    //   313: ldc 203
    //   315: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   318: putfield 100	com/tencent/beacon/e/b:A	I
    //   321: aload_0
    //   322: aload_1
    //   323: ldc 205
    //   325: invokeinterface 147 2 0
    //   330: checkcast 149	java/lang/String
    //   333: aload_0
    //   334: getfield 72	com/tencent/beacon/e/b:n	Z
    //   337: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   340: putfield 72	com/tencent/beacon/e/b:n	Z
    //   343: aload_0
    //   344: aload_1
    //   345: ldc 207
    //   347: invokeinterface 147 2 0
    //   352: checkcast 149	java/lang/String
    //   355: aload_0
    //   356: getfield 74	com/tencent/beacon/e/b:o	Z
    //   359: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   362: putfield 74	com/tencent/beacon/e/b:o	Z
    //   365: aload_0
    //   366: aload_1
    //   367: ldc 209
    //   369: invokeinterface 147 2 0
    //   374: checkcast 149	java/lang/String
    //   377: aload_0
    //   378: getfield 76	com/tencent/beacon/e/b:p	Z
    //   381: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   384: putfield 76	com/tencent/beacon/e/b:p	Z
    //   387: aload_0
    //   388: aload_1
    //   389: ldc 211
    //   391: invokeinterface 147 2 0
    //   396: checkcast 149	java/lang/String
    //   399: aload_0
    //   400: getfield 78	com/tencent/beacon/e/b:q	I
    //   403: iconst_1
    //   404: bipush 50
    //   406: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   409: putfield 78	com/tencent/beacon/e/b:q	I
    //   412: aload_0
    //   413: aload_1
    //   414: ldc 213
    //   416: invokeinterface 147 2 0
    //   421: checkcast 149	java/lang/String
    //   424: aload_0
    //   425: getfield 82	com/tencent/beacon/e/b:r	J
    //   428: ldc2_w 214
    //   431: ldc2_w 216
    //   434: invokestatic 220	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;JJJ)J
    //   437: putfield 82	com/tencent/beacon/e/b:r	J
    //   440: aload_0
    //   441: aload_1
    //   442: ldc 222
    //   444: invokeinterface 147 2 0
    //   449: checkcast 149	java/lang/String
    //   452: aload_0
    //   453: getfield 84	com/tencent/beacon/e/b:s	I
    //   456: bipush 20
    //   458: bipush 100
    //   460: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   463: putfield 84	com/tencent/beacon/e/b:s	I
    //   466: aload_0
    //   467: aload_1
    //   468: ldc 224
    //   470: invokeinterface 147 2 0
    //   475: checkcast 149	java/lang/String
    //   478: aload_0
    //   479: getfield 86	com/tencent/beacon/e/b:t	I
    //   482: bipush 60
    //   484: ldc 225
    //   486: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   489: putfield 86	com/tencent/beacon/e/b:t	I
    //   492: aload_0
    //   493: aload_1
    //   494: ldc 227
    //   496: invokeinterface 147 2 0
    //   501: checkcast 149	java/lang/String
    //   504: aload_0
    //   505: getfield 88	com/tencent/beacon/e/b:u	Z
    //   508: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   511: putfield 88	com/tencent/beacon/e/b:u	Z
    //   514: aload_0
    //   515: aload_1
    //   516: ldc 229
    //   518: invokeinterface 147 2 0
    //   523: checkcast 149	java/lang/String
    //   526: aload_0
    //   527: getfield 90	com/tencent/beacon/e/b:v	Z
    //   530: invokestatic 166	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   533: putfield 90	com/tencent/beacon/e/b:v	Z
    //   536: aload_0
    //   537: aload_1
    //   538: ldc 231
    //   540: invokeinterface 147 2 0
    //   545: checkcast 149	java/lang/String
    //   548: aload_0
    //   549: getfield 96	com/tencent/beacon/e/b:y	I
    //   552: sipush 10000
    //   555: ldc 232
    //   557: invokestatic 154	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;III)I
    //   560: putfield 96	com/tencent/beacon/e/b:y	I
    //   563: aload_1
    //   564: ldc 234
    //   566: invokeinterface 147 2 0
    //   571: checkcast 149	java/lang/String
    //   574: invokestatic 239	com/tencent/beacon/base/net/b/b:c	(Ljava/lang/String;)V
    //   577: aload_1
    //   578: ldc 241
    //   580: invokeinterface 147 2 0
    //   585: checkcast 149	java/lang/String
    //   588: invokestatic 243	com/tencent/beacon/base/net/b/b:e	(Ljava/lang/String;)V
    //   591: aload_0
    //   592: monitorexit
    //   593: return
    //   594: astore_3
    //   595: aload_3
    //   596: invokestatic 248	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   599: goto -325 -> 274
    //   602: astore_1
    //   603: aload_1
    //   604: invokestatic 248	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   607: goto -16 -> 591
    //   610: astore_1
    //   611: aload_0
    //   612: monitorexit
    //   613: aload_1
    //   614: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	this	b
    //   0	615	1	paramMap	Map<String, String>
    //   231	18	2	i1	int
    //   217	45	3	localObject	Object
    //   594	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   251	274	594	java/lang/Exception
    //   11	37	602	java/lang/Exception
    //   37	65	602	java/lang/Exception
    //   65	92	602	java/lang/Exception
    //   92	118	602	java/lang/Exception
    //   118	140	602	java/lang/Exception
    //   140	162	602	java/lang/Exception
    //   162	184	602	java/lang/Exception
    //   184	206	602	java/lang/Exception
    //   206	218	602	java/lang/Exception
    //   222	232	602	java/lang/Exception
    //   236	246	602	java/lang/Exception
    //   274	296	602	java/lang/Exception
    //   296	321	602	java/lang/Exception
    //   321	343	602	java/lang/Exception
    //   343	365	602	java/lang/Exception
    //   365	387	602	java/lang/Exception
    //   387	412	602	java/lang/Exception
    //   412	440	602	java/lang/Exception
    //   440	466	602	java/lang/Exception
    //   466	492	602	java/lang/Exception
    //   492	514	602	java/lang/Exception
    //   514	536	602	java/lang/Exception
    //   536	563	602	java/lang/Exception
    //   563	577	602	java/lang/Exception
    //   577	591	602	java/lang/Exception
    //   595	599	602	java/lang/Exception
    //   6	11	610	finally
    //   11	37	610	finally
    //   37	65	610	finally
    //   65	92	610	finally
    //   92	118	610	finally
    //   118	140	610	finally
    //   140	162	610	finally
    //   162	184	610	finally
    //   184	206	610	finally
    //   206	218	610	finally
    //   222	232	610	finally
    //   236	246	610	finally
    //   251	274	610	finally
    //   274	296	610	finally
    //   296	321	610	finally
    //   321	343	610	finally
    //   343	365	610	finally
    //   365	387	610	finally
    //   387	412	610	finally
    //   412	440	610	finally
    //   440	466	610	finally
    //   466	492	610	finally
    //   492	514	610	finally
    //   514	536	610	finally
    //   536	563	610	finally
    //   563	577	610	finally
    //   577	591	610	finally
    //   595	599	610	finally
    //   603	607	610	finally
  }
  
  public void a(Set<String> paramSet)
  {
    try
    {
      this.h = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Set localSet = this.h;
      boolean bool1 = bool2;
      if (localSet != null)
      {
        bool1 = bool2;
        if (localSet.size() > 0) {
          bool1 = this.h.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public int b()
  {
    return this.y;
  }
  
  /* Error */
  public void b(Set<String> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/beacon/e/b:i	Ljava/util/Map;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 116	java/util/HashMap
    //   13: dup
    //   14: invokespecial 117	java/util/HashMap:<init>	()V
    //   17: putfield 62	com/tencent/beacon/e/b:i	Ljava/util/Map;
    //   20: aload_1
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: invokeinterface 265 1 0
    //   33: astore_1
    //   34: aload_1
    //   35: invokeinterface 271 1 0
    //   40: ifeq -16 -> 24
    //   43: aload_1
    //   44: invokeinterface 275 1 0
    //   49: checkcast 149	java/lang/String
    //   52: ldc 184
    //   54: invokevirtual 188	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 4
    //   59: aload 4
    //   61: arraylength
    //   62: istore_3
    //   63: iload_3
    //   64: iconst_3
    //   65: if_icmpne -31 -> 34
    //   68: aload 4
    //   70: iconst_1
    //   71: aaload
    //   72: invokestatic 194	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   75: invokevirtual 198	java/lang/Float:floatValue	()F
    //   78: aload 4
    //   80: iconst_2
    //   81: aaload
    //   82: invokestatic 194	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   85: invokevirtual 198	java/lang/Float:floatValue	()F
    //   88: fdiv
    //   89: fstore_2
    //   90: aload_0
    //   91: getfield 62	com/tencent/beacon/e/b:i	Ljava/util/Map;
    //   94: aload 4
    //   96: iconst_0
    //   97: aaload
    //   98: invokevirtual 278	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   101: fload_2
    //   102: invokestatic 281	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   105: invokeinterface 282 3 0
    //   110: pop
    //   111: goto -77 -> 34
    //   114: astore 4
    //   116: aload 4
    //   118: invokestatic 248	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   121: goto -87 -> 34
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	b
    //   0	129	1	paramSet	Set<String>
    //   89	13	2	f1	float
    //   62	4	3	i1	int
    //   57	38	4	arrayOfString	String[]
    //   114	3	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   68	111	114	java/lang/Exception
    //   2	20	124	finally
    //   27	34	124	finally
    //   34	63	124	finally
    //   68	111	124	finally
    //   116	121	124	finally
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.i;
        boolean bool;
        if (localObject != null)
        {
          localObject = ((Map)localObject).get(paramString.toLowerCase());
          if (localObject != null) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        int i1 = (int)(((Float)this.i.get(paramString.toLowerCase())).floatValue() * 1000.0F);
        int i2 = new Random().nextInt(1000);
        if (i2 + 1 > i1) {
          bool = false;
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  public int c()
  {
    try
    {
      int i1 = this.A;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d()
  {
    return this.v;
  }
  
  public boolean e()
  {
    return this.u;
  }
  
  public boolean f()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.w;
  }
  
  public boolean i()
  {
    return this.x;
  }
  
  public boolean j()
  {
    try
    {
      boolean bool = this.z;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onEvent(c paramc)
  {
    if (paramc.a != 8) {
      return;
    }
    label83:
    int i1;
    if (paramc.b.containsKey("u_c_a_e"))
    {
      bool = ((Boolean)paramc.b.get("u_c_a_e")).booleanValue();
      this.v = bool;
      if (!paramc.b.containsKey("u_c_b_e")) {
        break label214;
      }
      bool = ((Boolean)paramc.b.get("u_c_b_e")).booleanValue();
      this.u = bool;
      if (!paramc.b.containsKey("u_c_d_s")) {
        break label222;
      }
      i1 = ((Integer)paramc.b.get("u_c_d_s")).intValue();
      label122:
      this.y = i1;
      if (!paramc.b.containsKey("u_c_p_s")) {
        break label230;
      }
      bool = ((Boolean)paramc.b.get("u_c_p_s")).booleanValue();
      label161:
      this.f = bool;
      if (!paramc.b.containsKey("u_s_o_h")) {
        break label238;
      }
    }
    label214:
    label222:
    label230:
    label238:
    for (boolean bool = ((Boolean)paramc.b.get("u_s_o_h")).booleanValue();; bool = this.x)
    {
      this.x = bool;
      return;
      bool = this.v;
      break;
      bool = this.u;
      break label83;
      i1 = this.y;
      break label122;
      bool = this.f;
      break label161;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.e.b
 * JD-Core Version:    0.7.0.1
 */