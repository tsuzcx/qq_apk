import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class wid
  implements uni<vbk, vbl>
{
  wid(wic paramwic, boolean paramBoolean) {}
  
  public void a(@NonNull vbk paramvbk, @Nullable vbl arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (wic.a(this.jdField_a_of_type_Wic).get())
    {
      wsv.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    wsv.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramvbk = new wif(this.jdField_a_of_type_Wic, paramErrorMessage);
    paramvbk.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      uht.a().dispatch(paramvbk);
      return;
    }
    paramvbk.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((ure)urr.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Wic)
    {
      uht.a().dispatch(paramvbk);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wid
 * JD-Core Version:    0.7.0.1
 */