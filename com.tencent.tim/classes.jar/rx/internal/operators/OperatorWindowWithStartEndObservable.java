package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V>
  implements Observable.Operator<Observable<T>, T>
{
  final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
  final Observable<? extends U> windowOpenings;
  
  public OperatorWindowWithStartEndObservable(Observable<? extends U> paramObservable, Func1<? super U, ? extends Observable<? extends V>> paramFunc1)
  {
    this.windowOpenings = paramObservable;
    this.windowClosingSelector = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    paramSubscriber.add(localCompositeSubscription);
    paramSubscriber = new SourceSubscriber(paramSubscriber, localCompositeSubscription);
    OperatorWindowWithStartEndObservable.1 local1 = new OperatorWindowWithStartEndObservable.1(this, paramSubscriber);
    localCompositeSubscription.add(paramSubscriber);
    localCompositeSubscription.add(local1);
    this.windowOpenings.unsafeSubscribe(local1);
    return paramSubscriber;
  }
  
  static final class SerializedSubject<T>
  {
    final Observer<T> consumer;
    final Observable<T> producer;
    
    public SerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      this.consumer = new SerializedObserver(paramObserver);
      this.producer = paramObservable;
    }
  }
  
  final class SourceSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    final List<OperatorWindowWithStartEndObservable.SerializedSubject<T>> chunks;
    final CompositeSubscription csub;
    boolean done;
    final Object guard;
    
    public SourceSubscriber(CompositeSubscription paramCompositeSubscription)
    {
      this.child = new SerializedSubscriber(paramCompositeSubscription);
      this.guard = new Object();
      this.chunks = new LinkedList();
      Object localObject;
      this.csub = localObject;
    }
    
    void beginWindow(U paramU)
    {
      Object localObject1 = createSerializedSubject();
      synchronized (this.guard)
      {
        if (this.done) {
          return;
        }
        this.chunks.add(localObject1);
        this.child.onNext(((OperatorWindowWithStartEndObservable.SerializedSubject)localObject1).producer);
      }
    }
    
    OperatorWindowWithStartEndObservable.SerializedSubject<T> createSerializedSubject()
    {
      UnicastSubject localUnicastSubject = UnicastSubject.create();
      return new OperatorWindowWithStartEndObservable.SerializedSubject(localUnicastSubject, localUnicastSubject);
    }
    
    void endWindow(OperatorWindowWithStartEndObservable.SerializedSubject<T> paramSerializedSubject)
    {
      for (;;)
      {
        synchronized (this.guard)
        {
          if (this.done) {
            return;
          }
          Iterator localIterator = this.chunks.iterator();
          if (localIterator.hasNext())
          {
            if ((OperatorWindowWithStartEndObservable.SerializedSubject)localIterator.next() != paramSerializedSubject) {
              continue;
            }
            i = 1;
            localIterator.remove();
            if (i == 0) {
              break;
            }
            paramSerializedSubject.consumer.onCompleted();
            return;
          }
        }
        int i = 0;
      }
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 41	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:guard	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 61	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:done	Z
      //   11: ifeq +13 -> 24
      //   14: aload_1
      //   15: monitorexit
      //   16: aload_0
      //   17: getfield 48	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:csub	Lrx/subscriptions/CompositeSubscription;
      //   20: invokevirtual 149	rx/subscriptions/CompositeSubscription:unsubscribe	()V
      //   23: return
      //   24: aload_0
      //   25: iconst_1
      //   26: putfield 61	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:done	Z
      //   29: new 151	java/util/ArrayList
      //   32: dup
      //   33: aload_0
      //   34: getfield 46	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:chunks	Ljava/util/List;
      //   37: invokespecial 154	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
      //   40: astore_2
      //   41: aload_0
      //   42: getfield 46	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:chunks	Ljava/util/List;
      //   45: invokeinterface 157 1 0
      //   50: aload_1
      //   51: monitorexit
      //   52: aload_2
      //   53: invokeinterface 123 1 0
      //   58: astore_1
      //   59: aload_1
      //   60: invokeinterface 129 1 0
      //   65: ifeq +38 -> 103
      //   68: aload_1
      //   69: invokeinterface 133 1 0
      //   74: checkcast 69	rx/internal/operators/OperatorWindowWithStartEndObservable$SerializedSubject
      //   77: getfield 140	rx/internal/operators/OperatorWindowWithStartEndObservable$SerializedSubject:consumer	Lrx/Observer;
      //   80: invokeinterface 145 1 0
      //   85: goto -26 -> 59
      //   88: astore_1
      //   89: aload_0
      //   90: getfield 48	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:csub	Lrx/subscriptions/CompositeSubscription;
      //   93: invokevirtual 149	rx/subscriptions/CompositeSubscription:unsubscribe	()V
      //   96: aload_1
      //   97: athrow
      //   98: astore_2
      //   99: aload_1
      //   100: monitorexit
      //   101: aload_2
      //   102: athrow
      //   103: aload_0
      //   104: getfield 36	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:child	Lrx/Subscriber;
      //   107: invokevirtual 158	rx/Subscriber:onCompleted	()V
      //   110: aload_0
      //   111: getfield 48	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:csub	Lrx/subscriptions/CompositeSubscription;
      //   114: invokevirtual 149	rx/subscriptions/CompositeSubscription:unsubscribe	()V
      //   117: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	118	0	this	SourceSubscriber
      //   88	12	1	localObject2	Object
      //   40	13	2	localArrayList	ArrayList
      //   98	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   0	7	88	finally
      //   52	59	88	finally
      //   59	85	88	finally
      //   101	103	88	finally
      //   103	110	88	finally
      //   7	16	98	finally
      //   24	52	98	finally
      //   99	101	98	finally
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 41	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:guard	Ljava/lang/Object;
      //   4: astore_2
      //   5: aload_2
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 61	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:done	Z
      //   11: ifeq +13 -> 24
      //   14: aload_2
      //   15: monitorexit
      //   16: aload_0
      //   17: getfield 48	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:csub	Lrx/subscriptions/CompositeSubscription;
      //   20: invokevirtual 149	rx/subscriptions/CompositeSubscription:unsubscribe	()V
      //   23: return
      //   24: aload_0
      //   25: iconst_1
      //   26: putfield 61	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:done	Z
      //   29: new 151	java/util/ArrayList
      //   32: dup
      //   33: aload_0
      //   34: getfield 46	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:chunks	Ljava/util/List;
      //   37: invokespecial 154	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
      //   40: astore_3
      //   41: aload_0
      //   42: getfield 46	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:chunks	Ljava/util/List;
      //   45: invokeinterface 157 1 0
      //   50: aload_2
      //   51: monitorexit
      //   52: aload_3
      //   53: invokeinterface 123 1 0
      //   58: astore_2
      //   59: aload_2
      //   60: invokeinterface 129 1 0
      //   65: ifeq +39 -> 104
      //   68: aload_2
      //   69: invokeinterface 133 1 0
      //   74: checkcast 69	rx/internal/operators/OperatorWindowWithStartEndObservable$SerializedSubject
      //   77: getfield 140	rx/internal/operators/OperatorWindowWithStartEndObservable$SerializedSubject:consumer	Lrx/Observer;
      //   80: aload_1
      //   81: invokeinterface 159 2 0
      //   86: goto -27 -> 59
      //   89: astore_1
      //   90: aload_0
      //   91: getfield 48	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:csub	Lrx/subscriptions/CompositeSubscription;
      //   94: invokevirtual 149	rx/subscriptions/CompositeSubscription:unsubscribe	()V
      //   97: aload_1
      //   98: athrow
      //   99: astore_1
      //   100: aload_2
      //   101: monitorexit
      //   102: aload_1
      //   103: athrow
      //   104: aload_0
      //   105: getfield 36	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:child	Lrx/Subscriber;
      //   108: aload_1
      //   109: invokevirtual 160	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
      //   112: aload_0
      //   113: getfield 48	rx/internal/operators/OperatorWindowWithStartEndObservable$SourceSubscriber:csub	Lrx/subscriptions/CompositeSubscription;
      //   116: invokevirtual 149	rx/subscriptions/CompositeSubscription:unsubscribe	()V
      //   119: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	SourceSubscriber
      //   0	120	1	paramThrowable	Throwable
      //   40	13	3	localArrayList	ArrayList
      // Exception table:
      //   from	to	target	type
      //   0	7	89	finally
      //   52	59	89	finally
      //   59	86	89	finally
      //   102	104	89	finally
      //   104	112	89	finally
      //   7	16	99	finally
      //   24	52	99	finally
      //   100	102	99	finally
    }
    
    public void onNext(T paramT)
    {
      synchronized (this.guard)
      {
        if (this.done) {
          return;
        }
        ArrayList localArrayList = new ArrayList(this.chunks);
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((OperatorWindowWithStartEndObservable.SerializedSubject)((Iterator)???).next()).consumer.onNext(paramT);
        }
      }
    }
    
    public void onStart()
    {
      request(9223372036854775807L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable
 * JD-Core Version:    0.7.0.1
 */