package com.tencent.wcdb.support;

final class CancellationSignal$Transport
  extends ICancellationSignal.Stub
{
  final CancellationSignal mCancellationSignal = new CancellationSignal();
  
  public void cancel()
  {
    this.mCancellationSignal.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.CancellationSignal.Transport
 * JD-Core Version:    0.7.0.1
 */