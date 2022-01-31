import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class ufz
  implements slx<szx, szy>
{
  ufz(ufy paramufy, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull szx paramszx, @Nullable szy paramszy, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramszy == null))
    {
      urk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      ufy.a(this.jdField_a_of_type_Ufy, paramErrorMessage);
      return;
    }
    ufy.a(this.jdField_a_of_type_Ufy).a(paramszy.jdField_a_of_type_JavaUtilList, paramszy.jdField_a_of_type_JavaLangString, paramszy.jdField_a_of_type_Boolean);
    ((uje)sqg.a(11)).a(paramszy.jdField_a_of_type_JavaUtilList);
    paramszx = ufy.a(this.jdField_a_of_type_Ufy).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    ufy.a(this.jdField_a_of_type_Ufy, paramszx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufz
 * JD-Core Version:    0.7.0.1
 */