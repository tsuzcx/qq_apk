import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class xld
  implements vqp<weq, wer>
{
  xld(xlc paramxlc, boolean paramBoolean) {}
  
  public void a(@NonNull weq paramweq, @Nullable wer arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (xlc.a(this.jdField_a_of_type_Xlc).get())
    {
      xvv.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    xvv.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramweq = new xlf(this.jdField_a_of_type_Xlc, paramErrorMessage);
    paramweq.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      vli.a().dispatch(paramweq);
      return;
    }
    paramweq.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((vuk)vux.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Xlc)
    {
      vli.a().dispatch(paramweq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */