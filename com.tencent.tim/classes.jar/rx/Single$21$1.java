package rx;

class Single$21$1
  extends Subscriber<T>
{
  Single$21$1(Single.21 param21, Subscriber paramSubscriber1, boolean paramBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1, paramBoolean);
  }
  
  public void onCompleted()
  {
    try
    {
      this.val$serial.onCompleted();
      return;
    }
    finally
    {
      this.val$serial.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.val$serial.onError(paramThrowable);
      return;
    }
    finally
    {
      this.val$serial.unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    this.val$serial.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.21.1
 * JD-Core Version:    0.7.0.1
 */