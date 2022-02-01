package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.utils.AssertUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract interface Subscriber
{
  public abstract void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList);
  
  public abstract void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable);
  
  public static abstract class EventBatchSubscriber
    implements Subscriber, Subscriber.IDispatchableListener<Dispatcher.Dispatchable>
  {
    public final void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      Bosses.get().postLightWeightJob(new InnerJob(paramDispatchable), 0);
    }
    
    class InnerJob
      implements Runnable
    {
      private Dispatcher.Dispatchable mDispatchable;
      
      public InnerJob(Dispatcher.Dispatchable paramDispatchable)
      {
        this.mDispatchable = paramDispatchable;
      }
      
      public void run()
      {
        Subscriber.EventBatchSubscriber.this.onDispatch(this.mDispatchable);
      }
    }
  }
  
  public static class EventBatchSubscriberWrapper
    extends Subscriber.EventBatchSubscriber
  {
    private final Subscriber mSubscriber;
    
    public EventBatchSubscriberWrapper(Subscriber paramSubscriber)
    {
      AssertUtils.checkNotNull(paramSubscriber);
      this.mSubscriber = paramSubscriber;
    }
    
    public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
    {
      this.mSubscriber.accept(paramList);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof Subscriber.SubscriberWrapper)) {
        return Subscriber.SubscriberWrapper.access$000((Subscriber.SubscriberWrapper)paramObject).equals(this.mSubscriber);
      }
      if ((paramObject instanceof Subscriber.LooperSubscriber)) {
        return paramObject.equals(this.mSubscriber);
      }
      if ((paramObject instanceof Subscriber)) {
        return paramObject.equals(this.mSubscriber);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.mSubscriber.hashCode();
    }
    
    public void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      this.mSubscriber.handleDispatch(paramDispatchable);
    }
  }
  
  public static abstract interface IDispatchableListener<T extends Dispatcher.Dispatchable>
  {
    public abstract void onDispatch(@NonNull T paramT);
  }
  
  public static abstract class LooperSubscriber
    extends Handler
    implements Subscriber, Subscriber.IDispatchableListener<Dispatcher.Dispatchable>
  {
    private static final int REQUEST_SUBMIT = 1;
    
    public LooperSubscriber(Looper paramLooper)
    {
      super();
    }
    
    public void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      Message.obtain(this, 1, paramDispatchable).sendToTarget();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = paramMessage.obj;
      AssertUtils.checkNotNull(paramMessage);
      onDispatch((Dispatcher.Dispatchable)paramMessage);
    }
  }
  
  public static abstract class SingleEventSubscriber<EVENT extends Dispatcher.Dispatchable>
    extends Subscriber.LooperSubscriber
  {
    private Class clazz;
    
    public SingleEventSubscriber()
    {
      super();
      Type[] arrayOfType = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
      this.clazz = ((Class)arrayOfType[(arrayOfType.length - 1)]);
    }
    
    public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
    {
      paramList.add(this.clazz);
    }
    
    public final void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      onDispatch2(paramDispatchable);
    }
    
    protected abstract void onDispatch2(@NonNull EVENT paramEVENT);
  }
  
  public static abstract class SingleEventSubscriberNoRefect<EVENT extends Dispatcher.Dispatchable>
    extends Subscriber.LooperSubscriber
  {
    public SingleEventSubscriberNoRefect()
    {
      super();
    }
    
    public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
    {
      paramList.add(acceptEventClass());
    }
    
    public abstract Class acceptEventClass();
    
    public final void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      onDispatch2(paramDispatchable);
    }
    
    protected abstract void onDispatch2(@NonNull EVENT paramEVENT);
  }
  
  public static class SubscriberWrapper
    extends Subscriber.LooperSubscriber
  {
    private final Subscriber mSubscriber;
    
    public SubscriberWrapper(Looper paramLooper, Subscriber paramSubscriber)
    {
      super();
      AssertUtils.checkNotNull(paramSubscriber);
      this.mSubscriber = paramSubscriber;
    }
    
    public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
    {
      this.mSubscriber.accept(paramList);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if ((paramObject instanceof SubscriberWrapper)) {
        return (((SubscriberWrapper)paramObject).mSubscriber.equals(this.mSubscriber)) && (((SubscriberWrapper)paramObject).getLooper().equals(getLooper()));
      }
      if ((paramObject instanceof Subscriber.LooperSubscriber))
      {
        if ((paramObject.equals(this.mSubscriber)) && (((Subscriber.LooperSubscriber)paramObject).getLooper().equals(getLooper()))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      if ((paramObject instanceof Subscriber)) {
        return paramObject.equals(this.mSubscriber);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.mSubscriber.hashCode();
    }
    
    public void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      this.mSubscriber.handleDispatch(paramDispatchable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber
 * JD-Core Version:    0.7.0.1
 */