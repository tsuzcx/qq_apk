package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class OperatorMulticast<T, R>
  extends ConnectableObservable<R>
{
  final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
  final Object guard;
  Subscription guardedSubscription;
  final Observable<? extends T> source;
  final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
  Subscriber<T> subscription;
  final List<Subscriber<? super R>> waitingForConnect;
  
  private OperatorMulticast(Object paramObject, AtomicReference<Subject<? super T, ? extends R>> paramAtomicReference, List<Subscriber<? super R>> paramList, Observable<? extends T> paramObservable, Func0<? extends Subject<? super T, ? extends R>> paramFunc0)
  {
    super(new OperatorMulticast.1(paramObject, paramAtomicReference, paramList));
    this.guard = paramObject;
    this.connectedSubject = paramAtomicReference;
    this.waitingForConnect = paramList;
    this.source = paramObservable;
    this.subjectFactory = paramFunc0;
  }
  
  public OperatorMulticast(Observable<? extends T> paramObservable, Func0<? extends Subject<? super T, ? extends R>> paramFunc0)
  {
    this(new Object(), new AtomicReference(), new ArrayList(), paramObservable, paramFunc0);
  }
  
  public void connect(Action1<? super Subscription> arg1)
  {
    Subject localSubject;
    synchronized (this.guard)
    {
      if (this.subscription != null)
      {
        ???.call(this.guardedSubscription);
        return;
      }
      localSubject = (Subject)this.subjectFactory.call();
      this.subscription = Subscribers.from(localSubject);
      Object localObject3 = new AtomicReference();
      ((AtomicReference)localObject3).set(Subscriptions.create(new OperatorMulticast.2(this, (AtomicReference)localObject3)));
      this.guardedSubscription = ((Subscription)((AtomicReference)localObject3).get());
      localObject3 = this.waitingForConnect.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        Subscriber localSubscriber = (Subscriber)((Iterator)localObject3).next();
        localSubject.unsafeSubscribe(new OperatorMulticast.3(this, localSubscriber, localSubscriber));
      }
    }
    this.waitingForConnect.clear();
    this.connectedSubject.set(localSubject);
    ???.call(this.guardedSubscription);
    synchronized (this.guard)
    {
      ??? = this.subscription;
      if (??? != null)
      {
        this.source.subscribe((Subscriber)???);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorMulticast
 * JD-Core Version:    0.7.0.1
 */