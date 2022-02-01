package androidx.lifecycle;

class LiveData$1
  implements Runnable
{
  LiveData$1(LiveData paramLiveData) {}
  
  public void run()
  {
    synchronized (this.this$0.mDataLock)
    {
      Object localObject2 = this.this$0.mPendingData;
      this.this$0.mPendingData = LiveData.NOT_SET;
      this.this$0.setValue(localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.LiveData.1
 * JD-Core Version:    0.7.0.1
 */