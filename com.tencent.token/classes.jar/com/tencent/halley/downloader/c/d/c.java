package com.tencent.halley.downloader.c.d;

import android.text.TextUtils;
import com.tencent.halley.common.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class c
{
  List a;
  boolean b = false;
  private String c;
  private List d;
  private List e;
  private List f;
  private a g;
  private List h;
  private a i;
  
  public c(b paramb, String paramString)
  {
    this.c = paramString;
  }
  
  private static void a(StringBuilder paramStringBuilder, List paramList)
  {
    if (paramList != null) {
      if ((paramStringBuilder != null) && (paramList != null)) {
        try
        {
          if (paramList.size() > 0)
          {
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              a locala = (a)localIterator.next();
              if (locala != null) {
                paramStringBuilder.append(locala).append(",");
              }
            }
          }
        }
        finally {}
      }
    }
  }
  
  private List b(a.a parama)
  {
    List localList = null;
    if (parama == a.a.c) {
      localList = this.d;
    }
    do
    {
      return localList;
      if (parama == a.a.e) {
        return this.a;
      }
      if (parama == a.a.f) {
        return this.e;
      }
      if (parama == a.a.j) {
        return this.f;
      }
    } while (parama != a.a.h);
    return this.h;
  }
  
  /* Error */
  public final a a(a.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getstatic 92	com/tencent/halley/downloader/c/d/a$a:d	Lcom/tencent/halley/downloader/c/d/a$a;
    //   6: if_acmpne +12 -> 18
    //   9: aload_0
    //   10: getfield 94	com/tencent/halley/downloader/c/d/c:g	Lcom/tencent/halley/downloader/c/d/a;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_1
    //   19: getstatic 96	com/tencent/halley/downloader/c/d/a$a:i	Lcom/tencent/halley/downloader/c/d/a$a;
    //   22: if_acmpne +11 -> 33
    //   25: aload_0
    //   26: getfield 98	com/tencent/halley/downloader/c/d/c:i	Lcom/tencent/halley/downloader/c/d/a;
    //   29: astore_1
    //   30: goto -16 -> 14
    //   33: aload_1
    //   34: invokestatic 101	com/tencent/halley/downloader/c/d/a:b	(Lcom/tencent/halley/downloader/c/d/a$a;)Z
    //   37: ifeq +27 -> 64
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 103	com/tencent/halley/downloader/c/d/c:b	(Lcom/tencent/halley/downloader/c/d/a$a;)Ljava/util/List;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +17 -> 64
    //   50: aload_1
    //   51: iconst_0
    //   52: invokeinterface 107 2 0
    //   57: checkcast 54	com/tencent/halley/downloader/c/d/a
    //   60: astore_1
    //   61: goto -47 -> 14
    //   64: aconst_null
    //   65: astore_1
    //   66: goto -52 -> 14
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	c
    //   0	74	1	parama	a.a
    // Exception table:
    //   from	to	target	type
    //   2	14	69	finally
    //   18	30	69	finally
    //   33	46	69	finally
    //   50	61	69	finally
  }
  
  /* Error */
  public final a a(a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: aload 4
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: areturn
    //   16: aload_0
    //   17: aload_1
    //   18: getfield 110	com/tencent/halley/downloader/c/d/a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   21: invokespecial 103	com/tencent/halley/downloader/c/d/c:b	(Lcom/tencent/halley/downloader/c/d/a$a;)Ljava/util/List;
    //   24: astore 5
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: ifnull -19 -> 12
    //   34: iconst_0
    //   35: istore_2
    //   36: aload 4
    //   38: astore_3
    //   39: iload_2
    //   40: aload 5
    //   42: invokeinterface 38 1 0
    //   47: if_icmpge -35 -> 12
    //   50: aload_1
    //   51: aload 5
    //   53: iload_2
    //   54: invokeinterface 107 2 0
    //   59: if_acmpne +36 -> 95
    //   62: aload 4
    //   64: astore_3
    //   65: iload_2
    //   66: aload 5
    //   68: invokeinterface 38 1 0
    //   73: iconst_1
    //   74: isub
    //   75: if_icmpeq -63 -> 12
    //   78: aload 5
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: invokeinterface 107 2 0
    //   88: checkcast 54	com/tencent/halley/downloader/c/d/a
    //   91: astore_3
    //   92: goto -80 -> 12
    //   95: iload_2
    //   96: iconst_1
    //   97: iadd
    //   98: istore_2
    //   99: goto -63 -> 36
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	c
    //   0	107	1	parama	a
    //   35	64	2	k	int
    //   11	81	3	localObject1	Object
    //   1	62	4	localObject2	Object
    //   24	55	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   16	26	102	finally
    //   39	62	102	finally
    //   65	92	102	finally
  }
  
  public final void a(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (this.g == null)
        {
          this.g = new a(paramString, a.a.d);
          this.g.a(b.a(this.j).getAndIncrement());
        }
        else
        {
          this.g.a = paramString;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final void a(String paramString, a.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_2
    //   15: getstatic 71	com/tencent/halley/downloader/c/d/a$a:c	Lcom/tencent/halley/downloader/c/d/a$a;
    //   18: if_acmpne +69 -> 87
    //   21: aload_0
    //   22: getfield 73	com/tencent/halley/downloader/c/d/c:d	Ljava/util/List;
    //   25: ifnonnull +14 -> 39
    //   28: aload_0
    //   29: new 137	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 138	java/util/ArrayList:<init>	()V
    //   36: putfield 73	com/tencent/halley/downloader/c/d/c:d	Ljava/util/List;
    //   39: aload_0
    //   40: getfield 73	com/tencent/halley/downloader/c/d/c:d	Ljava/util/List;
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 42 1 0
    //   52: astore 5
    //   54: aload 5
    //   56: invokeinterface 48 1 0
    //   61: ifeq +162 -> 223
    //   64: aload_1
    //   65: aload 5
    //   67: invokeinterface 52 1 0
    //   72: checkcast 54	com/tencent/halley/downloader/c/d/a
    //   75: getfield 135	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   78: invokevirtual 144	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   81: ifeq -27 -> 54
    //   84: goto -73 -> 11
    //   87: aload_2
    //   88: getstatic 75	com/tencent/halley/downloader/c/d/a$a:e	Lcom/tencent/halley/downloader/c/d/a$a;
    //   91: if_acmpne +30 -> 121
    //   94: aload_0
    //   95: getfield 77	com/tencent/halley/downloader/c/d/c:a	Ljava/util/List;
    //   98: ifnonnull +14 -> 112
    //   101: aload_0
    //   102: new 137	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 138	java/util/ArrayList:<init>	()V
    //   109: putfield 77	com/tencent/halley/downloader/c/d/c:a	Ljava/util/List;
    //   112: aload_0
    //   113: getfield 77	com/tencent/halley/downloader/c/d/c:a	Ljava/util/List;
    //   116: astore 4
    //   118: goto -73 -> 45
    //   121: aload_2
    //   122: getstatic 79	com/tencent/halley/downloader/c/d/a$a:f	Lcom/tencent/halley/downloader/c/d/a$a;
    //   125: if_acmpne +30 -> 155
    //   128: aload_0
    //   129: getfield 81	com/tencent/halley/downloader/c/d/c:e	Ljava/util/List;
    //   132: ifnonnull +14 -> 146
    //   135: aload_0
    //   136: new 137	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 138	java/util/ArrayList:<init>	()V
    //   143: putfield 81	com/tencent/halley/downloader/c/d/c:e	Ljava/util/List;
    //   146: aload_0
    //   147: getfield 81	com/tencent/halley/downloader/c/d/c:e	Ljava/util/List;
    //   150: astore 4
    //   152: goto -107 -> 45
    //   155: aload_2
    //   156: getstatic 83	com/tencent/halley/downloader/c/d/a$a:j	Lcom/tencent/halley/downloader/c/d/a$a;
    //   159: if_acmpne +30 -> 189
    //   162: aload_0
    //   163: getfield 85	com/tencent/halley/downloader/c/d/c:f	Ljava/util/List;
    //   166: ifnonnull +14 -> 180
    //   169: aload_0
    //   170: new 137	java/util/ArrayList
    //   173: dup
    //   174: invokespecial 138	java/util/ArrayList:<init>	()V
    //   177: putfield 85	com/tencent/halley/downloader/c/d/c:f	Ljava/util/List;
    //   180: aload_0
    //   181: getfield 85	com/tencent/halley/downloader/c/d/c:f	Ljava/util/List;
    //   184: astore 4
    //   186: goto -141 -> 45
    //   189: aload_2
    //   190: getstatic 87	com/tencent/halley/downloader/c/d/a$a:h	Lcom/tencent/halley/downloader/c/d/a$a;
    //   193: if_acmpne -182 -> 11
    //   196: aload_0
    //   197: getfield 89	com/tencent/halley/downloader/c/d/c:h	Ljava/util/List;
    //   200: ifnonnull +14 -> 214
    //   203: aload_0
    //   204: new 137	java/util/ArrayList
    //   207: dup
    //   208: invokespecial 138	java/util/ArrayList:<init>	()V
    //   211: putfield 89	com/tencent/halley/downloader/c/d/c:h	Ljava/util/List;
    //   214: aload_0
    //   215: getfield 89	com/tencent/halley/downloader/c/d/c:h	Ljava/util/List;
    //   218: astore 4
    //   220: goto -175 -> 45
    //   223: new 54	com/tencent/halley/downloader/c/d/a
    //   226: dup
    //   227: aload_1
    //   228: aload_2
    //   229: invokespecial 120	com/tencent/halley/downloader/c/d/a:<init>	(Ljava/lang/String;Lcom/tencent/halley/downloader/c/d/a$a;)V
    //   232: astore_1
    //   233: aload_1
    //   234: aload_0
    //   235: getfield 23	com/tencent/halley/downloader/c/d/c:j	Lcom/tencent/halley/downloader/c/d/b;
    //   238: invokestatic 125	com/tencent/halley/downloader/c/d/b:a	(Lcom/tencent/halley/downloader/c/d/b;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   241: invokevirtual 130	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   244: invokevirtual 133	com/tencent/halley/downloader/c/d/a:a	(I)V
    //   247: aload 4
    //   249: aload_1
    //   250: invokeinterface 148 2 0
    //   255: pop
    //   256: goto -245 -> 11
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	c
    //   0	264	1	paramString	String
    //   0	264	2	parama	a.a
    //   6	2	3	bool	boolean
    //   43	205	4	localList	List
    //   52	14	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	7	259	finally
    //   14	39	259	finally
    //   39	45	259	finally
    //   45	54	259	finally
    //   54	84	259	finally
    //   87	112	259	finally
    //   112	118	259	finally
    //   121	146	259	finally
    //   146	152	259	finally
    //   155	180	259	finally
    //   180	186	259	finally
    //   189	214	259	finally
    //   214	220	259	finally
    //   223	256	259	finally
  }
  
  public final void b(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (this.i == null)
        {
          this.i = new a(paramString, a.a.i);
          this.i.a(b.a(this.j).getAndIncrement());
        }
        else
        {
          this.i.a = paramString;
        }
      }
      finally {}
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j.b(this.c));
    localStringBuilder.append(",");
    a(localStringBuilder, this.d);
    a(localStringBuilder, this.a);
    a(localStringBuilder, this.e);
    a(localStringBuilder, this.f);
    if (this.g != null) {
      localStringBuilder.append(this.g).append(",");
    }
    a(localStringBuilder, this.h);
    if (this.i != null) {
      localStringBuilder.append(this.i);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.d.c
 * JD-Core Version:    0.7.0.1
 */