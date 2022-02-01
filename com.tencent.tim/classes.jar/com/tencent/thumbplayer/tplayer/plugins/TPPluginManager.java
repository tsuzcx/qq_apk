package com.tencent.thumbplayer.tplayer.plugins;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TPPluginManager
  implements ITPPluginManager
{
  private CopyOnWriteArrayList<ITPPluginBase> mPluginList = new CopyOnWriteArrayList();
  
  /* Error */
  public void addPlugin(ITPPluginBase paramITPPluginBase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/thumbplayer/tplayer/plugins/TPPluginManager:mPluginList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 18	com/tencent/thumbplayer/tplayer/plugins/TPPluginManager:mPluginList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   18: aload_1
    //   19: invokevirtual 25	java/util/concurrent/CopyOnWriteArrayList:contains	(Ljava/lang/Object;)Z
    //   22: ifne -11 -> 11
    //   25: aload_1
    //   26: invokeinterface 30 1 0
    //   31: aload_0
    //   32: getfield 18	com/tencent/thumbplayer/tplayer/plugins/TPPluginManager:mPluginList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   35: aload_1
    //   36: invokevirtual 33	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: goto -29 -> 11
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TPPluginManager
    //   0	48	1	paramITPPluginBase	ITPPluginBase
    //   6	2	2	localCopyOnWriteArrayList	CopyOnWriteArrayList
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   14	40	43	finally
  }
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    try
    {
      if (this.mPluginList != null)
      {
        Iterator localIterator = this.mPluginList.iterator();
        while (localIterator.hasNext())
        {
          ITPPluginBase localITPPluginBase = (ITPPluginBase)localIterator.next();
          if (localITPPluginBase != null) {
            localITPPluginBase.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
          }
        }
      }
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      if (this.mPluginList != null)
      {
        Iterator localIterator = this.mPluginList.iterator();
        while (localIterator.hasNext())
        {
          ITPPluginBase localITPPluginBase = (ITPPluginBase)localIterator.next();
          if (localITPPluginBase != null) {
            localITPPluginBase.onDetach();
          }
        }
        this.mPluginList.clear();
      }
    }
    finally {}
    this.mPluginList = null;
  }
  
  public void removePlugin(ITPPluginBase paramITPPluginBase)
  {
    try
    {
      if (this.mPluginList != null)
      {
        paramITPPluginBase.onDetach();
        this.mPluginList.remove(paramITPPluginBase);
      }
      return;
    }
    finally
    {
      paramITPPluginBase = finally;
      throw paramITPPluginBase;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.TPPluginManager
 * JD-Core Version:    0.7.0.1
 */