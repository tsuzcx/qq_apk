import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class pmg
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  pmg(pmf parampmf, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    pmi.a().dispatch(new JobController.DoneEvent(this.val$worker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmg
 * JD-Core Version:    0.7.0.1
 */