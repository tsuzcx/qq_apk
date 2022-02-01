package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.RefCountSubscription;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R>
  implements Observable.OnSubscribe<R>
{
  protected final Observable<T1> left;
  protected final Func1<? super T1, ? extends Observable<D1>> leftDuration;
  protected final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
  protected final Observable<T2> right;
  protected final Func1<? super T2, ? extends Observable<D2>> rightDuration;
  
  public OnSubscribeGroupJoin(Observable<T1> paramObservable, Observable<T2> paramObservable1, Func1<? super T1, ? extends Observable<D1>> paramFunc1, Func1<? super T2, ? extends Observable<D2>> paramFunc11, Func2<? super T1, ? super Observable<T2>, ? extends R> paramFunc2)
  {
    this.left = paramObservable;
    this.right = paramObservable1;
    this.leftDuration = paramFunc1;
    this.rightDuration = paramFunc11;
    this.resultSelector = paramFunc2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    ResultManager localResultManager = new ResultManager(new SerializedSubscriber(paramSubscriber));
    paramSubscriber.add(localResultManager);
    localResultManager.init();
  }
  
  final class ResultManager
    implements Subscription
  {
    final RefCountSubscription cancel;
    final CompositeSubscription group;
    final Object guard = new Object();
    boolean leftDone;
    int leftIds;
    final Map<Integer, Observer<T2>> leftMap = new HashMap();
    boolean rightDone;
    int rightIds;
    final Map<Integer, T2> rightMap = new HashMap();
    final Subscriber<? super R> subscriber;
    
    public ResultManager()
    {
      Object localObject;
      this.subscriber = localObject;
      this.group = new CompositeSubscription();
      this.cancel = new RefCountSubscription(this.group);
    }
    
    void complete(List<Observer<T2>> paramList)
    {
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          ((Observer)paramList.next()).onCompleted();
        }
        this.subscriber.onCompleted();
        this.cancel.unsubscribe();
      }
    }
    
    void errorAll(Throwable paramThrowable)
    {
      synchronized (this.guard)
      {
        ArrayList localArrayList = new ArrayList(this.leftMap.values());
        this.leftMap.clear();
        this.rightMap.clear();
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((Observer)((Iterator)???).next()).onError(paramThrowable);
        }
      }
      this.subscriber.onError(paramThrowable);
      this.cancel.unsubscribe();
    }
    
    void errorMain(Throwable paramThrowable)
    {
      synchronized (this.guard)
      {
        this.leftMap.clear();
        this.rightMap.clear();
        this.subscriber.onError(paramThrowable);
        this.cancel.unsubscribe();
        return;
      }
    }
    
    public void init()
    {
      LeftObserver localLeftObserver = new LeftObserver();
      RightObserver localRightObserver = new RightObserver();
      this.group.add(localLeftObserver);
      this.group.add(localRightObserver);
      OnSubscribeGroupJoin.this.left.unsafeSubscribe(localLeftObserver);
      OnSubscribeGroupJoin.this.right.unsafeSubscribe(localRightObserver);
    }
    
    public boolean isUnsubscribed()
    {
      return this.cancel.isUnsubscribed();
    }
    
    public void unsubscribe()
    {
      this.cancel.unsubscribe();
    }
    
    final class LeftDurationObserver
      extends Subscriber<D1>
    {
      final int id;
      boolean once = true;
      
      public LeftDurationObserver(int paramInt)
      {
        this.id = paramInt;
      }
      
      public void onCompleted()
      {
        if (this.once) {
          this.once = false;
        }
        synchronized (OnSubscribeGroupJoin.ResultManager.this.guard)
        {
          Observer localObserver = (Observer)OnSubscribeGroupJoin.ResultManager.this.leftMap.remove(Integer.valueOf(this.id));
          if (localObserver != null) {
            localObserver.onCompleted();
          }
          OnSubscribeGroupJoin.ResultManager.this.group.remove(this);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorMain(paramThrowable);
      }
      
      public void onNext(D1 paramD1)
      {
        onCompleted();
      }
    }
    
    final class LeftObserver
      extends Subscriber<T1>
    {
      LeftObserver() {}
      
      public void onCompleted()
      {
        ArrayList localArrayList = null;
        synchronized (OnSubscribeGroupJoin.ResultManager.this.guard)
        {
          OnSubscribeGroupJoin.ResultManager.this.leftDone = true;
          if (OnSubscribeGroupJoin.ResultManager.this.rightDone)
          {
            localArrayList = new ArrayList(OnSubscribeGroupJoin.ResultManager.this.leftMap.values());
            OnSubscribeGroupJoin.ResultManager.this.leftMap.clear();
            OnSubscribeGroupJoin.ResultManager.this.rightMap.clear();
          }
          OnSubscribeGroupJoin.ResultManager.this.complete(localArrayList);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorAll(paramThrowable);
      }
      
      /* Error */
      public void onNext(T1 arg1)
      {
        // Byte code:
        //   0: invokestatic 73	rx/subjects/PublishSubject:create	()Lrx/subjects/PublishSubject;
        //   3: astore 5
        //   5: new 75	rx/observers/SerializedObserver
        //   8: dup
        //   9: aload 5
        //   11: invokespecial 78	rx/observers/SerializedObserver:<init>	(Lrx/Observer;)V
        //   14: astore_3
        //   15: aload_0
        //   16: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   19: getfield 26	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:guard	Ljava/lang/Object;
        //   22: astore 4
        //   24: aload 4
        //   26: monitorenter
        //   27: aload_0
        //   28: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   31: astore 6
        //   33: aload 6
        //   35: getfield 82	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftIds	I
        //   38: istore_2
        //   39: aload 6
        //   41: iload_2
        //   42: iconst_1
        //   43: iadd
        //   44: putfield 82	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftIds	I
        //   47: aload_0
        //   48: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   51: getfield 39	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftMap	Ljava/util/Map;
        //   54: iload_2
        //   55: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   58: aload_3
        //   59: invokeinterface 92 3 0
        //   64: pop
        //   65: aload 4
        //   67: monitorexit
        //   68: new 94	rx/internal/operators/OnSubscribeGroupJoin$WindowObservableFunc
        //   71: dup
        //   72: aload 5
        //   74: aload_0
        //   75: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   78: getfield 98	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:cancel	Lrx/subscriptions/RefCountSubscription;
        //   81: invokespecial 101	rx/internal/operators/OnSubscribeGroupJoin$WindowObservableFunc:<init>	(Lrx/Observable;Lrx/subscriptions/RefCountSubscription;)V
        //   84: invokestatic 106	rx/Observable:create	(Lrx/Observable$OnSubscribe;)Lrx/Observable;
        //   87: astore 4
        //   89: aload_0
        //   90: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   93: getfield 110	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:this$0	Lrx/internal/operators/OnSubscribeGroupJoin;
        //   96: getfield 114	rx/internal/operators/OnSubscribeGroupJoin:leftDuration	Lrx/functions/Func1;
        //   99: aload_1
        //   100: invokeinterface 120 2 0
        //   105: checkcast 103	rx/Observable
        //   108: astore 5
        //   110: new 122	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftDurationObserver
        //   113: dup
        //   114: aload_0
        //   115: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   118: iload_2
        //   119: invokespecial 125	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftDurationObserver:<init>	(Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;I)V
        //   122: astore 6
        //   124: aload_0
        //   125: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   128: getfield 129	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:group	Lrx/subscriptions/CompositeSubscription;
        //   131: aload 6
        //   133: invokevirtual 135	rx/subscriptions/CompositeSubscription:add	(Lrx/Subscription;)V
        //   136: aload 5
        //   138: aload 6
        //   140: invokevirtual 139	rx/Observable:unsafeSubscribe	(Lrx/Subscriber;)Lrx/Subscription;
        //   143: pop
        //   144: aload_0
        //   145: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   148: getfield 110	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:this$0	Lrx/internal/operators/OnSubscribeGroupJoin;
        //   151: getfield 143	rx/internal/operators/OnSubscribeGroupJoin:resultSelector	Lrx/functions/Func2;
        //   154: aload_1
        //   155: aload 4
        //   157: invokeinterface 147 3 0
        //   162: astore 4
        //   164: aload_0
        //   165: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   168: getfield 26	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:guard	Ljava/lang/Object;
        //   171: astore_1
        //   172: aload_1
        //   173: monitorenter
        //   174: new 35	java/util/ArrayList
        //   177: dup
        //   178: aload_0
        //   179: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   182: getfield 54	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:rightMap	Ljava/util/Map;
        //   185: invokeinterface 45 1 0
        //   190: invokespecial 48	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
        //   193: astore 5
        //   195: aload_1
        //   196: monitorexit
        //   197: aload_0
        //   198: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   201: getfield 151	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:subscriber	Lrx/Subscriber;
        //   204: aload 4
        //   206: invokevirtual 153	rx/Subscriber:onNext	(Ljava/lang/Object;)V
        //   209: aload 5
        //   211: invokeinterface 159 1 0
        //   216: astore_1
        //   217: aload_1
        //   218: invokeinterface 165 1 0
        //   223: ifeq +24 -> 247
        //   226: aload_3
        //   227: aload_1
        //   228: invokeinterface 169 1 0
        //   233: invokeinterface 172 2 0
        //   238: goto -21 -> 217
        //   241: astore_1
        //   242: aload_1
        //   243: aload_0
        //   244: invokestatic 178	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
        //   247: return
        //   248: astore_1
        //   249: aload 4
        //   251: monitorexit
        //   252: aload_1
        //   253: athrow
        //   254: astore_3
        //   255: aload_1
        //   256: monitorexit
        //   257: aload_3
        //   258: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	259	0	this	LeftObserver
        //   38	81	2	i	int
        //   14	213	3	localSerializedObserver	rx.observers.SerializedObserver
        //   254	4	3	localObject1	Object
        //   3	207	5	localObject3	Object
        //   31	108	6	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   0	27	241	java/lang/Throwable
        //   68	174	241	java/lang/Throwable
        //   197	217	241	java/lang/Throwable
        //   217	238	241	java/lang/Throwable
        //   252	254	241	java/lang/Throwable
        //   257	259	241	java/lang/Throwable
        //   27	68	248	finally
        //   249	252	248	finally
        //   174	197	254	finally
        //   255	257	254	finally
      }
    }
    
    final class RightDurationObserver
      extends Subscriber<D2>
    {
      final int id;
      boolean once = true;
      
      public RightDurationObserver(int paramInt)
      {
        this.id = paramInt;
      }
      
      public void onCompleted()
      {
        if (this.once) {
          this.once = false;
        }
        synchronized (OnSubscribeGroupJoin.ResultManager.this.guard)
        {
          OnSubscribeGroupJoin.ResultManager.this.rightMap.remove(Integer.valueOf(this.id));
          OnSubscribeGroupJoin.ResultManager.this.group.remove(this);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorMain(paramThrowable);
      }
      
      public void onNext(D2 paramD2)
      {
        onCompleted();
      }
    }
    
    final class RightObserver
      extends Subscriber<T2>
    {
      RightObserver() {}
      
      public void onCompleted()
      {
        ArrayList localArrayList = null;
        synchronized (OnSubscribeGroupJoin.ResultManager.this.guard)
        {
          OnSubscribeGroupJoin.ResultManager.this.rightDone = true;
          if (OnSubscribeGroupJoin.ResultManager.this.leftDone)
          {
            localArrayList = new ArrayList(OnSubscribeGroupJoin.ResultManager.this.leftMap.values());
            OnSubscribeGroupJoin.ResultManager.this.leftMap.clear();
            OnSubscribeGroupJoin.ResultManager.this.rightMap.clear();
          }
          OnSubscribeGroupJoin.ResultManager.this.complete(localArrayList);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        OnSubscribeGroupJoin.ResultManager.this.errorAll(paramThrowable);
      }
      
      /* Error */
      public void onNext(T2 paramT2)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   4: getfield 26	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:guard	Ljava/lang/Object;
        //   7: astore_3
        //   8: aload_3
        //   9: monitorenter
        //   10: aload_0
        //   11: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   14: astore 4
        //   16: aload 4
        //   18: getfield 71	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:rightIds	I
        //   21: istore_2
        //   22: aload 4
        //   24: iload_2
        //   25: iconst_1
        //   26: iadd
        //   27: putfield 71	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:rightIds	I
        //   30: aload_0
        //   31: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   34: getfield 54	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:rightMap	Ljava/util/Map;
        //   37: iload_2
        //   38: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   41: aload_1
        //   42: invokeinterface 81 3 0
        //   47: pop
        //   48: aload_3
        //   49: monitorexit
        //   50: aload_0
        //   51: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   54: getfield 85	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:this$0	Lrx/internal/operators/OnSubscribeGroupJoin;
        //   57: getfield 89	rx/internal/operators/OnSubscribeGroupJoin:rightDuration	Lrx/functions/Func1;
        //   60: aload_1
        //   61: invokeinterface 95 2 0
        //   66: checkcast 97	rx/Observable
        //   69: astore_3
        //   70: new 99	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightDurationObserver
        //   73: dup
        //   74: aload_0
        //   75: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   78: iload_2
        //   79: invokespecial 102	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightDurationObserver:<init>	(Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;I)V
        //   82: astore 4
        //   84: aload_0
        //   85: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   88: getfield 106	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:group	Lrx/subscriptions/CompositeSubscription;
        //   91: aload 4
        //   93: invokevirtual 112	rx/subscriptions/CompositeSubscription:add	(Lrx/Subscription;)V
        //   96: aload_3
        //   97: aload 4
        //   99: invokevirtual 116	rx/Observable:unsafeSubscribe	(Lrx/Subscriber;)Lrx/Subscription;
        //   102: pop
        //   103: aload_0
        //   104: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   107: getfield 26	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:guard	Ljava/lang/Object;
        //   110: astore_3
        //   111: aload_3
        //   112: monitorenter
        //   113: new 35	java/util/ArrayList
        //   116: dup
        //   117: aload_0
        //   118: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$RightObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
        //   121: getfield 39	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftMap	Ljava/util/Map;
        //   124: invokeinterface 45 1 0
        //   129: invokespecial 48	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
        //   132: astore 4
        //   134: aload_3
        //   135: monitorexit
        //   136: aload 4
        //   138: invokeinterface 122 1 0
        //   143: astore_3
        //   144: aload_3
        //   145: invokeinterface 128 1 0
        //   150: ifeq +27 -> 177
        //   153: aload_3
        //   154: invokeinterface 132 1 0
        //   159: checkcast 134	rx/Observer
        //   162: aload_1
        //   163: invokeinterface 136 2 0
        //   168: goto -24 -> 144
        //   171: astore_1
        //   172: aload_1
        //   173: aload_0
        //   174: invokestatic 142	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
        //   177: return
        //   178: astore_1
        //   179: aload_3
        //   180: monitorexit
        //   181: aload_1
        //   182: athrow
        //   183: astore_1
        //   184: aload_3
        //   185: monitorexit
        //   186: aload_1
        //   187: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	188	0	this	RightObserver
        //   0	188	1	paramT2	T2
        //   21	58	2	i	int
        //   14	123	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   0	10	171	java/lang/Throwable
        //   50	113	171	java/lang/Throwable
        //   136	144	171	java/lang/Throwable
        //   144	168	171	java/lang/Throwable
        //   181	183	171	java/lang/Throwable
        //   186	188	171	java/lang/Throwable
        //   10	50	178	finally
        //   179	181	178	finally
        //   113	136	183	finally
        //   184	186	183	finally
      }
    }
  }
  
  static final class WindowObservableFunc<T>
    implements Observable.OnSubscribe<T>
  {
    final RefCountSubscription refCount;
    final Observable<T> underlying;
    
    public WindowObservableFunc(Observable<T> paramObservable, RefCountSubscription paramRefCountSubscription)
    {
      this.refCount = paramRefCountSubscription;
      this.underlying = paramObservable;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      Subscription localSubscription = this.refCount.get();
      paramSubscriber = new WindowSubscriber(paramSubscriber, localSubscription);
      paramSubscriber.add(localSubscription);
      this.underlying.unsafeSubscribe(paramSubscriber);
    }
    
    final class WindowSubscriber
      extends Subscriber<T>
    {
      private final Subscription ref;
      final Subscriber<? super T> subscriber;
      
      public WindowSubscriber(Subscription paramSubscription)
      {
        super();
        this.subscriber = paramSubscription;
        Object localObject;
        this.ref = localObject;
      }
      
      public void onCompleted()
      {
        this.subscriber.onCompleted();
        this.ref.unsubscribe();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.subscriber.onError(paramThrowable);
        this.ref.unsubscribe();
      }
      
      public void onNext(T paramT)
      {
        this.subscriber.onNext(paramT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin
 * JD-Core Version:    0.7.0.1
 */