import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class pou<T extends pov>
  extends prz
  implements pow
{
  public BasePublishTask<T> b;
  public ArrayList<T> cF = new ArrayList();
  public ArrayList<T> mD = new ArrayList();
  
  private void c(ErrorMessage paramErrorMessage)
  {
    try
    {
      Iterator localIterator = this.cF.iterator();
      while (localIterator.hasNext())
      {
        pov localpov = (pov)localIterator.next();
        localpov.status = 6;
        localpov.result = paramErrorMessage;
        this.mD.add(localpov);
        a(localpov);
      }
      this.cF.clear();
    }
    finally {}
  }
  
  protected abstract BasePublishTask a(T paramT);
  
  protected void a(BasePublishTask<T> paramBasePublishTask)
  {
    try
    {
      if (this.b == paramBasePublishTask) {
        this.b = null;
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
      ram.e("Q.qqstory.publish.upload:BasePublishTaskManager", "running publish task is null, when finish publish");
      return;
    }
    pov localpov = paramBasePublishTask.a();
    paramBasePublishTask.a().result = paramErrorMessage;
    if ((localpov.status == 6) || (localpov.status == 5) || (localpov.status == 3) || (localpov.status == 7))
    {
      ram.i("Q.qqstory.publish.upload:BasePublishTaskManager", "finish task:" + paramBasePublishTask);
      if (localpov.status != 5) {
        ram.w("Q.qqstory.publish.upload:BasePublishTaskManager", "task fail:" + paramBasePublishTask);
      }
      if (paramErrorMessage.errorCode != 10406) {
        break label147;
      }
      a(paramBasePublishTask);
      c(paramErrorMessage);
    }
    for (;;)
    {
      b(localpov, paramErrorMessage);
      a(localpov);
      return;
      label147:
      a(paramBasePublishTask);
      bmk();
    }
  }
  
  protected abstract void a(T paramT);
  
  protected abstract void a(T paramT, ErrorMessage paramErrorMessage);
  
  /* Error */
  protected void b(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	pou:mD	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 127	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 23	pou:cF	Ljava/util/ArrayList;
    //   15: aload_1
    //   16: invokevirtual 130	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   19: ifeq +13 -> 32
    //   22: ldc 72
    //   24: ldc 132
    //   26: invokestatic 109	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 23	pou:cF	Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual 56	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	pou
    //   0	49	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  protected void b(T paramT, ErrorMessage paramErrorMessage)
  {
    if (isDestroy())
    {
      ram.i("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
      return;
    }
    try
    {
      this.mD.add(paramT);
      a(paramT, paramErrorMessage);
      return;
    }
    finally {}
  }
  
  protected void bmj()
  {
    try
    {
      if (this.b != null) {
        this.b.bmf();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void bmk()
  {
    Bosses.get().postLightWeightJob(new BasePublishTaskManager.1(this), 10);
  }
  
  public void bml()
  {
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          ram.i("Q.qqstory.publish.upload:BasePublishTaskManager", "task waiting list size:" + this.cF.size());
          return;
        }
        if (isDestroy())
        {
          ram.i("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
          continue;
        }
        if (this.cF.size() <= 0) {
          break label137;
        }
      }
      finally {}
      pov localpov = (pov)this.cF.remove(0);
      this.b = a(localpov);
      this.b.a(this);
      ram.i("Q.qqstory.publish.upload:BasePublishTaskManager", "start publish task:" + localpov);
      this.b.run();
      continue;
      label137:
      ram.i("Q.qqstory.publish.upload:BasePublishTaskManager", "--- no feeds need to post");
    }
  }
  
  protected void c(T paramT)
  {
    try
    {
      this.cF.remove(paramT);
      this.mD.remove(paramT);
      if ((this.b != null) && (this.b.a().equals(paramT))) {
        this.b.bme();
      }
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void dW(List<T> paramList)
  {
    try
    {
      this.mD.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bmj();
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pou
 * JD-Core Version:    0.7.0.1
 */