package retrofit;

import rx.Observable;

public abstract interface RxHandler
{
  public abstract Observable onBefore(Observable paramObservable);
  
  public abstract Observable onRetry(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RxHandler
 * JD-Core Version:    0.7.0.1
 */