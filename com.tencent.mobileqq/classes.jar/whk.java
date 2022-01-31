import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class whk
  implements uni<vbi, vbj>
{
  whk(whj paramwhj, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull vbi paramvbi, @Nullable vbj paramvbj, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvbj == null))
    {
      wsv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      whj.a(this.jdField_a_of_type_Whj, paramErrorMessage);
      return;
    }
    whj.a(this.jdField_a_of_type_Whj).a(paramvbj.jdField_a_of_type_JavaUtilList, paramvbj.jdField_a_of_type_JavaLangString, paramvbj.jdField_a_of_type_Boolean);
    ((wkp)urr.a(11)).a(paramvbj.jdField_a_of_type_JavaUtilList);
    paramvbi = whj.a(this.jdField_a_of_type_Whj).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    whj.a(this.jdField_a_of_type_Whj, paramvbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whk
 * JD-Core Version:    0.7.0.1
 */