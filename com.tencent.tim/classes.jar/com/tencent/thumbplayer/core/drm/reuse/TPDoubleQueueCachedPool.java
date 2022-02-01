package com.tencent.thumbplayer.core.drm.reuse;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TPDoubleQueueCachedPool
{
  private static final int DEFAULT_CORE_POOL_SIZE = 2;
  private static final String TAG = "[PlayerCore][TPDoubleQueueCachedPool]";
  private final List<Object> mBusyCacheList = new ArrayList();
  private final List<Object> mIdleCacheList = new ArrayList();
  private ITPCachePoolListener mListener;
  private final int mMinSize;
  
  public TPDoubleQueueCachedPool(int paramInt, @NonNull ITPCachePoolListener paramITPCachePoolListener)
  {
    if (paramInt > 0) {}
    for (;;)
    {
      this.mMinSize = paramInt;
      this.mListener = paramITPCachePoolListener;
      paramInt = 0;
      label42:
      if (paramInt < this.mMinSize) {
        try
        {
          this.mIdleCacheList.add(paramITPCachePoolListener.createTPMediaDrm(this));
          paramInt += 1;
          break label42;
          paramInt = 2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            TPNativeLog.printLog(3, localException.getMessage());
          }
        }
      }
    }
    TPNativeLog.printLog(2, "[PlayerCore][TPDoubleQueueCachedPool]", "TPDoubleQueueCachedPool init size:" + this.mIdleCacheList.size());
  }
  
  /* Error */
  @NonNull
  public Object allocObject()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mIdleCacheList	Ljava/util/List;
    //   6: invokeinterface 90 1 0
    //   11: ifeq +29 -> 40
    //   14: aload_0
    //   15: getfield 40	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mListener	Lcom/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool$ITPCachePoolListener;
    //   18: aload_0
    //   19: invokeinterface 44 2 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 36	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mBusyCacheList	Ljava/util/List;
    //   29: aload_1
    //   30: invokeinterface 50 2 0
    //   35: pop
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aload_0
    //   41: getfield 34	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mIdleCacheList	Ljava/util/List;
    //   44: iconst_0
    //   45: invokeinterface 94 2 0
    //   50: astore_1
    //   51: goto -26 -> 25
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	TPDoubleQueueCachedPool
    //   24	27	1	localObject1	Object
    //   54	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	54	finally
    //   25	36	54	finally
    //   40	51	54	finally
  }
  
  /* Error */
  public void freeObject(@NonNull Object paramObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mBusyCacheList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 100 2 0
    //   12: ifeq +37 -> 49
    //   15: iload_2
    //   16: ifeq +33 -> 49
    //   19: aload_0
    //   20: getfield 34	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mIdleCacheList	Ljava/util/List;
    //   23: invokeinterface 73 1 0
    //   28: aload_0
    //   29: getfield 38	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mMinSize	I
    //   32: if_icmpge +17 -> 49
    //   35: aload_0
    //   36: getfield 34	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mIdleCacheList	Ljava/util/List;
    //   39: aload_1
    //   40: invokeinterface 50 2 0
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 40	com/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool:mListener	Lcom/tencent/thumbplayer/core/drm/reuse/TPDoubleQueueCachedPool$ITPCachePoolListener;
    //   53: aload_0
    //   54: aload_1
    //   55: invokeinterface 104 3 0
    //   60: goto -14 -> 46
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	TPDoubleQueueCachedPool
    //   0	68	1	paramObject	Object
    //   0	68	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	63	finally
    //   19	46	63	finally
    //   49	60	63	finally
  }
  
  public void release()
  {
    try
    {
      ListIterator localListIterator1 = this.mBusyCacheList.listIterator();
      while (localListIterator1.hasNext())
      {
        this.mListener.releaseTPMediaDrm(this, localListIterator1.next());
        localListIterator1.remove();
      }
      localListIterator2 = this.mIdleCacheList.listIterator();
    }
    finally {}
    ListIterator localListIterator2;
    while (localListIterator2.hasNext())
    {
      this.mListener.releaseTPMediaDrm(this, localListIterator2.next());
      localListIterator2.remove();
    }
    this.mListener = null;
  }
  
  static abstract interface ITPCachePoolListener
  {
    @NonNull
    public abstract Object createTPMediaDrm(TPDoubleQueueCachedPool paramTPDoubleQueueCachedPool)
      throws Exception;
    
    public abstract void releaseTPMediaDrm(TPDoubleQueueCachedPool paramTPDoubleQueueCachedPool, @NonNull Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPDoubleQueueCachedPool
 * JD-Core Version:    0.7.0.1
 */