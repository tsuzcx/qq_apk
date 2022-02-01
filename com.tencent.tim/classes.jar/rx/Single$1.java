package rx;

import rx.internal.producers.SingleDelayedProducer;

class Single$1
  implements Observable.OnSubscribe<T>
{
  Single$1(Single paramSingle, Single.OnSubscribe paramOnSubscribe) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = new SingleDelayedProducer(paramSubscriber);
    paramSubscriber.setProducer((Producer)localObject);
    localObject = new Single.1.1(this, (SingleDelayedProducer)localObject, paramSubscriber);
    paramSubscriber.add((Subscription)localObject);
    this.val$f.call(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.1
 * JD-Core Version:    0.7.0.1
 */