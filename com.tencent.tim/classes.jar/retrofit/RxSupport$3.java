package retrofit;

import rx.Subscriber;

class RxSupport$3
  implements Runnable
{
  RxSupport$3(RxSupport paramRxSupport, Subscriber paramSubscriber, RxSupport.Invoker paramInvoker, RequestInterceptorTape paramRequestInterceptorTape) {}
  
  public void run()
  {
    try
    {
      if (this.val$subscriber.isUnsubscribed()) {
        return;
      }
      ResponseWrapper localResponseWrapper = this.val$invoker.invoke(this.val$interceptorTape);
      this.val$subscriber.onNext(localResponseWrapper.responseBody);
      this.val$subscriber.onCompleted();
      return;
    }
    catch (RetrofitError localRetrofitError)
    {
      this.val$subscriber.onError(RxSupport.access$600(this.this$0).handleError(localRetrofitError));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RxSupport.3
 * JD-Core Version:    0.7.0.1
 */