package rx.internal.operators;

import rx.SingleSubscriber;

class SingleOnSubscribeUsing$1
  extends SingleSubscriber<T>
{
  SingleOnSubscribeUsing$1(SingleOnSubscribeUsing paramSingleOnSubscribeUsing, Object paramObject, SingleSubscriber paramSingleSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.this$0.handleSubscriptionTimeError(this.val$child, this.val$resource, paramThrowable);
  }
  
  /* Error */
  public void onSuccess(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	rx/internal/operators/SingleOnSubscribeUsing$1:this$0	Lrx/internal/operators/SingleOnSubscribeUsing;
    //   4: getfield 39	rx/internal/operators/SingleOnSubscribeUsing:disposeEagerly	Z
    //   7: ifeq +19 -> 26
    //   10: aload_0
    //   11: getfield 15	rx/internal/operators/SingleOnSubscribeUsing$1:this$0	Lrx/internal/operators/SingleOnSubscribeUsing;
    //   14: getfield 43	rx/internal/operators/SingleOnSubscribeUsing:disposeAction	Lrx/functions/Action1;
    //   17: aload_0
    //   18: getfield 17	rx/internal/operators/SingleOnSubscribeUsing$1:val$resource	Ljava/lang/Object;
    //   21: invokeinterface 48 2 0
    //   26: aload_0
    //   27: getfield 19	rx/internal/operators/SingleOnSubscribeUsing$1:val$child	Lrx/SingleSubscriber;
    //   30: aload_1
    //   31: invokevirtual 50	rx/SingleSubscriber:onSuccess	(Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 15	rx/internal/operators/SingleOnSubscribeUsing$1:this$0	Lrx/internal/operators/SingleOnSubscribeUsing;
    //   38: getfield 39	rx/internal/operators/SingleOnSubscribeUsing:disposeEagerly	Z
    //   41: ifne +19 -> 60
    //   44: aload_0
    //   45: getfield 15	rx/internal/operators/SingleOnSubscribeUsing$1:this$0	Lrx/internal/operators/SingleOnSubscribeUsing;
    //   48: getfield 43	rx/internal/operators/SingleOnSubscribeUsing:disposeAction	Lrx/functions/Action1;
    //   51: aload_0
    //   52: getfield 17	rx/internal/operators/SingleOnSubscribeUsing$1:val$resource	Ljava/lang/Object;
    //   55: invokeinterface 48 2 0
    //   60: return
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 55	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   66: aload_0
    //   67: getfield 19	rx/internal/operators/SingleOnSubscribeUsing$1:val$child	Lrx/SingleSubscriber;
    //   70: aload_1
    //   71: invokevirtual 57	rx/SingleSubscriber:onError	(Ljava/lang/Throwable;)V
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: invokestatic 55	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   80: invokestatic 63	rx/plugins/RxJavaPlugins:getInstance	()Lrx/plugins/RxJavaPlugins;
    //   83: invokevirtual 67	rx/plugins/RxJavaPlugins:getErrorHandler	()Lrx/plugins/RxJavaErrorHandler;
    //   86: aload_1
    //   87: invokevirtual 72	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   90: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	1
    //   0	91	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   10	26	61	java/lang/Throwable
    //   44	60	75	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.SingleOnSubscribeUsing.1
 * JD-Core Version:    0.7.0.1
 */