import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class uto
  implements syt<tmv, tmw>
{
  uto(utn paramutn, boolean paramBoolean) {}
  
  public void a(@NonNull tmv paramtmv, @Nullable tmw arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (utn.a(this.jdField_a_of_type_Utn).get())
    {
      veg.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    veg.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramtmv = new utq(this.jdField_a_of_type_Utn, paramErrorMessage);
    paramtmv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      ste.a().dispatch(paramtmv);
      return;
    }
    paramtmv.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((tcp)tdc.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Utn)
    {
      ste.a().dispatch(paramtmv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uto
 * JD-Core Version:    0.7.0.1
 */