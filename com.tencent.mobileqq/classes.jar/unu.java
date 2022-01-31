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
public class unu
  implements uvi
{
  public PreloadDownloader a;
  public Runnable a;
  public List<PreloadQueue> a;
  public unv a;
  
  public unu()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader = new PreloadDownloader();
    this.jdField_a_of_type_Unv = new unw(this);
    Object localObject1 = new unx();
    ((unx)localObject1).a(0);
    localObject1 = ((unx)localObject1).a();
    Object localObject2 = new unx();
    ((unx)localObject2).a(1);
    localObject2 = ((unx)localObject2).a();
    Object localObject3 = new unx();
    ((unx)localObject3).a(2);
    localObject3 = ((unx)localObject3).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(this.jdField_a_of_type_Unv);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a((PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	unu:jdField_a_of_type_JavaUtilList	Ljava/util/List;
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
    //   41: invokestatic 89	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 29	unu:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   51: invokevirtual 92	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()I
    //   54: istore_2
    //   55: aload_0
    //   56: getfield 29	unu:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   59: invokevirtual 95	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	()Lunj;
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
    //   98: invokestatic 105	wxe:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iload_2
    //   102: iload_1
    //   103: if_icmpne -59 -> 44
    //   106: aload_0
    //   107: getfield 29	unu:jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader	Lcom/tencent/biz/qqstory/base/preload/PreloadDownloader;
    //   110: aload 4
    //   112: invokevirtual 108	com/tencent/biz/qqstory/base/preload/PreloadDownloader:a	(Lunj;)V
    //   115: goto -71 -> 44
    //   118: astore_3
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_3
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	unu
    //   0	123	1	paramInt	int
    //   54	50	2	i	int
    //   15	50	3	localPreloadQueue	PreloadQueue
    //   118	4	3	localObject	Object
    //   62	49	4	localunj	unj
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
  
  public void a(List<unj> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {}
    PreloadQueue localPreloadQueue;
    for (;;)
    {
      return;
      try
      {
        wxe.d("Q.qqstory.download.preload.PreloadDownloaderManager", "setPreloadTaskList , id = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        localPreloadQueue = (PreloadQueue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localPreloadQueue == null) {
          wxe.d("Q.qqstory.download.preload.PreloadDownloaderManager", "cannot find queue , id = " + paramInt);
        }
      }
      finally {}
    }
    unj localunj2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a();
    if (paramList.size() == 0) {}
    for (unj localunj1 = null;; localunj1 = (unj)paramList.get(0))
    {
      localPreloadQueue.clearAllTask();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localPreloadQueue.addTask((unj)paramList.next(), false);
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
      if (localunj2 != null)
      {
        bool = paramBoolean;
        if (localunj1 != null)
        {
          bool = paramBoolean;
          if (localunj1.equals(localunj2)) {
            bool = false;
          }
        }
      }
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localunj2);
      break;
    }
  }
  
  public void a(unn paramunn)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(paramunn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unu
 * JD-Core Version:    0.7.0.1
 */