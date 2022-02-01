package rx;

class Single$19
  implements Single.OnSubscribe<T>
{
  Single$19(Single paramSingle, Scheduler paramScheduler) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    Scheduler.Worker localWorker = this.val$scheduler.createWorker();
    paramSingleSubscriber.add(localWorker);
    localWorker.schedule(new Single.19.1(this, paramSingleSubscriber, localWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.19
 * JD-Core Version:    0.7.0.1
 */