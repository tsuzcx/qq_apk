package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeAmb<T>
  implements Observable.OnSubscribe<T>
{
  final Iterable<? extends Observable<? extends T>> sources;
  
  private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return new OnSubscribeAmb(paramIterable);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    localArrayList.add(paramObservable8);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    localArrayList.add(paramObservable8);
    localArrayList.add(paramObservable9);
    return amb(localArrayList);
  }
  
  static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> paramCollection)
  {
    if (!paramCollection.isEmpty())
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext()) {
        ((AmbSubscriber)localIterator.next()).unsubscribe();
      }
      paramCollection.clear();
    }
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Selection localSelection = new Selection(null);
    AtomicReference localAtomicReference = localSelection.choice;
    paramSubscriber.add(Subscriptions.create(new OnSubscribeAmb.1(this, localAtomicReference, localSelection)));
    Iterator localIterator = this.sources.iterator();
    for (;;)
    {
      Observable localObservable;
      if (localIterator.hasNext())
      {
        localObservable = (Observable)localIterator.next();
        if (!paramSubscriber.isUnsubscribed()) {}
      }
      else
      {
        if (paramSubscriber.isUnsubscribed()) {
          unsubscribeAmbSubscribers(localSelection.ambSubscribers);
        }
        paramSubscriber.setProducer(new OnSubscribeAmb.2(this, localAtomicReference, localSelection));
        return;
      }
      AmbSubscriber localAmbSubscriber1 = new AmbSubscriber(0L, paramSubscriber, localSelection);
      localSelection.ambSubscribers.add(localAmbSubscriber1);
      AmbSubscriber localAmbSubscriber2 = (AmbSubscriber)localAtomicReference.get();
      if (localAmbSubscriber2 != null)
      {
        localSelection.unsubscribeOthers(localAmbSubscriber2);
        return;
      }
      localObservable.unsafeSubscribe(localAmbSubscriber1);
    }
  }
  
  static final class AmbSubscriber<T>
    extends Subscriber<T>
  {
    private boolean chosen;
    private final OnSubscribeAmb.Selection<T> selection;
    private final Subscriber<? super T> subscriber;
    
    AmbSubscriber(long paramLong, Subscriber<? super T> paramSubscriber, OnSubscribeAmb.Selection<T> paramSelection)
    {
      this.subscriber = paramSubscriber;
      this.selection = paramSelection;
      request(paramLong);
    }
    
    private boolean isSelected()
    {
      if (this.chosen) {
        return true;
      }
      if (this.selection.choice.get() == this)
      {
        this.chosen = true;
        return true;
      }
      if (this.selection.choice.compareAndSet(null, this))
      {
        this.selection.unsubscribeOthers(this);
        this.chosen = true;
        return true;
      }
      this.selection.unsubscribeLosers();
      return false;
    }
    
    private void requestMore(long paramLong)
    {
      request(paramLong);
    }
    
    public void onCompleted()
    {
      if (!isSelected()) {
        return;
      }
      this.subscriber.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!isSelected()) {
        return;
      }
      this.subscriber.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!isSelected()) {
        return;
      }
      this.subscriber.onNext(paramT);
    }
  }
  
  static class Selection<T>
  {
    final Collection<OnSubscribeAmb.AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();
    final AtomicReference<OnSubscribeAmb.AmbSubscriber<T>> choice = new AtomicReference();
    
    public void unsubscribeLosers()
    {
      OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)this.choice.get();
      if (localAmbSubscriber != null) {
        unsubscribeOthers(localAmbSubscriber);
      }
    }
    
    public void unsubscribeOthers(OnSubscribeAmb.AmbSubscriber<T> paramAmbSubscriber)
    {
      Iterator localIterator = this.ambSubscribers.iterator();
      while (localIterator.hasNext())
      {
        OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)localIterator.next();
        if (localAmbSubscriber != paramAmbSubscriber) {
          localAmbSubscriber.unsubscribe();
        }
      }
      this.ambSubscribers.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb
 * JD-Core Version:    0.7.0.1
 */