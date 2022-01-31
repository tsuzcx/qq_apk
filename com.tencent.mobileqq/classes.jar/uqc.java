import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class uqc<T extends uqd>
  extends uuw
  implements uqe
{
  public BasePublishTask<T> a;
  public ArrayList<T> a;
  public ArrayList<T> b = new ArrayList();
  
  public uqc()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        uqd localuqd = (uqd)localIterator.next();
        localuqd.jdField_a_of_type_Int = 6;
        localuqd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
        this.b.add(localuqd);
        a(localuqd);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    finally {}
  }
  
  protected abstract BasePublishTask a(T paramT);
  
  public void a() {}
  
  protected void a(BasePublishTask<T> paramBasePublishTask)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == paramBasePublishTask) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = null;
      }
      return;
    }
    finally
    {
      paramBasePublishTask = finally;
      throw paramBasePublishTask;
    }
  }
  
  public final void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage)
  {
    if (paramBasePublishTask == null)
    {
      wxe.e("Q.qqstory.publish.upload:BasePublishTaskManager", "running publish task is null, when finish publish");
      return;
    }
    uqd localuqd = paramBasePublishTask.a();
    paramBasePublishTask.a().jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((localuqd.jdField_a_of_type_Int == 6) || (localuqd.jdField_a_of_type_Int == 5) || (localuqd.jdField_a_of_type_Int == 3) || (localuqd.jdField_a_of_type_Int == 7))
    {
      wxe.c("Q.qqstory.publish.upload:BasePublishTaskManager", "finish task:" + paramBasePublishTask);
      if (localuqd.jdField_a_of_type_Int != 5) {
        wxe.d("Q.qqstory.publish.upload:BasePublishTaskManager", "task fail:" + paramBasePublishTask);
      }
      if (paramErrorMessage.errorCode != 10406) {
        break label147;
      }
      a(paramBasePublishTask);
      a(paramErrorMessage);
    }
    for (;;)
    {
      b(localuqd, paramErrorMessage);
      a(localuqd);
      return;
      label147:
      a(paramBasePublishTask);
      d();
    }
  }
  
  public void a(List<T> paramList)
  {
    try
    {
      this.b.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  protected abstract void a(T paramT);
  
  protected abstract void a(T paramT, ErrorMessage paramErrorMessage);
  
  public void b()
  {
    super.b();
    c();
  }
  
  /* Error */
  protected void b(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	uqc:b	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 131	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 22	uqc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   15: aload_1
    //   16: invokevirtual 134	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   19: ifeq +13 -> 32
    //   22: ldc 67
    //   24: ldc 136
    //   26: invokestatic 104	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 22	uqc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual 52	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	uqc
    //   0	49	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  protected void b(T paramT, ErrorMessage paramErrorMessage)
  {
    if (b())
    {
      wxe.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
      return;
    }
    try
    {
      this.b.add(paramT);
      a(paramT, paramErrorMessage);
      return;
    }
    finally {}
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void c(T paramT)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramT);
      this.b.remove(paramT);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a().equals(paramT))) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a();
      }
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  protected void d()
  {
    Bosses.get().postLightWeightJob(new BasePublishTaskManager.1(this), 10);
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null)
        {
          wxe.c("Q.qqstory.publish.upload:BasePublishTaskManager", "task waiting list size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
          return;
        }
        if (b())
        {
          wxe.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label137;
        }
      }
      finally {}
      uqd localuqd = (uqd)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = a(localuqd);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a(this);
      wxe.c("Q.qqstory.publish.upload:BasePublishTaskManager", "start publish task:" + localuqd);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.run();
      continue;
      label137:
      wxe.c("Q.qqstory.publish.upload:BasePublishTaskManager", "--- no feeds need to post");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqc
 * JD-Core Version:    0.7.0.1
 */