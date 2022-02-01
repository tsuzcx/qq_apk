package com.tencent.biz.qqstory.base.videoupload.task;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pos;
import pov;
import pow;
import ram;

public abstract class BasePublishTask<T extends pov>
  implements Runnable
{
  public static final Boolean P = Boolean.valueOf(false);
  public T a;
  public pow a;
  public AtomicBoolean aI = new AtomicBoolean(false);
  public int bjI = 7;
  public ArrayList<ErrorMessage> mB = new ArrayList();
  public ArrayList<Stream> mC = new ArrayList();
  
  public BasePublishTask(T paramT)
  {
    this.jdField_a_of_type_Pov = paramT;
  }
  
  private void bmh()
  {
    if (this.aI.get())
    {
      ram.w("Q.qqstory.publish.upload:BasePublishTask", "stop task in send rich data:" + this);
      a(this.bjI, new ErrorMessage());
      return;
    }
    a(1, new ErrorMessage());
    if (this.jdField_a_of_type_Pov.ms.size() == 0)
    {
      bmi();
      return;
    }
    try
    {
      Iterator localIterator = this.jdField_a_of_type_Pov.ms.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (pos)localIterator.next();
        localObject2 = Stream.of(new ErrorMessage()).map(new ThreadOffFunction("Q.qqstory.publish.upload:BasePublishTask", 4)).map((StreamFunction)localObject2);
        ((Stream)localObject2).subscribe(new a(null));
        this.mC.add(localObject2);
        ram.i("Q.qqstory.publish.upload:BasePublishTask", "add task finish");
      }
    }
    finally {}
  }
  
  private void bmi()
  {
    if (isStop())
    {
      a(this.bjI, new ErrorMessage());
      return;
    }
    a(2, new ErrorMessage());
    a(4, new ErrorMessage());
    bmg();
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Pov;
  }
  
  public void a(int paramInt, ErrorMessage paramErrorMessage)
  {
    ram.i("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:" + this.jdField_a_of_type_Pov);
    if (paramErrorMessage.isFail()) {
      ram.w("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:%s with fail result: %s", new Object[] { this.jdField_a_of_type_Pov, paramErrorMessage });
    }
    if (isStop()) {
      paramInt = this.bjI;
    }
    this.jdField_a_of_type_Pov.status = paramInt;
    if (this.jdField_a_of_type_Pow != null) {
      this.jdField_a_of_type_Pow.a(this, paramErrorMessage);
    }
  }
  
  protected void a(ErrorMessage paramErrorMessage)
  {
    this.mB.add(paramErrorMessage);
    ram.w("Q.qqstory.publish.upload:BasePublishTask", "not finish file count:%d, one file finish with result:%s", new Object[] { Integer.valueOf(this.mC.size() - this.mB.size()), paramErrorMessage });
    if (this.mB.size() >= this.mC.size())
    {
      paramErrorMessage = new ErrorMessage();
      Iterator localIterator = this.mB.iterator();
      while (localIterator.hasNext())
      {
        ErrorMessage localErrorMessage = (ErrorMessage)localIterator.next();
        if (localErrorMessage.isFail()) {
          paramErrorMessage = localErrorMessage;
        }
      }
    }
    for (;;)
    {
      if (isStop())
      {
        a(this.bjI, paramErrorMessage);
        return;
      }
      if (paramErrorMessage.isSuccess())
      {
        a(2, paramErrorMessage);
        bmi();
        return;
      }
      a(3, paramErrorMessage);
      return;
    }
  }
  
  public void a(pow parampow)
  {
    this.jdField_a_of_type_Pow = parampow;
  }
  
  public void bme()
  {
    ram.w("Q.qqstory.publish.upload:BasePublishTask", "user try to stop task" + this);
    this.bjI = 7;
    this.aI.set(true);
    try
    {
      Iterator localIterator = this.mC.iterator();
      while (localIterator.hasNext()) {
        ((Stream)localIterator.next()).cancel();
      }
    }
    finally {}
    a(this.bjI, new ErrorMessage());
  }
  
  public void bmf()
  {
    ram.w("Q.qqstory.publish.upload:BasePublishTask", "user try to force stop task" + this);
    this.bjI = 3;
    this.aI.set(true);
    try
    {
      Iterator localIterator = this.mC.iterator();
      while (localIterator.hasNext()) {
        ((Stream)localIterator.next()).cancel();
      }
    }
    finally {}
  }
  
  protected abstract void bmg();
  
  public boolean isStop()
  {
    return this.aI.get();
  }
  
  public void run()
  {
    bmh();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BasePublishTask{");
    localStringBuilder.append("mTaskInfo=").append(this.jdField_a_of_type_Pov);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  class a
    extends SimpleObserver<ErrorMessage>
  {
    private a() {}
    
    public void b(ErrorMessage paramErrorMessage)
    {
      if (paramErrorMessage.isSuccess())
      {
        BasePublishTask.this.a(new ErrorMessage());
        return;
      }
      BasePublishTask.this.a(paramErrorMessage);
    }
    
    public void onCancel() {}
    
    public void onComplete() {}
    
    public void onError(@NonNull Error paramError)
    {
      if ((paramError instanceof ErrorMessage))
      {
        BasePublishTask.this.a((ErrorMessage)paramError);
        return;
      }
      BasePublishTask.this.a(new ErrorMessage(940005, "upload file fail:" + paramError));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask
 * JD-Core Version:    0.7.0.1
 */