import com.tencent.mobileqq.app.BoundedPriorityBlockingQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class yxm
  implements Iterator
{
  private int jdField_a_of_type_Int;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private int b = -1;
  
  public yxm(BoundedPriorityBlockingQueue paramBoundedPriorityBlockingQueue, Object[] paramArrayOfObject)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
  }
  
  /* Error */
  private void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	yxm:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   4: invokestatic 29	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)Ljava/util/concurrent/locks/ReentrantLock;
    //   7: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 15	yxm:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   17: invokestatic 37	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)I
    //   20: if_icmpge +24 -> 44
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 15	yxm:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   28: invokestatic 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)[Ljava/lang/Object;
    //   31: iload_2
    //   32: aaload
    //   33: if_acmpne +22 -> 55
    //   36: aload_0
    //   37: getfield 15	yxm:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   40: iload_2
    //   41: invokestatic 43	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;I)V
    //   44: aload_0
    //   45: getfield 15	yxm:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   48: invokestatic 29	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)Ljava/util/concurrent/locks/ReentrantLock;
    //   51: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   54: return
    //   55: iload_2
    //   56: iconst_1
    //   57: iadd
    //   58: istore_2
    //   59: goto -47 -> 12
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 15	yxm:jdField_a_of_type_ComTencentMobileqqAppBoundedPriorityBlockingQueue	Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;
    //   67: invokestatic 29	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Lcom/tencent/mobileqq/app/BoundedPriorityBlockingQueue;)Ljava/util/concurrent/locks/ReentrantLock;
    //   70: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	yxm
    //   0	75	1	paramObject	Object
    //   11	48	2	i	int
    // Exception table:
    //   from	to	target	type
    //   12	44	62	finally
  }
  
  public boolean hasNext()
  {
    return this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaLangObject.length;
  }
  
  public Object next()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfJavaLangObject.length) {
      throw new NoSuchElementException();
    }
    this.b = this.jdField_a_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    return arrayOfObject[i];
  }
  
  public void remove()
  {
    if (this.b == -1) {
      throw new IllegalStateException();
    }
    a(this.jdField_a_of_type_ArrayOfJavaLangObject[this.b]);
    this.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxm
 * JD-Core Version:    0.7.0.1
 */