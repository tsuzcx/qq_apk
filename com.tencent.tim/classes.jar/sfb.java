import NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedRsp;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.subscribe.other.story.BaseUploadVideoFeedTask;
import com.tencent.biz.subscribe.other.story.BaseUploadVideoManager.1;
import com.tencent.biz.subscribe.other.story.VSUploadVideoEntry;
import com.tencent.biz.subscribe.other.story.VSUploadVideoFeedTask;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public abstract class sfb
  extends prz
  implements sfd
{
  public BaseUploadVideoFeedTask a;
  public sfk a;
  public ArrayList<VSUploadVideoEntry> cF = new ArrayList();
  public Handler mTaskHandler;
  public ArrayList<VSUploadVideoEntry> nU = new ArrayList();
  public ArrayList<VSUploadVideoEntry> nV = new ArrayList();
  protected HandlerThread r = ThreadManager.newFreeHandlerThread("VSUploadTaskThread", 0);
  
  public sfb()
  {
    this.r.start();
    this.mTaskHandler = new Handler(this.r.getLooper());
    this.jdField_a_of_type_Sfk = new sfk();
  }
  
  /* Error */
  protected VSUploadVideoEntry a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	sfb:jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask	Lcom/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 66	sfb:jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask	Lcom/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask;
    //   13: getfield 71	com/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask:a	Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	sfb
    //   16	7	1	localVSUploadVideoEntry	VSUploadVideoEntry
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  /* Error */
  protected void a(BaseUploadVideoFeedTask paramBaseUploadVideoFeedTask, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp, ErrorMessage paramErrorMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	sfb:isDestroy	()Z
    //   4: ifeq +11 -> 15
    //   7: ldc 78
    //   9: ldc 80
    //   11: invokestatic 86	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: return
    //   15: ldc 2
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 66	sfb:jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask	Lcom/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask;
    //   22: aload_1
    //   23: if_acmpne +8 -> 31
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 66	sfb:jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask	Lcom/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask;
    //   31: aload_1
    //   32: getfield 71	com/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask:a	Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;
    //   35: invokevirtual 91	com/tencent/biz/subscribe/other/story/VSUploadVideoEntry:isSuccess	()Z
    //   38: ifeq +29 -> 67
    //   41: aload_0
    //   42: getfield 29	sfb:nU	Ljava/util/ArrayList;
    //   45: aload_1
    //   46: getfield 71	com/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask:a	Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;
    //   49: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: aload_1
    //   58: getfield 71	com/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask:a	Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 98	sfb:a	(Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;LNS_QQ_STORY_CLIENT/CLIENT$StPublishStoryFeedRsp;Lcom/tencent/biz/qqstory/base/ErrorMessage;)V
    //   66: return
    //   67: aload_0
    //   68: getfield 31	sfb:nV	Ljava/util/ArrayList;
    //   71: aload_1
    //   72: getfield 71	com/tencent/biz/subscribe/other/story/BaseUploadVideoFeedTask:a	Lcom/tencent/biz/subscribe/other/story/VSUploadVideoEntry;
    //   75: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	sfb
    //   0	88	1	paramBaseUploadVideoFeedTask	BaseUploadVideoFeedTask
    //   0	88	2	paramStPublishStoryFeedRsp	CLIENT.StPublishStoryFeedRsp
    //   0	88	3	paramErrorMessage	ErrorMessage
    // Exception table:
    //   from	to	target	type
    //   18	31	82	finally
    //   31	53	82	finally
    //   53	56	82	finally
    //   67	79	82	finally
    //   83	86	82	finally
  }
  
  public void a(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    if (paramVSUploadVideoEntry == null) {}
    for (;;)
    {
      return;
      try
      {
        this.nU.remove(paramVSUploadVideoEntry);
        this.nV.remove(paramVSUploadVideoEntry);
        if (this.cF.contains(paramVSUploadVideoEntry))
        {
          ram.w("Q.videostory.publish.upload.BaseUploadVideoManager", "addTask() the task is already exist ");
          continue;
        }
      }
      finally {}
      this.cF.add(paramVSUploadVideoEntry);
    }
  }
  
  protected abstract void a(VSUploadVideoEntry paramVSUploadVideoEntry, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp, ErrorMessage paramErrorMessage);
  
  public void b(BaseUploadVideoFeedTask paramBaseUploadVideoFeedTask, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp, ErrorMessage paramErrorMessage)
  {
    if (paramBaseUploadVideoFeedTask == null)
    {
      ram.e("Q.videostory.publish.upload.BaseUploadVideoManager", "running publish task is null, when finish publish");
      return;
    }
    a(paramBaseUploadVideoFeedTask, paramStPublishStoryFeedRsp, paramErrorMessage);
    bmk();
  }
  
  public void b(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    try
    {
      this.cF.remove(paramVSUploadVideoEntry);
      this.nU.remove(paramVSUploadVideoEntry);
      this.nV.remove(paramVSUploadVideoEntry);
      if ((this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask != null) && (this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.a.equals(paramVSUploadVideoEntry)))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.bme();
        this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask = null;
      }
      return;
    }
    finally
    {
      paramVSUploadVideoEntry = finally;
      throw paramVSUploadVideoEntry;
    }
  }
  
  protected void bmj()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.bme();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void bmk()
  {
    if (this.mTaskHandler == null)
    {
      ram.i("Q.videostory.publish.upload.BaseUploadVideoManager", "mTaskHandler == null");
      return;
    }
    this.mTaskHandler.postDelayed(new BaseUploadVideoManager.1(this), 100L);
  }
  
  public void bml()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask != null)
        {
          ram.i("Q.videostory.publish.upload.BaseUploadVideoManager", "doTaskRun() task waiting list size=" + this.cF.size());
          return;
        }
        if (isDestroy())
        {
          ram.i("Q.videostory.publish.upload.BaseUploadVideoManager", "doTaskRun() manager had stopped");
          continue;
        }
        if (this.cF.size() <= 0) {
          break label162;
        }
      }
      finally {}
      VSUploadVideoEntry localVSUploadVideoEntry = (VSUploadVideoEntry)this.cF.remove(0);
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask = new VSUploadVideoFeedTask(localVSUploadVideoEntry);
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.a(this, this.mTaskHandler);
      ram.i("Q.videostory.publish.upload.BaseUploadVideoManager", "[vs_publish_flow] doTaskRun() start publish task , fakeId=" + localVSUploadVideoEntry.fakeId + " , waiting list size=" + this.cF.size());
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryBaseUploadVideoFeedTask.run();
      continue;
      label162:
      ram.i("Q.videostory.publish.upload.BaseUploadVideoManager", "doTaskRun() --- no feeds need to post");
    }
  }
  
  public ArrayList<VSUploadVideoEntry> by()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.nV);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ArrayList<VSUploadVideoEntry> bz()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cF);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    if (paramVSUploadVideoEntry == null)
    {
      ram.e("Q.videostory.publish.upload.BaseUploadVideoManager", "onTaskChange() running publish task is null");
      return;
    }
    d(paramVSUploadVideoEntry);
  }
  
  protected abstract void d(VSUploadVideoEntry paramVSUploadVideoEntry);
  
  public void onDestroy()
  {
    super.onDestroy();
    bmj();
    if (this.mTaskHandler != null)
    {
      this.mTaskHandler.removeCallbacksAndMessages(null);
      this.mTaskHandler = null;
    }
    if (this.r != null)
    {
      this.r.quit();
      this.r = null;
    }
    if (this.jdField_a_of_type_Sfk != null) {
      this.jdField_a_of_type_Sfk.byl();
    }
    sfl.a().blZ();
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfb
 * JD-Core Version:    0.7.0.1
 */