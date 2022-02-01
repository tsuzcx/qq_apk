import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class wix<T>
  implements wiw<T>
{
  private List<T> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final wiv<T> jdField_a_of_type_Wiv;
  
  public wix(wiv<T> paramwiv)
  {
    this.jdField_a_of_type_Wiv = paramwiv;
    this.jdField_a_of_type_Wiv.a(this);
  }
  
  /* Error */
  public T a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	wix:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +17 -> 26
    //   12: aload_0
    //   13: getfield 23	wix:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: invokeinterface 51 1 0
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +9 -> 32
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: areturn
    //   32: aload_0
    //   33: getfield 23	wix:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   36: iconst_0
    //   37: invokeinterface 55 2 0
    //   42: astore_2
    //   43: goto -15 -> 28
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	wix
    //   21	2	1	i	int
    //   27	16	2	localObject1	Object
    //   46	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	46	finally
    //   32	43	46	finally
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Wiv.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<T> paramList)
  {
    if (paramList != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_Wiv.a();
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wix
 * JD-Core Version:    0.7.0.1
 */