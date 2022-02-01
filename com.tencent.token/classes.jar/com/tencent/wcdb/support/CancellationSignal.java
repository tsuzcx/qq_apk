package com.tencent.wcdb.support;

import android.os.RemoteException;

public final class CancellationSignal
{
  private boolean mCancelInProgress;
  private boolean mIsCanceled;
  private OnCancelListener mOnCancelListener;
  private ICancellationSignal mRemote;
  
  public static ICancellationSignal createTransport()
  {
    return new Transport(null);
  }
  
  public static CancellationSignal fromTransport(ICancellationSignal paramICancellationSignal)
  {
    if ((paramICancellationSignal instanceof Transport)) {
      return ((Transport)paramICancellationSignal).mCancellationSignal;
    }
    return null;
  }
  
  private void waitForCancelFinishedLocked()
  {
    while (this.mCancelInProgress) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        label14:
        break label14;
      }
    }
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 48	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 40	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   22: aload_0
    //   23: getfield 50	com/tencent/wcdb/support/CancellationSignal:mOnCancelListener	Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 52	com/tencent/wcdb/support/CancellationSignal:mRemote	Lcom/tencent/wcdb/support/ICancellationSignal;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: ifnull +16 -> 51
    //   38: aload_1
    //   39: invokeinterface 55 1 0
    //   44: goto +7 -> 51
    //   47: astore_1
    //   48: goto +16 -> 64
    //   51: aload_2
    //   52: ifnull +32 -> 84
    //   55: aload_2
    //   56: invokeinterface 59 1 0
    //   61: goto +23 -> 84
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 40	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   71: aload_0
    //   72: invokevirtual 62	java/lang/Object:notifyAll	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_0
    //   85: monitorenter
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 40	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   91: aload_0
    //   92: invokevirtual 62	java/lang/Object:notifyAll	()V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -25 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	CancellationSignal
    //   26	13	1	localOnCancelListener	OnCancelListener
    //   47	31	1	localObject1	Object
    //   79	4	1	localObject2	Object
    //   98	4	1	localObject3	Object
    //   103	4	1	localObject4	Object
    //   108	1	1	localRemoteException	RemoteException
    //   31	25	2	localICancellationSignal	ICancellationSignal
    // Exception table:
    //   from	to	target	type
    //   38	44	47	finally
    //   55	61	47	finally
    //   66	77	79	finally
    //   80	82	79	finally
    //   86	97	98	finally
    //   99	101	98	finally
    //   2	11	103	finally
    //   12	34	103	finally
    //   104	106	103	finally
    //   55	61	108	android/os/RemoteException
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
  
  public void setOnCancelListener(OnCancelListener paramOnCancelListener)
  {
    try
    {
      waitForCancelFinishedLocked();
      if (this.mOnCancelListener == paramOnCancelListener) {
        return;
      }
      this.mOnCancelListener = paramOnCancelListener;
      if ((this.mIsCanceled) && (paramOnCancelListener != null))
      {
        paramOnCancelListener.onCancel();
        return;
      }
      return;
    }
    finally {}
  }
  
  public void setRemote(ICancellationSignal paramICancellationSignal)
  {
    label45:
    try
    {
      waitForCancelFinishedLocked();
      if (this.mRemote == paramICancellationSignal) {
        return;
      }
      this.mRemote = paramICancellationSignal;
      if (this.mIsCanceled) {
        if (paramICancellationSignal == null) {
          break label45;
        }
      }
    }
    finally {}
    try
    {
      paramICancellationSignal.cancel();
      return;
    }
    catch (RemoteException paramICancellationSignal) {}
    return;
  }
  
  public void throwIfCanceled()
  {
    if (!isCanceled()) {
      return;
    }
    throw new OperationCanceledException();
  }
  
  public static abstract interface OnCancelListener
  {
    public abstract void onCancel();
  }
  
  private static final class Transport
    extends ICancellationSignal.Stub
  {
    final CancellationSignal mCancellationSignal = new CancellationSignal();
    
    public void cancel()
    {
      this.mCancellationSignal.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.CancellationSignal
 * JD-Core Version:    0.7.0.1
 */