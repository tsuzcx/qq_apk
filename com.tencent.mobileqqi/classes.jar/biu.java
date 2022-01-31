import android.util.Log;
import com.tencent.av.thread.Future;
import com.tencent.av.thread.FutureListener;
import com.tencent.av.thread.ThreadPool;
import com.tencent.av.thread.ThreadPool.CancelListener;
import com.tencent.av.thread.ThreadPool.Job;
import com.tencent.av.thread.ThreadPool.JobContext;

public class biu
  implements Future, ThreadPool.JobContext, Runnable
{
  private static final String jdField_a_of_type_JavaLangString = "Worker";
  private int jdField_a_of_type_Int;
  private bit jdField_a_of_type_Bit;
  private FutureListener jdField_a_of_type_ComTencentAvThreadFutureListener;
  private ThreadPool.CancelListener jdField_a_of_type_ComTencentAvThreadThreadPool$CancelListener;
  private ThreadPool.Job jdField_a_of_type_ComTencentAvThreadThreadPool$Job;
  private Object jdField_a_of_type_JavaLangObject;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public biu(ThreadPool paramThreadPool, ThreadPool.Job paramJob, FutureListener paramFutureListener)
  {
    this.jdField_a_of_type_ComTencentAvThreadThreadPool$Job = paramJob;
    this.jdField_a_of_type_ComTencentAvThreadFutureListener = paramFutureListener;
  }
  
  private bit a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_ComTencentAvThreadThreadPool.jdField_a_of_type_Bit;
    }
    if (paramInt == 2) {
      return this.jdField_a_of_type_ComTencentAvThreadThreadPool.b;
    }
    return null;
  }
  
  private void a(bit parambit)
  {
    try
    {
      parambit.jdField_a_of_type_Int += 1;
      parambit.notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(bit parambit)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	biu:jdField_a_of_type_Boolean	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 56	biu:jdField_a_of_type_Bit	Lbit;
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 56	biu:jdField_a_of_type_Bit	Lbit;
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_1
    //   28: getfield 47	bit:jdField_a_of_type_Int	I
    //   31: ifle +31 -> 62
    //   34: aload_1
    //   35: aload_1
    //   36: getfield 47	bit:jdField_a_of_type_Int	I
    //   39: iconst_1
    //   40: isub
    //   41: putfield 47	bit:jdField_a_of_type_Int	I
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 56	biu:jdField_a_of_type_Bit	Lbit;
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_1
    //   63: invokevirtual 59	java/lang/Object:wait	()V
    //   66: aload_1
    //   67: monitorexit
    //   68: goto -68 -> 0
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: goto -16 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	biu
    //   0	85	1	parambit	bit
    //   71	4	2	localObject	Object
    //   81	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	16	57	finally
    //   18	25	57	finally
    //   58	60	57	finally
    //   27	46	71	finally
    //   62	66	71	finally
    //   66	68	71	finally
    //   72	74	71	finally
    //   48	55	76	finally
    //   77	79	76	finally
    //   62	66	81	java/lang/InterruptedException
  }
  
  public Object a()
  {
    try
    {
      for (;;)
      {
        boolean bool = this.b;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (Exception localException)
        {
          Log.w("Worker", "ingore exception", localException);
        }
      }
      localObject2 = this.jdField_a_of_type_JavaLangObject;
    }
    finally {}
    Object localObject2;
    return localObject2;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	biu:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 55	biu:jdField_a_of_type_Boolean	Z
    //   19: aload_0
    //   20: getfield 56	biu:jdField_a_of_type_Bit	Lbit;
    //   23: ifnull +19 -> 42
    //   26: aload_0
    //   27: getfield 56	biu:jdField_a_of_type_Bit	Lbit;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 56	biu:jdField_a_of_type_Bit	Lbit;
    //   37: invokevirtual 50	java/lang/Object:notifyAll	()V
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 76	biu:jdField_a_of_type_ComTencentAvThreadThreadPool$CancelListener	Lcom/tencent/av/thread/ThreadPool$CancelListener;
    //   46: ifnull -35 -> 11
    //   49: aload_0
    //   50: getfield 76	biu:jdField_a_of_type_ComTencentAvThreadThreadPool$CancelListener	Lcom/tencent/av/thread/ThreadPool$CancelListener;
    //   53: invokeinterface 80 1 0
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_3
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	biu
    //   6	2	1	bool	boolean
    //   61	7	2	localObject1	Object
    //   66	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	33	61	finally
    //   42	58	61	finally
    //   69	71	61	finally
    //   33	42	66	finally
    //   67	69	66	finally
  }
  
  public void a(ThreadPool.CancelListener paramCancelListener)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvThreadThreadPool$CancelListener = paramCancelListener;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvThreadThreadPool$CancelListener != null)) {
        this.jdField_a_of_type_ComTencentAvThreadThreadPool$CancelListener.a();
      }
      return;
    }
    finally
    {
      paramCancelListener = finally;
      throw paramCancelListener;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    bit localbit = a(this.jdField_a_of_type_Int);
    if (localbit != null) {
      a(localbit);
    }
    this.jdField_a_of_type_Int = 0;
    localbit = a(paramInt);
    if (localbit != null)
    {
      if (!a(localbit)) {
        return false;
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    return true;
  }
  
  public void b()
  {
    a();
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    Object localObject4 = null;
    Object localObject1 = localObject4;
    if (a(1)) {
      localObject1 = localObject4;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvThreadThreadPool$Job != null) {
        localObject1 = this.jdField_a_of_type_ComTencentAvThreadThreadPool$Job.a(this);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          a(0);
          this.jdField_a_of_type_JavaLangObject = localObject1;
          this.b = true;
          notifyAll();
          if (this.jdField_a_of_type_ComTencentAvThreadFutureListener != null) {
            this.jdField_a_of_type_ComTencentAvThreadFutureListener.a(this);
          }
          return;
        }
        finally {}
        localThrowable = localThrowable;
        Log.w("Worker", "Exception in running a job", localThrowable);
        Object localObject2 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     biu
 * JD-Core Version:    0.7.0.1
 */