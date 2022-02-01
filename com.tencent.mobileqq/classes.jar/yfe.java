import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class yfe
  implements wld<wzd, wze>
{
  yfe(yfd paramyfd, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull wzd paramwzd, @Nullable wze paramwze, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwze == null))
    {
      yqp.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      yfd.a(this.jdField_a_of_type_Yfd, paramErrorMessage);
      return;
    }
    yfd.a(this.jdField_a_of_type_Yfd).a(paramwze.jdField_a_of_type_JavaUtilList, paramwze.jdField_a_of_type_JavaLangString, paramwze.jdField_a_of_type_Boolean);
    ((yij)wpm.a(11)).a(paramwze.jdField_a_of_type_JavaUtilList);
    paramwzd = yfd.a(this.jdField_a_of_type_Yfd).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    yfd.a(this.jdField_a_of_type_Yfd, paramwzd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfe
 * JD-Core Version:    0.7.0.1
 */