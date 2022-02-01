import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class zdi
  implements wfk<wtx, wty>
{
  zdi(zdh paramzdh, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull wtx paramwtx, @Nullable wty paramwty, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwty == null))
    {
      ykq.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      zdh.a(this.jdField_a_of_type_Zdh, paramErrorMessage);
      return;
    }
    zdh.a(this.jdField_a_of_type_Zdh).a(paramwty.jdField_a_of_type_JavaUtilList, paramwty.jdField_a_of_type_JavaLangString, paramwty.jdField_a_of_type_Boolean);
    ((yck)wjs.a(11)).a(paramwty.jdField_a_of_type_JavaUtilList);
    paramwtx = zdh.a(this.jdField_a_of_type_Zdh).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    zdh.a(this.jdField_a_of_type_Zdh, paramwtx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdi
 * JD-Core Version:    0.7.0.1
 */