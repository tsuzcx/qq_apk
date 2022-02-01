import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class xzf
  implements wfk<wtj, wtk>
{
  xzf(xze paramxze, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull wtj paramwtj, @Nullable wtk paramwtk, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwtk == null))
    {
      ykq.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      xze.a(this.jdField_a_of_type_Xze, paramErrorMessage);
      return;
    }
    xze.a(this.jdField_a_of_type_Xze).a(paramwtk.jdField_a_of_type_JavaUtilList, paramwtk.jdField_a_of_type_JavaLangString, paramwtk.jdField_a_of_type_Boolean);
    ((yck)wjs.a(11)).a(paramwtk.jdField_a_of_type_JavaUtilList);
    paramwtj = xze.a(this.jdField_a_of_type_Xze).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    xze.a(this.jdField_a_of_type_Xze, paramwtj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzf
 * JD-Core Version:    0.7.0.1
 */