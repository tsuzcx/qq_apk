import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class xwf
  implements wfk<xwh, xwi>
{
  xwf(xwe paramxwe, boolean paramBoolean) {}
  
  public void a(@NonNull xwh paramxwh, @Nullable xwi arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxwh = new xwg(paramErrorMessage, xwe.a(this.jdField_a_of_type_Xwe));
    paramxwh.jdField_b_of_type_Boolean = false;
    paramxwh.jdField_a_of_type_Boolean = xwe.a(this.jdField_a_of_type_Xwe);
    paramxwh.jdField_a_of_type_Int = xwe.a(this.jdField_a_of_type_Xwe);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      wad.a().dispatch(paramxwh);
      return;
    }
    paramxwh.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramxwh.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramxwh.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramxwh.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((wje)wjs.a(15)).a(paramxwh.jdField_a_of_type_JavaUtilList, xwe.a(this.jdField_a_of_type_Xwe), xwe.c(this.jdField_a_of_type_Xwe), true);
    synchronized (this.jdField_a_of_type_Xwe)
    {
      xwe.a(this.jdField_a_of_type_Xwe, true);
      wad.a().dispatch(paramxwh);
      ykq.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramxwh);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwf
 * JD-Core Version:    0.7.0.1
 */