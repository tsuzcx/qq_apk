package rx.schedulers;

class CachedThreadScheduler$CachedWorkerPool$1
  implements Runnable
{
  CachedThreadScheduler$CachedWorkerPool$1(CachedThreadScheduler.CachedWorkerPool paramCachedWorkerPool) {}
  
  public void run()
  {
    this.this$0.evictExpiredWorkers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.CachedWorkerPool.1
 * JD-Core Version:    0.7.0.1
 */