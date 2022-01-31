import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class vkt
  implements slx<tal, tam>
{
  vkt(vks paramvks, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull tal paramtal, @Nullable tam paramtam, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtam == null))
    {
      urk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      vks.a(this.jdField_a_of_type_Vks, paramErrorMessage);
      return;
    }
    vks.a(this.jdField_a_of_type_Vks).a(paramtam.jdField_a_of_type_JavaUtilList, paramtam.jdField_a_of_type_JavaLangString, paramtam.jdField_a_of_type_Boolean);
    ((uje)sqg.a(11)).a(paramtam.jdField_a_of_type_JavaUtilList);
    paramtal = vks.a(this.jdField_a_of_type_Vks).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    vks.a(this.jdField_a_of_type_Vks, paramtal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */