package rx;

final class Single$3
  implements Single.OnSubscribe<T>
{
  Single$3(Throwable paramThrowable) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    paramSingleSubscriber.onError(this.val$exception);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.3
 * JD-Core Version:    0.7.0.1
 */