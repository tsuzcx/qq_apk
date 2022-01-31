package android.arch.lifecycle;

class LiveData$AlwaysActiveObserver
  extends LiveData.ObserverWrapper
{
  LiveData$AlwaysActiveObserver(LiveData paramLiveData, Observer paramObserver)
  {
    super(paramLiveData, paramObserver);
  }
  
  boolean shouldBeActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData.AlwaysActiveObserver
 * JD-Core Version:    0.7.0.1
 */