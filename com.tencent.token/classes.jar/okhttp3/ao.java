package okhttp3;

import com.tencent.token.gm;

final class ao
  extends gm
{
  private final h c;
  
  ao(an paraman, h paramh)
  {
    super("OkHttp %s", new Object[] { paraman.d() });
    this.c = paramh;
  }
  
  String a()
  {
    return this.a.c.a().f();
  }
  
  an b()
  {
    return this.a;
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   6: invokevirtual 50	okhttp3/an:e	()Lokhttp3/at;
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   14: getfield 53	okhttp3/an:b	Lcom/tencent/token/hl;
    //   17: invokevirtual 58	com/tencent/token/hl:a	()Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +40 -> 62
    //   25: aload_0
    //   26: getfield 27	okhttp3/ao:c	Lokhttp3/h;
    //   29: aload_0
    //   30: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   33: new 46	java/io/IOException
    //   36: dup
    //   37: ldc 60
    //   39: invokespecial 63	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   42: invokeinterface 68 3 0
    //   47: aload_0
    //   48: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   51: getfield 71	okhttp3/an:a	Lokhttp3/ak;
    //   54: invokevirtual 77	okhttp3/ak:t	()Lokhttp3/v;
    //   57: aload_0
    //   58: invokevirtual 82	okhttp3/v:b	(Lokhttp3/ao;)V
    //   61: return
    //   62: aload_0
    //   63: getfield 27	okhttp3/ao:c	Lokhttp3/h;
    //   66: aload_0
    //   67: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   70: aload_3
    //   71: invokeinterface 85 3 0
    //   76: goto -29 -> 47
    //   79: astore_3
    //   80: iload_1
    //   81: ifeq +51 -> 132
    //   84: invokestatic 90	com/tencent/token/ih:c	()Lcom/tencent/token/ih;
    //   87: iconst_4
    //   88: new 92	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   95: ldc 96
    //   97: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_0
    //   101: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   104: invokevirtual 102	okhttp3/an:c	()Ljava/lang/String;
    //   107: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: aload_3
    //   114: invokevirtual 108	com/tencent/token/ih:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_0
    //   118: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   121: getfield 71	okhttp3/an:a	Lokhttp3/ak;
    //   124: invokevirtual 77	okhttp3/ak:t	()Lokhttp3/v;
    //   127: aload_0
    //   128: invokevirtual 82	okhttp3/v:b	(Lokhttp3/ao;)V
    //   131: return
    //   132: aload_0
    //   133: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   136: invokestatic 111	okhttp3/an:a	(Lokhttp3/an;)Lokhttp3/y;
    //   139: aload_0
    //   140: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   143: aload_3
    //   144: invokevirtual 114	okhttp3/y:a	(Lokhttp3/g;Ljava/io/IOException;)V
    //   147: aload_0
    //   148: getfield 27	okhttp3/ao:c	Lokhttp3/h;
    //   151: aload_0
    //   152: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   155: aload_3
    //   156: invokeinterface 68 3 0
    //   161: goto -44 -> 117
    //   164: astore_3
    //   165: aload_0
    //   166: getfield 12	okhttp3/ao:a	Lokhttp3/an;
    //   169: getfield 71	okhttp3/an:a	Lokhttp3/ak;
    //   172: invokevirtual 77	okhttp3/ak:t	()Lokhttp3/v;
    //   175: aload_0
    //   176: invokevirtual 82	okhttp3/v:b	(Lokhttp3/ao;)V
    //   179: aload_3
    //   180: athrow
    //   181: astore_3
    //   182: iconst_0
    //   183: istore_1
    //   184: goto -104 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	ao
    //   1	183	1	i	int
    //   20	2	2	bool	boolean
    //   9	62	3	localat	at
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ao
 * JD-Core Version:    0.7.0.1
 */