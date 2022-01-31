import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class ucz
  implements slx<udb, udc>
{
  ucz(ucy paramucy, boolean paramBoolean) {}
  
  public void a(@NonNull udb paramudb, @Nullable udc arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramudb = new uda(paramErrorMessage, ucy.a(this.jdField_a_of_type_Ucy));
    paramudb.jdField_b_of_type_Boolean = false;
    paramudb.jdField_a_of_type_Boolean = ucy.a(this.jdField_a_of_type_Ucy);
    paramudb.jdField_a_of_type_Int = ucy.a(this.jdField_a_of_type_Ucy);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      sgi.a().dispatch(paramudb);
      return;
    }
    paramudb.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramudb.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramudb.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramudb.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((sps)sqg.a(15)).a(paramudb.jdField_a_of_type_JavaUtilList, ucy.a(this.jdField_a_of_type_Ucy), ucy.c(this.jdField_a_of_type_Ucy), true);
    synchronized (this.jdField_a_of_type_Ucy)
    {
      ucy.a(this.jdField_a_of_type_Ucy, true);
      sgi.a().dispatch(paramudb);
      urk.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramudb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucz
 * JD-Core Version:    0.7.0.1
 */