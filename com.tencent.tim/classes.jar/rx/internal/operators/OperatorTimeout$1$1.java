package rx.internal.operators;

import rx.functions.Action0;

class OperatorTimeout$1$1
  implements Action0
{
  OperatorTimeout$1$1(OperatorTimeout.1 param1, OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber, Long paramLong) {}
  
  public void call()
  {
    this.val$timeoutSubscriber.onTimeout(this.val$seqId.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeout.1.1
 * JD-Core Version:    0.7.0.1
 */