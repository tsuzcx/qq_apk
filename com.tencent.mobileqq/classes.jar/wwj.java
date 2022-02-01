import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wwj
{
  private int jdField_a_of_type_Int;
  private List<wwk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Queue<wwk> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private int b;
  
  public wwk a()
  {
    try
    {
      wwk localwwk = (wwk)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localwwk != null) {
        this.b -= localwwk.jdField_a_of_type_JavaNioByteBuffer.remaining();
      }
      return localwwk;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      for (;;)
      {
        wwk localwwk = (wwk)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localwwk == null) {
          break;
        }
        a(localwwk);
      }
      this.b = 0;
    }
    finally {}
  }
  
  /* Error */
  public void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 47	java/nio/ByteBuffer:remaining	()I
    //   6: aload_0
    //   7: getfield 53	wwj:jdField_a_of_type_Int	I
    //   10: if_icmple +20 -> 30
    //   13: aload_0
    //   14: getfield 25	wwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   17: invokeinterface 58 1 0
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 47	java/nio/ByteBuffer:remaining	()I
    //   27: putfield 53	wwj:jdField_a_of_type_Int	I
    //   30: aload_0
    //   31: getfield 25	wwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   34: invokeinterface 62 1 0
    //   39: ifne +101 -> 140
    //   42: aload_0
    //   43: getfield 25	wwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   46: iconst_0
    //   47: invokeinterface 66 2 0
    //   52: checkcast 38	wwk
    //   55: astore 5
    //   57: aload 5
    //   59: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   62: aload_1
    //   63: invokevirtual 47	java/nio/ByteBuffer:remaining	()I
    //   66: invokevirtual 70	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   69: pop
    //   70: aload 5
    //   72: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   75: invokevirtual 74	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   78: pop
    //   79: aload 5
    //   81: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   84: aload_1
    //   85: invokevirtual 78	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   88: pop
    //   89: aload 5
    //   91: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   94: invokevirtual 81	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   97: pop
    //   98: aload 5
    //   100: lload_2
    //   101: putfield 84	wwk:jdField_a_of_type_Long	J
    //   104: aload_0
    //   105: getfield 20	wwj:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   108: aload 5
    //   110: invokeinterface 88 2 0
    //   115: pop
    //   116: aload_0
    //   117: getfield 29	wwj:b	I
    //   120: istore 4
    //   122: aload_0
    //   123: aload 5
    //   125: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   128: invokevirtual 47	java/nio/ByteBuffer:remaining	()I
    //   131: iload 4
    //   133: iadd
    //   134: putfield 29	wwj:b	I
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: new 38	wwk
    //   143: dup
    //   144: aload_1
    //   145: invokevirtual 47	java/nio/ByteBuffer:remaining	()I
    //   148: invokespecial 91	wwk:<init>	(I)V
    //   151: astore 5
    //   153: goto -96 -> 57
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	wwj
    //   0	161	1	paramByteBuffer	ByteBuffer
    //   0	161	2	paramLong	long
    //   120	14	4	i	int
    //   55	97	5	localwwk	wwk
    // Exception table:
    //   from	to	target	type
    //   2	30	156	finally
    //   30	57	156	finally
    //   57	137	156	finally
    //   140	153	156	finally
  }
  
  /* Error */
  public void a(wwk paramwwk)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   6: invokevirtual 94	java/nio/ByteBuffer:capacity	()I
    //   9: istore_2
    //   10: aload_0
    //   11: getfield 53	wwj:jdField_a_of_type_Int	I
    //   14: istore_3
    //   15: iload_2
    //   16: iload_3
    //   17: if_icmpeq +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_1
    //   24: getfield 41	wwk:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   27: invokevirtual 97	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   30: pop
    //   31: aload_0
    //   32: getfield 25	wwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   35: aload_1
    //   36: invokeinterface 98 2 0
    //   41: pop
    //   42: goto -22 -> 20
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	wwj
    //   0	50	1	paramwwk	wwk
    //   9	9	2	i	int
    //   14	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	15	45	finally
    //   23	42	45	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwj
 * JD-Core Version:    0.7.0.1
 */