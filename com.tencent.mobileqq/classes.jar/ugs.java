import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class ugs
  implements slx<szz, taa>
{
  ugs(ugr paramugr, boolean paramBoolean) {}
  
  public void a(@NonNull szz paramszz, @Nullable taa arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (ugr.a(this.jdField_a_of_type_Ugr).get())
    {
      urk.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    urk.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramszz = new ugu(this.jdField_a_of_type_Ugr, paramErrorMessage);
    paramszz.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      sgi.a().dispatch(paramszz);
      return;
    }
    paramszz.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((spt)sqg.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Ugr)
    {
      sgi.a().dispatch(paramszz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugs
 * JD-Core Version:    0.7.0.1
 */