package c.t.m.g;

public final class p
{
  private static final int[] c = { 31, 113, 239, 397, 439, 557, 619, 773, 853, 977 };
  public byte[] a = new byte[0];
  public byte[] b;
  private a[] d = new a[Math.min(Math.max(1, 5), 10)];
  
  public p()
  {
    this((byte)0);
  }
  
  public p(byte paramByte)
  {
    while (paramByte < this.d.length)
    {
      this.d[paramByte] = new a(c[paramByte]);
      paramByte += 1;
    }
    this.b = new byte[8192];
  }
  
  public final void a(String paramString)
  {
    synchronized (this.a)
    {
      a[] arrayOfa = this.d;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfa[i].a(paramString);
        byte[] arrayOfByte2 = this.b;
        int m = k / 8;
        arrayOfByte2[m] = ((byte)(1 << k % 8 | arrayOfByte2[m]));
        i += 1;
      }
      return;
    }
  }
  
  public final byte[] a()
  {
    synchronized (this.a)
    {
      byte[] arrayOfByte2 = this.b;
      return arrayOfByte2;
    }
  }
  
  /* Error */
  public final boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	c/t/m/g/p:a	[B
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull +8 -> 18
    //   13: aload 5
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 37	c/t/m/g/p:d	[Lc/t/m/g/p$a;
    //   22: astore 6
    //   24: aload 6
    //   26: arraylength
    //   27: istore 4
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: iload 4
    //   34: if_icmpge +60 -> 94
    //   37: aload 6
    //   39: iload_2
    //   40: aaload
    //   41: aload_1
    //   42: invokevirtual 46	c/t/m/g/p$a:a	(Ljava/lang/String;)I
    //   45: istore_3
    //   46: iconst_1
    //   47: iload_3
    //   48: bipush 8
    //   50: irem
    //   51: ishl
    //   52: aload_0
    //   53: getfield 42	c/t/m/g/p:b	[B
    //   56: iload_3
    //   57: bipush 8
    //   59: idiv
    //   60: baload
    //   61: iand
    //   62: ifeq +20 -> 82
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_3
    //   68: ifne +19 -> 87
    //   71: aload 5
    //   73: monitorexit
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_1
    //   77: aload 5
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: iconst_0
    //   83: istore_3
    //   84: goto -17 -> 67
    //   87: iload_2
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: goto -60 -> 31
    //   94: aload 5
    //   96: monitorexit
    //   97: iconst_1
    //   98: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	p
    //   0	99	1	paramString	String
    //   30	61	2	i	int
    //   45	39	3	j	int
    //   27	8	4	k	int
    //   4	91	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   13	16	76	finally
    //   18	29	76	finally
    //   37	65	76	finally
    //   71	74	76	finally
    //   77	80	76	finally
    //   94	97	76	finally
  }
  
  static final class a
  {
    private int a = 65536;
    private int b;
    
    public a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final int a(String paramString)
    {
      int i = 0;
      int k = paramString.length();
      int j = 0;
      while (i < k)
      {
        j = j * this.b + paramString.charAt(i);
        i += 1;
      }
      return this.a - 1 & j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.p
 * JD-Core Version:    0.7.0.1
 */