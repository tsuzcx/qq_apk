import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class wit
  implements urr<wiv, wiw>
{
  wit(wis paramwis, boolean paramBoolean) {}
  
  public void a(@NonNull wiv paramwiv, @Nullable wiw arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwiv = new wiu(paramErrorMessage, wis.a(this.jdField_a_of_type_Wis));
    paramwiv.jdField_b_of_type_Boolean = false;
    paramwiv.jdField_a_of_type_Boolean = wis.a(this.jdField_a_of_type_Wis);
    paramwiv.jdField_a_of_type_Int = wis.a(this.jdField_a_of_type_Wis);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      umc.a().dispatch(paramwiv);
      return;
    }
    paramwiv.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramwiv.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramwiv.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramwiv.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((uvm)uwa.a(15)).a(paramwiv.jdField_a_of_type_JavaUtilList, wis.a(this.jdField_a_of_type_Wis), wis.c(this.jdField_a_of_type_Wis), true);
    synchronized (this.jdField_a_of_type_Wis)
    {
      wis.a(this.jdField_a_of_type_Wis, true);
      umc.a().dispatch(paramwiv);
      wxe.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramwiv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wit
 * JD-Core Version:    0.7.0.1
 */