package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public final class AsyncSubject<T>
  extends Subject<T, T>
{
  volatile Object lastValue;
  private final NotificationLite<T> nl = NotificationLite.instance();
  final SubjectSubscriptionManager<T> state;
  
  protected AsyncSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager)
  {
    super(paramOnSubscribe);
    this.state = paramSubjectSubscriptionManager;
  }
  
  public static <T> AsyncSubject<T> create()
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onTerminated = new AsyncSubject.1(localSubjectSubscriptionManager);
    return new AsyncSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager);
  }
  
  @Beta
  public Throwable getThrowable()
  {
    Object localObject = this.state.getLatest();
    if (this.nl.isError(localObject)) {
      return this.nl.getError(localObject);
    }
    return null;
  }
  
  @Beta
  public T getValue()
  {
    Object localObject1 = this.lastValue;
    Object localObject2 = this.state.getLatest();
    if ((!this.nl.isError(localObject2)) && (this.nl.isNext(localObject1))) {
      return this.nl.getValue(localObject1);
    }
    return null;
  }
  
  @Beta
  public boolean hasCompleted()
  {
    Object localObject = this.state.getLatest();
    return (localObject != null) && (!this.nl.isError(localObject));
  }
  
  public boolean hasObservers()
  {
    return this.state.observers().length > 0;
  }
  
  @Beta
  public boolean hasThrowable()
  {
    Object localObject = this.state.getLatest();
    return this.nl.isError(localObject);
  }
  
  @Beta
  public boolean hasValue()
  {
    Object localObject1 = this.lastValue;
    Object localObject2 = this.state.getLatest();
    return (!this.nl.isError(localObject2)) && (this.nl.isNext(localObject1));
  }
  
  public void onCompleted()
  {
    if (this.state.active)
    {
      Object localObject2 = this.lastValue;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.nl.completed();
      }
      localObject2 = this.state.terminate(localObject1);
      int j = localObject2.length;
      int i = 0;
      if (i < j)
      {
        Object localObject3 = localObject2[i];
        if (localObject1 == this.nl.completed()) {
          localObject3.onCompleted();
        }
        for (;;)
        {
          i += 1;
          break;
          localObject3.onNext(this.nl.getValue(localObject1));
          localObject3.onCompleted();
        }
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.state.active)
    {
      Object localObject1 = this.nl.error(paramThrowable);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.state.terminate(localObject1);
      int j = arrayOfSubjectObserver.length;
      localObject1 = null;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject2 = arrayOfSubjectObserver[i];
          try
          {
            ((SubjectSubscriptionManager.SubjectObserver)localObject2).onError(paramThrowable);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new ArrayList();
              }
              ((List)localObject2).add(localThrowable);
              localObject1 = localObject2;
            }
          }
        }
      }
      Exceptions.throwIfAny(localObject1);
    }
  }
  
  public void onNext(T paramT)
  {
    this.lastValue = this.nl.next(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.subjects.AsyncSubject
 * JD-Core Version:    0.7.0.1
 */