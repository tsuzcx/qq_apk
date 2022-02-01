package rx.internal.operators;

import rx.Producer;

class OperatorObserveOn$ObserveOnSubscriber$1
  implements Producer
{
  OperatorObserveOn$ObserveOnSubscriber$1(OperatorObserveOn.ObserveOnSubscriber paramObserveOnSubscriber) {}
  
  public void request(long paramLong)
  {
    if (paramLong > 0L)
    {
      BackpressureUtils.getAndAddRequest(this.this$0.requested, paramLong);
      this.this$0.schedule();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.1
 * JD-Core Version:    0.7.0.1
 */