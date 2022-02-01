package okhttp3;

import com.tencent.token.fb;
import com.tencent.token.fe;
import com.tencent.token.fj;
import com.tencent.token.fk;
import com.tencent.token.fp;
import com.tencent.token.fs;
import com.tencent.token.gc;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.connection.a;

final class w
  implements e
{
  final v a;
  final fs b;
  final x c;
  final boolean d;
  private p e;
  private boolean f;
  
  private w(v paramv, x paramx, boolean paramBoolean)
  {
    this.a = paramv;
    this.c = paramx;
    this.d = paramBoolean;
    this.b = new fs(paramv, paramBoolean);
  }
  
  static w a(v paramv, x paramx, boolean paramBoolean)
  {
    paramx = new w(paramv, paramx, paramBoolean);
    paramx.e = paramv.y().a(paramx);
    return paramx;
  }
  
  private void f()
  {
    Object localObject = gc.c().a("response.body().close()");
    this.b.a(localObject);
  }
  
  public void a(f paramf)
  {
    try
    {
      if (!this.f)
      {
        this.f = true;
        f();
        this.e.a(this);
        this.a.t().a(new a(paramf));
        return;
      }
      throw new IllegalStateException("Already Executed");
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.b.a();
  }
  
  public w b()
  {
    return a(this.a, this.c, this.d);
  }
  
  String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (a()) {
      str = "canceled ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    if (this.d) {
      str = "web socket";
    } else {
      str = "call";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" to ");
    localStringBuilder.append(d());
    return localStringBuilder.toString();
  }
  
  String d()
  {
    return this.c.a().m();
  }
  
  z e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a.w());
    localArrayList.add(this.b);
    localArrayList.add(new fj(this.a.g()));
    localArrayList.add(new fe(this.a.h()));
    localArrayList.add(new a(this.a));
    if (!this.d) {
      localArrayList.addAll(this.a.x());
    }
    localArrayList.add(new fk(this.d));
    return new fp(localArrayList, null, null, null, 0, this.c, this, this.e, this.a.a(), this.a.b(), this.a.c()).a(this.c);
  }
  
  final class a
    extends fb
  {
    private final f c;
    
    a(f paramf)
    {
      super(new Object[] { w.this.d() });
      this.c = paramf;
    }
    
    String a()
    {
      return w.this.c.a().f();
    }
    
    w b()
    {
      return w.this;
    }
    
    /* Error */
    protected void c()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   6: invokevirtual 50	okhttp3/w:e	()Lokhttp3/z;
      //   9: astore_3
      //   10: aload_0
      //   11: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   14: getfield 53	okhttp3/w:b	Lcom/tencent/token/fs;
      //   17: invokevirtual 58	com/tencent/token/fs:a	()Z
      //   20: istore_2
      //   21: iload_2
      //   22: ifeq +28 -> 50
      //   25: aload_0
      //   26: getfield 27	okhttp3/w$a:c	Lokhttp3/f;
      //   29: aload_0
      //   30: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   33: new 46	java/io/IOException
      //   36: dup
      //   37: ldc 60
      //   39: invokespecial 63	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   42: invokeinterface 68 3 0
      //   47: goto +17 -> 64
      //   50: aload_0
      //   51: getfield 27	okhttp3/w$a:c	Lokhttp3/f;
      //   54: aload_0
      //   55: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   58: aload_3
      //   59: invokeinterface 71 3 0
      //   64: aload_0
      //   65: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   68: getfield 74	okhttp3/w:a	Lokhttp3/v;
      //   71: invokevirtual 80	okhttp3/v:t	()Lokhttp3/n;
      //   74: aload_0
      //   75: invokevirtual 85	okhttp3/n:b	(Lokhttp3/w$a;)V
      //   78: return
      //   79: astore_3
      //   80: goto +10 -> 90
      //   83: astore_3
      //   84: goto +92 -> 176
      //   87: astore_3
      //   88: iconst_0
      //   89: istore_1
      //   90: iload_1
      //   91: ifeq +53 -> 144
      //   94: invokestatic 90	com/tencent/token/gc:c	()Lcom/tencent/token/gc;
      //   97: astore 4
      //   99: new 92	java/lang/StringBuilder
      //   102: dup
      //   103: invokespecial 94	java/lang/StringBuilder:<init>	()V
      //   106: astore 5
      //   108: aload 5
      //   110: ldc 96
      //   112: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   115: pop
      //   116: aload 5
      //   118: aload_0
      //   119: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   122: invokevirtual 102	okhttp3/w:c	()Ljava/lang/String;
      //   125: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: pop
      //   129: aload 4
      //   131: iconst_4
      //   132: aload 5
      //   134: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   137: aload_3
      //   138: invokevirtual 108	com/tencent/token/gc:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   141: goto -77 -> 64
      //   144: aload_0
      //   145: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   148: invokestatic 111	okhttp3/w:a	(Lokhttp3/w;)Lokhttp3/p;
      //   151: aload_0
      //   152: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   155: aload_3
      //   156: invokevirtual 114	okhttp3/p:a	(Lokhttp3/e;Ljava/io/IOException;)V
      //   159: aload_0
      //   160: getfield 27	okhttp3/w$a:c	Lokhttp3/f;
      //   163: aload_0
      //   164: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   167: aload_3
      //   168: invokeinterface 68 3 0
      //   173: goto -109 -> 64
      //   176: aload_0
      //   177: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   180: getfield 74	okhttp3/w:a	Lokhttp3/v;
      //   183: invokevirtual 80	okhttp3/v:t	()Lokhttp3/n;
      //   186: aload_0
      //   187: invokevirtual 85	okhttp3/n:b	(Lokhttp3/w$a;)V
      //   190: aload_3
      //   191: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	192	0	this	a
      //   1	90	1	i	int
      //   20	2	2	bool	boolean
      //   9	50	3	localz	z
      //   79	1	3	localIOException1	java.io.IOException
      //   83	1	3	localObject	Object
      //   87	104	3	localIOException2	java.io.IOException
      //   97	33	4	localgc	gc
      //   106	27	5	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   25	47	79	java/io/IOException
      //   50	64	79	java/io/IOException
      //   2	21	83	finally
      //   25	47	83	finally
      //   50	64	83	finally
      //   94	141	83	finally
      //   144	173	83	finally
      //   2	21	87	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.w
 * JD-Core Version:    0.7.0.1
 */