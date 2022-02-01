package okhttp3;

import com.tencent.token.fa;
import com.tencent.token.fd;
import com.tencent.token.fi;
import com.tencent.token.fj;
import com.tencent.token.fo;
import com.tencent.token.fr;
import com.tencent.token.gb;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.connection.a;

final class w
  implements e
{
  final v a;
  final fr b;
  final x c;
  final boolean d;
  private p e;
  private boolean f;
  
  private w(v paramv, x paramx, boolean paramBoolean)
  {
    this.a = paramv;
    this.c = paramx;
    this.d = paramBoolean;
    this.b = new fr(paramv, paramBoolean);
  }
  
  static w a(v paramv, x paramx, boolean paramBoolean)
  {
    paramx = new w(paramv, paramx, paramBoolean);
    paramx.e = paramv.y().a(paramx);
    return paramx;
  }
  
  private void f()
  {
    Object localObject = gb.c().a("response.body().close()");
    this.b.a(localObject);
  }
  
  public void a(f paramf)
  {
    try
    {
      if (this.f) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.f = true;
    f();
    this.e.a(this);
    this.a.t().a(new a(paramf));
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
    if (a())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.d) {
        break label61;
      }
    }
    label61:
    for (String str = "web socket";; str = "call")
    {
      return str + " to " + d();
      str = "";
      break;
    }
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
    localArrayList.add(new fi(this.a.g()));
    localArrayList.add(new fd(this.a.h()));
    localArrayList.add(new a(this.a));
    if (!this.d) {
      localArrayList.addAll(this.a.x());
    }
    localArrayList.add(new fj(this.d));
    return new fo(localArrayList, null, null, null, 0, this.c, this, this.e, this.a.a(), this.a.b(), this.a.c()).a(this.c);
  }
  
  final class a
    extends fa
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
      //   14: getfield 53	okhttp3/w:b	Lcom/tencent/token/fr;
      //   17: invokevirtual 58	com/tencent/token/fr:a	()Z
      //   20: istore_2
      //   21: iload_2
      //   22: ifeq +40 -> 62
      //   25: aload_0
      //   26: getfield 27	okhttp3/w$a:c	Lokhttp3/f;
      //   29: aload_0
      //   30: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   33: new 46	java/io/IOException
      //   36: dup
      //   37: ldc 60
      //   39: invokespecial 63	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   42: invokeinterface 68 3 0
      //   47: aload_0
      //   48: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   51: getfield 71	okhttp3/w:a	Lokhttp3/v;
      //   54: invokevirtual 77	okhttp3/v:t	()Lokhttp3/n;
      //   57: aload_0
      //   58: invokevirtual 82	okhttp3/n:b	(Lokhttp3/w$a;)V
      //   61: return
      //   62: aload_0
      //   63: getfield 27	okhttp3/w$a:c	Lokhttp3/f;
      //   66: aload_0
      //   67: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   70: aload_3
      //   71: invokeinterface 85 3 0
      //   76: goto -29 -> 47
      //   79: astore_3
      //   80: iload_1
      //   81: ifeq +51 -> 132
      //   84: invokestatic 90	com/tencent/token/gb:c	()Lcom/tencent/token/gb;
      //   87: iconst_4
      //   88: new 92	java/lang/StringBuilder
      //   91: dup
      //   92: invokespecial 94	java/lang/StringBuilder:<init>	()V
      //   95: ldc 96
      //   97: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: aload_0
      //   101: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   104: invokevirtual 102	okhttp3/w:c	()Ljava/lang/String;
      //   107: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   110: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   113: aload_3
      //   114: invokevirtual 108	com/tencent/token/gb:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   117: aload_0
      //   118: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   121: getfield 71	okhttp3/w:a	Lokhttp3/v;
      //   124: invokevirtual 77	okhttp3/v:t	()Lokhttp3/n;
      //   127: aload_0
      //   128: invokevirtual 82	okhttp3/n:b	(Lokhttp3/w$a;)V
      //   131: return
      //   132: aload_0
      //   133: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   136: invokestatic 111	okhttp3/w:a	(Lokhttp3/w;)Lokhttp3/p;
      //   139: aload_0
      //   140: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   143: aload_3
      //   144: invokevirtual 114	okhttp3/p:a	(Lokhttp3/e;Ljava/io/IOException;)V
      //   147: aload_0
      //   148: getfield 27	okhttp3/w$a:c	Lokhttp3/f;
      //   151: aload_0
      //   152: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   155: aload_3
      //   156: invokeinterface 68 3 0
      //   161: goto -44 -> 117
      //   164: astore_3
      //   165: aload_0
      //   166: getfield 14	okhttp3/w$a:a	Lokhttp3/w;
      //   169: getfield 71	okhttp3/w:a	Lokhttp3/v;
      //   172: invokevirtual 77	okhttp3/v:t	()Lokhttp3/n;
      //   175: aload_0
      //   176: invokevirtual 82	okhttp3/n:b	(Lokhttp3/w$a;)V
      //   179: aload_3
      //   180: athrow
      //   181: astore_3
      //   182: iconst_0
      //   183: istore_1
      //   184: goto -104 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	187	0	this	a
      //   1	183	1	i	int
      //   20	2	2	bool	boolean
      //   9	62	3	localz	z
      //   79	77	3	localIOException1	java.io.IOException
      //   164	16	3	localObject	Object
      //   181	1	3	localIOException2	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   25	47	79	java/io/IOException
      //   62	76	79	java/io/IOException
      //   2	21	164	finally
      //   25	47	164	finally
      //   62	76	164	finally
      //   84	117	164	finally
      //   132	161	164	finally
      //   2	21	181	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.w
 * JD-Core Version:    0.7.0.1
 */