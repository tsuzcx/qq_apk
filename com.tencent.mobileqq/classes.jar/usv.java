import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class usv
  implements syt<tmt, tmu>
{
  usv(usu paramusu, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull tmt paramtmt, @Nullable tmu paramtmu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtmu == null))
    {
      veg.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      usu.a(this.jdField_a_of_type_Usu, paramErrorMessage);
      return;
    }
    usu.a(this.jdField_a_of_type_Usu).a(paramtmu.jdField_a_of_type_JavaUtilList, paramtmu.jdField_a_of_type_JavaLangString, paramtmu.jdField_a_of_type_Boolean);
    ((uwa)tdc.a(11)).a(paramtmu.jdField_a_of_type_JavaUtilList);
    paramtmt = usu.a(this.jdField_a_of_type_Usu).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    usu.a(this.jdField_a_of_type_Usu, paramtmt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usv
 * JD-Core Version:    0.7.0.1
 */