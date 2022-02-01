package com.b.a;

import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public final class c
  extends Thread
{
  private static final boolean a = u.a;
  private final BlockingQueue<m<?>> b;
  private final BlockingQueue<m<?>> c;
  private final b d;
  private final p e;
  private volatile boolean f = false;
  private final a g;
  
  public c(BlockingQueue<m<?>> paramBlockingQueue1, BlockingQueue<m<?>> paramBlockingQueue2, b paramb, p paramp)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramb;
    this.e = paramp;
    this.g = new a(this);
  }
  
  public final void a()
  {
    this.f = true;
    interrupt();
  }
  
  public final void run()
  {
    if (a) {
      u.a("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.d.a();
    label73:
    b.a locala;
    for (;;)
    {
      try
      {
        m localm = (m)this.b.take();
        localm.a("cache-queue-take");
        if (!localm.f()) {
          break label73;
        }
        localm.b("cache-discard-canceled");
        continue;
        if (!this.f) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      locala = this.d.a(localInterruptedException.d());
      if (locala == null)
      {
        localInterruptedException.a("cache-miss");
        if (!a.a(this.g, localInterruptedException)) {
          this.c.put(localInterruptedException);
        }
      }
      else
      {
        if (!locala.a()) {
          break;
        }
        localInterruptedException.a("cache-hit-expired");
        localInterruptedException.a(locala);
        if (!a.a(this.g, localInterruptedException)) {
          this.c.put(localInterruptedException);
        }
      }
    }
    localInterruptedException.a("cache-hit");
    o localo = localInterruptedException.a(new j(locala.a, locala.g));
    localInterruptedException.a("cache-hit-parsed");
    if (locala.f < System.currentTimeMillis()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.e.a(localInterruptedException, localo);
        break;
      }
      localInterruptedException.a("cache-hit-refresh-needed");
      localInterruptedException.a(locala);
      localo.d = true;
      if (!a.a(this.g, localInterruptedException))
      {
        this.e.a(localInterruptedException, localo, new c.1(this, localInterruptedException));
        break;
      }
      this.e.a(localInterruptedException, localo);
      break;
    }
  }
  
  static final class a
    implements m.a
  {
    private final Map<String, List<m<?>>> a = new HashMap();
    private final c b;
    
    a(c paramc)
    {
      this.b = paramc;
    }
    
    /* Error */
    private boolean b(m<?> paramm)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_1
      //   5: invokevirtual 36	com/b/a/m:d	()Ljava/lang/String;
      //   8: astore 6
      //   10: aload_0
      //   11: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   14: aload 6
      //   16: invokeinterface 42 2 0
      //   21: ifeq +92 -> 113
      //   24: aload_0
      //   25: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   28: aload 6
      //   30: invokeinterface 46 2 0
      //   35: checkcast 48	java/util/List
      //   38: astore 5
      //   40: aload 5
      //   42: astore 4
      //   44: aload 5
      //   46: ifnonnull +12 -> 58
      //   49: new 50	java/util/ArrayList
      //   52: dup
      //   53: invokespecial 51	java/util/ArrayList:<init>	()V
      //   56: astore 4
      //   58: aload_1
      //   59: ldc 53
      //   61: invokevirtual 56	com/b/a/m:a	(Ljava/lang/String;)V
      //   64: aload 4
      //   66: aload_1
      //   67: invokeinterface 59 2 0
      //   72: pop
      //   73: aload_0
      //   74: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   77: aload 6
      //   79: aload 4
      //   81: invokeinterface 63 3 0
      //   86: pop
      //   87: getstatic 68	com/b/a/u:a	Z
      //   90: ifeq +17 -> 107
      //   93: ldc 70
      //   95: iconst_1
      //   96: anewarray 4	java/lang/Object
      //   99: dup
      //   100: iconst_0
      //   101: aload 6
      //   103: aastore
      //   104: invokestatic 73	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   107: iconst_1
      //   108: istore_2
      //   109: aload_0
      //   110: monitorexit
      //   111: iload_2
      //   112: ireturn
      //   113: aload_0
      //   114: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   117: aload 6
      //   119: aconst_null
      //   120: invokeinterface 63 3 0
      //   125: pop
      //   126: aload_1
      //   127: aload_0
      //   128: invokevirtual 76	com/b/a/m:a	(Lcom/b/a/m$a;)V
      //   131: iload_3
      //   132: istore_2
      //   133: getstatic 68	com/b/a/u:a	Z
      //   136: ifeq -27 -> 109
      //   139: ldc 78
      //   141: iconst_1
      //   142: anewarray 4	java/lang/Object
      //   145: dup
      //   146: iconst_0
      //   147: aload 6
      //   149: aastore
      //   150: invokestatic 73	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   153: iload_3
      //   154: istore_2
      //   155: goto -46 -> 109
      //   158: astore_1
      //   159: aload_0
      //   160: monitorexit
      //   161: aload_1
      //   162: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	this	a
      //   0	163	1	paramm	m<?>
      //   108	47	2	bool1	boolean
      //   1	153	3	bool2	boolean
      //   42	38	4	localObject	Object
      //   38	7	5	localList	List
      //   8	140	6	str	String
      // Exception table:
      //   from	to	target	type
      //   4	40	158	finally
      //   49	58	158	finally
      //   58	107	158	finally
      //   113	131	158	finally
      //   133	153	158	finally
    }
    
    /* Error */
    public final void a(m<?> paramm)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokevirtual 36	com/b/a/m:d	()Ljava/lang/String;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   11: aload_1
      //   12: invokeinterface 86 2 0
      //   17: checkcast 48	java/util/List
      //   20: astore_2
      //   21: aload_2
      //   22: ifnull +79 -> 101
      //   25: aload_2
      //   26: invokeinterface 90 1 0
      //   31: ifne +70 -> 101
      //   34: getstatic 68	com/b/a/u:a	Z
      //   37: ifeq +28 -> 65
      //   40: ldc 92
      //   42: iconst_2
      //   43: anewarray 4	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: aload_2
      //   49: invokeinterface 96 1 0
      //   54: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   57: aastore
      //   58: dup
      //   59: iconst_1
      //   60: aload_1
      //   61: aastore
      //   62: invokestatic 104	com/b/a/u:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   65: aload_2
      //   66: iconst_0
      //   67: invokeinterface 107 2 0
      //   72: checkcast 32	com/b/a/m
      //   75: astore_3
      //   76: aload_0
      //   77: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   80: aload_1
      //   81: aload_2
      //   82: invokeinterface 63 3 0
      //   87: pop
      //   88: aload_0
      //   89: getfield 25	com/b/a/c$a:b	Lcom/b/a/c;
      //   92: invokestatic 110	com/b/a/c:a	(Lcom/b/a/c;)Ljava/util/concurrent/BlockingQueue;
      //   95: aload_3
      //   96: invokeinterface 115 2 0
      //   101: aload_0
      //   102: monitorexit
      //   103: return
      //   104: astore_1
      //   105: ldc 117
      //   107: iconst_1
      //   108: anewarray 4	java/lang/Object
      //   111: dup
      //   112: iconst_0
      //   113: aload_1
      //   114: invokevirtual 120	java/lang/InterruptedException:toString	()Ljava/lang/String;
      //   117: aastore
      //   118: invokestatic 123	com/b/a/u:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   121: invokestatic 129	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   124: invokevirtual 132	java/lang/Thread:interrupt	()V
      //   127: aload_0
      //   128: getfield 25	com/b/a/c$a:b	Lcom/b/a/c;
      //   131: invokevirtual 134	com/b/a/c:a	()V
      //   134: goto -33 -> 101
      //   137: astore_1
      //   138: aload_0
      //   139: monitorexit
      //   140: aload_1
      //   141: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	142	0	this	a
      //   0	142	1	paramm	m<?>
      //   20	62	2	localList	List
      //   75	21	3	localm	m
      // Exception table:
      //   from	to	target	type
      //   88	101	104	java/lang/InterruptedException
      //   2	21	137	finally
      //   25	65	137	finally
      //   65	88	137	finally
      //   88	101	137	finally
      //   105	134	137	finally
    }
    
    /* Error */
    public final void a(m<?> paramm, o<?> paramo)
    {
      // Byte code:
      //   0: aload_2
      //   1: getfield 141	com/b/a/o:b	Lcom/b/a/b$a;
      //   4: ifnull +13 -> 17
      //   7: aload_2
      //   8: getfield 141	com/b/a/o:b	Lcom/b/a/b$a;
      //   11: invokevirtual 145	com/b/a/b$a:a	()Z
      //   14: ifeq +9 -> 23
      //   17: aload_0
      //   18: aload_1
      //   19: invokevirtual 147	com/b/a/c$a:a	(Lcom/b/a/m;)V
      //   22: return
      //   23: aload_1
      //   24: invokevirtual 36	com/b/a/m:d	()Ljava/lang/String;
      //   27: astore_1
      //   28: aload_0
      //   29: monitorenter
      //   30: aload_0
      //   31: getfield 23	com/b/a/c$a:a	Ljava/util/Map;
      //   34: aload_1
      //   35: invokeinterface 86 2 0
      //   40: checkcast 48	java/util/List
      //   43: astore_3
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_3
      //   47: ifnull -25 -> 22
      //   50: getstatic 68	com/b/a/u:a	Z
      //   53: ifeq +28 -> 81
      //   56: ldc 149
      //   58: iconst_2
      //   59: anewarray 4	java/lang/Object
      //   62: dup
      //   63: iconst_0
      //   64: aload_3
      //   65: invokeinterface 96 1 0
      //   70: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   73: aastore
      //   74: dup
      //   75: iconst_1
      //   76: aload_1
      //   77: aastore
      //   78: invokestatic 104	com/b/a/u:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   81: aload_3
      //   82: invokeinterface 153 1 0
      //   87: astore_1
      //   88: aload_1
      //   89: invokeinterface 158 1 0
      //   94: ifeq -72 -> 22
      //   97: aload_1
      //   98: invokeinterface 162 1 0
      //   103: checkcast 32	com/b/a/m
      //   106: astore_3
      //   107: aload_0
      //   108: getfield 25	com/b/a/c$a:b	Lcom/b/a/c;
      //   111: invokestatic 165	com/b/a/c:b	(Lcom/b/a/c;)Lcom/b/a/p;
      //   114: aload_3
      //   115: aload_2
      //   116: invokevirtual 169	com/b/a/p:a	(Lcom/b/a/m;Lcom/b/a/o;)V
      //   119: goto -31 -> 88
      //   122: astore_1
      //   123: aload_0
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	127	0	this	a
      //   0	127	1	paramm	m<?>
      //   0	127	2	paramo	o<?>
      //   43	72	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   30	46	122	finally
      //   123	125	122	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.c
 * JD-Core Version:    0.7.0.1
 */