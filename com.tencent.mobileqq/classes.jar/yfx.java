import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class yfx
  implements wld<wzf, wzg>
{
  yfx(yfw paramyfw, boolean paramBoolean) {}
  
  public void a(@NonNull wzf paramwzf, @Nullable wzg arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (yfw.a(this.jdField_a_of_type_Yfw).get())
    {
      yqp.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    yqp.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramwzf = new yfz(this.jdField_a_of_type_Yfw, paramErrorMessage);
    paramwzf.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      wfo.a().dispatch(paramwzf);
      return;
    }
    paramwzf.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((woz)wpm.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Yfw)
    {
      wfo.a().dispatch(paramwzf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfx
 * JD-Core Version:    0.7.0.1
 */