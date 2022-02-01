package rx.internal.operators;

import rx.Producer;

class OperatorMaterialize$1
  implements Producer
{
  OperatorMaterialize$1(OperatorMaterialize paramOperatorMaterialize, OperatorMaterialize.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    if (paramLong > 0L) {
      this.val$parent.requestMore(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorMaterialize.1
 * JD-Core Version:    0.7.0.1
 */