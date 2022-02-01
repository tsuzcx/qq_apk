import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class vlf
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  vlf(vle paramvle, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    vli.a().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlf
 * JD-Core Version:    0.7.0.1
 */