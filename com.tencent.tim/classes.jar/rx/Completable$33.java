package rx;

class Completable$33
  implements Completable.CompletableOnSubscribe
{
  Completable$33(Completable paramCompletable, Scheduler paramScheduler) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    this.this$0.subscribe(new Completable.33.1(this, paramCompletableSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.33
 * JD-Core Version:    0.7.0.1
 */