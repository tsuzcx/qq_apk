import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class zjy
  implements wld<wzr, wzs>
{
  zjy(zjx paramzjx, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull wzr paramwzr, @Nullable wzs paramwzs, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwzs == null))
    {
      yqp.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      zjx.a(this.jdField_a_of_type_Zjx, paramErrorMessage);
      return;
    }
    zjx.a(this.jdField_a_of_type_Zjx).a(paramwzs.jdField_a_of_type_JavaUtilList, paramwzs.jdField_a_of_type_JavaLangString, paramwzs.jdField_a_of_type_Boolean);
    ((yij)wpm.a(11)).a(paramwzs.jdField_a_of_type_JavaUtilList);
    paramwzr = zjx.a(this.jdField_a_of_type_Zjx).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    zjx.a(this.jdField_a_of_type_Zjx, paramwzr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjy
 * JD-Core Version:    0.7.0.1
 */