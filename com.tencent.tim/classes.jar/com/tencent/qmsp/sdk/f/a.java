package com.tencent.qmsp.sdk.f;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class a
{
  private static a e = new a(102400);
  protected static final Comparator<byte[]> f = new a.a();
  private List<byte[]> a = new LinkedList();
  private List<byte[]> b = new ArrayList(64);
  private int c = 0;
  private final int d;
  
  public a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static a a()
  {
    return e;
  }
  
  private void b()
  {
    try
    {
      if (this.c > this.d)
      {
        byte[] arrayOfByte = (byte[])this.a.remove(0);
        this.b.remove(arrayOfByte);
        this.c -= arrayOfByte.length;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
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
    //   10: getfield 47	com/tencent/qmsp/sdk/f/a:d	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 38	com/tencent/qmsp/sdk/f/a:a	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 63 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 43	com/tencent/qmsp/sdk/f/a:b	Ljava/util/List;
    //   37: aload_1
    //   38: getstatic 31	com/tencent/qmsp/sdk/f/a:f	Ljava/util/Comparator;
    //   41: invokestatic 69	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   44: istore_3
    //   45: iload_3
    //   46: istore_2
    //   47: iload_3
    //   48: ifge +8 -> 56
    //   51: iload_3
    //   52: ineg
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 43	com/tencent/qmsp/sdk/f/a:b	Ljava/util/List;
    //   60: iload_2
    //   61: aload_1
    //   62: invokeinterface 72 3 0
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 45	com/tencent/qmsp/sdk/f/a:c	I
    //   72: aload_1
    //   73: arraylength
    //   74: iadd
    //   75: putfield 45	com/tencent/qmsp/sdk/f/a:c	I
    //   78: aload_0
    //   79: invokespecial 74	com/tencent/qmsp/sdk/f/a:b	()V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramArrayOfByte	byte[]
    //   8	53	2	i	int
    //   13	39	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	85	finally
    //   22	45	85	finally
    //   56	82	85	finally
  }
  
  /* Error */
  public byte[] a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 43	com/tencent/qmsp/sdk/f/a:b	Ljava/util/List;
    //   9: invokeinterface 79 1 0
    //   14: if_icmpge +67 -> 81
    //   17: aload_0
    //   18: getfield 43	com/tencent/qmsp/sdk/f/a:b	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 82 2 0
    //   27: checkcast 56	[B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt +40 -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 45	com/tencent/qmsp/sdk/f/a:c	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 45	com/tencent/qmsp/sdk/f/a:c	I
    //   48: aload_0
    //   49: getfield 43	com/tencent/qmsp/sdk/f/a:b	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 54 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 38	com/tencent/qmsp/sdk/f/a:a	Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface 59 2 0
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
    //   0	93	0	this	a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */