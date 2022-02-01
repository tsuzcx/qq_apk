import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class xhk
  implements vqp<xhm, xhn>
{
  xhk(xhj paramxhj, boolean paramBoolean) {}
  
  public void a(@NonNull xhm paramxhm, @Nullable xhn arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxhm = new xhl(paramErrorMessage, xhj.a(this.jdField_a_of_type_Xhj));
    paramxhm.jdField_b_of_type_Boolean = false;
    paramxhm.jdField_a_of_type_Boolean = xhj.a(this.jdField_a_of_type_Xhj);
    paramxhm.jdField_a_of_type_Int = xhj.a(this.jdField_a_of_type_Xhj);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      vli.a().dispatch(paramxhm);
      return;
    }
    paramxhm.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramxhm.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramxhm.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramxhm.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((vuj)vux.a(15)).a(paramxhm.jdField_a_of_type_JavaUtilList, xhj.a(this.jdField_a_of_type_Xhj), xhj.c(this.jdField_a_of_type_Xhj), true);
    synchronized (this.jdField_a_of_type_Xhj)
    {
      xhj.a(this.jdField_a_of_type_Xhj, true);
      vli.a().dispatch(paramxhm);
      xvv.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramxhm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhk
 * JD-Core Version:    0.7.0.1
 */