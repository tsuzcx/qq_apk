import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class waa
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  waa(vzz paramvzz, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    wad.a().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waa
 * JD-Core Version:    0.7.0.1
 */