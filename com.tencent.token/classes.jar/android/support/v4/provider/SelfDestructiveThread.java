package android.support.v4.provider;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.support.annotation.GuardedBy;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Callable;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SelfDestructiveThread
{
  private static final int MSG_DESTRUCTION = 0;
  private static final int MSG_INVOKE_RUNNABLE = 1;
  private Handler.Callback mCallback = new SelfDestructiveThread.1(this);
  private final int mDestructAfterMillisec;
  @GuardedBy("mLock")
  private int mGeneration;
  @GuardedBy("mLock")
  private Handler mHandler;
  private final Object mLock = new Object();
  private final int mPriority;
  @GuardedBy("mLock")
  private HandlerThread mThread;
  private final String mThreadName;
  
  public SelfDestructiveThread(String paramString, int paramInt1, int paramInt2)
  {
    this.mThreadName = paramString;
    this.mPriority = paramInt1;
    this.mDestructAfterMillisec = paramInt2;
    this.mGeneration = 0;
  }
  
  private void onDestruction()
  {
    synchronized (this.mLock)
    {
      if (this.mHandler.hasMessages(1)) {
        return;
      }
      this.mThread.quit();
      this.mThread = null;
      this.mHandler = null;
      return;
    }
  }
  
  private void onInvokeRunnable(Runnable arg1)
  {
    ???.run();
    synchronized (this.mLock)
    {
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), this.mDestructAfterMillisec);
      return;
    }
  }
  
  private void post(Runnable paramRunnable)
  {
    synchronized (this.mLock)
    {
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
        this.mGeneration += 1;
      }
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramRunnable));
      return;
    }
  }
  
  @VisibleForTesting
  public int getGeneration()
  {
    synchronized (this.mLock)
    {
      int i = this.mGeneration;
      return i;
    }
  }
  
  @VisibleForTesting
  public boolean isRunning()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mThread != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void postAndReply(Callable paramCallable, SelfDestructiveThread.ReplyCallback paramReplyCallback)
  {
    post(new SelfDestructiveThread.2(this, paramCallable, new Handler(), paramReplyCallback));
  }
  
  /* Error */
  public Object postAndWait(Callable paramCallable, int paramInt)
  {
    // Byte code:
    //   0: new 135	java/util/concurrent/locks/ReentrantLock
    //   3: dup
    //   4: invokespecial 136	java/util/concurrent/locks/ReentrantLock:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:newCondition	()Ljava/util/concurrent/locks/Condition;
    //   14: astore 8
    //   16: new 142	java/util/concurrent/atomic/AtomicReference
    //   19: dup
    //   20: invokespecial 143	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   23: astore 9
    //   25: new 145	java/util/concurrent/atomic/AtomicBoolean
    //   28: dup
    //   29: iconst_1
    //   30: invokespecial 148	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   33: astore 10
    //   35: aload_0
    //   36: new 150	android/support/v4/provider/SelfDestructiveThread$3
    //   39: dup
    //   40: aload_0
    //   41: aload 9
    //   43: aload_1
    //   44: aload 7
    //   46: aload 10
    //   48: aload 8
    //   50: invokespecial 153	android/support/v4/provider/SelfDestructiveThread$3:<init>	(Landroid/support/v4/provider/SelfDestructiveThread;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Callable;Ljava/util/concurrent/locks/ReentrantLock;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/locks/Condition;)V
    //   53: invokespecial 129	android/support/v4/provider/SelfDestructiveThread:post	(Ljava/lang/Runnable;)V
    //   56: aload 7
    //   58: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   61: aload 10
    //   63: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   66: ifne +16 -> 82
    //   69: aload 9
    //   71: invokevirtual 162	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   74: astore_1
    //   75: aload 7
    //   77: invokevirtual 165	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: aload_1
    //   81: areturn
    //   82: getstatic 171	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   85: iload_2
    //   86: i2l
    //   87: invokevirtual 175	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   90: lstore_3
    //   91: aload 8
    //   93: lload_3
    //   94: invokeinterface 180 3 0
    //   99: lstore 5
    //   101: aload 10
    //   103: invokevirtual 159	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   106: ifne +16 -> 122
    //   109: aload 9
    //   111: invokevirtual 162	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   114: astore_1
    //   115: aload 7
    //   117: invokevirtual 165	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   120: aload_1
    //   121: areturn
    //   122: lload 5
    //   124: lstore_3
    //   125: lload 5
    //   127: lconst_0
    //   128: lcmp
    //   129: ifgt -38 -> 91
    //   132: new 133	java/lang/InterruptedException
    //   135: dup
    //   136: ldc 182
    //   138: invokespecial 185	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   141: athrow
    //   142: astore_1
    //   143: aload 7
    //   145: invokevirtual 165	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: lload_3
    //   152: lstore 5
    //   154: goto -53 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	SelfDestructiveThread
    //   0	157	1	paramCallable	Callable
    //   0	157	2	paramInt	int
    //   90	62	3	l1	long
    //   99	54	5	l2	long
    //   7	137	7	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    //   14	78	8	localCondition	java.util.concurrent.locks.Condition
    //   23	87	9	localAtomicReference	java.util.concurrent.atomic.AtomicReference
    //   33	69	10	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   61	75	142	finally
    //   82	91	142	finally
    //   91	101	142	finally
    //   101	115	142	finally
    //   132	142	142	finally
    //   91	101	150	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.SelfDestructiveThread
 * JD-Core Version:    0.7.0.1
 */