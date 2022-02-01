import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class yfz
  implements woy<ygb, ygc>
{
  yfz(yfy paramyfy, boolean paramBoolean) {}
  
  public void a(@NonNull ygb paramygb, @Nullable ygc arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramygb = new yga(paramErrorMessage, yfy.a(this.jdField_a_of_type_Yfy));
    paramygb.jdField_b_of_type_Boolean = false;
    paramygb.jdField_a_of_type_Boolean = yfy.a(this.jdField_a_of_type_Yfy);
    paramygb.jdField_a_of_type_Int = yfy.a(this.jdField_a_of_type_Yfy);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      wjj.a().dispatch(paramygb);
      return;
    }
    paramygb.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramygb.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramygb.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramygb.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((wst)wth.a(15)).a(paramygb.jdField_a_of_type_JavaUtilList, yfy.a(this.jdField_a_of_type_Yfy), yfy.c(this.jdField_a_of_type_Yfy), true);
    synchronized (this.jdField_a_of_type_Yfy)
    {
      yfy.a(this.jdField_a_of_type_Yfy, true);
      wjj.a().dispatch(paramygb);
      yuk.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramygb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfz
 * JD-Core Version:    0.7.0.1
 */