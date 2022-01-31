package com.tencent.mobileqq.app.automator;

public class ParallGroup
  extends StepGroup
  implements IResultListener
{
  private int k;
  
  protected int a()
  {
    AsyncStep localAsyncStep1 = a();
    localAsyncStep1.a = this;
    for (;;)
    {
      AsyncStep localAsyncStep2 = a();
      if ((localAsyncStep2 == null) || (this.g == 8)) {
        break;
      }
      localAsyncStep2.a = this;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b(localAsyncStep2);
    }
    localAsyncStep1.run();
    return 2;
  }
  
  public void a()
  {
    super.a();
    this.k = this.jdField_a_of_type_ArrayOfJavaLangString.length;
  }
  
  /* Error */
  public void a(AsyncStep arg1, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/tencent/mobileqq/app/automator/ParallGroup:k	I
    //   6: iconst_1
    //   7: isub
    //   8: istore_2
    //   9: aload_0
    //   10: iload_2
    //   11: putfield 45	com/tencent/mobileqq/app/automator/ParallGroup:k	I
    //   14: iload_2
    //   15: ifne +12 -> 27
    //   18: aload_0
    //   19: bipush 7
    //   21: invokevirtual 49	com/tencent/mobileqq/app/automator/ParallGroup:a	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 52	com/tencent/mobileqq/app/automator/ParallGroup:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 29	com/tencent/mobileqq/app/automator/ParallGroup:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   38: aload_0
    //   39: getfield 52	com/tencent/mobileqq/app/automator/ParallGroup:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   42: invokevirtual 55	com/tencent/mobileqq/app/automator/Automator:a	(Ljava/util/ArrayList;)Lcom/tencent/mobileqq/app/automator/AsyncStep;
    //   45: astore_3
    //   46: aload_1
    //   47: monitorexit
    //   48: aload_3
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: invokevirtual 38	com/tencent/mobileqq/app/automator/AsyncStep:run	()V
    //   56: goto -32 -> 24
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_3
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_3
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ParallGroup
    //   0	69	2	paramInt	int
    //   45	8	3	localAsyncStep	AsyncStep
    //   64	4	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	14	59	finally
    //   18	24	59	finally
    //   27	34	59	finally
    //   52	56	59	finally
    //   67	69	59	finally
    //   34	48	64	finally
    //   65	67	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ParallGroup
 * JD-Core Version:    0.7.0.1
 */