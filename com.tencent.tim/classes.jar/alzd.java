public abstract interface alzd
{
  public abstract void fp(long paramLong)
    throws InterruptedException;
  
  public abstract void onDecodeCancel();
  
  public abstract void onDecodeError(int paramInt, Throwable paramThrowable);
  
  public abstract void onDecodeFinish();
  
  public abstract void onDecodeRepeat();
  
  public abstract void onDecodeSeekTo(long paramLong);
  
  public abstract void onDecodeStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzd
 * JD-Core Version:    0.7.0.1
 */