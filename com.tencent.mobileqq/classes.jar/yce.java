import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class yce
  implements wld<ycg, ych>
{
  yce(ycd paramycd, boolean paramBoolean) {}
  
  public void a(@NonNull ycg paramycg, @Nullable ych arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramycg = new ycf(paramErrorMessage, ycd.a(this.jdField_a_of_type_Ycd));
    paramycg.jdField_b_of_type_Boolean = false;
    paramycg.jdField_a_of_type_Boolean = ycd.a(this.jdField_a_of_type_Ycd);
    paramycg.jdField_a_of_type_Int = ycd.a(this.jdField_a_of_type_Ycd);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      wfo.a().dispatch(paramycg);
      return;
    }
    paramycg.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramycg.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramycg.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramycg.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((woy)wpm.a(15)).a(paramycg.jdField_a_of_type_JavaUtilList, ycd.a(this.jdField_a_of_type_Ycd), ycd.c(this.jdField_a_of_type_Ycd), true);
    synchronized (this.jdField_a_of_type_Ycd)
    {
      ycd.a(this.jdField_a_of_type_Ycd, true);
      wfo.a().dispatch(paramycg);
      yqp.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramycg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yce
 * JD-Core Version:    0.7.0.1
 */