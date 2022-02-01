package androidx.core.os;

import android.os.Build.VERSION;
import androidx.annotation.Nullable;

public final class CancellationSignal
{
  private boolean mCancelInProgress;
  private Object mCancellationSignalObj;
  private boolean mIsCanceled;
  private OnCancelListener mOnCancelListener;
  
  private void waitForCancelFinishedLocked()
  {
    while (this.mCancelInProgress) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	androidx/core/os/CancellationSignal:mIsCanceled	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 30	androidx/core/os/CancellationSignal:mIsCanceled	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 24	androidx/core/os/CancellationSignal:mCancelInProgress	Z
    //   22: aload_0
    //   23: getfield 32	androidx/core/os/CancellationSignal:mOnCancelListener	Landroidx/core/os/CancellationSignal$OnCancelListener;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 34	androidx/core/os/CancellationSignal:mCancellationSignalObj	Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: ifnull +9 -> 44
    //   38: aload_1
    //   39: invokeinterface 37 1 0
    //   44: aload_2
    //   45: ifnull +18 -> 63
    //   48: getstatic 43	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 16
    //   53: if_icmplt +10 -> 63
    //   56: aload_2
    //   57: checkcast 45	android/os/CancellationSignal
    //   60: invokevirtual 47	android/os/CancellationSignal:cancel	()V
    //   63: aload_0
    //   64: monitorenter
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 24	androidx/core/os/CancellationSignal:mCancelInProgress	Z
    //   70: aload_0
    //   71: invokevirtual 50	java/lang/Object:notifyAll	()V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 24	androidx/core/os/CancellationSignal:mCancelInProgress	Z
    //   95: aload_0
    //   96: invokevirtual 50	java/lang/Object:notifyAll	()V
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	CancellationSignal
    //   26	13	1	localOnCancelListener	OnCancelListener
    //   77	4	1	localObject1	Object
    //   82	4	1	localObject2	Object
    //   87	15	1	localObject3	Object
    //   103	4	1	localObject4	Object
    //   31	26	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   65	76	77	finally
    //   78	80	77	finally
    //   2	11	82	finally
    //   12	34	82	finally
    //   83	85	82	finally
    //   38	44	87	finally
    //   48	63	87	finally
    //   90	101	103	finally
    //   104	106	103	finally
  }
  
  @Nullable
  public Object getCancellationSignalObject()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    try
    {
      if (this.mCancellationSignalObj == null)
      {
        this.mCancellationSignalObj = new android.os.CancellationSignal();
        if (this.mIsCanceled) {
          ((android.os.CancellationSignal)this.mCancellationSignalObj).cancel();
        }
      }
      Object localObject1 = this.mCancellationSignalObj;
      return localObject1;
    }
    finally {}
  }
  
  public boolean isCanceled()
  {
    try
    {
      boolean bool = this.mIsCanceled;
      return bool;
    }
    finally {}
  }
  
  public void setOnCancelListener(@Nullable OnCancelListener paramOnCancelListener)
  {
    try
    {
      waitForCancelFinishedLocked();
      if (this.mOnCancelListener == paramOnCancelListener) {
        return;
      }
      this.mOnCancelListener = paramOnCancelListener;
      if ((!this.mIsCanceled) || (paramOnCancelListener == null)) {
        return;
      }
    }
    finally {}
    paramOnCancelListener.onCancel();
  }
  
  public void throwIfCanceled()
  {
    if (isCanceled()) {
      throw new OperationCanceledException();
    }
  }
  
  public static abstract interface OnCancelListener
  {
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.os.CancellationSignal
 * JD-Core Version:    0.7.0.1
 */