import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class utl
  implements syq<tms, tmt>
{
  utl(utk paramutk, boolean paramBoolean) {}
  
  public void a(@NonNull tms paramtms, @Nullable tmt arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (utk.a(this.jdField_a_of_type_Utk).get())
    {
      ved.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    ved.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramtms = new utn(this.jdField_a_of_type_Utk, paramErrorMessage);
    paramtms.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      stb.a().dispatch(paramtms);
      return;
    }
    paramtms.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((tcm)tcz.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_Utk)
    {
      stb.a().dispatch(paramtms);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utl
 * JD-Core Version:    0.7.0.1
 */