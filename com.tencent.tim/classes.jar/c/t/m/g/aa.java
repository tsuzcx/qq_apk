package c.t.m.g;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class aa
{
  private static aa a = new aa();
  private static Comparator<byte[]> f = new aa.1();
  private final List<byte[]> b = new ArrayList(32);
  private final List<byte[]> c = new ArrayList(32);
  private int d = 0;
  private int e = 10240;
  
  public static aa a()
  {
    return a;
  }
  
  private void b()
  {
    try
    {
      if (this.d > this.e)
      {
        byte[] arrayOfByte = (byte[])this.b.remove(0);
        this.c.remove(arrayOfByte);
        this.d -= arrayOfByte.length;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: arraylength
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 43	c/t/m/g/aa:e	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_1
    //   23: iconst_0
    //   24: invokestatic 62	java/util/Arrays:fill	([BB)V
    //   27: aload_0
    //   28: getfield 37	c/t/m/g/aa:b	Ljava/util/List;
    //   31: aload_1
    //   32: invokeinterface 65 2 0
    //   37: pop
    //   38: aload_0
    //   39: getfield 39	c/t/m/g/aa:c	Ljava/util/List;
    //   42: aload_1
    //   43: getstatic 28	c/t/m/g/aa:f	Ljava/util/Comparator;
    //   46: invokestatic 71	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   49: istore_3
    //   50: iload_3
    //   51: istore_2
    //   52: iload_3
    //   53: ifge +8 -> 61
    //   56: iload_3
    //   57: ineg
    //   58: iconst_1
    //   59: isub
    //   60: istore_2
    //   61: aload_0
    //   62: getfield 39	c/t/m/g/aa:c	Ljava/util/List;
    //   65: iload_2
    //   66: aload_1
    //   67: invokeinterface 74 3 0
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 41	c/t/m/g/aa:d	I
    //   77: aload_1
    //   78: arraylength
    //   79: iadd
    //   80: putfield 41	c/t/m/g/aa:d	I
    //   83: aload_0
    //   84: invokespecial 76	c/t/m/g/aa:b	()V
    //   87: goto -68 -> 19
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	aa
    //   0	95	1	paramArrayOfByte	byte[]
    //   8	58	2	i	int
    //   13	44	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	90	finally
    //   22	50	90	finally
    //   61	87	90	finally
  }
  
  /* Error */
  public final byte[] a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 39	c/t/m/g/aa:c	Ljava/util/List;
    //   9: invokeinterface 81 1 0
    //   14: if_icmpge +67 -> 81
    //   17: aload_0
    //   18: getfield 39	c/t/m/g/aa:c	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 84 2 0
    //   27: checkcast 52	[B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmpne +40 -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 41	c/t/m/g/aa:d	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 41	c/t/m/g/aa:d	I
    //   48: aload_0
    //   49: getfield 39	c/t/m/g/aa:c	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 50 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 37	c/t/m/g/aa:b	Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface 55 2 0
    //   69: pop
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: areturn
    //   74: iload_2
    //   75: iconst_1
    //   76: iadd
    //   77: istore_2
    //   78: goto -74 -> 4
    //   81: iload_1
    //   82: newarray byte
    //   84: astore_3
    //   85: goto -15 -> 70
    //   88: astore_3
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	aa
    //   0	93	1	paramInt	int
    //   3	75	2	i	int
    //   30	55	3	arrayOfByte	byte[]
    //   88	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	70	88	finally
    //   81	85	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.aa
 * JD-Core Version:    0.7.0.1
 */