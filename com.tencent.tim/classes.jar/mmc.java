import java.util.ArrayList;
import java.util.List;

public class mmc<C, T, A>
  implements Cloneable
{
  private long[] O;
  private final mmc.a<C, T, A> a;
  private int aTG;
  private List<C> mCallbacks = new ArrayList();
  private long wg = 0L;
  
  public mmc(mmc.a<C, T, A> parama)
  {
    this.a = parama;
  }
  
  private void N(int paramInt, long paramLong)
  {
    long l = -9223372036854775808L;
    int i = paramInt + 64 - 1;
    while (i >= paramInt)
    {
      if ((paramLong & l) != 0L) {
        this.mCallbacks.remove(i);
      }
      l >>>= 1;
      i -= 1;
    }
  }
  
  private void a(T paramT, int paramInt1, A paramA, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      b(paramT, paramInt1, paramA);
      return;
    }
    long l = this.O[paramInt2];
    int i = (paramInt2 + 1) * 64;
    int j = Math.min(this.mCallbacks.size(), i + 64);
    a(paramT, paramInt1, paramA, paramInt2 - 1);
    a(paramT, paramInt1, paramA, i, j, l);
  }
  
  private void a(T paramT, int paramInt1, A paramA, int paramInt2, int paramInt3, long paramLong)
  {
    long l = 1L;
    while (paramInt2 < paramInt3)
    {
      if ((paramLong & l) == 0L) {
        this.a.a(this.mCallbacks.get(paramInt2), paramT, paramInt1, paramA);
      }
      l <<= 1;
      paramInt2 += 1;
    }
  }
  
  private void b(T paramT, int paramInt, A paramA)
  {
    a(paramT, paramInt, paramA, 0, Math.min(64, this.mCallbacks.size()), this.wg);
  }
  
  private void c(T paramT, int paramInt, A paramA)
  {
    int j = this.mCallbacks.size();
    if (this.O == null) {}
    for (int i = -1;; i = this.O.length - 1)
    {
      a(paramT, paramInt, paramA, i);
      a(paramT, paramInt, paramA, (i + 2) * 64, j, 0L);
      return;
    }
  }
  
  private boolean dS(int paramInt)
  {
    if (paramInt < 64) {
      if ((1L << paramInt & this.wg) == 0L) {}
    }
    int i;
    do
    {
      return true;
      return false;
      if (this.O == null) {
        return false;
      }
      i = paramInt / 64 - 1;
      if (i >= this.O.length) {
        return false;
      }
    } while ((this.O[i] & 1L << paramInt % 64) != 0L);
    return false;
  }
  
  private void rZ(int paramInt)
  {
    if (paramInt < 64)
    {
      this.wg = (1L << paramInt | this.wg);
      return;
    }
    int i = paramInt / 64 - 1;
    if (this.O == null) {
      this.O = new long[this.mCallbacks.size() / 64];
    }
    for (;;)
    {
      long[] arrayOfLong = this.O;
      arrayOfLong[i] = (1L << paramInt % 64 | arrayOfLong[i]);
      return;
      if (this.O.length < i)
      {
        arrayOfLong = new long[this.mCallbacks.size() / 64];
        System.arraycopy(this.O, 0, arrayOfLong, 0, this.O.length);
        this.O = arrayOfLong;
      }
    }
  }
  
  /* Error */
  public mmc<C, T, A> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 97	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	mmc
    //   9: astore_3
    //   10: aload_3
    //   11: lconst_0
    //   12: putfield 33	mmc:wg	J
    //   15: aload_3
    //   16: aconst_null
    //   17: putfield 55	mmc:O	[J
    //   20: aload_3
    //   21: iconst_0
    //   22: putfield 99	mmc:aTG	I
    //   25: aload_3
    //   26: new 28	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 29	java/util/ArrayList:<init>	()V
    //   33: putfield 31	mmc:mCallbacks	Ljava/util/List;
    //   36: aload_0
    //   37: getfield 31	mmc:mCallbacks	Ljava/util/List;
    //   40: invokeinterface 59 1 0
    //   45: istore_2
    //   46: iconst_0
    //   47: istore_1
    //   48: aload_3
    //   49: astore 4
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +50 -> 103
    //   56: aload_0
    //   57: iload_1
    //   58: invokespecial 101	mmc:dS	(I)Z
    //   61: ifne +23 -> 84
    //   64: aload_3
    //   65: getfield 31	mmc:mCallbacks	Ljava/util/List;
    //   68: aload_0
    //   69: getfield 31	mmc:mCallbacks	Ljava/util/List;
    //   72: iload_1
    //   73: invokeinterface 74 2 0
    //   78: invokeinterface 105 2 0
    //   83: pop
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -40 -> 48
    //   91: astore 4
    //   93: aconst_null
    //   94: astore_3
    //   95: aload 4
    //   97: invokevirtual 108	java/lang/CloneNotSupportedException:printStackTrace	()V
    //   100: aload_3
    //   101: astore 4
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 4
    //   107: areturn
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: athrow
    //   113: astore 4
    //   115: goto -20 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	mmc
    //   47	41	1	i	int
    //   45	9	2	j	int
    //   9	92	3	localmmc1	mmc
    //   108	4	3	localObject	Object
    //   49	1	4	localmmc2	mmc
    //   91	5	4	localCloneNotSupportedException1	java.lang.CloneNotSupportedException
    //   101	5	4	localmmc3	mmc
    //   113	1	4	localCloneNotSupportedException2	java.lang.CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   2	10	91	java/lang/CloneNotSupportedException
    //   2	10	108	finally
    //   10	46	108	finally
    //   56	84	108	finally
    //   95	100	108	finally
    //   10	46	113	java/lang/CloneNotSupportedException
    //   56	84	113	java/lang/CloneNotSupportedException
  }
  
  public void a(T paramT, int paramInt, A paramA)
  {
    for (;;)
    {
      try
      {
        this.aTG += 1;
        c(paramT, paramInt, paramA);
        this.aTG -= 1;
        if (this.aTG == 0)
        {
          if (this.O != null)
          {
            paramInt = this.O.length - 1;
            if (paramInt >= 0)
            {
              long l = this.O[paramInt];
              if (l == 0L) {
                break label123;
              }
              N((paramInt + 1) * 64, l);
              this.O[paramInt] = 0L;
              break label123;
            }
          }
          if (this.wg != 0L)
          {
            N(0, this.wg);
            this.wg = 0L;
          }
        }
        return;
      }
      finally {}
      label123:
      paramInt -= 1;
    }
  }
  
  public void add(C paramC)
  {
    if (paramC == null) {
      try
      {
        throw new IllegalArgumentException("callback cannot be null");
      }
      finally {}
    }
    int i = this.mCallbacks.lastIndexOf(paramC);
    if ((i < 0) || (dS(i))) {
      this.mCallbacks.add(paramC);
    }
  }
  
  /* Error */
  public void remove(C paramC)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	mmc:aTG	I
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: getfield 31	mmc:mCallbacks	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 131 2 0
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 31	mmc:mCallbacks	Ljava/util/List;
    //   27: aload_1
    //   28: invokeinterface 125 2 0
    //   33: istore_2
    //   34: iload_2
    //   35: iflt -15 -> 20
    //   38: aload_0
    //   39: iload_2
    //   40: invokespecial 133	mmc:rZ	(I)V
    //   43: goto -23 -> 20
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	mmc
    //   0	51	1	paramC	C
    //   33	7	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	20	46	finally
    //   23	34	46	finally
    //   38	43	46	finally
  }
  
  public static abstract class a<C, T, A>
  {
    public abstract void a(C paramC, T paramT, int paramInt, A paramA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmc
 * JD-Core Version:    0.7.0.1
 */