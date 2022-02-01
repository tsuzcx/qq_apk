import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.1;
import com.tencent.biz.qqstory.base.preload.PreloadQueue;
import com.tencent.biz.qqstory.base.preload.PreloadQueue.a;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

@TargetApi(14)
public class pnm
  implements psj
{
  public PreloadDownloader a = new PreloadDownloader();
  public pnm.a b = new pnm.b();
  public Runnable mStopRunnable;
  public List<PreloadQueue> mo = new ArrayList();
  
  public pnm()
  {
    Object localObject1 = new PreloadQueue.a();
    ((PreloadQueue.a)localObject1).a(0);
    localObject1 = ((PreloadQueue.a)localObject1).a();
    Object localObject2 = new PreloadQueue.a();
    ((PreloadQueue.a)localObject2).a(1);
    localObject2 = ((PreloadQueue.a)localObject2).a();
    Object localObject3 = new PreloadQueue.a();
    ((PreloadQueue.a)localObject3).a(2);
    localObject3 = ((PreloadQueue.a)localObject3).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    this.mo = localArrayList;
  }
  
  public boolean Iy()
  {
    return (this.mStopRunnable == null) && (this.a.isRunning());
  }
  
  public void b(pni.a parama)
  {
    this.a.b(parama);
  }
  
  public void blW()
  {
    if (this.mStopRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.mStopRunnable);
      this.mStopRunnable = null;
    }
    this.a.onStart();
  }
  
  public void d(List<png> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {}
    PreloadQueue localPreloadQueue;
    for (;;)
    {
      return;
      try
      {
        ram.w("Q.qqstory.download.preload.PreloadDownloaderManager", "setPreloadTaskList , id = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        localPreloadQueue = (PreloadQueue)this.mo.get(paramInt);
        if (localPreloadQueue == null) {
          ram.w("Q.qqstory.download.preload.PreloadDownloaderManager", "cannot find queue , id = " + paramInt);
        }
      }
      finally {}
    }
    png localpng2 = this.a.a();
    if (paramList.size() == 0) {}
    for (png localpng1 = null;; localpng1 = (png)paramList.get(0))
    {
      localPreloadQueue.clearAllTask();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localPreloadQueue.addTask((png)paramList.next(), false);
      }
    }
    if (this.a.sn() > paramInt)
    {
      this.a.a(localPreloadQueue);
      paramBoolean = true;
    }
    for (;;)
    {
      boolean bool = paramBoolean;
      if (localpng2 != null)
      {
        bool = paramBoolean;
        if (localpng1 != null)
        {
          bool = paramBoolean;
          if (localpng1.equals(localpng2)) {
            bool = false;
          }
        }
      }
      if (!bool) {
        break;
      }
      this.a.c(localpng2);
      break;
    }
  }
  
  public void ff(long paramLong)
  {
    this.mStopRunnable = new PreloadDownloaderManager.1(this);
    ThreadManager.getUIHandler().postDelayed(this.mStopRunnable, paramLong);
  }
  
  public void onDestroy()
  {
    ff(10L);
  }
  
  public void onInit()
  {
    this.a.a(this.b);
    this.a.a((PreloadQueue)this.mo.get(0));
  }
  
  /* Error */
  public void vQ(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	pnm:mo	Ljava/util/List;
    //   6: iload_1
    //   7: invokeinterface 109 2 0
    //   12: checkcast 111	com/tencent/biz/qqstory/base/preload/PreloadQueue
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +30 -> 47
    //   20: ldc 87
    //   22: new 113	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   29: ldc 116
    //   31: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 130	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 36	pnm:a	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   51: invokevirtual 158	com/tencent/biz/qqstory/base/preload/PreloadDownloader:sn	()I
    //   54: istore_2
    //   55: aload_0
    //   56: getfield 36	pnm:a	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   59: invokevirtual 133	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Lpng;
    //   62: astore 4
    //   64: aload_3
    //   65: invokevirtual 136	com/tencent/biz/qqstory/base/preload/PreloadQueue:clearAllTask	()V
    //   68: ldc 87
    //   70: new 113	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   77: ldc 192
    //   79: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload_1
    //   83: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 194
    //   88: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_2
    //   92: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 196	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iload_2
    //   102: iload_1
    //   103: if_icmpne -59 -> 44
    //   106: aload_0
    //   107: getfield 36	pnm:a	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   110: aload 4
    //   112: invokevirtual 168	com/tencent/biz/qqstory/base/preload/PreloadDownloader:c	(Lpng;)V
    //   115: goto -71 -> 44
    //   118: astore_3
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_3
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	pnm
    //   0	123	1	paramInt	int
    //   54	50	2	i	int
    //   15	50	3	localPreloadQueue	PreloadQueue
    //   118	4	3	localObject	Object
    //   62	49	4	localpng	png
    // Exception table:
    //   from	to	target	type
    //   2	16	118	finally
    //   20	44	118	finally
    //   47	101	118	finally
    //   106	115	118	finally
  }
  
  public static abstract interface a
  {
    public abstract void vR(int paramInt);
  }
  
  @TargetApi(14)
  public class b
    implements pnm.a
  {
    public b() {}
    
    public void vR(int paramInt)
    {
      int i = paramInt + 1;
      if (i < pnm.this.mo.size())
      {
        PreloadQueue localPreloadQueue = (PreloadQueue)pnm.this.mo.get(i);
        ram.d("Q.qqstory.download.preload.PreloadDownloaderManager", "queue " + paramInt + " download completed , turn to " + localPreloadQueue.getId());
        pnm.this.a.a(localPreloadQueue);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnm
 * JD-Core Version:    0.7.0.1
 */