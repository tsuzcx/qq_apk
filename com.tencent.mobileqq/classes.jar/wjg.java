import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class wjg
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  wjg(wjf paramwjf, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    wjj.a().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjg
 * JD-Core Version:    0.7.0.1
 */