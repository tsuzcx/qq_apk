package com.tencent.tmassistantsdk.d;

import com.qq.taf.jce.JceStruct;
import org.apache.http.client.methods.HttpPost;

public abstract class b
{
  HttpPost a = null;
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 12	com/tencent/tmassistantsdk/d/b:a	Lorg/apache/http/client/methods/HttpPost;
    //   6: ifnull +51 -> 57
    //   9: aload_0
    //   10: getfield 12	com/tencent/tmassistantsdk/d/b:a	Lorg/apache/http/client/methods/HttpPost;
    //   13: invokevirtual 21	org/apache/http/client/methods/HttpPost:isAborted	()Z
    //   16: ifne +41 -> 57
    //   19: ldc 23
    //   21: new 25	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 27
    //   27: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: ldc 36
    //   36: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 49	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 12	com/tencent/tmassistantsdk/d/b:a	Lorg/apache/http/client/methods/HttpPost;
    //   49: invokevirtual 52	org/apache/http/client/methods/HttpPost:abort	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 12	com/tencent/tmassistantsdk/d/b:a	Lorg/apache/http/client/methods/HttpPost;
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 12	com/tencent/tmassistantsdk/d/b:a	Lorg/apache/http/client/methods/HttpPost;
    //   70: goto -13 -> 57
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 12	com/tencent/tmassistantsdk/d/b:a	Lorg/apache/http/client/methods/HttpPost;
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	b
    //   60	2	1	localException	java.lang.Exception
    //   73	4	1	localObject1	Object
    //   78	7	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	60	java/lang/Exception
    //   2	45	73	finally
    //   52	57	73	finally
    //   65	70	73	finally
    //   79	86	73	finally
    //   45	52	78	finally
    //   61	65	78	finally
  }
  
  protected abstract void a(JceStruct paramJceStruct, int paramInt);
  
  protected final boolean a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {}
    for (;;)
    {
      return false;
      try
      {
        if (this.a != null) {
          continue;
        }
        new Thread(new c(this, paramJceStruct)).start();
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.d.b
 * JD-Core Version:    0.7.0.1
 */