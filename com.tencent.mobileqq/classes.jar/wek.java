import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class wek
  implements uni<wem, wen>
{
  wek(wej paramwej, boolean paramBoolean) {}
  
  public void a(@NonNull wem paramwem, @Nullable wen arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwem = new wel(paramErrorMessage, wej.a(this.jdField_a_of_type_Wej));
    paramwem.jdField_b_of_type_Boolean = false;
    paramwem.jdField_a_of_type_Boolean = wej.a(this.jdField_a_of_type_Wej);
    paramwem.jdField_a_of_type_Int = wej.a(this.jdField_a_of_type_Wej);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      uht.a().dispatch(paramwem);
      return;
    }
    paramwem.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramwem.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramwem.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramwem.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((urd)urr.a(15)).a(paramwem.jdField_a_of_type_JavaUtilList, wej.a(this.jdField_a_of_type_Wej), wej.c(this.jdField_a_of_type_Wej), true);
    synchronized (this.jdField_a_of_type_Wej)
    {
      wej.a(this.jdField_a_of_type_Wej, true);
      uht.a().dispatch(paramwem);
      wsv.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramwem);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wek
 * JD-Core Version:    0.7.0.1
 */