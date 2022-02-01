import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class yjs
  implements woy<xda, xdb>
{
  yjs(yjr paramyjr, boolean paramBoolean) {}
  
  public void a(@NonNull xda paramxda, @Nullable xdb arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (yjr.a(this.jdField_a_of_type_Yjr).get())
    {
      yuk.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    yuk.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramxda = new yju(this.jdField_a_of_type_Yjr, paramErrorMessage);
    paramxda.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      wjj.a().dispatch(paramxda);
      return;
    }
    paramxda.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((wsu)wth.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Yjr)
    {
      wjj.a().dispatch(paramxda);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjs
 * JD-Core Version:    0.7.0.1
 */