import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class xkk
  implements vqp<weo, wep>
{
  xkk(xkj paramxkj, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull weo paramweo, @Nullable wep paramwep, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwep == null))
    {
      xvv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      xkj.a(this.jdField_a_of_type_Xkj, paramErrorMessage);
      return;
    }
    xkj.a(this.jdField_a_of_type_Xkj).a(paramwep.jdField_a_of_type_JavaUtilList, paramwep.jdField_a_of_type_JavaLangString, paramwep.jdField_a_of_type_Boolean);
    ((xnp)vux.a(11)).a(paramwep.jdField_a_of_type_JavaUtilList);
    paramweo = xkj.a(this.jdField_a_of_type_Xkj).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    xkj.a(this.jdField_a_of_type_Xkj, paramweo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkk
 * JD-Core Version:    0.7.0.1
 */