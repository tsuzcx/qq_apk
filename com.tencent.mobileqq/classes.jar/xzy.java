import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class xzy
  implements wfk<wtl, wtm>
{
  xzy(xzx paramxzx, boolean paramBoolean) {}
  
  public void a(@NonNull wtl paramwtl, @Nullable wtm arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (xzx.a(this.jdField_a_of_type_Xzx).get())
    {
      ykq.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    ykq.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramwtl = new yaa(this.jdField_a_of_type_Xzx, paramErrorMessage);
    paramwtl.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      wad.a().dispatch(paramwtl);
      return;
    }
    paramwtl.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((wjf)wjs.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Xzx)
    {
      wad.a().dispatch(paramwtl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzy
 * JD-Core Version:    0.7.0.1
 */