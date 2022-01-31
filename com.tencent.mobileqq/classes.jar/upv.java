import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class upv
  implements syt<upx, upy>
{
  upv(upu paramupu, boolean paramBoolean) {}
  
  public void a(@NonNull upx paramupx, @Nullable upy arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramupx = new upw(paramErrorMessage, upu.a(this.jdField_a_of_type_Upu));
    paramupx.jdField_b_of_type_Boolean = false;
    paramupx.jdField_a_of_type_Boolean = upu.a(this.jdField_a_of_type_Upu);
    paramupx.jdField_a_of_type_Int = upu.a(this.jdField_a_of_type_Upu);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      ste.a().dispatch(paramupx);
      return;
    }
    paramupx.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramupx.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramupx.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramupx.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((tco)tdc.a(15)).a(paramupx.jdField_a_of_type_JavaUtilList, upu.a(this.jdField_a_of_type_Upu), upu.c(this.jdField_a_of_type_Upu), true);
    synchronized (this.jdField_a_of_type_Upu)
    {
      upu.a(this.jdField_a_of_type_Upu, true);
      ste.a().dispatch(paramupx);
      veg.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramupx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upv
 * JD-Core Version:    0.7.0.1
 */