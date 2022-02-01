package rx;

final class Single$5
  implements Single.OnSubscribe<T>
{
  Single$5(Single paramSingle) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    this.val$source.subscribe(new Single.5.1(this, paramSingleSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.5
 * JD-Core Version:    0.7.0.1
 */