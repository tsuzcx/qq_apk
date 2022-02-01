package androidx.lifecycle;

import java.util.concurrent.Executor;

class ComputableLiveData$1
  extends LiveData<T>
{
  ComputableLiveData$1(ComputableLiveData paramComputableLiveData) {}
  
  protected void onActive()
  {
    this.this$0.mExecutor.execute(this.this$0.mRefreshRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.ComputableLiveData.1
 * JD-Core Version:    0.7.0.1
 */