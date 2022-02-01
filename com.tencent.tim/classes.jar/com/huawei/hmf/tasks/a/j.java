package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class j
{
  public static <TResult> Task<TResult> a(TResult paramTResult)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setResult(paramTResult);
    return localTaskCompletionSource.getTask();
  }
  
  public static Task<List<Task<?>>> a(Collection<? extends Task<?>> paramCollection)
  {
    return c(paramCollection).continueWith(new j.2(paramCollection));
  }
  
  public static <TResult> TResult a(Task<TResult> paramTask)
    throws ExecutionException
  {
    if (paramTask.isSuccessful()) {
      return paramTask.getResult();
    }
    throw new ExecutionException(paramTask.getException());
  }
  
  public static void a(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static <TResult> Task<List<TResult>> b(Collection<? extends Task<?>> paramCollection)
  {
    return c(paramCollection).continueWith(new j.3(paramCollection));
  }
  
  public static Task<Void> c(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return a(null);
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Task)((Iterator)localObject).next() == null) {
        throw new NullPointerException("task can not is null");
      }
    }
    localObject = new i();
    e locale = new e(paramCollection.size(), (i)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Task localTask = (Task)paramCollection.next();
      localTask.addOnSuccessListener(TaskExecutors.immediate(), locale);
      localTask.addOnFailureListener(TaskExecutors.immediate(), locale);
      localTask.addOnCanceledListener(TaskExecutors.immediate(), locale);
    }
    return localObject;
  }
  
  public final <TResult> Task<TResult> a(Executor paramExecutor, Callable<TResult> paramCallable)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    try
    {
      paramExecutor.execute(new j.1(this, localTaskCompletionSource, paramCallable));
      return localTaskCompletionSource.getTask();
    }
    catch (Exception paramExecutor)
    {
      for (;;)
      {
        localTaskCompletionSource.setException(paramExecutor);
      }
    }
  }
  
  public static final class a<TResult>
    implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult>
  {
    public final CountDownLatch a = new CountDownLatch(1);
    
    public final void onCanceled()
    {
      this.a.countDown();
    }
    
    public final void onFailure(Exception paramException)
    {
      this.a.countDown();
    }
    
    public final void onSuccess(TResult paramTResult)
    {
      this.a.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.j
 * JD-Core Version:    0.7.0.1
 */