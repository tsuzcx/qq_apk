import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.1;
import com.tencent.biz.qqstory.base.preload.PreloadQueue;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

@TargetApi(14)
public class vna
  implements vuf
{
  public PreloadDownloader a;
  public Runnable a;
  public List<PreloadQueue> a;
  public vnb a;
  
  public vna()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader = new PreloadDownloader();
    this.jdField_a_of_type_Vnb = new vnc(this);
    Object localObject1 = new vnd();
    ((vnd)localObject1).a(0);
    localObject1 = ((vnd)localObject1).a();
    Object localObject2 = new vnd();
    ((vnd)localObject2).a(1);
    localObject2 = ((vnd)localObject2).a();
    Object localObject3 = new vnd();
    ((vnd)localObject3).a(2);
    localObject3 = ((vnd)localObject3).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(this.jdField_a_of_type_Vnb);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a((PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	vna:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: iload_1
    //   7: invokeinterface 59 2 0
    //   12: checkcast 61	com/tencent/biz/qqstory/base/preload/PreloadQueue
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +30 -> 47
    //   20: ldc 67
    //   22: new 69	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   29: ldc 72
    //   31: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 89	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 29	vna:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   51: invokevirtual 92	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()I
    //   54: istore_2
    //   55: aload_0
    //   56: getfield 29	vna:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   59: invokevirtual 95	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Lvmp;
    //   62: astore 4
    //   64: aload_3
    //   65: invokevirtual 98	com/tencent/biz/qqstory/base/preload/PreloadQueue:clearAllTask	()V
    //   68: ldc 67
    //   70: new 69	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   77: ldc 100
    //   79: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload_1
    //   83: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 102
    //   88: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_2
    //   92: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 105	xvv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iload_2
    //   102: iload_1
    //   103: if_icmpne -59 -> 44
    //   106: aload_0
    //   107: getfield 29	vna:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   110: aload 4
    //   112: invokevirtual 108	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	(Lvmp;)V
    //   115: goto -71 -> 44
    //   118: astore_3
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_3
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	vna
    //   0	123	1	paramInt	int
    //   54	50	2	i	int
    //   15	50	3	localPreloadQueue	PreloadQueue
    //   118	4	3	localObject	Object
    //   62	49	4	localvmp	vmp
    // Exception table:
    //   from	to	target	type
    //   2	16	118	finally
    //   20	44	118	finally
    //   47	101	118	finally
    //   106	115	118	finally
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaLangRunnable = new PreloadDownloaderManager.1(this);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(List<vmp> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {}
    PreloadQueue localPreloadQueue;
    for (;;)
    {
      return;
      try
      {
        xvv.d("Q.qqstory.download.preload.PreloadDownloaderManager", "setPreloadTaskList , id = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        localPreloadQueue = (PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localPreloadQueue == null) {
          xvv.d("Q.qqstory.download.preload.PreloadDownloaderManager", "cannot find queue , id = " + paramInt);
        }
      }
      finally {}
    }
    vmp localvmp2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
    if (paramList.size() == 0) {}
    for (vmp localvmp1 = null;; localvmp1 = (vmp)paramList.get(0))
    {
      localPreloadQueue.clearAllTask();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localPreloadQueue.addTask((vmp)paramList.next(), false);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a() > paramInt)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
      paramBoolean = true;
    }
    for (;;)
    {
      boolean bool = paramBoolean;
      if (localvmp2 != null)
      {
        bool = paramBoolean;
        if (localvmp1 != null)
        {
          bool = paramBoolean;
          if (localvmp1.equals(localvmp2)) {
            bool = false;
          }
        }
      }
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localvmp2);
      break;
    }
  }
  
  public void a(vmt paramvmt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(paramvmt);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangRunnable == null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a());
  }
  
  public void b()
  {
    a(10L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vna
 * JD-Core Version:    0.7.0.1
 */