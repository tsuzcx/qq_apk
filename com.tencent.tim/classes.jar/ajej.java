import android.util.SparseArray;
import java.util.ArrayList;

public class ajej
{
  private static SparseArray<ArrayList<byte[]>> cU = new SparseArray(2000);
  private static SparseArray<Integer> cV = new SparseArray(2000);
  
  /* Error */
  public static void bj(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: arraylength
    //   5: istore_1
    //   6: iload_1
    //   7: sipush 2000
    //   10: if_icmple +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: getstatic 19	ajej:cU	Landroid/util/SparseArray;
    //   20: iload_1
    //   21: invokevirtual 28	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   24: checkcast 30	java/util/ArrayList
    //   27: astore 4
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: ifnonnull +24 -> 58
    //   37: new 30	java/util/ArrayList
    //   40: dup
    //   41: bipush 100
    //   43: invokespecial 31	java/util/ArrayList:<init>	(I)V
    //   46: astore_3
    //   47: getstatic 21	ajej:cV	Landroid/util/SparseArray;
    //   50: iload_1
    //   51: iconst_0
    //   52: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokevirtual 41	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   58: aload_3
    //   59: invokevirtual 45	java/util/ArrayList:size	()I
    //   62: bipush 100
    //   64: if_icmpge -51 -> 13
    //   67: aload_3
    //   68: aload_0
    //   69: invokevirtual 49	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: getstatic 19	ajej:cU	Landroid/util/SparseArray;
    //   76: aload_0
    //   77: arraylength
    //   78: aload_3
    //   79: invokevirtual 41	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   82: getstatic 21	ajej:cV	Landroid/util/SparseArray;
    //   85: iload_1
    //   86: invokevirtual 28	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   89: checkcast 33	java/lang/Integer
    //   92: invokevirtual 52	java/lang/Integer:intValue	()I
    //   95: istore_2
    //   96: getstatic 21	ajej:cV	Landroid/util/SparseArray;
    //   99: iload_1
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: invokevirtual 41	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   109: goto -96 -> 13
    //   112: astore_0
    //   113: ldc 2
    //   115: monitorexit
    //   116: aload_0
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramArrayOfByte	byte[]
    //   5	95	1	i	int
    //   95	8	2	j	int
    //   31	48	3	localArrayList1	ArrayList
    //   27	6	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   3	6	112	finally
    //   17	29	112	finally
    //   37	58	112	finally
    //   58	109	112	finally
  }
  
  public static void clear()
  {
    try
    {
      cU.clear();
      cV.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void dwK()
  {
    int i = 0;
    try
    {
      int j = cV.size();
      while (i < j)
      {
        cV.setValueAt(i, Integer.valueOf(0));
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static byte[] getByteArray(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	ajej:cU	Landroid/util/SparseArray;
    //   6: iload_0
    //   7: invokevirtual 28	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 30	java/util/ArrayList
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +10 -> 25
    //   18: aconst_null
    //   19: astore_2
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: getstatic 21	ajej:cV	Landroid/util/SparseArray;
    //   28: iload_0
    //   29: invokevirtual 28	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   32: checkcast 33	java/lang/Integer
    //   35: invokevirtual 52	java/lang/Integer:intValue	()I
    //   38: istore_1
    //   39: iload_1
    //   40: aload_2
    //   41: invokevirtual 45	java/util/ArrayList:size	()I
    //   44: if_icmplt +8 -> 52
    //   47: aconst_null
    //   48: astore_2
    //   49: goto -29 -> 20
    //   52: aload_2
    //   53: iload_1
    //   54: invokevirtual 63	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   57: checkcast 65	[B
    //   60: astore_2
    //   61: getstatic 21	ajej:cV	Landroid/util/SparseArray;
    //   64: iload_0
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 41	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   74: goto -54 -> 20
    //   77: astore_2
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramInt	int
    //   38	30	1	i	int
    //   13	48	2	localObject1	Object
    //   77	5	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	77	finally
    //   25	47	77	finally
    //   52	74	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajej
 * JD-Core Version:    0.7.0.1
 */