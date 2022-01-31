package com.tencent.wcdb.support;

import android.os.RemoteException;

public final class CancellationSignal
{
  private boolean mCancelInProgress;
  private boolean mIsCanceled;
  private CancellationSignal.OnCancelListener mOnCancelListener;
  private ICancellationSignal mRemote;
  
  public static ICancellationSignal createTransport()
  {
    return new CancellationSignal.Transport(null);
  }
  
  public static CancellationSignal fromTransport(ICancellationSignal paramICancellationSignal)
  {
    if ((paramICancellationSignal instanceof CancellationSignal.Transport)) {
      return ((CancellationSignal.Transport)paramICancellationSignal).mCancellationSignal;
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
    //   3: getfield 42	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 42	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 34	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   22: aload_0
    //   23: getfield 44	com/tencent/wcdb/support/CancellationSignal:mOnCancelListener	Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 46	com/tencent/wcdb/support/CancellationSignal:mRemote	Lcom/tencent/wcdb/support/ICancellationSignal;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: ifnull +9 -> 44
    //   38: aload_1
    //   39: invokeinterface 51 1 0
    //   44: aload_2
    //   45: ifnull +9 -> 54
    //   48: aload_2
    //   49: invokeinterface 55 1 0
    //   54: aload_0
    //   55: monitorenter
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 34	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   61: aload_0
    //   62: invokevirtual 58	java/lang/Object:notifyAll	()V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: monitorenter
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 34	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   86: aload_0
    //   87: invokevirtual 58	java/lang/Object:notifyAll	()V
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: goto -46 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	CancellationSignal
    //   26	13	1	localOnCancelListener	CancellationSignal.OnCancelListener
    //   68	4	1	localObject1	Object
    //   73	4	1	localObject2	Object
    //   78	15	1	localObject3	Object
    //   94	4	1	localObject4	Object
    //   99	1	1	localRemoteException	RemoteException
    //   31	18	2	localICancellationSignal	ICancellationSignal
    // Exception table:
    //   from	to	target	type
    //   56	67	68	finally
    //   69	71	68	finally
    //   2	11	73	finally
    //   12	34	73	finally
    //   74	76	73	finally
    //   38	44	78	finally
    //   48	54	78	finally
    //   81	92	94	finally
    //   95	97	94	finally
    //   48	54	99	android/os/RemoteException
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
  
  public void setOnCancelListener(CancellationSignal.OnCancelListener paramOnCancelListener)
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
  
  public void setRemote(ICancellationSignal paramICancellationSignal)
  {
    try
    {
      waitForCancelFinishedLocked();
      if (this.mRemote == paramICancellationSignal) {
        return;
      }
      this.mRemote = paramICancellationSignal;
      if ((!this.mIsCanceled) || (paramICancellationSignal == null)) {
        return;
      }
    }
    finally {}
    try
    {
      paramICancellationSignal.cancel();
      return;
    }
    catch (RemoteException paramICancellationSignal) {}
  }
  
  public void throwIfCanceled()
  {
    if (isCanceled()) {
      throw new OperationCanceledException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.CancellationSignal
 * JD-Core Version:    0.7.0.1
 */