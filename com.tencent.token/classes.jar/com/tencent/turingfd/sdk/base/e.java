package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class e
{
  public static final cx<e> a = new a();
  public d b;
  public final AtomicBoolean c = new AtomicBoolean(false);
  
  public static e a()
  {
    return (e)a.b();
  }
  
  /* Error */
  public break a(int paramInt1, int paramInt2, int paramInt3, break parambreak1, break parambreak2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/turingfd/sdk/base/e:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 158	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +156 -> 165
    //   12: new 4	java/lang/Object
    //   15: dup
    //   16: invokespecial 29	java/lang/Object:<init>	()V
    //   19: astore 8
    //   21: new 160	java/util/concurrent/atomic/AtomicReference
    //   24: dup
    //   25: invokespecial 161	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   28: astore 9
    //   30: new 31	java/util/concurrent/atomic/AtomicBoolean
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial 34	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   38: astore 10
    //   40: aload 9
    //   42: aload 5
    //   44: invokevirtual 165	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   47: new 8	com/tencent/turingfd/sdk/base/e$b
    //   50: dup
    //   51: aload_0
    //   52: aload 10
    //   54: aload 9
    //   56: aload 8
    //   58: invokespecial 168	com/tencent/turingfd/sdk/base/e$b:<init>	(Lcom/tencent/turingfd/sdk/base/e;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   61: astore 11
    //   63: aload_0
    //   64: getfield 170	com/tencent/turingfd/sdk/base/e:b	Lcom/tencent/turingfd/sdk/base/e$d;
    //   67: astore 12
    //   69: new 172	com/tencent/turingfd/sdk/base/o$b
    //   72: dup
    //   73: iload_1
    //   74: iload_2
    //   75: iload_3
    //   76: invokespecial 175	com/tencent/turingfd/sdk/base/o$b:<init>	(III)V
    //   79: astore 13
    //   81: aload 13
    //   83: aload 4
    //   85: putfield 178	com/tencent/turingfd/sdk/base/o$b:d	Lcom/tencent/turingfd/sdk/base/break;
    //   88: aload 13
    //   90: aload 5
    //   92: putfield 181	com/tencent/turingfd/sdk/base/o$b:f	Lcom/tencent/turingfd/sdk/base/break;
    //   95: aload 13
    //   97: aload 11
    //   99: putfield 184	com/tencent/turingfd/sdk/base/o$b:a	Lcom/tencent/turingfd/sdk/base/o$c;
    //   102: aload 12
    //   104: iconst_2
    //   105: aload 13
    //   107: invokevirtual 187	com/tencent/turingfd/sdk/base/o$b:a	()Lcom/tencent/turingfd/sdk/base/o;
    //   110: invokestatic 193	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   113: invokevirtual 196	android/os/Message:sendToTarget	()V
    //   116: aload 8
    //   118: monitorenter
    //   119: aload 8
    //   121: lload 6
    //   123: invokevirtual 200	java/lang/Object:wait	(J)V
    //   126: aload 8
    //   128: monitorexit
    //   129: aload 10
    //   131: iconst_1
    //   132: invokevirtual 202	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   135: aload 9
    //   137: invokevirtual 204	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   140: checkcast 206	com/tencent/turingfd/sdk/base/break
    //   143: astore 4
    //   145: aload_0
    //   146: monitorexit
    //   147: aload 4
    //   149: areturn
    //   150: astore 4
    //   152: aload 8
    //   154: monitorexit
    //   155: aload 4
    //   157: athrow
    //   158: astore 4
    //   160: aload_0
    //   161: monitorexit
    //   162: aload 4
    //   164: athrow
    //   165: new 208	java/lang/RuntimeException
    //   168: dup
    //   169: ldc 210
    //   171: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    //   175: astore 4
    //   177: goto -51 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	e
    //   0	180	1	paramInt1	int
    //   0	180	2	paramInt2	int
    //   0	180	3	paramInt3	int
    //   0	180	4	parambreak1	break
    //   0	180	5	parambreak2	break
    //   0	180	6	paramLong	long
    //   19	134	8	localObject	Object
    //   28	108	9	localAtomicReference	AtomicReference
    //   38	92	10	localAtomicBoolean	AtomicBoolean
    //   61	37	11	localb	b
    //   67	36	12	locald	d
    //   79	27	13	localb1	o.b
    // Exception table:
    //   from	to	target	type
    //   119	126	150	finally
    //   126	129	150	finally
    //   152	155	150	finally
    //   2	119	158	finally
    //   129	145	158	finally
    //   155	158	158	finally
    //   165	175	158	finally
    //   119	126	175	java/lang/InterruptedException
  }
  
  public void a(ck paramck)
  {
    if (paramck == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!this.c.compareAndSet(false, true)) {
          continue;
        }
        HandlerThread localHandlerThread = new HandlerThread("TuringFdShark");
        localHandlerThread.start();
        this.b = new d(localHandlerThread.getLooper(), paramck);
        Message.obtain(this.b, 1).sendToTarget();
      }
      finally {}
    }
  }
  
  /* Error */
  public byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/turingfd/sdk/base/e:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 158	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +150 -> 159
    //   12: new 4	java/lang/Object
    //   15: dup
    //   16: invokespecial 29	java/lang/Object:<init>	()V
    //   19: astore 7
    //   21: new 160	java/util/concurrent/atomic/AtomicReference
    //   24: dup
    //   25: invokespecial 161	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   28: astore 8
    //   30: new 31	java/util/concurrent/atomic/AtomicBoolean
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial 34	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   38: astore 9
    //   40: aload 8
    //   42: iconst_0
    //   43: newarray byte
    //   45: invokevirtual 165	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   48: new 10	com/tencent/turingfd/sdk/base/e$c
    //   51: dup
    //   52: aload_0
    //   53: aload 9
    //   55: aload 8
    //   57: aload 7
    //   59: invokespecial 238	com/tencent/turingfd/sdk/base/e$c:<init>	(Lcom/tencent/turingfd/sdk/base/e;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   62: astore 10
    //   64: aload_0
    //   65: getfield 170	com/tencent/turingfd/sdk/base/e:b	Lcom/tencent/turingfd/sdk/base/e$d;
    //   68: astore 11
    //   70: new 172	com/tencent/turingfd/sdk/base/o$b
    //   73: dup
    //   74: iload_1
    //   75: iload_2
    //   76: iload_3
    //   77: invokespecial 175	com/tencent/turingfd/sdk/base/o$b:<init>	(III)V
    //   80: astore 12
    //   82: aload 12
    //   84: aload 4
    //   86: putfield 241	com/tencent/turingfd/sdk/base/o$b:e	[B
    //   89: aload 12
    //   91: aload 10
    //   93: putfield 184	com/tencent/turingfd/sdk/base/o$b:a	Lcom/tencent/turingfd/sdk/base/o$c;
    //   96: aload 11
    //   98: iconst_2
    //   99: aload 12
    //   101: invokevirtual 187	com/tencent/turingfd/sdk/base/o$b:a	()Lcom/tencent/turingfd/sdk/base/o;
    //   104: invokestatic 193	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   107: invokevirtual 196	android/os/Message:sendToTarget	()V
    //   110: aload 7
    //   112: monitorenter
    //   113: aload 7
    //   115: lload 5
    //   117: invokevirtual 200	java/lang/Object:wait	(J)V
    //   120: aload 7
    //   122: monitorexit
    //   123: aload 9
    //   125: iconst_1
    //   126: invokevirtual 202	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   129: aload 8
    //   131: invokevirtual 204	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   134: checkcast 242	[B
    //   137: astore 4
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 4
    //   143: areturn
    //   144: astore 4
    //   146: aload 7
    //   148: monitorexit
    //   149: aload 4
    //   151: athrow
    //   152: astore 4
    //   154: aload_0
    //   155: monitorexit
    //   156: aload 4
    //   158: athrow
    //   159: new 208	java/lang/RuntimeException
    //   162: dup
    //   163: ldc 210
    //   165: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: astore 4
    //   171: goto -51 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	e
    //   0	174	1	paramInt1	int
    //   0	174	2	paramInt2	int
    //   0	174	3	paramInt3	int
    //   0	174	4	paramArrayOfByte	byte[]
    //   0	174	5	paramLong	long
    //   19	128	7	localObject	Object
    //   28	102	8	localAtomicReference	AtomicReference
    //   38	86	9	localAtomicBoolean	AtomicBoolean
    //   62	30	10	localc	c
    //   68	29	11	locald	d
    //   80	20	12	localb	o.b
    // Exception table:
    //   from	to	target	type
    //   113	120	144	finally
    //   120	123	144	finally
    //   146	149	144	finally
    //   2	113	152	finally
    //   123	139	152	finally
    //   149	152	152	finally
    //   159	169	152	finally
    //   113	120	169	java/lang/InterruptedException
  }
  
  public static final class a
    extends cx<e>
  {
    public Object a()
    {
      return new e(null);
    }
  }
  
  public class b
    implements o.c
  {
    public b(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
    
    public void a(int paramInt, break arg2)
    {
      if (localAtomicBoolean.get()) {
        return;
      }
      if ((paramInt == 0) && (??? != null)) {
        localAtomicReference.set(???);
      }
      synchronized (localObject)
      {
        localObject.notify();
        return;
      }
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte) {}
  }
  
  public class c
    implements o.c
  {
    public c(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
    
    public void a(int paramInt, break parambreak) {}
    
    public void a(int paramInt, byte[] arg2)
    {
      if (localAtomicBoolean.get()) {
        return;
      }
      if ((paramInt == 0) && (??? != null)) {
        localAtomicReference.set(???);
      }
      synchronized (localObject)
      {
        localObject.notify();
        return;
      }
    }
  }
  
  private static class d
    extends Handler
  {
    public int a = 1;
    public do b = new do();
    public d c;
    public ck d;
    
    public d(Looper paramLooper, ck paramck)
    {
      super();
      this.b.B = 49;
      this.c = new d();
      this.d = paramck;
    }
    
    public final String a(Context paramContext)
    {
      System.currentTimeMillis();
      paramContext = b.a(paramContext);
      paramContext = cm.a(a(cm.a(), paramContext), paramContext.g, false);
      if ((paramContext instanceof try)) {
        return ((try)paramContext).u;
      }
      return "";
    }
    
    public final boolean a()
    {
      System.currentTimeMillis();
      Object localObject = this.c.a();
      localObject = cm.a(a(cm.a(), (o)localObject), ((o)localObject).g, false);
      if ((localObject instanceof synchronized))
      {
        localObject = (synchronized)localObject;
        this.c.a((synchronized)localObject);
        return true;
      }
      return false;
    }
    
    public final byte[] a(Context paramContext, o paramo)
    {
      int i = paramo.a;
      Object localObject1 = paramo.f;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.c;
        if (!TextUtils.isEmpty(((d)localObject2).a)) {
          break label157;
        }
        localObject2 = ((d)localObject2).e;
        label40:
        localObject2 = e.a(i, (byte[])localObject1, (String)localObject2);
        do localdo = this.b;
        if (paramo.a != 152) {
          break label167;
        }
        localObject1 = "";
        label70:
        localdo.A = ((String)localObject1);
        this.b.u = b.b(paramContext);
        paramContext = cm.a(e.a(this.a, (int)localObject2, this.b));
        localObject1 = this.d;
        if (localObject1 != null) {
          break label179;
        }
        paramContext = new byte[0];
        label120:
        paramContext = cm.a(paramContext, new char(), false);
        if (paramContext != null) {
          break label229;
        }
      }
      label157:
      label167:
      label179:
      label229:
      for (paramContext = null;; paramContext = (char)paramContext)
      {
        for (;;)
        {
          if (paramContext != null) {
            break label237;
          }
          return null;
          localObject1 = cm.a(paramo.e);
          break;
          localObject2 = ((d)localObject2).b;
          break label40;
          localObject1 = this.c.a;
          break label70;
          try
          {
            i = paramo.c;
            int j = paramo.a;
            int k = paramo.b;
            localObject1 = (cr)localObject1;
            paramContext = ((cr)localObject1).a(i, paramContext, j, k).a;
          }
          catch (Throwable paramContext)
          {
            paramContext = new byte[0];
          }
        }
        break label120;
      }
      label237:
      i = this.a;
      this.a = (i + 1);
      if (i >= 2147483647) {
        this.a = 1;
      }
      paramo = e.a(paramo.b, paramContext);
      if (paramo == null) {
        return null;
      }
      if (paramo.cb == 2)
      {
        this.c.c = 0L;
        return null;
      }
      paramContext = this.c;
      if (TextUtils.isEmpty(paramContext.a)) {}
      for (paramContext = paramContext.e;; paramContext = paramContext.b) {
        return e.a(paramo, paramContext);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1) {
        if (i == 2) {}
      }
      do
      {
        do
        {
          return;
          paramMessage = (o)paramMessage.obj;
          Object localObject1 = paramMessage.d;
          if ((this.c.b()) && (!a()))
          {
            ((o.c)localObject1).a(-1, null);
            return;
          }
          Object localObject2 = cm.a();
          if (TextUtils.isEmpty(b.b((Context)localObject2)))
          {
            b.a((Context)localObject2, a((Context)localObject2));
            if (TextUtils.isEmpty(b.b((Context)localObject2)))
            {
              ((o.c)localObject1).a(-2, null);
              return;
            }
          }
          localObject1 = a((Context)localObject2, paramMessage);
          localObject2 = paramMessage.g;
          if (localObject2 != null)
          {
            localObject1 = cm.a((byte[])localObject1, (break)localObject2, false);
            if (localObject1 == null)
            {
              paramMessage.d.a(-3, null);
              return;
            }
            paramMessage.d.a(0, (break)localObject1);
            return;
          }
          if (localObject1 == null)
          {
            paramMessage.d.a(-3, null);
            return;
          }
          paramMessage.d.a(0, (byte[])localObject1);
          return;
          System.currentTimeMillis();
        } while (!a());
        paramMessage = cm.a();
      } while (!TextUtils.isEmpty(b.b(paramMessage)));
      b.a(paramMessage, a(paramMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.e
 * JD-Core Version:    0.7.0.1
 */