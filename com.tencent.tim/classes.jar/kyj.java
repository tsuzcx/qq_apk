import android.os.Handler;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;

public class kyj
  implements AsyncTaskExecutor
{
  public static final kyj a = new kyj();
  private volatile Handler handler;
  
  /* Error */
  public void execute(java.lang.Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	kyj:handler	Landroid/os/Handler;
    //   4: ifnonnull +42 -> 46
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 25	kyj:handler	Landroid/os/Handler;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +29 -> 44
    //   18: ldc 27
    //   20: iconst_0
    //   21: invokestatic 33	com/tencent/mobileqq/app/ThreadManagerV2:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 38	android/os/HandlerThread:start	()V
    //   29: aload_0
    //   30: new 40	android/os/Handler
    //   33: dup
    //   34: aload_2
    //   35: invokevirtual 44	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   38: invokespecial 47	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   41: putfield 25	kyj:handler	Landroid/os/Handler;
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 25	kyj:handler	Landroid/os/Handler;
    //   50: aload_1
    //   51: invokevirtual 51	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   54: pop
    //   55: return
    //   56: astore_2
    //   57: ldc 53
    //   59: iconst_2
    //   60: aload_2
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   68: aload_0
    //   69: new 40	android/os/Handler
    //   72: dup
    //   73: invokestatic 62	com/tencent/mobileqq/app/ThreadManagerV2:getFileThreadLooper	()Landroid/os/Looper;
    //   76: invokespecial 47	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   79: putfield 25	kyj:handler	Landroid/os/Handler;
    //   82: goto -38 -> 44
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	kyj
    //   0	90	1	paramRunnable	java.lang.Runnable
    //   13	22	2	localObject	Object
    //   56	5	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   18	44	56	java/lang/OutOfMemoryError
    //   9	14	85	finally
    //   18	44	85	finally
    //   44	46	85	finally
    //   57	82	85	finally
    //   86	88	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyj
 * JD-Core Version:    0.7.0.1
 */