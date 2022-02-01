import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class yop
  implements vqp<wfc, wfd>
{
  yop(yoo paramyoo, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull wfc paramwfc, @Nullable wfd paramwfd, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwfd == null))
    {
      xvv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      yoo.a(this.jdField_a_of_type_Yoo, paramErrorMessage);
      return;
    }
    yoo.a(this.jdField_a_of_type_Yoo).a(paramwfd.jdField_a_of_type_JavaUtilList, paramwfd.jdField_a_of_type_JavaLangString, paramwfd.jdField_a_of_type_Boolean);
    ((xnp)vux.a(11)).a(paramwfd.jdField_a_of_type_JavaUtilList);
    paramwfc = yoo.a(this.jdField_a_of_type_Yoo).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    yoo.a(this.jdField_a_of_type_Yoo, paramwfc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yop
 * JD-Core Version:    0.7.0.1
 */