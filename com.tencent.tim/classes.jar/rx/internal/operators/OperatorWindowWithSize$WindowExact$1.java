package rx.internal.operators;

import rx.Producer;

class OperatorWindowWithSize$WindowExact$1
  implements Producer
{
  OperatorWindowWithSize$WindowExact$1(OperatorWindowWithSize.WindowExact paramWindowExact) {}
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    if (paramLong != 0L)
    {
      paramLong = BackpressureUtils.multiplyCap(this.this$0.size, paramLong);
      OperatorWindowWithSize.WindowExact.access$000(this.this$0, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowExact.1
 * JD-Core Version:    0.7.0.1
 */