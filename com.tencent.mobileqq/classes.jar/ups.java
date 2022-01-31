import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class ups
  implements syq<upu, upv>
{
  ups(upr paramupr, boolean paramBoolean) {}
  
  public void a(@NonNull upu paramupu, @Nullable upv arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramupu = new upt(paramErrorMessage, upr.a(this.jdField_a_of_type_Upr));
    paramupu.jdField_b_of_type_Boolean = false;
    paramupu.jdField_a_of_type_Boolean = upr.a(this.jdField_a_of_type_Upr);
    paramupu.jdField_a_of_type_Int = upr.a(this.jdField_a_of_type_Upr);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      stb.a().dispatch(paramupu);
      return;
    }
    paramupu.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramupu.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramupu.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramupu.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((tcl)tcz.a(15)).a(paramupu.jdField_a_of_type_JavaUtilList, upr.a(this.jdField_a_of_type_Upr), upr.c(this.jdField_a_of_type_Upr), true);
    synchronized (this.jdField_a_of_type_Upr)
    {
      upr.a(this.jdField_a_of_type_Upr, true);
      stb.a().dispatch(paramupu);
      ved.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramupu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ups
 * JD-Core Version:    0.7.0.1
 */